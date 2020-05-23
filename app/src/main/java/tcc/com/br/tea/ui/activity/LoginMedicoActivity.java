package tcc.com.br.tea.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import tcc.com.br.tea.R;

public class LoginMedicoActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "LOGIN MEDICO" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_medico);

        setTitle(TITULO_APPBAR);

        Button buttonNovoCadastroMedico = findViewById(R.id.btn_novo_cadastro_login_medico);
        buttonNovoCadastroMedico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginMedicoActivity.this, CadastroMedicoActivity.class);
                startActivity(intent);
            }
        });

        Button buttonEntrarMedico = findViewById(R.id.btn_entrar_login_medico);
        buttonEntrarMedico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginMedicoActivity.this, ListaPacientesMedicoActivity.class);
                startActivity(intent);
            }
        });








    }




}
