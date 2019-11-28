package com.example.kidsquiz.Model;

public class User {

    private  int id;
    private String name, email, gender, imgurl;

    public User(int id, String name, String email, String gender, String imgurl) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.imgurl = imgurl;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getImgurl() {
        return imgurl;
    }
}
