package com.example.lojavirtual.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.example.lojavirtual.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val button = binding.registerButton

        button.setOnClickListener {
            val name = validateName()
            val email = validateEmail()
            val numberPhone = validateNumberPhone()
            val password = validatePassword()
            navigateToLoginActivity(this, name, numberPhone, password, email)
        }
    }

    fun validateEmail(): String?{
        var email: String? = null
        val emailValidate = binding.edtEmail.text.toString()
        if(!Patterns.EMAIL_ADDRESS.matcher(emailValidate).matches()){
            binding.tilEmail.helperText = "Enail Inválido"
        } else{
            binding.tilEmail.helperText = null
            email = emailValidate
        }
        return email
    }

    fun validateNumberPhone(): String? {
        var numberPhone: String? = null
        val numberPhoneValidate = binding.edtNumberPhone.text.toString().trim()
        if(numberPhoneValidate.length != 11){
            binding.tilNumberPhone.helperText = "Esse número não existe"
        } else {
            binding.tilNumberPhone.helperText = null
            numberPhone = numberPhoneValidate
        }
        return numberPhone
    }

    fun validatePassword(): String?{
        var password: String? = null
        val passwordValidate = binding.edtPassword.text.toString().trim()
        if(passwordValidate.length < 5 ) {
            binding.tilPassword.helperText = "A Senha deve ter no mínimo 6 digitos"
        } else if(passwordValidate.isNullOrBlank()){
            binding.tilPassword.helperText = "Por favor digite sua senha"
        } else {
            binding.tilPassword.helperText = null
            password = passwordValidate
        }

        return password
    }

    fun validateName(): String?{
        var name: String? = null
        val nameValidate = binding.edtName.text.toString()
        if(nameValidate.isEmpty() || nameValidate.isBlank()){
            binding.tilName.helperText = "Insira seu Nome"
        } else{
            name = nameValidate
        }
        return name
    }

    fun navigateToLoginActivity(context: Context, name: String?, phone: String?, password: String?, email: String?){

        if(name != null && phone != null && password != null){
            val intent = Intent(context, LoginActivity::class.java)
            intent.putExtra("name", name)
            intent.putExtra("phone", phone)
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(context, "Confira se seus campos estão corretos", Toast.LENGTH_SHORT).show()
        }
    }
}
