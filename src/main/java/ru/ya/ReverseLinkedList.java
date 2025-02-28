package ru.ya;

import ru.ya.structures.ListNode;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;    // Предыдущий узел (изначально null)
        ListNode current = head; // Текущий узел

        while (current != null) {
            ListNode nextNode = current.next; // Сохраняем ссылку на следующий узел
            current.next = prev;  // Разворачиваем ссылку (текущий указывает на предыдущий)
            prev = current;       // Двигаем prev вперёд (становится текущим)
            current = nextNode;   // Двигаем current вперёд
        }

        return prev; // Новый head списка (последний элемент в исходном списке)
    }

    public static void main(String[] args) {
        // Создаём список head = [1,2,3,4,5]
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ReverseLinkedList solution = new ReverseLinkedList();
        ListNode reversedHead = solution.reverseList(head);

        // Выводим результат
        while (reversedHead != null) {
            System.out.print(reversedHead.val + " ");
            reversedHead = reversedHead.next;
        }
        // Ожидаемый вывод: 5 4 3 2 1
    }
}
