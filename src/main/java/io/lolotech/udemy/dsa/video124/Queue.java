package io.lolotech.udemy.dsa.video124;

public class Queue<E> {

    Node<E> first;
    Node<E> last;
    int length;

    public Queue() {
        this.first = null;
        this.last = null;
        this.length = 0;
    }

    public E peek() {
        return this.first.value;
    }

    public void enqueue(E value) {
        var newNode = new Node<>(value);
        if (this.length == 0) {
            this.first = newNode;
            this.last = newNode;
        } else {
            var holdingPointer = this.last;
            this.last = newNode;
            holdingPointer.next = newNode;
        }
        this.length++;
    }

    public E dequeue() {
        if (this.first == null) {
            return null;
        }
        if (this.first.equals(this.last)) {
            this.last = null;
        }
        var holdingPointer = this.first;
        this.first = this.first.next;
        this.length--;

        return holdingPointer.value;
    }

    @Override
    public String toString() {
        return "Queue{" +
                "first=" + first +
                ", last=" + last +
                ", length=" + length +
                '}';
    }
}
