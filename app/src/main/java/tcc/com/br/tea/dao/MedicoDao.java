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


    public void editaMed(Medico medico) {

    }
}
