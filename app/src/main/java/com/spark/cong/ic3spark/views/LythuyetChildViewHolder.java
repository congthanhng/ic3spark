package com.spark.cong.ic3spark.views;

import android.app.Application;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.spark.cong.ic3spark.R;
import com.spark.cong.ic3spark.activities.LythuyetActivity;
import com.spark.cong.ic3spark.activities.MainActivity;
import com.spark.cong.ic3spark.activities.PdfViewActivity;
import com.spark.cong.ic3spark.models.LythuyetChild;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

public class LythuyetChildViewHolder extends ChildViewHolder {
    private TextView mTextView;
    public LythuyetChildViewHolder(View itemView) {
        super(itemView);
        mTextView=itemView.findViewById(R.id.textView_chuong_chude);
    }

    public void bind(final LythuyetChild lythuyetChild){
        mTextView.setText(lythuyetChild.name);
        //listener
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),lythuyetChild.getDocument().toString(),Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(v.getContext(),PdfViewActivity.class);
                v.getContext().startActivity(intent);
            }
        });

    }
}
