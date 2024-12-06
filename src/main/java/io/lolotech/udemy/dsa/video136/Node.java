package io.lolotech.udemy.dsa.video136;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

@Getter
@Setter
public class Node<E> {

    private E value;
    private Node<E> left;
    private Node<E> right;

    public Node(E value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    @SneakyThrows
    @Override
    public String toString() {
        return new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(this);
    }
}
