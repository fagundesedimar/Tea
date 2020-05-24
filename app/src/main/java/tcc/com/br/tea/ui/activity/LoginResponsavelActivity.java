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

public class LoginResponsavelActivity extends AppCompatActivity {

    public static String TITULO_APPBAR = "LOGIN RESPONSAVEL";
    private FirebaseAuth auth;
    private EditText campoEmailLogin;
    private EditText campoSenha;
//    private Button btnEntrarLoginRespon;
//    private Button btnNovoCadastro;

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
                Intent intent = new Intent(LoginResponsavelActivity.this, ListaDependenteActivity.class);
                loginEmail();
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
            if (statusInternet_MoWi(getBaseContext())) {
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
                   // startActivity(new Intent(getBaseContext(),ListaDependenteActivity.class));
                    Toast.makeText(getBaseContext(), "Usuário Logado com Sucesso", Toast.LENGTH_LONG).show();
                    //finish();
                } else  {
                    String resposta = task.getException().toString();
                    opçoesErroFirebase(resposta);
                }
            }
        });
    }

    private void opçoesErroFirebase(String resposta) {
        if (resposta.contains("least 6 characters")){
            Toast.makeText(getBaseContext(),"Erro - Senha deve ter no minimo 6 caracteres!",Toast.LENGTH_LONG).show();
        } else if (resposta.contains("address is badly")) {
            Toast.makeText(getBaseContext(),"Erro - E-mail Invalido!",Toast.LENGTH_LONG).show();
        } else if (resposta.contains("interrupted connection")) {
            Toast.makeText(getBaseContext(),"Erro - Sem conexão com Firebase, (Banco de Dados)!",Toast.LENGTH_LONG).show();
        } else if (resposta.contains("password is invalid")) {
            Toast.makeText(getBaseContext(),"Erro - Senha Invalida!",Toast.LENGTH_LONG).show();
        }else if (resposta.contains("There is no user")) {
            Toast.makeText(getBaseContext(),"Erro - E-mail não Cadastrado!",Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(getBaseContext(),resposta,Toast.LENGTH_LONG).show();
        }
    }

    public static boolean statusInternet_MoWi(Context context) {
        boolean status = false;
        ConnectivityManager conexao = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        if (conexao != null){
            // PARA DISPOSTIVOS NOVOS
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                NetworkCapabilities recursosRede = conexao.getNetworkCapabilities(conexao.getActiveNetwork());
                if (recursosRede != null) {//VERIFICAMOS SE RECUPERAMOS ALGO
                    if (recursosRede.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) { //VERIFICAMOS SE DISPOSITIVO TEM 3G
                        return true;
                    }
                    else if (recursosRede.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                        //VERIFICAMOS SE DISPOSITIVO TEM WIFFI
                        return true;
                    }
                    //NÃO POSSUI UMA CONEXAO DE REDE VÁLIDA
                    return false;
                }
            } else {//COMECO DO ELSE
                // PARA DISPOSTIVOS ANTIGOS  (PRECAUÇÃO)
                NetworkInfo informacao = conexao.getActiveNetworkInfo();
                if (informacao != null && informacao.isConnected()) {
                    status = true;
                } else
                    status = false;
                return status;
            }//FIM DO ELSE
        }
        return false;
    }



}
