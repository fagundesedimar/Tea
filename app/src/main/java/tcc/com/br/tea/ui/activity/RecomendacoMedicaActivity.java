package tcc.com.br.tea.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.TextViewCompat;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.EditText;

import tcc.com.br.tea.R;

public class RecomendacoMedicaActivity extends AppCompatActivity {

    private EditText recomendaçoesParaDependente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recomendacao_medica);

        configuraTextViewRecomendacao();

    }

    @SuppressLint("WrongViewCast")
    private void configuraTextViewRecomendacao() {
        recomendaçoesParaDependente = (EditText) findViewById(R.id.recomendaçoes_para_dependente);

        TextViewCompat
                .setAutoSizeTextTypeWithDefaults(
                        recomendaçoesParaDependente, /* TextView. */
                        TextViewCompat.AUTO_SIZE_TEXT_TYPE_UNIFORM /* Configuração. */
                );

    }


}
