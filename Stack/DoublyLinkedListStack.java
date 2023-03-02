import java.util.NoSuchElementException; 

public class DoublyLinkedListStack<T> {
    private Node<T> top;
    private int size;

    private class Node<T> {
        private T data;
        private Node<T> next;
        private Node<T> prev;

        public Node(T data) {
            this.data = data;
        }
    }

    public DoublyLinkedListStack() {
        this.top = null;
        this.size = 0;
    }

    public void push(T data) {
        Node<T> node = new Node<T>(data);
        node.next = top;
        if (top != null) {
            top.prev = node;
        }
        top = node;
        size++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        T data = top.data;
        top = top.next;
        if (top != null) {
            top.prev = null;
        }
        size--;
        return data;
    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        DoublyLinkedListStack<Integer> stack = new DoublyLinkedListStack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Stack size: " + stack.size());
        System.out.println("Stack top element: " + stack.peek());
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Stack size after pop: " + stack.size());
    }
}
