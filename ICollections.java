package com.example.ICollections;

public interface ICollections<E> {
    void insert(E data);
    E find(E data);
    void delete(E data);
    int size();
    void print();
    E pop();
}
