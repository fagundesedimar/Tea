package tcc.com.br.tea.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import tcc.com.br.tea.R;


public class MenuProfActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "ACESSO PROFESSOR(A)" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_prof);

        setTitle(TITULO_APPBAR);


        Button botaoRecomendacaoDoDepProf = findViewById(R.id.bnt_ver_recomendacoes_menu_prof);
        botaoRecomendacaoDoDepProf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuProfActivity.this, VerRecomendacoesActivity.class);
                startActivity(intent);
            }
        });

        Button botaoAddCrisesDoDepProf = findViewById(R.id.bnt_add_crises_menu_prof);
        botaoAddCrisesDoDepProf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuProfActivity.this, RegistrarCriseActivity.class);
                startActivity(intent);
            }
        });



    }
}
