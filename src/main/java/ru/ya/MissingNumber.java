package ru.ya;

/*
* Так как мы имеем дело с рядом чисел от 0 до N, полезно вспомнить формулу арифметической прогрессии:
* sum_total= (n×(n+1)) / 2
* Недостающее число будет равно разнице между sum_total и фактической суммой элементов массива.
*/

public class MissingNumber {
    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int sumTotal = n * (n + 1) / 2; // Сумма всех чисел от 0 до n
        int sumArray = 0;

        for (int num : nums) {
            sumArray += num; // Суммируем все элементы массива
        }

        return sumTotal - sumArray; // Недостающее число
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(missingNumber(nums));
    }
}
