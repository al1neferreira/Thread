package br.com.aline.thread

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val switch1: SwitchCompat = findViewById(R.id.switch_component)
        val textViewCounter = findViewById<TextView>(R.id.tv_counter)

        switch1.setOnClickListener {
            GlobalScope.launch {
                repeat(10){ counter ->

                    delayOneSecond()
                    textViewCounter.post{

                        textViewCounter.text = (counter + 1).toString()
                    }
                }

            }
        }
    }

    private suspend fun delayOneSecond(){
        delay(1000)
    }
}

