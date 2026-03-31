import java.util.LinkedList;

// Main class (file name should be DataStructureDemo.java)
public class DataStructureDemo {

    // ---------------- STACK ----------------
    static class Stack<T> {
        LinkedList<T> list = new LinkedList<>();

        // push -> add at beginning
        public void push(T data) {
            list.addFirst(data);
        }

        // pop -> remove from beginning
        public T pop() {
            if (list.isEmpty()) {
                System.out.println("Stack is empty");
                return null;
            }
            return list.removeFirst();
        }

        // peek -> view top element
        public T peek() {
            if (list.isEmpty()) {
                System.out.println("Stack is empty");
                return null;
            }
            return list.getFirst();
        }

        public boolean isEmpty() {
            return list.isEmpty();
        }

        public void display() {
            System.out.println("Stack: " + list);
        }
    }

    // ---------------- QUEUE ----------------
    static class Queue<T> {
        LinkedList<T> list = new LinkedList<>();

        // enqueue -> add at end
        public void enqueue(T data) {
            list.addLast(data);
        }

        // dequeue -> remove from beginning
        public T dequeue() {
            if (list.isEmpty()) {
                System.out.println("Queue is empty");
                return null;
            }
            return list.removeFirst();
        }

        public void display() {
            System.out.println("Queue: " + list);
        }
    }

    // ---------------- MAIN METHOD ----------------
    public static void main(String[] args) {

        System.out.println("Welcome to Data Structure Demo");

        // ---------- STACK ----------
        Stack<Integer> stack = new Stack<>();

        // push elements (70, 30, 56 so 56 is on top)
        stack.push(70);
        stack.push(30);
        stack.push(56);

        stack.display();

        System.out.println("Peek: " + stack.peek());

        // pop till empty
        while (!stack.isEmpty()) {
            System.out.println("Popped: " + stack.pop());
        }

        // ---------- QUEUE ----------
        Queue<Integer> queue = new Queue<>();

        // enqueue elements (56, 30, 70)
        queue.enqueue(56);
        queue.enqueue(30);
        queue.enqueue(70);

        queue.display();

        // dequeue elements
        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Dequeued: " + queue.dequeue());
    }
}