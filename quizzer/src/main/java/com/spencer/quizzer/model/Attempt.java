package com.spencer.quizzer.model;

import org.joda.time.LocalDateTime;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by Pete on 6/9/2014.
 */
public class Attempt implements Serializable {

    private String quizId;
    private LocalDateTime attemptBegan;
    private LocalDateTime attemptFinished;
    String testerName;
    Map<String, Answer> answers;
    Integer numberCorrect;


    @Override
    public String toString() {
        return "Attempt{" +
                "quizId='" + quizId + '\'' +
                ", attemptBegan=" + attemptBegan +
                ", attemptFinished=" + attemptFinished +
                ", testerName='" + testerName + '\'' +
                ", answers=" + answers +
                ", numberCorrect=" + numberCorrect +
                '}';
    }

    public String getQuizId() {

        return quizId;
    }

    public void setQuizId(String quizId) {
        this.quizId = quizId;
    }

    public LocalDateTime getAttemptBegan() {
        return attemptBegan;
    }

    public void setAttemptBegan(LocalDateTime attemptBegan) {
        this.attemptBegan = attemptBegan;
    }

    public LocalDateTime getAttemptFinished() {
        return attemptFinished;
    }

    public void setAttemptFinished(LocalDateTime attemptFinished) {
        this.attemptFinished = attemptFinished;
    }

    public String getTesterName() {
        return testerName;
    }

    public void setTesterName(String testerName) {
        this.testerName = testerName;
    }

    public Map<String, Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(Map<String, Answer> answers) {
        this.answers = answers;
    }

    public Integer getNumberCorrect() {
        return numberCorrect;
    }

    public void setNumberCorrect(Integer numberCorrect) {
        this.numberCorrect = numberCorrect;
    }
}
