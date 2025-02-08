package io.lolotech.exercises;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

public class ConvertSortedArrayToBST {

    /*
    Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.

    Example 1:
    Input: nums = [-10,-3,0,5,9]
    Output: [0,-3,9,-10,null,5]
    Explanation: [0,-10,5,null,-3,null,9] is also accepted:

    Example 2:
    Input: nums = [1,3]
    Output: [3,1]
    Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.
     */

    public static void main(String[] args) throws JsonProcessingException {
        printTree(sortedArrayToBST(new int[]{-10, -3, 0, 5, 9}));
        printTree(sortedArrayToBST(new int[]{-10, -3, 0, 5, 9, 10}));
        printTree(sortedArrayToBST(new int[]{-10, -3, 0, 5, 9, 10, 11}));
        printTree(sortedArrayToBST(new int[]{1, 3}));
    }

    private static TreeNode sortedArrayToBST(int[] array) {
        return buildBST(array, 0, array.length - 1);
    }

    //TC: O(n)
    //SC: O(n log n) - recursion stack
    private static TreeNode buildBST(int[] array, int left, int right) {
        if (left > right) {
            return null;
        }

        int middle = left + (right - left) / 2;
        TreeNode root = new TreeNode(array[middle]);

        root.setLeft(buildBST(array, left, middle - 1));
        root.setRight(buildBST(array, middle + 1, right));

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
        Integer value;
        TreeNode left;
        TreeNode right;

        public TreeNode(Integer value) {
            this.value = value;
        }
    }
}
