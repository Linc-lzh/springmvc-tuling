package cn.tulingxueyuan.controller;

import cn.tulingxueyuan.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 *
 * ·响应json
 * 1. 加入jackson依赖
 * 2. 将jackson 的jar包加入WEB-INF的lib文件夹
 * 3.在对应处理方法上面加上@ResponseBody用于标记该处理方法返回json
 *      将@Controller改成@RestController
 *
 * ·请求Json接收
 * 使用 @RequestBody  ，提前是一定要保证请求过来的参数数据一定json数据，并且内容类型也必须要是"application/json"
 *
 */
@Controller
//@RestController   // 相当于控制器类中所有的处理方法都加上了@ResponseBody, 适用于web api
public class JsonController {

    @RequestMapping("/json/response")
    @ResponseBody    //将返回值作为文本进行返回，并不是返回视图逻辑名称了，适用于单体应用
    public  User responseJson(){
        User user = new User(1, "徐庶","12346",new Date());

        return user;

    }

    @RequestMapping("/json/response2")
    public  String responseJson2(){
       return "json";

    }


    @PostMapping(value="/json/request01",consumes = "application/json")
    @ResponseBody
    public  User requestJson01(@RequestBody String name){
        User user = new User(1, "徐庶","12346",new Date());
        System.out.println(name);
        return user;

    }


    @PostMapping(value="/json/request02",consumes = "application/json")
    @ResponseBody
    public  User requestJson02(@RequestBody User user){
        User user2 = new User(1, "徐庶","12346",new Date());
        System.out.println(user);
        return user2;

    }

    @PostMapping(value="/json/request03",consumes = "application/json")
    @ResponseBody
    public  User requestJson03(@RequestBody Map<String,String> map){
        User user2 = new User(1, "徐庶","12346",new Date());
        System.out.println(map);
        return user2;

    }


    @PutMapping(value="/json/request04",consumes = "application/json")
    @ResponseBody
    public  User requestJson04(@RequestBody List<User> list){
        User user2 = new User(1, "徐庶","12346",new Date());
        System.out.println(list);
        return user2;
    }
}
