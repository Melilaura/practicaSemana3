package com.example.semana3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class CalculationActivity extends AppCompatActivity {

    private ConstraintLayout calculoLayout;
    private EditText proyecto1, proyecto2, quices, parcial1, parcial2;
    private Button buttonCalcular;
    private String nombreString, notaFinalString;
    private double proyecto1Double, proyecto2Double, quicesDouble, parcial1Double, parcial2Double, notaFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculation);

        calculoLayout = findViewById(R.id.calculoLayout);

        proyecto1 = findViewById(R.id.proyecto1);
        proyecto2 = findViewById(R.id.proyecto2);
        quices= findViewById(R.id.quices);
        parcial1 = findViewById(R.id.parcial1);
        parcial2 = findViewById(R.id.parcial2);
        buttonCalcular = findViewById(R.id.buttonCalcular);

        nombreString = getIntent().getExtras().getString("nombre");


        buttonCalcular.setOnClickListener(
                (v) -> {
                    proyecto1Double = Double.parseDouble(proyecto1.getText().toString());
                    proyecto2Double = Double.parseDouble( proyecto2.getText().toString());
                    quicesDouble = Double.parseDouble(quices.getText().toString());
                    parcial1Double = Double.parseDouble(parcial1.getText().toString());
                    parcial2Double = Double.parseDouble(parcial2.getText().toString());

                    notaFinal = ((proyecto1Double*0.20) + (proyecto2Double*0.20) + (quicesDouble*0.20) + ( parcial1Double*0.20) + (parcial2Double*0.20));

                    notaFinalString= String.valueOf(notaFinal);

                    Intent resultActivity = new Intent(this, ResultActivity.class);
                    resultActivity.putExtra("nota Final",  notaFinalString);
                    resultActivity.putExtra("nombre", nombreString);
                    startActivity(resultActivity);
                }
        );
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences data = getSharedPreferences("data", MODE_PRIVATE);
        String background = data.getString("background", "#FFFFFF");
        calculoLayout.setBackgroundColor(Color.parseColor(background));
    }
}