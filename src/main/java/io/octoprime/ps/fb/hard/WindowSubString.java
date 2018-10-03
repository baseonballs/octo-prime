package io.octoprime.ps.fb.hard;

public class WindowSubString {


    String findMinWindowOfSubString(String s, String t) {

        int[] map = new int[128];
        for (char c : t.toCharArray()) map[c]++;

        int counter = t.length(), begin = 0, end = 0, distance = Integer.MAX_VALUE, head = 0;

        while (end < s.length()) {
            if (map[s.charAt(end++)]-- > 0) counter--;

            while (counter == 0) {
                if (end - begin < distance) {
                    distance = end - (head = begin);
                }
                if (map[s.charAt(begin++)]++ == 0) {
                    counter++;
                }
            }
        }
        return distance == Integer.MAX_VALUE ? "" : s.substring(head, distance);
    }


    int lengthOfLongestSubstringTwoDistinct(String s) {

        int[] map = new int[128];

        int counter = 0, begin = 0, end = 0, distance = 0;

        while (end < s.length()) {

            if (map[s.charAt(end++)]++ == 0)
                counter++;

            while (counter > 2) {
                if (map[s.charAt(begin++)]-- == 1)
                    counter--;
            }

            distance = Math.max(distance, end - begin);
        }
        return distance;
    }


    int lengthOfLongestSubstring(String s) {

        int[] map = new int[128];
        int counter = 0, begin = 0, end = 0, distance = 0;

        while (end < s.length()) {

            if (map[s.charAt(end++)]++ > 0) counter++;

            while (counter > 0) {
                if (map[s.charAt(begin++)]-- > 1) counter--;
            }

            distance = Math.max(distance, end - begin);
        }

        return distance;
    }

}
