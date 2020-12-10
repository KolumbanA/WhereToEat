package com.example.wheretoeat.Room

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "user_table")
data class User (
    @PrimaryKey(autoGenerate = true)
    val Id: Int,
    val Name: String,
    val Email: String,
    val Country: String,
    val Phone: String
)