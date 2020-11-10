package com.example.mysixdayapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnSatu: Button = findViewById(R.id.btnSatu)
        var btnDua: Button = findViewById(R.id.btnDua)
        val btnTiga: Button = findViewById(R.id.btnTiga)

        btnSatu.setOnClickListener {
            val i = Intent(this, FirstActivity::class.java)
            startActivity(i)
        }
        btnDua.setOnClickListener {
            val i = Intent(this, SecondActivity::class.java)
            startActivity(i)
        }
        btnTiga.setOnClickListener {
            val i = Intent(this, ThirdActivity::class.java)
            startActivity(i)
        }


    }
}