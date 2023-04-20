package com.example.authreg_stones

import android.content.Context
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
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
    private lateinit var db: SQLiteDatabase



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        emailtext = findViewById(R.id.editTextEmail)
        passwordtext = findViewById(R.id.editTextPassword)
        loginaccount = findViewById(R.id.btnlogin)
        createaccount = findViewById(R.id.btncreate)



        db = openOrCreateDatabase("StonesDB", Context.MODE_PRIVATE, null)





        loginaccount.setOnClickListener {

            val emailedt = emailtext.toString().trim()
            val passwordedt = passwordtext.toString().trim()


            //Validate your edit texts


            if (emailedt.isEmpty()|| passwordedt.isEmpty()){

                Toast.makeText(this, "Cannot submit an empty field", Toast.LENGTH_SHORT).show()

            }else{
                val cursor = db.rawQuery("SELECT * FROM users WHERE arafa=? AND funguo=?", arrayOf(emailedt, passwordedt))

                if (cursor != null && cursor.moveToFirst()) {
                    // user is authenticated, start a new activity
                    val intent = Intent(this, DashboardActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, "Invalid email or password, please try again", Toast.LENGTH_SHORT).show()
                }

            }





            createaccount.setOnClickListener {

                var gotocreate= Intent(this, login::class.java)
                startActivity(gotocreate)

            }













        }

    }

}