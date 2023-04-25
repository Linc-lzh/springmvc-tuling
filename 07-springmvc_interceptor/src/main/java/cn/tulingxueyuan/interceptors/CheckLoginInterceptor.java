package cn.tulingxueyuan.interceptors;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 *
 * 验证用户是否登录拦截器
 */
public class CheckLoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession();
        // 如果没有登录
        if(StringUtils.isEmpty(session.getAttribute("username"))){
            response.sendRedirect(request.getContextPath()+"/login");
            return false;
        }
        else
        {
            return true;
        }
    }
}
