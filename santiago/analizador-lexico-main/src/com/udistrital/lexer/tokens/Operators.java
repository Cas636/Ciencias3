package com.udistrital.lexer.tokens;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;

import com.udistrital.lexer.stacks.Delimiters;

import java.util.Set;

public class Operators {

    private Operators() {}

    protected static final Map<String, Integer> arithmetics = new LinkedHashMap<>();
    protected static final Map<String, Integer> relational = new LinkedHashMap<>();
    protected static final Map<String, Integer> logical = new LinkedHashMap<>();
    protected static final Map<String, Integer> special = new LinkedHashMap<>();
    protected static final Map<String, Integer> delimiters = new LinkedHashMap<>();

    protected static final Set<String> operators = new LinkedHashSet<>();

    static {
        arithmetics.put("+", 0);
        arithmetics.put("-", 0);
        arithmetics.put("*", 0);
        arithmetics.put("/", 0);
        arithmetics.put("%", 0);
        arithmetics.put(">>", 0);
        arithmetics.put("<<", 0);
        arithmetics.put("=", 0);

        relational.put("==", 0);
        relational.put(">", 0);
        relational.put("<", 0);
        relational.put("<=", 0);
        relational.put("!=", 0);

        logical.put("&&", 0);
        logical.put("||", 0);

        special.put("!", 0);
        special.put("++", 0);
        special.put("--", 0);

        delimiters.put("(", 0);
        delimiters.put(")", 0);
        delimiters.put("{", 0);
        delimiters.put("}", 0);
        delimiters.put("[", 0);
        delimiters.put("]", 0);
        delimiters.put("\"", 0);
        delimiters.put("'", 0);

        operators.addAll(arithmetics.keySet());
        operators.addAll(relational.keySet());
        operators.addAll(logical.keySet());
        operators.addAll(special.keySet());
        operators.addAll(delimiters.keySet());
    }

    public static boolean containsOperator(String line) {
        return operators.stream().anyMatch(line::contains);
    }

    public static boolean isOperator(String token) {
        return operators.contains(token);
    }

    public static boolean isArithmetic(String token) {
        return arithmetics.containsKey(token);
    }

    public static boolean isRelational(String token) {
        return relational.containsKey(token);
    }

    public static boolean isLogical(String token) {
        return logical.containsKey(token);
    }

    public static boolean isSpecial(String token) {
        return special.containsKey(token);
    }

    public static boolean isDelimiter(String token) {
        return delimiters.containsKey(token);
    }

    public static boolean isOpenDelimiter(String token) {
        int index = Arrays.asList(delimiters.keySet().toArray()).indexOf(token);
        return (0 <= index && index <= 5 && index % 2 == 0) || (token.equals("\"") || token.equals("'")) && !Delimiters.containsQuote();
    }

    public static boolean isCloseDelimiter(String token) {
        int index = Arrays.asList(delimiters.keySet().toArray()).indexOf(token);
        return (0 <= index && index <= 5 && index % 2 != 0) || (token.equals("\"") || token.equals("'")) && Delimiters.containsQuote() && correspond(token, Delimiters.getLasElement());
    }

    public static boolean correspond(String openToken, String closeToken) {
        int openIndex = Arrays.asList(delimiters.keySet().toArray()).indexOf(openToken);
        int closeIndex = Arrays.asList(delimiters.keySet().toArray()).indexOf(closeToken);

        return (openIndex != -1) && ((closeIndex - openIndex == 1) || (openToken.equals(closeToken) && closeToken.equals("\"")) || (openToken.equals(closeToken) && closeToken.equals("'")));
    }

    public static Set<Entry<String, Integer>> getOperators() {

        Set<Entry<String, Integer>> operatorsEntrySet = new LinkedHashSet<>();

        operatorsEntrySet.addAll(arithmetics.entrySet());
        operatorsEntrySet.addAll(relational.entrySet());
        operatorsEntrySet.addAll(logical.entrySet());
        operatorsEntrySet.addAll(special.entrySet());
        operatorsEntrySet.addAll(delimiters.entrySet());

        return operatorsEntrySet;
    }

    public static void add(String token) {
        if(arithmetics.containsKey(token)) {
            arithmetics.put(
                token,
                arithmetics.get(token) + 1
            );
        }

        if(relational.containsKey(token)) {
            relational.put(
                token,
                relational.get(token) + 1
            );
        }

        if(logical.containsKey(token)) {
            logical.put(
                token,
                logical.get(token) + 1
            );
        }

        if(special.containsKey(token)) {
            special.put(
                token,
                special.get(token) + 1
            );
        }

        if(delimiters.containsKey(token)) {
            delimiters.put(
                token,
                delimiters.get(token) + 1
            );
        }
    }
    
}
