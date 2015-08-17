package com.stormcoders.margarita_app.exercise;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.stormcoders.margarita_app.ColorLibrary;
import com.stormcoders.margarita_app.R;
import com.stormcoders.margarita_app.activity.MainActivity;
import com.stormcoders.margarita_app.story.StoryActivity;

import java.util.StringTokenizer;

public class WordsComplete extends ActionBarActivity {

    private ColorLibrary colors = new ColorLibrary();
    RelativeLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.words_complete);

        int color = colors.getColor();

        mainLayout = (RelativeLayout) findViewById(R.id.main_layout);
        mainLayout.setBackgroundColor(color);
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
                intent =  new Intent(WordsComplete.this, MainActivity.class);
                break;
            case R.id.read_poem:
                intent =  new Intent(WordsComplete.this, StoryActivity.class);
                break;
            case R.id.exercises:
                intent =  new Intent(WordsComplete.this, ExerciseActivity.class);
                break;
            case R.id.credits:
                intent =  new Intent(WordsComplete.this, ExerciseActivity.class);
                break;
        }

        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }
}
