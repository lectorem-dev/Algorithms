package ru.ya;

class NodeTree {
    int val;
    NodeTree left;
    NodeTree right;
    NodeTree() {}
    NodeTree(int val) { this.val = val; }
    NodeTree(int val, NodeTree left, NodeTree right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class SymmetricTree {
    public static boolean isSymmetric(NodeTree root) {
        if (root == null) return true; // Пустое дерево симметрично
        return isMirror(root.left, root.right);
    }

    private static boolean isMirror(NodeTree left, NodeTree right) {
        if (left == null && right == null) return true; // Оба узла пустые → симметрия
        if (left == null || right == null) return false; // Один пустой, другой нет → несимметрично
        if (left.val != right.val) return false; // Значения не совпадают → несимметрично

        // Рекурсивно проверяем симметрию
        return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }

    public static void main(String[] args) {
        NodeTree tree = new NodeTree(1,
                new NodeTree(2, new NodeTree(3), new NodeTree(4)),
                new NodeTree(2, new NodeTree(4), new NodeTree(3))
        );

        System.out.println(isSymmetric(tree)); // true (дерево симметрично)
    }
}