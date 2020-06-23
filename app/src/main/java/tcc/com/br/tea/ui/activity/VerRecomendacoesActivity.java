package tcc.com.br.tea.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.TextViewCompat;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.EditText;

import tcc.com.br.tea.R;

public class VerRecomendacoesActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "RECOMENDAÇÕES MÉDICAS";

    private EditText recomendaçoesParaDependente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_recomendacoes);

        setTitle(TITULO_APPBAR);

    }

    @SuppressLint("WrongViewCast")
    private void configuraTextViewRecomendacao() {
        recomendaçoesParaDependente = (EditText) findViewById(R.id.editText12);

        TextViewCompat
                .setAutoSizeTextTypeWithDefaults(
                        recomendaçoesParaDependente, /* TextView. */
                        TextViewCompat.AUTO_SIZE_TEXT_TYPE_UNIFORM /* Configuração. */
                );

    }


}
