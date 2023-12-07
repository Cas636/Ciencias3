package com.udistrital.lexer.tokens;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class Imports {

    private Imports() {}

    protected static final Map<String, Integer> includes = new LinkedHashMap<>();

    public static void add(String identifier) {
        if(includes.containsKey(identifier.replace("<", "").replace(">", "").replace("\"", ""))) {
            includes.put(
                identifier.replace("<", "").replace(">", "").replace("\"", ""),
                includes.get(identifier.replace("<", "").replace(">", "").replace("\"", "")) + 1
            );
        } else {
            includes.put(identifier.replace("<", "").replace(">", "").replace("\"", ""), 1);
        }
    }

    public static boolean exists(String token) {
        return includes.containsKey(token.replace("<", "").replace(">", "").replace("\"", ""));
    }

    public static Set<Entry<String, Integer>> getIncludes() {
        return includes.entrySet();
    }
}
