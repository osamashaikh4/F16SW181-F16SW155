package com.example.javedalidahri.gesturestesting;

import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ScaleGestureDetector;
import android.widget.ImageView;
import android.widget.TextView;

@RequiresApi(api = Build.VERSION_CODES.CUPCAKE)
public class MainActivity extends AppCompatActivity implements SensorEventListener
{
    private SensorManager mSensorManager;
    private float mScaleFactor = 1.0f;
    ImageView tv; Sensor mLight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.imageView);
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mLight = mSensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
    }
    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this,mLight,
                SensorManager.SENSOR_DELAY_NORMAL);
    }
    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy){
        // Do something here if sensor accuracy changes.
    }
    @Override
    public void onSensorChanged(SensorEvent event) {
        float val1=0.0f,val2=0.0f;
        val1= tv.getScaleX();
        val2 = tv.getScaleY();
        // The light sensor returns a single value.
        if(event.values[0] < mLight.getMaximumRange()) {

            mScaleFactor *= event.values[0];
            mScaleFactor = Math.max(0.1f,
                    Math.min(mScaleFactor, 10.0f));
            tv.setScaleX(mScaleFactor);
            tv.setScaleY(mScaleFactor);
//            tv.setMaxWidth(600);
//            tv.setMaxHeight(500);
//            getWindow().getDecorView().setBackgroundColor(Color.RED);
        } else {
            mScaleFactor *= event.values[1];
            tv.setScaleX(val1);
            tv.setScaleY(val2);

        }

    }
}