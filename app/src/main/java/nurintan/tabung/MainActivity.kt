package nurintan.tabung

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import nurintan.tabung.databinding.ActivityMainBinding
import kotlin.math.PI

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalculate.setOnClickListener {
            calculateTabung()
        }
    }

    private fun calculateTabung() {
        val radiusInput = binding.etRadius.text.toString()
        val heightInput = binding.etHeight.text.toString()


        if (radiusInput.isEmpty() || heightInput.isEmpty()) {
            Toast.makeText(this, "Masukkan jari-jari dan tinggi dulu yaaa", Toast.LENGTH_SHORT).show()
            return
        }

        val radius = radiusInput.toDouble()
        val height = heightInput.toDouble()

        val volume = PI * radius * radius * height

        val surfaceArea = 2 * PI * radius * (height + radius)

        binding.tvResult.text = "Volume Tabung: %.2f".format(volume)

        binding.tvSurfaceArea.text = "Luas Permukaan Tabung: %.2f".format(surfaceArea)
    }
}
