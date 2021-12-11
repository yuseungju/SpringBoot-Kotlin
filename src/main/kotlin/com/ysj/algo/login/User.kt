package com.ysj.algo.login

import org.hibernate.annotations.CreationTimestamp
import org.springframework.boot.autoconfigure.security.SecurityProperties
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.time.LocalDateTime
import java.util.stream.Collectors
import javax.persistence.*

@Entity
data class User(
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = -1,
    val name: String?,
    val pass: String?,
    val address: String?,
    val phoneNumber: String?

) : UserDetails {

    constructor()
            : this(-1, null, null, null, null)

    override fun getAuthorities(): MutableCollection<out GrantedAuthority>
            = arrayListOf(SimpleGrantedAuthority("AUTH1"))

    override fun getPassword() = pass
    override fun getUsername() = name
    override fun isAccountNonExpired() = true
    override fun isAccountNonLocked() = true
    override fun isCredentialsNonExpired() = true
    override fun isEnabled() = true
}