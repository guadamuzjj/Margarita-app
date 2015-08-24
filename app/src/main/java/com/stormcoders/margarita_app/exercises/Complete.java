package com.stormcoders.margarita_app.exercises;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.InputType;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.stormcoders.margarita_app.R;
import com.stormcoders.margarita_app.activity.MainActivity;
import com.stormcoders.margarita_app.story.StoryActivity;

public class Complete extends ActionBarActivity {
    private String[] options = {};
    RelativeLayout mainLayout;
    TextView tvComplete;

    Intent intent;
    int prevOption;
    int completeNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.complete);

        mainLayout = (RelativeLayout) findViewById(R.id.main_layout);
        tvComplete = (TextView) findViewById(R.id.tvComplete);

        LinearLayout fragContainer = (LinearLayout) findViewById(R.id.llComplete);
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        ll.setId(12345);

        String[] items = {};

        completeNumber = getIntent().getIntExtra("COMPLETE", 1);

        switch (completeNumber) {
            case 1: items = getItems(0); break;
            case 2: items = getItems(1); break;
        }

        for (String item : items) {
            getFragmentManager().beginTransaction().add(ll.getId(), CompleteFragment.newInstance(item)).commit();
        }

        fragContainer.addView(ll);
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
                intent =  new Intent(Complete.this, MainActivity.class);
                break;
            case R.id.read_poem:
                intent =  new Intent(Complete.this, StoryActivity.class);
                break;
            case R.id.exercises:
                intent =  new Intent(Complete.this, ExerciseActivity.class);
                break;
            case R.id.credits:
                intent =  new Intent(Complete.this, ExerciseActivity.class);
                break;
        }

        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }

    public void start(View view) {

        switch (completeNumber) {
            case 1:
                nextExercise(Complete.class, 2);
                break;
            case 2:
                nextExercise(ResultActivity.class, 3);
                intent = new Intent(this, ResultActivity.class);
                intent.putExtra("FROM", "COMPLETE");
                break;
            default:
                intent = new Intent(this, ResultActivity.class);
                break;
        }

        startActivity(intent);
    }

    public void launchDialog(final View v) {
        final ArrayAdapter<String> spinner_options = new  ArrayAdapter<String>(Complete.this,android.R.layout.simple_spinner_dropdown_item, options);

        new AlertDialog.Builder(Complete.this)
                .setTitle("Selecciona una opción")
                .setAdapter(spinner_options, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        String tmpText = ((TextView)v).getText().toString();
                        String text = tmpText.replace("______", options[which]);
                        ((TextView)v).setText(text);
                        dialog.dismiss();
                    }
                }).create().show();
    }

    private String[] getItems(int index) {
        String[] items;

        if (index == 0) {
            items = getResources().getStringArray(R.array.complete_1);
            options = getResources().getStringArray(R.array.options_complete_1);
        } else {
            items = getResources().getStringArray(R.array.complete_2);
            options = getResources().getStringArray(R.array.options_complete_2);
        }

        return items;
    }

    private void nextExercise(Class classDest, int nextItem) {
        intent = new Intent(this, classDest);
        intent.putExtra("COMPLETE", nextItem);
        prevOption = getIntent().getIntExtra("OPTION", 0);
        intent.putExtra("OPTION", 5);
    }
}
