package com.bido.courses.firebase;

public class UserData {
    private String Fname,Lname,Email;

    public UserData() {
    }

    public UserData(String fname, String lname, String email) {
        Fname = fname;
        Lname = lname;
        Email = email;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String fname) {
        Fname = fname;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String lname) {
        Lname = lname;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }




}
