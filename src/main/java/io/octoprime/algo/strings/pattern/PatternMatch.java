package io.octoprime.algo.strings.pattern;

public class PatternMatch {


    public static final String EXAMPLE_TEST = "This is my small example "
            + "string which I'm going to " + "use for pattern matching.";


    public static void main(String[] args) {
        String pattern = "(\\w)(\\s+)([\\.,])";
        System.out.println(EXAMPLE_TEST.replaceAll(pattern, "$1$3"));
    }
}
