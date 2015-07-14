package com.stormcoders.margarita_app;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.WindowManager;



public class ExerciseActivity extends ActionBarActivity {

    com.stormcoders.margarita_app.Utils utils = new com.stormcoders.margarita_app.Utils();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // This, remove the status bar.
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_story);
        utils.toggleHideyBar(this);
    }
}