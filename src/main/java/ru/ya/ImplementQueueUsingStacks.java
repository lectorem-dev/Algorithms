package ru.ya;

import java.util.Stack;

// При переносе элементов из stack1 в stack2, порядок инвертируется, и теперь stack2 работает как обычная очередь.
// Зачем это нужно совершенно непонятно, но переворачивая стеки реально можно реализовать FIFO

public class ImplementQueueUsingStacks {
    private Stack<Integer> stack1; // Основной стек для добавления элементов
    private Stack<Integer> stack2; // Вспомогательный стек для удаления элементов

    public ImplementQueueUsingStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Добавление элемента в очередь
    public void push(int x) {
        stack1.push(x);
    }

    // Удаление элемента из начала очереди
    public int pop() {
        shiftStacks();
        return stack2.pop();
    }

    // Получение элемента из начала очереди без удаления
    public int peek() {
        shiftStacks();
        return stack2.peek();
    }

    // Проверка, пуста ли очередь
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    // Перемещение элементов из stack1 в stack2 при необходимости
    private void shiftStacks() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
    }

    public static void main(String[] args) {
        ImplementQueueUsingStacks myQueue = new ImplementQueueUsingStacks();
        myQueue.push(1);   // очередь: [1]
        myQueue.push(2);   // очередь: [1, 2]
        System.out.println(myQueue.peek()); // 1
        System.out.println(myQueue.pop());  // 1, очередь: [2]
        System.out.println(myQueue.empty()); // false
    }
}
