package ru.ya;

public class FindIndexFirstOccurrenceString {
    public static int strStr(String haystack, String needle) {
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "aaaasssosalloh";
        String needle = "sosal";
        System.out.println(strStr(haystack, needle));
    }
}
