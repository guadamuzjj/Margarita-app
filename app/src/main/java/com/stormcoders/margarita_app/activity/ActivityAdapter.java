package com.stormcoders.margarita_app.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.stormcoders.margarita_app.R;
import com.stormcoders.margarita_app.SettingsActivity;
import com.stormcoders.margarita_app.exercise.ExerciseActivity;
import com.stormcoders.margarita_app.story.StoryActivity;

import java.util.List;

public class ActivityAdapter extends RecyclerView.Adapter<ActivityAdapter.ActivityViewHolder> {

    List<Activity> activity;
    private int itemLayout;

    ActivityAdapter(List<Activity> activity, int itemLayout) {
        this.activity = activity;
        this.itemLayout = itemLayout;
    }

    @Override
    public void onBindViewHolder(ActivityViewHolder activityViewHolder, int i) {
        activityViewHolder.activityName.setText(activity.get(i).name);
        activityViewHolder.description.setText(activity.get(i).description);
        activityViewHolder.activityName.setBackgroundColor(Color.parseColor(activity.get(i).color));
    }

    @Override
    public ActivityViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(itemLayout, viewGroup, false);
        return new ActivityViewHolder(itemView);
    }

    public static class ActivityViewHolder extends RecyclerView.ViewHolder implements AdapterView.OnClickListener {
        private Context context;
        CardView cv;
        TextView activityName;
        TextView description;

        ActivityViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();

            itemView.setOnClickListener(this);
            cv = (CardView) itemView.findViewById(R.id.cvActivities);
            activityName = (TextView) itemView.findViewById(R.id.tvName);
            description = (TextView) itemView.findViewById(R.id.tvDescription);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, MainActivity.class);
            int position = getAdapterPosition();

            switch (position){
                case 0:
                    intent =  new Intent(context, StoryActivity.class);
                    break;

                case 1:
                    intent =  new Intent(context, ExerciseActivity.class);
                    break;

                case 2:
                    break;

                case 3:
                    intent =  new Intent(context, SettingsActivity.class);
                    break;

                default:
                    break;
            }

            context.startActivity(intent);
        }
    }

    @Override
    public int getItemCount() {
        return activity.size();
    }
}
