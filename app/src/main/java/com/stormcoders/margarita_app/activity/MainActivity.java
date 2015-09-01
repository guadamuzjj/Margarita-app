package com.stormcoders.margarita_app.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.stormcoders.margarita_app.R;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        RecyclerView rv = (RecyclerView)findViewById(R.id.rvContent);
        rv.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(layoutManager);

        List<Activity> activity = new ArrayList<>();
        activity.add(new Activity("Leer Poema", "Leer A Margarita Debayle.", "#1ABC9C"));
        activity.add(new Activity("Actividades", "Aprende con estos ejercicios.", "#F1C40F"));
        activity.add(new Activity("Creditos", "Desarrolladores de esta aplicación.", "#2C3E50"));
        rv.setAdapter(new ActivityAdapter(activity, R.layout.activity_row));
    }
}
