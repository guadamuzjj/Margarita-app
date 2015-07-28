package com.stormcoders.margarita_app.exercise;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.WindowManager;

import com.stormcoders.margarita_app.R;
import com.stormcoders.margarita_app.activity.Activity;

import java.util.ArrayList;
import java.util.List;


public class ExerciseActivity extends ActionBarActivity {

    private List<Activity> activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        RecyclerView rv = (RecyclerView)findViewById(R.id.rvContent);
        rv.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(layoutManager);

        activity = new ArrayList<>();
        activity.add(new Activity("Selección Multiple", "Selcciona la respuesta correcta a lo  que se te pide.", "#1ABC9C"));
        activity.add(new Activity("Verdadero Y Falso", "Escriba Falso o Verdadero.", "#F1C40F"));
        activity.add(new Activity("Ordenar", "Ordena las ideas relevantes como suceden en el poema.", "#2980b9"));
        activity.add(new Activity("Completar", "Lorem ipsum dolor sit amet, consectetur adipiscing elit.", "#2C3E50"));

        rv.setAdapter(new ExerciseAdapter(activity, R.layout.exercise_row));
    }
}