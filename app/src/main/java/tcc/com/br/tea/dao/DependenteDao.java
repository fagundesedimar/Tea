package tcc.com.br.tea.dao;

import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.annotations.Nullable;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tcc.com.br.tea.model.Dependente;

public class DependenteDao {

    private static final String TAG = "";
    private static List<Dependente> dependentes = new ArrayList<>();
    private static int contadorDeIds = 1;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();


    public void addDependenteFireBase(Dependente dependente) {//( Dependente dependente)
       // FirebaseFirestore db = FirebaseFirestore.getInstance();


        Map<String, Object> dep = new HashMap<>();
        dep.put("listaDependente", Arrays.asList(dependente.getId(), dependente.getNome(), dependente.getContato(),
                dependente.getDataNascimento()));
//        dep.put("id", dependente.getId());
//        dep.put("nome", dependente.getNome());
//        dep.put("contato", dependente.getContato());
//        dep.put("nascimento", dependente.getDataNascimento());

        Log.i(TAG, "Documento adicionado com ID: " + dep);

        db.collection("deps").add(dep).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Log.d(TAG, "Documento adicionado com ID: " + documentReference.getId());

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                //salva(dependente);
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
        final Dependente[] dependente = new Dependente[1];
       // FirebaseFirestore db = FirebaseFirestore.getInstance();

//        DocumentReference docRef = db.collection("deps").document("deps");
//
//        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
//                if (task.isSuccessful()) {
//                    DocumentSnapshot document = task.getResult();
//                    if (document.exists()) {
//                        Log.d(TAG, "DocumentSnapshot data: " + document.getData());
//                    } else {
//                        Log.d(TAG, "ESSE DOCUMENTO NAO EXISTE!!!");
//                    }
//                } else {
//                    Log.d(TAG, "ERRO DO FIREBASE: ", task.getException());
//                }
//            }
//        });


        db.collection("deps").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        dependente[0] = new Dependente();
                        int cont = 0;
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                cont = cont + 1;
                                Log.d(TAG, document.getId() + " => " + document.getData());
//                                dependentes = (List<Dependente>) document.getData();
//                                dependente[cont] = ;
                                Log.i(TAG, "DEPENDENTES RETORNADOS DO FIREBASE: " + dependentes);

                            }
                        } else {
                            Log.d(TAG, "Error de retornar dependentes do FireBase: ", task.getException());
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
