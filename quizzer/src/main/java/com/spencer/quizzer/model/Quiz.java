package com.spencer.quizzer.model;

import org.joda.time.LocalDateTime;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by Pete on 6/9/2014.
 */
public class Quiz implements Serializable {


    private String quizName;
    private String quizDescription;
    private String author;
    private LocalDateTime createdTimestamp = LocalDateTime.now();
    private Map<Integer, Question> questionMap;
    private List<Attempt> attemptList;

    @Override
    public String toString() {
        return "Quiz{" +
                "quizName='" + quizName + '\'' +
                ", quizDescription='" + quizDescription + '\'' +
                ", author='" + author + '\'' +
                ", createdTimestamp=" + createdTimestamp +
                ", questionMap=" + questionMap +
                ", attemptList=" + attemptList +
                '}';
    }

    public String getQuizName() {
        return quizName;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }

    public String getQuizDescription() {
        return quizDescription;
    }

    public void setQuizDescription(String quizDescription) {
        this.quizDescription = quizDescription;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDateTime getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(LocalDateTime createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    public Map<Integer, Question> getQuestionMap() {
        return questionMap;
    }

    public void setQuestionMap(Map<Integer, Question> questionMap) {
        this.questionMap = questionMap;
    }

    public List<Attempt> getAttemptList() {
        return attemptList;
    }

    public void setAttemptList(List<Attempt> attemptList) {
        this.attemptList = attemptList;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }
        else if(!(o instanceof  Quiz)) {
            return false;
        }
        else {
            Quiz other = (Quiz)o;
            return ((null == getAuthor() && null == other.getAuthor()) || getAuthor().equals(other.getAuthor()))
                    && ((null == getQuizDescription() && null == other.getQuizDescription()) || getQuizDescription().equals(other.getQuizDescription()))
                    && ((null == getQuizName() && null == other.getQuizName()) || getQuizName().equals(other.getQuizName()))
                    && getCreatedTimestamp().equals(other.getCreatedTimestamp());
        }
    }
}
