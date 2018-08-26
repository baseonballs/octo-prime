package io.octoprime.algo.strings.search;

/**
 *
 */
public class BoyerMooreHorspoolTextSearch implements TextSearch {

    /**
     * @param text
     * @param pattern
     * @return
     */
    public int search(char[] text, char[] pattern) {

        int shift[] = new int[256];

        for (int k = 0; k < 256; k++) {
            shift[k] = pattern.length;
        }

        for (int k = 0; k < pattern.length - 1; k++) {
            shift[pattern[k]] = pattern.length - 1 - k;
        }

        int i = 0, j = 0;

        while ((i + pattern.length) <= text.length) {
            j = pattern.length - 1;

            while (text[i + j] == pattern[j]) {
                j -= 1;
                if (j < 0)
                    return i;
            }

            i = i + shift[text[i + pattern.length - 1]];
        }
        return -1;
    }

    /**
     * @param pattern
     * @param text
     * @return
     */
    public int naive(char[] text, char[] pattern) {
        int plen = pattern.length;

        int i = 0, j = 0;

        while ((i + plen) <= text.length) {
            j = plen - 1;
            while (text[i + j] == pattern[j]) {
                j--;
                if (j < 0)
                    return i;
            }
            i++;
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "The cow jumped over the moon.";

        String p = "jumped";

        int index = new BoyerMooreHorspoolTextSearch().search(s.toCharArray(), p.toCharArray());
        if (index != -1)
            System.out.println(String.format("The paternn (\"%s\") found in (\"%s\") at index %d.", p, s, index));

    }
}
