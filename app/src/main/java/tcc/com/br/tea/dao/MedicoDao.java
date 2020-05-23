package tcc.com.br.tea.dao;

import java.util.ArrayList;
import java.util.List;

import tcc.com.br.tea.model.Medico;

public class MedicoDao {
    private final static List<Medico> medicos = new ArrayList<>();

    public void salva(Medico medico){
        medicos.add(medico);
    }


}
