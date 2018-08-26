package io.octoprime.algo.strings.search;

/**
 *
 */
public class RabinKarpTextSearch extends AbstractTextSearchUtils implements TextSearch {

    /**
     * @param text
     * @param pattern
     * @return
     */
    public int search(char[] text, char[] pattern) {
        int patternSize = pattern.length;
        int textSize = text.length;

        long prime = getBiggerPrime(patternSize);

        long r = 1;
        for (int i = 0; i < patternSize - 1; i++) {
            r *= 2;
            r = r % prime;
        }

        long[] t = new long[textSize];
        t[0] = 0;

        long pfinger = 0;

        for (int j = 0; j < patternSize; j++) {
            t[0] = (2 * t[0] + text[j]) % prime;
            pfinger = (2 * pfinger + pattern[j]) % prime;
        }

        int i = 0;
        boolean passed = false;

        int diff = textSize - patternSize;
        for (i = 0; i <= diff; i++) {
            if (t[i] == pfinger) {
                passed = true;
                for (int k = 0; k < patternSize; k++) {
                    if (text[i + k] != pattern[k]) {
                        passed = false;
                        break;
                    }
                }

                if (passed) {
                    return i;
                }
            }

            if (i < diff) {
                long value = 2 * (t[i] - r * text[i]) + text[i + patternSize];
                t[i + 1] = ((value % prime) + prime) % prime;
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

        int index = new RabinKarpTextSearch().search(s.toCharArray(), p.toCharArray());
        if (index != -1)
            System.out.println(String.format("The paternn (\"%s\") found in (\"%s\") at index %d.", p, s, index));

    }
}
