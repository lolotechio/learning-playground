package io.lolotech.exercises;

import io.lolotech.exercises.util.LinkedList;

public class MergeTwoSortedLists {

    /*
    You are given the heads of two sorted linked lists list1 and list2.
    Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
    Return the head of the merged linked list

    Example 1:
    Input: list1 = [1,2,4], list2 = [1,3,4]
    Output: [1,1,2,3,4,4]

    Example 2:
    Input: list1 = [], list2 = []
    Output: []

    Example 3:
    Input: list1 = [], list2 = [0]
    Output: [0]
    */

    public static void main(String[] args) {
        LinkedList list1 = LinkedList.fromArray(new int[]{1, 2, 4});
        LinkedList list2 = LinkedList.fromArray(new int[]{1, 3, 4});
        printList(mergeLists(list1 != null ? list1.getHead() : null,
                list2 != null ? list2.getHead() : null));

        list1 = LinkedList.fromArray(new int[]{});
        list2 = LinkedList.fromArray(new int[]{});
        printList(mergeLists(list1 != null ? list1.getHead() : null,
                list2 != null ? list2.getHead() : null));

        list1 = LinkedList.fromArray(new int[]{});
        list2 = LinkedList.fromArray(new int[]{0});
        printList(mergeLists(list1 != null ? list1.getHead() : null,
                list2 != null ? list2.getHead() : null));
    }

    //TC: O(n+m)
    //SC: O(1)
    private static LinkedList.Node mergeLists(LinkedList.Node list1, LinkedList.Node list2) {
        if (list1 == null && list2 == null) {
            return null;
        }

        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        LinkedList.Node dummy = new LinkedList.Node(-1);
        LinkedList.Node current = dummy;

        while (list1 != null && list2 != null) {
            if (list1.getValue() < list2.getValue()) {
                current.setNext(list1);
                list1 = list1.getNext();
            } else {
                current.setNext(list2);
                list2 = list2.getNext();
            }
            current = current.getNext();
        }

        // Append the remaining nodes (if any)
        current.setNext((list1 != null) ? list1 : list2);

        return dummy.getNext();
    }

    public static void printList(LinkedList.Node head) {
        if (head == null) {
            System.out.println("[]");
            return;
        }

        while (head != null) {
            System.out.print(head.getValue() + " -> ");
            head = head.getNext();
        }
        System.out.println("null");
    }
}
