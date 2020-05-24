package tcc.com.br.tea.ui.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import tcc.com.br.tea.R;
import tcc.com.br.tea.util.Util;

public class LoginResponsavelActivity extends AppCompatActivity {

    public static String TITULO_APPBAR = "LOGIN RESPONSAVEL";
    private FirebaseAuth auth;
    private EditText campoEmailLogin;
    private EditText campoSenha;
    private Button btnEntrarLoginRespon;
    private Button btnNovoCadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_responsavel);

        auth = FirebaseAuth.getInstance();
        campoEmailLogin = findViewById(R.id.text_login_email_responsavel);
        campoSenha = findViewById(R.id.text_senha_login_responsavel);

        setTitle(TITULO_APPBAR);
//        btnEntrarLoginRespon = (Button) findViewById(R.id.btn_entrar_login_responsavel);
//        btnEntrarLoginRespon.setOnClickListener((View.OnClickListener) this);
//        btnNovoCadastro = (Button) findViewById(R.id.btn_novoCadastro_login_responsavel);
//        btnNovoCadastro.setOnClickListener((View.OnClickListener) this);

        Button btnEntrarLoginRespon = findViewById(R.id.btn_entrar_login_responsavel);
        btnEntrarLoginRespon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(LoginResponsavelActivity.this, ListaDependenteActivity.class);
                loginEmail();
                //startActivity(intent);
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

//    public void onClick(View view) {
//        switch (view.getId()){
//            case R.id.btn_entrar_login_responsavel:
//                loginEmail();
//                break;
//
//            case R.id.btn_novoCadastro_login_responsavel:
//                startActivity(new Intent(getBaseContext(),CadastroResponsavelActivity.class));
//                break;
//        }
//    }

    private void loginEmail() {
        String email = campoEmailLogin.getText().toString().trim();
        String senha = campoSenha.getText().toString().trim();

        if (email.isEmpty() || senha.isEmpty()) {
            Toast.makeText(getBaseContext(), "Erro: Favor preencher todos os campos!", Toast.LENGTH_LONG).show();
        } else {
            if (Util.statusInternet_MoWi(getBaseContext())) {
                confirmarLoginEmail(email, senha);
            } else {
                Toast.makeText(getBaseContext(), "Erro - Verifique seu sinal Wifi ou 3,4G!", Toast.LENGTH_LONG).show();
            }
        }
    }

    private void confirmarLoginEmail(String email, String senha) {
        auth.signInWithEmailAndPassword(email, senha).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {
                    startActivity(new Intent(getBaseContext(),ListaDependenteActivity.class));
                    Toast.makeText(getBaseContext(), "Usuário Logado com Sucesso", Toast.LENGTH_LONG).show();
                    finish();
                } else  {
                    String resposta = task.getException().toString();
                    Util.opçoesErroFirebase(getBaseContext() ,resposta);
                }
            }
        });
    }

}
