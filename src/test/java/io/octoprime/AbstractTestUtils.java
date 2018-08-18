package io.octoprime;

/**
 *
 */
public abstract class AbstractTestUtils {

    protected static int[] _NUMBERS = new int[]{88, 5, 13, 2, 10, 19, 28, 33, 50, 92};

    /**
     * test declorator using simple banner with name of method.
     *
     * @param name
     */
    protected void banner(String name) {
        System.out.println("---------: ");
        System.out.println(String.format("%s: ", name));
        System.out.println("---------: ");
    }

    /**
     * array declarator for arrays.
     *
     * @param s           the string to be used.
     * @param beforeLabel add the before label flag.
     */
    protected void header(String s, boolean beforeLabel) {
        if (beforeLabel)
            System.out.println("before array: " + s);
        else System.out.println("after  array: " + s);
    }
}
