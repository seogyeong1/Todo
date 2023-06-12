package hnu.multimedia.todo;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import hnu.multimedia.todo.repo.FirestoreRepository;

public class RegisterActivity extends AppCompatActivity {

    Button btnIDCheck;
    EditText etID;
    EditText etPassword;
    EditText etPasswordTest;
    EditText etNickname;
    EditText etRegisterEmail;
    Button btnEmailCheck;
    EditText etEmail;
    Spinner spnEmail;

    boolean isDidIdCheck = false;
    boolean isDidPasswordCheck = false;
    boolean isDidEmailCheck = false;
    StringBuilder emailString = new StringBuilder();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnIDCheck = findViewById(R.id.btnIDCheck);
        etID = findViewById(R.id.etID);
        etPassword = findViewById(R.id.etPassword);
        etPasswordTest = findViewById(R.id.etPasswordTest);
        etNickname = findViewById(R.id.etNickname);
        etRegisterEmail = findViewById(R.id.etRegisterEmail);

        // 아이디 중복 검사
        TextView tvDuplication = findViewById(R.id.tvDuplication);
        btnIDCheck.setOnClickListener(view -> {
            if (etID.getText().length() < 1) {
                Toast.makeText(RegisterActivity.this, "아이디를 입력하세요", Toast.LENGTH_LONG).show();
            }
            //TODO: 아이디 중복 검사 FIREAUTHA로 변경
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


        //TODO: 회원 가입 버튼 눌렀을 시 중복 검사 통과 확인 및 패스워드 일치하는지 확인
       Button btnJoin = findViewById(R.id.btnJoin);
       btnJoin.setOnClickListener(v -> {
           // 아이디 입력을 안 했을 시
           if(etID.getText().toString().length() < 1) {
               Toast.makeText(RegisterActivity.this, "아이디를 입력하세요", Toast.LENGTH_LONG).show();
               return;
           }

           // 비밀번호 입력을 안 했을 시
           if(etPassword.getText().toString().length() < 1
                   || etPasswordTest.getText().toString().length() < 1) {
               Toast.makeText(RegisterActivity.this, "비밀번호를 입력하세요", Toast.LENGTH_LONG).show();
               return;
           }

           // 닉네임 입력 안 했을 시
           if(etNickname.getText().toString().length() < 1) {
               Toast.makeText(RegisterActivity.this, "닉네임을 입력하세요", Toast.LENGTH_LONG).show();
               return;
           }

           //TODO: 회원가입 후 Login Activity가 아닌 Home Activity로 이동하는 문제 해결
           FirestoreRepository.getInstance().requestUserRegister(
                   etID.getText().toString(),
                   etPassword.getText().toString(),
                   (result , message) -> {
                       if(result) {
                           FirestoreRepository.getInstance().saveUserAdditionalData(message,
                                   etID.getText().toString(),
                                   etNickname.getText().toString(),
                                   etRegisterEmail.getText().toString());
                           finish();
                       }
                       else{
                           Snackbar.make(v, "등록 실패" + result, Snackbar.LENGTH_LONG).show();
                       }
                  }
           );
       });
    }
}