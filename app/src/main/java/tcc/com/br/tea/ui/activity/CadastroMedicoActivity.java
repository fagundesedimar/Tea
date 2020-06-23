package tcc.com.br.tea.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import tcc.com.br.tea.R;
import tcc.com.br.tea.dao.MedicoDao;
import tcc.com.br.tea.model.Medico;

public class CadastroMedicoActivity extends AppCompatActivity {

    private static final String TAG = "";

    public static final String TITULO_APPBAR = "CADASTRO MEDICO";
    private final MedicoDao medicoDao = new MedicoDao();
    private Medico medico;
    private EditText campoNome;
    private EditText campoCrm;
    private EditText campoSenha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_medico);

        setTitle(TITULO_APPBAR);

        inicializandoCamposMedico();
        configurarBotaoSalvar();


    }

    private  void salva (Medico medico) {
        medicoDao.salvaMedicos(medico);
        finish();
    }

    private void configurarBotaoSalvar() {
        Button botao_salvar_medico = findViewById(R.id.btn_salvar_cad_medico);
        botao_salvar_medico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Medico medicoCriado = criaMedico();
                salva(medicoCriado);
                Log.d(TAG, " ==>> " + medicoCriado.getNome() + medicoCriado.getCrm() + medicoCriado.getSenha());
                Toast.makeText(CadastroMedicoActivity.this, "Salvo com Sucesso", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        int itemId = item.getItemId();
//        if (itemId == R.id.btn_salvar_cad_medico) {
//            finalizaCadastro();
//        }
//        return super.onOptionsItemSelected(item);
//    }

//    private void finalizaCadastro() {
//        criaMedico();
//        if (medico.temIdValido()) {
//            medicoDao.editaMed(medico);
//        } else {
//            medicoDao.salvaMedicos(medico);
//        }
//        finish();
//    }

    private Medico criaMedico() {
        String nome = campoNome.getText().toString();
        String srm = campoCrm.getText().toString();
        String senha = campoSenha.getText().toString();

        return new Medico(nome,srm, senha);

    }

    private void preencheCampos() {
        campoNome.setText(medico.getNome());
        campoCrm.setText(medico.getCrm());
        campoSenha.setText(medico.getSenha());
    }

    private void inicializandoCamposMedico() {
        campoNome = (EditText) findViewById(R.id.campo_nome_cad_medico);
        campoCrm = (EditText) findViewById(R.id.campo_crm_cad_medico);
        campoSenha = (EditText) findViewById(R.id.campo_senha_cad_medico);

    }



}
