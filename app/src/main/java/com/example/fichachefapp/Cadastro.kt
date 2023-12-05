package com.example.fichachefapp

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth
import com.example.fichachefapp.databinding.ActivityCadastroBinding
import com.google.firebase.auth.UserProfileChangeRequest

class Cadastro : AppCompatActivity() {
     private lateinit var binding: ActivityCadastroBinding
     private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //firebase
        binding = ActivityCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.irEntrar.setOnClickListener{
            val intent = Intent(this, Entrar::class.java)
            startActivity(intent)
        }

        binding.btnCadastrar.setOnClickListener {
            val usuario = binding.caixaUser.text.toString()
            val email = binding.caixaEmail.text.toString()
            val criarSenha = binding.caixaCriarSenha.text.toString()
            val verificarSenha = binding.caixaVerificarSenha.text.toString()

            if(email.isNotEmpty() && criarSenha.isNotEmpty() && verificarSenha.isNotEmpty()) {
                if (criarSenha == verificarSenha){

                    firebaseAuth.createUserWithEmailAndPassword(email , criarSenha).addOnCompleteListener {
                        if (it.isSuccessful){
                            val user = firebaseAuth.currentUser

                            // Create a request to add the username to the user profile
                            val profileUpdates = UserProfileChangeRequest.Builder()
                                .setDisplayName(usuario)
                                .build()

                            // Update the user profile
                            user?.updateProfile(profileUpdates)?.addOnCompleteListener { task ->
                                if (task.isSuccessful) {
                                    val intent = Intent(this, Slider::class.java)
                                    startActivity(intent)
                                }
                            }
                        }else{
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }
                }else{
                    Toast.makeText(this, "As senhas não se correspondem", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this, "Campos vazios não são permitidos!", Toast.LENGTH_SHORT).show()
            }
        }
        window.statusBarColor = Color.parseColor("#000000")


        // Código para o input de senha permitindo tirar a visualização da senha.

        val caixaSenha = findViewById<TextInputEditText>(R.id.caixa_criar_senha)
        val caixaSenhaLayout = findViewById<TextInputLayout>(R.id.caixaCriarSenhaLayout)

        caixaSenha.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                // Não é necessário implementar nada aqui
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                // Não é necessário implementar nada aqui
            }

            override fun afterTextChanged(p0: Editable?) {
                validatePassword(caixaSenha.text.toString(), caixaSenhaLayout)
            }
        })
    }

    private fun validatePassword(password: String, caixaSenhaLayout: TextInputLayout): Boolean {
        return when {
            password.trim().isEmpty() -> {
                caixaSenhaLayout.error = "Vazio"
                false
            }
            password.trim().length !in 8..10 -> {
                caixaSenhaLayout.error = "A senha deve ter no mínimo entre 8 a 10 caracteres!"
                false
            }
            else -> {
                caixaSenhaLayout.error = null
                true
            }
        }
    }
}
