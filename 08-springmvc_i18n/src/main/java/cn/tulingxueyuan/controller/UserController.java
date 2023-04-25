package cn.tulingxueyuan.controller;

import cn.tulingxueyuan.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Locale;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 *
 * 1. 解决java的硬编码的国际化：
 *      1.在属性资源文件中加入需要国际化的硬编码内容
 *      2.将MessageSource 自动注入进来
 *      3.根据messageSource.getMessage 获取国际化内容
 *          String code 资源文件中的key
 *          args   文本中的参数， 可以用占位符的方式在资源文件文本中设置参数占位符：{0} 方式
 *          locale 当前本地化语言
 */
@Controller
public class UserController {

    @Autowired
    MessageSource messageSource;

    @PostMapping("/login")
    public String login(@Valid User user, BindingResult  bindingResult, Model model, Locale locale){
        if(bindingResult.hasErrors()){
            return "login";
        }

        // 验证用户名或密码是否正确
        if(!user.getEmail().equals("123@qq.com") &&
        !user.getPassword().equals("123456"))
        {
            //
            String login_error = messageSource.getMessage("login_error",new Object[]{user.getEmail(),user.getPassword()}, locale);
            model.addAttribute("errMsg",login_error);
            return "login";
        }
        return "admin";

    }
}
