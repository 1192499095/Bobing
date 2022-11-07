package com.example.bobing;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

public class MyGridViewAdapter extends BaseAdapter {
    private Context mContext;
    public int []imageID=new int[6];

    public MyGridViewAdapter(Context context,int []imageID) {
        this.imageID=imageID;
        mContext = context;
    }

    @Override
    public int getCount() {
        return imageID.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if (view == null) {
            viewHolder = new ViewHolder();
            view = View.inflate(mContext, R.layout.item_gv, null);
            viewHolder.mImageView = (ImageView) view.findViewById(R.id.item_dice1);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.mImageView.setImageResource(imageID[position]);

        return view;
    }
}

class ViewHolder {
    ImageView mImageView;
}
