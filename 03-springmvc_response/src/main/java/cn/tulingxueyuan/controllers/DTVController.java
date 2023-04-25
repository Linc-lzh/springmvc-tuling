package cn.tulingxueyuan.controllers;

import cn.tulingxueyuan.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 *
 * 将数据传输到视图
 */
@Controller
// 从model中获取指定的属性写入session中
// 底层会从model中去找一个叫做type的属性
// 找到了会将type设置一份到session中
// 这种方式是依赖model的
@SessionAttributes("type")
public class DTVController {

    /**
     * 使用servlet API 的方式传输数据到视图
     *
     * @param request
     * @return
     */
    @RequestMapping("/servletAPI")
    public String servletAPI(HttpServletRequest request){
        request.setAttribute("type","servletAPI");
        return "main";
    }

    /**
     * 使用model的方式传输数据到视图
     * @return
     */
    @RequestMapping("/model")
    public String model(Model model){
        System.out.println(model.getClass());
        model.addAttribute("type","model");
        return "main";
    }


    /**
     * 使用modelmap的方式传输数据到视图
     * @return
     */
    @RequestMapping("/modelmap")
    public String modelmap(ModelMap modelmap){
        System.out.println(modelmap.getClass());
        modelmap.addAttribute("type","modelmap");
        return "main";
    }

    /**
     * 使用map的方式传输数据到视图
     * @return
     */
    @RequestMapping("/map")
    public String map(Map map){
        System.out.println(map.getClass());
        map.put("type","map");
        return "main";
    }


    /**
     * 通过ModelAndView传输数据到视图
     * @return
     */
    @RequestMapping("/ModelAndView")
    public ModelAndView modelAndView(){
        ModelAndView mv=new ModelAndView("main");

        //mv.setViewName();
        mv.addObject("type","ModelAndView");
        return mv;
    }

    /**
     * 通过参数绑定的方式获取servlet api——session
     * @return
     */
    @RequestMapping("/servletapi/session")
    public String session01(HttpSession session){
        session.setAttribute("type","servletapi-session");
        return "main";
    }

    @Autowired
    private HttpSession session;
    /**
     * 通过自动注入的方式去获取servlet api
     */
    @RequestMapping("/autowired/session")
    public String session02(){
        session.setAttribute("type","autowired-session");
        return "main";
    }

    /**
     * @SessionAttribute 获取session
     *  required 用来设置session中某个属性必须存在 ， 不存在则会报错：HTTP Status 400 - Missing session attribute 'type' of type String
     *  model和session是互通的：session可以通过model中去获取写入指定的属性， model也会从session中自动写入指定的属性
     * @param type
     * @return
     */
    @RequestMapping("/annotation/session")
    public String session03(@SessionAttribute(value="type",required = false) String type,Model model ){
        System.out.println(type);
        // model.addAttribute("type",type); 相当于隐式往model也写入了type
        return "main";
    }

    @RequestMapping("/modelattribute/session")
    public String session04() {
        session2.setAttribute("type","ModelAttribute-session");
        return "main";
    }

    @RequestMapping("/threand/session")
    public String session05(String name,HttpSession session) throws InterruptedException {
        Thread.sleep(3000);
        session.setAttribute("type",name);
        return "main";
    }


    /**
     * 通过 @ModelAttribute来获取Servlet api——session
     */
    HttpSession session2;
    @ModelAttribute
    public void showModelAttribute(HttpSession session){
        this.session2=session;
    }

   /* @ModelAttribute
    public void initUser(Model model){
         // 从数据库中查询User  select *from User
        User user=new User();
        user.setId(1);
        user.setUsername("徐庶");
        user.setPassword("123456");
        model.addAttribute("user",user);
    }*/


    /**
     *  springmvc在进行参数绑定以前 会 将model中的根参数名符合属性拿出来进行合并。  新提交的字段会覆盖，缺失的字段会保留
     * @param user
     * @return
     */
    @RequestMapping("/update")
    public String update(@ModelAttribute("user") User user){
        // update user set id=? ,username=?, password=? where id=?
        //select
        System.out.println(user);
        return "main";
    }
}
