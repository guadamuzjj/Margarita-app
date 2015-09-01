package com.stormcoders.margarita_app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.stormcoders.margarita_app.activity.MainActivity;
import com.stormcoders.margarita_app.exercises.ExerciseActivity;
import com.stormcoders.margarita_app.exercises.MultipleChoice;
import com.stormcoders.margarita_app.exercises.TrueOrFalse;
import com.stormcoders.margarita_app.exercises.complete.Complete;
import com.stormcoders.margarita_app.exercises.drag_and_sort.DragAndSort;
import com.stormcoders.margarita_app.story.StoryActivity;

public class ResultActivity  extends AppCompatActivity {

    int attempts;
    boolean result = false;

    TextView tvResult;
    TextView tvAttempts;
    ImageView ivResult;
    Button btFinish;
    Button btViewAnswers;
    String prevActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.result_activity);

        attempts = getIntent().getIntExtra("ATTEMPTS", 2);
        tvResult = (TextView) findViewById(R.id.tvResult);
        tvAttempts = (TextView) findViewById(R.id.tvAttempts);
        ivResult = (ImageView) findViewById(R.id.ivResult);
        btFinish = (Button) findViewById(R.id.btFinish);
        btViewAnswers = (Button) findViewById(R.id.btViewAnswer);

        int actualAnswers = getIntent().getIntExtra("OPTION", 0);
        prevActivity = getIntent().getStringExtra("FROM");

        switch (prevActivity) {
            case "MultipleChoice":
                result = (actualAnswers == 5);
                break;
            case "TrueOrFalse":
                result = (actualAnswers == 5);
                break;
            case "DragAndSort":
                result = (actualAnswers == 6);
                break;
            case "Complete":
                result = (actualAnswers == 2);
                break;
        }

        if(result) {
            tvResult.setText("Lo Lograste");
            ivResult.setImageResource(R.drawable.medalla);
        }
        else {
            tvResult.setText("Inténtalo de nuevo");
            btFinish.setVisibility(View.VISIBLE);

            tvAttempts.setVisibility(View.VISIBLE);
            tvAttempts.setText("Intentos Restantes: " + attempts);

            if (attempts == 0) {
                tvAttempts.setText("No quedan mas Intentos");
                btViewAnswers.setVisibility(View.VISIBLE);
                btFinish.setVisibility(View.GONE);
            }
        }
    }

    public void tryAgain(View view) {
        attempts = attempts - 1;

        Intent intent = new Intent();

        switch (prevActivity) {
            case "MultipleChoice":
                intent = new Intent(ResultActivity.this, MultipleChoice.class);
                break;
            case "TrueOrFalse":
                intent = new Intent(ResultActivity.this, TrueOrFalse.class);
                break;
            case "DragAndSort":
                intent = new Intent(ResultActivity.this, DragAndSort.class);
                break;
            case "Complete":
                intent = new Intent(ResultActivity.this, Complete.class);
                break;
        }

        intent.putExtra("ATTEMPTS", attempts);
        startActivity(intent);
    }

    public void viewAnswers(View view) {
        attempts = attempts - 1;

        String textToShow = "";
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_LONG;

        switch (prevActivity) {
            case "MultipleChoice":
                textToShow = "Respuesta 1: La Princesa\n" +
                        "Respuesta 2: Una Vez\n" +
                        "Respuesta 3: A Margarita\n" +
                        "Respuesta 4: Es esclarecer y consolar explicando que él le había ofrecido la rosa\n" +
                        "Respuesta 5: Mágico y lejano de la realidad";
                break;
            case "TrueOrFalse":
                textToShow = "Respuesta 1: Verdadero\n" +
                        "Respuesta 2: Falso\n" +
                        "Respuesta 3: Verdadero\n" +
                        "Respuesta 4: Falso\n" +
                        "Respuesta 5: Verdadero";
                break;
            case "DragAndSort":
                textToShow = "Posición 1: Margarita, te voy a contar  un cuento\n" +
                        "Posición 2: El rey tiene un palacio de diamantes\n" +
                        "Posición 3: La princesa vio una estrella brillar\n" +
                        "Posición 4: La niña sale en busca de la estrella\n" +
                        "Posición 5: El rey se enoja con la princesa\n" +
                        "Posición 6: El buen Jesús perdona a la princesa";
                break;
            case "Complete":
                textToShow = " -- Ejercicio 1 -- \n" +
                        "Rey , Diamante, Tienda, Elefantes, \n" +
                        "Kisoco, Manto, Princesita, Margarita\n" +
                        " -- Ejercicio 2 -- \n" +
                        "Princesa , Flor, Luz, \n" +
                        "Princesita, Prendedor, Estrella";
                break;
        }

        final Toast toast = Toast.makeText(context, textToShow, duration);
        toast.show();
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
                intent =  new Intent(ResultActivity.this, MainActivity.class);
                break;
            case R.id.read_poem:
                intent =  new Intent(ResultActivity.this, StoryActivity.class);
                break;
            case R.id.exercises:
                intent =  new Intent(ResultActivity.this, ExerciseActivity.class);
                break;
            case R.id.credits:
                intent =  new Intent(ResultActivity.this, ExerciseActivity.class);
                break;
        }

        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }
}
