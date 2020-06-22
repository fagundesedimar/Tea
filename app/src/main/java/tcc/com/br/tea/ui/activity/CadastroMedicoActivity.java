package tcc.com.br.tea.ui.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;

import tcc.com.br.tea.R;
import tcc.com.br.tea.dao.MedicoDao;
import tcc.com.br.tea.model.Medico;

public class CadastroMedicoActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "CADASTRO MEDICO";
    private final MedicoDao medicoDao = new MedicoDao();
    private Medico medico;
    private EditText campoNome;
    private EditText campoSrm;
    private EditText campoSenha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_medico);

        setTitle(TITULO_APPBAR);
        inicializandoCamposMedico();
        //preencheCampos();


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.btn_salvar_cad_medico) {
            finalizaCadastro();
        }
        return super.onOptionsItemSelected(item);
    }


    private void finalizaCadastro() {
        preencheMedico();
        medicoDao.salvaMedicos(medico);
        //finish();
    }

    private void preencheMedico() {
        String nome = campoNome.getText().toString();
        String srm = campoSrm.getText().toString();
        String senha = campoSenha.getText().toString();

        medico.setNome(nome);
        medico.setCrm(srm);
        medico.setSenha(senha);

    }

    private void preencheCampos() {
        campoNome.setText(medico.getNome());
        campoSrm.setText(medico.getCrm());
        campoSenha.setText(medico.getSenha());
    }

    private void inicializandoCamposMedico() {
        campoNome = (EditText) findViewById(R.id.campo_nome_cad_medico);
        campoSrm = (EditText) findViewById(R.id.campo_crm_cad_medico);
        campoSenha = (EditText) findViewById(R.id.campo_senha_cad_medico);

    }



}
