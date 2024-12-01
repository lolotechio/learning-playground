package io.lolotech.udemy.dsa.video124;

public class QueueMain {

    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();

        queue.enqueue("google");
        queue.enqueue("udemy");
        queue.enqueue("discord");
        queue.enqueue("medium");
        queue.enqueue("youtube");

        System.out.println(queue.peek());

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

        System.out.println(queue);
    }
}
