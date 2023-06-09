package hnu.multimedia.todo.repo;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;


import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class FirestoreRepository {
    public static final String COLLECTION_USER = "user";

    private static FirestoreRepository firestoreRepository;
    private FirebaseFirestore firestore;
    private FirebaseAuth auth;

    private FirestoreRepository() {
        firestore = FirebaseFirestore.getInstance();
        auth = FirebaseAuth.getInstance();
    }
    public static FirestoreRepository getInstance() {
        if (firestoreRepository == null) {
            firestoreRepository = new FirestoreRepository();
        }
        return firestoreRepository;
    }

    public void requestUserRegister(String email, String password, BiConsumer<Boolean, String> biconsumer) {
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(task -> {

            if(task.isSuccessful()) {
                FirebaseUser currentUser = auth.getCurrentUser();
                String uid = currentUser.getUid();
                biconsumer.accept(true, uid);
            }

            else {
                    biconsumer.accept(false ,task.getException().getMessage());
                }
        });
    }

    public void saveUserAdditionalData(String uid, String id,String nickName, String email) {
        User user = new User(id, nickName, email);
        firestore.collection(COLLECTION_USER).document(uid).set(user);
    }

    public void requestUserLogin(String id, String password, Consumer<String> consumer) {

    }
}

