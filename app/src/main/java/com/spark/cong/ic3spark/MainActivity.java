package com.spark.cong.ic3spark;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageButton imgButton_lythuyet,imgButton_onthi;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgButton_lythuyet=(ImageButton) findViewById(R.id.imageButton_LyThuyet);
        imgButton_onthi=(ImageButton)findViewById(R.id.imageButton_OnThi);
        button=(Button)findViewById(R.id.buttonok);
        button.setOnClickListener(mOnclickListener);
        imgButton_lythuyet.setOnClickListener(mOnclickListener);
        imgButton_onthi.setOnClickListener(mOnclickListener);
    }
    View.OnClickListener mOnclickListener= new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(getApplicationContext() ,"ok" ,Toast.LENGTH_SHORT).show();
        }
    };

}
