package ru.ya;

public class GuessNumberHigherLower {
    // Пример метода guess, который можно использовать для тестов
    private int pick = 6;  // Допустим, это число, которое нужно угадать

    public int guess(int num) {
        if (num < pick) {
            return 1;  // Число больше
        } else if (num > pick) {
            return -1;  // Число меньше
        } else {
            return 0;  // Угадали
        }
    }

    public int guessNumber(int n) {
        int left = 1, right = n;

        while (left <= right) {
            int mid = left + (right - left) / 2;  // Чтобы избежать переполнения
            int result = guess(mid);

            if (result == 0) {
                return mid;  // Число угадано
            } else if (result == 1) {
                left = mid + 1;  // Если наш выбор меньше, сужаем диапазон
            } else {
                right = mid - 1;  // Если наш выбор больше, сужаем диапазон
            }
        }

        return -1;  // Не должно быть достигнуто, если входные данные корректны
    }

    public static void main(String[] args) {
        GuessNumberHigherLower solution = new GuessNumberHigherLower();
        System.out.println(solution.guessNumber(10));  // Ожидаемый результат: 6
    }
}
