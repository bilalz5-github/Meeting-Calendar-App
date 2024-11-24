package com.cloudandmobilecomputing.assignment_viii;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

public class SettingsActivity extends Activity {
    private GridLayout fontColorGrid, bgColorGrid;
    private String selectedFontColor = "#000000"; // Default black
    private String selectedBgColor = "#FFFFFF";   // Default white
    private Button saveButton;
    private EditText etFontSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        fontColorGrid = findViewById(R.id.fontColorGrid);
        bgColorGrid = findViewById(R.id.bgColorGrid);
        saveButton = findViewById(R.id.saveSettingsButton);
        etFontSize=findViewById(R.id.fontSizeInput);

        populateColorGrid(fontColorGrid, true);
        populateColorGrid(bgColorGrid, false);

        saveButton.setOnClickListener(v -> {
            // Save font color and background color preferences
            PreferencesUtil.savePreference(this, "font_color", selectedFontColor);
            PreferencesUtil.savePreference(this, "background_color", selectedBgColor);

            // Save font size preference
            String fontSizeInput = etFontSize.getText().toString().trim();
            if (!fontSizeInput.isEmpty()) {
                PreferencesUtil.savePreference(this, "font_size", Integer.parseInt(fontSizeInput));
            }

            Toast.makeText(this, "Settings Saved!", Toast.LENGTH_SHORT).show();
            finish();
        });

    }

    private void populateColorGrid(GridLayout grid, boolean isFontColor) {
        int[] colors = {
                Color.BLACK, Color.WHITE, Color.RED, Color.GREEN, Color.BLUE,
                Color.YELLOW, Color.CYAN, Color.MAGENTA, Color.DKGRAY, Color.LTGRAY
        };

        for (int color : colors) {
            TextView colorView = new TextView(this);
            colorView.setBackgroundColor(color);
            colorView.setLayoutParams(new GridLayout.LayoutParams());
            colorView.setWidth(100);
            colorView.setHeight(100);
            colorView.setPadding(8, 8, 8, 8);

            colorView.setOnClickListener(v -> {
                if (isFontColor) {
                    selectedFontColor = String.format("#%06X", (0xFFFFFF & color));
                    Toast.makeText(this, "Font Color Selected: " + selectedFontColor, Toast.LENGTH_SHORT).show();
                } else {
                    selectedBgColor = String.format("#%06X", (0xFFFFFF & color));
                    Toast.makeText(this, "Background Color Selected: " + selectedBgColor, Toast.LENGTH_SHORT).show();
                }
            });

            grid.addView(colorView);
        }
    }
}
