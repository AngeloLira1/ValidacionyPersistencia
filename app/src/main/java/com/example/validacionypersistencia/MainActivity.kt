package com.example.validacionypersistencia

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.example.validacionypersistencia.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val usuario = binding.etUsuario.text.toString()
            val contrasena = binding.etContrasena.text.toString()

            // 1. Validar reglas de negocio desde el ViewModel
            val esValido = viewModel.validarCredenciales(usuario, contrasena)

            if (esValido) {
                // 2. Navegar a DetailActivity enviando el rol
                val intent = Intent(this, DetailActivity::class.java).apply {
                    putExtra("EXTRA_ROL", "Administrador")
                }
                startActivity(intent)

                // Limpiar campos por si el usuario vuelve a esta pantalla tras cerrar sesión
                binding.etUsuario.text?.clear()
                binding.etContrasena.text?.clear()
            } else {
                // 3. Mostrar Snackbar en caso de fallo
                Snackbar.make(binding.root, "Usuario o contraseña incorrectos", Snackbar.LENGTH_SHORT).show()
            }
        }
    }
}