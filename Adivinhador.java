package com.example.guessgame;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int randomNumber;
    private EditText inputNumber;
    private TextView feedbackText;
    private Button guessButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputNumber = findViewById(R.id.inputNumber);
        feedbackText = findViewById(R.id.feedbackText);
        guessButton = findViewById(R.id.guessButton);

        startNewGame();

        guessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userInput = inputNumber.getText().toString();
                if (!userInput.isEmpty()) {
                    int guessedNumber = Integer.parseInt(userInput);
                    checkGuess(guessedNumber);
                } else {
                    feedbackText.setText("Por favor, insira um número!");
                }
            }
        });
    }

    private void startNewGame() {
        Random random = new Random();
        randomNumber = random.nextInt(100) + 1; // Número entre 1 e 100
        feedbackText.setText("Adivinhe o número entre 1 e 100");
        inputNumber.setText("");
    }

    private void checkGuess(int guessedNumber) {
        if (guessedNumber > randomNumber) {
            feedbackText.setText("Tente um número menor!");
        } else if (guessedNumber < randomNumber) {
            feedbackText.setText("Tente um número maior!");
        } else {
            feedbackText.setText("Parabéns! Você acertou o número!");
            guessButton.setText("Jogar novamente");
            guessButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startNewGame();
                    guessButton.setText("Adivinhar");
                    guessButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String userInput = inputNumber.getText().toString();
                            if (!userInput.isEmpty()) {
                                int guessedNumber = Integer.parseInt(userInput);
                                checkGuess(guessedNumber);
                            } else {
                                feedbackText.setText("Por favor, insira um número!");
                            }
                        }
                    });
                }
            });
        }
    }
}
