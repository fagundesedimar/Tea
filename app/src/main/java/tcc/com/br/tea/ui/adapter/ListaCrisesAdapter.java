package tcc.com.br.tea.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import tcc.com.br.tea.R;
import tcc.com.br.tea.model.Dependente;

public class ListaCrisesAdapter extends BaseAdapter {

    private final List<Dependente> dependentes;
    private final Context context;

    public ListaCrisesAdapter(List<Dependente> dependentes, Context context) {
        // public ListaDependentesAdapter( Context context) {
        this.dependentes = dependentes;
        this.context = context;
    }


    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int posicao, View view, ViewGroup parent) {
        View viewCriada = LayoutInflater.from(context).inflate(R.layout.item_dependente, parent, false);

        Dependente dependenteDevolvido = dependentes.get(posicao);

        TextView dataHora = viewCriada.findViewById(R.id.item_crise_numero_data_hora);
        dataHora.setText(dependenteDevolvido.getNome());

        TextView nomeMedicacao = viewCriada.findViewById(R.id.item_crise_medicamento);
        nomeMedicacao.setText(dependenteDevolvido.getContato());

        return viewCriada;

    }

}
