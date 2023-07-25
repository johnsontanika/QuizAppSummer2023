package com.example.quizappsummer2023;

public class Question {
    private String qPrompt;
    private Boolean correctAnswer;


    public Question(String qPrompt, Boolean correctAnswer) {
        this.qPrompt = qPrompt;
        this.correctAnswer = correctAnswer;
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

    @Override
    public String toString() {
        return "Question{" +
                "qPrompt='" + qPrompt + '\'' +
                ", correctAnswer=" + correctAnswer +
                '}';
    }
}
