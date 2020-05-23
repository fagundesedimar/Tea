package tcc.com.br.tea.ui.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;

import tcc.com.br.tea.R;

public class EscolhaSouUmActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "SEJA BEM VINDO  : )";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolha_sou_um);

        setTitle(TITULO_APPBAR);


        Button botaoSouMedico = findViewById(R.id.btn_sou_medico);
        botaoSouMedico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EscolhaSouUmActivity.this, LoginMedicoActivity.class);
                startActivity(intent);
            }
        });

        Button botaoSouResponsavel = findViewById(R.id.btn_sou_responsavel);
        botaoSouResponsavel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EscolhaSouUmActivity.this, LoginResponsavelActivity.class);
                startActivity(intent);
            }
        });

        Button botaoSouProfessor = findViewById(R.id.btn_sou_professor);
        botaoSouProfessor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EscolhaSouUmActivity.this, LoginProfActivity.class);
                startActivity(intent);
            }
        });








//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

}
