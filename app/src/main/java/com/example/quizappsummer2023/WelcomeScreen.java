package com.example.quizappsummer2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class WelcomeScreen extends AppCompatActivity {

    TextView welcomeTV, nameText1;
    Button nextButton;
    EditText instructionTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        welcomeTV = (TextView) findViewById(R.id.welcomeTV);
        nextButton = (Button) findViewById(R.id.nextButton);
        nameText1 = (TextView) findViewById(R.id.nameText1);
        instructionTV = (EditText) findViewById(R.id.instructionTV);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(WelcomeScreen.this, MainActivity.class);
              String name = instructionTV.getText().toString();
              intent.putExtra("name", name);
               startActivity(intent);
            }
        });
    }
}