package io.lolotech.exercises;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeMaximumDepth {

    /*
    Given the root of a binary tree, return its maximum depth.
    A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

    Example 1:
    Input: root = [3,9,20,null,null,15,7]
    Output: 3

    Example 2:
    Input: root = [1,null,2]
    Output: 2
     */
    public static void main(String[] args) throws JsonProcessingException {
        TreeNode bs1 = createBinaryTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        TreeNode bs2 = createBinaryTree(new Integer[]{1, null, 2});
        TreeNode bs3 = createBinaryTree(new Integer[]{1, 2, 3, null, 4, null, null, 5, 6, null, 7});
        printTree(bs3);

        System.out.println(maximumDepth2(bs1));
        System.out.println(maximumDepth2(bs2));
        System.out.println(maximumDepth2(bs3));
    }

    //BFS
    //TC: O(n)
    //SC: O(n)
    private static int maximumDepth1(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            while (size-- > 0) {
                var temp = queue.poll();
                if (temp.getLeft() != null) {
                    queue.add(temp.getLeft());
                }
                if (temp.getRight() != null) {
                    queue.add(temp.getRight());
                }
            }
        }


        return depth;
    }

    private static int maxDepth = 0;

    //DFS
    //TC: O(n)
    //SC: O(h) - h = height (the recursion uses a stack)-
    private static int maximumDepth2(TreeNode root) {
        maxDepth = 0;

        dfs(root, 0);

        return maxDepth;
    }

    private static void dfs(TreeNode node, Integer depth) {
        if (node == null) {
            return;
        }

        depth++;
        maxDepth = Math.max(maxDepth, depth);

        dfs(node.getLeft(), depth);
        dfs(node.getRight(), depth);
    }

    private static TreeNode createBinaryTree(Integer[] array) {
        if (array == null || array.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(array[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (i < array.length) {
            TreeNode current = queue.poll();

            if (current != null) {
                if (array[i] != null) {
                    current.left = new TreeNode(array[i]);
                    queue.add(current.left);
                }
                i++;

                if (i < array.length && array[i] != null) {
                    current.right = new TreeNode(array[i]);
                    queue.add(current.right);
                }
                i++;
            }
        }

        return root;
    }

    private static void printTree(TreeNode root) throws JsonProcessingException {
        if (root == null) {
            return;
        }
        System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(root));
    }

    @Getter
    @Setter
    public static class TreeNode {
        Integer val;
        TreeNode left;
        TreeNode right;

        public TreeNode(Integer val) {
            this.val = val;
        }
    }
}
