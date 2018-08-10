package io.octoprime.algo.sort;

import java.util.Arrays;

public interface Sort {

    default void sort(Integer[] arr) {
        sort(Arrays.stream(arr).mapToInt(x -> x).toArray());
    }

    void sort(int[] arr);
}
