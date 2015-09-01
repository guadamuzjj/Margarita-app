package com.stormcoders.margarita_app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.stormcoders.margarita_app.activity.MainActivity;
import com.stormcoders.margarita_app.exercises.ExerciseActivity;
import com.stormcoders.margarita_app.story.StoryActivity;

public class CreditsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.credits_activity);
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
                intent =  new Intent(CreditsActivity.this, MainActivity.class);
                break;
            case R.id.read_poem:
                intent =  new Intent(CreditsActivity.this, StoryActivity.class);
                break;
            case R.id.exercises:
                intent =  new Intent(CreditsActivity.this, ExerciseActivity.class);
                break;
            case R.id.credits:
                intent =  new Intent(CreditsActivity.this, CreditsActivity.class);
                break;
        }

        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }

    public void about(View v) {
        Context context = getApplicationContext();
        String textToShow = "Esta es una aplicación que presenta el contenido del cuento o poema Betún y Sangre y actividades educativas sobre el mismo. Dirigido a estudiantes de 3 grado de educación primaria.";
        int duration = Toast.LENGTH_LONG;

        final Toast toast = Toast.makeText(context, textToShow, duration);
        toast.show();
    }
}
