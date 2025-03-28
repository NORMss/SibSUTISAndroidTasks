package ru.normno.sibsutisandroidtask2

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ru.normno.sibsutisandroidtask2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)

        val view = binding.root

        setContentView(view)

        binding.btnNextActivity.setOnClickListener {
            Intent(applicationContext, ColorPickerActivity::class.java).apply {
                putExtra(EXTRA_USERNAME, binding.etUsername.text.toString())
            }.also {
                startActivity(it)
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    companion object {
        const val EXTRA_USERNAME = "EXTRA_USERNAME"
    }
}