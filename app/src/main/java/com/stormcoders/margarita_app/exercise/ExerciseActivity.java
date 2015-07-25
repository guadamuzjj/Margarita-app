package com.stormcoders.margarita_app.exercise;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.WindowManager;

import com.stormcoders.margarita_app.R;
import com.stormcoders.margarita_app.Utils;
import com.stormcoders.margarita_app.activity.Activity;

import java.util.ArrayList;
import java.util.List;


public class ExerciseActivity extends ActionBarActivity {

    Utils utils = new Utils();

    private List<Activity> activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        utils.toggleHideyBar(this);

        RecyclerView rv = (RecyclerView)findViewById(R.id.rvContent);
        rv.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(layoutManager);

        activity = new ArrayList<>();
        activity.add(new Activity("Selección Multiple", "Lorem ipsum dolor sit amet, consectetur adipiscing elit.", "#1ABC9C"));
        activity.add(new Activity("Verdadero Y Falso", "Lorem ipsum dolor sit amet, consectetur adipiscing elit.", "#F1C40F"));
        activity.add(new Activity("Completar", "Lorem ipsum dolor sit amet, consectetur adipiscing elit.", "#2C3E50"));
        activity.add(new Activity("Ordenar", "Lorem ipsum dolor sit amet, consectetur adipiscing elit.", "#2980b9"));

        rv.setAdapter(new ExerciseAdapter(activity, R.layout.exercise_row));
    }
}