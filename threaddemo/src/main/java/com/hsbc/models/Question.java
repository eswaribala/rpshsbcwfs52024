package com.hsbc.models;

public class Question {
    private int questionNo;
    private String questionText;

    private Answer[] answers;

    public Question() {
    }

    public Question(int questionNo, String questionText, Answer[] answers) {
        this.questionNo = questionNo;
        this.questionText = questionText;
        this.answers = answers;
    }

    public int getQuestionNo() {
        return questionNo;
    }

    public String getQuestionText() {
        return questionText;
    }

    public Answer[] getAnswers() {
        return answers;
    }


}
