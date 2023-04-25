package cn.tulingxueyuan.interceptors;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 *
 */
public class MyInterceptor implements HandlerInterceptor {

    /**
     * 在处理方法之前执 日志、权限、 记录调用时间
     * @param request 可以在方法请求进来之前更改request中的属性值
     * @param response
     * @param handler 封装了当前处理方法的信息
     * @return true 后续调用链是否执行/ false 则中断后续执行
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

         // 在请求映射到对应的处理方法映射，实现类才是HandlerMethod。
        // 如果是视图控制器，实现类ParameterizableViewController
        if(handler instanceof HandlerMethod ) {
            HandlerMethod handMethod = (HandlerMethod) handler;
        }
        /*System.out.println("-------类["+handMethod.getBean().getClass().getName()+"]" +
                "方法名["+handMethod.getMethod().getName()+"]" +
                "参数["+ Arrays.toString(handMethod.getMethod().getParameters()) +"]前执行--------preHandle");*/
        System.out.println("---------方法后执行，在渲染之前--------------preHandle");
        return true;
    }

    /**
     *  如果preHandle返回false则会不会允许该方法
     *  在请求执行后执行, 在视图渲染之前执行
     *  当处理方法出现了异常则不会执行方法
     * @param request
     * @param response 可以在方法执行后去更改response中的信息
     * @param handler  封装了当前处理方法的信息
     * @param modelAndView 封装了model和view.所以当请求结束后可以修改model中的数据或者新增model数据，  也可以修改view的跳转
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("---------方法后执行，在渲染之前--------------postHandle");
    }

    /**
     * 如果preHandle返回false则会不会允许该方法
     * 在视图渲染之后执行，相当于try catch finally 中finally，出现异常也一定会执行该方法
     * @param request
     * @param response
     * @param handler
     * @param ex  Exception对象，在该方法中去做一些：记录异常日志的功能，或者清除资源
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("---------在视图渲染之后--------------afterCompletion");
    }
}
