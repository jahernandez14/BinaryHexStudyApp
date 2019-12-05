package edu.utep.cs.cs4330.finalproject.View;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;

import edu.utep.cs.cs4330.finalproject.Controller.ScoreController;
import edu.utep.cs.cs4330.finalproject.Model.Score;
import edu.utep.cs.cs4330.finalproject.R;

public class Difficulty extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.difficulty);

        ImageButton easy = findViewById(R.id.easy);
        easy.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Difficulty.this, Quiz.class);
                intent.putExtra("difficulty", 1);
                startActivity(intent);
            }
        });

        ImageButton medium = findViewById(R.id.medium);
        medium.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Difficulty.this, Quiz.class);
                intent.putExtra("difficulty", 2);
                startActivity(intent);
            }
        });

        ImageButton hard = findViewById(R.id.hard);
        hard.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Difficulty.this, Quiz.class);
                intent.putExtra("difficulty", 3);
                startActivity(intent);
            }
        });
    }
}
