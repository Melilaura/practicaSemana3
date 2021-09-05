package com.example.semana3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;



public class MainActivity extends AppCompatActivity {

    private Button buttonConfig, buttonContinuar;
    private EditText textNombre;
    private ConstraintLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonConfig = findViewById(R.id.buttonConfig);
        buttonContinuar = findViewById(R.id.buttonContinuar);
        textNombre = findViewById(R.id.textNombre);
        mainLayout = findViewById(R.id.mainLayout);

        buttonConfig.setOnClickListener(
                (v) -> {
                    Intent ConfigActivity = new Intent(this, ConfigActivity.class);
                    startActivity(ConfigActivity);
                }
        );

        buttonContinuar.setOnClickListener(
                (v) -> {
                    String name = textNombre.getText().toString();
                    Intent calculationActivity = new Intent(this, CalculationActivity.class);
                    calculationActivity.putExtra("name", name);
                    startActivity(calculationActivity);
                    textNombre.getText().clear();
                }
        );

    }

   @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences data = getSharedPreferences("data", MODE_PRIVATE);
        String background = data.getString("background", "#FFFFFF");
        mainLayout.setBackgroundColor(Color.parseColor(background));
    }


}