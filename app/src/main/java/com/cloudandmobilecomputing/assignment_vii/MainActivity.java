package com.cloudandmobilecomputing.assignment_vii;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    // Declare UI components
    private EditText title, place, participants, dateTime;
    private Button submitButton, searchButton, updateButton;

    // Static list to store meetings (you can consider using a database or SharedPreferences)
    private static ArrayList<Meeting> meetingList = new ArrayList<>();

    private static final int REQUEST_CODE_UPDATE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI components
        title = findViewById(R.id.meetingTitle);
        place = findViewById(R.id.meetingPlace);
        participants = findViewById(R.id.meetingParticipants);
        dateTime = findViewById(R.id.meetingDateTime);
        submitButton = findViewById(R.id.submitButton);
        searchButton = findViewById(R.id.searchButton);
        updateButton = findViewById(R.id.updateButton);

        // Set up Date and Time picker for the dateTime EditText
        dateTime.setOnClickListener(v -> showDateTimePicker());

        // Submit button click listener: Create a meeting and store it in the list
        submitButton.setOnClickListener(v -> {
            String meetingTitle = title.getText().toString();
            String meetingPlace = place.getText().toString();
            String meetingParticipants = participants.getText().toString();
            String meetingDateTime = dateTime.getText().toString();

            // Create a Meeting object with input data
            Meeting meeting = new Meeting(meetingTitle, meetingPlace, meetingParticipants, meetingDateTime);

            // Add the meeting to the meeting list
            meetingList.add(meeting);

            // Pass the meeting summary to the next activity
            Intent intent = new Intent(MainActivity.this, MeetingSummaryActivity.class);
            intent.putExtra("meeting_data", meeting.getMeetingSummary());
            startActivity(intent);
        });

        // Search button click listener: Pass the list of meetings to SearchMeetingActivity
        searchButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SearchMeetingActivity.class);
            // Pass the list of meetings to the search activity
            intent.putExtra("meetingList", meetingList);
            startActivity(intent);
        });

        // Update button click listener: Navigate to UpdateMeetingActivity
        updateButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, UpdateMeetingActivity.class);
            intent.putExtra("meetingList", meetingList);
            startActivityForResult(intent, REQUEST_CODE_UPDATE);
        });
    }

    // Method to show DatePicker and TimePicker dialog
    private void showDateTimePicker() {
        final Calendar calendar = Calendar.getInstance();

        // Show DatePickerDialog
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, (view, year, month, dayOfMonth) -> {
            // Set the selected date in the EditText field
            calendar.set(year, month, dayOfMonth);
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            int minute = calendar.get(Calendar.MINUTE);

            // Show TimePickerDialog
            TimePickerDialog timePickerDialog = new TimePickerDialog(this, (view1, hourOfDay, minute1) -> {
                // Set the selected time in the EditText field
                calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                calendar.set(Calendar.MINUTE, minute1);
                // Update dateTime EditText with formatted date and time
                dateTime.setText(android.text.format.DateFormat.format("yyyy-MM-dd HH:mm", calendar));
            }, hour, minute, true);
            timePickerDialog.show();

        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_UPDATE && resultCode == RESULT_OK) {
            // Retrieve updated list
            meetingList = (ArrayList<Meeting>) data.getSerializableExtra("updatedMeetingList");
            // Refresh display or notify adapter if using RecyclerView/ListView
        }
    }
}
