package com.spark.cong.ic3spark.controllers;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.spark.cong.ic3spark.models.DBHelper;
import com.spark.cong.ic3spark.models.TracNghiem;

import java.util.ArrayList;

public class TracnghiemController {
    private DBHelper dbHelper;
    public TracnghiemController(Context context){
        dbHelper=new DBHelper(context);
    }

    public ArrayList<TracNghiem> getTracnghiem(){
        ArrayList<TracNghiem> lsData= new ArrayList<TracNghiem>();
        SQLiteDatabase db= dbHelper.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM tracnghiem",null);
        cursor.moveToFirst();
        do {
            TracNghiem item;
            item=new TracNghiem(cursor.getInt(0),cursor.getString(1),cursor.getString(2),
                    cursor.getString(3),cursor.getString(4),cursor.getString(5),
                    cursor.getString(6),cursor.getString(7),"");
            lsData.add(item);
        }while (cursor.moveToNext());
        return lsData;
    }
}
