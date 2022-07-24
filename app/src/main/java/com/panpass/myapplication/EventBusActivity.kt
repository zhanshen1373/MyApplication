package com.panpass.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.greenrobot.eventbus.EventBus
import java.io.Serializable

class EventBusActivity : AppCompatActivity() {
    private var p = -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_bus)
        intent?.let {
            p = it.getIntExtra("position",-1)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().post(EventBusData(p))
    }
    inner class EventBusData(var position:Int):Serializable
}