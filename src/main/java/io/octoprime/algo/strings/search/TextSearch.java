package io.octoprime.algo.strings.search;

/**
 * Simple interface for test search modules.
 */
public interface TextSearch {

    /**
     * Applies the search method within the supplied text; given a pattern.  Method depends on the underlying
     * algorithm.
     *
     * @param text
     * @param pattern
     * @return int index where the pattern is found within the supplied text.
     */
    int search(char[] text, char[] pattern);
}
