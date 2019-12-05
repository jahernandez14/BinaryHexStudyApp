package edu.utep.cs.cs4330.finalproject.View;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import edu.utep.cs.cs4330.finalproject.Controller.ScoreController;
import edu.utep.cs.cs4330.finalproject.Model.Score;
import edu.utep.cs.cs4330.finalproject.Model.ScoreModel;
import edu.utep.cs.cs4330.finalproject.R;

public class ScoreBoard extends AppCompatActivity {
    private TextView score, correct;
    private Button submit;
    private EditText input;
    private ImageButton exit, share;
    private ScoreController scoreController;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score_board);
        scoreController = new ScoreController(new ScoreModel(this));
        score = findViewById(R.id.score);
        correct = findViewById(R.id.correct);
        submit = findViewById(R.id.submit);
        input = findViewById(R.id.input);
        share = findViewById(R.id.share);
        exit = findViewById(R.id.exit);
        int difficulty = getIntent().getExtras().getInt("Difficulty");
        final int highScore = getIntent().getExtras().getInt("Score");
        int correctly = highScore/(difficulty*5);
        score.setText(Integer.toString(highScore));
        correct.setText(Integer.toString(correctly));
        exit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(ScoreBoard.this, MainActivity.class);
                finish();
                startActivity(intent);
            }
        });
        share.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "Beat this!\nMy mighty score is... " + highScore + "!!!");
                sendIntent.setType("text/plain");
                Intent shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(!input.getText().toString().equals("")) {
                    Score score = new Score("", 0, input.getText().toString(), highScore);
                    Log.d("Score info", score.name + "   " + score.score);
                    scoreController.newScore(score);
                    Toast.makeText(getBaseContext(), "High score has been recorded!!!", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getBaseContext(), "Please enter your name", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}