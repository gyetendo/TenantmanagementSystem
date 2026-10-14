package com.example.tenantmanagementsystem

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tenantmanagementsystem.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Check if an email was sent back from RegisterActivity
        val registeredEmail = intent.getStringExtra("EMAIL")
        if (registeredEmail != null) {
            binding.emailEditText.setText(registeredEmail)
        }

        // Login button action
        binding.loginButton.setOnClickListener {
            val email = binding.emailEditText.text.toString().trim()
            val password = binding.passwordEditText.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter your email and password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Passes the email to MainActivity so it can show the Welcome Toast
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("EMAIL", email)
            startActivity(intent)
            finish()
        }

        // Open Register screen
        binding.registerTextView.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}