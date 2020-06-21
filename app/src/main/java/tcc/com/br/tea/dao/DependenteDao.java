package tcc.com.br.tea.dao;

import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.common.primitives.Ints;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.annotations.Nullable;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.remote.Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tcc.com.br.tea.model.Dependente;

public class DependenteDao {

    private static final String TAG = "";
    private static List<Dependente> dependentes = new ArrayList<>();
    private static int contadorDeIds = 1;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();


    public void addDependenteFireBase(Dependente dependente) {
        Map<String, Object> dep = new HashMap<>();

        dep.put("id", dependente.getId());
        dep.put("nome", dependente.getNome());
        dep.put("contato", dependente.getContato());
        dep.put("nascimento", dependente.getDataNascimento());
        dep.put("endereco", dependente.getEndereco());

        db.collection("deps").add(dep).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Log.d(TAG, "Documento adicionado com ID: " + documentReference.getId());

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.w(TAG, "Erro em Registro Firebase!!", e);

            }
        });
    }


    public void salva(Dependente dependente) {
        dependente.setId(contadorDeIds);
        dependentes.add(dependente);
        atualizaIds();
        addDependenteFireBase(dependente);
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

    public void retornaDependenteFirebase() {

        db.collection("deps").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            if (task.getResult() != null) {
//                                List<Dependente> dependentesinfoList = task.getResult().toObjects(Dependente.class);
                                for (QueryDocumentSnapshot document : task.getResult()) {

                                    dependentes = task.getResult().toObjects(Dependente.class);
//                                    Log.d(TAG, " ==>> " + dependentesinfoList);
                                    Log.d(TAG, " ==>> " + dependentes);
                                }
                            }
                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });
    }

    //mandando copia da lista de dependente para as modificaçoes
    public List<Dependente> todosDepend() {
        retornaDependenteFirebase();
        return new ArrayList<>(dependentes);
    }

    // Ver se é realmente necessario criar, acredido que remover um dependente não
    // é viavel, pensando na regra de negocio do app, pois todos os dados
    // são muito importantes as estimativas, uma vez removido perderiamos os dados desse dependentes
    public void desabilitaDependente(Dependente dependente) {

    }

}

