package ru.ya;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {
    public static int numJewelsInStones(String jewels, String stones) {
        // Преобразуем строку jewels в множество для быстрого поиска
        Set<Character> jewelSet = new HashSet<>();

        // Заполняем множество драгоценных камней
        for (char c : jewels.toCharArray()) {
            jewelSet.add(c);
        }

        int count = 0;
        // Проходим по строке stones и проверяем, если камень драгоценный
        for (char c : stones.toCharArray()) {
            if (jewelSet.contains(c)) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.print(numJewelsInStones("aA", "aAAbbbb"));
    }
}
