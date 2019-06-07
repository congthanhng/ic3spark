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
        radA.setText(getItem(mPageNumber).getAns_a());
        radB.setText(getItem(mPageNumber).getAns_b());
        radC.setText(getItem(mPageNumber).getAns_c());
        radD.setText(getItem(mPageNumber).getAns_d());

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                arr_Tn.get(mPageNumber).choiceID=checkedId;
                arr_Tn.get(mPageNumber).setHadAns(getChoiceFromID(checkedId));
            }
        });

    }

    public TracNghiem getItem(int position){
        return arr_Tn.get(position);
    }
    //lấy giá trị(vị trí ) radioGroup chuyển thành đáp án A/B/C/D
    private String getChoiceFromID(int ID) {
        if (ID == R.id.radA) {
            return "A";
        } else if (ID == R.id.radB) {
            return "B";
        } else if (ID == R.id.radC) {
            return "C";
        } else if (ID == R.id.radD) {
            return "D";
        }else return "";
    }
}

