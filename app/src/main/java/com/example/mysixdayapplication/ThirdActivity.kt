package com.example.mysixdayapplication

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.text.isDigitsOnly
import kotlinx.*
import kotlinx.android.synthetic.main.activity_login.*
import org.intellij.lang.annotations.Pattern
import org.w3c.dom.Text

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val edtUser: (EditText) = findViewById(R.id.edtUser)
        val edtPass: (EditText) = findViewById(R.id.edtPass)
        val btnLogin: (Button) = findViewById(R.id.btnLogin)
        btnLogin.setOnClickListener {
            when {
                edtUser.text.toString().isEmailValid() && edtPass.text.toString()
                    .isPasswordValid() -> {
                    val i = Intent(this, HomeActivity::class.java)
                }
                edtUser.text.isEmpty() -> edtUser.setError("Email is empty")
                edtPass.text.toString().length <= 8 -> {
//                    edtPass.text.clear()
                    edtPass.setError("minimum password 8 character")
                }
                edtPass.text.matches(Regex("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~\$^+=<>]).{8,20}\$")) == false -> {
//                    edtPass.text.clear()
                    edtPass.setError("Your password is not Alphanumeric")
                }
            }
        }
    }

    private fun String.isPasswordValid(): Boolean {
        return !TextUtils.isEmpty(this) && this.matches(Regex("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~\$^+=<>]).{8,20}\$"))
    }

    private fun String.isEmailValid(): Boolean {
        return !TextUtils.isEmpty(this) && android.util.Patterns.EMAIL_ADDRESS.matcher(this)
            .matches()
    }

}

