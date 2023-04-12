package com.acardona.laboratorio04cardona.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.acardona.laboratorio04cardona.R
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private lateinit var nameEditText: TextInputEditText
    private lateinit var emailEditText: TextInputEditText
    private lateinit var phoneNumberEditText: TextInputEditText
    private lateinit var saveButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bind()

        saveButton.setOnClickListener {
            val intent = Intent(this, ShareActivity::class.java)
            intent.putExtra(SHARE_NAME, nameEditText.text.toString())
            intent.putExtra(SHARE_EMAIL, emailEditText.text.toString())
            intent.putExtra(SHARE_PHONE_NUMBER, phoneNumberEditText.text.toString())
            startActivity(intent)
        }
    }

    fun bind () {
        nameEditText = findViewById(R.id.nameValue)
        emailEditText = findViewById(R.id.emailValue)
        phoneNumberEditText = findViewById(R.id.phoneNumberValue)
        saveButton = findViewById(R.id.saveActionButton)
    }

    companion object {
        const val SHARE_NAME = "name"
        const val SHARE_EMAIL = "email"
        const val SHARE_PHONE_NUMBER = "phone_number"

    }
}