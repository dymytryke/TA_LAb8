package com.example.ICollections.impl;

import com.example.ICollections.ICollections;
import com.example.model.Data;

public class BinaryTree implements ICollections<Data> {

    private int size;
    private Node root;

    static class Node {
        Data data;
        Node left, right;

        Node(Data data) {
            this.data = data;
        }

        public int size(){
            int size = 1;
            if (left != null){
                size += left.size();
            }
            if (right != null){
                size += right.size();
            }
            return size;
        }
    }

    public BinaryTree() {

    }

    public BinaryTree(Data data) {
        root = new Node(data);
    }

    @Override
    public void delete(Data data) {
        root = deleteRecursive(root, data);
    }

    private Node deleteRecursive(Node root, Data data) {

        if (root == null){
            return null;
        }

        if (data.compareTo(root.data) < 0)
            root.left = deleteRecursive(root.left, data);
        else if (data.compareTo(root.data) > 0)
            root.right = deleteRecursive(root.right, data);
        else {
            if (root.left == null) {
                size--;
                return root.right;
            } else if (root.right == null) {
                size--;
                return root.left;
            }

            root.data = minValue(root.right);

            root.right = deleteRecursive(root.right, root.data);
        }
        return root;
    }

    private Data minValue(Node root) {
        Data minval = root.data;

        while (root.left != null) {
            minval = root.left.data;
            root = root.left;
        }
        return minval;
    }

    @Override
    public void insert(Data data) {
        root = insertRecursive(root, data);
    }

    private Node insertRecursive(Node root, Data data) {
        if (root == null) {
            root = new Node(data);
            size++;
            return root;
        }
        if (data.compareTo(root.data) < 0)
            root.left = insertRecursive(root.left, data);
        else if (data.compareTo(root.data) > 0)
            root.right = insertRecursive(root.right, data);
        return root;
    }

    @Override
    public Data find(Data data){
        Node node = searchRecursive(root, data);
        return (node == null) ? null : node.data;
    }

    private Node searchRecursive(Node root, Data data) {
        if (root == null || root.data.equals(data))
            return root;

        if (root.data.compareTo(data) < 0)
            return searchRecursive(root.right, data);

        return searchRecursive(root.left, data);
    }

    @Override
    public void print() {
        printRecursive(root);
    }

    private void printRecursive(Node root) {
        if (root != null) {
            printRecursive(root.left);
            System.out.print(root.data + " ");
            printRecursive(root.right);
        }
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public Data pop() {
        Data data = root.data;
        delete(data);
        return data;
    }
}