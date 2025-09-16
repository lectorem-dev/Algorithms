package ru.ya.warm.up;

import java.util.Scanner;

/*
* Дана последовательность целых чисел. Необходимо найти минимально возможное произведение пары элементов
*  последовательности. (пара - два каких-то элемента, не обязательно подряд идущие). Например, для последовательности
*  чисел 9 4 2 5 3 ответ будет 6.
*
* */

public class MinProductPair {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); String[] input = sc.nextLine().trim().split("\\s+");

        int[] arr = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        // Решение отсюда
        if (arr.length < 2) {
            System.out.println("Недостаточно элементов");
            return;
        }

        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE; // Два наибольших числа
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE; //  Два наименьших числа

        for (int x : arr) {
            // обновляем максимумы
            if (x > max1) {
                max2 = max1;
                max1 = x;
            } else if (x > max2) {
                max2 = x;
            }

            // обновляем минимумы
            if (x < min1) {
                min2 = min1;
                min1 = x;
            } else if (x < min2) {
                min2 = x;
            }
        }

        // Возможные кандидаты для минимального произведения
        long candidate1 = (long) max1 * min1; // самое большое * самое маленькое
        long candidate2 = (long) min1 * min2; // два минимальных
        long candidate3 = (long) max1 * max2; // два максимальных

        long answer = Math.min(candidate1, Math.min(candidate2, candidate3));

        System.out.println(answer);
    }
}