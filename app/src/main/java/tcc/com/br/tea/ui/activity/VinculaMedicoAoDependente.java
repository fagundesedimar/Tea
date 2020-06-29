package tcc.com.br.tea.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import tcc.com.br.tea.R;

public class VinculaMedicoAoDependente extends AppCompatActivity {

    public static final String TITULO_APPBAR = "VINCULA MÉDICO(A)";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vincula_medico_ao_dependente);

        setTitle(TITULO_APPBAR);

        Button botaoVinculaMedDependente = findViewById(R.id.btn_vincila_medico_dependente);
        botaoVinculaMedDependente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(VinculaMedicoAoDependente.this, "Médico Vinculado com Sucesso", Toast.LENGTH_LONG).show();
//                Intent intent = new Intent(VinculaMedicoAoDependente.this, VinculaMedicoAoDependente.class);
//                startActivity(intent);
            }
        });


    }
}
