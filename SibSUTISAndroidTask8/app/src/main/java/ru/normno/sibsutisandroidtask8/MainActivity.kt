package ru.normno.sibsutisandroidtask8

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ru.normno.sibsutisandroidtask8.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var mSec: Int = 0
    private var mRunning: Boolean = false
    private val handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnStart.setOnClickListener {
            mRunning = true
            runTimer()
        }

        binding.btnStop.setOnClickListener {
            mRunning = false
        }

        binding.btnReset.setOnClickListener {
            mSec = 0
            updateUI(binding.tvTime)
        }
    }

    private fun runTimer() {
        handler.post(object : Runnable {
            override fun run() {
                if (mRunning) {
                    mSec++
                    updateUI(binding.tvTime)
                }
                handler.postDelayed(this, 1000)
            }
        })
    }

    private fun updateUI(timeTextView: TextView) {
        val hours = mSec / 3600
        val minutes = (mSec % 3600) / 60
        val secs = mSec % 60
        val time = "%d:%02d:%02d".format(hours, minutes, secs)
        timeTextView.text = time
    }
}