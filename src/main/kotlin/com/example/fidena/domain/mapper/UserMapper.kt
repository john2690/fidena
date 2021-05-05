package com.example.fidena.domain.mapper

import com.example.fidena.common.model.UserModel
import com.example.fidena.domain.entity.User

object UserMapper {
    fun userModel(user: User) = UserModel(user.id, user.name, user.fatherLastName, user.motherLastName, user.age)
    fun userUpdate(userModel: UserModel, user: User) = user.apply {
        this.name = userModel.name
        this.fatherLastName = userModel.fatherLastName
        this.motherLastName = userModel.motherLastName
        this.age = userModel.age
    }
    fun userCreate(userModel: UserModel) = User().apply {
        this.name = userModel.name
        this.fatherLastName = userModel.fatherLastName
        this.motherLastName = userModel.motherLastName
        this.age = userModel.age
    }
}