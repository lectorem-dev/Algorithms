package ru.ya;

import java.util.ArrayList;
import java.util.List;

/*
* Внутренние элементы вычисляются по формуле:
* C(n, k) = C(n − 1, k − 1) + C(n − 1, k)
* где:
* C(n, k) — элемент в строке n и позиции k.
* C(n - 1, k - 1) — элемент сверху-слева.
* C(n - 1, k) — элемент сверху.
*/

public class PascalTriangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    // Считаем внутренние элементы как сумму двух чисел сверху
                    row.add(triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j));
                }
            }

            triangle.add(row);
        }

        return triangle;
    }

    public static void main(String[] args) {
        int numRows = 5;
        System.out.println(generate(numRows));
    }
}
