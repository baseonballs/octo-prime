package io.octoprime.ps.fb.hard;

import java.util.Stack;

public class MaxRectStack {

    public int maxRect(char[][] input) {
        if (input.length == 0)
            return 0;

        int temp[] = new int[input[0].length];

        int maxArea = 0;
        int area = 0;
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < temp.length; j++) {
                if (input[i][j] - '0' == 0) {
                    temp[j] = 0;
                } else {
                    temp[j] += input[i][j] - '0';
                }
            }
            area = maxHist(temp);
            if (area > maxArea) {
                maxArea = area;
            }
        }
        return maxArea;
    }

    public int maxHist(int input[]) {
        Stack<Integer> stack = new Stack<Integer>();

        int max_area = 0;
        int top;
        int area_top;

        int i = 0;
        while (i < input.length) {
            if (stack.empty() || input[stack.peek()] <= input[i])
                stack.push(i++);
            else {
                top = stack.peek();
                stack.pop();
                area_top = input[top] * (stack.empty() ? i : i - stack.peek() - 1);

                if (max_area < area_top)
                    max_area = area_top;
            }
        }

        while (!stack.empty()) {
            top = stack.peek();
            stack.pop();
            area_top = input[top] * (stack.empty() ? i : i - stack.peek() - 1);

            if (max_area < area_top)
                max_area = area_top;
        }

        return max_area;
    }

}
