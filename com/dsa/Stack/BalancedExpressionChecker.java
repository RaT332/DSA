package com.dsa.Stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BalancedExpressionChecker {

    private final List<Character> leftBrackets = Arrays.asList('(','<','{', '[');
    private final List<Character> rightBrackets = Arrays.asList(')','>','}',']');

    public boolean check(String input) {
        Stack<Character> stack = new Stack<>();

        for (char ch : input.toCharArray()) {
            if (isLeftBracket(ch))
                stack.push(ch);

            if (isRightBracket(ch)){
                if (stack.isEmpty()) return false;

                char top = stack.pop();
                if (bracketMatch(ch,top)) return false;
            }
        }
        return stack.isEmpty();
    }

    private boolean isLeftBracket(char ch) {
        return leftBrackets.contains(ch);
    }

    private boolean isRightBracket(char ch) {
        return rightBrackets.contains(ch);
    }

    private boolean bracketMatch(char right, char left) {
        return leftBrackets.indexOf(left) == rightBrackets.indexOf(right);
    }
}
