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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

        buttonRosa = findViewById(R.id.buttonRosa);
        buttonGris = findViewById(R.id.buttonGris);
        buttonBlanco = findViewById(R.id.buttonBlanco);

        configLayout = findViewById(R.id.configLayout);


        SharedPreferences data = getSharedPreferences("data", MODE_PRIVATE);

        buttonRosa.setOnClickListener(
                (v) -> {
                    data.edit().putString("background", "#F9D5C7").apply();
                    finish();
                }
        );
        buttonGris.setOnClickListener(
                (v) -> {
                    data.edit().putString("background", "#BCBFA3").apply();
                    finish();
                }
        );
        buttonBlanco.setOnClickListener(
                (v) -> {
                    data.edit().putString("background", "#FFFFFF" ).apply();
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
