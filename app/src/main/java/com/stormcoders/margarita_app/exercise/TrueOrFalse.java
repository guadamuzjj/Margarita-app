package com.stormcoders.margarita_app.exercise;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.stormcoders.margarita_app.R;
import com.stormcoders.margarita_app.Utils;

public class TrueOrFalse extends ActionBarActivity {
    Utils utils = new Utils();

    Intent intent;
    TextView tvAffirmation;
    RadioGroup rgOptions;
    int prevOption;
    int option;
    int affirmationNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.true_or_false);
        utils.toggleHideyBar(this);

        tvAffirmation = (TextView) findViewById(R.id.tvAffirmation);
        rgOptions = (RadioGroup) findViewById(R.id.rgOptions);

        affirmationNumber = getIntent().getIntExtra("AFFIRMATION", 1);

        switch (affirmationNumber) {
            case 1: getAffirmation(0); break;
            case 2: getAffirmation(1); break;
            case 3: getAffirmation(2); break;
            case 4: getAffirmation(3); break;
            case 5: getAffirmation(4); break;
        }
    }

    public void start(View view) {
        switch (affirmationNumber) {
            case 1:
                nextAffirmation(TrueOrFalse.class, 2, 1);
                break;
            case 2:
                nextAffirmation(TrueOrFalse.class, 3, 2);
                break;
            case 3:
                nextAffirmation(TrueOrFalse.class, 4, 1);
                break;
            case 4:
                nextAffirmation(TrueOrFalse.class, 5, 2);
                break;
            case 5:
                nextAffirmation(ResultActivity.class, 6, 1);
                intent = new Intent(this, ResultActivity.class);
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

        for(int i=0; i < 1; i++){
            String affirmation = affirmations[index];
            tvAffirmation.setText(affirmation);
        }
    }

    private void nextAffirmation(Class classDest, int nAffirmation, int correctIndex) {
        intent = new Intent(this, classDest);
        intent.putExtra("AFFIRMATION", nAffirmation);
        option = (rgOptions.indexOfChild(findViewById(rgOptions.getCheckedRadioButtonId())) == correctIndex ) ? 1: 0;
        prevOption = getIntent().getIntExtra("OPTION", 0);
        intent.putExtra("OPTION", option + prevOption);
    }
}
