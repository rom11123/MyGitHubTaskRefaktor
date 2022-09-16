package com.example.mygithubtaskrefacktor.feature_github.data.room.usersdatabase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mygithubtaskrefacktor.feature_github.data.entity.projectentity.AllUsersEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AllUsersDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user:List<AllUsersEntity>)

    @Query("SELECT * FROM users ORDER BY id  ASC")
   suspend fun readAllData():List<AllUsersEntity>


    @Query("DELETE FROM users" )
    suspend fun deleteAll()
}