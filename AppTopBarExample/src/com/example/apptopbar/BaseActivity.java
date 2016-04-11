package com.example.apptopbar;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * 继承BaseActivity的Activity可以直接显示并操作AppTopBar
 * <p>
 * 
 * 2016-04-05
 * </p>
 * 
 * @author WuMeng
 * @version 1.0
 * 
 */
public class BaseActivity extends Activity {

	/** 顶部栏 */
	public AppTopBar mAppTopBar;
	/** 承载父类中的AppTopBar和子类的XML的两个布局 */
	private LinearLayout parentLinearLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initContentView(R.layout.layout_app_top_bar);
	}

	/**
	 * 初始化ContentView
	 */
	private void initContentView(int layoutResID) {
		ViewGroup viewGroup = (ViewGroup) findViewById(android.R.id.content);
		viewGroup.removeAllViews();
		parentLinearLayout = new LinearLayout(this);
		parentLinearLayout.setOrientation(LinearLayout.VERTICAL);
		viewGroup.addView(parentLinearLayout);
		LayoutInflater.from(this).inflate(layoutResID, parentLinearLayout, true);
		// INIT AppTopBar
		mAppTopBar = (AppTopBar) findViewById(R.id.mAppTopBar);
	}

	@Override
	public void setContentView(int layoutResID) {
		LayoutInflater.from(this).inflate(layoutResID, parentLinearLayout, true);
	}

	@Override
	public void setContentView(View view) {
		parentLinearLayout.addView(view);
	}

	@Override
	public void setContentView(View view, ViewGroup.LayoutParams params) {
		parentLinearLayout.addView(view, params);
	}

}
