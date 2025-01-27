package io.lolotech.exercises;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

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

        var linkedList = buildLinkedList(input);

        var currentNode = linkedList.getHead();
        Node previousNode = null;
        while (currentNode != null) {
            var nextNode = currentNode.next;
            currentNode.setNext(previousNode);
            previousNode = currentNode;
            currentNode = nextNode;
        }

        linkedList.setHead(previousNode);

        return linkedList;
    }

    private static LinkedList buildLinkedList(int[] array) {
        var linkedList = new LinkedList(new Node(array[0]));

        var currentNode = linkedList.getHead();
        int i = 1;
        while (i < array.length) {
            var node = new Node(array[i]);
            currentNode.next = node;
            currentNode = node;
            i++;
        }

        return linkedList;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class LinkedList {
        Node head;

        @SneakyThrows
        @Override
        public String toString() {
            return new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(this);
        }
    }

    @Data
    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}
