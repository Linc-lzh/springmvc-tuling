package cn.tulingxueyuan.controllers;

import cn.tulingxueyuan.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 *
 *  基于服务api的方式使用restful api
 */

@RestController
@RequestMapping("/restful")
public class RestfultController {

    // 查询
    @GetMapping("/user/{id}")
    public String get(@PathVariable("id") Integer id){
        System.out.println("查询用户:"+id);
        return "{'id':'1','name':'徐庶'}";
    }


    // 新增
    @PostMapping("/user")
    public String add(User user){
        System.out.println("新增用户:"+user);
        return "{'msg':'success'}";
    }



    // 修改
    @PutMapping("/user/{id}")
    public String update(User user){
        System.out.println("修改用户:"+user);
        return "{'msg':'success'}";
    }


    // 删除
    @DeleteMapping("/user/{id}")
    public String delete(@PathVariable("id") Integer id){
        System.out.println("删除用户:"+id);
        return "{'msg':'success'}";
    }
}
