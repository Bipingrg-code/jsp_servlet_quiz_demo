package servlet;

import domain.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "sessionFilter")
public class sessionFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse) resp;

        String pageRequest = request.getParameter("pageRequest");

        HttpSession session = request.getSession(false);
        if(session==null){
            session = request.getSession(true);

        }
        User user = (User) session.getAttribute("user");

        if(pageRequest==null || user==null && !pageRequest.equals(("login"))){
            request.setAttribute("msg","Please Login");
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request,response);
        }
       chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
