package cn.tulingxueyuan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 */
@Controller
public class UserController {

   @PostMapping("/login")
    public String login(HttpSession session){
        //登录成功
        session.setAttribute("username","xushu");
        return "admin";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
