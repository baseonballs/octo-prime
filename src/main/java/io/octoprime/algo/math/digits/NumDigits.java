package io.octoprime.algo.math.digits;

import java.util.Scanner;

public class NumDigits {

    public static int getNumDigitsUsingDivideAndConquer(int number) {
        if (number < 100000) {
            if (number < 100) {
                if (number < 10) {
                    return 1;
                } else {
                    return 2;
                }
            } else {
                if (number < 1000) {
                    return 3;
                } else {
                    if (number < 10000) {
                        return 4;
                    } else {
                        return 5;
                    }
                }
            }
        } else {
            if (number < 10000000) {
                if (number < 1000000) {
                    return 6;
                } else {
                    return 7;
                }
            } else {
                if (number < 100000000) {
                    return 8;
                } else {
                    if (number < 1000000000) {
                        return 9;
                    } else {
                        return 10;
                    }
                }
            }
        }
    }

    public static int getNumDigitsUsingPowersOfTwos(int number) {
        int length = 1;
        if (number >= 100000000) {
            length += 8;
            number /= 100000000;
        }
        if (number >= 10000) {
            length += 4;
            number /= 10000;
        }
        if (number >= 100) {
            length += 2;
            number /= 100;
        }
        if (number >= 10) {
            length += 1;
        }
        return length;
    }

    /**
     * @param n
     * @return
     */
    public static int getNumDigitUsingLog(int n) {
        int length = (int) (Math.log10(n) + 1);
        return length;
    }

    /**
     *
     * @param n
     * @return
     */
    public static int getNumDigit1(String n) {
        return n.length();
    }

    /**
     *
     * @param n
     * @return
     */
    public static int numdigits0(int n) {
        int count = 0;


        if (n == 0) return 1;
        for (; n > 0; n /= 10)
            count++;

        return count;
    }

    /**
     * @param n
     * @return
     */
    public static int getNumDigitsUsingPlaceValue(int n) {

        int count = 0;
        for (int pv = 1; pv <= n; pv *= 10)
            count++;

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number: ");
        int num = scanner.nextInt();

        System.out.println("Number of digits: " + numdigits0(num));
    }
}
