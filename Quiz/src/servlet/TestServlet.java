package servlet;

import javax.servlet.RequestDispatcher;
import java.io.IOException;

public class TestServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {


        RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
        rd.forward(request,response);
    }
}
