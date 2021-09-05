package com.example.semana3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class ResultActivity extends AppCompatActivity {

    private ConstraintLayout resultLayout;
    private TextView  holaText, resultadoText;
    private Button buttonCalcular2;
    private String  nombreText, notaFinal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        resultLayout = findViewById(R.id.resultLayout);
        resultadoText = findViewById(R.id.resultadoText);
        holaText = findViewById(R.id.holaText);
        buttonCalcular2 = findViewById(R.id. buttonCalcular2);

        Intent i =getIntent();
        Intent j =getIntent();
        nombreText = j.getStringExtra("nombre");
        holaText.setText("Hola, " + nombreText + ".\n Tu nota final es de:");
        notaFinal= i.getStringExtra("nota Final");
        resultadoText.setText(notaFinal);

        buttonCalcular2.setOnClickListener(
                (v) -> {
                    Intent mainActivity = new Intent(this, MainActivity.class);
                    startActivity(mainActivity);
                }
        );


    }
    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences data = getSharedPreferences("data", MODE_PRIVATE);
        String background = data.getString("background", "#FFFFFF");
        resultLayout.setBackgroundColor(Color.parseColor(background));
    }
}