package com.spark.cong.ic3spark.fragments;


import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ListView;
import com.spark.cong.ic3spark.R;
import com.spark.cong.ic3spark.adapters.ScoreAdapter;
import com.spark.cong.ic3spark.controllers.ScoreController;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScoreFragment extends Fragment {
    ListView lvScore;
    ScoreController scoreController;
    ScoreAdapter scoreAdapter;


    public ScoreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_score, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
        scoreController=new ScoreController(getActivity());
        lvScore=(ListView)getActivity().findViewById(R.id.lvScore);
        Cursor cursor=scoreController.getScore();
        scoreAdapter =new ScoreAdapter(getActivity(),cursor,true);
        lvScore.setAdapter(scoreAdapter);
    }
}
