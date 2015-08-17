package com.stormcoders.margarita_app.exercise;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.stormcoders.margarita_app.ColorLibrary;
import com.stormcoders.margarita_app.R;
import com.stormcoders.margarita_app.activity.MainActivity;
import com.stormcoders.margarita_app.story.StoryActivity;

import java.util.StringTokenizer;

public class MultipleChoice extends ActionBarActivity {

    private ColorLibrary colors = new ColorLibrary();

    Intent intent;
    TextView tvQuestion;
    RadioGroup rgOptions;
    RadioButton rbOption1;
    RadioButton rbOption2;
    RadioButton rbOption3;
    int prevOption;
    int option;
    int qestionNumber;
    RelativeLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.multiple_choice);

        int color = colors.getColor();

        mainLayout = (RelativeLayout) findViewById(R.id.main_layout);
        tvQuestion = (TextView) findViewById(R.id.tvQuestion);
        rgOptions = (RadioGroup) findViewById(R.id.rgOptions);

        rbOption1 = (RadioButton) findViewById(R.id.rbOption1);
        rbOption2 = (RadioButton) findViewById(R.id.rbOption2);
        rbOption3 = (RadioButton) findViewById(R.id.rbOption3);
        mainLayout.setBackgroundColor(color);

        qestionNumber = getIntent().getIntExtra("QESTION_NUMBER", 1);

        switch (qestionNumber) {
            case 1: getQuestion(0); break;
            case 2: getQuestion(1); break;
            case 3: getQuestion(2); break;
            case 4: getQuestion(3); break;
            case 5: getQuestion(4); break;
        }
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
                intent =  new Intent(MultipleChoice.this, MainActivity.class);
                break;
            case R.id.read_poem:
                intent =  new Intent(MultipleChoice.this, StoryActivity.class);
                break;
            case R.id.exercises:
                intent =  new Intent(MultipleChoice.this, ExerciseActivity.class);
                break;
            case R.id.credits:
                intent =  new Intent(MultipleChoice.this, ExerciseActivity.class);
                break;
        }

        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }

    public void start(View view) {

        switch (qestionNumber) {
            case 1:
                nextQuestion(MultipleChoice.class, 2, 0);
                break;
            case 2:
                nextQuestion(MultipleChoice.class, 3, 2);
                break;
            case 3:
                nextQuestion(MultipleChoice.class, 4, 1);
                break;
            case 4:
                nextQuestion(MultipleChoice.class, 5, 2);
                break;
            case 5:
                nextQuestion(ResultActivity.class, 6, 0);
                intent.putExtra("FROM", "MultipleChoice");
                break;
            default:
                intent = new Intent(this, ResultActivity.class);
                break;
        }

        startActivity(intent);
    }

    private void getQuestion(int index) {
        String[] multiplChoices = getResources().getStringArray(R.array.multiple_choices);

        for(int i=0; i < 1; i++){
            StringTokenizer tokens = new StringTokenizer(multiplChoices[index], "|");
            String question = tokens.nextToken();
            String options = tokens.nextToken();

            String[] option = options.split(",");

            tvQuestion.setText(question);
            rbOption1.setText(option[0]);
            rbOption2.setText(option[1]);
            rbOption3.setText(option[2]);
        }
    }

    private void nextQuestion(Class classDest, int nQuestion, int correctIndex) {
        intent = new Intent(this, classDest);
        intent.putExtra("QESTION_NUMBER", nQuestion);
        option = (rgOptions.indexOfChild(findViewById(rgOptions.getCheckedRadioButtonId())) == correctIndex ) ? 1: 0;
        prevOption = getIntent().getIntExtra("OPTION", 0);
        intent.putExtra("OPTION", option + prevOption);

        int attempts = getIntent().getIntExtra("ATTEMPTS", 3);
        intent.putExtra("ATTEMPTS", attempts);
    }
}
