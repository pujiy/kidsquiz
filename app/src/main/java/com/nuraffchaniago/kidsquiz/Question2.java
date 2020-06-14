package com.nuraffchaniago.kidsquiz;

public class Question2 {

    private String question2;
    private String questionImage;
    private String questionSound;
    private String Option1;
    private String Option2;
    private String Option3;
    private String Option4;
    private int answerNr;
    private int typeQuestion;
    private int typeAnswer;

    public Question2() {
    }

    public Question2(String question2, String questionImage, String questionSound, String option1, String option2, String option3, String option4, int answerNr, int typeQuestion, int typeAnswer) {
        this.question2 = question2;
        this.questionImage = questionImage;
        this.questionSound = questionSound;
        Option1 = option1;
        Option2 = option2;
        Option3 = option3;
        Option4 = option4;
        this.answerNr = answerNr;
        this.typeQuestion = typeQuestion;
        this.typeAnswer = typeAnswer;
    }

    public String getQuestion2() {
        return question2;
    }

    public void setQuestion2(String question2) {
        this.question2 = question2;
    }

    public String getQuestionImage() {
        return questionImage;
    }

    public void setQuestionImage(String questionImage) {
        this.questionImage = questionImage;
    }

    public String getQuestionSound() {
        return questionSound;
    }

    public void setQuestionSound(String questionSound) {
        this.questionSound = questionSound;
    }

    public String getOption1() {
        return Option1;
    }

    public void setOption1(String option1) {
        Option1 = option1;
    }

    public String getOption2() {
        return Option2;
    }

    public void setOption2(String option2) {
        Option2 = option2;
    }

    public String getOption3() {
        return Option3;
    }

    public void setOption3(String option3) {
        Option3 = option3;
    }

    public String getOption4() {
        return Option4;
    }

    public void setOption4(String option4) {
        Option4 = option4;
    }

    public int getAnswerNr() {
        return answerNr;
    }

    public void setAnswerNr(int answerNr) {
        this.answerNr = answerNr;
    }

    public int getTypeQuestion() {
        return typeQuestion;
    }

    public void setTypeQuestion(int typeQuestion) {
        this.typeQuestion = typeQuestion;
    }

    public int getTypeAnswer() {
        return typeAnswer;
    }

    public void setTypeAnswer(int typeAnswer) {
        this.typeAnswer = typeAnswer;
    }
}
