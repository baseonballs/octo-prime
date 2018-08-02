package io.octoprime.algo.sort;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.Arrays;

import static io.octoprime.algo.ds.DataStructure.getRandomArray;

/**
 * Unit test for simple App.
 */
public class BubbleSortTest
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public BubbleSortTest(String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( BubbleSortTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testBubble()
    {
        System.out.println("testBubble.");
        assertTrue( true );

        BubbleSort bubble = new BubbleSort();

        int[] numbers = getRandomArray(10, 100);

        assertTrue( numbers.length == 10);


        System.out.println("Input array: ");
        System.out.println(Arrays.toString(numbers));

        System.out.println("Sorted array: ");
        bubble.sort(numbers);
        System.out.println(Arrays.toString(numbers));

    }
}
