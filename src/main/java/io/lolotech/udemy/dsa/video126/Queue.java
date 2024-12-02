package io.lolotech.udemy.dsa.video126;

import io.lolotech.udemy.dsa.video120.Stack;

public class Queue<E> {

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

    Stack<E> queue = new Stack<>();

    //Pushes element x to the back of the queue.
    public void push(E value) {
        if (queue.size() == 0) {
            queue.push(value);
        } else {
            int queueSize = queue.size();;
            Stack<E> temp = new Stack<>();
            for (int i = 0; i < queueSize; i++) {
                temp.push(queue.pop());
            }

            queue.push(value);
            for (int i = 0; i < queueSize; i++) {
                queue.push(temp.pop());
            }
        }
    }

    //Removes the element from the front of the queue and returns it.
    public E pop() {
        return queue.pop();
    }

    //Returns the element at the front of the queue.
    public E peek() {
        return queue.peek();
    }

    //Returns true if the queue is empty, false otherwise.
    public boolean empty() {
        return queue.empty();
    }

    @Override
    public String toString() {
        return "Queue{" +
                "queue=" + queue +
                '}';
    }
}
