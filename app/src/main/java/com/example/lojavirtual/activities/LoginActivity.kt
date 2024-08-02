package com.example.lojavirtual.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.example.lojavirtual.databinding.ActivityLoginBinding
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nameTextInputLayout = binding.tilName
        val passwordTextInputLayout = binding.tilPassword
        val edtName = binding.edtName
        val edtPassword = binding.edtPassword
        val button = binding.loginButton

        button.setOnClickListener {
            validate(edtName, edtPassword, nameTextInputLayout, passwordTextInputLayout, this)
        }
    }

    private fun validate(edtName: EditText, edtPass: EditText, nameTextInputLayout: TextInputLayout
                         , passwordTextInputLayout: TextInputLayout, context: Context){
        val data = intent
        val name = edtName.text.toString()
        val nameReceived = data.getStringExtra("name")
        val pass = edtPass.text.toString()
        if(name.isEmpty()){
            nameTextInputLayout.helperText = "Digite seu nome"
        } else if(name != nameReceived){
            nameTextInputLayout.helperText = "Nome inválido"
        }
        if(pass.length < 5 || pass.isBlank()){
            passwordTextInputLayout.helperText = "Senha inválida"
            return
        }

        if(name.isNotEmpty() && name == nameReceived){
            val intent = Intent(context, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}