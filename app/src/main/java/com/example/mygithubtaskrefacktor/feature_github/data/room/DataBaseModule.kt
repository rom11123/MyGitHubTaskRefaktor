package com.example.mygithubtaskrefacktor.feature_github.data.room

import android.app.Application
import androidx.room.Room
import com.example.mygithubtaskrefacktor.feature_github.data.room.repodatabase.RepoDatabase
import com.example.mygithubtaskrefacktor.feature_github.data.room.repodatabase.RepositoriesDao
import com.example.mygithubtaskrefacktor.feature_github.data.room.usersdatabase.AllUsersDao
import com.example.mygithubtaskrefacktor.feature_github.data.room.usersdatabase.UsersDatabase
import org.koin.dsl.module


val dataBaseModule =  module {


    fun provideUserdataBase(application: Application): UsersDatabase =
        Room.databaseBuilder(application, UsersDatabase::class.java, "userDatabase")
            .fallbackToDestructiveMigration()
            .build()

    fun provideUserDao(db: UsersDatabase): AllUsersDao = db.usersDao()

    single {
        provideUserdataBase(get())

    }
    single {
        provideUserDao(get())
    }

    fun provideRepoDataBase(application:Application):RepoDatabase =
        Room.databaseBuilder(application,RepoDatabase::class.java,"repoDatabase")
            .fallbackToDestructiveMigration()
            .build()


    fun provideRepoDao(db: RepoDatabase): RepositoriesDao = db.repoDao()

    single { provideRepoDataBase(get()) }

    single { provideRepoDao(get()) }
}