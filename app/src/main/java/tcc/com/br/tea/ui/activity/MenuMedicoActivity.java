package tcc.com.br.tea.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import tcc.com.br.tea.R;

public class MenuMedicoActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "ACESSO DO MEDICO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_medico);

        setTitle(TITULO_APPBAR);

        Button botaoAddMedicacao = findViewById(R.id.bnt_medicacao_menu_medico);
        botaoAddMedicacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuMedicoActivity.this, InserirMedicamentoActivity.class);
                startActivity(intent);
            }
        });

        Button botaoAddRecomendacoes = findViewById(R.id.bnt_recomendacoes_menu_medico);
        botaoAddRecomendacoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuMedicoActivity.this, RecomendacoMedicaActivity.class);
                startActivity(intent);
            }
        });

        Button botaoCrises = findViewById(R.id.bnt_crises_menu_medico);
        botaoCrises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuMedicoActivity.this, RecomendacoMedicaActivity.class);
                startActivity(intent);
            }
        });



    }
}
