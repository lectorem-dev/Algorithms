package ru.ya;

public class IsSubsequence {
    public static boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;  // Двигаем указатель s, если символ совпал
            }
            j++;  // Всегда двигаем указатель t
        }
        return i == s.length();  // Если i достиг конца s, значит s - подпоследовательность t
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgdc"));  // true
        System.out.println(isSubsequence("axc", "ahbgdc"));  // false
    }
}
