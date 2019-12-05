package edu.utep.cs.cs4330.finalproject.Model;

public class Score {
    public String id;
    public int rank;
    public String name;
    public int score;

    public Score(String id, int rank, String name, int score){
        this.id = id;
        this.rank = rank;
        this.name = name;
        this.score = score;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

}
