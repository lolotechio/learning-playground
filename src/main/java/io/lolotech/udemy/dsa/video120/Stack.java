package io.lolotech.udemy.dsa.video120;

public class Stack<E> {

    Node<E> top;
    Node<E> bottom;
    int length;

    public Stack() {
        this.top = null;
        this.bottom = null;
        this.length = 0;
    }

    public E peek() {
        return this.top.value;
    }

    public void push(E value) {
        var newNode = new Node<>(value);
        if (this.length == 0) {
            this.bottom = newNode;
            this.top = newNode;
        } else {
            var holdingPointer = this.top;
            this.top = newNode;
            this.top.next = holdingPointer;
        }
        this.length++;
    }

    public E pop() {
        if (this.top == null) {
            return null;
        }
        if (this.top.equals(this.bottom)) {
            this.bottom = null;
        }
        var holdingPointer = this.top;
        this.top = this.top.next;
        this.length--;

        return holdingPointer.value;
    }

    @Override
    public String toString() {
        return "Stack{" +
                "top=" + top +
                ", bottom=" + bottom +
                ", length=" + length;
    }
}
