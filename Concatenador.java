import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText edtNome, edtSobrenome, edtEndereco;
    private TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNome = findViewById(R.id.edtNome);
        edtSobrenome = findViewById(R.id.edtSobrenome);
        edtEndereco = findViewById(R.id.edtEndereco);
        txtResultado = findViewById(R.id.txtResultado);

        Button btnConcatenar = findViewById(R.id.btnConcatenar);
        btnConcatenar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = edtNome.getText().toString().trim();
                String sobrenome = edtSobrenome.getText().toString().trim();
                String endereco = edtEndereco.getText().toString().trim();

                if (nome.isEmpty() || sobrenome.isEmpty() || endereco.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Erro: Todos os campos são obrigatórios", Toast.LENGTH_SHORT).show();
                } else {
                    String resultado = "Nome completo: " + nome + " " + sobrenome + "\nEndereço: " + endereco;
                    txtResultado.setText(resultado);
                }
            }
        });
    }
}
