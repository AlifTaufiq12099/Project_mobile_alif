package com.example.aliftaufiq_3tib.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cart")
data class CartEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val productName: String,
    val price: Long,
    val imageUrl: String,
    val quantity: Int = 1,
    val createdAt: Long = System.currentTimeMillis()
)
