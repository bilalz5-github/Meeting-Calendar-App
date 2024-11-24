package com.cloudandmobilecomputing.assignment_viii;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayActivity extends Activity {
    private TextView displayText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        displayText = findViewById(R.id.displayText);

        // Get the data passed from MainActivity
        String title = getIntent().getStringExtra("title");
        String place = getIntent().getStringExtra("place");
        String participants = getIntent().getStringExtra("participants");
        String dateTime = getIntent().getStringExtra("dateTime");

        // Display the meeting information
        displayText.setText("Title: " + title + "\nPlace: " + place + "\nParticipants: " + participants + "\nDate & Time: " + dateTime);
    }
}
