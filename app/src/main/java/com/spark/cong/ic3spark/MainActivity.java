package com.spark.cong.ic3spark;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


import com.spark.cong.ic3spark.LyThuyet.LythuyetActivity;
import com.spark.cong.ic3spark.OnTap.OntapActivity;

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

        button.setOnClickListener(mLythuyetOnclickListener);
        imgButton_lythuyet.setOnClickListener(mLythuyetOnclickListener);
        imgButton_onthi.setOnClickListener(mOntapOnclickListener);
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

            Intent intent_ontap=new Intent(MainActivity.this,OntapActivity.class);
            startActivityForResult(intent_ontap,456);
        }
    };

}
