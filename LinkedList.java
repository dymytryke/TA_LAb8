package com.example.ICollections.impl;

import com.example.ICollections.ICollections;
import com.example.model.Data;

public class LinkedList implements ICollections<Data> {

    private int size;
    private Node head;

    static class Node{
        Data data;
        Node next;
        public Node(Data data) {
            this.data = data;
        }
        public void print(){
            System.out.print(data + " ");
        }
    }

    public LinkedList(Data data) {
        size++;
        head = new Node(data);
    }

    public LinkedList() {

    }

    @Override
    public void insert(Data data){
        size ++;
        if (head == null){
            head = new Node(data);
            return;
        }
        Node temp = head;
        while (temp.next != null){
            if (temp.data.equals(data)){
                return;
            }
            temp = temp.next;
        }
        temp.next = new Node(data);
    }

    @Override
    public Data find(Data data){
        Node temp = head;
        while (temp != null){
            if (temp.data.equals(data)){
                return temp.data;
            }
            temp = temp.next;
        }
        return null;
    }

    @Override
    public void delete(Data data){
        Node parent = null;
        Node temp = head;
        while (temp != null){
            if (temp.data == data){
                size--;
                if (parent == null && temp.next != null){
                    head = temp.next;
                }else if (parent == null){
                    head = null;
                }else {
                    parent.next = temp.next;
                }
            }
            parent = temp;
            temp = temp.next;
        }
    }

    @Override
    public void print(){
        Node temp = head;
        while (temp != null){
            temp.print();
            temp = temp.next;
        }
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public Data pop() {
        Data data = head.data;
        delete(data);
        return data;
    }
}
