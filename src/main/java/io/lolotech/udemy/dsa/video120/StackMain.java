package io.lolotech.udemy.dsa.video120;

public class StackMain {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        stack.push("google");
        stack.push("udemy");
        stack.push("discord");
        stack.push("medium");
        stack.push("youtube");

        System.out.println(stack.peek());

        System.out.println(stack.pop());

        System.out.println(stack);
    }
}
