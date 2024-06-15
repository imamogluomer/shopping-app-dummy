package com.example.shoppingapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {

    private Switch switchNotifications;
    private RadioGroup radioGroupLanguage;
    private RadioButton radioEnglish, radioTurkish;
    private Button btnSaveSettings;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        switchNotifications = findViewById(R.id.switchNotifications);
        radioGroupLanguage = findViewById(R.id.radioGroupLanguage);
        radioEnglish = findViewById(R.id.radioEnglish);
        radioTurkish = findViewById(R.id.radioTurkish);
        btnSaveSettings = findViewById(R.id.btnSaveSettings);

        sharedPreferences = getSharedPreferences("Settings", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        // Load saved settings
        loadSettings();

        btnSaveSettings.setOnClickListener(v -> {
            saveSettings();
        });
    }

    private void loadSettings() {
        boolean notificationsEnabled = sharedPreferences.getBoolean("notifications", false);
        String language = sharedPreferences.getString("language", "English");

        switchNotifications.setChecked(notificationsEnabled);
        if (language.equals("English")) {
            radioEnglish.setChecked(true);
        } else if (language.equals("Türkçe")) {
            radioTurkish.setChecked(true);
        }
    }

    private void saveSettings() {
        boolean notificationsEnabled = switchNotifications.isChecked();
        String language = radioEnglish.isChecked() ? "English" : "Turkish";

        editor.putBoolean("notifications", notificationsEnabled);
        editor.putString("language", language);
        editor.apply();

        Toast.makeText(this, "Settings saved", Toast.LENGTH_SHORT).show();
    }
}
