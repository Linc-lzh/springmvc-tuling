package cn.tulingxueyuan.controller;

import cn.tulingxueyuan.entity.User;
import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 *
 * springmvc 已经底层已经做好了自动类型转换
 */
@Controller
@RequestMapping("/converter")
public class ConverterController {


    @RequestMapping("/test")
    public String test( User user){
        System.out.println(user);
        return  "show";
    }


    @Test
    public void test01(){
        //Tue Jan 01 00:00:00 CST 2019
        //Tue Jan 01 00:00:00 CST 2019
        Date date=new Date("2019-01-01");
        System.out.println(date);
    }
}
