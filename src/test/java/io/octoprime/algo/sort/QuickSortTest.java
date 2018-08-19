package io.octoprime.algo.sort;

import io.octoprime.AbstractTestUtils;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple App.
 */
public class QuickSortTest extends AbstractTestUtils {

    private static QuickSort quick = new QuickSort();

    @Test
    void testQuickSort() {

        int[] array = {2, 1, 4, 6, 3, 5};
        int[] sortedArray = {1, 2, 3, 4, 5, 6};

        banner("testBasic");

        header((Arrays.toString(array)), true);
        quick.sort(array);
        header((Arrays.toString(array)), false);

        assertArrayEquals(array, sortedArray);
    }


    @Test
    void testQuickWith0Elements() {

        int[] arr = {};
        int[] sortedArray = {};

        banner("testSelectionWith0Element");

        header((Arrays.toString(arr)), true);
        quick.sort(arr);
        header((Arrays.toString(arr)), false);

        assertEquals(arr.length, 0);
        assertArrayEquals(arr, sortedArray);
    }

    @Test
    void testQuicknWith1Element() {

        int[] arr = {1};
        int[] sortedArray = {1};

        banner("testSelectionWith1Element");

        header((Arrays.toString(arr)), true);
        quick.sort(arr);
        header((Arrays.toString(arr)), false);

        assertEquals(arr.length, 1);
        assertArrayEquals(arr, sortedArray);
    }


    @Test
    void testQuickWith2Elements() {

        int[] arr = {1, -1};
        int[] sortedArray = {-1, 1};

        banner("testSelectionWith1Element");

        header((Arrays.toString(arr)), true);
        quick.sort(arr);
        header((Arrays.toString(arr)), false);

        assertEquals(arr.length, 2);
        assertArrayEquals(arr, sortedArray);
    }


    @Test
    void testQuickWithSortedElements() {

        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9,};
        int[] sortedArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        banner("testSelectionWith1Element");

        header((Arrays.toString(arr)), true);
        quick.sort(arr);
        header((Arrays.toString(arr)), false);

        assertEquals(arr.length, 10);
        assertArrayEquals(arr, sortedArray);
    }


    @Test
    void testQuickWithDescendingElements() {

        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int[] sortedArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        banner("testSelectionWith1Element");

        header((Arrays.toString(arr)), true);
        quick.sort(arr);
        header((Arrays.toString(arr)), false);

        assertEquals(arr.length, 10);
        assertArrayEquals(arr, sortedArray);
    }

}
