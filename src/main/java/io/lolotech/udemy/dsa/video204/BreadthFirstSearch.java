package io.lolotech.udemy.dsa.video204;

import io.lolotech.udemy.dsa.video136.BinarySearchTree;
import io.lolotech.udemy.dsa.video136.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BreadthFirstSearch {

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

        System.out.println("BFS: " + breadthFirstSearch(bst));

        List<Node<Integer>> queue = new LinkedList<>();
        queue.add(bst.lookup(9));
        System.out.println("BFS Recursive: " + breadthFirstSearchRecursive(queue, new ArrayList<>()));
    }

    private static List<Integer> breadthFirstSearch(BinarySearchTree binarySearchTree) {
        var currentNode = binarySearchTree.getRoot();
        List<Integer> result = new ArrayList<>();
        List<Node<Integer>> queue = new LinkedList<>();
        queue.add(currentNode);

        while (!queue.isEmpty()) {
            currentNode = queue.removeFirst();
            result.add(currentNode.getValue());
            if (currentNode.getLeft() != null) {
                queue.add(currentNode.getLeft());
            }
            if (currentNode.getRight() != null) {
                queue.add(currentNode.getRight());
            }
        }

        return result;
    }

    private static List<Integer> breadthFirstSearchRecursive(List<Node<Integer>> queue, List<Integer> result) {
        if (queue.isEmpty()) {
            return result;
        }

        var currentNode = queue.removeFirst();
        result.add(currentNode.getValue());
        if (currentNode.getLeft() != null) {
            queue.add(currentNode.getLeft());
        }
        if (currentNode.getRight() != null) {
            queue.add(currentNode.getRight());
        }

        return breadthFirstSearchRecursive(queue, result);
    }
}
