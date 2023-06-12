package hnu.multimedia.todo.ui.home;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import hnu.multimedia.todo.R;
import hnu.multimedia.todo.databinding.ActivityUploadBinding;
import hnu.multimedia.todo.repo.FirestoreRepository;

public class UploadActivity extends AppCompatActivity {
    ActivityUploadBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUploadBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        setTitle("일정 추가");
        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // 뒤로가기 버튼 생성

        binding.tvStart.setOnClickListener(v -> {
            DialogFragment dialogFragment = new DatePickerFragment();
            dialogFragment.show(getSupportFragmentManager(), "datePicker");
        });
        binding.tvEnd.setOnClickListener(v -> {
            DialogFragment dialogFragment = new DatePickerFragment();
            dialogFragment.show(getSupportFragmentManager(), "datePicker");
        });

    }
    // xml에 만든 메뉴를 inflate를 통해 객체화해 준다
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.upload_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // 툴바에서 이미지 선택 시 자동 호출되는 함수
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: // back 버튼
                setResult(RESULT_CANCELED);
                finish();
                break;
            case R.id.menu_done:
                //TODO: 파이어 베이스에 데이터 업로드 1. 맵, 2. 커스텀 객체
                FirestoreRepository repository = FirestoreRepository.getInstance();
                setResult(RESULT_OK);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
