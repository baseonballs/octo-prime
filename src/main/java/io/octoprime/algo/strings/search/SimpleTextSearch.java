package io.octoprime.algo.strings.search;

/**
 *
 */
public class SimpleTextSearch {

    /**
     * @param text
     * @param pat
     * @return
     */
    public static int simpleTextSearch(char[] text, char[] pat) {

        for (int i = 0; (i + pat.length) <= text.length; i++) {
            int j = 0;
            while (text[i + j] == pat[j]) {
                if (++j >= pat.length)
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

        int index = simpleTextSearch(s.toCharArray(), p.toCharArray());
        if (index != -1)
            System.out.println(String.format("The paternn (\"%s\") found in (\"%s\") at index %d.", p, s, index));

    }
}
