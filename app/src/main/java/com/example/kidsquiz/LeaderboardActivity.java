package com.example.kidsquiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.kidsquiz.Adapter.ListLeaderboardAdapter;
import com.example.kidsquiz.Model.LeaderboardData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class LeaderboardActivity extends AppCompatActivity {

    private static ListView listView;
    ArrayList<LeaderboardData> dataModelArrayList;
    private ListLeaderboardAdapter listAdapter;

    String[] positionLeaderboard = new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    int[] imgCrown = new int[] {R.drawable.crown, R.drawable.crown, R.drawable.crown, R.drawable.leaderboardgrey, R.drawable.leaderboardgrey, R.drawable.leaderboardgrey, R.drawable.leaderboardgrey, R.drawable.leaderboardgrey, R.drawable.leaderboardgrey, R.drawable.leaderboardgrey};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);
        
        listView = findViewById(R.id.lv_leaderboard);

        
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

                                dataModelArrayList = new ArrayList<>();
                                JSONArray dataArray  = obj.getJSONArray("users");

                                for (int i = 0; i < dataArray.length(); i++) {

                                    LeaderboardData playerModel = new LeaderboardData();
                                    JSONObject dataobj = dataArray.getJSONObject(i);

                                    playerModel.setName(dataobj.getString("name"));
                                    playerModel.setPoin(dataobj.getString("poin"));
                                    playerModel.setPositionLeaderboard(positionLeaderboard[i]);
                                    playerModel.setImgCrown(imgCrown[i]);


                                    dataModelArrayList.add(playerModel);

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

        listAdapter = new ListLeaderboardAdapter(this, dataModelArrayList);
        listView.setAdapter(listAdapter);

    }

    
}
