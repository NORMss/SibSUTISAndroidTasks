package ru.normno.sibsutisandroidtask4

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ru.normno.sibsutisandroidtask4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)

        val view = binding.root

        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        println("item.itemId = ${item.itemId}")
        when (item.itemId) {
            R.id.dz -> {
                binding.root.setBackgroundResource(R.drawable.spring)
                Toast.makeText(
                    applicationContext,
                    "День знаний празднуется 1 сентября",
                    Toast.LENGTH_SHORT
                ).show()
                return true
            }

            R.id.dp -> {
                binding.root.setBackgroundResource(R.drawable.code)
                Toast.makeText(
                    applicationContext,
                    "День прогаммиста празднуется в 256 день года",
                    Toast.LENGTH_SHORT
                ).show()
                return true
            }

            R.id.ny -> {
                binding.root.setBackgroundResource(R.drawable.winter)
                Toast.makeText(
                    applicationContext,
                    "Новый Год встречают 1 января",
                    Toast.LENGTH_SHORT
                ).show()
                return true
            }

            R.id.kt -> {
                binding.root.setBackgroundResource(R.drawable.kotlin)
                Toast.makeText(
                    applicationContext,
                    "Язык программирования Kotlin представили 19 июля",
                    Toast.LENGTH_SHORT
                ).show()
                return true
            }

            else -> return super.onOptionsItemSelected(item)
        }
    }
}