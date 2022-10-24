package com.example.practicaspropias

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.practicaspropias.databinding.ActivityLogInBinding
import com.example.practicaspropias.datas.UserDataBase
import com.example.practicaspropias.exceptions.IncorrectDataException

class LogInActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLogInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        binding = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.logInSendButton.setOnClickListener {

            try {

                checkUserData()

            }catch ( e : IncorrectDataException){

                Toast.makeText(this,e.message,Toast.LENGTH_SHORT).show()

            }

        }

    }

    private fun checkUserData() {

        val userName = binding.logInUser.text
        val pass = binding.logInPass.text

        if (userName.isEmpty() || pass.isEmpty())

            throw IncorrectDataException("Debes rellenar los campos.")


        when(UserDataBase.checkLoginUser(userName.toString(), pass.toString())){

            -1 -> Toast.makeText(this,"No hay ningún usuario con ese nombre", Toast.LENGTH_SHORT).show()
            0 -> Toast.makeText(this,"Contraseña equivocada", Toast.LENGTH_SHORT).show()
            1 -> {

                val intent = Intent(this, MainWindowActivity::class.java)
                startActivity(intent)

            }

        }

    }

}