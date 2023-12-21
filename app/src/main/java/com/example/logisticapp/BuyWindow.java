package com.example.logisticapp;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;

import java.io.IOException;

public class BuyWindow extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finas_window);

        EditText Money = (EditText) findViewById( R.id.money_field);

        TextView create_button = (TextView) findViewById(R.id.coins_rubels);
        create_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String url = client.PayMenent(String.valueOf(Money));
                } catch (IOException | JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        });

    }


}
