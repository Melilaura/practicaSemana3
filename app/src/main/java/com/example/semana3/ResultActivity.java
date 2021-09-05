package com.example.semana3;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class ResultActivity extends AppCompatActivity {

    private ConstraintLayout resultLayout;
    private TextView holaText, resultadoText;
    private Button buttonCalcular2;
    private String nombre, nota;
    private double notaFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        resultLayout = findViewById(R.id.resultLayout);
        holaText = findViewById(R.id.holaText);
        resultadoText = findViewById(R.id.resultadoText);
        buttonCalcular2 = findViewById(R.id.buttonCalcular2);

        nombre = getIntent().getExtras().getString("nombre");
        notaFinal = getIntent().getExtras().getDouble("nota");
        nota = String.format("%.2f", nota);

        holaText.setText("Hola, " + nombre + ", tu nota final es de:");
        resultadoText.setText(nota);

        buttonCalcular2.setOnClickListener(
                (v) -> finish()
        );
    }
}