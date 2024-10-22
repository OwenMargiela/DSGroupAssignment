package Objects;

public class Registration {
    private int studentID;      // ID of the student
    private int sequentialID;   // Sequential ID for registration
    private String courseName;   // Name of the course

    // Constructor to initialize the Registration object
    public Registration(int studentID, int sequentialID, String courseName) {
        this.studentID = studentID;
        this.sequentialID = sequentialID;
        this.courseName = courseName;
    }

    // Getter for studentID
    public int getStudentID() {
        return studentID;
    }

    // Setter for studentID
    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    // Getter for sequentialID
    public int getSequentialID() {
        return sequentialID;
    }

    // Setter for sequentialID
    public void setSequentialID(int sequentialID) {
        this.sequentialID = sequentialID;
    }

    // Getter for courseName
    public String getCourseName() {
        return courseName;
    }

    // Setter for courseName
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    // Method to display registration details
    public void displayRegistrationDetails() {
        System.out.println("Registration Details:");
        System.out.println("Student ID: " + studentID);
        System.out.println("Sequential ID: " + sequentialID);
        System.out.println("Course Name: " + courseName);
    }
}
