package com.ysj.algo.login

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class UserRepositoryUserDetailsService(@Autowired val userRepository: IUserRepository)
    : UserDetailsService { @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String): UserDetails {
        val user = userRepository.findByName(username)
        return user ?: throw UsernameNotFoundException("loadUserByUsername() - cannot find username:$username)")
    }
}
