package tcc.com.br.tea.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import tcc.com.br.tea.R;
import tcc.com.br.tea.dao.DependenteDao;
import tcc.com.br.tea.model.Dependente;
import tcc.com.br.tea.ui.adapter.ListaDependentesAdapter;

import static tcc.com.br.tea.ui.activity.ConstantesActivities.CHAVE_DEPENDENTE;
import static tcc.com.br.tea.ui.activity.ConstantesActivities.CHAVE_MEDICO;

public class ListaPacientesMedicoActivity extends AppCompatActivity {


    private final DependenteDao daoDepend = new DependenteDao();
    private ListaDependentesAdapter adapter;

    public static final String TITULO_APPBAR_MEDICO = "LISTA PACIENTES";
    public static final String TITULO_APPBAR_PROF = "LISTA ALUNOS";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_lista_pacientes_medico);
        setContentView(R.layout.activity_lista_pacientes_medico);

        //setTitle(TITULO_APPBAR);

//        configuraFabNovoDependente();
        //configuraLista();
        //atualizaDependente();
        carragrDependente();
    }

    private void carragrDependente() {
        Intent dados = getIntent();
        if (dados.hasExtra(CHAVE_MEDICO)) {
            setTitle(TITULO_APPBAR_MEDICO);
            configuraLista();
            atualizaDependente();
        } else {
            setTitle(TITULO_APPBAR_PROF);
            configuraLista();
            atualizaDependente();
        }

    }


    private void configuraLista() {
        // List<Dependente> dependentes = new DependenteDao().todosDepend();
        ListView listaDependente = findViewById(R.id.activity_lista_dependente_listView);
        configuraAdapter(listaDependente);
        configuraListenerDeCliquePorItem(listaDependente);
    }

    private void abreCadastroDependenteActivity() {
        startActivity(new Intent(this, CadastroDependenteActivity.class));
    }

    @Override
    protected void onResume() {
        super.onResume();

        daoDepend.retornaDependenteFirebase();
        atualizaDependente();

    }

    private void atualizaDependente() {
        adapter.atualiza(daoDepend.todosDepend());
    }

    private void configuraListenerDeCliquePorItem(ListView listaDeDependentes) {
        listaDeDependentes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicao, long id) {
                Dependente dependenteEscolhido = (Dependente) adapterView.getItemAtPosition(posicao);

                abreStatusDependentePorClickCurto(dependenteEscolhido);
                //abreCadastroModoEditaDependentePorClickLongo(dependenteEscolhido);
            }
        });
    }

    // Metodo responsavel por abrir os dados do dependente para editar, caso o cadastro seja feito e/ou digitado errado
    private void abreCadastroModoEditaDependentePorClickLongo(Dependente dependente) {
        Intent vaiParaCadastroDependenteActivity = new Intent(ListaPacientesMedicoActivity.this, CadastroDependenteActivity.class);
        vaiParaCadastroDependenteActivity.putExtra(CHAVE_DEPENDENTE, dependente);
        startActivity(vaiParaCadastroDependenteActivity);
    }

    private void abreStatusDependentePorClickCurto(Dependente dependente) {
        Intent vaiParaInfoDependenteActivity = new Intent(ListaPacientesMedicoActivity.this, MenuMedicoActivity.class);
//        Intent vaiParaInfoDependenteActivity = new Intent(ListaPacientesMedicoActivity.this, MenuProfActivity.class);
        startActivity(vaiParaInfoDependenteActivity );
    }

    private void configuraAdapter(ListView listaDeDependentes) {
        adapter = new ListaDependentesAdapter(daoDepend.todosDepend(), this);
        // adapter = new ListaDependentesAdapter(daoDepend.retornaDependenteFirebase(),this);
        listaDeDependentes.setAdapter(adapter);
    }

}
