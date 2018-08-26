package io.octoprime.algo.bits;

public class BitShifts {


    /**
     * Demonstrate bit shift left which means multiply by power of 2s; for .e.,g 1 << 1 = 2;
     * 1 << 3; moves 1 bit left 3 bits = 2^3 = 8.  each 1 shifted 1 bit is a power of 2 shifted.
     * <p>
     * 00000001 << 1 = 00000010 = 2
     * 00000001 << 2 = 00000010 = 4
     * 00000001 << 3 = 00000100 = 8
     * 11111111 11111111 11111111 11110000 >> 4 = 11111111 11111111 11111111 11111111
     * 0xFFFFFFF0 >> 4 == 0xFFFFFFFF
     * 00001111 11111111 11111111 11111111 >> 4 = 00000000 11111111 11111111 11111111
     * 0x0FFFFFFF >> 4 == 0x00FFFFFF
     */
    private static void ShiftLeft() {
        int n = 7;

        for (int i = 0; i <= n; i++)
            System.out.println(String.format("Shifted: 1 << %d = %d", i, 1 << i));

        int bitmask = 1 << 3;

    }

    private static void useParseInt() {
        /* loops from 5 up to and including 15 */
        for (int b = Integer.parseInt("0101", 2); b <= Integer.parseInt("1111", 2); b++) {
            /* do stuff here */
        }
    }


    public static void main(String[] args) {
        ShiftLeft();
    }
}
