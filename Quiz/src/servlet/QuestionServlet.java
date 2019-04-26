package servlet;

import domain.Quiz;
import services.QuestionService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "QuestionServlet")
public class QuestionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageRequest = request.getParameter("pageRequest");
        if(pageRequest.equals("questionlist")){
            RequestDispatcher rd = request.getRequestDispatcher("question/questionlist.jsp");
            display(request,response);
            //rd.forward(request,response);
        }

        if(pageRequest.equals("create")){
            //System.out.println("this is test for createquestion");
            RequestDispatcher rd = request.getRequestDispatcher("question/createQuestion.jsp");
            rd.forward(request,response);
        }
        if(pageRequest.equals("createQuestion")){
            String question = request.getParameter("question");
            String category = request.getParameter("category");
            String option1 = request.getParameter("option1");
            String option2 = request.getParameter("option2");
            String option3 = request.getParameter("option3");
            String option4 = request.getParameter("option4");
            int correctanswer = Integer.parseInt(request.getParameter("correctanswer"));
            QuestionService service = new QuestionService();
            Quiz quiz = new Quiz();
            quiz.setQuestion(question);
            quiz.setCategory(category);
            quiz.setOption1(option1);
            quiz.setOption2(option2);
            quiz.setOption3(option3);
            quiz.setOption4(option4);
            quiz.setCorrectanswer(correctanswer);
            service.createquestion(quiz);
            display(request,response);
        }
        if(pageRequest.equals("update")){
            int qid = Integer.parseInt(request.getParameter("quizId"));
            Quiz quiz = new QuestionService().getQuiz(qid);
            request.setAttribute("quiz",quiz);
            RequestDispatcher rd = request.getRequestDispatcher("question/updatequestion.jsp");
            rd.forward(request,response);
        }
        if(pageRequest.equals("updatequestion")){
            String question = request.getParameter("question");
            String category = request.getParameter("category");
            String option1 = request.getParameter("option1");
            String option2 = request.getParameter("option2");
            String option3 = request.getParameter("option3");
            String option4 = request.getParameter("option4");
            int correctanswer = Integer.parseInt(request.getParameter("correctanswer"));
            int id = Integer.parseInt(request.getParameter("quizId"));
            QuestionService service = new QuestionService();
            Quiz quiz = new Quiz();
            quiz.setQuestion(question);
            quiz.setCategory(category);
            quiz.setOption1(option1);
            quiz.setOption2(option2);
            quiz.setOption3(option3);
            quiz.setOption4(option4);
            quiz.setCorrectanswer(correctanswer);
            quiz.setQid(id);
            service.updatequestion(quiz);
            display(request,response);
        }
        if(pageRequest.equals("deletequestion")) {
            int qid = Integer.valueOf(request.getParameter("quizId"));
            QuestionService service = new QuestionService();
            service.deletequestion(qid);
            display(request, response);
        }

    }protected void display(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QuestionService service = new QuestionService();
        List<Quiz> quizList = service.getQuizList();
        request.setAttribute("quizList", quizList);
        RequestDispatcher rd = request.getRequestDispatcher("question/questionlist.jsp");
        rd.forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
