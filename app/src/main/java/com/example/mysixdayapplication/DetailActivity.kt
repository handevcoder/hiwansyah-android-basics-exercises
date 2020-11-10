package com.example.mysixdayapplication

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val text = intent.getStringExtra("user")
        val edtUser: (EditText) = findViewById(R.id.edtUserDetail)
        edtUser.setText("$text")

    }
}