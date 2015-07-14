package com.stormcoders.margarita_app.story;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.stormcoders.margarita_app.story.FullScreenImageAdapter;
import com.stormcoders.margarita_app.story.Utils;
import com.stormcoders.margarita_app.R;

public class FullScreenViewActivity extends Activity{

	private Utils utils;
	private FullScreenImageAdapter adapter;
	private ViewPager viewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fullscreen_view);

		viewPager = (ViewPager) findViewById(R.id.pager);

		utils = new Utils(getApplicationContext());

		Intent i = getIntent();
		int position = i.getIntExtra("position", 0);

		adapter = new FullScreenImageAdapter(FullScreenViewActivity.this,
				utils.getFilePaths());

		viewPager.setAdapter(adapter);

		// displaying selected image first
		viewPager.setCurrentItem(position);
	}
}
