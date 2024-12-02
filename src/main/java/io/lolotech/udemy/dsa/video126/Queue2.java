package io.lolotech.udemy.dsa.video126;

import io.lolotech.udemy.dsa.video120.Stack;

public class Queue2<E> {

//    Implement a first in first out (FIFO) queue using only two stacks.
//    The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).
//
//    Implement the MyQueue class:
//
//    void push(int x) Pushes element x to the back of the queue.
//    int pop() Removes the element from the front of the queue and returns it.
//    int peek() Returns the element at the front of the queue.
//    boolean empty() Returns true if the queue is empty, false otherwise.
//
//    Notes:
//
//    You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty operations are valid.
//    Depending on your language, the stack may not be supported natively. You may simulate a stack using a list or deque (double-ended queue)
//    as long as you use only a stack's standard operations.

    Stack<E> first = new Stack<>();
    Stack<E> last = new Stack<>();

    public void push(E value) {
        var length = this.first.size();

        for (int i = 0; i < length; i++) {
            this.last.push(this.first.pop());
        }

        this.last.push(value);
    }

    //Removes the element from the front of the queue and returns it.
    public E pop() {
        var length = this.last.size();

        for (int i = 0; i < length; i++) {
            this.first.push(this.last.pop());
        }

        return this.first.pop();
    }

    //Returns the element at the front of the queue.
    public E peek() {
        if (this.first.size() > 0) {
            return this.first.peek();
        }

        var length = this.last.size();
        for (int i = 0; i < length; i++) {
            this.first.push(this.last.pop());
        }

        return this.first.peek();
    }

    //Returns true if the queue is empty, false otherwise.
    public boolean empty() {
        return this.first.empty();
    }

    @Override
    public String toString() {
        return "Queue2{" +
                "queue=" + first +
                '}';
    }
}
