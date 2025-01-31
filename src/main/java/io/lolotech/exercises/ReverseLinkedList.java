package io.lolotech.exercises;

import io.lolotech.exercises.util.LinkedList;

public class ReverseLinkedList {

    /*
    Given the head of a singly linked list, reverse the list, and return the reversed list.

    Example 1:
    Input: head = [1,2,3,4,5]
    Output: [5,4,3,2,1]

    Example 2:
    Input: head = [1,2]
    Output: [2,1]
     */
    public static void main(String[] args) {
        System.out.println(reverseLinkedList(new int[]{1, 2, 3, 4, 5}));
        System.out.println(reverseLinkedList(new int[]{1, 2}));
        System.out.println(reverseLinkedList(new int[]{}));
    }

    //TC: O(n)
    //SC: O(1)
    private static LinkedList reverseLinkedList(int[] input) {
        if (input == null || input.length == 0) {
            return new LinkedList();
        }

        var linkedList = LinkedList.fromArray(input);

        var currentNode = linkedList.getHead();
        LinkedList.Node previousNode = null;
        while (currentNode != null) {
            var nextNode = currentNode.getNext();
            currentNode.setNext(previousNode);
            previousNode = currentNode;
            currentNode = nextNode;
        }

        linkedList.setHead(previousNode);

        return linkedList;
    }
}
