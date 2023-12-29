package com.example.logisticapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainWindow extends AppCompatActivity {

    private ExecutorService executorService = Executors.newSingleThreadExecutor();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_window);
        Intent intetik = getIntent();
        String email = intetik.getStringExtra("email");
        ProgressTasks progressTasks = new ProgressTasks();
        progressTasks.emails = email;
        executorService.submit(progressTasks);

        ImageButton create_button = (ImageButton) findViewById(R.id.finans_button);
        create_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), FinansWindow.class);
                intent.putExtra("money", progressTasks.many);
                view.getContext().startActivity(intent);
            }
        });


        ImageButton buy = (ImageButton) findViewById(R.id.buy);
        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), BuyWindow.class);
                view.getContext().startActivity(intent);
            }
        });

    }

    class ProgressTasks implements Runnable {

        String emails;
        String connectionError = null;
        String many;
        @Override
        public void run() {
            try {
                client.Connect();
                String money = String.valueOf(client.money(emails));
                System.out.println(money);
                TextView textView = findViewById(R.id.dollar_1);
                textView.setText(money);
                many = money;
            } catch (Exception ex) {
                connectionError = ex.getMessage();
            }
        }
    }

}
