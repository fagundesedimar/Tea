package tcc.com.br.tea.dao;

import java.util.ArrayList;
import java.util.List;
import tcc.com.br.tea.model.Dependente;

public class DependenteDao {

    private final static List<Dependente> dependentes = new ArrayList<>();
    private static int contadorDeIds =1;

    public static void salva(Dependente dependente) {
        dependente.setId(contadorDeIds);
        dependentes.add(dependente);
        atualizaIds();
    }

    private static void atualizaIds() {
        contadorDeIds ++;
    }

    public void edita (Dependente dependente){
        Dependente dependenteEncontrado = buscaDependentePeloId(dependente);
        if(dependenteEncontrado != null){
            int posicaoDoDependente = dependentes.indexOf(dependenteEncontrado);
            dependentes.set(posicaoDoDependente, dependente);
        }
    }

    private Dependente buscaDependentePeloId(Dependente dependente){
        for (Dependente d : dependentes) {
            if (d.getId() == dependente.getId()) {
                return d;
            }
        }
        return null;
    }

    //mandando copia da lista de dependente para as modificaçoes
    public List<Dependente> todosDepend() {
        return new ArrayList<>(dependentes);
    }

    // Ver se é realmente necessario criar, acredido que remover um dependente não
    // é viavel, pensando na regra de negocio do app, pois todos os dados
    // são muito importantes as estimativas, uma vez removido perderiamos os dados desse dependentes
    public void desabilitaDependente(Dependente dependente){

    }


}
