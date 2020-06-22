package tcc.com.br.tea.dao;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tcc.com.br.tea.model.Dependente;
import tcc.com.br.tea.model.Medico;

public class MedicoDao {

    private static final String TAG = "";
    private static List<Medico> medicos = new ArrayList<>();
    private FirebaseFirestore db = FirebaseFirestore.getInstance();



    public void addMedicoFireBase(Medico medico) {

        Map<String, Object> med = new HashMap<>();
                med.put("id", medico.getNome());
        med.put("nome", medico.getNome());
        med.put("nome", medico.getCrm());
        med.put("nome", medico.getSenha());


        db.collection("medicos").add(med).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Log.d(TAG, "Documento medicos adicionado com ID: " + documentReference.getId());

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.w(TAG, "Erro em Registrar Medicos Firebase!!", e);

            }
        });
    }

    public void retornaMedicoFirebase() {

        db.collection("medicos").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            if (task.getResult() != null) {
//                                List<Dependente> dependentesinfoList = task.getResult().toObjects(Dependente.class);
                                for (QueryDocumentSnapshot document : task.getResult()) {

                                    medicos = task.getResult().toObjects(Medico.class);
//                                    Log.d(TAG, " ==>> " + dependentesinfoList);
                                    Log.d(TAG, " ==>> " + medicos);
                                }
                            }
                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });
    }



    public void salvaMedicos(Medico medico){
        medicos.add(medico);
        addMedicoFireBase(medico);

    }


}
