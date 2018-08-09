package io.octoprime.algo.strings;

public class ShiftedByK {

    public static void shiftByK(char arr[], char shiftedS[], int n, int k) {

        // Iterate through the length of given string
        for (int i = 0; i < n; i++) {

            // Find the index for this current character in shiftedS[]
            int index = (i + k) % n;

            // Copy that character at the found index idx
            shiftedS[index] = arr[i];
        }
    }

    public static void main(String[] args) {
        String s = "Hello World";
        char[] shifted = new char[s.length()];

        shiftByK(s.toCharArray(), shifted, s.length(), 2);

        System.out.println(s);
        System.out.println("----------------");
        System.out.println(shifted);
    }
}
