package com.spark.cong.ic3spark.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.github.barteksc.pdfviewer.PDFView;
import com.spark.cong.ic3spark.R;
import com.spark.cong.ic3spark.adapters.ChildAdapter;
import com.spark.cong.ic3spark.models.LythuyetChild;
import com.spark.cong.ic3spark.models.LythuyetParent;

import java.util.ArrayList;
import java.util.List;

public class LythuyetActivity extends AppCompatActivity {
    PDFView pdfView;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lythuyet);

        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<LythuyetParent> parent = new ArrayList<>();
        addData(parent);

        ChildAdapter adapter=new ChildAdapter(parent);
        recyclerView.setAdapter(adapter);


//        pdfView=(PDFView)findViewById(R.id.pdfViewer);
//        pdfView.fromAsset("demo.pdf").load();

    }
    public void addData(List<LythuyetParent> parent){
        //chương I
        ArrayList<LythuyetChild> childChuongI=new ArrayList<>();
        childChuongI.add(new LythuyetChild("Chủ đề A: Căn bản hệ điều hành", "chuong1chudeA.pdf"));
        childChuongI.add(new LythuyetChild("Chủ đề B: Phần cứng máy tính", "chuong1chudeB.pdf"));
        childChuongI.add(new LythuyetChild("Chủ đề C: Phần mềm máy tính", "chuong1chudeC.pdf"));
        LythuyetParent ChuongI=new LythuyetParent("Chương I: Máy tính thật đơn giản",childChuongI);
        parent.add(ChuongI);

        //Chương II
        ArrayList<LythuyetChild> childChuongII=new ArrayList<>();
        childChuongII.add(new LythuyetChild("Chủ đề A: Các tính năng phổ biến", "chuong2chudeA.pdf"));
        childChuongII.add(new LythuyetChild("Chủ đề B: MICROSOFT WORD", "chuong2chudeB.pdf"));
        childChuongII.add(new LythuyetChild("Chủ đề C: MICROSOFT EXCEL", "chuong2chudeC.pdf"));
        childChuongII.add(new LythuyetChild("Chủ đề D: MICROSOFT POWERPOINT", "chuong2chudeD.pdf"));
        LythuyetParent ChuongII=new LythuyetParent("Chương II: Các ứng dụng chủ chốt",childChuongII);
        parent.add(ChuongII);

        //Chương III
        ArrayList<LythuyetChild> childChuongIII=new ArrayList<>();
        childChuongIII.add(new LythuyetChild("Chủ đề A: Internet và truyền thông số", "chuong3chudeA.pdf"));
        childChuongIII.add(new LythuyetChild("Chủ đề B: Công dân số", "chuong3chudeB.pdf"));
        LythuyetParent ChuongIII=new LythuyetParent("Chương III: Cuộc sống trực tuyến",childChuongIII);
        parent.add(ChuongIII);

    }
}
