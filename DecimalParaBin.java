package com.example.decimalparabinario;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextDecimal;
    private TextView textViewBinary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextDecimal = findViewById(R.id.editTextDecimal);
        textViewBinary = findViewById(R.id.textViewBinary);
        Button buttonConvert = findViewById(R.id.buttonConvert);

        buttonConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String decimalText = editTextDecimal.getText().toString();

                if (decimalText.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Por favor, insira um número", Toast.LENGTH_SHORT).show();
                } else {
                    int numeroDecimal = Integer.parseInt(decimalText);
                    if (numeroDecimal < 0) {
                        Toast.makeText(MainActivity.this, "Insira um número positivo", Toast.LENGTH_SHORT).show();
                    } else {
                        String numeroBinario = converterDecimalParaBinario(numeroDecimal);
                        textViewBinary.setText("Resultado: " + numeroBinario);
                    }
                }
            }
        });
    }

    private String converterDecimalParaBinario(int numeroDecimal) {
        if (numeroDecimal == 0) {
            return "0";
        }

        StringBuilder binario = new StringBuilder();
        while (numeroDecimal > 0) {
            int resto = numeroDecimal % 2;
            binario.insert(0, resto);
            numeroDecimal /= 2;
        }
        return binario.toString();
    }
}
