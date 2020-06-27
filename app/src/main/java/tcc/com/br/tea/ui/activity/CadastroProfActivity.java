package tcc.com.br.tea.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import tcc.com.br.tea.R;

public class CadastroProfActivity extends AppCompatActivity {

    public static String TITULO_APPBAR = "CADASTRO PROFESSOR(A)";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_prof);

        setTitle(TITULO_APPBAR);



    }

}
