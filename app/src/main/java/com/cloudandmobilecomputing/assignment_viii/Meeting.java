package com.cloudandmobilecomputing.assignment_viii;

import java.util.ArrayList;
import java.util.List;

public class Meeting {
    private String title;
    private String place;
    private String participants;
    private String dateTime;

    public static List<Meeting> meetings = new ArrayList<>();

    public Meeting(String title, String place, String participants, String dateTime) {
        this.title = title;
        this.place = place;
        this.participants = participants;
        this.dateTime = dateTime;
    }

    public String getTitle() {
        return title;
    }

    // Setter for place
    public void setPlace(String place) {
        this.place = place;
    }

    public String getPlace() {
        return place;
    }

    // Setter for participants
    public void setParticipants(String participants) {
        this.participants = participants;
    }

    public String getParticipants() {
        return participants;
    }

    // Setter for date and time
    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getDateTime() {
        return dateTime;
    }
}
