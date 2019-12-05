package edu.utep.cs.cs4330.finalproject.Model;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Class created to retrieve all item information to implement MVC
 */
public class ScoreModel {
    private Database db;

    public ScoreModel(Context context){
        this.db = new Database(context);
    }

    public void addScore(Score score){
        this.db.insertData(score);
    }

    public Cursor getScores(){
        return db.getAll();
    }

    public void removeItem(Score score) {
        this.db.deleteData(score.id);
    }

}
