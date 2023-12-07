package com.udistrital.lexer.reviewer;

import java.util.regex.Pattern;

public class Reviewer {
    private Reviewer() {}

    protected static String include = "<.+>|\".+\"";

    public static boolean isImport(String line) {
        return Pattern.matches(include, line);
    }
}


/**
 * package com.udistrital.lexer.reviewer;

import java.util.regex.Pattern;

import com.udistrital.lexer.tokens.Preprocessors;

public class Reviewer {
    private Reviewer() {}

    public boolean isMacro(String line) {

        String macro = line.split(" ")[0];

        if(Preprocessors.isPreprocessor(macro)) {
            Preprocessors.add(macro);

            

            return true;
        }

        return false;

    }
}

 */