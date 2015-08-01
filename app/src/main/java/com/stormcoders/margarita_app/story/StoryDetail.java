package com.stormcoders.margarita_app.story;

/**
 * Created by oscarmcm on 25/7/15.
 */
import android.os.Bundle;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.stormcoders.margarita_app.R;

/**
 * Actividad que muestra la imagen del item extendida
 */
public class StoryDetail extends ActionBarActivity {

    public static final String EXTRA_PARAM_ID = "com.stormcoders.margarita_app.extra.ID";
    public static final String VIEW_NAME_HEADER_IMAGE = "imagen_compartida";
    private Chapter itemDetail;
    private ImageView extendedImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_detail);

        // Obtener el chapter con el identificador establecido en la actividad principal
        itemDetail = Chapter.getItem(getIntent().getIntExtra(EXTRA_PARAM_ID, 0));

        extendedImage = (ImageView) findViewById(R.id.extended_image);

        loadExtendedImage();
    }

    private void loadExtendedImage() {
        Glide.with(extendedImage.getContext())
                .load(itemDetail.getIdDrawable())
                .into(extendedImage);
    }
}