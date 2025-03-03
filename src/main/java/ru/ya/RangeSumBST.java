package ru.ya;

import ru.ya.structures.TreeNode;

/*
* Двоичное дерево поиска, где для каждого узла:
*   - Все значения в левом поддереве меньше его значения.
*   - Все значения в правом поддереве больше его значения.
* Когда мы обрабатываем дерево, важно понимать, что если мы знаем, что значение узла больше (или меньше) заданного
* диапазона, мы можем пропустить целые поддеревья. Это позволяет нам оптимизировать поиск и не проходить по всему дереву.
*/

public class RangeSumBST {
    public static int rangeSumBST(TreeNode root, int low, int high) {
        // Если дерево пустое, то возвращаем 0
        if (root == null) {
            return 0;
        }

        int sum = 0;

        // Если значение узла в пределах диапазона, добавляем его к сумме
        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }

        // Если значение узла больше low, рекурсивно обрабатываем левое поддерево
        if (root.val > low) {
            sum += rangeSumBST(root.left, low, high);
        }

        // Если значение узла меньше high, рекурсивно обрабатываем правое поддерево
        if (root.val < high) {
            sum += rangeSumBST(root.right, low, high);
        }

        return sum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(18);

        System.out.println(rangeSumBST(root, 7, 15));  // Вывод: 32
    }
}
