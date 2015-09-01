package com.stormcoders.margarita_app.exercises.drag_and_sort;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.stormcoders.margarita_app.CreditsActivity;
import com.stormcoders.margarita_app.R;
import com.stormcoders.margarita_app.activity.MainActivity;
import com.stormcoders.margarita_app.exercises.ExerciseActivity;
import com.stormcoders.margarita_app.ResultActivity;
import com.stormcoders.margarita_app.story.StoryActivity;


public class DragAndSort extends AppCompatActivity {
    private static final String FRAGMENT_TAG_DATA_PROVIDER = "data provider";
    private static final String FRAGMENT_LIST_VIEW = "list view";

    TextView tv;
    TextView tv1;
    TextView tv2;
    TextView tv3;
    TextView tv4;
    TextView tv5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drag_and_sort);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(new DataProviderFragment(), FRAGMENT_TAG_DATA_PROVIDER)
                    .commit();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new RecyclerListViewFragment(), FRAGMENT_LIST_VIEW)
                    .commit();
        }
    }

    public AbstractDataProvider getDataProvider() {
        final Fragment fragment = getSupportFragmentManager().findFragmentByTag(FRAGMENT_TAG_DATA_PROVIDER);
        return ((DataProviderFragment) fragment).getDataProvider();
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
                intent =  new Intent(DragAndSort.this, MainActivity.class);
                break;
            case R.id.read_poem:
                intent =  new Intent(DragAndSort.this, StoryActivity.class);
                break;
            case R.id.exercises:
                intent =  new Intent(DragAndSort.this, ExerciseActivity.class);
                break;
            case R.id.credits:
                intent =  new Intent(DragAndSort.this, CreditsActivity.class);
                break;
        }

        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }

    public void evaluate(View v) {
        int actualOption = 0;

        tv = (TextView) findViewById(0);
        tv1 = (TextView) findViewById(1);
        tv2= (TextView) findViewById(2);
        tv3 = (TextView) findViewById(3);
        tv4 = (TextView) findViewById(4);
        tv5 = (TextView) findViewById(5);

        String txt = tv.getText().toString();
        String txt1 = tv1.getText().toString();
        String txt2 = tv2.getText().toString();
        String txt3 = tv3.getText().toString();
        String txt4 = tv4.getText().toString();
        String txt5 = tv5.getText().toString();

        if (isCorrect(txt, 0) && isCorrect(txt1, 1) && isCorrect(txt2, 2) && isCorrect(txt2, 2)
                && isCorrect(txt3, 3) && isCorrect(txt4, 4) && isCorrect(txt5, 5)) {
            actualOption = 6;
        }

        Intent intent = new Intent(this, ResultActivity.class);

        intent.putExtra("OPTION", actualOption);
        intent.putExtra("FROM", "DragAndSort");

        int attempts = getIntent().getIntExtra("ATTEMPTS", 2);
        intent.putExtra("ATTEMPTS", attempts);

        startActivity(intent);
    }

    public boolean isCorrect(String choice, int index) {
        String[] items = getResources().getStringArray(R.array.drag_and_sort_answer);
        String item = items[index];

        Log.i("MyTAG", choice.equals(item) + "");
        return choice.equals(item);
    }
}
