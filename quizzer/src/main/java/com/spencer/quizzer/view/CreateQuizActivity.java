package com.spencer.quizzer.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.spencer.quizzer.model.Question;
import com.spencer.quizzer.model.Quiz;
import com.spencer.quizzer.utility.QuestionAdapter;
import com.spencer.quizzer.utility.QuizlistAdapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;


public class CreateQuizActivity extends Activity {

    private ArrayList<Quiz> quizList;
    private EditText qNameInput;
    private EditText qDescriptionInput;
    private EditText qAuthorInput;
    private Quiz newQuiz;


    private ArrayAdapter arrayAdapter;

    private ListView qQuestionsListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_quiz);
        Intent intent = getIntent();
        quizList = (ArrayList<Quiz>) intent.getSerializableExtra("quizList");




        qNameInput = (EditText)findViewById(R.id.qNameInput);
        qDescriptionInput = (EditText)findViewById(R.id.qDescriptionInput);
        qAuthorInput = (EditText)findViewById(R.id.qAuthorInput);

        newQuiz = (Quiz)intent.getSerializableExtra("newQuiz");
        if (null == newQuiz) {
            newQuiz = new Quiz();
            newQuiz.setQuestionMap(new HashMap<Integer, Question>());
        }
        else {

            Collection<Question> questions = newQuiz.getQuestionMap().values();

            qNameInput.setText(newQuiz.getQuizName());
            qDescriptionInput.setText(newQuiz.getQuizDescription());
            qAuthorInput.setText(newQuiz.getAuthor());

            ArrayList<String> questionArray = QuestionAdapter.getQuestionsDisplayTextArray(questions);
            arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, questionArray);
            qQuestionsListView = (ListView)findViewById(R.id.qQuestionsListView);
            qQuestionsListView.setAdapter(arrayAdapter);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.create_quiz, menu);
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

    public void saveNewQuiz(View view) {

        newQuiz.setQuizName(qNameInput.getText().toString());
        newQuiz.setQuizDescription(qDescriptionInput.getText().toString());
        newQuiz.setAuthor(qAuthorInput.getText().toString());

        quizList.add(newQuiz);

        Intent intent = new Intent(this, QuizListActivity.class);
        intent.putExtra("quizList", quizList);
        startActivity(intent);

    }

    public void addNewQuestion(View view) {
        if(null == newQuiz) {
            newQuiz = new Quiz();
        }
        newQuiz.setQuizName(qNameInput.getText().toString());
        newQuiz.setQuizDescription(qDescriptionInput.getText().toString());
        newQuiz.setAuthor(qAuthorInput.getText().toString());



        Intent intent = new Intent(this, AddQuestionActivity.class);
        intent.putExtra("quizList", quizList);
        intent.putExtra("newQuiz", newQuiz);
        startActivity(intent);
    }
}
