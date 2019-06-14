package com.spark.cong.ic3spark.activities;

import android.app.Dialog;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import com.spark.cong.ic3spark.R;
import com.spark.cong.ic3spark.adapters.CheckAnswerAdapter;
import com.spark.cong.ic3spark.controllers.TracnghiemController;
import com.spark.cong.ic3spark.fragments.ScreenSlidePageFragment;
import com.spark.cong.ic3spark.models.TracNghiem;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class ScreenSlidePagerActivity extends FragmentActivity {
    /**
     * The number of pages (wizard steps) to show in this demo.
     */
    private static final int NUM_PAGES = 15;

    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
    private ViewPager mPager;

    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    private PagerAdapter pagerAdapter;

    TextView tvKiemtra;
    TextView tvTimer;
    TextView tvXemdiem;

    public int checkAns = 0;

    //CSDL
    TracnghiemController tracnghiemController;
    ArrayList<TracNghiem>arr_tn;
    CounterClass timer; // khai bao lop dem nguoc

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_slide);

        // Instantiate a ViewPager and a PagerAdapter.
        mPager = findViewById(R.id.pager);
        pagerAdapter=new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(pagerAdapter);
        mPager.setPageTransformer(true, new DepthPageTransformer ());

        //thoi gian dem nguoc 60s
        timer=new CounterClass(60*1000,1000);

        tracnghiemController =new TracnghiemController(this);
        arr_tn=new ArrayList<TracNghiem>();
        arr_tn=tracnghiemController.getTracnghiem();

        tvKiemtra=(TextView)findViewById(R.id.tvKiemTra);
        tvTimer=(TextView)findViewById(R.id.tvTimer);
        tvXemdiem=(TextView)findViewById(R.id.tvScore);

        tvKiemtra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAns();
            }
        });

        tvTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        tvXemdiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent=new Intent(ScreenSlidePagerActivity.this,TestDoneActivity.class);
                intent.putExtra("arr_Ques",arr_tn);
                startActivity(intent);
            }
        });
        timer.start();
    }

    //tao phuong thuc de ScreenSlidePageFragment lay duoc data
    public ArrayList<TracNghiem> getData(){
        return arr_tn;
    }

    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }

    /**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
     */
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            //tra ve vi tri cua cau cho fragment hien thi
            return ScreenSlidePageFragment.create(position,checkAns);
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }

    public class DepthPageTransformer implements ViewPager.PageTransformer {
        private static final float MIN_SCALE = 0.75f;

        public void transformPage(View view, float position) {
            int pageWidth = view.getWidth();

            if (position < -1) { // [-Infinity,-1)
                // This page is way off-screen to the left.
                view.setAlpha(0f);

            } else if (position <= 0) { // [-1,0]
                // Use the default slide transition when moving to the left page
                view.setAlpha(1f);
                view.setTranslationX(0f);
                view.setScaleX(1f);
                view.setScaleY(1f);

            } else if (position <= 1) { // (0,1]
                // Fade the page out.
                view.setAlpha(1 - position);

                // Counteract the default slide transition
                view.setTranslationX(pageWidth * -position);

                // Scale the page down (between MIN_SCALE and 1)
                float scaleFactor = MIN_SCALE
                        + (1 - MIN_SCALE) * (1 - Math.abs(position));
                view.setScaleX(scaleFactor);
                view.setScaleY(scaleFactor);

            } else { // (1,+Infinity]
                // This page is way off-screen to the right.
                view.setAlpha(0f);
            }
        }
    }

    public void checkAns(){
        final Dialog dialog=new Dialog(this);
        dialog.setContentView(R.layout.dialog_check_answer);

        dialog.setTitle("Danh sách câu trả lời");

        //thiet lap adapter cho dialog
        CheckAnswerAdapter answerAdapter=new CheckAnswerAdapter(arr_tn,this);
        final GridView gvLsAns= (GridView)dialog.findViewById(R.id.gridViewQuestion);
        gvLsAns.setAdapter(answerAdapter);

        gvLsAns.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mPager.setCurrentItem(position);
                dialog.dismiss();

            }
        });

        //khai bao 2 button
        Button btnCancel,btnFinish;
        btnCancel=(Button)dialog.findViewById(R.id.btnCancel);
        btnFinish=(Button)dialog.findViewById(R.id.btnFinish);

        //button click listener cancel
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        //button click listener finnish> dừng thời gian đếm ngược và thay đổi nút textview kiểm tra
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.cancel();
                result();
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    //khi nop bai thay doi textview Kiemtra thanh Xemdiem
    public void result(){
        checkAns=1;
        if (mPager.getCurrentItem()>=5)mPager.setCurrentItem(mPager.getCurrentItem()-4);
        else if (mPager.getCurrentItem()<=5)mPager.setCurrentItem(mPager.getCurrentItem()+4);
        tvXemdiem.setVisibility(View.VISIBLE);
        tvKiemtra.setVisibility(View.GONE);
    }
    // millisInFuture: 60*1000 (60 giây đến ngược)
    //countDownInterval: 1000 (đếm ngược 1s)
    public class CounterClass extends CountDownTimer {
        /**
         * @param millisInFuture    The number of millis in the future from the call
         *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
         *                          is called.
         * @param countDownInterval The interval along the way to receive
         *                          {@link #onTick(long)} callbacks.
         */
        public CounterClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            String countTime = String.format("%02d:%02d", TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished), TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
                    TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)));
            tvTimer.setText(countTime); //SetText cho textview hiện thị thời gian.
        }

        @Override
        public void onFinish() {
            tvTimer.setText("00:00");  //SetText cho textview hiện thị thời gian.
        }
    }

}
