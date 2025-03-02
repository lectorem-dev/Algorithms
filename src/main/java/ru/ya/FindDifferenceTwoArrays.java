package ru.ya;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
* Идея решения заключается в использовании HashSet для хранения уникальных элементов из двух массивов. Мы преобразуем
* массивы в множества, что позволяет эффективно проверять элементы, отсутствующие в другом массиве. Затем, за два
* прохода, добавляем элементы из первого множества, которых нет во втором, и наоборот. Это минимизирует количество
* проверок и позволяет работать за время O(n + m), где n и m — длины массивов.
*/

public class FindDifferenceTwoArrays {
    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        // Создаем HashSet для уникальных элементов
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        for (int num : nums1) {
            set1.add(num);
        }

        for (int num : nums2) {
            set2.add(num);
        }

        // Найдем пересечение
        HashSet<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);

        // Результаты
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        // Для nums1 исключаем пересечение
        for (int num : set1) {
            if (!intersection.contains(num)) {
                list1.add(num);
            }
        }

        // Для nums2 исключаем пересечение
        for (int num : set2) {
            if (!intersection.contains(num)) {
                list2.add(num);
            }
        }

        result.add(list1);
        result.add(list2);

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {2, 4, 6};
        System.out.println(findDifference(nums1, nums2)); // [[1, 3], [4, 6]]

        int[] nums1_2 = {1, 2, 3, 3};
        int[] nums2_2 = {1, 1, 2, 2};
        System.out.println(findDifference(nums1_2, nums2_2)); // [[3], []]
    }
}
