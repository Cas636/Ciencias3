package com.udistrital.lexer.tokens;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class Developer {

    private Developer() {}

    protected static final Map<String, Integer> identifiers = new LinkedHashMap<>();
    protected static final Map<String, Integer> literals = new LinkedHashMap<>();

    public static void addIdentifier(String identifier) {
        if(identifiers.containsKey(identifier.replace(";", "").replace("()", ""))) {
            identifiers.put(
                identifier.replace(";", "").replace("()", ""),
                identifiers.get(identifier.replace(";", "").replace("()", "")) + 1
            );
        } else {
            identifiers.put(identifier.replace(";", "").replace("()", ""), 1);
        }
    }

    public static void addLiteral(String literal) {
        if(literals.containsKey(literal)) {
            literals.put(
                literal,
                literals.get(literal) + 1
            );
        } else {
            literals.put(literal, 1);
        }
    }

    public static boolean existsIdentifier(String token) {
        return identifiers.containsKey(token.replace(";", "").replace("()", ""));
    }

    public static boolean existsLiteral(String token) {
        return literals.containsKey(token);
    }

    public static Set<Entry<String, Integer>> getDeveloperTokens() {
        Set<Entry<String, Integer>> developerTokens = new LinkedHashSet<>();

        developerTokens.addAll(identifiers.entrySet());
        developerTokens.addAll(literals.entrySet());

        return developerTokens;
    }
}
