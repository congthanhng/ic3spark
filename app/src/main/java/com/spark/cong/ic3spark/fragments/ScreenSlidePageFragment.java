package com.spark.cong.ic3spark.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.spark.cong.ic3spark.R;
import com.spark.cong.ic3spark.activities.ScreenSlidePagerActivity;
import com.spark.cong.ic3spark.models.TracNghiem;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScreenSlidePageFragment extends Fragment {
    ArrayList<TracNghiem> arr_Tn;
    public static final String ARG_PAGE = "page";
    private int mPageNumber;//vi tri trang hien tai

    TextView tvNum,tvQuestion;
    RadioGroup radioGroup;
    RadioButton radA,radB,radC,radD;

    public ScreenSlidePageFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_screen_slide_page, container, false);
        tvNum=(TextView) rootView.findViewById(R.id.tvNum);
        tvQuestion=(TextView) rootView.findViewById(R.id.tvQuestion);
        radA=(RadioButton)rootView.findViewById(R.id.radA);
        radB=(RadioButton)rootView.findViewById(R.id.radB);
        radC=(RadioButton)rootView.findViewById(R.id.radC);
        radD=(RadioButton)rootView.findViewById(R.id.radD);
        radioGroup=(RadioGroup)rootView.findViewById(R.id.radGroup);


        return rootView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        arr_Tn=new ArrayList<TracNghiem>();
        ScreenSlidePagerActivity screenSlidePagerActivity= (ScreenSlidePagerActivity) getActivity();
        arr_Tn=screenSlidePagerActivity.getData();

        mPageNumber=getArguments().getInt("ARG_PAGE");
    }

    //lay vi tri cua cau hoi
    public static ScreenSlidePageFragment create(int pageNumber){
        ScreenSlidePageFragment fragment=new ScreenSlidePageFragment();
        Bundle args=new Bundle();
        args.putInt("ARG_PAGE",pageNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        tvNum.setText("Câu "+(mPageNumber+1));
        tvQuestion.setText(arr_Tn.get(mPageNumber).getQuestion());
        radA.setText(arr_Tn.get(mPageNumber).getAns_a());
        radB.setText(arr_Tn.get(mPageNumber).getAns_b());
        radC.setText(arr_Tn.get(mPageNumber).getAns_c());
        radD.setText(arr_Tn.get(mPageNumber).getAns_d());

    }
}

