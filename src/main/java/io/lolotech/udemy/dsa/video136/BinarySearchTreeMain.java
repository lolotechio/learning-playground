package io.lolotech.udemy.dsa.video136;

public class BinarySearchTreeMain {

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
//        bst.setRoot(new Node<>(9));
//        bst.getRoot().setLeft(new Node<>(4));
//        bst.getRoot().setRight(new Node<>(20));
//        bst.getRoot().getLeft().setLeft(new Node<>(1));
//        bst.getRoot().getLeft().setRight(new Node<>(6));
//        bst.getRoot().getRight().setLeft(new Node<>(15));
//        bst.getRoot().getRight().setRight(new Node<>(170));

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