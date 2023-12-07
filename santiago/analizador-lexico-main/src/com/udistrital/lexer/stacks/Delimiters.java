package com.udistrital.lexer.stacks;

import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.udistrital.lexer.tokens.Operators;

public class Delimiters {

    private Delimiters() {}

    protected static final Stack<String> stack = new Stack<>();

    private static final Logger log = Logger.getGlobal();

    public static boolean add(String token) {

        if(!Operators.isDelimiter(token)) {
            return false;
        }

        if(Operators.isCloseDelimiter(token) && stack.isEmpty()) {
            return false;
        }

        if(Operators.isCloseDelimiter(token) && stack.isEmpty() && !Operators.correspond(stack.peek(), token)) {
            return false;
        }

        if(!stack.isEmpty() && Operators.correspond(stack.peek(), token)) {
            stack.pop();

            return true;
        }

        stack.add(token);

        return true;
    }

    public static boolean containsQuote() {
        return !stack.isEmpty() && (stack.peek().equals("\"") || stack.peek().equals("'"));
    }

    public static String getLasElement() {
        return stack.peek();
    }

    public static boolean isEmpty() {
        return stack.isEmpty();
    }
    
}
