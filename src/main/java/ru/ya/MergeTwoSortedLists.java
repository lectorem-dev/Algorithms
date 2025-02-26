package ru.ya;

import ru.ya.structures.*;

public class MergeTwoSortedLists {
    static public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0); // Фиктивный узел для удобства
        ListNode current = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        // Добавляем оставшиеся элементы из одного из списков
        if (list1 != null) {
            current.next = list1;
        } else if (list2 != null) {
            current.next = list2;
        }

        return dummy.next; // Возвращаем голову нового списка
    }

    private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(3, new ListNode(5))); // 1 -> 3 -> 5
        ListNode list2 = new ListNode(2, new ListNode(4, new ListNode(6))); // 2 -> 4 -> 6

        printList(mergeTwoLists(list1, list2));
    }
}
