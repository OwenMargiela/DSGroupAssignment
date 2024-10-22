package DataStructures;

// DoublyLinkedList will implement both stack and queue functionality
public class DoublyLinkedList<T> {
    private Node<T> head; // Reference to the head of the list
    private Node<T> tail; // Reference to the tail of the list
    private int size; // Current size of the list

    // Constructor to initialize the doubly linked list
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // Insert at the front of the list (Insert Head)
    public void insertHead(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) { // List is empty
            head = newNode;
            tail = newNode;
        } else {
            newNode.setNext(head); // Set next of new node to current head
            head.setPrev(newNode); // Set previous of current head to new node
            head = newNode; // Update head to new node
        }
        size++;
    }

    // Insert at the back of the list (Insert Tail)
    public void insertTail(T data) {
        Node<T> newNode = new Node<>(data);
        if (tail == null) { // List is empty
            head = newNode;
            tail = newNode;
        } else {
            newNode.setPrev(tail); // Set previous of new node to current tail
            tail.setNext(newNode); // Set next of current tail to new node
            tail = newNode; // Update tail to new node
        }
        size++;
    }

    // Insert at a specific index (Insert Middle)
    public void insertAt(int index, T data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }
        if (index == 0) {
            insertHead(data);
            return;
        }
        if (index == size) {
            insertTail(data);
            return;
        }

        Node<T> newNode = new Node<>(data);
        Node<T> current = head;

        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }

        newNode.setPrev(current.getPrev()); // Set previous of new node
        newNode.setNext(current); // Set next of new node to current

        if (current.getPrev() != null) {
            current.getPrev().setNext(newNode); // Update next of previous node
        }
        current.setPrev(newNode); // Set previous of current node to new node

        if (index == 0) { // Inserting at the head
            head = newNode;
        }

        size++;
    }

    // For queue operations and functionality
    public void popHead() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head == tail) { // Only one element
            head = null;
            tail = null;
        } else {
            head = head.getNext(); // Move head to next node
            head.setPrev(null); // Set previous of new head to null
        }
        size--;
    }

    // For stack operations and functionality
    public void popTail() {
        if (tail == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head == tail) { // Only one element
            head = null;
            tail = null;
        } else {
            tail = tail.getPrev(); // Move tail to previous node
            tail.setNext(null); // Set next of new tail to null
        }
        size--;
    }

    // Delete a specific node
    public void deleteNode(Node<T> node) {
        if (node == null)
            return;

        if (node == head) {
            popHead();
            return;
        }
        if (node == tail) {
            popTail();
            return;
        }

        if (node.getPrev() != null) {
            node.getPrev().setNext(node.getNext()); // Update next of previous node
        }
        if (node.getNext() != null) {
            node.getNext().setPrev(node.getPrev()); // Update previous of next node
        }
        size--;
    }

    // Search for a specific index
    public T search(int index) {

        try {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("Index out of bounds.");
            }
        } catch (IndexOutOfBoundsException e) {
            // TODO: handle exception
        }

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getData(); // Return data of the node
    }

    // Get the current size of the list
    public int getSize() {
        return size;
    }

    // Print the list from head to tail
    public void printList() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.getData() + " <-> ");
            current = current.getNext();
        }
        System.out.println("null");
    }

    // Print the list from tail to head
    public void printListReverse() {
        Node<T> current = tail;
        while (current != null) {
            System.out.print(current.getData() + " <-> ");
            current = current.getPrev();
        }
        System.out.println("null");
    }
}
