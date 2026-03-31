class MaximumGenerics<T extends Comparable<T>> {

    T a, b, c;

    // constructor
    MaximumGenerics(T a, T b, T c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    // method for 3 values
    public static <T extends Comparable<T>> T findMax(T x, T y, T z) {
        T max = x;

        if (y.compareTo(max) > 0) {
            max = y;
        }

        if (z.compareTo(max) > 0) {
            max = z;
        }

        printMax(max);
        return max;
    }

    // method using object values
    public T findMax() {
        return findMax(a, b, c);
    }

    // method for more than 3 values
    public static <T extends Comparable<T>> T findMax(T... values) {
        T max = values[0];

        for (int i = 1; i < values.length; i++) {
            if (values[i].compareTo(max) > 0) {
                max = values[i];
            }
        }

        printMax(max);
        return max;
    }

    // print method
    public static <T> void printMax(T max) {
        System.out.println("Maximum is: " + max);
    }

    public static void main(String[] args) {

        // Integer
        findMax(50, 20, 30);
        findMax(10, 80, 30);
        findMax(10, 20, 90);

        // Float
        findMax(3.2f, 1.5f, 2.8f);
        findMax(1.1f, 5.6f, 2.2f);
        findMax(1.1f, 2.2f, 9.9f);

        // String
        findMax("Apple", "Peach", "Banana");
        findMax("Apple", "Zoo", "Banana");
        findMax("Apple", "Banana", "Zoo");

        // using object
        MaximumGenerics<Integer> obj = new MaximumGenerics<>(5, 15, 10);
        obj.findMax();

        // more values
        findMax(10, 20, 30, 40, 100);
        findMax("Cat", "Dog", "Elephant", "Bear");
    }
}