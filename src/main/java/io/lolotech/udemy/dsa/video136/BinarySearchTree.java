package io.lolotech.udemy.dsa.video136;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

@Getter
@Setter
public class BinarySearchTree {

    private Node<Integer> root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(Integer value) {
        if (this.root == null) {
            this.root = new Node<>(value);
        } else {
            Node<Integer> currentNode = this.root;
            Node<Integer> holdingPointer = this.root;
            while (currentNode != null) {
                holdingPointer = currentNode;
                if (value < currentNode.getValue()) {
                    currentNode = currentNode.getLeft();
                } else {
                    currentNode = currentNode.getRight();
                }
            }

            if (value < holdingPointer.getValue()) {
                holdingPointer.setLeft(new Node<>(value));
            } else {
                holdingPointer.setRight(new Node<>(value));
            }

        }
    }

    public Node<Integer> lookup(Integer value) {
        if (this.root == null) {
            return null;
        }

        if (this.root.getValue().equals(value)) {
            return this.root;
        }

        Node<Integer> currentNode = this.root;
        while (currentNode != null) {
            if (currentNode.getValue().equals(value)) {
                return currentNode;
            }

            if (value < currentNode.getValue()) {
                currentNode = currentNode.getLeft();
            } else {
                currentNode = currentNode.getRight();
            }
        }

        return null;
    }

    @SneakyThrows
    @Override
    public String toString() {
        return new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(this);
    }
}

//     9
//  4     20
//1  6  15  170
