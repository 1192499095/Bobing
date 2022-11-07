package com.example.bobing;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends ArrayAdapter<Person> {
    public MyAdapter(Context context, int resource,List<Person> pList) {
        super(context, resource, pList);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Person p = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate( R.layout.lv_item, null);
        TextView tv_name = (TextView) view.findViewById(R.id.item_name);
        TextView tv_result = (TextView) view.findViewById(R.id.item_result);
        tv_name.setText(p.getName());
        tv_result.setText(p.getResult());
        return view;
    }
}
