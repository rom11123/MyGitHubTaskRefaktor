package com.example.mygithubtaskrefacktor.feature_github.data.entity.projectentity;

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "users")
data class AllUsersEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name ="id")
    val id: Int = 0,
    @ColumnInfo(name ="avatar_url")
    val avatarUrl: String?,
    @ColumnInfo(name = "login")
    val login: String?,
):Serializable

