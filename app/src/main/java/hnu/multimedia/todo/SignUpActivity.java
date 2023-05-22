package hnu.multimedia.todo;

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

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Button btnIDCheck = findViewById(R.id.btnIDCheck);
        EditText etID = findViewById(R.id.etID);
        EditText etPassword = findViewById(R.id.etPassword);
        EditText etPasswordTest = findViewById(R.id.etPasswordTest);
        String email;


        // 아이디 중복 검사
        TextView tvDuplication = findViewById(R.id.tvDuplication);
        btnIDCheck.setOnClickListener(view -> {
            if (etID.getText().length() < 1) {
                Toast.makeText(SignUpActivity.this, "아이디를 입력하세요", Toast.LENGTH_LONG).show();
                return;
            }
            //TODO: 아이디 중복 검사
            return;
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
            Log.d("email", etEmail.getText().toString()+"@"+spnEmail.getSelectedItem().toString());
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
           // 이메일 중복 체크
           // 아이디 중복 체크
           // 비밀번호 일치 체크
           if (etPassword.getText().toString().equals(etPasswordTest.getText().toString())){

           }
       });
    }
}