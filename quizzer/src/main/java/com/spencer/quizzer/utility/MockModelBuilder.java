package com.spencer.quizzer.utility;

import com.spencer.quizzer.model.Answer;
import com.spencer.quizzer.model.Attempt;
import com.spencer.quizzer.model.Prompt;
import com.spencer.quizzer.model.Question;
import com.spencer.quizzer.model.Quiz;
import com.spencer.quizzer.model.TextAnswer;
import com.spencer.quizzer.model.TextPrompt;

import org.joda.time.LocalDateTime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Pete on 6/9/2014.
 */
public  class MockModelBuilder {

    public static Quiz buildQuiz() {
        Quiz quiz = new Quiz();
        quiz.setQuizName("Common Colors");
        quiz.setAuthor("Pete");
        quiz.setCreatedTimestamp(LocalDateTime.now());
        quiz.setAttemptList(new ArrayList<Attempt>());
        quiz.setQuestionMap(new HashMap<Integer, Question>());
        quiz.setQuizDescription("Silly quiz about the colors of common objects.");

        quiz.getQuestionMap().putAll(createQuestions());

        quiz.getAttemptList().add(buildAttempt());

        return quiz;
    }

    private static Map<? extends Integer, ? extends Question> createQuestions() {
        HashMap<Integer, Question> qs = new HashMap<Integer, Question>();


        Question q1 = new Question();
        q1.setQuestionNumber(1);
        q1.setPrompts(new ArrayList<Prompt>());
        q1.getPrompts().add(new TextPrompt("What Color is an apple?"));
        q1.getPrompts().add(new TextPrompt("(type your answer in the block below and click 'save')."));
        q1.setCorrectAnswer(new TextAnswer("red", false));


        Question q2 = new Question();
        q2.setQuestionNumber(2);
        q2.setPrompts(new ArrayList<Prompt>());
        q2.getPrompts().add(new TextPrompt("What Color is the sky?"));
        q2.getPrompts().add(new TextPrompt("(type your answer in the block below and click 'save')."));
        q2.setCorrectAnswer(new TextAnswer( "blue", false));

        qs.put(1, q1);
        qs.put(2, q2);

        return qs;
    }


    public static Attempt buildAttempt() {
        Attempt a = new Attempt();

        a.setAnswers(new HashMap<String, Answer>());
        a.setAttemptBegan(LocalDateTime.now().minusHours(1));
        a.setAttemptFinished(LocalDateTime.now());
        a.setQuizId("quiz1");
        a.setTesterName("Pete");
        a.getAnswers().put("q1", new TextAnswer("red", false));
        a.getAnswers().put("q2", new TextAnswer("blue", false));
        return a;
    }


}
