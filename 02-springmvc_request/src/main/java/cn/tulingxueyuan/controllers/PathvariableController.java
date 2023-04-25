package cn.tulingxueyuan.controllers;

import cn.tulingxueyuan.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 *
 * @PathVariable 用在参数上面的
 *  专门用来获取URL目录级别的参数
 *   比如 http://localhost:8080/springmvc/path/user/123/xushu
 *    要获得123   @RequestMapping("/user/{id}") : @PathVariable("id") Integer id
 *
 *    如果是单个参数接收必须要使用@PathVariable来声明对应的参数占位符名字
 *    如果是javaBean可以省略@PathVariable，要保证占位符的名字和javaBean的属性名字一样
 *
 */
@Controller
@RequestMapping("/path")
public class PathvariableController {

    /**
     * 获取用户实体   传入id
     * @return
     */
    @RequestMapping("/user/{id}/{username}")
    public String path01(@PathVariable("id") Integer id,@PathVariable("username") String name){
        System.out.println(id);
        System.out.println(name);
        return "/index.jsp";
    }

    @RequestMapping("/user02/{id}/{name}")
    public String path02(User user){
        System.out.println(user);
        return "/index.jsp";
    }
}
