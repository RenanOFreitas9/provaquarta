package com.example.imccalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText inputWeight;
    private EditText inputHeight;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputWeight = findViewById(R.id.inputWeight);
        inputHeight = findViewById(R.id.inputHeight);
        resultText = findViewById(R.id.resultText);
        Button calculateButton = findViewById(R.id.calculateButton);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });
    }

    private void calculateBMI() {
        String weightText = inputWeight.getText().toString();
        String heightText = inputHeight.getText().toString();

        if (!weightText.isEmpty() && !heightText.isEmpty()) {
            double weight = Double.parseDouble(weightText);
            double heightInCm = Double.parseDouble(heightText);
            double heightInMeters = heightInCm / 100; // Conversão para metros

            double bmi = weight / (heightInMeters * heightInMeters);
            String bmiCategory = classifyBMI(bmi);

            resultText.setText(String.format("Seu IMC é: %.2f\nClassificação: %s", bmi, bmiCategory));
        } else {
            resultText.setText("Por favor, insira peso e altura.");
        }
    }

    private String classifyBMI(double bmi) {
        if (bmi < 18.5) {
            return "Abaixo do peso";
        } else if (bmi >= 18.5 && bmi < 24.9) {
            return "Peso normal";
        } else if (bmi >= 25 && bmi < 29.9) {
            return "Sobrepeso";
        } else {
            return "Obesidade";
        }
    }
}
