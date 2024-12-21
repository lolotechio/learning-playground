package io.lolotech.udemy.dsa.video207;

import io.lolotech.udemy.dsa.video136.BinarySearchTree;
import io.lolotech.udemy.dsa.video136.Node;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch {

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

        System.out.println("DFS InOrder: " + dfsInOrder(bst.lookup(9), new ArrayList<>()));
        System.out.println("DFS PreOrder: " + dfsPreOrder(bst.lookup(9), new ArrayList<>()));
        System.out.println("DFS PostOrder: " + dfsPostOrder(bst.lookup(9), new ArrayList<>()));
    }

    private static List<Integer> dfsInOrder(Node<Integer> node, List<Integer> result) {
        if (node.getLeft() != null) {
            dfsInOrder(node.getLeft(), result);
        }

        result.add(node.getValue());

        if (node.getRight() != null) {
            dfsInOrder(node.getRight(), result);
        }

        return result;
    }

    private static List<Integer> dfsPreOrder(Node<Integer> node, List<Integer> result) {
        result.add(node.getValue());

        if (node.getLeft() != null) {
            dfsPreOrder(node.getLeft(), result);
        }

        if (node.getRight() != null) {
            dfsPreOrder(node.getRight(), result);
        }

        return result;
    }

    private static List<Integer> dfsPostOrder(Node<Integer> node, List<Integer> result) {
        if (node.getLeft() != null) {
            dfsPostOrder(node.getLeft(), result);
        }

        if (node.getRight() != null) {
            dfsPostOrder(node.getRight(), result);
        }

        result.add(node.getValue());

        return result;
    }
}
