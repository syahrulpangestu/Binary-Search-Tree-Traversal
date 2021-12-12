package com.strukdat;

import java.util.Scanner;

class Node{
    Node left, right;
    String value;

    public Node(String value){
        this.value = value;
    }
}

class BinaryTree{
    Node root;

    private Node insert(Node current, String value){
        if (current == null){
            return new Node(value);
        }
        if (value.compareTo(current.value) < 0){
            current.left = insert(current.left, value);
        }else if(value.compareTo(current.value) > 0){
            current.right = insert(current.right, value);
        }else {
            return current;
        }
        return current;
    }

    public void add(String value) {
        root = insert(root,value);
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
        BinaryTree binaryTree = new BinaryTree();
        Scanner scanner = new Scanner(System.in);
        System.out.print("tentukan jumlah data : ");
        int jumlahData = scanner.nextInt();
        for (int i = 0; i < jumlahData; i++) {
            System.out.print("masukan elemen : ");
            String value = scanner.next();
            binaryTree.add(value);
        }
        System.out.println("post order");
        binaryTree.postOrder(binaryTree.root);
        System.out.println("pre order");
        binaryTree.preOrder(binaryTree.root);
        System.out.println("in order");
        binaryTree.inOrder(binaryTree.root);
    }
}
