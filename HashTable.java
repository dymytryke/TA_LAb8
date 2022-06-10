package com.example.ICollections.impl;

import com.example.ICollections.CollectionType;
import com.example.ICollections.ICollections;
import com.example.model.Data;

public class HashTable implements ICollections<Data> {

    private int size;
    private int capacity;
    private ICollections<Data>[] keys;
    private final CollectionType type;

    public HashTable(CollectionType type, int capacity) {
        this.capacity = capacity;
        this.type = type;
        if (type == CollectionType.BinaryTree){
            keys = new BinaryTree[capacity];
        }else {
            keys = new LinkedList[capacity];
        }
    }

    public HashTable(CollectionType type) {
        capacity = 20;
        this.type = type;
        if (type == CollectionType.BinaryTree){
            keys = new BinaryTree[capacity];
        }else {
            keys = new LinkedList[capacity];
        }
    }

    private int hash(Data data){
        return hashString(data.streetAddr);
    }

    private int hashString(String key){
        long sum = 0;
        long temp = 1;
        for (int i = 0; i < key.length(); i++) {
            temp = (i % 4 == 0) ? 1 : temp * 256;
            sum += key.charAt(i) * temp;
        }
        return (int)(Math.abs(sum) % capacity);
    }

    private void reHash(){
        ICollections<Data>[] temp = keys;
        capacity = capacity * 2;
        if (type == CollectionType.BinaryTree){
            keys = new BinaryTree[capacity];
        }else {
            keys = new LinkedList[capacity];
        }
        for (ICollections<Data> el : temp) {
            if (el != null) {
                int size = el.size();
                for (int j = 0; j < size; j++) {
                    insert(el.pop());
                }
            }
        }
    }

    @Override
    public void insert(Data data) {
        double loadFactor = (double) size / (double) capacity;
        if (loadFactor > 0.7){
            reHash();
        }

        int index = hash(data);
        if (keys[index] == null){
            if (type == CollectionType.BinaryTree){
                keys[index] = new BinaryTree(data);
            }else {
                keys[index] = new LinkedList(data);
            }
        }else {
            keys[index].insert(data);
        }
        size++;
    }

    @Override
    public Data find(Data data) {
        int index = hash(data);
        if (keys[index] == null){
            return null;
        }
        return keys[index].find(data);
    }

    @Override
    public void delete(Data data) {
        int index = hash(data);
        if (keys[index] == null){
            return;
        }
        keys[index].delete(data);
        size--;
    }

    @Override
    public int size(){
        int size = 0;
        for (int i = 0; i < capacity; i++) {
            if (keys[i] != null){
                size += keys[i].size();
            }
        }
        return size;
    }

    @Override
    public void print() {
        for (ICollections<Data> el: keys) {
            if (el != null)
                el.print();
        }
    }

    @Override
    public Data pop() {
        for (int i = 0; i < capacity; i++) {
            if (keys[i] != null && keys[i].size() != 0){
                return keys[i].pop();
            }
        }
        return null;
    }

    public int[] sizes(){
        int[] sizes = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            if (keys[i] != null)
            sizes[i] = keys[i].size();
        }
        return sizes;
    }
}
