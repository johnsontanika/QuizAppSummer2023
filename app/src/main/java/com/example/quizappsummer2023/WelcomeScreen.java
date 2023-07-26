package com.example.quizappsummer2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WelcomeScreen extends AppCompatActivity {

    TextView welcomeTV;
    Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        welcomeTV = (TextView) findViewById(R.id.welcomeTV);
        nextButton = (Button) findViewById(R.id.nextButton);

        Intent incomingIntent = getIntent();

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}