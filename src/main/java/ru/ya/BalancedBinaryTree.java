package ru.ya;

import ru.ya.structures.TreeNode;

public class BalancedBinaryTree {
    private static int heightDiff(TreeNode root, int[] diff) {
        if (root == null) { return 0; }

        int left = heightDiff(root.left, diff);
        int right = heightDiff(root.right, diff);

        diff[0] = Math.max(diff[0], Math.abs(left - right));

        return Math.max(left, right) + 1;
    }

    public static boolean isBalanced(TreeNode root) {
        int[] diff = new int[1];
        heightDiff(root, diff);

        return diff[0] <= 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        //         1
        //        / \
        //       2   3
        //      / \   \
        //     4   5   6
        //    /
        //   7
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.left.left = new TreeNode(7);

        System.out.println(isBalanced(root));
    }
}
