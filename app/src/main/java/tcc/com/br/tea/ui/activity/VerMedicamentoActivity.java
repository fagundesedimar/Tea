package tcc.com.br.tea.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import tcc.com.br.tea.R;

public class VerMedicamentoActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "VER MEDICAÇÃO DO PACIENTE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_medicamento);

        setTitle(TITULO_APPBAR);

    }


}
