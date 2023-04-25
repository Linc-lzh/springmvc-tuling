package cn.tulingxueyuan.controller;

import cn.tulingxueyuan.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;


/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 *
 * ·基于浏览器设置的语言切换国际化
 *      1.新建jsp对应的国际化属性资源文件:
 *          login.properties
         * login_en_US.properties
         * login_zh_CN.properties
 *     2.配置springmvc, 将国际化资源文件注入到springmvc中
 *       <bean class="org.springframework.context.support.ResourceBundleMessageSource" id="messageSource">
 *         <property name="basenames">
 *             <array>
 *                 <value>i18n/login</value>
 *             </array>
 *         </property>
 *
 *     </bean>
 *     3. 在页面来调用属性资源文件<spring:message></spring:message>
 *
 *
 *   ·使用超链接的方式切换语言
 *      1.更改默认本地化语言解析器LocaleResolver 改成SessionLocaleResolver
 *      方式1:  创建一个请求方法，接收local参数(en_US、zh_CN)   设置session中去
 *      方式2:  使用springmvc提供的拦截器，接收local参数(en_US、zh_CN)   设置session中去
 *
 */
@Controller
public class I18NController {

    @RequestMapping("/i18n")
    public  String i18n(User user){
        return "login";
    }

    @RequestMapping("/i18n/{language}_{country}")
    public String changeLocale(@PathVariable("language") String language,
                               @PathVariable("country") String country,
                               HttpServletRequest request,
                               HttpServletResponse response,
                               @Autowired SessionLocaleResolver localeResolver){
        Locale local=new Locale(language,country);
        localeResolver.setLocale(request,response,local);
        return "login";

    }
}
