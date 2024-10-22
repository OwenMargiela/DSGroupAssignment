package Objects;

import DataStructures.DoublyLinkedList;

public class Student {
    private int Id;
    private int sequentialID; // Unique identifier for the student
    private String name; // Name of the student
    private int recordOffset; // Offset for the student's record
    // Maybe implement a hash map for prevCourses for for o(1) lookup
    private DoublyLinkedList<String> prevCourses; // List to store previous courses
    private DoublyLinkedList<String> courses; // List to store current courses
    private DoublyLinkedList<String> registrationHistory;

    // Constructor to initialize the Student object
    public Student(int sequentialID, String name, int recordOffset) {
        this.sequentialID = sequentialID;
        this.name = name;
        this.recordOffset = recordOffset;
        this.prevCourses = new DoublyLinkedList<String>(); // Initialize the list for previous courses
        this.courses = new DoublyLinkedList<String>(); // Initialize the list for current courses
    }


    // Getter for sequentialID
    public int geID() {
        return Id;
    }

    // Setter for sequentialID
    public void setID(int newId) {
        this.Id = newId;
    }

    // Getter for sequentialID
    public int getSequentialID() {
        return sequentialID;
    }

    // Setter for sequentialID
    public void setSequentialID(int sequentialID) {
        this.sequentialID = sequentialID;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for recordOffset
    public int getRecordOffset() {
        return recordOffset;
    }

    // Setter for recordOffset
    public void setRecordOffset(int recordOffset) {
        this.recordOffset = recordOffset;
    }

    // Getter for previous courses
    public DoublyLinkedList<String> getPrevCourses() {
        return prevCourses;
    }

    // Setter for previous courses
    @SuppressWarnings("unused")
    private void setPrevCourses(DoublyLinkedList<String> prevCourses) {
        this.prevCourses = prevCourses;
    }

    // Getter for current courses
    public DoublyLinkedList<String> getCourses() {
        return courses;
    }

    // Setter for current courses
    @SuppressWarnings("unused")
    private void setCourses(DoublyLinkedList<String> courses) {
        this.courses = courses;
    }

    // Method to add a course to the current courses list
    @SuppressWarnings("unused")
    private void addCourse(String course) {
        this.courses.insertTail(course);
    }

    // Method to add a previous course
    @SuppressWarnings("unused")
    private void addPrevCourse(String course) {
        this.prevCourses.insertTail(course);
    }

    // Method to remove a course from the current courses list
    public void unregister(String course) {

        if (registrationHistory.getSize() > 1 ){
            registrationHistory.popTail();
            // Find the course in the course list and remove from the course list

            // Once the student is removed from the course on the course linked list we remove here
            //Find course then delete course
            System.out.println("Found and removied previous course!");
        } else {
            //List empty
            System.out.println("Empty queue");
        }
        // Iterate list to find a course then remove it
    }

    public void removePreviousCourse(String course) {

        // Remove a course from there history
        if (prevCourses.getSize() > 1 ){
            // Find the course in the course list and remove from the course list
            System.out.println("Found and removied previous course!");
        } else {
            //List empty
            System.out.println("Empty List");
        }
    }


    public void findCourse(String course) {
        // Iterate list to find a course then remove it
        System.out.println("Found course!");
    }

    public void findPreviousCourse(String course) {
        // Iterate list to find a course then remove it
        System.out.println("Found course!");
    }

    // Method to display student information
    public void displayInfo() {
        System.out.println("Student ID: " + sequentialID);
        System.out.println("Name: " + name);
        System.out.println("Record Offset: " + recordOffset);
        System.out.println("Current Courses: " + courses);
        System.out.println("Previous Courses: " + prevCourses);
    }
}
