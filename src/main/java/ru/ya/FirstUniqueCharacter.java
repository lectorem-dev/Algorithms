package ru.ya;

public class FirstUniqueCharacter {
    public int firstUniqChar(String s) {
        // Шаг 1: Построим частотный словарь
        // Массив для подсчета частоты символов ('a' - 'z')
        int[] freq = new int[26];

        // Проходим по строке и считаем частоту каждого символа
        // Для каждого символа строки увеличиваем соответствующий индекс в массиве freq
        // Индекс рассчитывается как разница между символом и 'a'
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Шаг 2: Ищем первый неповторяющийся символ
        // Проходим по строке и для каждого символа проверяем его частоту в массиве freq
        // Если частота символа равна 1, то этот символ уникален, возвращаем его индекс
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;  // Возвращаем индекс первого неповторяющегося символа
            }
        }

        // Шаг 3: Если неповторяющийся символ не найден, возвращаем -1
        return -1;
    }

    public static void main(String[] args) {
        FirstUniqueCharacter solution = new FirstUniqueCharacter();

        // Тесты
        // Тест 1: Входная строка "leetcode", первый уникальный символ 'l' с индексом 0
        System.out.println(solution.firstUniqChar("leetcode"));  // 0

        // Тест 2: Входная строка "loveleetcode", первый уникальный символ 'v' с индексом 2
        System.out.println(solution.firstUniqChar("loveleetcode"));  // 2

        // Тест 3: Входная строка "aabb", нет уникальных символов, поэтому -1
        System.out.println(solution.firstUniqChar("aabb"));  // -1
    }
}
