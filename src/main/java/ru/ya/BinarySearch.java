package ru.ya;

public class BinarySearch {
    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;  // Вычисляем середину

            if (nums[mid] == target) {
                return mid;  // Если нашли target, возвращаем индекс
            }
            if (nums[mid] < target) {
                left = mid + 1;  // Если target больше, ищем в правой половине
            } else {
                right = mid - 1;  // Если target меньше, ищем в левой половине
            }
        }

        return -1;  // Если не нашли target, возвращаем -1
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(search(nums, 9));
    }
}
