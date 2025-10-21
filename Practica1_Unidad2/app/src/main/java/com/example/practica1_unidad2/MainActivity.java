package com.example.practica1_unidad2;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    EditText editTextCalificacion;
    Button buttonEvaluar;
    TextView textViewResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editTextCalificacion = findViewById(R.id.editTextCalificacion);
        buttonEvaluar = findViewById(R.id.buttonEvaluar);
        textViewResultado = findViewById(R.id.textViewResultado);


        buttonEvaluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String calificacionStr = editTextCalificacion.getText().toString().trim();


                if (calificacionStr.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Por favor ingresa una calificación", Toast.LENGTH_SHORT).show();
                    return;
                }


                try {
                    double calificacion = Double.parseDouble(calificacionStr);
                    String resultado;


                    if (calificacion < 8) {
                        resultado = "Nivel de aprovechamiento: NA";
                    } else if (calificacion >= 8 && calificacion < 9) {
                        resultado = "Nivel de aprovechamiento: SA";
                    } else if (calificacion >= 9 && calificacion < 9.5) {
                        resultado = "Nivel de aprovechamiento: DE";
                    } else if (calificacion >= 9.5 && calificacion <= 10) {
                        resultado = "Nivel de aprovechamiento: AU";
                    } else {
                        resultado = "Calificación no válida";
                    }


                    textViewResultado.setText(resultado);
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Formato no válido. Usa solo números.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}