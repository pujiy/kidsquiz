package com.nuraffchaniago.kidsquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.nuraffchaniago.kidsquiz.Adapter.ListLeaderboardAdapter;
import com.nuraffchaniago.kidsquiz.Model.LeaderboardData;
import com.nuraffchaniago.kidsquiz.Model.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class LeaderboardActivity extends AppCompatActivity {

    private static ListView listView;
    ArrayList<LeaderboardData> leaderboardDataArrayList;
    private ListLeaderboardAdapter listAdapter;
    private RequestQueue requestQueue;

    String[] positionLeaderboard = new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    int[] imgCrown = new int[] {R.drawable.crown, R.drawable.crownsilver, R.drawable.crownbronze, R.drawable.four, R.drawable.five, R.drawable.six, R.drawable.seven, R.drawable.eight, R.drawable.nine, R.drawable.ten};

    @Override
    public void onBackPressed() {
        AudioPlay.stopAudio();
        Intent moveMain = new Intent(LeaderboardActivity.this, MainActivity.class);
        startActivity(moveMain);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);
        
        listView = findViewById(R.id.lv_leaderboard);
        User user = SharedPrefmanager.getInstance(this).getUser();

        TextView tvUsername = findViewById(R.id.tv_name);
        TextView tvTotalScore = findViewById(R.id.tv_poin);
        tvUsername.setText(user.getName());
        tvTotalScore.setText(""+user.getTotalscore());

        if(AudioPlay.isplayingAudio == true) {
            Log.d("isiaudio", "true");

            AudioPlay.stopAudio();
        }
        else {
            Log.d("isiaudio",  "false");
        }

        AudioPlay.playAudio(getApplicationContext(), R.raw.ifyourehappyandyouknowit);




        Button buttonProfile = findViewById(R.id.btn_profile);
        buttonProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveProfile= new Intent(LeaderboardActivity.this, ProfileActivity.class);
                startActivity(moveProfile);
            }
        });



        retrieveJson();
    }

    private void retrieveJson() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URLs.URL_LEADERBOARD,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Log.d("strrrrr", ">>" + response);

                        try {

                            JSONObject obj = new JSONObject(response);
                            if(obj.optString("error").equals("false")){

                                leaderboardDataArrayList = new ArrayList<>();
                                JSONArray dataArray  = obj.getJSONArray("users");

                                for (int i = 0; i < dataArray.length(); i++) {

                                    LeaderboardData playerModel = new LeaderboardData();
                                    JSONObject dataobj = dataArray.getJSONObject(i);

                                    playerModel.setName(dataobj.getString("name"));
                                    playerModel.setTotalscore(dataobj.getInt("totalscore"));
                                    playerModel.setPositionleaderboard(positionLeaderboard[i]);
                                    playerModel.setCrown(imgCrown[i]);


                                    leaderboardDataArrayList.add(playerModel);

                                }



                                setupListview();

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //displaying the error in toast if occurrs
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

        // request queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        requestQueue.add(stringRequest);


    }


    private void setupListview() {

        listAdapter = new ListLeaderboardAdapter(this, leaderboardDataArrayList);
        listView.setAdapter(listAdapter);

    }

    
}
    /*JSONArray jsonArray = new JSONArray();
    JSONObject jsonObject = new JSONObject();

    try{
            jsonObject.put("store",storeId);
            jsonObject.put("people", people);
            jsonObject.put("date",reserveDay);
            jsonObject.put("time", reserveTime);
            jsonArray.put(jsonObject);
            Log.i("jsonString", jsonObject.toString());


            }catch(Exception e){

            }

            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, domain + api, jsonObject,
            new Response.Listener<JSONObject>(){
@Override
public void onResponse(JSONObject response) {
        Log.e("Response", response.toString());
        try {
        JSONArray arrData = response.getJSONArray("data");
        parseData(arrData);
        } catch (JSONException e) {
        e.printStackTrace();
        }
        }
        },
        new Response.ErrorListener(){
@Override
public void onErrorResponse(VolleyError error) {
        Log.e("Error.Response", error.toString());
        String json = null;
        NetworkResponse response = error.networkResponse;
        if(response != null && response.data != null){
        switch(response.statusCode){
        case 400:

        json = new String(response.data);
        System.out.println(json);
        break;
        }
        //Additional cases
        }
        }
        })
        {
@Override
public Map<String, String> getHeaders() throws AuthFailureError {
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Authorization", finalToken);
        Log.d("headers", headers.toString());
        return headers;
        }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonObjectRequest);
        }

     */