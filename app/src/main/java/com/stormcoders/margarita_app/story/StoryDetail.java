package com.stormcoders.margarita_app.story;

/**
 * Created by oscarmcm on 25/7/15.
 */
import android.os.Bundle;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;
import android.media.MediaPlayer;

import com.bumptech.glide.Glide;
import com.stormcoders.margarita_app.R;

import java.io.IOException;

/**
 * Actividad que muestra la imagen del item extendida
 */
public class StoryDetail extends ActionBarActivity {

    public static final String EXTRA_PARAM_ID = "com.stormcoders.margarita_app.extra.ID";
    public static final String VIEW_NAME_HEADER_IMAGE = "imagen_compartida";
    private Chapter itemDetail;
    private ImageView extendedImage;
    private TextView extendedText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_detail);

        // Obtener el chapter con el identificador establecido en la actividad principal
        itemDetail = Chapter.getItem(getIntent().getIntExtra(EXTRA_PARAM_ID, 0));

        extendedImage = (ImageView) findViewById(R.id.extended_image);
        extendedText = (TextView) findViewById(R.id.extended_text);

        loadExtendedImage();

        // Hard coded because who cares? I'm a hacker XD

        if (itemDetail.getName() == "Cap 1") {
            extendedText.setText(R.string.cap_1);
            playAudio("cap_1");
        }
        else if (itemDetail.getName() == "Cap 2") {
            extendedText.setText(R.string.cap_2);
            playAudio("cap_2");
        }
        else if (itemDetail.getName() == "Cap 3") {
            extendedText.setText(R.string.cap_3);
            playAudio("cap_3");
        }
        else if (itemDetail.getName() == "Cap 4") {
            extendedText.setText(R.string.cap_4);
            playAudio("cap_4");
        }
        else if (itemDetail.getName() == "Cap 5") {
            extendedText.setText(R.string.cap_5);
            playAudio("cap_5");
        }
        else if (itemDetail.getName() == "Cap 6") {
            extendedText.setText(R.string.cap_6);
            playAudio("cap_6");
        }
        else if (itemDetail.getName() == "Cap 7") {
            extendedText.setText(R.string.cap_7);
            playAudio("cap_7");
        }
        else if (itemDetail.getName() == "Cap 8") {
            extendedText.setText(R.string.cap_8);
            playAudio("cap_8");
        }
        else {
            extendedText.setText(R.string.cap_9);
            playAudio("cap_9");
        }

    }

    private void loadExtendedImage() {
        Glide.with(extendedImage.getContext())
                .load(itemDetail.getIdDrawable())
                .into(extendedImage);
    }

    private void playAudio(String name) {
        int resID = getResources().getIdentifier(name, "raw", getPackageName());
        MediaPlayer mediaPlayer = MediaPlayer.create(this, resID);
        if (mediaPlayer.isPlaying())
            mediaPlayer.stop();
        else
            mediaPlayer.start();
    }

}