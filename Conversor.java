package com.example.currencyconverter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText inputAmount;
    private TextView resultText;
    private final double exchangeRate = 5.00; // Taxa de câmbio fixa para exemplo

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputAmount = findViewById(R.id.inputAmount);
        resultText = findViewById(R.id.resultText);
        Button convertToRealButton = findViewById(R.id.convertToRealButton);
        Button convertToDollarButton = findViewById(R.id.convertToDollarButton);

        convertToRealButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertToReal();
            }
        });

        convertToDollarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertToDollar();
            }
        });
    }

    private void convertToReal() {
        String amountText = inputAmount.getText().toString();
        if (!amountText.isEmpty()) {
            double amountInDollar = Double.parseDouble(amountText);
            double amountInReal = amountInDollar * exchangeRate;
            resultText.setText(String.format("R$ %.2f", amountInReal));
        } else {
            resultText.setText("Por favor, insira um valor.");
        }
    }

    private void convertToDollar() {
        String amountText = inputAmount.getText().toString();
        if (!amountText.isEmpty()) {
            double amountInReal = Double.parseDouble(amountText);
            double amountInDollar = amountInReal / exchangeRate;
            resultText.setText(String.format("US$ %.2f", amountInDollar));
        } else {
            resultText.setText("Por favor, insira um valor.");
        }
    }
}
