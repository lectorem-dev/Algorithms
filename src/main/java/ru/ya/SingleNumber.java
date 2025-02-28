package ru.ya;

/*
*   Шаг  	Число	Результат (XOR)
*   0 ^ 4	4	    4
*   4 ^ 1	1	    5
*   5 ^ 2	2	    7
*   7 ^ 1	1	    6
*   6 ^ 2	2	    4
*
*   Конечный результат: 4 - это и есть искомое число на массиве {4, 1, 2, 1, 2}
*   Числа, встречающиеся по два раза, обнуляются (a ^ a = 0).
*   Остаётся только одно неповторяющееся число.
*/

public class SingleNumber {
    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num; // Применяем XOR
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println(singleNumber(nums));
    }
}
