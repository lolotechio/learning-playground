package io.lolotech.udemy.dsa.video126;

public class QueueMain {

    public static void main(String[] args) {
        Queue2<String> queue = new Queue2<>();

        queue.push("google");
        queue.push("udemy");
        queue.push("discord");
        queue.push("medium");
        queue.push("youtube");
        queue.push("facebook");

        System.out.println("peek: " + queue.peek());

        System.out.println("pop: " + queue.pop());
        System.out.println("pop: " + queue.pop());

        System.out.println(queue);
    }
}
