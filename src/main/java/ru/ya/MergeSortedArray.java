package ru.ya;

import java.util.Arrays;

public class MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] tmp = Arrays.copyOf(nums1, m);

        int indexM = 0;
        int indexN = 0;
        int index = 0;

        while (indexM < m && indexN < n) {
            if (tmp[indexM] < nums2[indexN]) {
                nums1[index++] = tmp[indexM++];
            } else {
                nums1[index++] = nums2[indexN++];
            }
        }

        // Если остались элементы в tmp
        while (indexM < m) { nums1[index++] = tmp[indexM++]; }

        // Если остались элементы в nums2
        while (indexN < n) { nums1[index++] = nums2[indexN++]; }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 3;
        int n = 3;

        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
}
