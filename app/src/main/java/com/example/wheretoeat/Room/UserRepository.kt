package com.example.wheretoeat.Room

import androidx.lifecycle.LiveData

class UserRepository(private val userDao: UserDao) {
    val readAllData: LiveData<User> = userDao.readUser()


    suspend fun addUser(user: User){
        userDao.addUser(user)
    }


}