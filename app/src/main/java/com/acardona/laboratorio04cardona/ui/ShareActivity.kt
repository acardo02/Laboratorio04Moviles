package com.acardona.laboratorio04cardona.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.acardona.laboratorio04cardona.R

class ShareActivity : AppCompatActivity() {
    private lateinit var nameTextView: TextView
    private lateinit var emailTextView: TextView
    private lateinit var phoneTextView: TextView
    private lateinit var shareButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share)

        bind()

        val name = intent.getStringExtra(MainActivity.SHARE_NAME).toString()
        val email = intent.getStringExtra(MainActivity.SHARE_EMAIL).toString()
        val phone = intent.getStringExtra(MainActivity.SHARE_PHONE_NUMBER).toString()

        nameTextView.text = "Nombre ${name}"
        emailTextView.text = "Correo electronico ${email}"
        phoneTextView.text = "Numero de telefono ${phone}"

        shareButton.setOnClickListener {
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "Nombre ${name} " + "Correo electronico ${email} " + " Numero de telefono ${phone} ")
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }
    }

    fun bind() {
        nameTextView = findViewById(R.id.nameTextView)
        emailTextView = findViewById(R.id.emailTextView)
        phoneTextView = findViewById(R.id.phoneTextView)
        shareButton = findViewById(R.id.shareButton)
    }
}