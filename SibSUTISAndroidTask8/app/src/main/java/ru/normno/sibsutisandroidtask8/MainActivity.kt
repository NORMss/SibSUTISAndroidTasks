package ru.normno.sibsutisandroidtask8

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.runBlocking
import ru.normno.sibsutisandroidtask8.databinding.ActivityMainBinding
import java.lang.String
import kotlin.Int
import kotlin.div
import kotlin.inc
import kotlin.rem

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val view = binding.root

        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

//        runBlocking {
//            val hоurs: Int = mSec / 3600
//            val minutes: Int = (mSec % 3600) / 60
//            val secs: Int = mSec % 60
//            val time: String? = String.fоrmаt("%d:%02d:%02d", hоurs, minutes, secs)
//            timeTextView.setText(time)
//            if (mRunning) {
//                mSec++
//            }
//            handler.postDelayed(this, 1000)
//        }
    }
}