package com.example.mmht_my_mini_home_training.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.mmht_my_mini_home_training.R;

import java.util.Objects;

public class CameraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        // 툴바(뒤로 가기) - 추후엔 툴바 없이 뒤로가기 생성 예정
        Toolbar toolbar = findViewById(R.id.camera_toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);  // 뒤로 가기
        getSupportActionBar().setTitle(R.string.home_camera);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {     // toolbar의 back 키 눌렀을 경우에 동작
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}