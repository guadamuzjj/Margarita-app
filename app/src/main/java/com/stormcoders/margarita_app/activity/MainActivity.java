package com.stormcoders.margarita_app.activity;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;

import com.stormcoders.margarita_app.R;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {



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
        activity.add(new Activity("Leer Poema", "Lorem ipsum dolor sit amet, consectetur adipiscing elit.", "#1ABC9C"));
        activity.add(new Activity("Actividades", "Lorem ipsum dolor sit amet, consectetur adipiscing elit.", "#F1C40F"));
        activity.add(new Activity("Creditos", "Lorem ipsum dolor sit amet, consectetur adipiscing elit.", "#2C3E50"));
        rv.setAdapter(new ActivityAdapter(activity, R.layout.activity_row));
    }
}
