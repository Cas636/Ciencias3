package com.udistrital.lexer.tokens;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Keywords {
    
    private Keywords() {}

    protected static final Map<String, Integer> tokens = new LinkedHashMap<>();

    protected static final Set<String> keywords = new LinkedHashSet<>();
    protected static final Map<String, Integer> typeDefinitions = new LinkedHashMap<>();

    static {
        typeDefinitions.put("auto", 0);
        typeDefinitions.put("bool", 0);
        typeDefinitions.put("char", 0);
        typeDefinitions.put("class", 0);
        typeDefinitions.put("double", 0);
        typeDefinitions.put("float", 0);
        typeDefinitions.put("int", 0);
        typeDefinitions.put("long", 0);
        typeDefinitions.put("namespace", 0);
        typeDefinitions.put("short", 0);
        typeDefinitions.put("string", 0);
        typeDefinitions.put("struct", 0);
        typeDefinitions.put("void", 0);

        tokens.put("break", 0);
        tokens.put("case", 0);
        tokens.put("catch", 0);
        tokens.put("continue", 0);
        tokens.put("cin", 0);
        tokens.put("cout", 0);
        tokens.put("const", 0);
        tokens.put("default", 0);
        tokens.put("delete", 0);
        tokens.put("do", 0);
        tokens.put("else", 0);
        tokens.put("enum", 0);
        tokens.put("endl", 0);
        tokens.put("false", 0);
        tokens.put("final", 0);
        tokens.put("for", 0);
        tokens.put("friend", 0);
        tokens.put("if", 0);
        tokens.put("inline", 0);
        tokens.put("new", 0);
        tokens.put("nullptr", 0);
        tokens.put("operator", 0);
        tokens.put("override", 0);
        tokens.put("private", 0);
        tokens.put("protected", 0);
        tokens.put("public", 0);
        tokens.put("return", 0);
        tokens.put("signed", 0);
        tokens.put("sizeof", 0);
        tokens.put("static", 0);
        tokens.put("template", 0);
        tokens.put("this", 0);
        tokens.put("throw", 0);
        tokens.put("true", 0);
        tokens.put("try", 0);
        tokens.put("typeid", 0);
        tokens.put("typename", 0);
        tokens.put("unsigned", 0);
        tokens.put("using", 0);
        tokens.put("virtual", 0);
        tokens.put("while", 0);

        keywords.addAll(tokens.keySet());
        keywords.addAll(typeDefinitions.keySet());
    }

    public static boolean containsKeyword(String line) {
        return keywords.stream().anyMatch(line::contains);
    }

    public static boolean isKeyword(String token) {
        return keywords.contains(token.replace(";", ""));
    }

    public static boolean isTypeDefinition(String token) {
        return typeDefinitions.containsKey(token);
    }

    public static void add(String token) {
        if(tokens.containsKey(token)) {
            tokens.put(
                token,
                tokens.get(token) + 1
            );
        }

        if(typeDefinitions.containsKey(token)) {
            typeDefinitions.put(
                token,
                typeDefinitions.get(token) + 1
            );
        }
    }

    public static Set<Entry<String, Integer>> getKeywords() {

        Set<Entry<String, Integer>> keywordsEntrySet = new LinkedHashSet<>();

        keywordsEntrySet.addAll(tokens.entrySet());
        keywordsEntrySet.addAll(typeDefinitions.entrySet());

        return keywordsEntrySet;
    }

}
