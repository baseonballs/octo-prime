package io.octoprime.ps.fb.hard;

import java.util.Scanner;

public class IntegersToWords {

    private final String[] SPECIAL_BASE = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
            "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen",
            "Seventeen", "Eighteen", "Nineteen"};
    private final String[] TENS_BASE = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty",
            "Seventy", "Eighty", "Ninety"};
    private final String[] THOUSANDS_BASE = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0) return "Zero";

        int i = 0;
        String words = "";

        while (num > 0) {
            if (num % 1000 != 0)
                words = wordify(num % 1000) + THOUSANDS_BASE[i] + " " + words;
            num /= 1000;
            i++;
        }

        return words.trim();
    }

    private String wordify(int num) {
        if (num == 0)
            return "";
        else if (num < 20)
            return SPECIAL_BASE[num] + " ";
        else if (num < 100)
            return TENS_BASE[num / 10] + " " + wordify(num % 10);
        else
            return SPECIAL_BASE[num / 100] + " Hundred " + wordify(num % 100);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number to convert: ");
        int num = scanner.nextInt();


        System.out.println("Converted in words: " + new IntegersToWords().numberToWords(num));
    }
}
