package com.strukdat;

import java.util.Scanner;

class Node{
    Node left, right;
    String value;

    public Node(String value){
        this.value = value;
    }
}

class BinarySearchTree{
    Node root;

    private Node addRecursive(Node current, String value){
        if (current == null){
            return new Node(value);
        }
        if (value.compareTo(current.value) < 0){
            current.left = addRecursive(current.left, value);
        }else if(value.compareTo(current.value) > 0){
            current.right = addRecursive(current.right, value);
        }else {
            return current;
        }
        return current;
    }

    public void add(String value) {
        root = addRecursive(root,value);
    }

    public void inOrder(Node node) {
        if (node != null){
            inOrder(node.left);
            System.out.print(" "+ node.value);
            inOrder(node.right);
        }
    }

    public void preOrder(Node node) {
        if (node != null){
            System.out.print(" "+ node.value);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void postOrder(Node node) {
        if (node != null){
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(" "+ node.value);
        }
    }

}

public class Main {

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        Scanner scanner = new Scanner(System.in);
        System.out.print("tentukan jumlah data : ");
        int jumlahData = scanner.nextInt();
        for (int i = 0; i < jumlahData; i++) {
            System.out.print("masukan elemen : ");
            String value = scanner.next();
            binarySearchTree.add(value);
        }
        System.out.println("post order");
        binarySearchTree.postOrder(binarySearchTree.root);
        System.out.println("pre order");
        binarySearchTree.preOrder(binarySearchTree.root);
        System.out.println("in order");
        binarySearchTree.inOrder(binarySearchTree.root);
    }
}
