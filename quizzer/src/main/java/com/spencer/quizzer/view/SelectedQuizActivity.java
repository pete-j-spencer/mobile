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
import android.widget.TextView;

import com.spencer.quizzer.model.Attempt;
import com.spencer.quizzer.model.Quiz;
import com.spencer.quizzer.utility.QuestionAdapter;
import com.spencer.quizzer.view.R;

import java.util.ArrayList;

public class SelectedQuizActivity extends Activity {

    private ArrayList<Quiz> quizList;
    private Quiz selectedQuiz;


    private TextView qName;
    private TextView qDescription;
    private TextView qAuthor;

    private ArrayAdapter arrayAdapter;
    private ListView qQuestionsListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_quiz);
        Intent intent = getIntent();
        quizList = (ArrayList<Quiz>) intent.getSerializableExtra("quizList");
        selectedQuiz = (Quiz) intent.getSerializableExtra("selectedQuiz");

        if(null != selectedQuiz) {
            qName = (TextView) findViewById(R.id.qName);
            qDescription = (TextView) findViewById(R.id.qDescription);
            qAuthor = (TextView) findViewById(R.id.qAuthor);

            qName.setText(selectedQuiz.getQuizName());
            qDescription.setText(selectedQuiz.getQuizDescription());
            qAuthor.setText(selectedQuiz.getAuthor());

            ArrayList<String> questionArray = QuestionAdapter.getQuestionsDisplayTextArray(selectedQuiz.getQuestionMap().values());
            arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, questionArray);
            qQuestionsListView = (ListView)findViewById(R.id.qQuestionsListView);
            qQuestionsListView.setAdapter(arrayAdapter);
            qQuestionsListView.setClickable(false);
        }



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.selected_quiz, menu);
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

    public void editSelectedQuiz(View view) {
        quizList.remove(selectedQuiz);
        Intent intent = new Intent(this, CreateQuizActivity.class);
        intent.putExtra("quizList", quizList);
        intent.putExtra("newQuiz", selectedQuiz);
        startActivity(intent);
    }

    public void takeTheQuiz(View view) {
        if(null == selectedQuiz.getAttemptList()) {
            selectedQuiz.setAttemptList(new ArrayList<Attempt>());
        }
        Intent intent = new Intent(this, AnswerQuestionActivity.class);
        intent.putExtra("quizList", quizList);
        intent.putExtra("selectedQuiz", selectedQuiz);
        intent.putExtra("currentQuestionNumber", 0);
        startActivity(intent);
    }
}
