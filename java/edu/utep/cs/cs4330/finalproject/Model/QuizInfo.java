package edu.utep.cs.cs4330.finalproject.Model;

import edu.utep.cs.cs4330.finalproject.View.Quiz;

public class QuizInfo {
    private String question;
    private String answer;
    private Boolean type;

    public QuizInfo(String question, String answer, Boolean type){
        this.answer = answer;
        this.question = question;
        this.type = type;
    }

    public QuizInfo(){
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }
}
