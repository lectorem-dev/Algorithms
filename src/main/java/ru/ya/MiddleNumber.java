package ru.ya;

public class MiddleNumber {
    public static int middleNumber(int[] numbers) {
        int a = numbers[0];
        int b = numbers[1];
        int c = numbers[2];

        // Используем ручные проверки, чтобы избежать лишних вызовов Math.max и Math.min
        int max = (a > b) ? (Math.max(a, c)) : (Math.max(b, c));
        int min = (a < b) ? (Math.min(a, c)) : (Math.min(b, c));

        return a + b + c - max - min;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3};

        System.out.println(middleNumber(numbers));
    }
}
