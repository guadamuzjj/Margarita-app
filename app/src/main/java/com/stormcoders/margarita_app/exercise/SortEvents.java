package com.stormcoders.margarita_app.exercise;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Spinner;
import android.widget.TextView;

import com.stormcoders.margarita_app.R;

public class SortEvents extends ActionBarActivity {

    Intent intent;
    TextView tvEvent;
    Spinner spinner;
    int prevOption;
    int option;
    int sortNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.sort_events);

        tvEvent = (TextView) findViewById(R.id.tvEvent);
        spinner = (Spinner) findViewById(R.id.spinner);

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

    public void start(View view) {
        switch (sortNumber) {
            case 1:
                nextSortEvent(SortEvents.class, 2, "4");
                break;
            case 2:
                nextSortEvent(SortEvents.class, 3, "6");
                break;
            case 3:
                nextSortEvent(SortEvents.class, 4, "2");
                break;
            case 4:
                nextSortEvent(SortEvents.class, 5, "1");
                break;
            case 5:
                nextSortEvent(SortEvents.class, 6, "3");
                break;
            case 6:
                nextSortEvent(ResultActivity.class, 7, "5");
                intent = new Intent(this, SortEvents.class);
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

    private void nextSortEvent(Class classDest, int nEvent, String correctIndex) {
        intent = new Intent(this, classDest);
        intent.putExtra("SORT", nEvent);
        option = (spinner.getSelectedItem().toString() == correctIndex ) ? 1: 0;
        prevOption = getIntent().getIntExtra("OPTION", 0);
        intent.putExtra("OPTION", option + prevOption);
    }
}
