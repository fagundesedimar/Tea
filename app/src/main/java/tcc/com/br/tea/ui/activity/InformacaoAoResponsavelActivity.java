package tcc.com.br.tea.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import tcc.com.br.tea.R;

public class InformacaoAoResponsavelActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "MENU PACIENTE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacao_ao_responsavel);

        setTitle(TITULO_APPBAR);


        Button botaoMedicamentoDoDep = findViewById(R.id.btn_medicameto_inf_ao_respons);
        botaoMedicamentoDoDep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InformacaoAoResponsavelActivity.this, VerMedicamentoActivity.class);
                startActivity(intent);
            }
        });

        Button botaoRecomendacaoDoDep = findViewById(R.id.btn_recomendaçoes_inf_ao_respons);
        botaoRecomendacaoDoDep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InformacaoAoResponsavelActivity.this, VerRecomendacoesActivity.class);
                startActivity(intent);
            }
        });

        Button botaoAddCrisesDoDep = findViewById(R.id.btn_addCrises_inf_ao_respons);
        botaoAddCrisesDoDep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InformacaoAoResponsavelActivity.this, RegistrarCriseActivity.class);
                startActivity(intent);
            }
        });

        // Botao responsavel para mostra alertas de crises da escola, como alguma observaçoes feita pelo professor
        Button botaoAlerta = findViewById(R.id.btn_alerta_inf_ao_respons);
        botaoAlerta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InformacaoAoResponsavelActivity.this, MenuAlertaDependenteActivity.class);
                startActivity(intent);
            }
        });


    }




}
