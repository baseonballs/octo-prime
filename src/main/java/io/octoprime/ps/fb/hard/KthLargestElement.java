package io.octoprime.ps.fb.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElement {

    class Container {
        int index;
        int value;

        public Container(int i, int v) {
            index = i;
            value = v;
        }
    }

    class ContainerComparator implements Comparator<Container> {
        public int compare(Container p1, Container p2) {
            return p2.value - p1.value;
        }
    }

    // O(n log k ) ; because it uses the heap sort.
    public int findKthLargest(int[] nums, int k) {

        if (nums == null || nums.length == 0) {
            return -1;
        }

        PriorityQueue<Container> heap = new PriorityQueue<>(new ContainerComparator());

        for (int i = 0; i < nums.length; i++) {
            heap.add(new Container(i, nums[i]));
        }

        for (int i = 0; i < k - 1; i++) {
            heap.poll();
        }

        return heap.peek().value;
    }


    public int findKthLargestOptimized(int[] nums, int k) {
        int i;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        for (i = 0; i < Math.min(k, nums.length); i++)
            pq.add(nums[i]);

        for (int j = k; j < nums.length; j++) {
            if (nums[j] > pq.peek()) {
                pq.remove();
                pq.add(nums[j]);
            }
        }
        return pq.peek();
    }

}
