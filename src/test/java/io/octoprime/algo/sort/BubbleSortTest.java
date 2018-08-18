package io.octoprime.algo.sort;

import io.octoprime.AbstractTestUtils;
import io.octoprime.TestConfig;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static io.octoprime.algo.ds.DataStructure.getRandomArray;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit test for simple App.
 */
public class BubbleSortTest extends AbstractTestUtils {

    private static BubbleSort bubble = new BubbleSort();

    @Test
    void testBasic() {

        Integer[] array = {2, 1, 4, 6, 3, 5};
        Integer[] sortedArray = {1, 2, 3, 4, 5, 6};

        banner("testBasic");

        header((Arrays.toString(array)), true);
        bubble.bubbleSortWithStreams(array);
        header((Arrays.toString(array)), false);

        assertArrayEquals(array, sortedArray);
    }


    @Test
    public void testAsending() {
        assertTrue(_NUMBERS.length == TestConfig.ARRAY_SIZE);

        bubble.sort(_NUMBERS);

        /*
        Must have at least two values in the array to assert natural order.
         */
        if (_NUMBERS.length > 1)
            for (int i = 0; i < _NUMBERS.length - 1; i++) {
                assertTrue(_NUMBERS[i] <= _NUMBERS[i + 1]);
            }
    }

    /**
     * Rigourous Test :-)
     */
    @Test
    public void randomziedArray() {
        System.out.println("testBubble.");
        assertTrue(true);

        int[] numbers = getRandomArray(TestConfig.ARRAY_SIZE, TestConfig.RAND_RANGE);

        assertTrue(numbers.length == TestConfig.ARRAY_SIZE);

        System.out.println("Input array: ");
        System.out.println(Arrays.toString(numbers));

        System.out.println("Sorted array: ");
        bubble.sort(numbers);
        System.out.println(Arrays.toString(numbers));
    }


    @Test
    public void testBubbleSort() {
        int[] array = {2, 1, 4, 6, 3, 5};
        int[] sortedArray = {1, 2, 3, 4, 5, 6};

        bubble.sort(array);

        assertArrayEquals(array, sortedArray);
    }

    @Test
    public void testBubbleSortWithStreams() {
        Integer[] array = {2, 1, 4, 6, 3, 5};
        Integer[] sortedArray = {1, 2, 3, 4, 5, 6};

        bubble.bubbleSortWithStreams(array);

        assertArrayEquals(array, sortedArray);
    }

    @Test
    public void testOptimizedBubbleSort() {
        Integer[] array = {10, 15, 3, 4, 5};
        Integer[] sortedArray = {3, 4, 5, 10, 15};

        bubble.optimizedBubbleSort(array);

        assertArrayEquals(array, sortedArray);
    }

}
