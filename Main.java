package com.example;

import com.example.ICollections.CollectionType;
import com.example.ICollections.ICollections;
import com.example.ICollections.impl.BinaryTree;
import com.example.ICollections.impl.HashTable;
import com.example.model.Data;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        ICollections<Data> hashTableTreeFor1000 = new HashTable(CollectionType.BinaryTree);
        ICollections<Data> hashTableTreeFor10000 = new HashTable(CollectionType.BinaryTree);
        ICollections<Data> hashTableTreeFor100000 = new HashTable(CollectionType.BinaryTree);
        ICollections<Data> hashTableTreeFor200000 = new HashTable(CollectionType.BinaryTree);

        ICollections<Data> hashTableListFor1000 = new HashTable(CollectionType.LinkedList);
        ICollections<Data> hashTableListFor10000 = new HashTable(CollectionType.LinkedList);
        ICollections<Data> hashTableListFor100000 = new HashTable(CollectionType.LinkedList);
        ICollections<Data> hashTableListFor200000 = new HashTable(CollectionType.LinkedList);

        ICollections<Data> treeFor1000 = new BinaryTree();
        ICollections<Data> treeFor10000 = new BinaryTree();
        ICollections<Data> treeFor100000 = new BinaryTree();
        ICollections<Data> treeFor200000 = new BinaryTree();

        Data[] findData = new Data[500];
        for (int i = 0; i < findData.length; i++) {
            byte[] array = new byte[7];
            random.nextBytes(array);
            String generatedString = new String(array, StandardCharsets.UTF_8);
            findData[i] = new Data(random.nextInt(1000), generatedString, random.nextInt(1000));
        }

        long time = System.nanoTime();
        for (int i = 0; i < 500; i++) {
            byte[] array = new byte[8];
            random.nextBytes(array);
            String generatedString = new String(array, StandardCharsets.UTF_8);
            hashTableTreeFor1000.insert(new Data(random.nextInt(1000), generatedString, random.nextInt(1000)));
            hashTableTreeFor1000.insert(findData[i]);
        }
        System.out.println("Insert in hashTableTreeFor1000: " + (System.nanoTime() - time));

        time = System.nanoTime();
        for (int i = 0; i < 500; i++) {
            byte[] array = new byte[8];
            random.nextBytes(array);
            String generatedString = new String(array, StandardCharsets.UTF_8);
            hashTableListFor1000.insert(new Data(random.nextInt(1000), generatedString, random.nextInt(1000)));
            hashTableListFor1000.insert(findData[i]);
        }
        System.out.println("Insert in hashTableListFor1000: " + (System.nanoTime() - time));

        time = System.nanoTime();
        for (int i = 0; i < 500; i++) {
            byte[] array = new byte[8];
            random.nextBytes(array);
            String generatedString = new String(array, StandardCharsets.UTF_8);
            treeFor1000.insert(new Data(random.nextInt(1000), generatedString, random.nextInt(1000)));
            treeFor1000.insert(findData[i]);
        }
        System.out.println("Insert in treeFor1000: " + (System.nanoTime() - time));

        time = System.nanoTime();
        for (int i = 0; i < 9500; i++) {
            byte[] array = new byte[8];
            random.nextBytes(array);
            String generatedString = new String(array, StandardCharsets.UTF_8);
            hashTableTreeFor10000.insert(new Data(random.nextInt(1000), generatedString, random.nextInt(1000)));
            if (i < 500) {
                hashTableTreeFor10000.insert(findData[i]);
            }
        }
        System.out.println("Insert in hashTableTreeFor10000: " + (System.nanoTime() - time));

        time = System.nanoTime();
        for (int i = 0; i < 9500; i++) {
            byte[] array = new byte[8];
            random.nextBytes(array);
            String generatedString = new String(array, StandardCharsets.UTF_8);
            hashTableListFor10000.insert(new Data(random.nextInt(1000), generatedString, random.nextInt(1000)));
            if (i < 500) {
                hashTableListFor10000.insert(findData[i]);
            }
        }
        System.out.println("Insert in hashTableListFor10000: " + (System.nanoTime() - time));

        time = System.nanoTime();
        for (int i = 0; i < 9500; i++) {
            byte[] array = new byte[8];
            random.nextBytes(array);
            String generatedString = new String(array, StandardCharsets.UTF_8);
            treeFor10000.insert(new Data(random.nextInt(1000), generatedString, random.nextInt(1000)));
            if (i < 500) {
                treeFor10000.insert(findData[i]);
            }
        }
        System.out.println("Insert in treeFor10000: " + (System.nanoTime() - time));

        time = System.nanoTime();
        for (int i = 0; i < 99500; i++) {
            byte[] array = new byte[8];
            random.nextBytes(array);
            String generatedString = new String(array, StandardCharsets.UTF_8);
            hashTableTreeFor100000.insert(new Data(random.nextInt(1000), generatedString, random.nextInt(1000)));
            if (i < 500) {
                hashTableTreeFor100000.insert(findData[i]);
            }
        }
        System.out.println("Insert in hashTableTreeFor100000: " + (System.nanoTime() - time));

        time = System.nanoTime();
        for (int i = 0; i < 99500; i++) {
            byte[] array = new byte[8];
            random.nextBytes(array);
            String generatedString = new String(array, StandardCharsets.UTF_8);
            hashTableListFor100000.insert(new Data(random.nextInt(1000), generatedString, random.nextInt(1000)));
            if (i < 500) {
                hashTableListFor100000.insert(findData[i]);
            }
        }
        System.out.println("Insert in hashTableListFor100000: " + (System.nanoTime() - time));

        time = System.nanoTime();
        for (int i = 0; i < 99500; i++) {
            byte[] array = new byte[8];
            random.nextBytes(array);
            String generatedString = new String(array, StandardCharsets.UTF_8);
            treeFor100000.insert(new Data(random.nextInt(1000), generatedString, random.nextInt(1000)));
            if (i < 500) {
                treeFor100000.insert(findData[i]);
            }
        }
        System.out.println("Insert in treeFor100000: " + (System.nanoTime() - time));

        time = System.nanoTime();
        for (int i = 0; i < 199500; i++) {
            byte[] array = new byte[8];
            random.nextBytes(array);
            String generatedString = new String(array, StandardCharsets.UTF_8);
            hashTableTreeFor200000.insert(new Data(random.nextInt(1000), generatedString, random.nextInt(1000)));
            if (i < 500) {
                hashTableTreeFor200000.insert(findData[i]);
            }
        }
        System.out.println("Insert in hashTableTreeFor200000: " + (System.nanoTime() - time));

        time = System.nanoTime();
        for (int i = 0; i < 199500; i++) {
            byte[] array = new byte[8];
            random.nextBytes(array);
            String generatedString = new String(array, StandardCharsets.UTF_8);
            hashTableListFor200000.insert(new Data(random.nextInt(1000), generatedString, random.nextInt(1000)));
            if (i < 500) {
                hashTableListFor200000.insert(findData[i]);
            }
        }
        System.out.println("Insert in hashTableListFor200000: " + (System.nanoTime() - time));

        time = System.nanoTime();
        for (int i = 0; i < 199500; i++) {
            byte[] array = new byte[8];
            random.nextBytes(array);
            String generatedString = new String(array, StandardCharsets.UTF_8);
            treeFor200000.insert(new Data(random.nextInt(1000), generatedString, random.nextInt(1000)));
            if (i < 500) {
                treeFor200000.insert(findData[i]);
            }
        }
        System.out.println("Insert in treeFor200000: " + (System.nanoTime() - time));

        time = System.nanoTime();
        for (int i = 0; i < 500; i++) {
            hashTableListFor1000.find(findData[i]);
        }
        System.out.println("Find 500 in hashTableListFor1000: " + (System.nanoTime() - time));

        time = System.nanoTime();
        for (int i = 0; i < 500; i++) {
            hashTableTreeFor1000.find(findData[i]);
        }
        System.out.println("Find 500 in hashTableTreeFor1000: " + (System.nanoTime() - time));

        time = System.nanoTime();
        for (int i = 0; i < 500; i++) {
            treeFor1000.find(findData[i]);
        }
        System.out.println("Find 500 in treeFor1000: " + (System.nanoTime() - time));

        time = System.nanoTime();
        for (int i = 0; i < 500; i++) {
            hashTableListFor10000.find(findData[i]);
        }
        System.out.println("Find 500 in hashTableListFor10000: " + (System.nanoTime() - time));

        time = System.nanoTime();
        for (int i = 0; i < 500; i++) {
            hashTableTreeFor10000.find(findData[i]);
        }
        System.out.println("Find 500 in hashTableTreeFor10000: " + (System.nanoTime() - time));

        time = System.nanoTime();
        for (int i = 0; i < 500; i++) {
            treeFor10000.find(findData[i]);
        }
        System.out.println("Find 500 in treeFor10000: " + (System.nanoTime() - time));

        time = System.nanoTime();
        for (int i = 0; i < 500; i++) {
            hashTableListFor100000.find(findData[i]);
        }
        System.out.println("Find 500 in hashTableListFor100000: " + (System.nanoTime() - time));

        time = System.nanoTime();
        for (int i = 0; i < 500; i++) {
            hashTableTreeFor100000.find(findData[i]);
        }
        System.out.println("Find 500 in hashTableTreeFor100000: " + (System.nanoTime() - time));

        time = System.nanoTime();
        for (int i = 0; i < 500; i++) {
            treeFor100000.find(findData[i]);
        }
        System.out.println("Find 500 in treeFor100000: " + (System.nanoTime() - time));

        time = System.nanoTime();
        for (int i = 0; i < 500; i++) {
            hashTableListFor200000.find(findData[i]);
        }
        System.out.println("Find 500 in hashTableListFor200000: " + (System.nanoTime() - time));

        time = System.nanoTime();
        for (int i = 0; i < 500; i++) {
            hashTableTreeFor200000.find(findData[i]);
        }
        System.out.println("Find 500 in hashTableTreeFor200000: " + (System.nanoTime() - time));

        time = System.nanoTime();
        for (int i = 0; i < 500; i++) {
            treeFor200000.find(findData[i]);
        }
        System.out.println("Find 500 in treeFor200000: " + (System.nanoTime() - time));
    }
}
