package com.cloudandmobilecomputing.assignment_vii;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MeetingSummaryActivity extends AppCompatActivity {

    private TextView meetingSummary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting_summary);

        meetingSummary = findViewById(R.id.meetingSummary);

        // Get meeting data passed from MainActivity
        String meetingData = getIntent().getStringExtra("meeting_data");
        meetingSummary.setText(meetingData);
    }
}