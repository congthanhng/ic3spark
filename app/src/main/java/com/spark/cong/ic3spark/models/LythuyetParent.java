package com.spark.cong.ic3spark.models;

import android.os.Parcel;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

public class LythuyetParent extends ExpandableGroup<LythuyetChild> {
    public LythuyetParent(String title, List<LythuyetChild> items) {
        super(title, items);
    }
}
