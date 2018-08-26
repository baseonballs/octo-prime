package io.octoprime.algo.strings.search;

/**
 *
 */
public class KnuthMorrisPrattTextSearch implements TextSearch {

    /**
     * @param pattern
     * @param text
     * @return
     */
    public int search(char[] text, char[] pattern) {
        int patternSize = pattern.length;
        int textSize = text.length;

        int i = 0, j = 0;

        int[] shift = knuthMorrisPrattShift(pattern);

        while ((i + patternSize) <= textSize) {
            while (text[i + j] == pattern[j]) {
                j += 1;
                if (j >= patternSize)
                    return i;
            }

            if (j > 0) {
                i += shift[j - 1];
                j = Math.max(j - shift[j - 1], 0);
            } else {
                i++;
                j = 0;
            }
        }
        return -1;
    }

    /**
     * @param pattern
     * @return
     */
    private int[] knuthMorrisPrattShift(char[] pattern) {
        int patternSize = pattern.length;

        int[] shift = new int[patternSize];
        shift[0] = 1;

        int i = 1, j = 0;

        while ((i + j) < patternSize) {
            if (pattern[i + j] == pattern[j]) {
                shift[i + j] = i;
                j++;
            } else {
                if (j == 0)
                    shift[i] = i + 1;

                if (j > 0) {
                    i = i + shift[j - 1];
                    j = Math.max(j - shift[j - 1], 0);
                } else {
                    i = i + 1;
                    j = 0;
                }
            }
        }
        return shift;
    }

    public static void main(String[] args) {
        String s = "Hello World.";

        String p = "World";

        int index = new KnuthMorrisPrattTextSearch().search(s.toCharArray(), p.toCharArray());
        if (index != -1)
            System.out.println(String.format("The paternn (\"%s\") found in (\"%s\") at index %d.", p, s, index));

    }

}
