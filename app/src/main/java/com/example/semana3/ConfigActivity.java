package com.example.semana3;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class ConfigActivity extends AppCompatActivity {

    private Button buttonRosa, buttonGris, buttonBlanco;
    private ConstraintLayout configLayout;
    private String pinkColor, grayColor, whiteColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

        configLayout = findViewById(R.id.configLayout);

        buttonRosa = findViewById(R.id.buttonRosa);
        buttonGris = findViewById(R.id.buttonGris);
        buttonBlanco = findViewById(R.id.buttonBlanco);


        whiteColor = "#FFFFFF";
        grayColor = "#BCBFA3";
        pinkColor = "#F9D5C7";

        SharedPreferences data = getSharedPreferences("data", MODE_PRIVATE);

        buttonRosa.setOnClickListener(
                (view) -> {
                    data.edit().putString("background", pinkColor).apply();
                    finish();
                }
        );
        buttonGris.setOnClickListener(
                (view) -> {
                    data.edit().putString("background", grayColor).apply();
                    finish();
                }
        );
        buttonBlanco.setOnClickListener(
                (view) -> {
                    data.edit().putString("background", whiteColor ).apply();
                    finish();
                }
        );
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences data = getSharedPreferences("data", MODE_PRIVATE);
        String background = data.getString("background", "#FFFFFF");
        configLayout.setBackgroundColor(Color.parseColor(background));
    }
}
