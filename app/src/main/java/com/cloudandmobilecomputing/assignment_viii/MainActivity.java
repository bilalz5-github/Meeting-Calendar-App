package com.cloudandmobilecomputing.assignment_viii;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import java.util.Calendar;

public class MainActivity extends Activity {
    private EditText title, place, participants, dateTime;
    private Button submit, search, update, settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize all UI components
        title = findViewById(R.id.editTitle);
        place = findViewById(R.id.editPlace);
        participants = findViewById(R.id.editParticipants);
        dateTime = findViewById(R.id.editDateTime);
        submit = findViewById(R.id.btnSubmit);
        search = findViewById(R.id.btnSearch);
        update = findViewById(R.id.btnUpdate);
        settings = findViewById(R.id.btnSettings);

        // Load and apply user-defined preferences
        applyPreferences();

        setupButtonListeners();
    }

    private void setupButtonListeners() {
        submit.setOnClickListener(v -> {
            Meeting meeting = new Meeting(
                    title.getText().toString(),
                    place.getText().toString(),
                    participants.getText().toString(),
                    dateTime.getText().toString()
            );
            Meeting.meetings.add(meeting);
            Intent intent = new Intent(MainActivity.this, DisplayActivity.class);
            intent.putExtra("title", meeting.getTitle());
            intent.putExtra("place", meeting.getPlace());
            intent.putExtra("participants", meeting.getParticipants());
            intent.putExtra("dateTime", meeting.getDateTime());
            startActivity(intent);
        });

        search.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, SearchActivity.class)));
        update.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, UpdateActivity.class)));
        settings.setOnClickListener(this::openSettings);

        dateTime.setOnClickListener(v -> showDateTimeDialog());
    }

    private void openSettings(View view) {
        startActivity(new Intent(this, SettingsActivity.class));
    }

    private void showDateTimeDialog() {
        final Calendar calendar = Calendar.getInstance();
        new DatePickerDialog(this, (view, year, month, dayOfMonth) -> {
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, month);
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

            new TimePickerDialog(this, (view1, hourOfDay, minute) -> {
                dateTime.setText(String.format("%02d/%02d/%d %02d:%02d", dayOfMonth, month + 1, year, hourOfDay, minute));
            }, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), false).show();
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        applyPreferences();  // Apply the preferences every time the activity resumes
    }


    private void applyPreferences() {
        LinearLayout layout = findViewById(R.id.mainLayout);
        String bgColor = PreferencesUtil.getPreference(this, "background_color", "#FFFFFF");
        String fontColor = PreferencesUtil.getPreference(this, "font_color", "#000000");

        layout.setBackgroundColor(Color.parseColor(bgColor));

        int fontSize = PreferencesUtil.getPreference(this, "font_size", 16);
        title.setTextSize(fontSize);
        place.setTextSize(fontSize);
        participants.setTextSize(fontSize);
        dateTime.setTextSize(fontSize);

        int parsedFontColor = Color.parseColor(fontColor);
        title.setTextColor(parsedFontColor);
        place.setTextColor(parsedFontColor);
        participants.setTextColor(parsedFontColor);
        dateTime.setTextColor(parsedFontColor);
    }

}
