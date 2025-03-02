package ru.ya;

/*
* Анограма - это слово, которое состоит из тех же букв, но в другом порядке. Таким образом, если мы отсортируем оба
* слова, то они будут идентичными, если одно является анаграммой другого.
*
* Когда мы вычитаем 'a' из символа, например, 'b', мы фактически переводим символ в его позицию в алфавите,
* но в числовом виде. Это работает потому, что символы в кодировке ASCII (и других кодировках, таких как UTF-8)
* имеют определенные числовые значения.
*/

public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false; // Если длины строк разные, они не могут быть анаграммами
        }

        int[] counts = new int[26]; // Массив для подсчета символов (для латинских букв)

        // Подсчитываем частоту символов в строках s и t
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
            counts[t.charAt(i) - 'a']--;
        }

        // Если все элементы массива равны 0, то строки являются анаграммами
        for (int count : counts) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("asddsa", "aaddss"));
    }
}
