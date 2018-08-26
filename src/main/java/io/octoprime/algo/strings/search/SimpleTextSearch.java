package io.octoprime.algo.strings.search;

/**
 *
 */
public class SimpleTextSearch {

    public static int simpleTextSearch(char[] pattern, char[] text) {
        int patternSize = pattern.length;
        int textSize = text.length;

        int i = 0;

        while ((i + patternSize) <= textSize) {
            int j = 0;
            while (text[i + j] == pattern[j]) {
                j += 1;
                if (j >= patternSize)
                    return i;
            }
            i += 1;
        }
        return -1;
    }

    /**
     * @param text
     * @param pattern
     * @return
     */
    public static int simpleTextSearch2(char[] text, char[] pattern) {
        int plen = pattern.length;

        for (int i = 0; (i + plen) <= text.length; i++) {
            int j = 0;
            while (text[i + j] == pattern[j]) {
                j += 1;
                if (j >= plen)
                    return i;
            }
        }
        return -1;
    }


    /**
     * @param args
     */
    public static void main(String[] args) {
        String s = "Hello World.";

        String p = "World";

        int index = simpleTextSearch2(s.toCharArray(), p.toCharArray());
        if (index != -1)
            System.out.println(String.format("The paternn (\"%s\") found in (\"%s\") at index %d.", p, s, index));

    }
}
