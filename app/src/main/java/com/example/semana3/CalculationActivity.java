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
    private String nombre;
    private double proyecto1D, proyecto2D, quicesD, parcial1D, parcial2D, nota;
    private boolean notasCompletas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculation);

        proyecto1 = findViewById(R.id.proyecto1);
        proyecto2 = findViewById(R.id.proyecto2);
        quices= findViewById(R.id.quices);
        parcial1 = findViewById(R.id.parcial1);
        parcial2 = findViewById(R.id.parcial2);
        buttonCalcular = findViewById(R.id.buttonCalcular);
        calculoLayout = findViewById(R.id.calculoLayout);

        nombre = getIntent().getExtras().getString("name");

        buttonCalcular.setOnClickListener(
                (v) -> {
                    try {
                        proyecto1D = Double.parseDouble(proyecto1.getText().toString());
                        proyecto2D = Double.parseDouble( proyecto2.getText().toString());
                        quicesD = Double.parseDouble(quices.getText().toString());
                        parcial1D = Double.parseDouble(parcial1.getText().toString());
                        parcial2D = Double.parseDouble(parcial2.getText().toString());
                        notasCompletas = true;
                    } catch (NumberFormatException e) {
                        Toast.makeText(this, "Intente denuevo", Toast.LENGTH_SHORT).show();
                        notasCompletas = false;
                    }
                    nota = ((proyecto1D*0.20) + (proyecto2D*0.20) + (quicesD*0.20) + ( parcial1D*0.20) + (parcial2D*0.20));

                    if (notasCompletas){
                        Intent resultActivity = new Intent(this, com.example.semana3.ResultActivity.class);
                        resultActivity.putExtra("nota",  nota);
                        resultActivity.putExtra("nombre", nombre);
                        startActivity(resultActivity);
                        finish();
                    }
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