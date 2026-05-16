package org.example;


import java.util.ArrayList;

public class MyHashTable<K, V> {

    private final int size = 10;
    private ArrayList<MyMapNode<K, V>> bucket;


    public MyHashTable() {
        bucket = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            bucket.add(null);
        }
    }

    public int getIndex(K key) {
        return Math.abs(key.hashCode()) % size;
    }

    // UC1 + UC2
    public void put(K key, V value) {
        int index = getIndex(key);

        MyMapNode<K, V> head = bucket.get(index);
        if (head == null) {
            head = new MyMapNode<>(key, value);
            bucket.set(index, head);
            return;
        }

        MyMapNode<K, V> temp = head;
        while (temp != null) {
            if (temp.getKey().equals(key)) {
                temp.setValue(value);
                return;
            }
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = new MyMapNode<>(key, value);
    }

    public V get(K key) {
        int index = getIndex(key);
        MyMapNode<K, V> temp = bucket.get(index);
        while (temp != null) {
            if (temp.getKey().equals(key)) {
                return temp.getValue();
            }
            temp = temp.next;
        }
        return null;
    }


    public void display() {
        for (int i = 0; i < size; i++) {
            MyMapNode<K, V> temp = bucket.get(i);
            if (temp != null) {
                while (temp != null) {
                    System.out.println(temp.getKey() + " -> " + temp.getValue());
                    temp = temp.next;
                }
            }

        }
    }

    public boolean remove(K key) {
        int index = getIndex(key);

        MyMapNode<K, V> head = bucket.get(index);
        if (head == null) {
            return false;
        }
        if (head.getKey().equals(key)) {
            bucket.set(index, head.next);
            return true;
        }
        MyMapNode<K, V> temp = head;
        while (temp.next != null) {
            if (temp.next.getKey().equals(key)) {
                temp.next = temp.next.next;
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
}