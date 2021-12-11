package com.ysj.algo.login

import org.springframework.security.crypto.password.PasswordEncoder

data class JoinUser(
    val name: String?,
    val pass: String?,
    val address: String?,
    val phoneNumber: String?)
{
    fun getUser(passwordEncoder: PasswordEncoder)
    = User( name = name, pass = passwordEncoder.encode(pass), address = address, phoneNumber = phoneNumber )
}
