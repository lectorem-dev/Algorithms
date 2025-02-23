package ru.ya;

import java.util.Scanner;

public class MiddleNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        // Используем ручные проверки, чтобы избежать лишних вызовов Math.max и Math.min
        int max = (a > b) ? ((a > c) ? a : c) : ((b > c) ? b : c);
        int min = (a < b) ? ((a < c) ? a : c) : ((b < c) ? b : c);
        int middle = a + b + c - max - min;

        System.out.println(middle);
    }
}

