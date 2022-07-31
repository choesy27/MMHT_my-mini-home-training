package com.example.mmht_my_mini_home_training;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Toast;

import com.example.mmht_my_mini_home_training.home.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private HomeFragment homeFragment;
    private WalkingFragment walkingFragment;
    private SettingFragment settingFragment;

    private long pressed_time = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavi);
        bottomNavigationView.setOnNavigationItemSelectedListener(menuItem -> {
            switch (menuItem.getItemId()) {
                case R.id.menu_home:
                    setFragment(0);
                    break;

                case R.id.menu_walking:
                    setFragment(1);
                    break;

                case R.id.menu_setting:
                    setFragment(2);
                    break;
            }
            return true;
        });

        homeFragment = new HomeFragment();
        walkingFragment = new WalkingFragment();
        settingFragment = new SettingFragment();

        setFragment(0);     // 첫 프래그먼트 화면 지정
    }

    // 프래그먼트 교체
    private void setFragment(int n) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        switch (n) {
            case 0:
                fragmentTransaction.replace(R.id.mainFrame, homeFragment);
                fragmentTransaction.commit();
                break;

            case 1:
                fragmentTransaction.replace(R.id.mainFrame, walkingFragment);
                fragmentTransaction.commit();
                break;

            case 2:
                fragmentTransaction.replace(R.id.mainFrame, settingFragment);
                fragmentTransaction.commit();
                break;

            default:
                break;
        }
    }

    // 뒤로가기 두 번 누르면 종료
    @Override
    public void onBackPressed() {
        long tempTime = System.currentTimeMillis();
        long intervalTime = tempTime - pressed_time;

        long finished_time = 1000;
        if (0 <= intervalTime && finished_time >= intervalTime) {
            finish();
        } else {
            pressed_time = tempTime;
            Toast.makeText(getApplicationContext(), R.string.back_button, Toast.LENGTH_LONG).show();
        }
    }
}