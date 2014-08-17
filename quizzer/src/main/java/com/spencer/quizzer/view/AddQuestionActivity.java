package com.spencer.quizzer.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.spencer.quizzer.model.Prompt;
import com.spencer.quizzer.model.Question;
import com.spencer.quizzer.model.Quiz;
import com.spencer.quizzer.model.TextAnswer;
import com.spencer.quizzer.utility.QuestionAdapter;
import com.spencer.quizzer.utility.QuizlistAdapter;

import java.util.ArrayList;


public class AddQuestionActivity extends Activity {
    private ArrayList<Quiz> quizList;
    private Quiz newQuiz;
    private Question newQuestion;


    private ListView promptListView;
    private ArrayAdapter arrayAdapter;
    private TextView correctAnswer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_question);

        promptListView = (ListView)findViewById(R.id.addQuestionPromptList);
        promptListView = (ListView)findViewById(R.id.addQuestionPromptList);

        Intent intent = getIntent();
        quizList = (ArrayList<Quiz>) intent.getSerializableExtra("quizList");
        newQuiz = (Quiz) intent.getSerializableExtra("newQuiz");
        newQuestion = (Question) intent.getSerializableExtra("newQuestion");
        if(null == newQuestion) {
            newQuestion = new Question();
            newQuestion.setQuestionNumber(newQuiz.getQuestionMap().size()+1);
            newQuestion.setPrompts(new ArrayList<Prompt>());
        }

        else  {
            if(null != newQuestion.getCorrectAnswer()) {
                correctAnswer = (TextView) findViewById(R.id.addQuestionAnswer);
                correctAnswer.setText(((TextAnswer) newQuestion.getCorrectAnswer()).getAnswerText());
            }
            if(null != newQuestion.getPrompts() && !newQuestion.getPrompts().isEmpty()) {

                ArrayList<String> promptsDisplayTextArray = (ArrayList) QuestionAdapter.getPromptsDisplayTextArray(newQuestion.getPrompts());

                arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, promptsDisplayTextArray);
                promptListView.setAdapter(arrayAdapter);
            }
        }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.add_prompt, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void addAnswer(View view) {
        Intent intent = new Intent(this, AddTextAnswerActivity.class);
        intent.putExtra("quizList", quizList);
        intent.putExtra("newQuiz", newQuiz);
        intent.putExtra("newQuestion", newQuestion);
        startActivity(intent);
    }

    public void saveNewQuestion(View view) {
        newQuiz.getQuestionMap().put(newQuestion.getQuestionNumber(), newQuestion);

        Intent intent = new Intent(this, CreateQuizActivity.class);
        intent.putExtra("quizList", quizList);
        intent.putExtra("newQuiz", newQuiz);
        startActivity(intent);
    }

    public void addPrompt(View view) {
        Intent intent = new Intent(this, AddTextPromptActivity.class);
        intent.putExtra("quizList", quizList);
        intent.putExtra("newQuiz", newQuiz);
        intent.putExtra("newQuestion", newQuestion);
        startActivity(intent);
    }
}
