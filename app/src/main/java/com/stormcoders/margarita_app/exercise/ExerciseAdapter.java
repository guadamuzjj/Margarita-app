package com.stormcoders.margarita_app.exercise;

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
import com.stormcoders.margarita_app.activity.Activity;
import com.stormcoders.margarita_app.activity.MainActivity;

import java.util.List;

public class ExerciseAdapter extends RecyclerView.Adapter<ExerciseAdapter.ExerciseViewHolder> {

    List<Activity> activity;
    private int itemLayout;

    ExerciseAdapter(List<Activity> activity, int itemLayout) {
        this.activity = activity;
        this.itemLayout = itemLayout;
    }

    @Override
    public void onBindViewHolder(ExerciseViewHolder activityViewHolder, int i) {
        activityViewHolder.icon.setBackgroundColor(Color.parseColor(activity.get(i).color));
        activityViewHolder.name.setText(activity.get(i).name);
        activityViewHolder.description.setText(activity.get(i).description);
    }

    @Override
    public ExerciseViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(itemLayout, viewGroup, false);
        return new ExerciseViewHolder(itemView);
    }

    public static class ExerciseViewHolder extends RecyclerView.ViewHolder implements AdapterView.OnClickListener {
        private Context context;
        CardView cv;
        TextView icon;
        TextView name;
        TextView description;

        ExerciseViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();

            itemView.setOnClickListener(this);
            cv = (CardView) itemView.findViewById(R.id.cvExercise);
            icon = (TextView) itemView.findViewById(R.id.tvIcon);
            name = (TextView) itemView.findViewById(R.id.tvName2);
            description = (TextView) itemView.findViewById(R.id.tvDescription2);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, MainActivity.class);
            int position = getAdapterPosition();

            switch (position){
                case 0:
                    intent =  new Intent(context, MultipleChoice.class);
                    intent.putExtra("QESTION_NUMBER", 1);
                    break;

                case 1:
                    intent =  new Intent(context, TrueOrFalse.class);
                    intent.putExtra("AFFIRMATION", 1);
                    break;

                case 2:
                    intent =  new Intent(context, SortEvents.class);
                    intent.putExtra("SORT", 1);
                    break;

                case 3:
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
