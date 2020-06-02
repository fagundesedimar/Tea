package tcc.com.br.tea.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import tcc.com.br.tea.R;
import tcc.com.br.tea.dao.DependenteDao;
import tcc.com.br.tea.model.Dependente;
import tcc.com.br.tea.ui.adapter.ListaDependentesAdapter;

import static tcc.com.br.tea.ui.activity.ConstantesActivities.CHAVE_DEPENDENTE;

public class ListaDependenteActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "LISTA DEPENDENTE";
    private final DependenteDao daoDepend = new DependenteDao();
    private ListaDependentesAdapter adapter;

// Listar todos os dependentes de responsavel.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_dependente);
        setTitle(TITULO_APPBAR);
        configuraFabNovoDependente();
        configuraLista();

       daoDepend.salva(new Dependente("Renato", "29031999", "Rua sem nome", "22223333"));


    }

    private void configuraLista() {
       // List<Dependente> dependentes = new DependenteDao().todosDepend();
        ListView listaDependente = findViewById(R.id.activity_lista_dependente_listView);
        configuraAdapter(listaDependente);

        //listaDependente.setAdapter(new ListaDependentesAdapter(daoDepend.todosDepend(), this));

    }

    private void configuraFabNovoDependente() {
        FloatingActionButton btbNovoDependente = findViewById(R.id.floating_btn_add_dependente);
        btbNovoDependente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abreCadastroDependenteActivity();
            }
        });
    }

    private void abreCadastroDependenteActivity() {
        startActivity(new Intent(this, CadastroDependenteActivity.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
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
                abreCadastroModoEditaDependente(dependenteEscolhido);
            }
        });
    }

    private void abreCadastroModoEditaDependente(Dependente dependente) {
        Intent vaiParaCadastroDependenteActivity = new Intent(ListaDependenteActivity.this, CadastroDependenteActivity.class);
        vaiParaCadastroDependenteActivity.putExtra(CHAVE_DEPENDENTE, dependente);
        startActivity(vaiParaCadastroDependenteActivity);
    }

    private void configuraAdapter(ListView listaDeDependentes) {
        adapter = new ListaDependentesAdapter( this);
        listaDeDependentes.setAdapter(adapter);
    }

}
