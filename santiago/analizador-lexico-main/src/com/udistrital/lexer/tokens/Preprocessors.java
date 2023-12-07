package com.udistrital.lexer.tokens;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Preprocessors {

    private Preprocessors() {}

    protected static final Map<String, Integer> macros = new LinkedHashMap<>();

    protected static final Set<String> preprocessors = new LinkedHashSet<>();

    static {
        macros.put("#include", 0);

        preprocessors.addAll(macros.keySet());
    }

    public static boolean containsPreprocessor(String line) {
        return preprocessors.stream().anyMatch(line::contains);
    }

    public static boolean isPreprocessor(String token) {
        return preprocessors.contains(token);
    }

    public static void add(String token) {
        if(macros.containsKey(token)) {
            macros.put(
                token,
                macros.get(token) + 1
            );
        }
    }

    public static Set<Entry<String, Integer>> getPreprocessors() {
        return macros.entrySet();
    }
    
}
