package tcc.com.br.tea.dao;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

import tcc.com.br.tea.model.Responsavel;

public class ResponsavelDao {

    private final static List<Responsavel> responsaveis = new ArrayList<>();

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    public static void salva(Responsavel responsavel) {
        responsaveis.add(responsavel);
    }








}
