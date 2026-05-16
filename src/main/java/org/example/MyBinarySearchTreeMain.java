package org.example;



public class MyBinarySearchTreeMain {
    public static void main(String[] args) {
        MyBinarySearchTree<Integer> searchTree = new MyBinarySearchTree<>();
        searchTree.add(56);
        searchTree.add(30);
        searchTree.add(70);

        System.out.println("Printing the elements of search Tree: ");
        searchTree.display();

        MyBinarySearchTree<Integer> searchTree1 = new MyBinarySearchTree<>();
        Integer[] values = {22, 40, 60, 95, 11, 3, 16, 65, 63, 67};
        for (Integer value : values)
            searchTree1.add(value);

        System.out.println("UC2 Full BST Inorder:");
        searchTree1.display();

        System.out.println("Size: " + searchTree1.size());

        System.out.println("UC3 Search Results:");
        System.out.println("Search 63: " + searchTree1.search(63));
        System.out.println("Search 100: " + searchTree1.search(100));
    }
}