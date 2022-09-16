package com.example.mygithubtaskrefacktor.feature_github.data.room.repodatabase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mygithubtaskrefacktor.feature_github.data.entity.projectentity.RepositoryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RepositoriesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(repo:List<RepositoryEntity>)

    @Query("SELECT * FROM repository ORDER BY id  ASC")
    fun readAllData(): Flow<List<RepositoryEntity>>


    @Query("DELETE FROM repository" )
    suspend fun deleteAll()
}