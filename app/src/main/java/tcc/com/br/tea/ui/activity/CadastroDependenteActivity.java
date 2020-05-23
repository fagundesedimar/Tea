package tcc.com.br.tea.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import tcc.com.br.tea.R;
import tcc.com.br.tea.dao.DependenteDao;
import tcc.com.br.tea.model.Dependente;

import static tcc.com.br.tea.ui.activity.ConstantesActivities.CHAVE_DEPENDENTE;


public class CadastroDependenteActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR_NOVO_DEPENDENTE = "CADASTRO DE DEPENDETE";
    public static final String TITULO_APPBAR_EDITA_DEPENDENTE = "EDITA DEPENDETE";
    private EditText campoNome;
    private EditText campoDataNascimento;
    private EditText campoEndereco;
    private EditText campoContato;
    private final DependenteDao dependenteDao = new DependenteDao();
    private Dependente dependente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_dependente);

        inicializandoCamposDepend();
        //setTitle(TITULO_APPBAR_NOVO_DEPENDENTE);
        carragrDependente();

       // configuraBotaoSalvar();
    }




    private void carragrDependente() {
        Intent dados = getIntent();
        if (dados.hasExtra(CHAVE_DEPENDENTE)){
            setTitle(TITULO_APPBAR_EDITA_DEPENDENTE);
            dependente = (Dependente) dados.getSerializableExtra(CHAVE_DEPENDENTE);
            preencheCampos();
        } else {
            setTitle(TITULO_APPBAR_NOVO_DEPENDENTE);
            dependente = new Dependente();
        }

    }

    private void preencheCampos() {
        campoNome.setText(dependente.getNome());
        campoDataNascimento.setText(dependente.getDataNascimento());
        campoEndereco.setText(dependente.getEndereco());
        campoContato.setText(dependente.getEndereco());
    }

//    private void configuraBotaoSalvar() {
//        Button botao_salvar_dependente = findViewById(R.id.btn_salvar_cad_dependente);
//        botao_salvar_dependente.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Dependente dependenteCriado = criaDependente();
//                salvaDepend(dependenteCriado);
//
//            }
//        });
//    }

    private void inicializandoCamposDepend() {
        campoNome = (EditText) findViewById(R.id.campo_nome_cad_dependente);
        campoDataNascimento = (EditText) findViewById(R.id.campo_data_nasc_cad_dependente);
        campoEndereco = (EditText) findViewById(R.id.campo_endereco_cad_dependente);
        campoContato = (EditText) findViewById(R.id.campo_contato_cad_dependente);
    }

    private void salvaDepend(Dependente dependente) {
        dependenteDao.salva(dependente);
        //finaliza a activity assim que finaliza o cadastro do um novo dependent
        finish();
    }

    private void criaDependente() {
        String nome = campoNome.getText().toString();
        String dataNascimento = campoDataNascimento.getText().toString();
        String endereco = campoEndereco.getText().toString();
        String contato = campoContato.getText().toString();

        dependente.setNome(nome);
        dependente.setDataNascimento(dataNascimento);
        dependente.setEndereco(endereco);
        dependente.setContato(contato);

    }

}
