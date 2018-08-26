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
public class BubbleSortTest extends AbstractTestUtils {

    private static BubbleSort bubble = new BubbleSort();

    @Test
    void testBubbleSort() {

        int[] array = {2, 1, 4, 6, 3, 5};
        int[] sortedArray = {1, 2, 3, 4, 5, 6};

        banner("testBubbleSort");

        header((Arrays.toString(array)), true);
        bubble.sort(array);
        header((Arrays.toString(array)), false);

        assertArrayEquals(array, sortedArray);
    }


    @Test
    void testBubbleWith0Elements() {

        int[] arr = {};
        int[] sortedArray = {};

        banner("testBubbleWith0Elements");

        header((Arrays.toString(arr)), true);
        bubble.sort(arr);
        header((Arrays.toString(arr)), false);

        assertEquals(arr.length, 0);
        assertArrayEquals(arr, sortedArray);
    }

    @Test
    void testBubbleWith1Element() {

        int[] arr = {1};
        int[] sortedArray = {1};

        banner("testBubbleWith1Element");

        header((Arrays.toString(arr)), true);
        bubble.sort(arr);
        header((Arrays.toString(arr)), false);

        assertEquals(arr.length, 1);
        assertArrayEquals(arr, sortedArray);
    }


    @Test
    void testBubbleWith2Elements() {

        int[] arr = {1, -1};
        int[] sortedArray = {-1, 1};

        banner("testBubbleWith2Elements");

        header((Arrays.toString(arr)), true);
        bubble.sort(arr);
        header((Arrays.toString(arr)), false);

        assertEquals(arr.length, 2);
        assertArrayEquals(arr, sortedArray);
    }


    @Test
    void testBubbleWithSortedElements() {

        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9,};
        int[] sortedArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        banner("testBubbleWithSortedElements");

        header((Arrays.toString(arr)), true);
        bubble.sort(arr);
        header((Arrays.toString(arr)), false);

        assertEquals(arr.length, 10);
        assertArrayEquals(arr, sortedArray);
    }


    @Test
    void testBubbleWithDescendingElements() {

        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int[] sortedArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        banner("testBubbleWithDescendingElements");

        header((Arrays.toString(arr)), true);
        bubble.sort(arr);
        header((Arrays.toString(arr)), false);

        assertEquals(arr.length, 10);
        assertArrayEquals(arr, sortedArray);
    }

    /**
     * Rigourous Test :-)
     */
    @Test
    public void randomzizeBubbleArray() {
        banner("randomzizeBubbleArray");

        int[] numbers = getRandomArray(TestConfig.ARRAY_SIZE, TestConfig.RAND_RANGE);

        assertTrue(numbers.length == TestConfig.ARRAY_SIZE);

        header((Arrays.toString(numbers)), true);
        bubble.sort(numbers);
        header((Arrays.toString(numbers)), false);
    }


    @Test
    public void testBubbleSortWithStreams() {
        Integer[] array = {2, 1, 4, 6, 3, 5};
        Integer[] sortedArray = {1, 2, 3, 4, 5, 6};

        bubble.bubbleSortWithStreams(array);

        assertArrayEquals(array, sortedArray);
    }

    @Test
    public void testBubbleOptimizedSort() {
        Integer[] array = {10, 15, 3, 4, 5};
        Integer[] sortedArray = {3, 4, 5, 10, 15};

        bubble.optimizedBubbleSort(array);

        assertArrayEquals(array, sortedArray);
    }

}
