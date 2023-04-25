package cn.tulingxueyuan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.PrintWriter;
import java.io.StringWriter;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 *
 * 处理异常：
 * 通过@ExceptionHandler可以在方法中记录日志
 *      转发一个友好的界面进行提示：
 *         经验：1.记录日志中
 *               2.可以将异常转发错误也没， 将错误信息在一个隐藏的div中
 *  如果@ExceptionHandler写在@Controller中只能处理当前控制器类的处理方法
 */
@Controller
public class ExceptionController {

    @RequestMapping("/exception")
    public String exception(@RequestParam("name") String name){
        System.out.println("方法处理中...");
        return "show";
    }

    @RequestMapping("/exception02")
    public String exception02(@RequestParam("name") String name){
        System.out.println("方法处理中2...");
        return "show";
    }

   /* @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception ex){
        System.out.println("@Controller异常处理");
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("error");
        modelAndView.addObject("ex",ex);
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);
        System.out.println(sw.toString());   // 日志记录
        return modelAndView;
    }*/
}
