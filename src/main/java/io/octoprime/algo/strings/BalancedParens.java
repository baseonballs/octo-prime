package io.octoprime.algo.strings;

import java.util.Stack;

public class BalancedParens {

    public static void main(String[] args) {
        String checkBalancedExpr1 = checkBalancedParentesis("a*(b+c)-(d*e)");
        System.out.println("a*(b+c)-(d*e) : " + checkBalancedExpr1);
        String checkBalancedExpr2 = checkBalancedParentesis("(a*(b-c)*{d+e}");
        System.out.println("(a*(b-c)*{d+e} : " + checkBalancedExpr2);
    }

    public static String checkBalancedParentesis(String expr) {
        if (expr.isEmpty())
            return "Balanced";

        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < expr.length(); i++) {
            char ch = expr.charAt(i);
            if (ch == '{' || ch == '(' || ch == '[') {
                stack.push(ch);
            }
            if (ch == '}' || ch == ')' || ch == ']') {
                if (stack.isEmpty())
                    return "Not Balanced";
                char last = stack.peek();
                if ((ch == '}' && last == '{') || (ch == ')' && last == '(') || (ch == ']' && last == '['))
                    stack.pop();
                else
                    return "Not Balanced";
            }
        }
        return stack.isEmpty() ? "Balanced" : "Not Balanced";
    }
}
