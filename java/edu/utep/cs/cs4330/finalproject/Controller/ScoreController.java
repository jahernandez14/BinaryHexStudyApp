package edu.utep.cs.cs4330.finalproject.Controller;

import android.database.Cursor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import edu.utep.cs.cs4330.finalproject.Model.Score;
import edu.utep.cs.cs4330.finalproject.Model.ScoreModel;
import edu.utep.cs.cs4330.finalproject.View.Leaderboard;


public class ScoreController {
    private ScoreModel model;
    private Leaderboard view;


    public ScoreController(ScoreModel model, Leaderboard view){
        this.model = model;
        this.view = view;
    }

    public ScoreController(ScoreModel model){
        this.model = model;
    }


    public void addScore(Score score){
        model.addScore(score);
        updateView();
    }

    public void newScore(Score score){
        model.addScore(score);
    }


    public void removeScore(Score score){
        model.removeItem(score);
        updateView();
    }

    public void updateView(){
        view.clearItems();
        ArrayList<Score> list = new ArrayList<Score>();
        Cursor cursor = model.getScores();
        while (cursor.moveToNext()){
            Score score = new Score(cursor.getString(0), cursor.getInt(1), cursor.getString(2),cursor.getInt(3));
            list.add(score);
        }
        cursor.close();

        Collections.sort(list, new Comparator<Score>() {
            @Override
            public int compare(Score s1, Score s2) {
                return Integer.valueOf(s2.score).compareTo(s1.score);
            }
        });
        for( int i = 1; i < 9; i++) {
            view.displayScore(list.get(i).getId(), i, list.get(i).getName(), list.get(i).getScore());
        }
    }
}
