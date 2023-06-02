package hnu.multimedia.todo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity {

    Button btnIDCheck;
    EditText etID;
    EditText etPassword;
    EditText etPasswordTest;
    EditText etNickname;

    boolean isDidIdCheck = false;
    boolean isDidPasswordCheck = false;
    boolean isDidEmailCheck = false;



    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        btnIDCheck = findViewById(R.id.btnIDCheck);
        etID = findViewById(R.id.etID);
        etPassword = findViewById(R.id.etPassword);
        etPasswordTest = findViewById(R.id.etPasswordTest);
        etNickname = findViewById(R.id.etNickname);

        String email;


        // 아이디 중복 검사
        TextView tvDuplication = findViewById(R.id.tvDuplication);
        btnIDCheck.setOnClickListener(view -> {
            if (etID.getText().length() < 1) {
                Toast.makeText(SignUpActivity.this, "아이디를 입력하세요", Toast.LENGTH_LONG).show();
            }
            //TODO: 아이디 중복 검사
            // 아이디를 중복 검사했는데 중복이 아닌 걸로 나왔다!
            if(etID.getText().toString().equals("aaa")) {
                isDidIdCheck = true;
            }
        });

        // 패스워드 일치 검사
        etPasswordTest.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (etPassword.getText().toString().equals(etPasswordTest.getText().toString())) {
                    TextView tvPasswordSame = findViewById(R.id.tvPasswordSame);
                    tvPasswordSame.setText("비밀번호가 일치합니다.");
                    isDidPasswordCheck = true;
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        // TODO: 이메일 중복 검사 + 스피너 직접 입력 선택 시 editText 나오기
        Button btnEmailCheck = findViewById(R.id.btnEmailCheck);
        EditText etEmail = findViewById(R.id.etEmail);
        Spinner spnEmail = findViewById(R.id.spnEmail);

        btnEmailCheck.setOnClickListener(v -> {
            if (etEmail.getText().length() < 1) {
                Toast.makeText(SignUpActivity.this, "이메일을 입력하세요", Toast.LENGTH_LONG).show();
                return;
            }
            if(!spnEmail.getSelectedItem().toString().contains("com") &&
                    !spnEmail.getSelectedItem().toString().contains("net")) {
                Toast.makeText(SignUpActivity.this, "이메일을 입력하세요2", Toast.LENGTH_LONG).show();
                return;
            }
            isDidEmailCheck = true;
        });

        // TODO: emil + @ + Spinner 을 통해 이메일 중복 확인
        spnEmail.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //TODO: 회원 가입 버튼 눌렀을 시 중복 검사 통과 확인 및 패스워드 일치하는지 확인
        // 각 중복검사들 함수로 만들어서 boolean type 리턴...?? 인가?
       Button btnJoin = findViewById(R.id.btnJoin);
       btnJoin.setOnClickListener(v -> {
           // 아이디 입력을 안 했을 시
           if(etID.getText().toString().length() < 1) {
               Toast.makeText(SignUpActivity.this, "아이디를 입력하세요", Toast.LENGTH_LONG).show();
           }

           // 비밀번호 입력을 안 했을 시
           if(etPassword.getText().toString().length() < 1
                   || etPasswordTest.getText().toString().length() < 1) {
               Toast.makeText(SignUpActivity.this, "비밀번호를를 입력하세요", Toast.LENGTH_LONG).show();
           }

           // 닉네임 입력 안 했을 시
           if(etNickname.getText().toString().length() < 1) {
               Toast.makeText(SignUpActivity.this, "닉네임을 입력하세요", Toast.LENGTH_LONG).show();
           }

           // 이메일 입력 안 했을 시
           if (etEmail.getText().length() < 1) {
               Toast.makeText(SignUpActivity.this, "이메일을 입력하세요", Toast.LENGTH_LONG).show();
               return;
           }
           if(!spnEmail.getSelectedItem().toString().contains("com") &&
                   !spnEmail.getSelectedItem().toString().contains("net")) {
               Toast.makeText(SignUpActivity.this, "이메일을 입력하세요2", Toast.LENGTH_LONG).show();
               return;
           }

           // 중복검사
          if(isDidEmailCheck && isDidPasswordCheck && isDidIdCheck
           && etNickname.getText().length() > 0) {
               Intent intent= new Intent(SignUpActivity.this, MainActivity.class);
               startActivity(intent);
           } else if (!isDidIdCheck) {
              Toast.makeText(SignUpActivity.this, "아이디 중복 검사", Toast.LENGTH_LONG).show();
          }

       });
    }
}