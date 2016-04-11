package com.example.apptopbar.example;

import android.os.Bundle;

import com.example.apptopbar.AppTopBar.Mode;
import com.example.apptopbar.BaseActivity;
import com.example.apptopbar.R;

public class LeftImageTitleActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mAppTopBar.titleText.setText("LeftImageTitle");

		// ·µ»Ø¼ü + ±êÌâÀ¸
		mAppTopBar.setMode(Mode.LEFTIMAGE_TITLE);

	}

}
