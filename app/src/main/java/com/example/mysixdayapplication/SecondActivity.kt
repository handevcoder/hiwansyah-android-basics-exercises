package com.example.mysixdayapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val btnKirim = findViewById<Button>(R.id.btnKirim)
        val edtUser: (EditText) = findViewById(R.id.edtUserSecond)


        btnKirim.setOnClickListener {
            if (edtUser.text.isNotEmpty()) {

                val text = edtUser.text.toString()
                val i = Intent(this, ResultActivity::class.java)
                i.putExtra("user", text)
                startActivity(i)
            } else if (edtUser.text.isEmpty()){
                Toast.makeText(this, "Isi dahulu ya !!!", Toast.LENGTH_SHORT).show()
            }
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val TEXT_REQUEST = 1
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                val i = Intent(this, SecondActivity::class.java)
                val reply = data?.getStringExtra("user")

            }
        }
    }
}