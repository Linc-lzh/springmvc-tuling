package cn.tulingxueyuan.controllers;

import cn.tulingxueyuan.entity.Role;
import cn.tulingxueyuan.entity.User;
import cn.tulingxueyuan.entity.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 *
 * 处理请求参数：
 * 之前servlet api:
 * if(request.getParameter("age")!=null){
 *     //转换
 * }
 * 在springmvc中只需要在处理方法中声明对应的参数就可以自动接收请求的参数并且还可以自动转换类型
 * 如果类型未匹配会报400错误
 * 匹配规则：
 * 请求的参数必须跟处理方法的参数名一致
 * 如果处理方法的参数未传入的情况会自动传入null
 *
 * 如果请求的参数跟处理方法的参数名不一致：
 * @RequestParam  管理请求参数，用了这个注解之后默认必须要传入值否则报错
 *  value  用来重命名参数
 *  required  用来指定参数是否必须传入值
 *      true 默认   必须要传入， 如果没有传入则会报错:HTTP Status 400 - Required String parameter 'username' is not present
 *      false  可以不用必须传入值 ,如果没有传入会自动传入null
 *          注意：不要用基础数据类型，因为基础数据类型无法接收null
 *  defaultValue 默认值，当参数为null的时候会自动设置一个默认值
 *          注意：当设置了默认值可以省略required=false
 *
 *   处理请求参数乱码：
 *   GET:   直接设置tomcat目录下conf/server.xml  里面<Connector URIEncoding="UTF-8"
 *   POST:
 *   在servlet的时期： 在获取参数之前 设置 request.setCharacterEncoding("UTF-8")
 *                     但是在每个处理方法中都去设置一遍太麻烦
 *                     所以我们会用过滤器来处理编码的问题（终极解决方式）
 *    使用springmvc提供给我们的编码过滤器来解决POST乱码问题:CharacterEncodingFilter
 *    在web.xml里面配置.
 *
 *   复杂数据参数类型:
 *   对象：
 *    不用加上参数名字的，直接传入该对象对应的属性名字
 *    如果是包装类型的简单变量  直接输入属性名字= 表单元素的name : name="id"
 *    数组   =保证这一组的表单元素都是同样的name:     name="alias"
 *    List: 必须加上[索引]    name="list[0]"     如果List<User> : name="list[0].name"
 *    map:  必须加上[key]     name="map["key"]"
 *    实体类：  只能给某个属性去赋值   name="object.xxx"
 *
 *    注意：
 *    如果出现多个对象比如：（User user,Role role）
 *                       ： (List<User>)
 *    参数的情况 建议再次封装一层javaBean (DTO data transfer object)
 */
@Controller
public class ParamsContrller {

    @RequestMapping("/params01")
    public String params01(@RequestParam(value="username",defaultValue = "徐庶") String name){
        System.out.println(name);
        return "index.jsp";
    }


    /**
     * 复杂数据类型参数自动绑定演示 如果是List必须再使用JavaBean封装一层
     * @param userDTO
     * @return
     */
    @RequestMapping("/params02")
    public String params02(UserDTO userDTO){
        System.out.println(userDTO);
        return "/index.jsp";
    }


    /**
     * 复杂数据类型参数自动绑定演示
     * @param user
     * @return
     */
    @RequestMapping("/params03")
    public String params02(User user){
        System.out.println(user);
        return "/index.jsp";
    }


    /**
     * 获取请求头的信息@RequestHeader
     * 里面也有required 和 defaultValue 用法是一样的
     *
     * request.getHeader("")
     * @param host
     * @return
     */
    @RequestMapping("/header")
    public String header(@RequestHeader("Host") String host){
        System.out.println(host);
        return "/index.jsp";
    }


    /**
     * 获取cookie的值
     * Cookie[] cookies=request.getCookies;
     * for(Cookie cookie : cookies){
     *     if(cookie.getValue.equals("JSESSIONID"))
     *     {
     *         //getName
     *     }
     * }
     * @return
     */
    @RequestMapping("/cookie")
    public String cookie(@CookieValue("JSESSIONID") String jsessionId){
        System.out.println(jsessionId);
        return "/index.jsp";
    }


    /**
     * 获取servlet api
     *  springmvc+servlet api一起用
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/servlet")
    public String servlet(String username ,HttpServletRequest request, HttpServletResponse response){
        System.out.println(username);
        String name = request.getParameter("name");
        System.out.println(name);
        request.setAttribute("name",name);
        return "/index.jsp";
    }

}
