package com.spark.cong.ic3spark.activities;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


import com.spark.cong.ic3spark.R;
import com.spark.cong.ic3spark.fragments.ScoreFragment;
import com.spark.cong.ic3spark.models.DBHelper;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    ImageButton imgButton_lythuyet,imgButton_onthi,imgButton_Score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgButton_lythuyet=(ImageButton) findViewById(R.id.imageButton_LyThuyet);
        imgButton_onthi=(ImageButton)findViewById(R.id.imageButton_OnThi);
        imgButton_Score=(ImageButton)findViewById(R.id.imageButton_Score);

        imgButton_lythuyet.setOnClickListener(mLythuyetOnclickListener);
        imgButton_onthi.setOnClickListener(mOntapOnclickListener);
        imgButton_Score.setOnClickListener(mScoreOnclickListener);

        DBHelper db=new DBHelper(this);
        try {
            db.createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    View.OnClickListener mLythuyetOnclickListener= new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent intent_lythuyet=new Intent(MainActivity.this,LythuyetActivity.class);
            startActivityForResult(intent_lythuyet,123);
        }
    };

    View.OnClickListener mOntapOnclickListener= new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent intent_ontap=new Intent(MainActivity.this,ScreenSlidePagerActivity.class);
            startActivityForResult(intent_ontap,456);
        }
    };
    View.OnClickListener mScoreOnclickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ScoreFragment scoreFragment = new ScoreFragment();
            FragmentManager manager=getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.frameLayout_Score,scoreFragment,scoreFragment.getTag()).commit();
        }
    };

}
