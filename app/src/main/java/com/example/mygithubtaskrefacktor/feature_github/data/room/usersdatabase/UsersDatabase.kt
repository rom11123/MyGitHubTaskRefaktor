package com.example.mygithubtaskrefacktor.feature_github.data.room.usersdatabase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mygithubtaskrefacktor.feature_github.data.entity.projectentity.AllUsersEntity


@Database(entities = [AllUsersEntity::class], version = 1)

abstract class UsersDatabase:RoomDatabase() {
    abstract fun usersDao(): AllUsersDao

}

