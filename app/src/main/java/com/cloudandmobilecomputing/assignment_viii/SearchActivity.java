package com.cloudandmobilecomputing.assignment_viii;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class SearchActivity extends Activity {
    private EditText searchField;
    private Button searchButton;
    private TextView searchResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        searchField = findViewById(R.id.searchField);
        searchButton = findViewById(R.id.searchButton);
        searchResults = findViewById(R.id.searchResults);

        searchButton.setOnClickListener(v -> {
            String searchTerm = searchField.getText().toString().toLowerCase();
            StringBuilder results = new StringBuilder();
            for (Meeting meeting : Meeting.meetings) {
                if (meeting.getTitle().toLowerCase().contains(searchTerm) ||
                        meeting.getParticipants().toLowerCase().contains(searchTerm) ||
                        meeting.getDateTime().toLowerCase().contains(searchTerm)) {
                    results.append("Title: ").append(meeting.getTitle())
                            .append("\nPlace: ").append(meeting.getPlace())
                            .append("\nParticipants: ").append(meeting.getParticipants())
                            .append("\nDate & Time: ").append(meeting.getDateTime())
                            .append("\n\n");
                }
            }

            if (results.toString().isEmpty()) {
                searchResults.setText("No results found.");
            } else {
                searchResults.setText(results.toString());
            }
        });


    }
}
