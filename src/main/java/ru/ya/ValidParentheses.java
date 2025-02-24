package ru.ya;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class ValidParentheses {
    private static final Map<Character, Character> OPEN_CLOSE = Map.of(
            '(', ')',
            '[', ']',
            '{', '}'
    );

    public static boolean validParentheses(String input) {
        // Если строка содержит нечетое количество скобок, она неправильная
        if (input.length() % 2 != 0) { return false; }

        // Считаем скобки с помощию стека
        Deque<Character> stack = new ArrayDeque<>();

        // Сколзящие окно, проверяет текущий и предидущий символ
        for (char current : input.toCharArray()) {
            if (OPEN_CLOSE.containsKey(current)) {
                stack.push(current); // Открывающая скобка -> в стек
            } else {
                if (stack.isEmpty() || OPEN_CLOSE.get(stack.pop()) != current) {
                    return false; // Ошибка: либо стек пуст, либо скобки не совпали
                }
            }
        }

        return stack.isEmpty(); // Если стек пустой, значит все скобки закрыты корректно
    }

    public static void main(String[] args) {
        String input = "((()))";
        System.out.println(validParentheses(input)); // Ожидается true
    }
}
