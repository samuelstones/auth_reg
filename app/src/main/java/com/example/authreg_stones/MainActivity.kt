package com.example.authreg_stones

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var firstnametext: EditText
    private lateinit var secondnametext: EditText
    private lateinit var emailtext: EditText
    private lateinit var passwordtext: EditText
    private lateinit var savebtn: Button
    private lateinit var db: SQLiteDatabase


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firstnametext = findViewById(R.id.editfirstname)
        secondnametext = findViewById(R.id.editsecondname)
        emailtext = findViewById(R.id.editemailadress)
        passwordtext = findViewById(R.id.editPassword)


        //Creating our database
        db = openOrCreateDatabase("StonesDB", Context.MODE_PRIVATE, null)

        //creating our table
        db.execSQL("CREATE TABLE IF NOT EXISTS users(firstname VARCHAR, seconddname VARCHAR, email VACHAR, password VACHAR )")


        savebtn.setOnClickListener {

            val firstnameedt = firstnametext.text.toString().trim()
            val secondnameedt = secondnametext.text.toString().trim()
            val emailedt = emailtext.text.toString().trim()
            val passwordedt = passwordtext.text.toString().trim()


            //Validate your edit texts

            if(firstnameedt.isEmpty() || secondnameedt.isEmpty() || emailedt.isEmpty() || passwordedt.isEmpty()) {

                Toast.makeText(this, "Cannot submit an Empty field", Toast.LENGTH_SHORT).show()

            }else {

                //insert data

                db.execSQL("INSERT INTO users VALUES(  '\"+firstnameedt\"' , '\"+secondnameedt\"' , '\"+emailedt\"', '\"+passwordedt\"' )")


                Toast.makeText(this, "User created Successfully", Toast.LENGTH_SHORT).show()





            }






        }
    }

}