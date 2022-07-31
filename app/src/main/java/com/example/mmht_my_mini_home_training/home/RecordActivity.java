package com.example.mmht_my_mini_home_training.home;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.mmht_my_mini_home_training.R;

import java.util.Calendar;
import java.util.Objects;

public class RecordActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        // 툴바(뒤로 가기) - 추후엔 툴바 없이 뒤로가기 생성 예정
        Toolbar toolbar = findViewById(R.id.record_toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);  // 뒤로 가기
        getSupportActionBar().setTitle(R.string.home_record);

        Calendar calendar = Calendar.getInstance();
        int mYear = calendar.get(Calendar.YEAR);
        int mMonth = calendar.get(Calendar.MONTH);
        int mDay = calendar.get(Calendar.DAY_OF_MONTH);

        Button record_date = findViewById(R.id.record_date_btn);

        // 나중에 하드코딩 해결할 것
        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                                            (datePicker, year, month, dayOfMonth) ->
                record_date.setText(year + "/" + (month + 1) + "/" + dayOfMonth),
                                    mYear, mMonth, mDay);

        record_date.setOnClickListener(view -> {
            if (record_date.isClickable()) {
                datePickerDialog.show();
            }
        });
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
