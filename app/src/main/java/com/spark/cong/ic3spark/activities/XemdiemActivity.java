package com.spark.cong.ic3spark.activities;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import com.spark.cong.ic3spark.R;
import com.spark.cong.ic3spark.adapters.ScoreAdapter;
import com.spark.cong.ic3spark.controllers.ScoreController;

public class XemdiemActivity extends AppCompatActivity {
    ListView lvScore;
    ScoreController scoreController;
    ScoreAdapter scoreAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_score);
        scoreController=new ScoreController(this);
        lvScore=(ListView)findViewById(R.id.lvScore);
        Cursor cursor=scoreController.getScore();
        scoreAdapter =new ScoreAdapter(this,cursor,true);
        lvScore.setAdapter(scoreAdapter);
    }
}
