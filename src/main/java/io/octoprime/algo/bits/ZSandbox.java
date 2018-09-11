package io.octoprime.algo.bits;

public class ZSandbox {


    class Solution {
        public void moveZeroes(int[] nums) {
            int c = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0)
                    c++;
                if (c != 0 && nums[i] != 0) {
                    nums[i - c] = nums[i];
                    nums[i] = 0;
                }
            }

        }

        public int removeDuplicates(int[] nums) {
            if (nums.length == 0) return 0;
            int i = 0;
            for (int j = 1; j < nums.length; j++) {
                if (nums[j] != nums[i]) {
                    i++;
                    nums[i] = nums[j];
                }
            }
            return i + 1;
        }

        public int missingNumber(int[] nums) {
            int sum = 0;
            for (int i = 0; i < nums.length; i++)
                sum += nums[i];

            int total = nums.length * (nums.length + 1) / 2;
            return total - sum;
        }

    }

    public static void main(String[] args) {

        int n = -3;

        int c = 0;
        while (n > 0) {
            c++;
            n &= n - 1;
        }

        n = 5;
        c = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) c++;
            n >>>= 1;
        }
        System.out.print(String.format("number of bits for %d: %s", n, c));
    }
}
