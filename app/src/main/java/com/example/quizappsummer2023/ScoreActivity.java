package com.example.quizappsummer2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ScoreActivity extends AppCompatActivity {

    TextView scoreTV, hScore;
    int score, num;
    String name, scoreList;
    Button sendScoreBtn, highScore, retrieveBtn;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("High Score");
    HighScore hS1;

    public static final String TAG = "BHQuiz";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        scoreTV = (TextView) findViewById(R.id.scoreTV);
        scoreList = "";
        sendScoreBtn = (Button) findViewById(R.id.sendScoreBTN);
        highScore = (Button) findViewById(R.id.highScore);
        retrieveBtn = (Button) findViewById(R.id.retreivebtn);
        hScore = (TextView) findViewById(R.id.hScore);
        num = 0;

        sendScoreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String subject = "new score on quiz app";
                String body = "Hello!\n" + "Your score" + score;
                composeEmail(subject, body);
            }
        });
        Intent incomingIntent = getIntent();
        score = incomingIntent.getIntExtra("score", 0);
        name = incomingIntent.getStringExtra("name");


        scoreTV.setText("Score =" + score);
        highScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                hS1 = new HighScore(score, name);
                String key = myRef.push().getKey();
                myRef.child(key).setValue(hS1);
            }
        });

        retrieveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Read from the database
                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.
                        for (DataSnapshot hsSnapShot : dataSnapshot.getChildren()) {

                            if (num < 2){
                                HighScore newHS = hsSnapShot.getValue(HighScore.class);
                                Log.d(TAG, "Value is: " + newHS);

                                num ++;
                                scoreList += newHS.getpName() + "\t" + newHS.getpScore() + "\n";
                            }
                        }
                        hScore.setText(scoreList);
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        Log.w(TAG, "Failed to read value.", error.toException());
                    }
                });
            }

        });


//        retreiveBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d(TAG, "got to retrieve button onClick");
//                // Read from the database
//                myRef.addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(DataSnapshot dataSnapshot) {
//                        // This method is called once with the initial value and again
//                        // whenever data at this location is updated.
//
//                        for (DataSnapshot hSSnapShot : dataSnapshot.getChildren()) {
//                            HighScore newHS = hSSnapShot.getValue(HighScore.class);
//                            Log.d(TAG, "High Score is: " + newHS);
//
//
//                        }
//                    }
//                    @Override
//                    public void onCancelled(DatabaseError error) {
//                        // Failed to read value
//                        Log.w(TAG, "Failed to read High Score.", error.toException());
//                    }
//                });
//            }
//        });
    }

    private void composeEmail(String subject, String body) {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(Uri.parse("mailto:")); // only email apps should handle this
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        emailIntent.putExtra(Intent.EXTRA_TEXT, body);
        if (emailIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(emailIntent);
        }
    }
}