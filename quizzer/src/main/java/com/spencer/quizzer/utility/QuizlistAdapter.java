package com.spencer.quizzer.utility;

import com.spencer.quizzer.model.Question;
import com.spencer.quizzer.model.Quiz;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pete on 6/9/2014.
 */
public class QuizlistAdapter {

    public static List<String> getQuizNames(List<Quiz> quizzes) {
        ArrayList<String> qNames = new ArrayList<String>(quizzes.size());
        for(Quiz q : quizzes) {
            qNames.add(q.getQuizName());
        }
        return qNames;
    }


}
