package io.lolotech.udemy.dsa.video136;

public class BinarySearchTreeMain {

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        //     9
        //  4     20
        //1  6  15  170
        bst.insert(9);
        bst.insert(4);
        bst.insert(6);
        bst.insert(20);
        bst.insert(170);
        bst.insert(15);
        bst.insert(1);

        System.out.println(bst);
        //System.out.println(bst.lookup(9));
    }
}