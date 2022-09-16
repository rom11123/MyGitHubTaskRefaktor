package com.example.mygithubtaskrefacktor.feature_github.data.room.repodatabase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mygithubtaskrefacktor.feature_github.data.entity.projectentity.RepositoryEntity


@Database(entities = [RepositoryEntity::class], version = 1)

abstract class RepoDatabase:RoomDatabase() {
    abstract fun repoDao(): RepositoriesDao

}

