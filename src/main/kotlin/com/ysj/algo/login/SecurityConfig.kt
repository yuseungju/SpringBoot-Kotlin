package com.ysj.algo.login

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.csrf.CookieCsrfTokenRepository


@Configuration
@EnableWebSecurity
open class SecurityConfig : WebSecurityConfigurerAdapter() {
    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http.authorizeRequests()
            .antMatchers("/auth1")
            .access("hasRole('AUTH1') and hasRole('AUTH2')")
            .antMatchers("/auth3")
            .access("hasRole('AUTH3')")
            .antMatchers("/", "/**").access("permitAll")
            .and() .formLogin() .loginPage("/login") .defaultSuccessUrl("/index",true)
            .and() .logout() .logoutSuccessUrl("/index")
            .and(). csrf().disable() //나중에 html 조작 방지하려면 추가

    }

    @Autowired
    private lateinit var userDetailsService: UserDetailsService
    @Bean
    fun encoder() = BCryptPasswordEncoder()

    @Throws(Exception::class)
    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService(userDetailsService).passwordEncoder(encoder())
    }

}
