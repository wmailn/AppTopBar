package com.example.apptopbar.example;

import android.os.Bundle;

import com.example.apptopbar.AppTopBar.Mode;
import com.example.apptopbar.BaseActivity;
import com.example.apptopbar.R;

public class LeftTextTitleRightTextActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mAppTopBar.titleText.setText("LeftTextTitleRightText");

		// 左边文字 + 标题栏 + 右边文字
		mAppTopBar.setMode(Mode.LEFTTEXT_TITLE_RIGHTTEXT);
	}

}
