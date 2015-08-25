package com.stormcoders.margarita_app.exercises;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.stormcoders.margarita_app.R;
import com.stormcoders.margarita_app.activity.MainActivity;
import com.stormcoders.margarita_app.exercises.drag_and_sort.DragAndSort;

import java.util.List;

public class ExerciseAdapter extends RecyclerView.Adapter<ExerciseAdapter.ExerciseViewHolder> {

    List<Exercise> exercise;
    private int itemLayout;

    ExerciseAdapter(List<Exercise> exercise, int itemLayout) {
        this.exercise = exercise;
        this.itemLayout = itemLayout;
    }

    @Override
    public void onBindViewHolder(ExerciseViewHolder activityViewHolder, int i) {
        activityViewHolder.icon.setImageResource(exercise.get(i).icon);
        activityViewHolder.exerciseName.setText(exercise.get(i).title);
    }

    @Override
    public ExerciseViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(itemLayout, viewGroup, false);
        return new ExerciseViewHolder(itemView);
    }

    public static class ExerciseViewHolder extends RecyclerView.ViewHolder implements AdapterView.OnClickListener {
        Context context;
        TextView exerciseName;
        ImageView icon;

        ExerciseViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();

            itemView.setOnClickListener(this);
            icon = (ImageView) itemView.findViewById(R.id.imageIcon);
            exerciseName = (TextView) itemView.findViewById(R.id.tvExerciseName);
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
                    intent =  new Intent(context, DragAndSort.class);
                    break;
                case 3:
                    intent = new Intent(context, SoupActivity.class);
                    break;
                case 4:
                    intent =  new Intent(context, Complete.class);
                    intent.putExtra("COMPLETE", 1);
                    break;

                default:
                    break;
            }

            context.startActivity(intent);
        }
    }

    @Override
    public int getItemCount() {
        return exercise.size();
    }
}
