package com.bhaskar.utils.demos;

import android.app.Activity;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.bhaskar.utils.ShakeDetector;

public abstract class ShakeDetectionDemo extends Activity implements ShakeDetector.Listener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        ShakeDetector sd = new ShakeDetector(this);
        sd.start(sensorManager);
    }

    @Override
    public void hearShake() {
        Toast.makeText(getApplicationContext(), "Don't shake me, bro!", Toast.LENGTH_SHORT).show();
    }
}
