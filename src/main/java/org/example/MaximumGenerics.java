class MaximumGenerics<T extends Comparable<T>> {

    T x, y, z;

    // Constructor
    MaximumGenerics(T x, T y, T z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // Static method to find max of 3 values
    public static <T extends Comparable<T>> T testMaximum(T a, T b, T c) {
        T max = a;

        if (b.compareTo(max) > 0) {
            max = b;
        }

        if (c.compareTo(max) > 0) {
            max = c;
        }

        printMax(max);
        return max;
    }

    // Instance method
    public T testMaximum() {
        return testMaximum(x, y, z);
    }

    // Method to handle more than 3 values
    public static <T extends Comparable<T>> T testMaximum(T... values) {
        T max = values[0];

        for (int i = 1; i < values.length; i++) {
            if (values[i].compareTo(max) > 0) {
                max = values[i];
            }
        }

        printMax(max);
        return max;
    }

    // Print method
    public static <T> void printMax(T max) {
        System.out.println("Maximum value is: " + max);
    }

    public static void main(String[] args) {

        // Integer test cases
        testMaximum(30, 20, 10);  // max at 1st
        testMaximum(10, 50, 20);  // max at 2nd
        testMaximum(10, 20, 90);  // max at 3rd

        // Float test cases
        testMaximum(3.5f, 2.1f, 1.0f);
        testMaximum(1.1f, 5.5f, 2.2f);
        testMaximum(1.1f, 2.2f, 9.9f);

        // String test cases
        testMaximum("Peach", "Apple", "Banana");
        testMaximum("Apple", "Zoo", "Banana");
        testMaximum("Apple", "Banana", "Zoo");

        // Using Generic Class
        MaximumGenerics<Integer> obj = new MaximumGenerics<>(5, 15, 10);
        obj.testMaximum();

        // More than 3 values
        testMaximum(10, 20, 30, 40, 50);
        testMaximum("Apple", "Mango", "Peach", "Banana");
    }
}