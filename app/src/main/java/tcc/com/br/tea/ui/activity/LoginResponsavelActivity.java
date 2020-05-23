package tcc.com.br.tea.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import tcc.com.br.tea.R;

public class LoginResponsavelActivity extends AppCompatActivity {

    public static String TITULO_APPBAR = "LOGIN RESPONSAVEL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_responsavel);

        setTitle(TITULO_APPBAR);

        Button btnEntrarLoginRespon = findViewById(R.id.btn_entrar_login_responsavel);
        btnEntrarLoginRespon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginResponsavelActivity.this, ListaDependenteActivity.class);
                startActivity(intent);

            }
        });

        Button btnNovoCadastro = findViewById(R.id.btn_novoCadastro_login_responsavel);
        btnNovoCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginResponsavelActivity.this, CadastroResponsavelActivity.class);
                startActivity(intent);

            }
        });




    }
}
