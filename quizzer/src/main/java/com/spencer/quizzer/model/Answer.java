package com.spencer.quizzer.model;

import java.io.Serializable;

/**
 * Created by Pete on 6/9/2014.
 */
public abstract class Answer  implements Serializable {
    private String questionId;

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }
}
