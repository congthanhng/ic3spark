package com.spark.cong.ic3spark.views;

import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.spark.cong.ic3spark.R;
import com.spark.cong.ic3spark.models.LythuyetParent;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

import static android.view.animation.Animation.RELATIVE_TO_SELF;

public class LythuyetParentViewHolder extends GroupViewHolder {
    private TextView mTextView;
    private ImageView arrow;
    public LythuyetParentViewHolder(View itemView) {
        super(itemView);
        mTextView=itemView.findViewById(R.id.textView_chuong);
        arrow=itemView.findViewById(R.id.imgView_arrow);
    }
    public void bind(LythuyetParent lythuyetParent){
        mTextView.setText(lythuyetParent.getTitle());
    }
    @Override
    public void expand() {
        animateExpand();
    }

    @Override
    public void collapse() {
        animateCollapse();
    }

    private void animateExpand() {
        RotateAnimation rotate =
                new RotateAnimation(360, 180, RELATIVE_TO_SELF, 0.5f, RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(300);
        rotate.setFillAfter(true);
        arrow.setAnimation(rotate);
    }

    private void animateCollapse() {
        RotateAnimation rotate =
                new RotateAnimation(180, 360, RELATIVE_TO_SELF, 0.5f, RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(300);
        rotate.setFillAfter(true);
        arrow.setAnimation(rotate);
    }
}

