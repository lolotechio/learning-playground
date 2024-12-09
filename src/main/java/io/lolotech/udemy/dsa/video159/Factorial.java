package io.lolotech.udemy.dsa.video159;

public class Factorial {
    //Write two functions that finds the factorial of any number.
    //One should use recursive, the other should use a for loop.
    //5! = 5*4*3*2*1

    public static void main(String[] args) {
        System.out.println(findFactorialRecursive(7));
        System.out.println(findFactorialIterative(6));
    }

    //Big O - O(n)
    private static int findFactorialRecursive(int number) {
        if (number == 1 || number == 2) {
            return number;
        }

        return number * findFactorialRecursive(number - 1);
    }

    //Big O - O(n)
    private static int findFactorialIterative(int number) {
        if (number == 1 || number == 2) {
            return number;
        }

        int factorial = 1;
        for (int i = number; i >= 2; i--) {
            factorial *= i;
        }

        return factorial;
    }
}
