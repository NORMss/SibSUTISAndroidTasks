package ru.normno.sibsutisandroidtask7

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ru.normno.sibsutisandroidtask7.databinding.ActivityMainBinding
import ru.normno.sibsutisandroidtask7.databinding.UseSwitchBinding

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
        binding.btnAbout.setOnClickListener {
            Intent(this, AboutActivity::class.java).also { intent ->
                startActivity(intent)
            }
        }

        binding.btnOpenThemesActivity.setOnClickListener {
            Intent(this, ThemesActivity::class.java).also { intent ->
                startActivity(intent)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)

        val itemSwitch = menu?.findItem(R.id.app_bar_switch)

        itemSwitch?.actionView?.let { actionView ->
            val switchBinding = UseSwitchBinding.bind(actionView)

            val nightMode = AppCompatDelegate.getDefaultNightMode()
            switchBinding.mySwitch.isChecked = nightMode == AppCompatDelegate.MODE_NIGHT_YES

            switchBinding.mySwitch.setOnCheckedChangeListener { _, isChecked ->
                AppCompatDelegate.setDefaultNightMode(
                    if (isChecked) AppCompatDelegate.MODE_NIGHT_YES
                    else AppCompatDelegate.MODE_NIGHT_NO
                )
                recreate()
            }
        }

        return super.onCreateOptionsMenu(menu)
    }
}