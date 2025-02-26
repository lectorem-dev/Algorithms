package ru.ya;

import ru.ya.structures.*;

public class SymmetricTree {
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true; // Пустое дерево симметрич`но
        return isMirror(root.left, root.right);
    }

    private static boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true; // Оба узла пустые → симметрия
        if (left == null || right == null) return false; // Один пустой, другой нет → несимметрично
        if (left.val != right.val) return false; // Значения не совпадают → несимметрично

        // Рекурсивно проверяем симметрию
        return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1,
                new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                new TreeNode(2, new TreeNode(4), new TreeNode(3))
        );

        System.out.println(isSymmetric(tree)); // true (дерево симметрично)
    }
}