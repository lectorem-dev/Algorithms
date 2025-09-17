package ru.ya.warm.up;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/*
* На клеточном поле, размером NxM (2 ≤ N, M ≤ 250) сидит Q (0 ≤ Q ≤ 10000) блох в различных клетках. «Прием пищи»
* блохами возможен только в кормушке — одна из клеток поля, заранее известная. Блохи перемещаются по полю странным
* образом, а именно, прыжками, совпадающими с ходом обыкновенного шахматного коня. Длина пути каждой блохи до кормушки
* определяется как количество прыжков. Определить минимальное значение суммы длин путей блох до кормушки или, если
* собраться блохам у кормушки невозможно, то сообщить об этом. Сбор невозможен, если хотя бы одна из блох не может
* попасть к кормушке.
*
* Формат ввода
* В первой строке входного файла находится 5 чисел, разделенных пробелом: N, M, S, T, Q.
*
* N, M — размеры доски (отсчет начинается с 1);
* S, T — координаты клетки — кормушки (номер строки и столбца соответственно);
* Q — количество блох на доске.
* Далее Q строк по два числа — координаты каждой блохи.
*
* Формат вывода
* Содержит одно число — минимальное значение суммы длин путей или −1, если сбор невозможен.
*
* Пример 1
* Ввод:
* 2 2 1 1 1
* 2 2
* Вывод:
* -1
*
* Пример 2
* Ввод:
* 4 4 1 1 16
* 1 1
* 1 2
* 1 3
* 1 4
* 2 1
* 2 2
* 2 3
* 2 4
* 3 1
* 3 2
* 3 3
* 3 4
* 4 1
* 4 2
* 4 3
* 4 4
* Вывод:
* 42
* */

public class Fleas {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // размеры доски
        int M = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken()) - 1; // номер строки кормушки, 0-индексация
        int T = Integer.parseInt(st.nextToken()) - 1; // номер столбца кормушки, 0-индексация
        int Q = Integer.parseInt(st.nextToken()); // количество блох на доске

        // Шахматная доска
        int[][] dist = new int[N][M];
        for (int[] row : dist) Arrays.fill(row, -1);

        // Q строк по два числа — координаты каждой блохи
        int[][] fleas = new int[Q][2];
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            fleas[i][0] = Integer.parseInt(st.nextToken()) - 1;
            fleas[i][1] = Integer.parseInt(st.nextToken()) - 1;
        }

        // BFS от кормушки
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{S, T});
        dist[S][T] = 0;

        // Блохи по сути кони идущие к водопою
        int[][] moves = { {1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1},{-2,1},{-1,2} };

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1];

            for (int[] m : moves) {
                int nx = x + m[0];
                int ny = y + m[1];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && dist[nx][ny] == -1) {
                    dist[nx][ny] = dist[x][y] + 1;
                    queue.add(new int[]{nx, ny});
                }
            }
        }

        long result = 0;
        boolean possible = true;

        for (int i = 0; i < Q; i++) {
            int fx = fleas[i][0];
            int fy = fleas[i][1];

            if (dist[fx][fy] == -1) {
                possible = false;
                break;
            } else {
                result += dist[fx][fy];
            }
        }

        System.out.println(possible ? result : -1);
    }
}
