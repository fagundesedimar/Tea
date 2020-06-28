package tcc.com.br.tea.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import tcc.com.br.tea.R;

public class InserirMedicamentoActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "INSIRA OS MEDICAMENTOS:";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserir_medicamento);

        setTitle(TITULO_APPBAR);



    }
}
