package com.spark.cong.ic3spark.models;

public class Score  {
    private int _id;
    private String name;
    private int score;
    private String date;

    public Score(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public int getId() {
        return _id;
    }

    public void setId(int id) {
        this._id = id;
    }

    public String getName() {
        return name;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
