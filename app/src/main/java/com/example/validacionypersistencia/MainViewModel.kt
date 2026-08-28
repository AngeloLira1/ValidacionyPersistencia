package com.example.validacionypersistencia
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    fun validarCredenciales(usuario: String, contrasena: String): Boolean {
        return usuario.trim() == "admin" && contrasena == "1234"
    }
}