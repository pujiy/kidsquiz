package com.example.kidsquiz.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.kidsquiz.Model.LeaderboardData;
import com.example.kidsquiz.R;

import java.util.ArrayList;

public class ListLeaderboardAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<LeaderboardData> leaderboardDataArrayList;

    public ListLeaderboardAdapter(Context context, ArrayList<LeaderboardData> leaderboardDataArrayList) {
        this.context = context;
        this.leaderboardDataArrayList = leaderboardDataArrayList;
    }

    @Override
    public int getViewTypeCount() {
       return getCount();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getCount() {

        return leaderboardDataArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return leaderboardDataArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Viewholder holder;

        if (convertView == null) {
            holder = new Viewholder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.lv_leaderboard, null, true);

            holder.tvName = convertView.findViewById(R.id.tv_nameleaderboard);
            holder.tvPoin = convertView.findViewById(R.id.tv_poinleaderboard);

            convertView.setTag(holder);
        }

        else {
            // the getTag returns the viewHolder object set as a tag to the view
            holder = (Viewholder) convertView.getTag();
        }

        holder.tvName.setText(leaderboardDataArrayList.get(position).getName());
        holder.tvPoin.setText(leaderboardDataArrayList.get(position).getPoin());

        return convertView;
    }

    private class Viewholder {
        protected TextView tvName, tvPoin;
    }
}
