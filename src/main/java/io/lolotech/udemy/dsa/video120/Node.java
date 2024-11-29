package io.lolotech.udemy.dsa.video120;

public class Node<E> {

    E value;
    Node<E> next;

    public Node(E value) {
        this.value = value;
        this.next = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }
}
