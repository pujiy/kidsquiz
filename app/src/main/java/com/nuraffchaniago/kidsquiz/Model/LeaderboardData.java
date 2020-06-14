package com.nuraffchaniago.kidsquiz.Model;

public class LeaderboardData {

    private String name, positionleaderboard;
    private int id, totalscore, crown;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPositionleaderboard() {
        return positionleaderboard;
    }

    public void setPositionleaderboard(String positionleaderboard) {
        this.positionleaderboard = positionleaderboard;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotalscore() {
        return totalscore;
    }

    public void setTotalscore(int totalscore) {
        this.totalscore = totalscore;
    }

    public int getCrown() {
        return crown;
    }

    public void setCrown(int crown) {
        this.crown = crown;
    }
}
