package com.spencer.quizzer.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.spencer.quizzer.model.Answer;
import com.spencer.quizzer.model.Attempt;
import com.spencer.quizzer.model.Quiz;
import com.spencer.quizzer.model.TextAnswer;
import com.spencer.quizzer.model.TextPrompt;
import com.spencer.quizzer.utility.MockModelBuilder;

import org.joda.time.LocalDateTime;

import java.util.ArrayList;
import java.util.HashMap;


public class HomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
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

    public void startProgram(View view) {
        System.out.println("Starting now!");


        MockModelBuilder mmb = new MockModelBuilder();
        Quiz quiz = mmb.buildQuiz();

        ArrayList<Quiz> quizList = new ArrayList<Quiz>();
        quizList.add(quiz);

        Intent intent = new Intent(this, QuizListActivity.class);
        intent.putExtra("quizList",quizList);
        startActivity(intent);



    }

}
