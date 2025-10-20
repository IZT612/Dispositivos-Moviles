package com.example.proyecto1

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.proyecto1.databinding.ActivityMainBinding
import com.example.proyecto1.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        val binding = ActivityWelcomeBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        val usuario = getIntent().getStringExtra("usuario")

        val textoBienvenida = binding.Bienvenida

        val input = binding.buscadorInput.text

        textoBienvenida.text = "¡Bienvenido " + usuario + "!"

        binding.navegadorBtn.setOnClickListener{

            val navegadorIntent= Intent(Intent.ACTION_VIEW)
            navegadorIntent.data = "https://www.google.com/search?q=${input.toString()}".toUri()
            startActivity(navegadorIntent)
            finish()
        }

        binding.telefonoBtn.setOnClickListener{

            val telefonoIntent = Intent(Intent.ACTION_DIAL)
            telefonoIntent.data = Uri.parse("tel:${input}")
            startActivity(telefonoIntent)
            finish()

        }

        binding.mensajeBtn.setOnClickListener{

            val mensajeIntent = Intent(Intent.ACTION_VIEW)
            mensajeIntent.data = Uri.parse("smsto:" + input) // número escrito en el EditText
            mensajeIntent.putExtra("sms_body", "Hola desde mi app") // texto opcional
            startActivity(mensajeIntent)
            finish()
        }

        binding.compartirBtn.setOnClickListener{

            val compartirIntent = Intent(Intent.ACTION_SEND)
            compartirIntent.type = "text/plain"
            compartirIntent.putExtra(Intent.EXTRA_TEXT, input.toString()) // texto escrito en el EditText
            startActivity(Intent.createChooser(compartirIntent, "Compartir con..."))
            finish()

        }

    }

    override fun onStart() {

        super .onStart()
        Log.d("ciclo", "onCreate() creado. 2")

    }

    override fun onRestart() {

        super .onRestart()
        Log.d("ciclo", "onRestart() llamado - Volviendo de estar 'stopped'. 2")

    }

    override fun onResume() {

        super .onResume()
        Log.d("ciclo", "onResume() llamado - ¡La Activity es visible y activa!. 2")
        Toast.makeText(applicationContext, getString(R.string.toast_actividad_b), Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {

        super .onPause()
        Log.d("ciclo", "onPause() llamado - Otra Activity toma el foco. 2")

    }

    override fun onStop() {

        super .onStop()
        Log.d("ciclo", "onStop() llamado - La Activity ya no es visible. 2")

    }

    override fun onDestroy() {

        super .onDestroy()
        Log.d("ciclo", "onDestroy() llamado - La Activity está siendo destruida. 2")

    }
}