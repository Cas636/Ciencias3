package com.udistrital.lexer.reviewer;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.udistrital.lexer.stacks.Delimiters;
import com.udistrital.lexer.tokens.Developer;
import com.udistrital.lexer.tokens.Imports;
import com.udistrital.lexer.tokens.Keywords;
import com.udistrital.lexer.tokens.Operators;
import com.udistrital.lexer.tokens.Preprocessors;

public class Extractor {
    private Extractor() {}

    private static final Logger log = Logger.getGlobal();

    private static boolean containsInclude = false;
    private static boolean isTypeDefinition = false;
    private static String stringLiteral = "";
    private static boolean isLiteral = false;

    public static void verifyLine(String line) throws IOException {

        List<String> elements = new LinkedList<>(Arrays.asList(line.split(" ")));

        if(!elements.isEmpty()) {
            elements.removeIf(element -> element.isBlank() || element.isEmpty());
        }

        for(String element : elements) {
            verifyOperators(element);
            if(isLiteral || (!stringLiteral.isBlank() && !stringLiteral.isEmpty())) {
                stringLiteral += " " + element;
                
                if(!isLiteral) {
                    Developer.addLiteral(String.valueOf(stringLiteral));
                
                    stringLiteral = "";
                }
                
                continue;
            }
            if(!isLiteral) {
                verifyPreprocessors(element);
                verifyKeywords(element);
                verifyIdentifiers(element);
            }
        }

        if(Delimiters.containsQuote()) {
            throw new IOException(
                "Comilla sin cerrar"
            );
        }

    }

    private static void verifyPreprocessors(String element) throws IOException {
        if(containsInclude) {
            if(Reviewer.isImport(element)) {
                Imports.add(element);
            } else {
                throw new IOException(
                    String.format("Error en el elemento: %s", element)
                );
            }
        }

        containsInclude = false;

        if(Preprocessors.isPreprocessor(element)) {
            containsInclude = true;

            Preprocessors.add(element);
        }
    }

    private static void verifyKeywords(String element) {
        if(Keywords.isKeyword(element)) {
            Keywords.add(element);
        }
    }

    private static void verifyOperators(String element) throws IOException {
        if(Operators.isOperator(element)) {
            Operators.add(element);
        } else if(Operators.containsOperator(element)) {
            List<Character> characters = element.chars().mapToObj(c -> (char) c).collect(Collectors.toList());

            characters.removeIf(Character::isLetterOrDigit);
            
            String operator = characters
                                .stream()
                                .map(String::valueOf)
                                .collect(Collectors.joining());

            if(Operators.isOperator(operator)) {
                verifyOperators(operator);
            } else {
                for(char character : characters) {
                    verifyOperators(
                        String.valueOf(character)
                    );
                }
            }

        }
        if(Operators.isDelimiter(element) && !Delimiters.add(element)) {
            throw new IOException(
                String.format("Mal manejo de delimitadores: %s", element)
            );
        }

        if(Delimiters.containsQuote()) {
            isLiteral = true;
        } else {
            isLiteral = false;
        }
    }

    private static void verifyIdentifiers(String element) throws IOException {
        if(!Keywords.isKeyword(element) && !Preprocessors.isPreprocessor(element) && !Operators.isOperator(element) && !Imports.exists(element)) {
            if(Pattern.matches("[0-9]+;", element)) {
                Developer.addLiteral(element);
            } else if(!Developer.existsIdentifier(element) && !isTypeDefinition) {
                throw new IOException(
                    String.format("Identificador no declarado: %s", element)
                );
            } else if(Developer.existsIdentifier(element) && isTypeDefinition) {
                throw new IOException(
                    String.format("El identificador ya ha sido declarado: %s", element)
                );
            } else {
                Developer.addIdentifier(element);

                isTypeDefinition = false;
            }
        }
        if(Keywords.isTypeDefinition(element)) {
            isTypeDefinition = true;
        }
    }

}
