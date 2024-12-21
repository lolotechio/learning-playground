package io.lolotech.udemy.dsa.video208;

import io.lolotech.udemy.dsa.video136.BinarySearchTree;
import io.lolotech.udemy.dsa.video136.Node;

import java.util.LinkedList;
import java.util.List;

public class ValidateBinarySearchTree {

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        //     9
        //  4     20
        //1  6  15  170
        bst.insert(9);
        bst.insert(4);
        bst.insert(6);
        bst.insert(20);
        bst.insert(170);
        bst.insert(15);
        bst.insert(1);

        BinarySearchTree bst2 = new BinarySearchTree();
        bst2.setRoot(new Node<>(5));
        bst2.getRoot().setLeft(new Node<>(1));
        bst2.getRoot().setRight(new Node<>(6));
        bst2.getRoot().getRight().setLeft(new Node<>(4));
        bst2.getRoot().getRight().setRight(new Node<>(3));

        System.out.println("Valid BST1: " + isValidBST(bst.getRoot()));
        System.out.println("Valid BST2: " + isValidBST(bst2.getRoot()));

        List<Node<Integer>> queue1 = new LinkedList<>();
        queue1.add(bst.getRoot());
        List<Node<Integer>> queue2 = new LinkedList<>();
        queue2.add(bst2.getRoot());
        System.out.println("Valid BST1 (recursive): " + isValidBSTRecursive(queue1));
        System.out.println("Valid BST2 (recursive): " + isValidBSTRecursive(queue2));
    }

    private static boolean isValidBST(Node<Integer> root) {
        var currentNode = root;
        List<Node<Integer>> queue = new LinkedList<>();
        queue.add(currentNode);

        while (!queue.isEmpty()) {
            currentNode = queue.removeFirst();
            if (currentNode.getLeft() != null) {
                queue.add(currentNode.getLeft());
                if (currentNode.getLeft().getValue() > currentNode.getValue()) {
                    return false;
                }
            }
            if (currentNode.getRight() != null) {
                queue.add(currentNode.getRight());
                if (currentNode.getRight().getValue() < currentNode.getValue()) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean isValidBSTRecursive(List<Node<Integer>> queue) {
        if (queue.isEmpty()) {
            return true;
        }

        var currentNode = queue.removeFirst();
        if (currentNode.getLeft() != null) {
            queue.add(currentNode.getLeft());
            if (currentNode.getLeft().getValue() > currentNode.getValue()) {
                return false;
            }
        }

        if (currentNode.getRight() != null) {
            queue.add(currentNode.getRight());
            if (currentNode.getRight().getValue() < currentNode.getValue()) {
                return false;
            }
        }

        return isValidBSTRecursive(queue);
    }

}
