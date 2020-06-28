package tcc.com.br.tea.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import tcc.com.br.tea.R;

public class ConfiguraSemaforoAlerta extends AppCompatActivity {

    public static final String TITULO_APPBAR = "CONFIGURA SEMÁFORO DE ALERTAS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configura_semaforo_alerta);

        setTitle(TITULO_APPBAR);

    }

}
