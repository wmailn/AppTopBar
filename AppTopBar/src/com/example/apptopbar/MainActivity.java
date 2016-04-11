package com.example.apptopbar;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.example.apptopbar.AppTopBar.Mode;

public class MainActivity extends Activity {

	private AppTopBar mAppTopBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mAppTopBar = (AppTopBar) findViewById(R.id.mAppTopBar);

		findViewById(R.id.leftimage_title).setOnClickListener(mOnClickListener);
		findViewById(R.id.leftimage_title_rightimage).setOnClickListener(mOnClickListener);
		findViewById(R.id.leftimage_title_righttext).setOnClickListener(mOnClickListener);
		findViewById(R.id.lefttext_title_righttext).setOnClickListener(mOnClickListener);
	}

	private OnClickListener mOnClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {

			switch (v.getId()) {
			case R.id.leftimage_title:
				// 返回键 + 标题栏
				mAppTopBar.setMode(Mode.LEFTIMAGE_TITLE);
				break;
			case R.id.leftimage_title_rightimage:
				// 返回键 + 标题栏 + 右边图片
				mAppTopBar.setMode(Mode.LEFTIMAGE_TITLE_RIGHTIMAGE);
				break;
			case R.id.leftimage_title_righttext:
				// 返回键 + 标题栏 + 右边文字
				mAppTopBar.setMode(Mode.LEFTIMAGE_TITLE_RIGHTTEXT);
				break;
			case R.id.lefttext_title_righttext:
				// 左边文字 + 标题栏 + 右边文字
				mAppTopBar.setMode(Mode.LEFTTEXT_TITLE_RIGHTTEXT);
				break;

			default:
				break;
			}
		}
	};

}
