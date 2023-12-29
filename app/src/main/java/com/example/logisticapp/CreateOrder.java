package com.example.logisticapp;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CreateOrder extends AppCompatActivity {
    private ExecutorService executorService = Executors.newSingleThreadExecutor();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_order);
        Button registration_button = (Button) findViewById(R.id.create_button);
        registration_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText name = (EditText) findViewById( R.id.ssilka);
                EditText email = (EditText) findViewById( R.id.deneg);
               ProgressTask progressTask = new ProgressTask();
                progressTask.order = new Order(name, email);
                executorService.submit(progressTask);
            }
        });

    }

    class ProgressTask implements Runnable {
        Order order;
        String connectionError = null;
        @Override
        public void run() {
            try {
                client.Connect();
                client.createOrder(order);
            } catch (Exception ex) {
                connectionError = ex.getMessage();
            }
        }
    }

}
