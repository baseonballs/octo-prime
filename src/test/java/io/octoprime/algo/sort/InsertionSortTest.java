package io.octoprime.algo.sort;

import io.octoprime.AbstractTestUtils;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Unit test for simple App.
 */
public class InsertionSortTest extends AbstractTestUtils {

    private static BubbleSort _bubbleSort = new BubbleSort();

    @Test
    void testBasic() {
        InsertionSort insertion = new InsertionSort();

        int[] array = {2, 1, 4, 6, 3, 5};
        int[] sortedArray = {1, 2, 3, 4, 5, 6};

        banner("testBasic");

        header((Arrays.toString(array)), true);
        insertion.sort(array);
        header((Arrays.toString(array)), false);

        assertArrayEquals(array, sortedArray);
    }


}
