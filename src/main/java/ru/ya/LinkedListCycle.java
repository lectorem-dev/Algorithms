package ru.ya;

import ru.ya.structures.ListNode;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false; // Пустой список или один элемент без цикла
        }

        ListNode slow = head;  // Черепаха
        ListNode fast = head;  // Заяц

        while (fast != null && fast.next != null) {
            slow = slow.next;         // Двигаемся на 1 шаг
            fast = fast.next.next;    // Двигаемся на 2 шага

            if (slow == fast) {       // Если встретились — цикл есть
                return true;
            }
        }

        return false; // Дошли до конца, цикла нет
    }

    public static void main(String[] args) {
        // Пример: head = [3,2,0,-4], pos = 1
        ListNode head = new ListNode(3);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(0);
        ListNode fourth = new ListNode(-4);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = second; // Создаём цикл

        LinkedListCycle solution = new LinkedListCycle();
        System.out.println(solution.hasCycle(head)); // Выведет true
    }
}
