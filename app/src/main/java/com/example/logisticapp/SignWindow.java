package com.example.logisticapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SignWindow extends AppCompatActivity {
    private ExecutorService executorService = Executors.newSingleThreadExecutor();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in_window);

        Button registration_button = (Button) findViewById(R.id.signs_button);
        registration_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText emails = (EditText) findViewById( R.id.email_sign);
                EditText passwords = (EditText) findViewById( R.id.password_sign);
                ProgressTasks progressTasks = new ProgressTasks();
                try {
                    progressTasks.user = new User(emails, passwords);
                } catch (NoSuchAlgorithmException e) {
                    throw new RuntimeException(e);
                } catch (InvalidKeySpecException e) {
                    throw new RuntimeException(e);
                }
                progressTasks.view = view;
                executorService.submit(progressTasks);
            }
        });

    }

    class ProgressTasks implements Runnable {

        View view;
        User user;
        String connectionError = null;
        @Override
        public void run() {
            try {
                client.Connect();
                boolean register = client.SignUser(user);
                System.out.println(register);
                if (register){
                    Intent intent = new Intent(view.getContext(), MainWindow.class);
                    view.getContext().startActivity(intent);
                }
            } catch (Exception ex) {
                connectionError = ex.getMessage();
            }
        }
    }

}