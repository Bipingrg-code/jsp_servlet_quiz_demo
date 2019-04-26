package services;

import domain.Player;
import domain.Quiz;
import utils.DatabaseConnection;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class PlayService {

    public void insertanswer(Player player){

     String query ="INSERT INTO result ( username, qid,catagory, answer,no_of_correct_question, created_at) VALUES (?,?,?,?,?,?)";
        DatabaseConnection db = new DatabaseConnection();
        PreparedStatement pstm = db.getPreparedStatement(query);
        try{
            pstm.setString(1,player.getUsername());
            pstm.setString(2,player.getqid());
            pstm.setString(3,player.getCatagory());
            pstm.setInt(4,player.getAnswer());
            pstm.setInt(5,player.getNo_of_correct_question());
            pstm.setString(6,player.getCreated_at());
            pstm.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<Player> getcatList(){
        List <Player> catList = new ArrayList<>();
        String query = "select DISTINCT catagory from quiz ";
        DatabaseConnection db = new DatabaseConnection();
        PreparedStatement pstm = db.getPreparedStatement(query);
        try{

            ResultSet rs = pstm.executeQuery();
           // ArrayList<Player> catList = new ArrayList<>();
            while (rs.next()){
                Player player = new Player();
                player.setCatagory(rs.getString("catagory"));
                catList.add(player);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return catList;
    }



    public List<Player> getResultList(String username){
        List<Player> resultList = new ArrayList<>();
       // String query = "select result.question,result.answer from result join quiz on result.question=quiz.question";
        String query = "select *  from result where username=?";

        DatabaseConnection db = new DatabaseConnection();
        PreparedStatement pstm = db.getPreparedStatement(query);

        try {
            pstm.setString(1, username);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                Player player = new Player();
                player.setRid(rs.getInt("rid"));
                player.setUsername(rs.getString("username"));
                player.setqid(rs.getString("qid"));
                player.setCatagory(rs.getString("catagory"));
                player.setAnswer(rs.getInt("answer"));
                player.setNo_of_correct_question(rs.getInt("no_of_correct_question"));
                player.setCreated_at(rs.getTimestamp("Created_at"));


                resultList.add(player);
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    public List<Quiz> getQuestionlist(String category) {
        List<Quiz> questionList = new ArrayList<>();

        String query = "select * from quiz where catagory=?";

        DatabaseConnection db = new DatabaseConnection();
        PreparedStatement pstm = db.getPreparedStatement(query);

        int no_of_ques = 0;



        try {
            pstm.setString(1, category);
            ResultSet rs = pstm.executeQuery();

            if (rs.last()) {
                no_of_ques = rs.getRow();
                rs.beforeFirst();
            }

            ArrayList<Integer> numbers = new ArrayList<>();
            for (int i = 0; i < no_of_ques; i++) {
                numbers.add(i + 1);
            }
            Collections.shuffle(numbers);

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

                questionList.add(quiz);
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }

        return questionList;
    }
}
