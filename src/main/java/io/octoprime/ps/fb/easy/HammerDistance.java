package io.octoprime.ps.fb.easy;

public class HammerDistance {

    /**
     * @param a
     * @param b
     * @return
     */
    private static int hammingDistance0(int a, int b) {
        int n = a ^ b;
        int result = 0;
        while (n != 0) {
            result += (n & 1);
            n = n >>> 1;
        }
        return result;
    }

    /**
     * @param x
     * @param y
     * @return
     */
    private static int hammingDistance2(int x, int y) {
        int count = 0;
        while ((x + y) != 0) {
            if ((x % 2) != (y % 2)) count++;
            x >>= 1;
            y >>= 1;
        }
        return count;
    }

    /**
     * @param a
     * @param b
     * @return
     */
    private static int hammerDistance(int a, int b) {
        int z = a ^ b;
        int count = 0;

        while (z > 0) {
            z &= z - 1;
            count++;
        }
        return count;
    }


    /**
     * write a function that takes an integer and retursn the number of '1' bits it has; also known as the
     * hammer weight;
     *
     * @param a
     * @param b
     * @return
     */
    private static int hammerWeight(int n) {
        int count = 0;

        int b = 32;

        while (b-- > 0) {
            if ((n & 1) == 1)
                count++;

            n >>= 1;
        }

        return count;
    }



    /**
     * @param arg
     */
    public static void main(String[] arg) {

        System.out.println("hammerDistance::distance: " + hammerDistance(1, 4));
        System.out.println("hammingDistance2::distance: " + hammingDistance2(1, 4));
        System.out.println("hammingDistance0::distance: " + hammingDistance0(1, 4));

        System.out.println("weight: " + hammerWeight(128));
    }
}
