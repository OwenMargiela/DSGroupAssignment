package Objects;

import DataStructures.DoublyLinkedList;

public class Course {
    private boolean isFull;
    private String courseCode; // Code of the course
    private String title;      // Title of the course
    private int credits;       // Number of credits for the course
    private int maxCapacity;   // Maximum number of students allowed
    private DoublyLinkedList<Student> enrolledStudents; // List of enrolled students
    private DoublyLinkedList<Registration> registrationQueue;
    private int recordOffset;  // Offset for the course record
    @SuppressWarnings("unused")
    private String preRequsite;

    // Constructor to initialize the Course object
    public Course(String courseCode, String title, int credits, int maxCapacity, int recordOffset) {
        this.courseCode = courseCode;
        this.title = title;
        this.credits = credits;
        this.maxCapacity = maxCapacity;
        this.enrolledStudents = new DoublyLinkedList<>(); // Initialize the list for enrolled students
        this.recordOffset = recordOffset;
    }

    //  Getter isFull
    public boolean getIsFull() {
        return isFull;
    }

    // Setter for is full
    public void setIsFull(boolean newVal) {
        isFull = newVal;
    }
    // Getter for courseCode
    public String getCourseCode() {
        return courseCode;
    }

    // Setter for courseCode
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    // Getter for title
    public String getTitle() {
        return title;
    }

    // Setter for title
    public void setTitle(String title) {
        this.title = title;
    }

    // Getter for credits
    public int getCredits() {
        return credits;
    }

    // Setter for credits
    public void setCredits(int credits) {
        this.credits = credits;
    }

    // Getter for maxCapacity
    public int getMaxCapacity() {
        return maxCapacity;
    }

    // Setter for maxCapacity
    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    // Getter for enrolled students
    public DoublyLinkedList<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    // Getter for recordOffset
    public int getRecordOffset() {
        return recordOffset;
    }

    // Setter for recordOffset
    public void setRecordOffset(int recordOffset) {
        this.recordOffset = recordOffset;
    }

    // Method to enroll a student in the course
    public boolean enrollStudent(Student student) {
        if (enrolledStudents.getSize() < maxCapacity) {
            // Use student Map to check if pre the course's pre-requisite is in the students previously enrolled
            enrolledStudents.insertTail(student); // Insert student at the end of the list
            return true; // Successfully enrolled
        } else {
            System.out.println("Cannot enroll student. Maximum capacity reached.Adding student to registration queue");
            this.isFull = true;
            Registration reg = new Registration(student.geID(), student.getSequentialID(), this.getTitle());
            registrationQueue.insertHead(reg);
            return false; // Enrollment failed
        }
    }

    // Method to drop a student from the course
    public boolean dropStudent(Student student) {
        // Search for the student in the list to drop


        return false; // Drop failed
    }


    public void registerStudent(Student student){

    }

    // Method to display course information
    public void displayCourseInfo() {
        System.out.println("Course Code: " + courseCode);
        System.out.println("Title: " + title);
        System.out.println("Credits: " + credits);
        System.out.println("Maximum Capacity: " + maxCapacity);
        System.out.println("Current Enrollment: " + enrolledStudents.getSize() + "/" + maxCapacity);
        System.out.println("\nRecord Offset: " + recordOffset);
        
        System.out.print("Enrolled Students: ");
        // Print enrolled students
        enrolledStudents.printList();
        
    }
}
