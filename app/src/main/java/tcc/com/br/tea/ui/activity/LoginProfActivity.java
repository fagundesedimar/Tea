package tcc.com.br.tea.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import tcc.com.br.tea.R;

public class LoginProfActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "LOGIN PROFESSOR(A)";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_prof);

        setTitle(TITULO_APPBAR);


        Button btnNovoProf = findViewById(R.id.btn_novoCadastro_login_prof);
        btnNovoProf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginProfActivity.this, CadastroProfActivity.class);
                startActivity(intent);
            }
        });

        Button btnEntrarLoginProf = findViewById(R.id.btn_entrar_login_prof);
        btnEntrarLoginProf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginProfActivity.this, ListaDependenteActivity.class);
                startActivity(intent);
            }
        });

    }

}
