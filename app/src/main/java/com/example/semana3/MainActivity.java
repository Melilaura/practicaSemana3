package com.example.semana3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

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

                    Intent configActivity = new Intent(this, ConfigActivity.class);
                    startActivity(configActivity);
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
}