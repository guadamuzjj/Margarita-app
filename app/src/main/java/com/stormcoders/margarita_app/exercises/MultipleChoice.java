package com.stormcoders.margarita_app.exercises;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.stormcoders.margarita_app.CreditsActivity;
import com.stormcoders.margarita_app.R;
import com.stormcoders.margarita_app.ResultActivity;
import com.stormcoders.margarita_app.activity.MainActivity;
import com.stormcoders.margarita_app.story.StoryActivity;

import java.util.StringTokenizer;

public class MultipleChoice extends AppCompatActivity {

    Intent intent;
    TextView tvQuestion;
    RadioGroup rgOptions;
    RadioButton rbOption1;
    RadioButton rbOption2;
    RadioButton rbOption3;
    int qestionNumber;
    RelativeLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.multiple_choice);

        mainLayout = (RelativeLayout) findViewById(R.id.main_layout);
        tvQuestion = (TextView) findViewById(R.id.tvQuestion);
        rgOptions = (RadioGroup) findViewById(R.id.rgOptions);

        rbOption1 = (RadioButton) findViewById(R.id.rbOption1);
        rbOption2 = (RadioButton) findViewById(R.id.rbOption2);
        rbOption3 = (RadioButton) findViewById(R.id.rbOption3);

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
                intent =  new Intent(MultipleChoice.this, CreditsActivity.class);
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

        StringTokenizer tokens = new StringTokenizer(multiplChoices[index], "|");
        String question = tokens.nextToken();
        String options = tokens.nextToken();

        String[] option = options.split(",");

        tvQuestion.setText(question);
        rbOption1.setText(option[0]);
        rbOption2.setText(option[1]);
        rbOption3.setText(option[2]);
    }

    private void nextQuestion(Class classDest, int nQuestion, int correctIndex) {
        int actualOption;
        int prevOption;

        intent = new Intent(this, classDest);
        intent.putExtra("QESTION_NUMBER", nQuestion);
        actualOption = (rgOptions.indexOfChild(findViewById(rgOptions.getCheckedRadioButtonId())) == correctIndex ) ? 1: 0;
        prevOption = getIntent().getIntExtra("OPTION", 0);
        intent.putExtra("OPTION", prevOption + actualOption);

        int attempts = getIntent().getIntExtra("ATTEMPTS", 2);
        intent.putExtra("ATTEMPTS", attempts);
    }
}
