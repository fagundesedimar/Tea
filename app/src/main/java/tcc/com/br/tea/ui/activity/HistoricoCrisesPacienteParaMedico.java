package tcc.com.br.tea.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import tcc.com.br.tea.R;

public class HistoricoCrisesPacienteParaMedico extends AppCompatActivity {

    public static final String TITULO_APPBAR = "HISTÓRICO CRISES E CONFIGURA SEMÁFORO";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico_crises_pacie_para_medico);

        setTitle(TITULO_APPBAR);

        Button botaoConfSemaforo = findViewById(R.id.btn_Conf_semaforo_Hist_crise_p_medico);
        botaoConfSemaforo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HistoricoCrisesPacienteParaMedico.this, ConfiguraSemaforoAlerta.class);
                startActivity(intent);
            }
        });
    }
}
