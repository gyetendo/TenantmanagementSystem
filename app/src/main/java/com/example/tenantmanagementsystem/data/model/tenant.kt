package com.example.tenantmanagementsystem.data.model

import java.io.Serializable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tenants")
data class Tenant(
    val name: String,
    val phone: String,
    val rent: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
) : Serializable {

    fun summary(): String {
        return "Tenant: $name\nPhone: $phone\nRent: KSh $rent"
    }
}