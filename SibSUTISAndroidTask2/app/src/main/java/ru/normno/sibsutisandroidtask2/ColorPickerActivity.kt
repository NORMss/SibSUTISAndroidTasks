package ru.normno.sibsutisandroidtask2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ru.normno.sibsutisandroidtask2.databinding.ActivityColorPickerBinding

class ColorPickerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityColorPickerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityColorPickerBinding.inflate(layoutInflater)

        val view = binding.root

        setContentView(view)


        val username = intent.getStringExtra(MainActivity.EXTRA_USERNAME)
        println("Username: $username")
        username?.let {
            if (username.isNotBlank()) {
                binding.tvUsername.text = "$username, ${getString(R.string.have_a_nice_day)}"
            }
        }

        binding.btnGreen.setOnClickListener {
            binding.root.setBackgroundColor(getColor(R.color.green))
            binding.tvUsername.text = getString(R.string.btn_green)
        }

        binding.btnRed.setOnClickListener {
            binding.root.setBackgroundColor(getColor(R.color.red))
            binding.tvUsername.text = getString(R.string.btn_red)
        }

        binding.btnYellow.setOnClickListener {
            binding.root.setBackgroundColor(getColor(R.color.yellow))
            binding.tvUsername.text = getString(R.string.btn_yellow)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}