package com.example.dell.womensafetyapp;

/**
 * Created by DELL on 12-05-2018.
 */

public class Users {
    String name = "";
    //String username = "";
    String email = "";
    String phoneno = "";
    String password = "";
    String confirmpass = "";
    String emerno1="";
    String emerno2="";
    String emerno3="";
    String emerno4="";
    String token = "";
    //private int timageResourceId = NO_IMAGE_PROVIDED;
    //private static final int NO_IMAGE_PROVIDED = -1;

    public Users(String shreya, int ic_launcher_background) {
    }

    public Users(String name, String email, String phoneno, String password, String confirmpass,
                String emerno1, String emerno2, String emerno3, String emerno4, String token)
    {
        this.name = name;
        //this.username = username;
        this.email = email;
        this.phoneno = phoneno;
        this.password = password;
        this.confirmpass = confirmpass;
        this.emerno1 = emerno1;
        this.emerno2 = emerno2;
        this.emerno3 = emerno3;
        this.emerno4 = emerno4;
        this.token = token;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //public String getUsername() {
    //  return username;
    //}

    //public void setUsername(String username) {
    //  this.username = username;
    //}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmpass() {
        return confirmpass;
    }

    public void setConfirmpass(String confirmpass) {
        this.confirmpass = confirmpass;
    }

    public String getEmerno1(){ return emerno1; }

    public void setEmerno1(String emerno1) { this.emerno1 = emerno1; }

    public String getEmerno2(){ return emerno2; }

    public void setEmerno2(String emerno2) { this.emerno2 = emerno2; }

    public String getEmerno3(){ return emerno3; }

    public void setEmerno3(String emerno1) { this.emerno3 = emerno3; }

    public String getEmerno4(){ return emerno4; }

    public void setEmerno4(String emerno4) { this.emerno4 = emerno4; }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


}

