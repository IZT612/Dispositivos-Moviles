package com.example.proyecto1

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.proyecto1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        val binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        Log.d("ciclo", "onCreate() creado. 1")
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.accederBtn.setOnClickListener{

            val usuario = binding.usuarioInput.text.toString()
            val contraseña = binding.contrasenaInput.text.toString()

            if (usuario == "admin") {

                if (contraseña == "1234") {

                    val welcomeIntent = Intent(this, WelcomeActivity::class.java)
                    welcomeIntent.putExtra("usuario", usuario)
                    startActivity(welcomeIntent)

                } else {

                    val errorContraseña = Toast.makeText(applicationContext, "Contraseña incorrecta", Toast.LENGTH_SHORT).show()

                }

            } else {

                val welcomeIntent = Intent(this, WelcomeActivity::class.java)
                welcomeIntent.putExtra("usuario", usuario)
                startActivity(welcomeIntent)

            }

        }

    }

    override fun onStart() {

        super .onStart()
        Log.d("ciclo", "onStart() llamado. 1")

    }

    override fun onRestart() {

        super .onRestart()
        Log.d("ciclo", "onRestart() llamado - Volviendo de estar 'stopped'. 1")

    }

    override fun onResume() {

        super .onResume()
        Log.d("ciclo", "onResume() llamado - ¡La Activity es visible y activa!. 1")

    }

    override fun onPause() {

        super .onPause()
        Log.d("ciclo", "onPause() llamado - Otra Activity toma el foco. 1")

    }

    override fun onStop() {

        super .onStop()
        Log.d("ciclo", "onStop() llamado - La Activity ya no es visible. 1")

    }

    override fun onDestroy() {

        super .onDestroy()
        Log.d("ciclo", "onDestroy() llamado - La Activity está siendo destruida. 1")

    }

}