package tcc.com.br.tea.ui.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import tcc.com.br.tea.R;

public class EscolhaSouUmActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "VOCÊ É UM ?";

    private FirebaseAuth auth;
    private FirebaseUser user;
    private FirebaseAuth.AuthStateListener authStateListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolha_sou_um);

        setTitle(TITULO_APPBAR);
        auth = FirebaseAuth.getInstance();

        estatoAutenticacao();

        Button botaoSouMedico = findViewById(R.id.btn_sou_medico);
        botaoSouMedico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EscolhaSouUmActivity.this, LoginMedicoActivity.class);
                startActivity(intent);
            }
        });

        Button botaoSouResponsavel = findViewById(R.id.btn_sou_responsavel);
        botaoSouResponsavel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EscolhaSouUmActivity.this, LoginResponsavelActivity.class);
               // startActivity(intent);
                //Condição para verificar se já existe alguns usuário logado no app, não esta finalizado.
                user = auth.getCurrentUser();
                if (user == null) {
                    startActivity(intent);
                } else {
                    startActivity(new Intent(getBaseContext(),ListaDependenteActivity.class));
                }

            }
        });

        Button botaoSouProfessor = findViewById(R.id.btn_sou_professor);
        botaoSouProfessor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EscolhaSouUmActivity.this, LoginProfActivity.class);
                startActivity(intent);
            }
        });

//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    private  void estatoAutenticacao() {
        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    Toast.makeText(getBaseContext(), "Usuário " + user.getEmail() + " está logado" , Toast.LENGTH_LONG);

                } else {

                }

            }
        };
    }

    @Override
    protected void onStart() {
        super.onStart();
        auth.addAuthStateListener(authStateListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (authStateListener != null) {
            auth.removeAuthStateListener(authStateListener);
        }
    }


}
