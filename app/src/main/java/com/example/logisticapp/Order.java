package com.example.logisticapp;

import android.widget.EditText;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class Order {
    private String link;
    private double price;

    public Order(EditText link, EditText price) {
        this.link = String.valueOf(link.getText());
        this.price= Double.parseDouble(String.valueOf(price.getText()));
    }

    public Order() {

    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}

