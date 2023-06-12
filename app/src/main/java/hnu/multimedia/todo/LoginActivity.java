package hnu.multimedia.todo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import hnu.multimedia.todo.databinding.ActivityLoginBinding;
import hnu.multimedia.todo.repo.FirestoreRepository;
import hnu.multimedia.todo.repo.Names;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // 기억 시켜둔 파일이 존재하는지에 대한 여부 판단
        SharedPreferences preferences = getSharedPreferences(Names.PREF_LOGIN_FILE, MODE_PRIVATE);
        String email = preferences.getString(Names.PREF_EMAIL_FIELD, "");
        String password = preferences.getString(Names.PREF_PASSWORD_FIELD, "");
        // 이전에 로그인 정보가 존재한다면
        if(!email.equals("") && !password.equals("")) {
            binding.etId.setText(email);
            binding.etPassword.setText(password);
        }

        binding.btnSignin.setOnClickListener(view -> {
            if(TextUtils.isEmpty(binding.etId.getText().toString()) || TextUtils.isEmpty(binding.etPassword.getText().toString())) {
                Toast.makeText(getApplicationContext(), "아이디 또는 비밀번호를 입력하세요.", Toast.LENGTH_SHORT).show();
            } else {
                FirestoreRepository.getInstance().requestUserLogin(binding.etId.getText().toString(), binding.etPassword.getText().toString(), (isSuccess, message) -> {
                    if (isSuccess) {
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);

                        SharedPreferences.Editor editor = getSharedPreferences(Names.PREF_LOGIN_FILE, MODE_PRIVATE).edit();
                        editor.putString(Names.PREF_UID_FIELD, message);
                        editor.putString(Names.PREF_EMAIL_FIELD, binding.etId.getText().toString());
                        editor.putString(Names.PREF_PASSWORD_FIELD, binding.etPassword.getText().toString());
                        editor.apply();
                    } else {
                        Snackbar.make(view, "로그인 실패: " + message, Snackbar.LENGTH_LONG).show();
                    }
                });
            }
        });

        binding.btnSignUp.setOnClickListener(v->{
            Intent intent = new Intent(this, RegisterActivity.class);
            startActivity(intent);
        });
    }

}