package ru.ya;

import java.util.Map;

public class RomanToInteger {
    private static final Map<Character, Integer> NUMBERS = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000
    );

    public static int romanToInteger(String roman) {
        int sum = 0;
        int prevValue = 0;

        for (int i = roman.length() - 1; i >= 0; i--) {
            int currentValue = NUMBERS.get(roman.charAt(i));

            if (currentValue < prevValue) {
                sum -= currentValue;
            } else {
                sum += currentValue;
            }

            prevValue = currentValue;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(romanToInteger("MCMXCIV")); // 1994
    }
}
