package Objects;

import java.io.IOException;

import DataStructures.DoublyLinkedList;
import fileIO.BinaryFileEditor;

public class Store<T> {

    //Implement segmented array structure 
    private DoublyLinkedList<T> storage; // Storage for items
    // Should the store be the interface for all storage transactions including file
    private boolean maxCapacity; // Indicates if the store has reached its maximum capacity

    private BinaryFileEditor persistentFile; // Name of the persistent file
    private BinaryFileEditor writeFileName;

    // Constructor to initialize the Store
    public Store(String StorageElement, String persistentFile, String writeFileName) {
        setupStore(StorageElement, persistentFile, writeFileName);
    }


    //Add functionality to rebuild store

    
    // Getter for storage
    public DoublyLinkedList<T> getStorage() {
        return storage;
    }
    
    // Setter for storage
    public void setStorage(DoublyLinkedList<T> storage) {
        this.storage = storage;
    }
    
    // Getter for maxCapacity
    public boolean isMaxCapacity() {
        return maxCapacity;
    }
    
    // Setter for maxCapacity
    public void setMaxCapacity(boolean maxCapacity) {
        this.maxCapacity = maxCapacity;
    }
    
    // Getter for persistentFile
    public BinaryFileEditor getPersistentFile() {
        return persistentFile;
    }
    
    // Setter for persistentFile
    public void setPersistentFile(String persistentFile) {
        try {
            this.persistentFile = new BinaryFileEditor(persistentFile);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    // Getter for writeFileName
    public BinaryFileEditor getWriteFileName() {
        return writeFileName;
    }
    
    // Setter for writeFileName
    public void setWriteFileName(String writeFileName) {
        try {
            this.writeFileName = new BinaryFileEditor(writeFileName);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    private void setupStore(String storageElem, String persistentFile, String writeFileName) {
        // Depending on whether we're storing Students or Courses
    
        try {
            this.persistentFile = new BinaryFileEditor(persistentFile);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } // Set the persistent file name
        try {
            this.writeFileName = new BinaryFileEditor(writeFileName);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } // Set the write file name
    
        this.storage = new DoublyLinkedList<T>(); // Initialize the storage list
        this.maxCapacity = false; // Initialize maxCapacity
    }



    public void Add(){

    }

    public void Delete(){

    }

    public void Edit(){

    }

    public void get(){}

    // Store handle for insert and delete and edit operations
}
