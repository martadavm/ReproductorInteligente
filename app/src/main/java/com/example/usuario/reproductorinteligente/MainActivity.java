package com.example.usuario.reproductorinteligente;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    MediaPlayer mediaPlayer;
    SensorManager sensorManager;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer=MediaPlayer.create(this,R.raw.musica);
        button=findViewById(R.id.button);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        sensorManager.registerListener((SensorEventListener) this, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mediaPlayer.stop();
        }
    });
    }


    @Override
    public void onSensorChanged(SensorEvent event) {
       /* if(event.sensor.getType()==Sensor.TYPE_PROXIMITY)
        {
            if(event.values[0]==0)
            {
                mediaPlayer.pause();
                Toast.makeText(this, "TAPADO Pause", Toast.LENGTH_SHORT).show();
            }else{
                mediaPlayer.start();
                Toast.makeText(this, "DESTAPADO Sonando", Toast.LENGTH_SHORT).show();

            }
        }else */
       if(event.sensor.getType()==Sensor.TYPE_ACCELEROMETER)
        {
            if(event.values[2]<0)
            {
                mediaPlayer.pause();
               // Toast.makeText(this, "pausa", Toast.LENGTH_SHORT).show();
            }else{
                mediaPlayer.start();
                //Toast.makeText(this, "sonando", Toast.LENGTH_SHORT).show();

            }
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}




