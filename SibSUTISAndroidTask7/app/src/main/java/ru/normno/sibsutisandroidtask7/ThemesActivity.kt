package ru.normno.sibsutisandroidtask7

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ru.normno.sibsutisandroidtask7.databinding.ActivityThemesBinding

class ThemesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThemesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityThemesBinding.inflate(layoutInflater)

        val view = binding.root

        ThemeManager.applyTheme(ThemeManager.getCurrentTheme(this), this)

        setContentView(view)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.thems_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.theme1 -> {
                ThemeManager.applyTheme(ThemeManager.Theme.LIGHT, this)
                true
            }

            R.id.theme2 -> {
                ThemeManager.applyTheme(ThemeManager.Theme.DARK, this)
                true
            }

            R.id.theme3 -> {
                ThemeManager.applyTheme(ThemeManager.Theme.BLUE, this)
                true
            }
        }
        this.recreate()

        return super.onOptionsItemSelected(item)
    }
}