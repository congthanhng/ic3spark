package com.spark.cong.ic3spark.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.spark.cong.ic3spark.R;
import com.spark.cong.ic3spark.models.TracNghiem;

import java.util.ArrayList;

public class CheckAnswerAdapter extends BaseAdapter {
    ArrayList lsData;
    LayoutInflater inflater;

    public CheckAnswerAdapter(ArrayList lsData, Context context) {
        this.lsData = lsData;
        inflater= (LayoutInflater) context.getSystemService((context.LAYOUT_INFLATER_SERVICE));
    }

    @Override
    public int getCount() {
        return lsData.size();
    }

    @Override
    public Object getItem(int position) {
        return lsData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private static class ViewHolder{
        TextView tvNumAnswer,tvAnswer;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TracNghiem data=(TracNghiem)getItem(position);
        ViewHolder holder;
        if(convertView==null){
            holder=new ViewHolder();
            convertView=inflater.inflate(R.layout.item_gridview_list_answer,null);
            holder.tvNumAnswer=(TextView)convertView.findViewById(R.id.tvNumAnswer);
            holder.tvAnswer=(TextView)convertView.findViewById(R.id.tvAnswer);
            convertView.setTag(holder);
        } else holder=(ViewHolder)convertView.getTag();

        int i=position+1;
        holder.tvNumAnswer.setText("Câu "+i+": ");
        holder.tvAnswer.setText(data.getHadAns());
        return convertView;
    }
}
