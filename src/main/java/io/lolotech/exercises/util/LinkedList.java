package io.lolotech.exercises.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkedList {
    Node head;

    @SneakyThrows
    @Override
    public String toString() {
        return new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(this);
    }

    public Node getNode(int value) {
        var currentNode = this.getHead();
        while (currentNode != null) {
            if (currentNode.getValue() == value) {
                return currentNode;
            }

            currentNode = currentNode.getNext();
        }

        return null;
    }

    public static LinkedList fromArray(int[] array) {
        var linkedList = new LinkedList(new Node(array[0]));

        var currentNode = linkedList.getHead();
        int i = 1;
        while (i < array.length) {
            var node = new Node(array[i]);
            currentNode.setNext(node);
            currentNode = node;
            i++;
        }

        return linkedList;
    }

    @Data
    public static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}
