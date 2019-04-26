package servlet;

import domain.User;
import services.UserService;


import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class UserServlet extends javax.servlet.http.HttpServlet {

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        String pageRequest = request.getParameter("pageRequest");
        if (pageRequest.equals("login")) {


            String username = request.getParameter("username");
            String password = request.getParameter("password");

            UserService service = new UserService();
            User user = service.getUser(username, password);

            if (user!=null) {
                HttpSession session = request.getSession(false);
                session.setAttribute("user",user);
                session.setAttribute("username",username);
                //request.setAttribute("username",user.getUserName());
                request.setAttribute("msg","Login Successful!!");
                RequestDispatcher rd = request.getRequestDispatcher("user/home.jsp");
                rd.forward(request,response);
            }else{
                request.setAttribute("msg","Invalid Username or Password!!");

                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request,response);
            }

        }
        if (pageRequest.equals("logout")) {
            request.setAttribute("msg", "Logout Successful!!");
            HttpSession session = request.getSession(false);
            session.invalidate();
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request,response);
        }
        if (pageRequest.equals("home")) {
            //request.setAttribute("msg", "Logout Successful!!");
            RequestDispatcher rd = request.getRequestDispatcher("user/home.jsp");
            rd.forward(request,response);
        }
        if (pageRequest.equals("list")) {
            display(request,response);
            /*UserService service = new UserService();
            List<User> userList = service.getUserList();
            request.setAttribute("userList", userList);
            RequestDispatcher rd = request.getRequestDispatcher("user/list.jsp");
            rd.forward(request,response);*/
        }
        if(pageRequest.equals("create")){
           RequestDispatcher rd = request.getRequestDispatcher("user/createUser.jsp");
           rd.forward(request,response);
        }
         if(pageRequest.equals("CreateUser")){
             String username = request.getParameter("username");
             String password = request.getParameter("password");
             String roal = request.getParameter("roal");

             UserService service = new UserService();
             User user = new User();
             user.setUserName(username);
             user.setPassword(password);
             user.setRole(roal);
             service.createuser(user);
             display(request,response);
             /*List<User> userList = service.getUserList();
             request.setAttribute("userList", userList);
             RequestDispatcher rd = request.getRequestDispatcher("user/list.jsp");
             rd.forward(request,response);*/
             /*user.c*/
         }
         if(pageRequest.equals("update")){

             int userId = Integer.parseInt(request.getParameter("userId"));
             User user = new UserService().getUser(userId);
             request.setAttribute("user", user);
             RequestDispatcher rd = request.getRequestDispatcher("user/updateUser.jsp");
             rd.forward(request,response);
         }
        if(pageRequest.equals("UpdateUser")){
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String roal = request.getParameter("roal");
            int id = Integer.parseInt(request.getParameter("userId"));

            UserService service = new UserService();
            User user = new User();
            user.setUserName(username);
            user.setPassword(password);
            user.setRole(roal);
            user.setId(id);
            service.updateUser(user);
            display(request,response);
           /* List<User> userList = service.getUserList();
            request.setAttribute("userList", userList);
            RequestDispatcher rd = request.getRequestDispatcher("user/list.jsp");
            rd.forward(request,response);*/
        }
        if(pageRequest.equals("delete")){
             int id = Integer.valueOf(request.getParameter("userId"));
             UserService service = new UserService();
             service.deleteuser(id);
             display(request,response);
           /* List<User> userList = service.getUserList();
            request.setAttribute("userList", userList);
            RequestDispatcher rd = request.getRequestDispatcher("user/questionlist.jsp");
            rd.forward(request,response);
*/
        }

    }
    public void display(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)throws javax.servlet.ServletException, IOException{
         UserService service = new UserService();
         List<User> userList = service.getUserList();
         request.setAttribute("userList", userList);
         RequestDispatcher rd = request.getRequestDispatcher("user/list.jsp");
         rd.forward(request,response);
     }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request, response);
    }
}
