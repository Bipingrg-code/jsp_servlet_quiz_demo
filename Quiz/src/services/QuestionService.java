package services;

import domain.Quiz;
import utils.DatabaseConnection;
import java.sql.*;
import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

public class QuestionService {
    public void createquestion(Quiz quiz){
        String query = "INSERT INTO quiz( question, catagory, option1, option2, option3, option4, correctanswer) VALUES(?,?,?,?,?,?,?) ";
        DatabaseConnection db = new DatabaseConnection();
        PreparedStatement pstm = db.getPreparedStatement(query);
        try{
            pstm.setString(1,quiz.getQuestion());
            pstm.setString(2,quiz.getCategory());
            pstm.setString(3,quiz.getOption1());
            pstm.setString(4,quiz.getOption2());
            pstm.setString(5,quiz.getOption3());
            pstm.setString(6,quiz.getOption4());
            pstm.setInt(7,quiz.getCorrectanswer());
            pstm.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Quiz getQuiz(int qid) {
        Quiz quiz = new Quiz();
        String query = "select * from quiz where qid=?";

        DatabaseConnection db = new DatabaseConnection();
        PreparedStatement pstm = db.getPreparedStatement(query);

        try {
            pstm.setInt(1, qid);

            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                // quiz = new Quiz();
                quiz.setQid(rs.getInt("qid"));
                quiz.setQuestion(rs.getString("question"));
                quiz.setCategory(rs.getString("catagory"));
                quiz.setOption1(rs.getString("option1"));
                quiz.setOption2(rs.getString("option2"));
                quiz.setOption3(rs.getString("option3"));
                quiz.setOption4(rs.getString("option4"));
                quiz.setCorrectanswer(rs.getInt("correctanswer"));
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }

        return quiz;
    }

    public List<Quiz> getQuizList(){
        List<Quiz> quizList = new ArrayList<>();
        String query = "select * from quiz";

        DatabaseConnection db = new DatabaseConnection();
        PreparedStatement pstm = db.getPreparedStatement(query);

        try {

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                Quiz quiz = new Quiz();
                quiz.setQid(rs.getInt("qid"));
                quiz.setQuestion(rs.getString("question"));
                quiz.setCategory(rs.getString("catagory"));
                quiz.setOption1(rs.getString("option1"));
                quiz.setOption2(rs.getString("option2"));
                quiz.setOption3(rs.getString("option3"));
                quiz.setOption4(rs.getString("option4"));
                quiz.setCorrectanswer(rs.getInt("correctanswer"));

                quizList.add(quiz);
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }
        return quizList;
    }
    public void updatequestion(Quiz quiz){
        String query = "update quiz set question=?, catagory=?, option1=?, option2=?, option3=?, option4=?, correctanswer=? where qid=?";
        DatabaseConnection db = new DatabaseConnection();
        PreparedStatement pstm = db.getPreparedStatement(query);
        try{
            pstm.setString(1,quiz.getQuestion());
            pstm.setString(2,quiz.getCategory());
            pstm.setString(3,quiz.getOption1());
            pstm.setString(4,quiz.getOption2());
            pstm.setString(5,quiz.getOption3());
            pstm.setString(6,quiz.getOption4());
            pstm.setInt(7,quiz.getCorrectanswer());
            pstm.setInt(8,quiz.getQid());
            pstm.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void deletequestion(int qid){
        String query = "delete  FROM quiz WHERE qid=?";
        DatabaseConnection db = new DatabaseConnection();
        PreparedStatement pstm = db.getPreparedStatement(query);
        try {
            pstm.setInt(1,qid);
            pstm.execute();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}


