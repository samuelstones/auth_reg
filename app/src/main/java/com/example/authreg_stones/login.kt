package com.example.authreg_stones

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class login : AppCompatActivity() {


    private lateinit var emailtext: EditText
    private lateinit var passwordtext: EditText
    private lateinit var loginaccount: Button
    private lateinit var createaccount: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        emailtext = findViewById(R.id.editTextEmail)
        passwordtext = findViewById(R.id.editTextPassword)
        loginaccount = findViewById(R.id.btnlogin)
        createaccount = findViewById(R.id.btncreate)





        loginaccount.setOnClickListener {

            var emailedt = emailtext.toString().trim()
            var passwordedt = passwordtext.toString().trim()


            //Validate your edit texts

            if (emailedt.isEmpty() || passwordedt.isEmpty()) {

                Toast.makeText(this, "Cannot submit an Empty field", Toast.LENGTH_SHORT).show()

            } else {

                //insert data




                Toast.makeText(this, "login successfully", Toast.LENGTH_SHORT).show()


            }


            createaccount.setOnClickListener {

                var gotoregister = Intent(this, MainActivity::class.java)
                startActivity(gotoregister)

            }


        }

    }

}