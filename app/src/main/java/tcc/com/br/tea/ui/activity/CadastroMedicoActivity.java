package tcc.com.br.tea.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import tcc.com.br.tea.R;

public class CadastroMedicoActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "CADASTRO MEDICO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_medico);

        setTitle(TITULO_APPBAR);











    }
}
