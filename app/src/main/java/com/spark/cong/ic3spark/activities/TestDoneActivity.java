package com.spark.cong.ic3spark.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.spark.cong.ic3spark.R;
import com.spark.cong.ic3spark.controllers.ScoreController;
import com.spark.cong.ic3spark.models.Score;
import com.spark.cong.ic3spark.models.TracNghiem;

import java.util.ArrayList;

public class TestDoneActivity extends AppCompatActivity {
    ArrayList<TracNghiem>arr_QuesBegin = new ArrayList<TracNghiem>();
    int numNoAns=0;
    int numTrue=0;
    int numFale=0;
    int totalScore=0;

    ScoreController scoreController;

    TextView tvTrue,tvFalse,tvNotAns,tvTotalScore;
    Button btnHome,btnAgain,btnSaveScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_done);
        scoreController=new ScoreController(TestDoneActivity.this);

        Intent intent=getIntent();
        arr_QuesBegin= (ArrayList<TracNghiem>) intent.getExtras().getSerializable("arr_Ques");
        begin();
        checkResult();
        totalScore=numTrue*10;
        tvNotAns.setText(""+numNoAns);
        tvTrue.setText(""+numTrue);
        tvFalse.setText(""+numFale);
        tvTotalScore.setText(""+totalScore);

        btnSaveScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(TestDoneActivity.this);
                LayoutInflater inflater=TestDoneActivity.this.getLayoutInflater();
                View view = inflater.inflate(R.layout.alert_dialog_save_score,null);
                builder.setView(view);

                final EditText edtName = (EditText)view.findViewById(R.id.edtName);
                TextView tvScore=(TextView)view.findViewById(R.id.tvScore2);
                 final int numTotal= numTrue*100;
                 tvScore.setText(numTotal+" Điểm");
                 builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialog, int which) {
                         String name=edtName.getText().toString();
                         scoreController.insertScore(name,numTotal);
                         Toast.makeText( TestDoneActivity.this,"Lưu điểm thành công",Toast.LENGTH_SHORT).show();
                         finish();
                         dialog.dismiss();
                     }
                 });
                 builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialog, int which) {

                     }
                 });
                 AlertDialog b=builder.create();
                 b.show();
            }
        });

        btnAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(TestDoneActivity.this);
                builder.setIcon(R.drawable.ic_replay_black_24dp);
                builder.setTitle("Thông báo");
                builder.setMessage("Bạn có làm lại không?");
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                        Intent intent_ontap=new Intent(TestDoneActivity.this,ScreenSlidePagerActivity.class);
                        startActivity(intent_ontap);
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
            }
        });
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(TestDoneActivity.this);
                builder.setIcon(R.drawable.ic_home_black_24dp);
                builder.setTitle("Thông báo");
                builder.setMessage("Bạn có muốn trở về trang chủ không?");
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();

                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
            }
        });

    }
    public void begin(){
        tvTrue=findViewById(R.id.tvTrue);
        tvFalse=findViewById(R.id.tvFalse);
        tvNotAns=findViewById(R.id.tvNotAns);
        tvTotalScore=findViewById(R.id.tvTotalPoint);

        btnHome=findViewById(R.id.btnHome);
        btnAgain=findViewById(R.id.btnAgain);
        btnSaveScore=findViewById(R.id.btnSaveScore);
    }
    //PT check ket qua
    public void checkResult(){
        for(int i=0;i<arr_QuesBegin.size();i++){
            if(arr_QuesBegin.get(i).getHadAns().equals("")==true){
                numNoAns++;
            }else if(arr_QuesBegin.get(i).getResult().equals(arr_QuesBegin.get(i).getHadAns())==true){
                numTrue++;
            }else {numFale++; }
        }
    }
}
