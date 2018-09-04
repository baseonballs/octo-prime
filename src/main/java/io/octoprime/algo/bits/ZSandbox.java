package io.octoprime.algo.bits;

public class ZSandbox {


    public static void main(String[] args) {

        int n = -3;

        int c = 0;
        while (n > 0) {
            c++;
            n &= n - 1;
        }

        n = 5;
        c = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) c++;
            n >>>= 1;
        }
        System.out.print(String.format("number of bits for %d: %s", n, c));
    }
}
