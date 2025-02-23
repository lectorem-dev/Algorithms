package ru.ya;

public class SequentialCharacters {
    public static int sequentialCharacters(String input) {
        int count = 1;
        int maxCount = 1;

        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == input.charAt(i - 1)) {
                count++;
            } else {
                maxCount = Math.max(maxCount, count);
                count = 1;
            }
        }

         return Math.max(maxCount, count);
    }

    public static void main(String[] args) {
        String input = "cc";

        System.out.println(sequentialCharacters(input));
    }
}
