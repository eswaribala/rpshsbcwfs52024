package com.hsbc.models;

public class Answer {
    private int answerId;
    private String answerText;

    public Answer() {
    }

    public Answer(int answerId, String answerText) {
        this.answerId = answerId;
        this.answerText = answerText;
    }

    public int getAnswerId() {
        return answerId;
    }

    public String getAnswerText() {
        return answerText;
    }
}
