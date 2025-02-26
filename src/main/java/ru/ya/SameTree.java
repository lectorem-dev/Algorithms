package ru.ya;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class SameTree {
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true; // Если оба пустые - они идентичны
        if (p == null || q == null) return false;

        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();

        queue1.add(p);
        queue2.add(q);

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();

            if (node1.val != node2.val) return false;

            // A ^ B возвращает true, если A и B разные.
            if ((node1.left == null) ^ (node2.left == null)) return false;
            if ((node1.right == null) ^ (node2.right == null)) return false;

            if (node1.left != null) {
                queue1.add(node1.left);
                queue2.add(node2.left);
            }
            if (node1.right != null) {
                queue1.add(node1.right);
                queue2.add(node2.right);
            }
        }

        return queue1.isEmpty() && queue2.isEmpty();
    }

    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(1,
                new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3, new TreeNode(6), new TreeNode(7))
        );

        TreeNode tree2 = new TreeNode(1,
                new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3, new TreeNode(6), new TreeNode(7))
        );

        System.out.println(isSameTree(tree1, tree2));
    }
}