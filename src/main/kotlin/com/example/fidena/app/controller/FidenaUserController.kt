package com.example.fidena.app.controller

import com.example.fidena.common.model.UserModel
import com.example.fidena.common.route.Route.ROUTE_BASE
import com.example.fidena.common.route.Route.USER_BY_ID
import com.example.fidena.common.route.PathVariables.USER_ID
import com.example.fidena.domain.mapper.UserMapper
import com.example.fidena.domain.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.DataAccessException
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestBody


@RestController
@RequestMapping(value = [ROUTE_BASE], produces = [APPLICATION_JSON_VALUE])
class FidenaUserController {

    @Autowired
    private lateinit var userRepository: UserRepository

    @PostMapping
    fun createUser(@RequestBody userModel: UserModel): ResponseEntity<HttpStatus> {
        return try {
            if (userModel.name.isNullOrBlank().not() && userModel.fatherLastName.isNullOrBlank().not() && userModel.motherLastName.isNullOrBlank().not()) {
                userRepository.save(UserMapper.userCreate(userModel))
                ResponseEntity(HttpStatus.CREATED)
            } else {
                ResponseEntity(HttpStatus.BAD_REQUEST)
            }
        } catch (ex: DataAccessException) {
            ResponseEntity(HttpStatus.CONFLICT)
        }

    }

    @GetMapping(USER_BY_ID)
    fun getUser(@PathVariable(USER_ID) userId: Long): ResponseEntity<UserModel> {
        val user = userRepository.findById(userId)
        return if (user.isPresent) {
            ResponseEntity(UserMapper.userModel(user.get()), HttpStatus.OK)
        } else {
            ResponseEntity(HttpStatus.BAD_REQUEST)
        }
    }

    @PatchMapping(USER_BY_ID)
    fun updateUser(@PathVariable(USER_ID) userId: Long,
                   @RequestBody userModel: UserModel): ResponseEntity<HttpStatus> {
        val user = userRepository.findById(userId)
        return if (user.isPresent) {
            userRepository.save(UserMapper.userUpdate(userModel, user.get()))
            ResponseEntity(HttpStatus.OK)
        } else {
            ResponseEntity(HttpStatus.BAD_REQUEST)
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(USER_BY_ID)
    fun deleteUser(@PathVariable(USER_ID) userId: Long){
        userRepository.deleteById(userId)
    }


}