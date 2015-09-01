package com.stormcoders.margarita_app.exercises;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.stormcoders.margarita_app.CreditsActivity;
import com.stormcoders.margarita_app.R;
import com.stormcoders.margarita_app.ResultActivity;
import com.stormcoders.margarita_app.activity.MainActivity;
import com.stormcoders.margarita_app.story.StoryActivity;

public class TrueOrFalse extends AppCompatActivity {

    Intent intent;
    TextView tvAffirmation;
    RadioGroup rgOptions;
    int affirmationNumber;
    RelativeLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.true_or_false);

        mainLayout = (RelativeLayout) findViewById(R.id.main_layout);
        tvAffirmation = (TextView) findViewById(R.id.tvAffirmation);
        rgOptions = (RadioGroup) findViewById(R.id.rgOptionsTrueOrFalse);

        affirmationNumber = getIntent().getIntExtra("AFFIRMATION", 1);

        switch (affirmationNumber) {
            case 1: getAffirmation(0); break;
            case 2: getAffirmation(1); break;
            case 3: getAffirmation(2); break;
            case 4: getAffirmation(3); break;
            case 5: getAffirmation(4); break;
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
                intent =  new Intent(TrueOrFalse.this, MainActivity.class);
                break;
            case R.id.read_poem:
                intent =  new Intent(TrueOrFalse.this, StoryActivity.class);
                break;
            case R.id.exercises:
                intent =  new Intent(TrueOrFalse.this, ExerciseActivity.class);
                break;
            case R.id.credits:
                intent =  new Intent(TrueOrFalse.this, CreditsActivity.class);
                break;
        }

        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }

    public void start(View view) {

        switch (affirmationNumber) {
            case 1:
                nextAffirmation(TrueOrFalse.class, 2, 0);
                break;
            case 2:
                nextAffirmation(TrueOrFalse.class, 3, 1);
                break;
            case 3:
                nextAffirmation(TrueOrFalse.class, 4, 0);
                break;
            case 4:
                nextAffirmation(TrueOrFalse.class, 5, 1);
                break;
            case 5:
                nextAffirmation(ResultActivity.class, 6, 0);
                intent.putExtra("FROM", "TrueOrFalse");
                break;
            default:
                intent = new Intent(this, ResultActivity.class);
                break;
        }

        startActivity(intent);
    }
    
    private void getAffirmation(int index) {
        String[] affirmations = getResources().getStringArray(R.array.affirmations);

        String affirmation = affirmations[index];
        tvAffirmation.setText(affirmation);
    }

    private void nextAffirmation(Class classDest, int nAffirmation, int correctIndex) {
        int actualOption;
        int prevOption;

        intent = new Intent(this, classDest);
        intent.putExtra("AFFIRMATION", nAffirmation);

        actualOption = (rgOptions.indexOfChild(findViewById(rgOptions.getCheckedRadioButtonId())) == correctIndex ) ? 1: 0;
        prevOption = getIntent().getIntExtra("OPTION", 0);
        intent.putExtra("OPTION", prevOption + actualOption);

        int attempts = getIntent().getIntExtra("ATTEMPTS", 2);
        intent.putExtra("ATTEMPTS", attempts);
    }
}
