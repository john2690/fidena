package com.example.fidena.common.model

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.PropertyNamingStrategy.SnakeCaseStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming
import java.util.Date

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(SnakeCaseStrategy::class)
data class UserModel(
    var id: Long? = null,
    var name: String? = null,
    var fatherLastName: String? = null,
    var motherLastName: String? = null,
    var age: Int? = null,
    var createdAt: Date = Date(),
    var updatedAt: Date = Date()
)