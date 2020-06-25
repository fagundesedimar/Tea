package tcc.com.br.tea.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import tcc.com.br.tea.R;

public class MenuAlertaDependenteActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "ALERTAS DE SEU DEPENDENTE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_alerta_dependente); //Possivel alteração
        setTitle(TITULO_APPBAR);

    }
}
