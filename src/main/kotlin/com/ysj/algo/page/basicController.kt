package com.ysj.algo.page

import com.ysj.algo.login.IUserRepository
import com.ysj.algo.login.JoinUser
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping



@Controller
@RequestMapping("/")
class basicController() {
    //회원가입 페이지로
    @GetMapping("/index")
    fun index() = "index"  //index.html


    //회원가입 페이지로
    @GetMapping("/auth1")
    fun auth1() = "index"  //index.html
    @GetMapping("/auth2")
    fun auth2() = "index"  //index.html
    @GetMapping("/auth3")
    fun auth3() = "index"  //index.html
}
