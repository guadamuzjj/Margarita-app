package com.stormcoders.margarita_app;

import android.app.Activity;
import android.os.Build;
import android.util.Log;
import android.view.View;

import java.io.BufferedReader;

public class Utils {

    public static final String TAG = "ImmersiveModeFragment";

    /**
     * Detects and toggles immersive mode (also known as "hidey bar" mode). By Google
     * @param myActivityReference
     */
    public void toggleHideyBar(Activity myActivityReference) {

        int uiOptions = myActivityReference.getWindow().getDecorView().getSystemUiVisibility();
        int newUiOptions = uiOptions;
        boolean isImmersiveModeEnabled =
                ((uiOptions | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY) == uiOptions);
        if (isImmersiveModeEnabled) {
            Log.i(TAG, "Turning immersive mode mode off. ");
        } else {
            Log.i(TAG, "Turning immersive mode mode on.");
        }

        if (Build.VERSION.SDK_INT >= 14) {
            newUiOptions ^= View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        }

        if (Build.VERSION.SDK_INT >= 16) {
            newUiOptions ^= View.SYSTEM_UI_FLAG_FULLSCREEN;
        }

        if (Build.VERSION.SDK_INT >= 18) {
            newUiOptions ^= View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        }

        myActivityReference.getWindow().getDecorView().setSystemUiVisibility(newUiOptions);
    }
}
