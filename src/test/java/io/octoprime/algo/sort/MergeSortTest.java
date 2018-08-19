package io.octoprime.algo.sort;

import io.octoprime.AbstractTestUtils;
import io.octoprime.TestConfig;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static io.octoprime.algo.ds.DataStructure.getRandomArray;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for simple App.
 */
public class MergeSortTest extends AbstractTestUtils {

    private static MergeSort merge = new MergeSort();

    @Test
    void testMergeSort() {

        int[] array = {2, 1, 4, 6, 3, 5};
        int[] sortedArray = {1, 2, 3, 4, 5, 6};

        banner("testBasic");

        header((Arrays.toString(array)), true);
        merge.sort(array);
        header((Arrays.toString(array)), false);

        assertArrayEquals(array, sortedArray);
    }


    @Test
    void testMergeWith0Elements() {

        int[] arr = {};
        int[] sortedArray = {};

        banner("testMergeWith0Element");

        header((Arrays.toString(arr)), true);
        merge.sort(arr);
        header((Arrays.toString(arr)), false);

        assertEquals(arr.length, 0);
        assertArrayEquals(arr, sortedArray);
    }

    @Test
    void testMergenWith1Element() {

        int[] arr = {1};
        int[] sortedArray = {1};

        banner("testMergeWith1Element");

        header((Arrays.toString(arr)), true);
        merge.sort(arr);
        header((Arrays.toString(arr)), false);

        assertEquals(arr.length, 1);
        assertArrayEquals(arr, sortedArray);
    }


    @Test
    void testMergeWith2Elements() {

        int[] arr = {1, -1};
        int[] sortedArray = {-1, 1};

        banner("testMergeWith1Element");

        header((Arrays.toString(arr)), true);
        merge.sort(arr);
        header((Arrays.toString(arr)), false);

        assertEquals(arr.length, 2);
        assertArrayEquals(arr, sortedArray);
    }


    @Test
    void testMergeWithSortedElements() {

        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9,};
        int[] sortedArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        banner("testMergeWithSortedElements");

        header((Arrays.toString(arr)), true);
        merge.sort(arr);
        header((Arrays.toString(arr)), false);

        assertEquals(arr.length, 10);
        assertArrayEquals(arr, sortedArray);
    }


    @Test
    void testMergeWithDescendingElements() {

        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int[] sortedArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        banner("testMergeWithDescendingElements");

        header((Arrays.toString(arr)), true);
        merge.sort(arr);
        header((Arrays.toString(arr)), false);

        assertEquals(arr.length, 10);
        assertArrayEquals(arr, sortedArray);
    }

    /**
     * Rigourous Test :-)
     */
    @Test
    public void randomzizeQSortArray() {
        banner("randomzizeQSortArray");

        int[] numbers = getRandomArray(TestConfig.ARRAY_SIZE, TestConfig.RAND_RANGE);

        assertTrue(numbers.length == TestConfig.ARRAY_SIZE);

        header((Arrays.toString(numbers)), true);
        merge.sort(numbers);
        header((Arrays.toString(numbers)), false);
    }
}
