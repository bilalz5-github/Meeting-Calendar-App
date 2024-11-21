package com.cloudandmobilecomputing.assignment_vii;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class UpdateMeetingActivity extends AppCompatActivity {

    private EditText updateSearch, title, place, participants, dateTime;
    private Button updateButton, saveButton;
    private ArrayList<Meeting> meetingList;  // List of meetings
    private Meeting meetingToEdit;  // Meeting to be updated

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_meeting);

        // Retrieve the meeting list from the intent
        meetingList = (ArrayList<Meeting>) getIntent().getSerializableExtra("meetingList");

        // Initialize UI components
        updateSearch = findViewById(R.id.updateSearch);
        title = findViewById(R.id.updateTitle); // Add this to XML layout
        place = findViewById(R.id.updatePlace); // Add this to XML layout
        participants = findViewById(R.id.updateParticipants); // Add this to XML layout
        dateTime = findViewById(R.id.updateDateTime); // Add this to XML layout
        updateButton = findViewById(R.id.updateButton);
        saveButton = findViewById(R.id.saveButton); // Button for saving changes

        updateButton.setOnClickListener(v -> {
            String searchQuery = updateSearch.getText().toString().trim();
            meetingToEdit = searchMeeting(searchQuery);

            if (meetingToEdit != null) {
                // Display the meeting details for editing
                title.setText(meetingToEdit.getTitle());
                place.setText(meetingToEdit.getPlace());
                participants.setText(meetingToEdit.getParticipants());
                dateTime.setText(meetingToEdit.getDateTime());
            } else {
                Toast.makeText(this, "Meeting not found", Toast.LENGTH_SHORT).show();
            }
        });

        saveButton.setOnClickListener(v -> {
            if (meetingToEdit != null) {
                // Update meeting details with the new data
                meetingToEdit.setTitle(title.getText().toString().trim());
                meetingToEdit.setPlace(place.getText().toString().trim());
                meetingToEdit.setParticipants(participants.getText().toString().trim());
                meetingToEdit.setDateTime(dateTime.getText().toString().trim());

                // Send updated list back to MainActivity
                Intent returnIntent = new Intent();
                returnIntent.putExtra("updatedMeetingList", meetingList); // pass updated list
                setResult(RESULT_OK, returnIntent);

                Toast.makeText(this, "Meeting updated successfully", Toast.LENGTH_SHORT).show();

                // Finish activity and return to MainActivity
                finish();
            } else {
                Toast.makeText(this, "No meeting selected for update", Toast.LENGTH_SHORT).show();
            }
        });

    }

    // Method to search for a meeting by title
    private Meeting searchMeeting(String query) {
        for (Meeting meeting : meetingList) {
            if (meeting.getTitle().equalsIgnoreCase(query)) {
                return meeting;
            }
        }
        return null;
    }
}
