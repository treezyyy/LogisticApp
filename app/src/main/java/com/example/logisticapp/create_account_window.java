package com.example.logisticapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.SQLException;
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
                ProgressTask progressTask = new ProgressTask();
                executorService.submit(progressTask);
            }
        });

    }

    class ProgressTask implements Runnable {
        String connectionError = null;
        @Override
        public void run() {
            try {
                signUpNewUser();
            } catch (Exception ex) {
                connectionError = ex.getMessage();
            }
        }
    }




    private void signUpNewUser() throws SQLException, ClassNotFoundException {

        DataBaseHandler dbHandler = new DataBaseHandler();

        EditText name = (EditText) findViewById( R.id.name_field);
        EditText email = (EditText) findViewById( R.id.email_field);
        EditText password = (EditText) findViewById( R.id.password_field);
        User user = new User(name, email, password);
        dbHandler.signUpUser(user);
    }
}