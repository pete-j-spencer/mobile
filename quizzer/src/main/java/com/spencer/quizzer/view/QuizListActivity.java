package com.spencer.quizzer.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.spencer.quizzer.model.Quiz;
import com.spencer.quizzer.utility.QuizlistAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pete on 6/9/2014.
 */
public class QuizListActivity extends Activity {

    private ListView quizListView;

    private ArrayAdapter arrayAdapter;

    private ArrayList<Quiz> quizList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_list);

        quizListView = (ListView)findViewById(R.id.quizList_ListView);
        quizListView.setClickable(true);
        quizListView.setOnItemClickListener(getQuizClickedListener());



        Intent intent = getIntent();
        quizList = (ArrayList<Quiz>) intent.getSerializableExtra("quizList");

        ArrayList<String> quizNames = (ArrayList)QuizlistAdapter.getQuizNames(quizList);

        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, quizNames);

        quizListView.setAdapter(arrayAdapter);

    }

    private AdapterView.OnItemClickListener getQuizClickedListener() {
        return new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Quiz selectedQuiz = quizList.get(position);

                Intent intent = new Intent(parent.getContext(), SelectedQuizActivity.class);
                intent.putExtra("quizList", quizList);
                intent.putExtra("selectedQuiz", selectedQuiz);
                startActivity(intent);
            }
        };
    }

    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        return super.onCreateView(name, context, attrs);
    }

    public void createNewQuiz(View view) {
        Intent intent = new Intent(this, CreateQuizActivity.class);
        intent.putExtra("quizList",quizList);
        startActivity(intent);
    }
}
