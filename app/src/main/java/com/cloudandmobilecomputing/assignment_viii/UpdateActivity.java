package com.cloudandmobilecomputing.assignment_viii;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends Activity {
    private EditText searchTitleField, updatePlaceField, updateParticipantsField, updateDateTimeField;
    private Button searchButton, updateButton;
    private Meeting currentMeeting; // Store the current meeting being updated

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        searchTitleField = findViewById(R.id.searchTitleField);
        updatePlaceField = findViewById(R.id.updatePlaceField);
        updateParticipantsField = findViewById(R.id.updateParticipantsField);
        updateDateTimeField = findViewById(R.id.updateDateTimeField);
        searchButton = findViewById(R.id.searchButton);
        updateButton = findViewById(R.id.updateButton);

        searchButton.setOnClickListener(v -> {
            String titleToSearch = searchTitleField.getText().toString();
            boolean found = false;
            for (Meeting meeting : Meeting.meetings) {
                if (meeting.getTitle().equalsIgnoreCase(titleToSearch)) {
                    currentMeeting = meeting;
                    updatePlaceField.setText(meeting.getPlace());
                    updateParticipantsField.setText(meeting.getParticipants());
                    updateDateTimeField.setText(meeting.getDateTime());

                    updatePlaceField.setVisibility(View.VISIBLE);
                    updateParticipantsField.setVisibility(View.VISIBLE);
                    updateDateTimeField.setVisibility(View.VISIBLE);
                    updateButton.setVisibility(View.VISIBLE);
                    found = true;
                    break;
                }
            }
            if (!found) {
                Toast.makeText(UpdateActivity.this, "No meeting found with that title.", Toast.LENGTH_LONG).show();
            }
        });

        updateButton.setOnClickListener(v -> {
            if (currentMeeting != null) {
                currentMeeting.setPlace(updatePlaceField.getText().toString());
                currentMeeting.setParticipants(updateParticipantsField.getText().toString());
                currentMeeting.setDateTime(updateDateTimeField.getText().toString());
                Toast.makeText(UpdateActivity.this, "Meeting updated successfully!", Toast.LENGTH_LONG).show();
            }
        });
    }
}
