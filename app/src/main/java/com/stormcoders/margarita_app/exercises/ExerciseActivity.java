package com.stormcoders.margarita_app.exercises;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.stormcoders.margarita_app.R;
import com.stormcoders.margarita_app.activity.MainActivity;
import com.stormcoders.margarita_app.story.StoryActivity;

import java.util.ArrayList;
import java.util.List;


public class ExerciseActivity extends ActionBarActivity {

    private List<Exercise> exercise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        RecyclerView rv = (RecyclerView)findViewById(R.id.rvContent);
        rv.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(layoutManager);

        exercise = new ArrayList<>();
        exercise.add(new Exercise("Selección Multiple", R.mipmap.ic_format_list_numbered_white_36dp));
        exercise.add(new Exercise("Falso y Verdadero", R.mipmap.ic_format_list_bulleted_white_36dp));
        exercise.add(new Exercise("Ordenar Ideas", R.mipmap.ic_sort_white_36dp));
        exercise.add(new Exercise("Completar Párrafos", R.mipmap.ic_format_list_numbered_white_36dp));

        rv.setAdapter(new ExerciseAdapter(exercise, R.layout.exercise_row));
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent();
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        switch (id) {
            case R.id.home:
                intent =  new Intent(ExerciseActivity.this, MainActivity.class);
                break;
            case R.id.read_poem:
                intent =  new Intent(ExerciseActivity.this, StoryActivity.class);
                break;
            case R.id.exercises:
                intent =  new Intent(ExerciseActivity.this, ExerciseActivity.class);
                break;
            case R.id.credits:
                intent =  new Intent(ExerciseActivity.this, ExerciseActivity.class);
                break;
        }

        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }
}