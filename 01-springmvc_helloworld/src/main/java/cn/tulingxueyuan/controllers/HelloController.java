package cn.tulingxueyuan.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 */
@Controller
public class HelloController {

    /**
     * RequestMapping  将方法映射给对应的url请求处理
     * @param name   springmvc 自动匹配请求的参数值
     * @return
     */
    @RequestMapping("/Hello")
    public String hello(String name){
        System.out.println("hello springmvc:"+name);

        // 响应
        // redirect 重定向
        // forward  转发  默认
        return "index.jsp";
    }

}
