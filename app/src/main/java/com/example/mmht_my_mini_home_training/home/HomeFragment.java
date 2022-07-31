package com.example.mmht_my_mini_home_training.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mmht_my_mini_home_training.R;

public class HomeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        Button record = view.findViewById(R.id.dailyRecord);
        Button calendar = view.findViewById(R.id.calendar);
        Button camera = view.findViewById(R.id.camera);

        // 일일 기록 버튼 클릭 이벤트(기록 액티비티 화면으로 전환)
        record.setOnClickListener(view1 -> {
            Intent intent = new Intent(getActivity(), RecordActivity.class);
//            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);           // 화면 전환이 안 일어난 척하는 코드
            startActivity(intent);
        });

        // 캘린더 버튼 클릭 이벤트(캘린더 액티비티 화면으로 전환)

        // 카메라 버튼 클릭 이벤트(카메로 액티비티 화면으로 전환)

        return view;
    }
}