package cn.tulingxueyuan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 *
 * 拦截器演示
 * 1.定义拦截器,必须要实现HandlerInterceptor
 * 2. 在springmvc配置文件中去配置拦截器
 *   <mvc:interceptors>
 *         <bean class="cn.tulingxueyuan.interceptors.MyInterceptor"></bean>
 *     </mvc:interceptors>
 */
@Controller
public class InterceptorController {

    @RequestMapping("/test01")
    public String test01(){
        System.out.println("请求方法执行中...");
        return "admin";
    }
}
