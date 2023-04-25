package cn.tulingxueyuan.controller;

import cn.tulingxueyuan.entity.User;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.*;


/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 *
 * 实现数据验证的步骤：
 * 1.加入hibernate-validator依赖
 * 2.一定要注意！！将新加入的jar包 加入到WEB-INF/lib中
 * 3.在需要验证的javaBean的属性上面中加入对应的验证注解，可以设置message属性定制更友好错误提示信息
 * 4.在需要验证的处理方法的对应javaBean参数上面加上@Valid
 * 5.在需要验证的处理方法参数中加入BindingResult，代表自己处理错误，这样就不会显示错误页面了。
 *
 *  ·基于原生html form表单实现方式：
 *      1.在将错误信息循环通过map存入到request域中
 *      2.在jsp通过${errors.id}获取对应的错误信息
 *  ·基于spring form标签库的实现方式：
 *      1.添加一个显示jsp的处理方法， 一定要传入一个空的User到model中
 *      2.在jsp中导入spring-form标签库
 *      3.在form标签上一定要加上ModelAtrribute
 *      4.加上对应的form标签  必须都要以<form:开头
 *
 */
@Controller
public class UserController {

    @PostMapping("/user")
    public String add(@Valid User user, BindingResult result, Model model){
        /*
         将错误信息取出来，输出到jsp页面
         */
        // 判断当前是否出现了错误
        if(result.hasErrors()){
            // 存放错误信息:key=错误信息的属性名 value=错误信息
            // 这样就有利于在jsp中分别取出${errors.id}
            Map<String,String> errors=new HashMap<>();
            // 获取所有的错误信息   包含 错误的属性，错误信息
            List<FieldError> fieldErrors = result.getFieldErrors();
            // 循环转移到map中
            for (FieldError fieldError :fieldErrors){
                //fieldError.getField() 是属性名
                //fieldError.getDefaultMessage() 验证失败的错误信息
                errors.put(fieldError.getField(),fieldError.getDefaultMessage());
            }
            model.addAttribute("errors",errors);
            // 如果验证失败将请求重新转发到添加页面
            return "user/add";
        }

        System.out.println(user);
        return "show";
    }



    @PostMapping("/form/user")
    public String springformAdd(@Valid User user, BindingResult result, Model model) {

        // 判断当前是否出现了错误
        if(result.hasErrors()) {
            return "user/add";
        }
        System.out.println(user);
        return "show";
    }

    @ModelAttribute
    public void initData(Model model){
        // 初始化该页面的数据
        /*List<String> list=Arrays.asList("唱歌","跳舞");
        model.addAttribute("list",list);*/
        Map<String,String> map=new HashMap<>();
        map.put("1","唱歌");
        map.put("2","跳舞");
        model.addAttribute("list",map);
    }

    @GetMapping("/user/add")
    public String addView(User user){
        return "user/add";
    }

}
