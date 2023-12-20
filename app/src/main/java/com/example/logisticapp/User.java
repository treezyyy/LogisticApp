package com.example.logisticapp;


import android.widget.EditText;

public class User {

    private int id;
    private String name;
    private String email;
    private String password;

    public User(EditText name, EditText email, EditText password) {
        this.name = String.valueOf(name.getText());
        this.email = String.valueOf(email.getText());
        this.password = String.valueOf(password.getText());
    }

    public User(EditText email, EditText password) {
        this.email = String.valueOf(email.getText());
        this.password = String.valueOf(password.getText());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
