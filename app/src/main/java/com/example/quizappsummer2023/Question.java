package com.example.quizappsummer2023;

public class Question {
    private String qPrompt;
    private Boolean correctAnswer;
    private String picture;


    public Question(String qPrompt, Boolean correctAnswer, String picture) {
        this.qPrompt = qPrompt;
        this.correctAnswer = correctAnswer;
        this.picture = picture;
    }

    public void setqPrompt(String qPrompt) {
        this.qPrompt = qPrompt;
    }

    public void setCorrectAnswer(Boolean correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getqPrompt() {
        return qPrompt;
    }

    public Boolean getCorrectAnswer() {
        return correctAnswer;
    }


    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }


    @Override
    public String toString() {
        return "Question{" +
                "qPrompt='" + qPrompt + '\'' +
                ", correctAnswer=" + correctAnswer +
                '}';
    }


}
