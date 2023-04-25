package cn.tulingxueyuan.controllers;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;


/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 */
@Controller
public class ResponseController {

    @RequestMapping("/response01")
    public String response01() {
        return "index";
    }

    /**
     * 转发请求处理
     *
     * forward:转发  ，它不会经过视图解析器的解析，适用于当访问的视图不在我们指定的前缀下
     */
    @RequestMapping("/forward")
    public String forward(Model model){
        model.addAttribute("type","转发");
        return "forward:/login.jsp";
    }

    /**
     * 重定向请求处理
     *
     * redirect:它不会经过视图解析器的解析，需要写上完整的逻辑视图名称
     *  重定向不能将地址重定向到WEB-INF中
     *  springmvc转发和重定向的“/” 都定位到项目名这一级
     *
     *  response.sendRedirect("/")
     *
     */
    @RequestMapping("/redirect")
    public String redirect(Model model){
        model.addAttribute("type","转发");
        return "redirect:/login.jsp";
    }


}
