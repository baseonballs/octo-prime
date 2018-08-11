package io.octoprime.algo.ds.array;

public class MediamOfTwoSortedArrays2 {

    class Solution1 {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int total = nums1.length + nums2.length;
            if (total % 2 == 0) {
                return (findKth(total / 2 + 1, nums1, nums2, 0, 0) + findKth(total / 2, nums1, nums2, 0, 0)) / 2.0;
            } else {
                return findKth(total / 2 + 1, nums1, nums2, 0, 0);
            }
        }

        public int findKth(int k, int[] nums1, int[] nums2, int s1, int s2) {
            if (s1 >= nums1.length)
                return nums2[s2 + k - 1];

            if (s2 >= nums2.length)
                return nums1[s1 + k - 1];

            if (k == 1)
                return Math.min(nums1[s1], nums2[s2]);

            int m1 = s1 + k / 2 - 1;
            int m2 = s2 + k / 2 - 1;

            int mid1 = m1 < nums1.length ? nums1[m1] : Integer.MAX_VALUE;
            int mid2 = m2 < nums2.length ? nums2[m2] : Integer.MAX_VALUE;

            if (mid1 < mid2) {
                return findKth(k - k / 2, nums1, nums2, m1 + 1, s2);
            } else {
                return findKth(k - k / 2, nums1, nums2, s1, m2 + 1);
            }
        }
    }

    class Solution2 {
        public double findMedianSortedArrays(int A[], int B[]) {
            int m = A.length;
            int n = B.length;

            if ((m + n) % 2 != 0) // odd
                return (double) findKth(A, B, (m + n) / 2, 0, m - 1, 0, n - 1);
            else { // even
                return (findKth(A, B, (m + n) / 2, 0, m - 1, 0, n - 1)
                        + findKth(A, B, (m + n) / 2 - 1, 0, m - 1, 0, n - 1)) * 0.5;
            }
        }

        // leetcode: https://www.programcreek.com/2012/12/leetcode-median-of-two-sorted-arrays-java/
        public int findKth(int A[], int B[], int k,
                           int aStart, int aEnd, int bStart, int bEnd) {

            int aLen = aEnd - aStart + 1;
            int bLen = bEnd - bStart + 1;

            // Handle special cases
            if (aLen == 0)
                return B[bStart + k];
            if (bLen == 0)
                return A[aStart + k];
            if (k == 0)
                return A[aStart] < B[bStart] ? A[aStart] : B[bStart];

            int aMid = aLen * k / (aLen + bLen); // a's middle count
            int bMid = k - aMid - 1; // b's middle count

            // make aMid and bMid to be array index
            aMid = aMid + aStart;
            bMid = bMid + bStart;

            if (A[aMid] > B[bMid]) {
                k = k - (bMid - bStart + 1);
                aEnd = aMid;
                bStart = bMid + 1;
            } else {
                k = k - (aMid - aStart + 1);
                bEnd = bMid;
                aStart = aMid + 1;
            }

            return findKth(A, B, k, aStart, aEnd, bStart, bEnd);
        }
    }

}
