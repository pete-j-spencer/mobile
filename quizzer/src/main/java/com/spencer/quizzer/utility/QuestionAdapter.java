package com.spencer.quizzer.utility;

import com.spencer.quizzer.model.Prompt;
import com.spencer.quizzer.model.Question;
import com.spencer.quizzer.model.Quiz;
import com.spencer.quizzer.model.TextPrompt;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Pete on 6/9/2014.
 */
public class QuestionAdapter {

    public static ArrayList<String> getQuestionsFirstPrompt(Collection<Question> questions) {
        ArrayList<String> questionPrompts = new ArrayList<String>(questions.size());
        for(Question q : questions) {
            questionPrompts.add(getFirstQuestionPrompt(q));
        }
        return questionPrompts;
    }

    public static ArrayList<String> getQuestionsDisplayTextArray(Collection<Question> questions) {
        ArrayList<String> questionPrompts = new ArrayList<String>(questions.size());
        for(Question q : questions) {
            questionPrompts.add(q.getDisplayText());
        }
        return questionPrompts;
    }

    public static String getFirstQuestionPrompt(Question question) {
        if(null == question || null == question.getPrompts()) {
            return null;
        }
        return ((TextPrompt)question.getPrompts().get(0)).getText();
    }

    public static String getFirstTextPrompt(Question question) {
        if(null != question.getPrompts()) {
            for (Prompt p : question.getPrompts()) {
                if (p instanceof TextPrompt) {
                    return  ((TextPrompt) p).getText();
                }
            }
        }
        return null;
    }

    public static ArrayList<String> getPromptsDisplayTextArray(List<Prompt> promptList) {
        ArrayList<String> promptsDisplayText = new ArrayList<String>(promptList.size());
        for(Prompt p : promptList) {
            promptsDisplayText.add(p.getPromptDisplayText());
        }
        return promptsDisplayText;
    }
}
