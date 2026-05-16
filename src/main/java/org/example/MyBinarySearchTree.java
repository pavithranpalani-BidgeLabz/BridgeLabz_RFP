package org.example;

public class MyBinarySearchTree<K extends Comparable<K>> {
    MyBinaryNode<K> root;

    public void add(K key) {
        root = this.addRecursively(root, key);
    }

    // UC1 && UC2
    private MyBinaryNode<K> addRecursively(MyBinaryNode<K> current, K key) {
        if (current == null) {
            return new MyBinaryNode<>(key);
        }
        int compare = key.compareTo(current.key);
        if (compare < 0) {
            current.left = addRecursively(current.left, key);
        } else if (compare > 0) {
            current.right = addRecursively(current.right, key);
        }
        return current;
    }

    public void display() {
        print(root);
        System.out.println();
    }

    private void print(MyBinaryNode<K> node) {
        if (node == null) {
            return;
        }
        print(node.left);
        System.out.println(node.key + " ");
        print(node.right);
    }

    // UC2
    public int size() {
        return sizeRecursively(root);

    }

    private int sizeRecursively(MyBinaryNode<K> root) {
        if (root == null) {
            return 0;
        }
        return 1 + sizeRecursively(root.left) + sizeRecursively(root.right);
    }

    public boolean search(K key) {
        return searchRecursively(root, key);
    }

    private boolean searchRecursively(MyBinaryNode<K> node, K key) {
        if (node == null) {
            return false;
        }
        int compare = key.compareTo(node.key);
        if (compare == 0) {
            return true;
        } else if (compare < 0) {
            return searchRecursively(node.left, key);
        } else {
            return searchRecursively(node.right, key);
        }
    }
}