package cn.tulingxueyuan.controllers;

import cn.tulingxueyuan.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 *
 *  用户rest风格CRUD
 *
 *  form表单提交PUT和DELETE出现问题：会将PUT和DELETE作为GET提交，因为HTML现在无法支持PUT和DELETE:
 *      解决：1.需要添加HiddenHttpMethodFilter过滤器
 *           2.在表单中添加一个有隐藏域<input type="hidden" value="put" name="_method">   value就是对应的请求方式
 *           3.将form的method设置POST
 *           4.过滤器就会自动将POST请求修改成隐藏域中对应值的请求
 *
 *
 *  tomcat 7以上的版本对request.method更加严格：只支持GET/POST/HEAD:
 *      HTTP Status 405 - JSPs only permit GET POST or HEAD
 *          1.用tomcat7
 *          2.不用转发，用重定向
 *          3. 将jsp的page指定 isErrorPage属性改成true(不建议)
 *          4. 自定义一个过滤器，将request.method改回POST
 */
@Controller
@RequestMapping("/rest")
public class RestController {

    // 查询
    @GetMapping("/user/{id}")
    public String get(@PathVariable("id") Integer id){
        System.out.println("查询用户:"+id);
        return "/index.jsp";
    }


    // 新增
    @PostMapping("/user")
    public String add(User user){
        System.out.println("新增用户:"+user);
        return "/index.jsp";
    }



    // 修改
    @PutMapping("/user/{id}")
    public String update(User user){
        System.out.println("修改用户:"+user);
        return "/index.jsp";
    }


    // 删除
    @DeleteMapping("/user/{id}")
    public String delete(@PathVariable("id") Integer id){
        System.out.println("删除用户:"+id);
        return "/index.jsp";
    }
}
