package cn.tulingxueyuan.filters;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 */
@WebFilter("/*")
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("===================过滤器前===================");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("===================过滤器后===================");
    }

    @Override
    public void destroy() {

    }
}
