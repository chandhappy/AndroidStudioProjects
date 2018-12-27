package com.example.e_learning;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

/**
 * Created by INCBASHA on 12/4/2016.
 */
public class ProgressItemsAdapter extends BaseAdapter {

    private Context context;
    private List<ProgressItems> lstItem;

    public ProgressItemsAdapter(Context context, List<ProgressItems> lstItem) {
        this.context = context;
        this.lstItem = lstItem;
    }

    @Override
    public int getCount() {
        return lstItem.size();
    }

    @Override
    public Object getItem(int position) {
        return lstItem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = View.inflate(context, R.layout.item_progress_menu, null);
        ImageView img = (ImageView)v.findViewById(R.id.imageView);
        TextView tv = (TextView)v.findViewById(R.id.TopicName);
        ProgressBar pb= (ProgressBar)v.findViewById(R.id.progressBar);

        ProgressItems item = lstItem.get(position);
        img.setImageResource(item.getImgId());
        tv.setText(item.getTitle());
        pb.setProgress(item.getProgress());

        return v;
    }
}
