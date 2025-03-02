package ru.ya;

import java.util.*;

// Идея алгоритма:
// 1. Используем HashMap для подсчета частоты каждого элемента в массиве nums1.
// 2. Затем проходим по массиву nums2 и для каждого элемента проверяем:
//    - Если элемент присутствует в HashMap и его частота больше нуля, добавляем его в результат.
//    - После этого уменьшаем частоту элемента в HashMap на 1, чтобы учесть возможные дубликаты.


public class IntersectionTwoArraysII {
    public static int[] intersect(int[] nums1, int[] nums2) {
        // Создаем карту для хранения частоты элементов из nums1
        Map<Integer, Integer> freq = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        // Заполняем частоты для элементов в nums1
        for (int num : nums1) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Проверяем пересечение с nums2
        for (int num : nums2) {
            if (freq.getOrDefault(num, 0) > 0) {
                result.add(num);
                freq.put(num, freq.get(num) - 1); // Уменьшаем счетчик для учета дубликатов
            }
        }

        // Преобразуем результат в массив
        int[] resArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resArray[i] = result.get(i);
        }

        return resArray;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};

        System.out.println(Arrays.toString(intersect(nums1, nums2))); // Вывод: [2, 2]
    }
}
