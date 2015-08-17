package com.stormcoders.margarita_app.exercise;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.stormcoders.margarita_app.ColorLibrary;
import com.stormcoders.margarita_app.R;
import com.stormcoders.margarita_app.activity.MainActivity;
import com.stormcoders.margarita_app.story.StoryActivity;

public class SortEvents extends ActionBarActivity {

    private ColorLibrary colors = new ColorLibrary();

    Intent intent;
    TextView tvEvent;
    Spinner spinner;
    int prevOption;
    int option;
    int sortNumber;
    RelativeLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.sort_events);

        int color = colors.getColor();

        mainLayout = (RelativeLayout) findViewById(R.id.main_layout);
        tvEvent = (TextView) findViewById(R.id.tvEvent);
        spinner = (Spinner) findViewById(R.id.spinner);
        mainLayout.setBackgroundColor(color);

        sortNumber = getIntent().getIntExtra("SORT", 1);

        switch (sortNumber) {
            case 1: getSortEvent(0); break;
            case 2: getSortEvent(1); break;
            case 3: getSortEvent(2); break;
            case 4: getSortEvent(3); break;
            case 5: getSortEvent(4); break;
            case 6: getSortEvent(5); break;
        }
    }

    @Override
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
                intent =  new Intent(SortEvents.this, MainActivity.class);
                break;
            case R.id.read_poem:
                intent =  new Intent(SortEvents.this, StoryActivity.class);
                break;
            case R.id.exercises:
                intent =  new Intent(SortEvents.this, ExerciseActivity.class);
                break;
            case R.id.credits:
                intent =  new Intent(SortEvents.this, ExerciseActivity.class);
                break;
        }

        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }

    public void start(View view) {
        switch (sortNumber) {
            case 1:
                nextSortEvent(SortEvents.class, 2, 3);
                break;
            case 2:
                nextSortEvent(SortEvents.class, 3, 1);
                break;
            case 3:
                nextSortEvent(SortEvents.class, 4, 0);
                break;
            case 4:
                nextSortEvent(SortEvents.class, 5, 2);
                break;
            case 5:
                nextSortEvent(ResultActivity.class, 6, 4);
                intent.putExtra("FROM", "SortEvents");
                break;
            default:
                intent = new Intent(this, ResultActivity.class);
                break;
        }

        startActivity(intent);
    }

    private void getSortEvent(int index) {
        String[] events = getResources().getStringArray(R.array.sort_events);

        for(int i=0; i < 1; i++){
            String event = events[index];
            tvEvent.setText(event);
        }
    }

    private void nextSortEvent(Class classDest, int nEvent, int correctIndex) {
        intent = new Intent(this, classDest);
        intent.putExtra("SORT", nEvent);
        option = (spinner.getSelectedItemPosition() == correctIndex ) ? 1: 0;
        prevOption = getIntent().getIntExtra("OPTION", 0);
        intent.putExtra("OPTION", option + prevOption);
    }
}
