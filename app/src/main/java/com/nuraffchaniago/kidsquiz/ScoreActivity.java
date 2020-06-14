package com.nuraffchaniago.kidsquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.nuraffchaniago.kidsquiz.Model.User;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ScoreActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String EXTRA_SCORE = "score";
    String newtotalscoreprofile;
    int scoreprofile, newscoreprofile;
    TextView tvscore;
    public static String email;
    Button btnSubmit, btnPlayAgain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        tvscore = findViewById(R.id.tv_score);
        btnSubmit = findViewById(R.id.btn_submit);

        btnSubmit.setOnClickListener(this);
        //getting the current user
        User user = SharedPrefmanager.getInstance(this).getUser();
        email = user.getEmail();
        scoreprofile = user.getTotalscore();
        Log.d("email", user.getEmail());
        Log.d("totalscore", ""+user.getTotalscore());
        //setting the values to the textviews

        /*textViewUsername.setText("Name   : "+user.getName());
        textViewEmail.setText("Email    : "+user.getEmail());
        textViewGender.setText("Gender : "+user.getGender());
        textViewScore.setText("Total Score : "+String.valueOf(user.getTotalscore())); */

        final int scorequiztotal = getIntent().getIntExtra(EXTRA_SCORE, 0);

        tvscore.setText(""+scorequiztotal);

        newscoreprofile = scoreprofile + scorequiztotal;
        Log.d("scoreuser", ""+newscoreprofile);

        AudioPlayNotLoop.playAudio(ScoreActivity.this, R.raw.yay);

    }

    @Override
    public void onClick(View view) {

        if(view == btnSubmit) {
            Log.d("VolleyUpdateScore", "Button Success click");
            submitScore();
        }
    }

    @Override
    public void onBackPressed() {
        submitScore();
    }

    private void submitScore() {
        Log.d("VolleyUpdateScore", "ButtonSuccess");
        /*AudioPlay.isplayingAudio = false;
        Intent moveToCat = new Intent(ScoreActivity.this, MainActivity.class);
        startActivity(moveToCat);
         */

        Map params = new HashMap();
        params.put("email", email);
        params.put("total_score", newscoreprofile);
        JSONObject parameters = new JSONObject(params);

        //Json Update Score
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, URLs.URL_UPDATESCORE, parameters,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            Log.d("VolleyResponse", ""+response);
                            //if error false
                            if (!response.getBoolean("error")) {
                                //getting the user from response
                                JSONObject userJson = response.getJSONObject("user");
                                Log.d("Vollejson", ""+userJson);

                                User user = new User(
                                        userJson.getInt("id"),
                                        userJson.getInt("totalscore"),
                                        userJson.getString("name"),
                                        userJson.getString("email"),
                                        userJson.getString("gender")
                                );

                                //storing the user in sharedpref
                                SharedPrefmanager.getInstance(getApplicationContext()).userLogin(user);

                                //starting the profile activity
                                AudioPlay.isplayingAudio = false;
                                Intent moveToCat = new Intent(ScoreActivity.this, MainActivity.class);
                                startActivity(moveToCat);
                                Log.d("VolleyUpdateScore", "Success");

                            } else {
                                Toast.makeText(getApplicationContext(), response.getString("message"), Toast.LENGTH_SHORT).show();
                                Log.d("VolleyUpdateScore", "" + response.getString("message"));

                            }
                        } catch (JSONException e) {
                            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                        Log.d("VolleyUpdateScore", ""+error.getMessage());

                    }
                });

        VolleySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest);
    }
    }
