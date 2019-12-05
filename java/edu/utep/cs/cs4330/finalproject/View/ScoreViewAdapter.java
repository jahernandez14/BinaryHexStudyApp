package edu.utep.cs.cs4330.finalproject.View;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import edu.utep.cs.cs4330.finalproject.Model.Score;
import edu.utep.cs.cs4330.finalproject.R;

public class ScoreViewAdapter extends ArrayAdapter<Score> {

    private Context context;
    private ArrayList<Score> ScoreList = new ArrayList<>();

    ScoreViewAdapter(@NonNull Context context, int resource, ArrayList<Score> objects) {
        super(context, resource, objects);
        this.context = context;
        this.ScoreList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Score highScore = (Score) getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.player_layout, parent, false);
        }

        TextView name = convertView.findViewById(R.id.name);
        TextView rank = convertView.findViewById(R.id.rank);
        TextView score = convertView.findViewById(R.id.score);
        ImageView imageView = convertView.findViewById(R.id.img);

        name.setText(highScore.name);
        rank.setText(Integer.toString(highScore.rank));
        score.setText(Integer.toString(highScore.score));

        if(highScore.rank == 1){
            imageView.setImageResource(R.drawable.first);
        }
        if(highScore.rank == 2){
            imageView.setImageResource(R.drawable.second);
        }
        if(highScore.rank == 3){
            imageView.setImageResource(R.drawable.third);
        }

        return convertView;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }


}
