package com.example.mmht_my_mini_home_training.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.mmht_my_mini_home_training.R;
import com.github.sundeepk.compactcalendarview.CompactCalendarView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

public class CalendarActivity extends AppCompatActivity {
//    final String TAG = "calendar test";
    private final SimpleDateFormat dateFormatForDisplaying = new SimpleDateFormat("yyyy년 MM월", Locale.KOREA);
//    private final SimpleDateFormat dateFormatForMonth = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        // 툴바(뒤로 가기) - 추후엔 툴바 없이 뒤로가기 생성 예정
        Toolbar toolbar = findViewById(R.id.calendar_toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);  // 뒤로 가기
        getSupportActionBar().setTitle(R.string.home_calendar);

        final CompactCalendarView compactCalendarView = findViewById(R.id.calendar_cal);

        TextView calendar_month = findViewById(R.id.calendar_month);
        TextView calendar_click = findViewById(R.id.calendar_click);

        calendar_month.setText(dateFormatForDisplaying.format(compactCalendarView.getFirstDayOfCurrentMonth()));

        compactCalendarView.setFirstDayOfWeek(Calendar.MONDAY);

        // 이벤트 관련 코드
        compactCalendarView.setListener(new CompactCalendarView.CompactCalendarViewListener() {
            @Override
            public void onDayClick(Date dateClicked) {
//                List<Event> events = compactCalendarView.getEvents(dateClicked);
                // 추후 수정
                SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
                String date = transFormat.format(dateClicked);

/*                String event_name = "";
                String event_date = "";

                if (events.size() > 0) {
                    event_name = events.get(0).getData().toString();
                    long time1 = events.get(0).getTimeInMillis();
                    event_date = transFormat.format(new Date(time1));
                }*/

//                calendar_click.setText("클릭한 날짜 " + date1 + " event 정보 " + event_name + " " + event_date);
                calendar_click.setText(date);
            }

            @Override
            public void onMonthScroll(Date firstDayOfNewMonth) {
                calendar_month.setText(dateFormatForDisplaying.format(firstDayOfNewMonth));
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