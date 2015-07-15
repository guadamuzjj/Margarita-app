package com.stormcoders.margarita_app;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.view.WindowManager;

import com.stormcoders.margarita_app.exercise.ExerciseActivity;
import com.stormcoders.margarita_app.story.StoryActivity;


public class MainActivity extends ActionBarActivity {

    Utils utils = new Utils();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // This, remove the status bar.
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        utils.toggleHideyBar(this);
    }

    public void story (View view) {
        Intent intent = new Intent(MainActivity.this, StoryActivity.class);
        startActivity(intent);
    }

    public void exercise(View view) {
        Intent intent = new Intent(MainActivity.this, ExerciseActivity.class);
        startActivity(intent);
    }

    public void settings(View view) {
        Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
        startActivity(intent);
    }
}
