package tcc.com.br.tea.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import tcc.com.br.tea.R;

public class ListaPacientesMedicoActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "LISTA PACIENTE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacientes_medico);

        setTitle(TITULO_APPBAR);

        //Button btnSair = findViewById();


    }
}
