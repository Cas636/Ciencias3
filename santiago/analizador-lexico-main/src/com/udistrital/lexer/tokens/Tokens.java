package com.udistrital.lexer.tokens;

import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Tokens {

    private Tokens() {}

    public static Map<String, Set<Entry<String, Integer>>> getAllTokens() {
        
        return Map.of(
            "Identifiers", Developer.getDeveloperTokens().stream().filter(x -> x.getValue() > 0).collect(Collectors.toSet()),
            "Includes", Imports.getIncludes().stream().filter(x -> x.getValue() > 0).collect(Collectors.toSet()),
            "Keywords", Keywords.getKeywords().stream().filter(x -> x.getValue() > 0).collect(Collectors.toSet()),
            "Operators", Operators.getOperators().stream().filter(x -> x.getValue() > 0).collect(Collectors.toSet()),
            "Preprocessors", Preprocessors.getPreprocessors().stream().filter(x -> x.getValue() > 0).collect(Collectors.toSet())
        );
    }
    
}
