package com.example.validacionypersistencia

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.validacionypersistencia.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Recibir y mostrar el rol enviado
        val rol = intent.getStringExtra("EXTRA_ROL") ?: "Usuario"
        binding.tvBienvenida.text = "Bienvenido, $rol"

        // Botón Cerrar Sesión
        binding.btnCerrarSesion.setOnClickListener {
            // Finaliza DetailActivity para sacarla del Back Stack
            finish()
        }
    }
}