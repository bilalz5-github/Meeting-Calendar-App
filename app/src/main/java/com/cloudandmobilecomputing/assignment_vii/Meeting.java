package com.cloudandmobilecomputing.assignment_vii;
import android.os.Parcel;
import android.os.Parcelable;

public class Meeting implements Parcelable {
    private String title;
    private String place;
    private String participants;
    private String dateTime;

    // Constructor to initialize the class
    public Meeting(String title, String place, String participants, String dateTime) {
        this.title = title;
        this.place = place;
        this.participants = participants;
        this.dateTime = dateTime;
    }

    // Parcelable constructor
    protected Meeting(Parcel in) {
        title = in.readString();
        place = in.readString();
        participants = in.readString();
        dateTime = in.readString();
    }

    // Parcelable implementation
    public static final Creator<Meeting> CREATOR = new Creator<Meeting>() {
        @Override
        public Meeting createFromParcel(Parcel in) {
            return new Meeting(in);
        }

        @Override
        public Meeting[] newArray(int size) {
            return new Meeting[size];
        }
    };

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(title);
        parcel.writeString(place);
        parcel.writeString(participants);
        parcel.writeString(dateTime);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    // Getters and Setters for each attribute (allowing us to retrieve and update data)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getParticipants() {
        return participants;
    }

    public void setParticipants(String participants) {
        this.participants = participants;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    // Method to return a summary of the meeting
    public String getMeetingSummary() {
        return "Title: " + title + "\nPlace: " + place + "\nParticipants: " + participants + "\nDate and Time: " + dateTime;
    }
}
