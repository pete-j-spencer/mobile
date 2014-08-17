package com.spencer.quizzer.model;

import java.io.Serializable;

/**
 * Created by Pete on 6/9/2014.
 */
public class TextAnswer extends Answer  implements Serializable {

    private String answerText;
    boolean caseSensitive = false;

    public TextAnswer( String answerText, boolean caseSensitive) {
        this.answerText = answerText;
        this.caseSensitive = caseSensitive;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public boolean isCaseSensitive() {
        return caseSensitive;
    }

    public void setCaseSensitive(boolean caseSensitive) {
        this.caseSensitive = caseSensitive;
    }

    @Override
    public String toString() {
        return "TextAnswer{" +
                "answerText='" + answerText + '\'' +
                ", caseSensitive=" + caseSensitive +
                '}';
    }
}
