package io.octoprime.algo.strings;

public class ShiftedByK {

    public static void shiftByK(char arr[], char shiftedS[], int n, int k) {

        for (int i = 0; i < n; i++) {
            shiftedS[(i + k) % n] = arr[i];
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
