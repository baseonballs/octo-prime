package io.octoprime.algo.strings;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class Reverse {

    public static String reverser(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        return input.charAt(input.length() - 1) + reverser(input.substring(0, input.length() - 1));
    }

    public static String reverseAppend(String input) {
        StringBuilder sb = new StringBuilder();

        for (int j = input.length() - 1; j >= 0; j--) {
            sb.append(input.charAt(j));
        }

        return sb.toString();
    }

    public static String reverseQueue(String input) {
        Queue<Character> q = new LinkedList<>();

        for (int j = input.length() - 1; j >= 0; j--)
            q.add(input.charAt(j));

        return q.stream().map(String::valueOf).collect(Collectors.joining());
    }

    public static String reverseInPlace(String input) {
        char[] chars = input.toCharArray();

        for (int i = 0, j = chars.length - 1; i < j; i++, j--) {
            char t = chars[i];
            chars[i] = chars[j];
            chars[j] = t;
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        String str = "abcdefg";

        System.out.println("input string: " + str);

        System.out.println("reversed string: " + reverseQueue(str));
    }
}
