package tcc.com.br.tea.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import tcc.com.br.tea.R;

public class VerRecomendacoesActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "RECOMENDAÇÕES MÉDICAS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_recomendacoes);

        setTitle(TITULO_APPBAR);

    }


}
