package io.octoprime.algo.sort;

import io.octoprime.AbstractTestUtils;
import io.octoprime.TestConfig;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static io.octoprime.utils.DataStructure.getRandomArray;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for simple App.
 */
public class InsertionSortTest extends AbstractTestUtils {

    private static InsertionSort insertion = new InsertionSort();

    @Test
    void testInsertionSort() {

        int[] array = {2, 1, 4, 6, 3, 5};
        int[] sortedArray = {1, 2, 3, 4, 5, 6};

        banner("testInsertionSort");

        header((Arrays.toString(array)), true);
        insertion.sort(array);
        header((Arrays.toString(array)), false);

        assertArrayEquals(array, sortedArray);
    }


    @Test
    void testInsertionnWith0Elements() {

        int[] arr = {};
        int[] sortedArray = {};

        banner("testInsertionnWith0Elements");

        header((Arrays.toString(arr)), true);
        insertion.sort(arr);
        header((Arrays.toString(arr)), false);

        assertEquals(arr.length, 0);
        assertArrayEquals(arr, sortedArray);
    }

    @Test
    void testInsertionWith1Element() {

        int[] arr = {1};
        int[] sortedArray = {1};

        banner("testInsertionWith1Element");

        header((Arrays.toString(arr)), true);
        insertion.sort(arr);
        header((Arrays.toString(arr)), false);

        assertEquals(arr.length, 1);
        assertArrayEquals(arr, sortedArray);
    }


    @Test
    void testInsertionWith2Elements() {

        int[] arr = {1, -1};
        int[] sortedArray = {-1, 1};

        banner("testInsertionWith2Elements");

        header((Arrays.toString(arr)), true);
        insertion.sort(arr);
        header((Arrays.toString(arr)), false);

        assertEquals(arr.length, 2);
        assertArrayEquals(arr, sortedArray);
    }


    @Test
    void testInsertionWithSortedElements() {

        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9,};
        int[] sortedArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        banner("testInsertionWithSortedElements");

        header((Arrays.toString(arr)), true);
        insertion.sort(arr);
        header((Arrays.toString(arr)), false);

        assertEquals(arr.length, 10);
        assertArrayEquals(arr, sortedArray);
    }


    @Test
    void testInsertionWithDescendingElements() {

        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int[] sortedArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        banner("testInsertionWithDescendingElements");

        header((Arrays.toString(arr)), true);
        insertion.sort(arr);
        header((Arrays.toString(arr)), false);

        assertEquals(arr.length, 10);
        assertArrayEquals(arr, sortedArray);
    }

    /**
     * Rigourous Test :-)
     */
    @Test
    public void randomzizeInsertionArray() {
        banner("randomzizeInsertionArray");

        int[] numbers = getRandomArray(TestConfig.ARRAY_SIZE, TestConfig.RAND_RANGE);

        assertTrue(numbers.length == TestConfig.ARRAY_SIZE);

        header((Arrays.toString(numbers)), true);
        insertion.sort(numbers);
        header((Arrays.toString(numbers)), false);
    }

}
