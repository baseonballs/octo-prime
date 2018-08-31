package io.octoprime.algo.sort;

/**
 * Example
 * For "abAcD", a reasonable answer is "acbAD"
 * Note
 * It's NOT necessary to keep the original order of lower-case letters and upper case
 * letters.
 * Challenge
 * Do it in one-pass and in-place.
 */
public class SortByCase {

    /**
     * @param chars: The letter array you should sort by Case
     * @return: void
     */
    public void sortLetters(char[] chars) {
        int i = 0, j = chars.length - 1;
        while (i < j) {
            while (i < chars.length && chars[i] <= 'z' && chars[i
                    ] >= 'a') i++;
            while (j >= 0 && chars[j] <= 'Z' && chars[j] >= 'A')
                j--;
            if (i < j) {
                char tmp = chars[i];
                chars[i] = chars[j];
                chars[j] = tmp;
            }
        }
    }

}
