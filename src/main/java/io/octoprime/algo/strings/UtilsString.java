package io.octoprime.algo.strings;

import java.nio.charset.Charset;
import java.util.Random;

public class UtilsString {

    public static String randomString(int size) {
        byte[] array = new byte[size]; // length is bounded by 32
        new Random().nextBytes(array);

        return new String(array, Charset.forName("UTF-8"));

    }

    public static String randomStringAlpha(int n) {

        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = n;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        return buffer.toString();
    }

    public static String reverseString(String s) {
        char[] arr = s.toCharArray();
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            char t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }
        return new String(arr);
    }
}

