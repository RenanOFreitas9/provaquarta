package com.example.listadeprodutos;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText editTextProduto;
    private TextView textViewLista;
    private ArrayList<String> listaDeProdutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextProduto = findViewById(R.id.editTextProduto);
        textViewLista = findViewById(R.id.textViewLista);
        Button buttonAdd = findViewById(R.id.buttonAdd);
        Button buttonMostrarLista = findViewById(R.id.buttonMostrarLista);

        listaDeProdutos = new ArrayList<>();

        // Ação do botão "Adicionar Produto"
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nomeProduto = editTextProduto.getText().toString().trim();

                if (nomeProduto.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Por favor, insira o nome do produto", Toast.LENGTH_SHORT).show();
                } else {
                    listaDeProdutos.add(nomeProduto);
                    editTextProduto.setText(""); // Limpa o campo após adicionar
                    Toast.makeText(MainActivity.this, "Produto adicionado!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Ação do botão "Mostrar Lista"
        buttonMostrarLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listaDeProdutos.isEmpty()) {
                    textViewLista.setText("A lista está vazia.");
                } else {
                    StringBuilder produtos = new StringBuilder("Lista de Produtos:\n");
                    for (String produto : listaDeProdutos) {
                        produtos.append("- ").append(produto).append("\n");
                    }
                    textViewLista.setText(produtos.toString());
                }
            }
        });
    }
}
