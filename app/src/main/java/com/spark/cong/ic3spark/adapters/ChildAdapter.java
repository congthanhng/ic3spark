package com.spark.cong.ic3spark.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.spark.cong.ic3spark.R;
import com.spark.cong.ic3spark.models.LythuyetChild;
import com.spark.cong.ic3spark.models.LythuyetParent;
import com.spark.cong.ic3spark.views.LythuyetChildViewHolder;
import com.spark.cong.ic3spark.views.LythuyetParentViewHolder;
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

public class ChildAdapter extends ExpandableRecyclerViewAdapter<LythuyetParentViewHolder, LythuyetChildViewHolder> {
    public ChildAdapter(List<? extends ExpandableGroup> groups) {
        super(groups);
    }

    @Override
    public LythuyetParentViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.expandable_recyclerview_parent_lythuyet,parent,false);
        return new LythuyetParentViewHolder(v);
    }

    @Override
    public LythuyetChildViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.expandable_recyclerview_child_lythuyet,parent,false);
        return new LythuyetChildViewHolder(v);
    }

    @Override
    public void onBindChildViewHolder(LythuyetChildViewHolder holder, int flatPosition, ExpandableGroup group, int childIndex) {
        final LythuyetChild lythuyetChild=(LythuyetChild)group.getItems().get(childIndex);
        holder.bind(lythuyetChild);
    }

    @Override
    public void onBindGroupViewHolder(LythuyetParentViewHolder holder, int flatPosition, ExpandableGroup group) {
        final LythuyetParent lythuyetParent=(LythuyetParent)group;
        holder.bind(lythuyetParent);
    }
}
