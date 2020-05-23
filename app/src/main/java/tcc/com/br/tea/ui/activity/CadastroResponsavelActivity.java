package tcc.com.br.tea.ui.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
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
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.List;

import tcc.com.br.tea.R;
import tcc.com.br.tea.model.Responsavel;

public class CadastroResponsavelActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "CADASTRO RESPONSAVEL";
    //private final ResponsavelDao responsavelDao = new ResponsavelDao();
    private FirebaseAuth auth;

    private EditText campoNome;
    private EditText campoContato;
    private EditText campoEmailLogin;
    private EditText campoSenha;
    private EditText campoConfirmaSenha;

    //FirebaseDatabase firebaseDatabase;
    DatabaseReference databeseReference;
    List<Responsavel> listaResponsavel = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_responsavel);

//        inicializarFirebase();
//        inicializandoCamposRes();
        auth = FirebaseAuth.getInstance();

        campoNome = findViewById(R.id.campo_nome_cad_responsavel);
        campoContato = findViewById(R.id.campo_contato_cad_responsavel);
        campoEmailLogin = findViewById(R.id.campo_email_login_cad_responsavel);
        campoSenha = findViewById(R.id.campo_senha_cad_responsavel);
        campoConfirmaSenha = findViewById(R.id.campo_confirma_senha_cad_responsavel);

        databeseReference = FirebaseDatabase.getInstance().getReference();
        configuraBotaoSalvar();


    }

//    private void inicializandoCamposRes() {
//        campoNome = (EditText) findViewById(R.id.campo_nome_cad_responsavel);
//        campoContato = (EditText) findViewById(R.id.campo_contato_cad_responsavel);
//        campoLogin = (EditText) findViewById(R.id.campo_login_cad_responsavel);
//        campoSenha = (EditText) findViewById(R.id.campo_senha_cad_responsavel);
//    }

    //Para teste!!!
//    private Responsavel criaResponsavel() {
//        String nome = campoNome.getText().toString();
//        String contato = campoContato.getText().toString();
//        String login = campoLogin.getText().toString();
//        String senha = campoSenha.getText().toString();
//
//        return new Responsavel (nome, contato, login, senha);
//    }

//    private void inicializarFirebase() {
//        FirebaseApp.initializeApp(CadastroResponsavelActivity.this);
//        firebaseDatabase = FirebaseDatabase.getInstance();
//        databeseReference = firebaseDatabase.getReference();
//
//    }

    private void configuraBotaoSalvar() {
        Button botao_salvar_responsavel = findViewById(R.id.btn_salvar_cad_responsavel);
        botao_salvar_responsavel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                autenticarFirebase();
                //addResponsavel();
            }

           });
    }


    private void autenticarFirebase() { //renato.silva@gmail.com
        String emailLogin = campoEmailLogin.getText().toString().trim(); // trim(), limpa qualquer caracter que o usuario digita sem querer
        String senha = campoSenha.getText().toString().trim();
        String confirmaSenha = campoConfirmaSenha.getText().toString().trim();

        if (emailLogin.isEmpty() || senha.isEmpty() || confirmaSenha.isEmpty()) {

            Toast.makeText(getBaseContext(),"Erro - Preencha todos os Campos!",Toast.LENGTH_LONG).show();

        } else {

            if (senha.contentEquals(confirmaSenha)) {
                if (statusInternet_MoWi(getBaseContext())) {
                    criarUsuarioResponsavel(emailLogin, senha);
                } else {
                    Toast.makeText(getBaseContext(),"Erro - Verifique seu sinal Wifi ou 3,4G!",Toast.LENGTH_LONG).show();
                }

            } else {
                Toast.makeText(getBaseContext(),"Erro - Senhas Diferentes!",Toast.LENGTH_LONG).show();
            }
        }
    }

    private void criarUsuarioResponsavel(String emailLogin, String senha) {
        auth.createUserWithEmailAndPassword(emailLogin, senha).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                boolean resultado = task.isSuccessful();

                if(resultado){
                    Toast.makeText(getBaseContext(),"Cadastro efetuado com sucesso",Toast.LENGTH_LONG).show();
                } else {
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
        } else if (resposta.contains("address is already")) {
            Toast.makeText(getBaseContext(),"Erro - E-mail já existe Cadastrado!",Toast.LENGTH_LONG).show();
        } else if (resposta.contains("interrupted connection")) {
            Toast.makeText(getBaseContext(),"Erro - Sem conexão com Firebase, (Banco de Dados)!",Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getBaseContext(),resposta,Toast.LENGTH_LONG).show();
        }
    }

    private void addResponsavel() {
//        resp.setUid(UUID.randomUUID().toString(),
        listaResponsavel.clear();

        Responsavel resp = new Responsavel(
            campoNome.getText().toString(),
            campoContato.getText().toString(),
            campoEmailLogin.getText().toString(),
            campoSenha.getText().toString()
        );

        databeseReference.child("responsavel").push().setValue(resp,
                new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(@Nullable DatabaseError databaseError, @NonNull DatabaseReference databaseReference) {
                Toast.makeText(CadastroResponsavelActivity.this, "Responsavel Cadastrado.", Toast.LENGTH_SHORT).show();
            }
        });

        limparCampos();

    }

    private void limparCampos() {
        campoNome.setText("");
        campoContato.setText("");
        campoEmailLogin.setText("");
        campoSenha.setText("");
    }



    public static boolean statusInternet_MoWi(Context context) {
        boolean status = false;
        ConnectivityManager conexao = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        if (conexao != null){
            // PARA DISPOSTIVOS NOVOS
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

                NetworkCapabilities recursosRede = conexao.getNetworkCapabilities(conexao.getActiveNetwork());

                if (recursosRede != null) {//VERIFICAMOS SE RECUPERAMOS ALGO

                    if (recursosRede.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                        //VERIFICAMOS SE DISPOSITIVO TEM 3G
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

