package com.example.mygithubtaskrefacktor.feature_github.data.entity.projectentity;

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "repository")

data class RepositoryEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    @ColumnInfo(name ="private")
    val isPrivate: Boolean,
    val language: String
        )
