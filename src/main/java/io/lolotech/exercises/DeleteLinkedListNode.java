package io.lolotech.exercises;

import io.lolotech.exercises.util.LinkedList;

public class DeleteLinkedListNode {

    /*
    There is a singly-linked list head, and we want to delete a node in it.
    You are given the node to be deleted node. You will not be given access to the first node of head.
    All the values of the linked list are unique, and it is guaranteed that the given node is not the last node in the linked list.
    Delete the given node. Note that by deleting the node, we do not mean removing it from memory. We mean:

    The value of the given node should not exist in the linked list.
    The number of nodes in the linked list should decrease by one.
    All the values before node should be in the same order.
    All the values after node should be in the same order.

    Custom testing:
    For the input, you should provide the entire linked list head and the node to be given node. node should not be the last node of the list and should be an actual node in the list.
    We will build the linked list and pass the node to your function.
    The output will be the entire list after calling your function.

    Example 1:
    Input: head = [4,5,1,9], node = 5
    Output: [4,1,9]
    Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.

    Example 2;
    Input: head = [4,5,1,9], node = 1
    Output: [4,5,9]
    Explanation: You are given the third node with value 1, the linked list should become 4 -> 5 -> 9 after calling your function.
     */

    public static void main(String[] args) {
        var linkedList1 = LinkedList.fromArray(new int[]{4, 5, 1, 9});
        deleteNode(linkedList1.getNode(5));
        System.out.println(linkedList1);

        var linkedList2 = LinkedList.fromArray(new int[]{4, 5, 1, 9});
        deleteNode(linkedList2.getNode(1));
        System.out.println(linkedList2);
    }

    //TC: O(1)
    //SC: O(1)
    private static void deleteNode(LinkedList.Node node) {
        if (node == null || node.getNext() == null) {
            throw new IllegalArgumentException("Node cannot be null and must not be the last node");
        }

        node.setValue(node.getNext().getValue());
        node.setNext(node.getNext().getNext());
    }
}
