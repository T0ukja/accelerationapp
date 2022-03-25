package com.example.accelerometerapp

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView


class MainActivity : AppCompatActivity(), SensorEventListener {
    lateinit var Accelerometer: SensorManager
 var x: Float = 0F
     var y: Float = 0F
     var z: Float = 0F
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_main)
        Accelerometer = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        Accelerometer.registerListener(this,Accelerometer.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
            ,SensorManager.SENSOR_DELAY_FASTEST)

    }

    override fun onSensorChanged(event: SensorEvent) {
        val Accelerotext: TextView = findViewById(R.id.Acc)


        var alpha = 0.8;

        x = (alpha * event.values[0] + (1 - alpha) * event.values[0]).toFloat();
        y = (alpha * event.values[1] + (1 - alpha) * event.values[1]).toFloat();
        z = (alpha * event.values[2] + (1 - alpha) * event.values[2]).toFloat();
if(x == 9.81F || x == -9.81F){
y = 0F
    z = 0F
}

        if(y >= 9.81F || y == -9.81F){
            x = 0F
            z = 0F
        }

        if(z >= 9.81F || z == -9.81F){
            x = 0F
            y = 0F
        }

        Accelerotext.text="X =${x}\n"+ "Y= ${y}\n" + "Z = ${z}"
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

    }


}