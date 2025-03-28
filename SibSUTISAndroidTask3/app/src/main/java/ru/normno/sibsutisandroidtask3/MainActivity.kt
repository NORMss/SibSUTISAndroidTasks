package ru.normno.sibsutisandroidtask3

import android.os.Bundle
import android.view.Gravity.CENTER
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import com.google.android.material.snackbar.Snackbar
import ru.normno.sibsutisandroidtask3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)

        val view = binding.root

        setContentView(view)

        val toast = Toast.makeText(this, R.string.toast_text, Toast.LENGTH_SHORT)

        val ivCat = ImageView(applicationContext).apply {
            setImageResource(R.drawable.cat)
        }

        binding.btnToast.setOnClickListener {
            toast.setGravity(CENTER, 0, 0)
            toast.view = (ivCat)
            toast.show()
        }

        val snackbar = Snackbar.make(view, R.string.snackbar_text, Snackbar.LENGTH_SHORT)
            .setAction(R.string.boooo) {
                binding.ivContent.isVisible = true
                binding.ivContent.setImageResource(R.drawable.cat)
            }

        binding.btnSnackbar.setOnClickListener {
            binding.ivContent.isVisible = false
            snackbar.show()
        }

        var imageNumber = 0

        binding.npChangeBg.minValue = 0
        binding.npChangeBg.maxValue = 3

        binding.npChangeBg.setOnValueChangedListener { _, _, newVal ->
            imageNumber = newVal
        }

        binding.btnChangeBg.setOnClickListener {
            when (imageNumber) {
                1 -> binding.root.setBackgroundResource(R.drawable.image_1)
                2 -> binding.root.setBackgroundResource(R.drawable.image_2)
                3 -> binding.root.setBackgroundResource(R.drawable.image_3)
                else -> {
                    binding.root.background = null
                    Toast.makeText(
                        applicationContext,
                        R.string.enter_number,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}