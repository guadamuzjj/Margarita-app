package com.stormcoders.margarita_app.exercise;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.WindowManager;

import com.stormcoders.margarita_app.R;


public class ExerciseActivity extends ActionBarActivity {

    com.stormcoders.margarita_app.Utils utils = new com.stormcoders.margarita_app.Utils();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // This, remove the status bar.
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_exercise);
        utils.toggleHideyBar(this);
    }
}