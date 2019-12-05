package edu.utep.cs.cs4330.finalproject.View;

import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import edu.utep.cs.cs4330.finalproject.Controller.ScoreController;
import edu.utep.cs.cs4330.finalproject.Model.Score;
import edu.utep.cs.cs4330.finalproject.Model.ScoreModel;
import edu.utep.cs.cs4330.finalproject.R;

public class Leaderboard extends AppCompatActivity {
    private ScoreController scoreController;
    private ListView listView;
    private ScoreViewAdapter listViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.leader_board);
        scoreController = new ScoreController(new ScoreModel(this), this);
        listViewAdapter = new ScoreViewAdapter(this, android.R.layout.simple_list_item_1, new ArrayList<Score>());
        listView = findViewById(R.id.list);
        listView.setAdapter(listViewAdapter);

        scoreController.updateView();
    }

    public void displayScore(String id, int rank, String name, int score){
        listViewAdapter.add(new Score(id, rank, name, score));
        listViewAdapter.notifyDataSetChanged();
    }

    public void clearItems(){
        listViewAdapter.clear();
    }
}
