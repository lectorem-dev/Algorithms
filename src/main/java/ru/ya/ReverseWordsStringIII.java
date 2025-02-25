package ru.ya;

public class ReverseWordsStringIII {
    public static String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int left = 0;

        for (int right = 0; right <= chars.length; right++) {
            if (right == chars.length || chars[right] == ' ') {
                reverse(chars, left, right - 1);
                left = right + 1;
            }
        }

        return new String(chars);
    }

    private static void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left++] = chars[right];
            chars[right--] = temp;
        }
    }

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        System.out.println(reverseWords(s));
    }
}
