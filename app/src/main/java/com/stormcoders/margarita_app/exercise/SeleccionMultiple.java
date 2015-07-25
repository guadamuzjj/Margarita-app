package com.stormcoders.margarita_app.exercise;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.WindowManager;

import com.stormcoders.margarita_app.R;
import com.stormcoders.margarita_app.Utils;

public class SeleccionMultiple extends ActionBarActivity {
    Utils utils = new Utils();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.seleccion_multiple);
        utils.toggleHideyBar(this);
    }
}
