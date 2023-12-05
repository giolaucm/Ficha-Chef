package com.example.fichachefapp

import EmailActivity
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.fichachefapp.databinding.ActivityEntrarBinding
import com.google.firebase.auth.FirebaseAuth

class Entrar : AppCompatActivity() {

    private lateinit var binding: ActivityEntrarBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityEntrarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()
        //verificar se vai o "irEntrar" senão mudar para "irCadastrar"
        binding.irEntrar.setOnClickListener{
            val intent = Intent(this, Cadastro::class.java)
            startActivity(intent)
        }

        binding.btnEntrar.setOnClickListener{
            val email = binding.caixaEmail.text.toString()
            val criarSenha = binding.caixaCriarSenha.text.toString()

            if(email.isNotEmpty() && criarSenha.isNotEmpty()) {
                    firebaseAuth.signInWithEmailAndPassword(email , criarSenha).addOnCompleteListener {
                        if (it.isSuccessful){
                            val intent = Intent(this, Principal::class.java)
                            startActivity(intent)
                        }else{
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }
            }else{
                Toast.makeText(this, "Campos vazios não são permitidos!", Toast.LENGTH_SHORT).show()
            }
        }

        window.statusBarColor = Color.parseColor("#000000")

    }
}