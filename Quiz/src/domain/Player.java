package domain;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Player {
    int rid;
    String username;
    String qid;
    String catagory;
    String question;
    int answer;
    protected int no_of_correct_question;
    protected String created_at;

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getqid() {
        return qid;
    }

    public void setqid(String qid) {
        this.qid = qid;
    }

    public String getCatagory() {
        return catagory;
    }

    public void setCatagory(String catagory) {
        this.catagory = catagory;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public int getNo_of_correct_question() {
        return no_of_correct_question;
    }

    public void setNo_of_correct_question(int no_of_correct_question) {
        this.no_of_correct_question = no_of_correct_question;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        SimpleDateFormat date_format = new SimpleDateFormat (" yyyy-MM-dd hh:mm:ss");
        this.created_at = date_format.format(created_at);
    }
}
