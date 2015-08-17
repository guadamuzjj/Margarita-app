package com.stormcoders.margarita_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.stormcoders.margarita_app.activity.MainActivity;
import com.stormcoders.margarita_app.exercise.ExerciseActivity;

public class SplashScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
    }

    public void entrar(View view) {
        Intent intent =  new Intent(SplashScreen.this, MainActivity.class);
        startActivity(intent);
    }
}
