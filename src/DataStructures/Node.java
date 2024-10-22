package DataStructures;

public class Node<T> {
    private T data; // Generic data type
    private Node<T> next; // Reference to the next node
    private Node<T> prev; // Reference to the previous node

    // Constructor to initialize the node
    public Node(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    // Getter for data
    public T getData() {
        return data;
    }

    // Setter for data
    public void setData(T data) {
        this.data = data;
    }

    // Getter for next node
    public Node<T> getNext() {
        return next;
    }

    // Setter for next node
    public void setNext(Node<T> next) {
        this.next = next;
    }

    // Getter for previous node
    public Node<T> getPrev() {
        return prev;
    }

    // Setter for previous node
    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }
}
