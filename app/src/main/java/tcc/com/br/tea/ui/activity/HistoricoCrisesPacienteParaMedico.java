package tcc.com.br.tea.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import tcc.com.br.tea.R;
import tcc.com.br.tea.dao.DependenteDao;
import tcc.com.br.tea.ui.adapter.ListaCrisesAdapter;

public class HistoricoCrisesPacienteParaMedico extends AppCompatActivity {

    public static final String TITULO_APPBAR = "HISTÓRICO CRISES E CONFIGURA SEMÁFORO";

    private ListaCrisesAdapter adapterCrise;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico_crises_pacie_para_medico);

        setTitle(TITULO_APPBAR);

        Button botaoConfSemaforo = findViewById(R.id.btn_Conf_semaforo_Hist_crise_p_medico);
        botaoConfSemaforo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HistoricoCrisesPacienteParaMedico.this, ConfiguraSemaforoAlerta.class);
                startActivity(intent);
            }
        });

    }


    private void configuraLista() {
        // List<Dependente> dependentes = new DependenteDao().todosDepend();
        ListView listaCriseDependente = findViewById(R.id.activity_lista_crises_dependente_listView);
//        configuraAdapter(listaCriseDependente);
//        configuraListenerDeCliquePorItem(listaCriseDependente);
    }

//    private void configuraAdapter(ListView listaDeDependentes) {
//        DependenteDao daoDepend = new DependenteDao();
//        adapterCrise = new ListaCrisesAdapter(daoDepend.todosDepend(), this);
//        // adapter = new ListaDependentesAdapter(daoDepend.retornaDependenteFirebase(),this);
//        ListaCrisesAdapter.setAdapter(adapterCrise);
//    }



}
