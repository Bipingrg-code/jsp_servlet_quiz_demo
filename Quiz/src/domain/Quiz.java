package domain;

public class Quiz {
    int qid;
    String question;
    String category;
    String option1;
    String option2;
    String option3;
    String option4;
    int correctanswer;

     public Quiz() {
         this.qid = 0;
         this.question = "";
         this.option1 = "";
         this.option2 = "";
         this.option3 = "";
         this.option4 = "";
         this.correctanswer= 0;
     }

    public int getQid() {
        return qid;
    }

    public void setQid(int qid) {
        this.qid = qid;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

   /* public int getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(int i) {
        questionNumber=i;
    }*/

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public int getCorrectanswer() {
        return correctanswer;
    }

    public void setCorrectanswer(int correctanswer) {
        this.correctanswer = correctanswer;
    }


}
