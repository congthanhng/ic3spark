package com.spark.cong.ic3spark.LyThuyet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;
import com.spark.cong.ic3spark.R;

public class LythuyetActivity extends AppCompatActivity {
    PDFView pdfView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lythuyet);
        pdfView=(PDFView)findViewById(R.id.pdfViewer);

        pdfView.fromAsset("demo.pdf").load();
    }
}
