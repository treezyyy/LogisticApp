package com.example.logisticapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class create_account_window extends AppCompatActivity {

    private ExecutorService executorService = Executors.newSingleThreadExecutor();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_account_window);

        Button registration_button = (Button) findViewById(R.id.button_registration);
        registration_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText name = (EditText) findViewById( R.id.name_field);
                EditText email = (EditText) findViewById( R.id.email_field);
                EditText password = (EditText) findViewById( R.id.password_field);
                ProgressTask progressTask = new ProgressTask();
                try {
                    progressTask.user = new User(name, email, password);
                } catch (NoSuchAlgorithmException e) {
                    throw new RuntimeException(e);
                } catch (InvalidKeySpecException e) {
                    throw new RuntimeException(e);
                }
                executorService.submit(progressTask);
            }
        });

    }

    class ProgressTask implements Runnable {
        User user;
        String connectionError = null;
        @Override
        public void run() {
            try {
                client.Connect();
                client.RegisterUser(user);
            } catch (Exception ex) {
                connectionError = ex.getMessage();
            }
        }
    }





}