package com.spark.cong.ic3spark;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    FrameLayout fl_lythuyet,fl_onthi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fl_lythuyet=(FrameLayout) findViewById(R.id.frameLayout_LyThuyet);
        fl_onthi=(FrameLayout)findViewById(R.id.frameLayout_Onthi);

        fl_lythuyet.setOnClickListener(mOnclickListener);
        fl_onthi.setOnClickListener(mOnclickListener);
    }
    View.OnClickListener mOnclickListener= new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(getApplicationContext(),"ok",Toast.LENGTH_SHORT).show();
        }
    };

}
