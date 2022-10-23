package com.example.practicaspropias

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.practicaspropias.databinding.ActivitySignUpBinding
import com.example.practicaspropias.datas.User
import com.example.practicaspropias.datas.UserDataBase
import com.example.practicaspropias.exceptions.IncorrectDataException

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.signUpSendButton.setOnClickListener {


            try {


                val user = checkFieldsSignUp()

                UserDataBase.userList.add(user)

                var intent = Intent(this, WelcomeActivity::class.java)
                startActivity(intent)

            }catch (e : IncorrectDataException){

                Toast.makeText(this,e.message, Toast.LENGTH_SHORT).show()

            }


        }

    }

    private fun checkFieldsSignUp() : User {

        var user : User

        var userName = binding.signUpUser.text
        var userPass = binding.signUpPass.text
        var userCPass = binding.signUpPassConfirm.text
        var email = binding.signUpMail.text



        if(userName.isEmpty() || userPass.isEmpty() || userCPass.isEmpty() || email.isEmpty())

            throw IncorrectDataException("Debes rellenar todos los campos.")

       println(userPass.equals(userCPass))

        if (userPass.toString() != userCPass.toString())

            throw IncorrectDataException("Las contraseñas no coinciden.")

        user = User(userName.toString(),userPass.toString(),email.toString())

        return user

    }


}