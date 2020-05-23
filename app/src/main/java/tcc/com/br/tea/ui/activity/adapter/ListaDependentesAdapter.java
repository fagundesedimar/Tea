package tcc.com.br.tea.ui.activity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import tcc.com.br.tea.R;
import tcc.com.br.tea.model.Dependente;

public class ListaDependentesAdapter extends BaseAdapter {

    private final List<Dependente> dependentes = new ArrayList<>();
    private Context context;

    public ListaDependentesAdapter(Context context) {
        this.context = context;
    }



    @Override
    public int getCount() {
        return dependentes.size();
    }

    @Override
    public Dependente getItem(int posicao) {
        return dependentes.get(posicao);
    }

    @Override
    public long getItemId(int posicao) {
        return dependentes.get(posicao).getId();
    }

    @Override
    public View getView(int posicao, View view, ViewGroup viewGroup) {
        View viewCriada = LayoutInflater.from(context).inflate(R.layout.item_dependente, viewGroup, false);

        Dependente dependenteDevolvido = dependentes.get(posicao);
        TextView nome = viewCriada.findViewById(R.id.item_dependente_nome);
        nome.setText(dependenteDevolvido.getNome());
        TextView notificacao = viewCriada.findViewById(R.id.item_notificacao);
        notificacao.setText(dependenteDevolvido.getContato());

        return viewCriada;
    }

    public void atualiza (List<Dependente> dependentes) {
        this.dependentes.clear();
        this.dependentes.addAll(dependentes);
        notifyDataSetChanged();
    }

    // Adaptar metodo para desativar um depedente
    public void desativa (Dependente dependente) {
        dependentes.remove(dependente);
        notifyDataSetChanged();
    }

}
