package com.example.logisticapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FinansWindow extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finas_window);
        Intent intetik = getIntent();
        String money = intetik.getStringExtra("money");
        TextView textView = findViewById(R.id.dollar_2);
        textView.setText(money);

        ImageButton registration_button = (ImageButton) findViewById(R.id.umany_button);
        registration_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent telegram = new Intent(Intent.ACTION_VIEW , Uri.parse("https://t.me/LogistAppBot"));
                startActivity(telegram);
                }
        });



    }
}
