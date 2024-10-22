package Objects;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;


// Event containing the changes made to a record in the in memmory to be reflected on disk (the files)

public class Event {

    // Optionally the name of the file the data that was changed  is stored on
    private int userID; // ID of the user who made the edit
    private LocalDateTime eventTime; // Time of the event
    private String eventType; // Type of the event (e.g., "edit", "delete")
    private int eventID; // Unique ID for the event
    private int recordOffset; // Offset for the record in the file
    private Map<String, String> changesMap; // Map to hold the changes made
    // Map<Feild, Changes made> changesMap;

    // Constructor to initialize the EditEvent object
    public Event(int userID, LocalDateTime eventTime, String eventType, int eventID, int recordOffset) {
        this.userID = userID;
        this.eventTime = eventTime;
        this.eventType = eventType;
        this.changesMap = new HashMap<>(); // Initialize changesMap
        this.eventID = eventID;
        this.recordOffset = recordOffset;
    }

    // Getter for userID
    public int getUserID() {
        return userID;
    }

    // Setter for userID
    public void setUserID(int userID) {
        this.userID = userID;
    }

    // Getter for eventTime
    public LocalDateTime getEventTime() {
        return eventTime;
    }

    // Setter for eventTime
    public void setEventTime(LocalDateTime eventTime) {
        this.eventTime = eventTime;
    }

    // Getter for eventType
    public String getEventType() {
        return eventType;
    }

    // Setter for eventType
    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    // Getter for changesMap
    public Map<String, String> getChangesMap() {
        return changesMap;
    }

    // Method to add a change to the changesMap
    public void addChange(String field, String newValue) {
        changesMap.put(field, newValue);
    }

    // Getter for eventID
    public int getEventID() {
        return eventID;
    }

    // Setter for eventID
    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    // Getter for recordOffset
    public int getRecordOffset() {
        return recordOffset;
    }

    // Setter for recordOffset
    public void setRecordOffset(int recordOffset) {
        this.recordOffset = recordOffset;
    }

    // Method to display event details
    public void displayEventDetails() {
        System.out.println("Edit Event Details:");
        System.out.println("User ID: " + userID);
        System.out.println("Event Time: " + eventTime);
        System.out.println("Event Type: " + eventType);
        System.out.println("Event ID: " + eventID);
        System.out.println("Record Offset: " + recordOffset);
        System.out.println("Changes Made:");
        for (Map.Entry<String, String> entry : changesMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
