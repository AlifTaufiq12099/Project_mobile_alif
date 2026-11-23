package com.example.aliftaufiq_3tib.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.aliftaufiq_3tib.data.entity.CartEntity

@Dao
interface CartDao {
    @Query("SELECT * FROM cart ORDER BY createdAt DESC")
    suspend fun getAll(): List<CartEntity>

    @Query("SELECT * FROM cart WHERE productName = :name LIMIT 1")
    suspend fun findByProductName(name: String): CartEntity?

    @Insert
    suspend fun insert(item: CartEntity)

    @Update
    suspend fun update(item: CartEntity)

    @Delete
    suspend fun delete(item: CartEntity)

    @Query("DELETE FROM cart")
    suspend fun clear()
}
