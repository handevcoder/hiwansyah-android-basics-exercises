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
import kotlinx.*
import kotlinx.android.synthetic.main.activity_login.*
import org.intellij.lang.annotations.Pattern
import org.w3c.dom.Text

class ThirdActivity : AppCompatActivity() {
    companion object {
        val USERNAME: String? = ""
        val PASSWORD: String? = ""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val edtUser: (EditText) = findViewById(R.id.edtUser)
        val edtPass: (EditText) = findViewById(R.id.edtPass)
        val btnLogin: (Button) = findViewById(R.id.btnLogin)
        btnLogin.setOnClickListener {

/*            if (edtUser.text.isEmpty() || edtPass.text.isEmpty()) {
                Toast.makeText(this,"Tidak boleh dikosongkan.", Toast.LENGTH_SHORT).show()
            } else if (edtUser.text.isNotEmpty() || edtPass.text.isNotEmpty()) {
                Toast.makeText(this,"Selamat anda berhasil login.", Toast.LENGTH_SHORT).show()

*/
            when {
                edtUser.text.toString().isEmailValid() && edtPass.text.toString()
                    .isPasswordValid() -> {
                    val intent = Intent(this, HomeActivity::class.java)
                    val bundle = Bundle()
                    bundle.putString(USERNAME, edtUser.text.toString())
                    bundle.putString(PASSWORD, edtPass.text.toString())
                    intent.putExtras(bundle)
                    startActivity(intent)
                }
                edtUser.text.isEmpty() -> edtUser.setError("Email is empty")
                edtPass.text.toString().length <= 8 -> {

                    edtPass.setError("minimum password 8 character")
                }
                edtPass.text.matches(Regex("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~\$^+=<>]).{8,20}\$")) == false -> {

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