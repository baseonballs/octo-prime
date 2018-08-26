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
public class SelectionSortTest extends AbstractTestUtils {

    private static SelectionSort selection = new SelectionSort();

    @Test
    void testSelectionSort() {

        int[] array = {2, 1, 4, 6, 3, 5};
        int[] sortedArray = {1, 2, 3, 4, 5, 6};

        banner("testBasic");

        header((Arrays.toString(array)), true);
        selection.sort(array);
        header((Arrays.toString(array)), false);

        assertArrayEquals(array, sortedArray);
    }


    @Test
    void testSelectionWith0Elements() {

        int[] arr = {};
        int[] sortedArray = {};

        banner("testSelectionWith0Element");

        header((Arrays.toString(arr)), true);
        selection.sort(arr);
        header((Arrays.toString(arr)), false);

        assertEquals(arr.length, 0);
        assertArrayEquals(arr, sortedArray);
    }

    @Test
    void testSelectionWith1Element() {

        int[] arr = {1};
        int[] sortedArray = {1};

        banner("testSelectionWith1Element");

        header((Arrays.toString(arr)), true);
        selection.sort(arr);
        header((Arrays.toString(arr)), false);

        assertEquals(arr.length, 1);
        assertArrayEquals(arr, sortedArray);
    }


    @Test
    void testSelectionWith2Elements() {

        int[] arr = {1, -1};
        int[] sortedArray = {-1, 1};

        banner("testSelectionWith1Element");

        header((Arrays.toString(arr)), true);
        selection.sort(arr);
        header((Arrays.toString(arr)), false);

        assertEquals(arr.length, 2);
        assertArrayEquals(arr, sortedArray);
    }


    @Test
    void testSelectionWithSortedElements() {

        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9,};
        int[] sortedArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        banner("testSelectionWith1Element");

        header((Arrays.toString(arr)), true);
        selection.sort(arr);
        header((Arrays.toString(arr)), false);

        assertEquals(arr.length, 10);
        assertArrayEquals(arr, sortedArray);
    }


    @Test
    void testSelectionWithDescendingElements() {

        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int[] sortedArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        banner("testSelectionWith1Element");

        header((Arrays.toString(arr)), true);
        selection.sort(arr);
        header((Arrays.toString(arr)), false);

        assertEquals(arr.length, 10);
        assertArrayEquals(arr, sortedArray);
    }

    /**
     * Rigourous Test :-)
     */
    @Test
    public void randomzizeSelectionArray() {
        banner("randomziedArray");

        int[] numbers = getRandomArray(TestConfig.ARRAY_SIZE, TestConfig.RAND_RANGE);

        assertTrue(numbers.length == TestConfig.ARRAY_SIZE);

        header((Arrays.toString(numbers)), true);
        selection.sort(numbers);
        header((Arrays.toString(numbers)), false);
    }

}
