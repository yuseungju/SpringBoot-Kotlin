package com.ysj.algo.login

import org.springframework.data.repository.CrudRepository

interface IUserRepository: CrudRepository<User, Long> {
    fun findByName(name: String): User?
}
