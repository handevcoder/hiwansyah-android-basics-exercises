package com.example.mysixdayapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val btnKirimBalik = findViewById<Button>(R.id.btnKirimBalik)
        val text = intent.getStringExtra("user")
        val edtUser: (EditText) = findViewById(R.id.edtUserResult)
        edtUser.setText("$text")

        btnKirimBalik.setOnClickListener {

            if (edtUser.text.isNotEmpty()) {
                Snackbar.make(it, "Edit Text tidak sedang kosong !", Snackbar.LENGTH_SHORT).show()
                    val reply = edtUserResult.text.toString()
                    val i = Intent(this, SecondActivity::class.java)
                    i.putExtra("user", reply)
                    setResult(RESULT_OK, i)
                    finish()
            } else if (edtUser.text.isEmpty())Snackbar.make(it,
                "Edit Text sedang kosong, Silahkan isi dahulu !",
                Snackbar.LENGTH_LONG).show()

        }
    }
}