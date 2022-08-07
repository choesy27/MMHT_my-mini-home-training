package com.example.mmht_my_mini_home_training;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

public class WalkingFragment extends Fragment implements SensorEventListener {
    private SensorManager sensorManager;
    private Sensor stepCountSensor;
    private TextView walking_count;

    // 현재 걸음 수
    int currentSteps = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_walking, container, false);

        walking_count = view.findViewById(R.id.walking_count);

        // 활동 퍼미션 체크
        if (ContextCompat.checkSelfPermission(getActivity(),
                Manifest.permission.ACTIVITY_RECOGNITION) == PackageManager.PERMISSION_DENIED) {
            requestPermissions(new String[]{Manifest.permission.ACTIVITY_RECOGNITION}, 0);
        }

//         걸음 센서 연결
//         * 옵션
//         - TYPE_STEP_DETECTOR:  리턴 값이 무조건 1, 앱이 종료되면 다시 0부터 시작
//         - TYPE_STEP_COUNTER : 앱 종료와 관계없이 계속 기존의 값을 가지고 있다가 1씩 증가한 값을 리턴
        sensorManager = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);
        stepCountSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR);

        // 디바이스에 걸음 센서의 존재 여부 체크
        if (stepCountSensor == null) {
            Toast.makeText(getActivity(), "No Step Sensor", Toast.LENGTH_SHORT).show();
        }

        return view;
    }

    public void onStart() {
        super.onStart();
        if (stepCountSensor != null) {
            // 센서 속도 설정
            // * 옵션
            // - SENSOR_DELAY_NORMAL: 20,000 초 딜레이
            // - SENSOR_DELAY_UI: 6,000 초 딜레이
            // - SENSOR_DELAY_GAME: 20,000 초 딜레이
            // - SENSOR_DELAY_FASTEST: 딜레이 없음
            sensorManager.registerListener(this, stepCountSensor, SensorManager.SENSOR_DELAY_FASTEST);
        }
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        // 걸음 센서 이벤트 발생시
        if (sensorEvent.sensor.getType() == Sensor.TYPE_STEP_DETECTOR) {

            if (sensorEvent.values[0] == 1.0f) {
                // 센서 이벤트가 발생할때 마다 걸음수 증가
                currentSteps++;
                walking_count.setText(String.valueOf(currentSteps));
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}