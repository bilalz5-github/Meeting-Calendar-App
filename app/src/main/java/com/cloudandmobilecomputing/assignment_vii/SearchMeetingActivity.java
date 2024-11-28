package com.cloudandmobilecomputing.assignment_vii;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class SearchMeetingActivity extends AppCompatActivity {

    private EditText searchDateTime;
    private Button searchButton;
    private TextView searchResults;

    // List of meetings (could be replaced with data from a database or storage)
    private List<Meeting> meetingsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_meeting);

        meetingsList = (ArrayList<Meeting>) getIntent().getSerializableExtra("meetingList");


        // Initialize the UI components
        searchDateTime = findViewById(R.id.searchDateTime);
        searchButton = findViewById(R.id.searchButton);
        searchResults = findViewById(R.id.searchResults);

        // Adding sample meetings to the list
        meetingsList.add(new Meeting("Team Meeting", "Room A", "Awais , Azeem", "2024-11-07 10:00"));
        meetingsList.add(new Meeting("Client Meeting", "Room B", "Joseph, Inka, Adam", "2024-11-07 14:00"));
        meetingsList.add(new Meeting("Project Discussion", "Room C", "Anjan, Bilal, Ahlam", "2024-11-08 09:00"));

        // Set the listener for the search button
        searchButton.setOnClickListener(v -> {
            String query = searchDateTime.getText().toString().trim();

            // Perform the search and update UI
            if (!query.isEmpty()) {
                List<String> results = searchMeetings(query);
                displaySearchResults(results);
            } else {
                searchResults.setText("Please enter a search query.");
            }
        });
    }

    // Method to search meetings based on the query
    private List<String> searchMeetings(String query) {
        List<String> results = new ArrayList<>();

        // Loop through the meetings and check for matches with participants or date/time
        for (Meeting meeting : meetingsList) {

            if (meeting.getParticipants().toLowerCase().contains(query.toLowerCase()) ||
                    meeting.getDateTime().contains(query)) {
                results.add(meeting.getMeetingSummary()); // Add meeting summary to results
            }
        }

        return results;
    }

    // Method to display the search results in the TextView
    private void displaySearchResults(List<String> results) {
        if (results.isEmpty()) {
            searchResults.setText("No meetings found with the given query.");
        } else {
            StringBuilder resultText = new StringBuilder();
            for (String result : results) {
                resultText.append(result).append("\n\n");
            }
            searchResults.setText(resultText.toString());
        }
    }
}
