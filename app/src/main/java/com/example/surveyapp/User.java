package com.example.surveyapp;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private byte yes,no;
    public User() {

    }
    public User(String name, byte yes, byte no) {
        this.name = name;
        this.yes = yes;
        this.no = no;
    }


    public byte getNo() {
        return no;
    }

    public void setNo(byte no) {
        this.no = no;
    }

    public byte getYes() {
        return yes;
    }

    public void setYes(byte yes) {
        this.yes = yes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
