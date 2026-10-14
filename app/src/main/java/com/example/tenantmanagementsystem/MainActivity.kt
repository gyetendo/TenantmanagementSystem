package com.example.tenantmanagementsystem

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tenantmanagementsystem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var lastTenant: Tenant? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Task 2: Welcome the user (Reads email passed from LoginActivity)
        val userEmail = intent.getStringExtra("EMAIL")
        if (!userEmail.isNullOrEmpty()) {
            Toast.makeText(this, "Logged in as $userEmail", Toast.LENGTH_SHORT).show()
        }

        // Save tenant details WITH VALIDATION
        binding.saveButton.setOnClickListener {
            val name = binding.tenantNameEditText.text.toString().trim()
            val phone = binding.phoneEditText.text.toString().trim()
            val rent = binding.rentEditText.text.toString().trim()

            // Task 3: Validate the tenant inputs
            var isValid = true

            if (name.isEmpty()) {
                binding.tenantNameEditText.error = "Required"
                isValid = false
            }
            if (phone.isEmpty()) {
                binding.phoneEditText.error = "Required"
                isValid = false
            }
            if (rent.isEmpty()) {
                binding.rentEditText.error = "Required"
                isValid = false
            }

            // Stop execution if any field was empty
            if (!isValid) return@setOnClickListener

            // Save and display tenant if valid
            val tenant = Tenant(name, phone, rent)
            binding.tenant = tenant
            lastTenant = tenant

            Toast.makeText(this, "Tenant saved successfully", Toast.LENGTH_SHORT).show()
        }

        // Call tenant button
        binding.callButton.setOnClickListener {
            val tenant = lastTenant

            if (tenant == null) {
                Toast.makeText(this, "Save a tenant first", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:${tenant.phone}"))
            startActivity(intent)
        }

        // Task 1: Share tenant button
        binding.shareButton.setOnClickListener {
            val tenant = lastTenant

            if (tenant == null) {
                Toast.makeText(this, "Save a tenant first", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val shareIntent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, tenant.summary())
            }

            startActivity(Intent.createChooser(shareIntent, "Share tenant"))
        }
    }
}