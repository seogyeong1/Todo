package hnu.multimedia.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btnSignIn = findViewById(R.id.btnSignIn);
        Button btnFindId = findViewById(R.id.btnFindId);
        Button btnSignUp = findViewById(R.id.btnSignUp);

        // 로그인 버튼
        /*btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText etId = findViewById(R.id.etId);
                EditText etPassword = findViewById(R.id.etPassword);
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);

                if(etId.getText().length() < 1) {
                    Toast.makeText(LoginActivity.this, "아이디를 입력하세요.", Toast.LENGTH_LONG).show();
                    return;
                }
                if(etPassword.getText().length() < 1) {
                    Toast.makeText(LoginActivity.this, "비밀번호를 입력하세요.", Toast.LENGTH_LONG).show();
                    return;
                }
                if(etId.getText().toString().equals("aaa") && etPassword.getText().toString().equals("aaa"))
                    startActivity(intent);
            }
        });*/

        btnSignIn.setOnClickListener(view -> {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        });

        // 아이디 찾기 버튼
        btnFindId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, FindIdActivity.class);
                startActivity(intent);
            }
        });

        //회원가입 버튼
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

}