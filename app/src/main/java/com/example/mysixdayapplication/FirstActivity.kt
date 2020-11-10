package com.example.mysixdayapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class FirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        val btnKirim: (Button) = findViewById(R.id.btnKirim)
        val edtUser = findViewById<EditText>(R.id.edtUser)

        btnKirim.setOnClickListener {
            val text = edtUser.text.toString()
            val i = Intent(this, DetailActivity::class.java)
            i.putExtra("user", text)
            startActivity(i)
        }
    }
}