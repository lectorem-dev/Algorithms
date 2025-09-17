package ru.ya.warm.up;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
* На стандартной шахматной доске (8х8) живут 2 шахматных коня: Красный и Зелёный. Обычно они беззаботно скачут по
* просторам доски, пощипывая шахматную травку, но сегодня особенный день: у Зелёного коня День Рождения. Зеленый конь
* решил отпраздновать это событие вместе с Красным. Но для осуществления этого прекрасного плана им нужно оказаться на
* одной клетке. Заметим, что Красный и Зелёный шахматные кони сильно отличаются от черного с белым: они ходят не по
* очереди, а одновременно, и если оказываются на одной клетке, никто никого не съедает. Сколько ходов им потребуется,
* чтобы насладиться праздником?
*
* Формат ввода
* На вход программы поступают координаты коней, записанные по стандартным шахматным правилам (т.е. двумя символами -
* маленькая латинская буква (от a до h) и цифра (от 1 до 8), задающие столбец и строку соответственно).
*
* Формат вывода
* Требуется вывести наименьшее необходимое количество ходов, либо число -1, если кони не могут встретиться.
*
* https://coderun.yandex.ru/problem/two-horses
*
* */

public class TwoHorses {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        /*
        Пример ввода и вывода числа n, где -10^9 < n < 10^9:
        int n = Integer.parseInt(reader.readLine());
        writer.write(String.valueOf(n));
        */

        reader.close();
        writer.close();
    }
}
