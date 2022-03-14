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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_main)
        Accelerometer = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        Accelerometer.registerListener(this,Accelerometer.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_FASTEST)

    }

    override fun onSensorChanged(event: SensorEvent) {
        val Accelerotext: TextView = findViewById(R.id.Acc)
        Accelerotext.text="X =${event.values[0]}\n"+ "Y= ${event.values[1]}\n" + "Z = ${event.values[2]}"
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

    }


}