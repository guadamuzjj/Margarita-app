package com.stormcoders.margarita_app.story;

/**
 * Created by oscarmcm on 25/7/15.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.stormcoders.margarita_app.R;

/**
 * {@link BaseAdapter} para poblar capitulos en un grid view
 */

public class ChapterAdapter extends BaseAdapter {
    private Context context;

    public ChapterAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return Chapter.ITEMS.length;
    }

    @Override
    public Chapter getItem(int position) {
        return Chapter.ITEMS[position];
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.story_grid, viewGroup, false);
        }

        ImageView chapterImage = (ImageView) view.findViewById(R.id.chapter_image);
        TextView chapterName = (TextView) view.findViewById(R.id.chapter_name);

        final Chapter item = getItem(position);
        Glide.with(chapterImage.getContext())
                .load(item.getIdDrawable())
                .into(chapterImage);

        chapterName.setText(item.getName());

        return view;
    }

}