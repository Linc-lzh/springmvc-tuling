package cn.tulingxueyuan.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 *
 * @RequestMapping 用来处理URL映射 将请求映射到处理方法中
 *  除了可以用在方法上面 还可以同时用在类上面：
 *                  将请求URL模块化
 *                  避免请求方法映射中的映射重复
 *  如果加在类上面，该类所有请求方法的映射都必须加上类的映射：@RequestMapping("/mapping")   /mapping/xxxx
 *  value  设置请求URL映射
 *  method 设置请求方式   GET/POST
 *         HTTP Status 405 - Request method 'GET' not supported
 *         可以设置多个请求方式：method = {RequestMethod.POST,RequestMethod.GET}
 *         如果不写就可以匹配所有请求方式
 *  从spring4.3开始提供了一套简写请求方式的注解
 *   @PostMapping("mapping02")
 *   @GetMapping
 *   @PutMapping
 *   @DeleteMapping
 *
 *   params : 设置请求必须携带某些参数
 *              1. 必须要有某些参数  params = {"username"}
 *              2. 必须没有某些参数  params = {"!username"}
 *              3. 参数必须要等于什么值  params = {"username=徐庶"}
 *              4. 参数必须要不等于什么值  params = {"username!=徐庶"}
 *  headers: 请求头必须包含某个值：headers = {"Accept-Language=zh-CN,zh;q=0.9"}
 *  consumes: 当前请求的内容类型必须为指定值
 *                  常见请求内容类型：
 *                      application/x-www-form-urlencoded  form表单提交默认的内容类型
 *                      multipart/form-data    form表单提交文件流的的内容类型
 *                      application/json       ajax提交的json内容类型
 *      请求内容类型不匹配：HTTP Status 415 -
 *      consumes = {"application/x-www-form-urlencoded"}
 *
 *
 *  produces：设置当前响应的内容类型：produces = {"application/json"}
 *
 *
 *  映射的URL还可以支持通配符  /ANT  style
 *     1.?      一个?匹配单个字符(a-z0-9)[1]
 *     2.*      一个*匹配任意个字符(a-z0-9)[任意个]
 *     3.**     **匹配任意个字符任意层次    /** /
 *
 *     如果映射存在包含关系会优先交给更精确的那个映射处理
 *     没有通配符>?>*>**
 *     假如有4个映射处理方法：
 *      ant  ant?   ant*   /** /ant
 *
 *     http://localhost:8080/springmvc/mapping/ant   ant处理
 *     http://localhost:8080/springmvc/mapping/ant1   ant?处理
 *     http://localhost:8080/springmvc/mapping/ant123   ant*处理
 *
 *
 */
@Controller
@RequestMapping("/mapping")
public class MappingController {

    @RequestMapping("/mapping01")
    public String mapping01(){
        System.out.println("映射成功!");
        return "/index.jsp";
    }

    //@RequestMapping(value="/mapping02",method = {RequestMethod.POST})
    @PostMapping("/method")   // 等同于上面的
    public String mapping02(){
        System.out.println("请求方式映射!");
        return "/index.jsp";
    }

    @RequestMapping(value="/params",params = {"username!=徐庶"})
    public String mapping03(){
        System.out.println("请求参数映射!");
        return "/index.jsp";
    }

    @RequestMapping(value="/headers",headers = {"Accept-Language=zh-CN,zh;q=0.9"})
    public String mapping04(){
        System.out.println("请求头映射!");
        return "/index.jsp";
    }

    @RequestMapping(value="/consumes",consumes = {"application/x-www-form-urlencoded"})
    public String mapping05(){
        System.out.println("请求内容类型映射!");
        return "/index.jsp";
    }

    @RequestMapping(value="/produces",produces = {"application/json"})
    public String mapping06(){
        System.out.println("响应的内容类型!");
        return "/index.jsp";
    }


    // localhost:8080/springmvc/mapping/ant1

    @RequestMapping(value="/ant*")
    public String mapping08(){
        System.out.println("通配符——*");
        return "/index.jsp";
    }
    @RequestMapping(value="/ant?")
    public String mapping07(){
        System.out.println("通配符——？");
        return "/index.jsp";
    }
    @RequestMapping(value="/**/ant")
    public String mapping09(){
        System.out.println("通配符——**");
        return "/index.jsp";
    }


}
