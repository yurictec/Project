package project.carRental.filters;

import project.carRental.constantPages.ConstantPage;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Yuriy Kolennikov
 */

@WebFilter(filterName = "MyFilter")
public class MyFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpSession session = ((HttpServletRequest) req).getSession();

        if(session.getAttribute("email") != null){
            chain.doFilter(req, resp);
        }else {
            req.getRequestDispatcher(ConstantPage.LOGIN_PAGE).forward(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
