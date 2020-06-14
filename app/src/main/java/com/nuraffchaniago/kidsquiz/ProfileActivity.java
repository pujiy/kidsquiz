package com.nuraffchaniago.kidsquiz;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.nuraffchaniago.kidsquiz.Model.User;

public class ProfileActivity extends AppCompatActivity {

    private static final String TAG = "ProfileActivity";
    TextView textViewId, textViewUsername, textViewEmail, textViewGender, textViewScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //if the user is not logged in
        //starting the login activity
        if (!SharedPrefmanager.getInstance(this).isLoggedIn()) {
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }



        textViewUsername = (TextView) findViewById(R.id.textViewName);
        textViewEmail = (TextView) findViewById(R.id.textViewEmail);
        textViewGender = (TextView) findViewById(R.id.textViewGender);
        textViewScore = findViewById(R.id.textViewScore);


        //getting the current user
        User user = SharedPrefmanager.getInstance(this).getUser();

        //setting the values to the textviews

        textViewUsername.setText("Name   : "+user.getName());
        textViewEmail.setText("Email    : "+user.getEmail());
        textViewGender.setText("Gender : "+user.getGender());
        textViewScore.setText("Total Score : "+String.valueOf(user.getTotalscore()));

        //when the user presses logout button
        //calling the logout method
        findViewById(R.id.buttonLogout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPrefmanager.getInstance(getApplicationContext()).logout();
                Intent movelogout= new Intent(ProfileActivity.this, GetStartedActivity.class);
                startActivity(movelogout);


            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: activity is destroyed.");
    }
}
