package com.example.mygithubtaskrefacktor.feature_github.data.datasource.localdatasource.allusersdatasource

import com.example.mygithubtaskrefacktor.feature_github.data.entity.projectentity.AllUsersEntity
import com.example.mygithubtaskrefacktor.feature_github.data.room.usersdatabase.AllUsersDao
import kotlinx.coroutines.flow.Flow

class UsersLocalDataSourceImpl(private val usersDao: AllUsersDao):UsersLocalDataSource {
    override suspend fun getAllUsers():List<AllUsersEntity> = usersDao.readAllData()


    override suspend fun insert(users: List<AllUsersEntity>)  = usersDao.insert(users)

    override suspend fun deleteAll()  = usersDao.deleteAll()


}