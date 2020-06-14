package com.nuraffchaniago.kidsquiz.Model;

public class User {

    private int id, totalscore;
    private String name, email, password, gender;

    public User() {
    }

    public User(int id, int totalscore, String name, String email, String gender) {
        this.id = id;
        this.totalscore = totalscore;
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    public User(int id, int totalscore, String name, String email, String password, String gender) {
        this.id = id;
        this.totalscore = totalscore;
        this.name = name;
        this.email = email;
        this.password = password;
        this.gender = gender;


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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
