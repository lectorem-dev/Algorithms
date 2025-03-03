package ru.ya;

import java.util.Arrays;

public class SquaresSortedArray {
    public static int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        int left = 0, right = n - 1, index = n - 1;

        while (left <= right) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];

            if (leftSquare > rightSquare) {
                result[index--] = leftSquare;
                left++;
            } else {
                result[index--] = rightSquare;
                right--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-7, -3, 2, 3, 11};

        System.out.println(Arrays.toString(sortedSquares(nums)));
    }
}
