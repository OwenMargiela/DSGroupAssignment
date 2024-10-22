package Objects;

import DataStructures.DoublyLinkedList;
import fileIO.BinaryFileEditor;

public class FileProccessor {
    private BinaryFileEditor fileEditor;
    private DoublyLinkedList<Event> eventQueue;

    //To A connection to send messages to the container.Such as if the file is at capacity
    // Will send messgaes to linked list, queues and stacks (the in memmory storage);
    private Store containerConnection;
    
    // Stores free record offsets;
    private DoublyLinkedList<String> freeList;
    
    
}
