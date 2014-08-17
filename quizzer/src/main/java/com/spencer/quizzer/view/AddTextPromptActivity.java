package com.spencer.quizzer.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import com.spencer.quizzer.model.Answer;
import com.spencer.quizzer.model.Prompt;
import com.spencer.quizzer.model.Question;
import com.spencer.quizzer.model.Quiz;
import com.spencer.quizzer.model.TextAnswer;
import com.spencer.quizzer.model.TextPrompt;

import java.util.ArrayList;


public class AddTextPromptActivity extends Activity {

    private ArrayList<Quiz> quizList;
    private Quiz newQuiz;
    private Question newQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_text_prompt);

        Intent intent = getIntent();
        quizList = (ArrayList<Quiz>) intent.getSerializableExtra("quizList");
        newQuiz = (Quiz) intent.getSerializableExtra("newQuiz");
        newQuestion = (Question) intent.getSerializableExtra("newQuestion");

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.add_text_prompt, menu);
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

    public void savePrompt(View view) {

        EditText prompt = (EditText) findViewById(R.id.addTextPromptEditText);
        Prompt textPrompt = new TextPrompt(prompt.getText().toString());
        newQuestion.getPrompts().add(textPrompt);


        Intent intent = new Intent(this, AddQuestionActivity.class);
        intent.putExtra("quizList", quizList);
        intent.putExtra("newQuiz", newQuiz);
        intent.putExtra("newQuestion", newQuestion);
        startActivity(intent);
    }
}
