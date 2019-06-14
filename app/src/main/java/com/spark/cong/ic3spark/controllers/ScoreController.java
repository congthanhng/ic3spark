package com.spark.cong.ic3spark.controllers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.spark.cong.ic3spark.models.DBHelper;
import com.spark.cong.ic3spark.models.Score;
import com.spark.cong.ic3spark.models.TracNghiem;

import java.util.ArrayList;

public class ScoreController {
    private DBHelper dbHelper;
    public ScoreController(Context context){
        dbHelper=new DBHelper(context);
    }

    public void insertScore(String name,int score,String room){
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("name",name);
        values.put("score",score);
        values.put("room",room);
        db.insert("tbscore",null,values);
        db.close();
    }

    public Cursor getScore(){
        ArrayList<Score> lsData= new ArrayList<Score>();
        SQLiteDatabase db= dbHelper.getReadableDatabase();
        Cursor cursor=db.query("tbscore",//tenbang
                null,//danh sach cot can lay,
                null,//dieu kien where
                null,//doi so dieu kienj where
                null,//bieu thuc froupBy
                null,//bieu thuc having
                "id DESC",//bieu thuc orderby
                null );
        if(cursor!=null)cursor.moveToFirst();
        return cursor;
    }
}
