package io.octoprime.algo.sort;

public interface Sort {

    default void sort(Integer[] arr) {

        throw new IllegalArgumentException();

        // sort( Arrays.stream(arr).mapToInt(x -> x).toArray());
    }

    void sort(int[] arr);
}
