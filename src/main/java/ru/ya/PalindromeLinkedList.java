package ru.ya;

import ru.ya.structures.ListNode;

public class PalindromeLinkedList {
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true; // Если список пустой или содержит один элемент, это палиндром.
        }

        // Найдем середину списка с помощью двух указателей
        ListNode slow = head;
        ListNode fast = head;

        // Двигаем fast в два раза быстрее, чем slow, чтобы fast дошел до конца
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Переворачиваем вторую половину списка
        ListNode secondHalf = reverse(slow);

        // Сравниваем первую и вторую половины списка
        ListNode firstHalf = head;
        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }

    // Метод для реверсирования списка
    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        // Создаём список head = [1, 2, 2, 1]
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        System.out.println(isPalindrome(head));
    }
}
