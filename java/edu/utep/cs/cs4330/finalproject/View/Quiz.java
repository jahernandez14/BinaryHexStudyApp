package edu.utep.cs.cs4330.finalproject.View;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import static edu.utep.cs.cs4330.finalproject.Controller.Test.*;
import androidx.appcompat.app.AppCompatActivity;

import edu.utep.cs.cs4330.finalproject.Controller.ScoreController;
import edu.utep.cs.cs4330.finalproject.Model.QuizInfo;
import edu.utep.cs.cs4330.finalproject.R;

public class Quiz extends AppCompatActivity {
    int difficulty;
    private TextView question, answer;
    private EditText input;
    private QuizInfo qInfo;
    private int count = 0;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_layout);
        question = findViewById(R.id.question);
        ImageButton next = findViewById(R.id.next);
        answer = findViewById(R.id.ans);
        input = findViewById(R.id.input);
        difficulty = getIntent().getExtras().getInt("difficulty");
        qInfo = questionGen(difficulty);
        question.setText(qInfo.getQuestion());
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((input.getText().toString()).equals("")) {
                    Toast.makeText(getBaseContext(), "Please enter a valid number", Toast.LENGTH_LONG).show();
                } else {
                    if ((input.getText().toString()).equals(qInfo.getAnswer())) {
                        answer.setText("Correct!!!");
                        count++;
                        score += 5 * difficulty;
                    } else {
                        answer.setText("Nope!!!");
                        count++;
                    }
                    InputMethodManager inputManager = (InputMethodManager)
                            getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                            InputMethodManager.HIDE_NOT_ALWAYS);

                }
                if (count == 3) {
                    Intent intent = new Intent(Quiz.this, ScoreBoard.class);
                    intent.putExtra("Score", score);
                    intent.putExtra("Difficulty", difficulty);
                    startActivity(intent);
                } else {
                    qInfo = questionGen(difficulty);
                    question.setText(qInfo.getQuestion());
                    input.setText("");
                }
            }
        });
    }
}
