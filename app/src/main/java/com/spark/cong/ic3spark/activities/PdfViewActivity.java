package com.spark.cong.ic3spark.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.github.barteksc.pdfviewer.PDFView;
import com.spark.cong.ic3spark.R;

public class PdfViewActivity extends AppCompatActivity {
    private PDFView pdfView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_view);

        pdfView=(PDFView)findViewById(R.id.pdfViewer);
        pdfView.fromAsset("demo.pdf").load();
    }
}
