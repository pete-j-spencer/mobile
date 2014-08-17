package com.spencer.quizzer.model;

import com.spencer.quizzer.utility.QuestionAdapter;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Pete on 6/9/2014.
 */
public class Question  implements Serializable {

    private int questionNumber;
    private List<Prompt> prompts;
    private Answer correctAnswer;


    @Override
    public String toString() {
        return "Question{" +

                "prompts=" + prompts +
                ", correctAnswer=" + correctAnswer +
                '}';
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(int questionNumber) {
        this.questionNumber = questionNumber;
    }

    public List<Prompt> getPrompts() {
        return prompts;
    }

    public void setPrompts(List<Prompt> prompts) {
        this.prompts = prompts;
    }

    public Answer getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(Answer correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getDisplayText() {
        return "#" + getQuestionNumber() + ": " + QuestionAdapter.getFirstQuestionPrompt(this);
    }
}
