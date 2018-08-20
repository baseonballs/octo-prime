package io.octoprime.algo.strings;

/**
 * Give a stream of characters encode the string such that the character if followed by the number of repetting character.
 * For exampl,e 'aaabbcd' should be encoded as 'a3b2c1d1';
 */
public class Encoding {

    private void intern(StringBuilder sb, char prev, int count) {
        sb.append(Character.toString(prev)).append(count);
    }

    public String encode(String s) {
        char[] ch = s.toCharArray();
        StringBuilder sb = new StringBuilder();

        char prev = ch[0];
        int count = 1;
        int i = 1;
        for (; i < ch.length; i++) {
            if (prev != ch[i]) {
                intern(sb, prev, count);
                prev = ch[i];
                count = 1;
            } else {
                count++;
            }
        }
        if (i >= 1)
            intern(sb, prev, count);

        return sb.toString();
    }
}
