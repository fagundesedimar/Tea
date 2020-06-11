package tcc.com.br.tea.dao;

import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.annotations.Nullable;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tcc.com.br.tea.model.Dependente;

public class DependenteDao {

    private static final String TAG = "";
    private final static List<Dependente> dependentes = new ArrayList<>();
    private static int contadorDeIds = 1;
//    DatabaseReference databaseReference;




    public void addDependenteFireBase(Dependente dependente) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();

//        databaseReference.child("dependente").push().setValue(dependentes,
//                new DatabaseReference.CompletionListener() {
//                    @Override
//                    public void onComplete(@Nullable DatabaseError databaseError, @NonNull DatabaseReference databaseReference) {
//                        atualizaIds();
//                    }
//                });

        Map<String, Object> dep = new HashMap<>();
        dep.put("id", dependente.getId());
        dep.put("nome", dependente.getNome());
        dep.put("contato", dependente.getContato());
        dep.put("nascimento", dependente.getDataNascimento());
        Log.i(TAG, "Documento adicionado com ID: " + dep);

        db.collection("deps").add(dep).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Log.d(TAG, "Documento adicionado com ID: " + documentReference.getId());
                atualizaIds();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.w(TAG, "Erro em Registro Firebase!!", e);

            }
        });
    }


    public static void salva(Dependente dependente) {
        dependente.setId(contadorDeIds);
        dependentes.add(dependente);
        atualizaIds();
    }

    private static void atualizaIds() {
        contadorDeIds++;
    }

    public void edita(Dependente dependente) {
        Dependente dependenteEncontrado = buscaDependentePeloId(dependente);
        if (dependenteEncontrado != null) {
            int posicaoDoDependente = dependentes.indexOf(dependenteEncontrado);
            dependentes.set(posicaoDoDependente, dependente);
        }
    }

    private Dependente buscaDependentePeloId(Dependente dependente) {
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
    public void desabilitaDependente(Dependente dependente) {

    }


}
