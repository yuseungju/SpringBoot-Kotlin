package com.ysj.algo.login

import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/register")
class RegistrationController(val userRepository: IUserRepository, val passwordEncoder: PasswordEncoder) {

    //회원가입 페이지로
    @GetMapping
    fun registerForm() = "registration"

    //일반 회원가입
    @PostMapping
    fun processRegistration(model: JoinUser): String
    {
        userRepository.save(model.getUser(passwordEncoder))
        return "redirect:/login" //가입 후 로그인으로
    }
}
