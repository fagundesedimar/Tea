package tcc.com.br.tea.dao;

import java.util.ArrayList;
import java.util.List;

import tcc.com.br.tea.model.Responsavel;

public class ResponsavelDao {

    private final static List<Responsavel> responsaveis = new ArrayList<>();

    public static void salva(Responsavel responsavel) {
        responsaveis.add(responsavel);
    }





}
