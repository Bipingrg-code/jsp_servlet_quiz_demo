package servlet;

import domain.Quiz;
import domain.Player;
import services.PlayService;
import utils.DatabaseConnection;

import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "PlayServlet")
public class PlayServlet extends HttpServlet {

    int correct = 0;
    private int questionCounterTotal;
    private List<Quiz>questionList;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String pageRequest=request.getParameter("pageRequest");

        if(pageRequest.equals("quizcatagory")){

            PlayService service = new PlayService();
            List<Player> catList = service.getcatList();
            request.setAttribute("catList", catList);
            RequestDispatcher rd = request.getRequestDispatcher("playquiz/quizcatagory.jsp");
            rd.forward(request,response);

        }
        if(pageRequest.equals("play")){
            RequestDispatcher rd = request.getRequestDispatcher("playquiz/playquiz.jsp");
            display(request,response);

        }

        if(pageRequest.equals("check")){
            HttpSession session=request.getSession(false);
            String username = session.getAttribute("username").toString();
            String category = session.getAttribute("category").toString();
            System.out.println("im test"+username+category);

            try {
                for(int i = 1; i <= questionCounterTotal; i++) {
                    String qid = request.getParameter("select+" + i + "qid");
                    int option =Integer.parseInt( request.getParameter("select+" + i + "option"));


                    //String created_at = request.getParameter("created_at");
                    System.out.println(qid + "-->" + option);

                    PlayService service = new PlayService();
                    Player player = new Player();
                    String query = "select correctanswer from quiz where qid='" + qid + "'";
                    DatabaseConnection db = new DatabaseConnection();
                    PreparedStatement pstm = db.getPreparedStatement(query);
                    java.util.Date date= new java.util.Date();
                    java.sql.Date sqlDate= new java.sql.Date(date.getTime());
                    System.out.println(query);


                        ResultSet rs = pstm.executeQuery();
                        if (rs.next()) {
                            request.setAttribute("select+" + "option", option);
                            request.setAttribute("select+" + "qid", qid);
                            request.setAttribute("select+" + "correctanswer", rs.getInt(1));
                            if (option == rs.getInt(1)) {
                                correct++;
                                request.setAttribute("select" + i + "correctanswer", "true");
                            } else {
                                request.setAttribute("select" + i + "correctanswer", "false");
                            }
                        }


                    player.setqid(qid);
                    player.setAnswer(option);
                    player.setUsername(username);
                    player.setCatagory(category);
                    player.setNo_of_correct_question(correct);
                    player.setCreated_at(sqlDate);
                    service.insertanswer(player);
                    }



                    } catch (SQLException e) {
                        e.printStackTrace();
                    }


            resultplay(request, response);


        }

    }
    protected void display(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        String category = request.getParameter("cat");
        session.setAttribute("category",category);
        request.setAttribute("category", category);
         if(category!=null) {
             PlayService service = new PlayService();
             List<Quiz> quizList = service.getQuestionlist(category);
             request.setAttribute("quizList", quizList);
             questionList = service.getQuestionlist(category);
             questionCounterTotal = questionList.size();
             request.setAttribute("question_counter", questionCounterTotal);
             RequestDispatcher rd = request.getRequestDispatcher("playquiz/playquiz.jsp");
             rd.forward(request, response);
         }else{
             PlayService service = new PlayService();
             List<Player> catList = service.getcatList();
             request.setAttribute("catList", catList);
             RequestDispatcher rd = request.getRequestDispatcher("playquiz/quizcatagory.jsp");
             rd.forward(request,response);
         }

    }

    protected void resultplay(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        String username = session.getAttribute("username").toString();
        PlayService service = new PlayService();
        List<Player> resultList = service.getResultList(username);
        request.setAttribute("resultList", resultList);
        RequestDispatcher rd = request.getRequestDispatcher("playquiz/resultquiz.jsp");
        rd.forward(request,response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
