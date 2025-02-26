package ru.ya;

import ru.ya.structures.TreeNode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

/*
* 0 ms - Рекурсивный подход. Использует стандартный рекурсивный DFS для вычисления глубины. Это решение оказалось
* самым быстрым (0 ms), так как не требует дополнительных структур данных и выполняется с минимальными накладными
* расходами на память.
*
* 1 ms - maxDepthBFS. Использует очередь (LinkedList) для обхода дерева в ширину. Данный метод эффективен для деревьев
* с равномерной глубиной, но всё равно требует 1 ms из-за дополнительных операций с очередью.
*
* 1 ms - maxDepthDequeBFS. Тот же подход, что и maxDepthBFS, но с использованием ArrayDeque вместо LinkedList для
* повышения производительности. Однако, несмотря на улучшенную работу с очередью, время выполнения остаётся тем же —
* 1 ms, что показывает минимальный выигрыш в данном случае.
*
* 4 ms - maxDepthDequeDFS. Использует ConcurrentLinkedDeque для поиска в глубину. Дека синхронизирована, что добавляет
* накладные расходы на производительность, особенно в многозадачной среде, что приводит к большему времени выполнения
* (4 ms).
*
* 2 ms - maxDepthDFS. Использует обычный стек (LinkedList) для поиска в глубину. Это решение быстрее maxDepthDequeDFS,
* но всё равно немного медленнее, чем другие методы, требующие 2 ms из-за особенностей работы со стеком.
*/

public class MaximumDepthBinaryTree {
    // 0 ms
    public int maxDepth(TreeNode root) {
        // if(root == null)
        // return 0;
        // return Math.max(maxDepth(root.left) , maxDepth(root.right)) + 1;

        return (root == null)? 0 : Math.max(maxDepth(root.left) , maxDepth(root.right)) + 1;
    }

    // 1 ms
    static int maxDepthBFS(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> q = new LinkedList<>(); // Создаём очередь для обхода дерева в ширину
        q.add(root);
        int depth = 0;

        while (!q.isEmpty()) {
            int levelSize = q.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = q.poll();

                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            depth++;
        }

        return depth;
    }

    // 1 ms
    static int maxDepthDequeBFS(TreeNode root) {
        if (root == null) return 0;

        // Используем ArrayDeque для более быстрой работы с очередью
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        int depth = 0;

        while (!q.isEmpty()) {
            int levelSize = q.size();

            // Проходим по всем узлам текущего уровня
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = q.poll();

                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            depth++;
        }

        return depth;
    }


    // 4 ms
    static int maxDepthDequeDFS(TreeNode root) {
        if (root == null) return 0;

        ConcurrentLinkedDeque<TreeNode> deque = new ConcurrentLinkedDeque<>();
        ConcurrentLinkedDeque<Integer> depths = new ConcurrentLinkedDeque<>();

        deque.push(root);
        depths.push(1);
        int maxDepth = 0;

        while (!deque.isEmpty()) {
            TreeNode node = deque.pop();
            int depth = depths.pop();

            maxDepth = Math.max(maxDepth, depth);

            if (node.right != null) {
                deque.push(node.right);
                depths.push(depth + 1);
            }

            if (node.left != null) {
                deque.push(node.left);
                depths.push(depth + 1);
            }
        }

        return maxDepth;
    }

    // 2 ms
    static int maxDepthDFS(TreeNode root) {
        if (root == null) return 0;

        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> depths = new LinkedList<>();

        stack.push(root);
        depths.push(1);
        int maxDepth = 0;

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int depth = depths.pop();

            maxDepth = Math.max(maxDepth, depth);

            if (node.right != null) {
                stack.push(node.right);
                depths.push(depth + 1);
            }

            if (node.left != null) {
                stack.push(node.left);
                depths.push(depth + 1);
            }
        }

        return maxDepth;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        //     12
        //    /  \
        //   8   18
        //  / \
        // 5   11
        root.left = new TreeNode(8);
        root.right = new TreeNode(18);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(11);

        System.out.println(maxDepthBFS(root)); // Поиск в ширину
        System.out.println(maxDepthDFS(root)); // Поиск в губину
    }
}
