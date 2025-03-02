package ru.ya;

import java.util.Arrays;

public class MoveZeroes {
    public static void moveZeroes(int[] nums) {
        int j = 0;  // Указатель для позиции следующего ненулевого элемента

        // Проходим по массиву
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                // Если элемент ненулевой, меняем его местами с nums[j]
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;  // Увеличиваем указатель для следующего ненулевого элемента
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);  // Вызываем метод для перемещения нулей
        System.out.println(Arrays.toString(nums));  // Печатаем результат
    }
}
