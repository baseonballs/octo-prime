package io.octoprime.algo.strings.search;

import java.math.BigInteger;
import java.util.Random;

public abstract class AbstractTextSearchUtils {

    public static long getBiggerPrime(int m) {
        BigInteger prime = BigInteger.probablePrime(getNumberOfBits(m) + 1, new Random());
        return prime.longValue();
    }

    private static int getNumberOfBits(int number) {
        return Integer.SIZE - Integer.numberOfLeadingZeros(number);
    }

}
