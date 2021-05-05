package com.example.fidena.domain.entity

import java.util.Date
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Column
import javax.persistence.Table
import javax.persistence.PrePersist
import javax.persistence.PreUpdate


@Entity
@Table(name = "users")
class User(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long? = null,

    @Column(name = "name")
    var name: String? = null,

    @Column(name = "father_last_name")
    var fatherLastName: String? = null,

    @Column(name = "mother_last_name")
    var motherLastName: String? = null,

    @Column(name = "age")
    var age: Int? = null,

    @Column(name = "created_at")
    var createdAt: Date = Date(),

    @Column(name = "updated_at")
    var updatedAt: Date = Date()
) {
    @PrePersist
    fun prePersist() {
        this.createdAt = Date()
        this.updatedAt = Date()
    }

    @PreUpdate
    fun preUpdate() {
        this.updatedAt = Date()
    }
}