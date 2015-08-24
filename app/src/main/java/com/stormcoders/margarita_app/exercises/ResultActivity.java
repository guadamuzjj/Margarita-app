package com.stormcoders.margarita_app.exercises;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.stormcoders.margarita_app.R;
import com.stormcoders.margarita_app.activity.MainActivity;
import com.stormcoders.margarita_app.exercises.drag_and_sort.DragAndSort;
import com.stormcoders.margarita_app.story.StoryActivity;

public class ResultActivity  extends ActionBarActivity {

    final int ExerciseAnswers = 5;
    int attempts;
    TextView tvResult;
    ImageView ivResult;
    Button btFinish;
    String prevActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.result_activity);
        Log.i("ATTEMPTS Received", getIntent().getIntExtra("ATTEMPTS", 3) + "");
        attempts = getIntent().getIntExtra("ATTEMPTS", 3);
        tvResult = (TextView) findViewById(R.id.tvResult);
        ivResult = (ImageView) findViewById(R.id.ivResult);
        btFinish = (Button) findViewById(R.id.btFinish);

        int countOptions = getIntent().getIntExtra("OPTION", 0);
        prevActivity = getIntent().getStringExtra("FROM");

        if(countOptions == ExerciseAnswers) {
            tvResult.setText("Lo Lograste");
            ivResult.setImageResource(R.drawable.medalla);
        }
        else {
            tvResult.setText("Inténtalo de nuevo");
            btFinish.setVisibility(View.VISIBLE);
        }
    }

    public void tryAgain(View view) {
        attempts = attempts - 1;

        Log.i("ATTEMPTS onClick", attempts + "");
        Intent intent = new Intent();

        switch (prevActivity) {
            case "MultipleChoice":
                intent = new Intent(ResultActivity.this, MultipleChoice.class);
                break;
            case "TrueOrFalse":
                intent = new Intent(ResultActivity.this, TrueOrFalse.class);
                break;
            case "SortEvents":
                intent = new Intent(ResultActivity.this, DragAndSort.class);
                break;
        }

        intent.putExtra("ATTEMPTS", attempts);
        startActivity(intent);
    }

    public void goBack(View view) {
        Intent intent = new Intent(ResultActivity.this, ExerciseActivity.class);
        startActivity(intent);
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
