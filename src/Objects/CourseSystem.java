package Objects;

import java.io.IOException;

import DataStructures.DoublyLinkedList;
import fileIO.BinaryFileEditor;

public class CourseSystem<T> {
    private String restartPolicy;
    private DoublyLinkedList<Event> eventsQueue; // Queue of edit events

    private Config config; // Configuration object

    // Flags to say what type of data
    public Store<T> container; // Container for student data

    // Constructor to initialize the System object
    public CourseSystem(Config config) {
        this.config = config; // Set the config
        this.eventsQueue = new DoublyLinkedList<Event>(); // Initialize the events queue
        this.container = new Store<T>("Example","Exmple","Example"); // Initialize the container
        //Implement above code
    }

    // Getter for eventsQueue
    public DoublyLinkedList<Event> getEventsQueue() {
        return eventsQueue;
    }

    // Setter for eventsQueue
    public void setEventsQueue(DoublyLinkedList<Event> eventsQueue) {
        this.eventsQueue = eventsQueue;
    }

    

    // Getter for config
    public Config getConfig() {
        return config;

        // Use values to reconfigure System
    }

    // Setter for config
    public void setConfig(Config config) {
        this.config = config;
    }

    // Getter for container
    public Store getContainer() {
        return container;
    }

    // Setter for container
    public void  setContainer(Store<T> container) {
        this.container = container;
    }

    // Additional methods can be added here for handling events and students
}
