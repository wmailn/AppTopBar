package com.example.apptopbar;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * 自己封装的APP顶部的操作栏
 * <p>
 * 设置颜色或者图标，直接修改此类的源码，不提供set方法
 * <p>
 * 
 * 2016-04-05
 * </p>
 * 
 * @author WuMeng
 * @version 1.0
 * 
 */
public class AppTopBar extends RelativeLayout {

	/** 左右边距 - DP */
	private final int PADDING_SIZE = 10;
	/** 文字大小 - 默认SP，无需转换 */
	private final int TEXT_SIZE = 18;
	/** 整体背景的默认颜色 */
	private int BACKGROUND_COLOR = Color.parseColor("#F44A4A");
	/** 左右两边和中间标题的文字颜色 */
	private int TEXT_COLOR = Color.parseColor("#FFFFFF");
	/** 左上角返回键的默认图标 */
	private int ICON_LEFT = android.R.drawable.ic_menu_revert;
	/** 右上角的默认图标 */
	private int ICON_RIGHT = android.R.drawable.ic_input_add;

	// 所有子控件全为public，不封装为set/get方法，方便直接操作子控件
	/** 左边图片 - 返回按钮 */
	public ImageView leftImage;
	/** 右边按钮 */
	public ImageView rightImage;
	/** 左边文字 */
	public TextView leftText;
	/** 右边文字 */
	public TextView rightText;
	/** 标题栏 */
	public TextView titleText;
	/** 计算后的按钮的按钮内部填充间距 - 用来扩展可点击区域 */
	private int padding;
	/** 上下文对象 */
	private Context mContext;

	public AppTopBar(Context context) {
		super(context);
		initAppTopBar(context);
	}

	public AppTopBar(Context context, AttributeSet attrs) {
		super(context, attrs);
		initAppTopBar(context);
	}

	public AppTopBar(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		initAppTopBar(context);
	}

	/**
	 * 初始化AppTopBar
	 * 
	 * @param context
	 */
	private void initAppTopBar(Context context) {
		// 设置所有子元素竖直居中
		this.setGravity(Gravity.CENTER_VERTICAL);
		// 设置背景颜色
		this.setBackgroundColor(BACKGROUND_COLOR);
		// 设置Context
		this.mContext = context;
		// 获取左右边距
		padding = dip2px(PADDING_SIZE);

		// 标题栏
		titleText = new TextView(mContext);
		titleText.setGravity(Gravity.CENTER);
		// 单行
		titleText.setSingleLine(true);
		titleText.setText("Title");
		titleText.setTextColor(TEXT_COLOR);
		titleText.setTextSize(TEXT_SIZE);
		// 布局参数
		RelativeLayout.LayoutParams titleParams = new LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.MATCH_PARENT);
		titleParams.addRule(RelativeLayout.CENTER_IN_PARENT);
		addView(titleText, titleParams);
	}

	/**
	 * 增加左边按钮
	 */
	private void addLeftImage() {
		// 左边的图片 - 一般为返回按钮
		leftImage = new ImageView(mContext);
		// 设置Padding是为了增加可点击面积
		leftImage.setPadding(padding, padding, padding, padding);
		leftImage.setImageResource(ICON_LEFT);
		// 设置点击事件 - 默认为返回按钮
		// 调用页面中可以直接用AppTopBar.leftImage.setOnClickListener...执行自己的逻辑，此逻辑自动失效
		leftImage.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				((Activity) getContext()).finish();
			}
		});
		// 布局参数
		RelativeLayout.LayoutParams leftParams = new LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.MATCH_PARENT);
		leftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
		addView(leftImage, leftParams);
	}

	/**
	 * 增加左边文字
	 */
	private void addLeftText() {
		// 左边的文字
		leftText = new TextView(mContext);
		// 设置Padding是为了增加可点击面积且增加左右间距
		leftText.setPadding(padding, padding, padding, padding);
		leftText.setText("Left");
		leftText.setTextColor(TEXT_COLOR);
		leftText.setTextSize(TEXT_SIZE);
		// 布局参数
		RelativeLayout.LayoutParams leftParams = new LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.MATCH_PARENT);
		leftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
		addView(leftText, leftParams);
	}

	/**
	 * 增加右边文字
	 */
	private void addRightText() {
		// 右边的文字
		rightText = new TextView(mContext);
		// 设置Padding是为了增加可点击面积
		rightText.setPadding(padding, padding, padding, padding);
		rightText.setText("Right");
		rightText.setTextColor(TEXT_COLOR);
		rightText.setTextSize(TEXT_SIZE);
		// 布局参数
		RelativeLayout.LayoutParams rightParams = new LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.MATCH_PARENT);
		rightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
		addView(rightText, rightParams);
	}

	/**
	 * 增加右边按钮
	 */
	private void addRightImage() {
		// 右边的图片
		rightImage = new ImageView(mContext);
		// 设置Padding是为了增加可点击面积
		rightImage.setPadding(padding, padding, padding, padding);
		rightImage.setImageResource(ICON_RIGHT);
		// 布局参数
		RelativeLayout.LayoutParams rightParams = new LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.MATCH_PARENT);
		rightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
		addView(rightImage, rightParams);
	}

	/**
	 * 设置显示模式
	 * 
	 * @param mode
	 */
	public void setMode(Mode mode) {
		// 根据设置的模式显示对应组件
		switch (mode) {
		case LEFTIMAGE_TITLE:
			// 返回键 + 标题栏
			addLeftImage();
			break;
		case LEFTIMAGE_TITLE_RIGHTIMAGE:
			// 返回键 + 标题栏 + 右边图片
			addLeftImage();
			addRightImage();
			break;
		case LEFTIMAGE_TITLE_RIGHTTEXT:
			// 返回键 + 标题栏 + 右边文字
			addLeftImage();
			addRightText();
			break;
		case LEFTTEXT_TITLE_RIGHTTEXT:
			// 左边文字 + 标题栏 + 右边文字
			addLeftText();
			addRightText();
			break;
		default:
			break;
		}

	}

	/**
	 * 模式
	 * 
	 * @author WuMeng
	 * 
	 */
	public enum Mode {
		/** 返回键 + 标题栏 */
		LEFTIMAGE_TITLE,
		/** 返回键 + 标题栏 + 右边图片 */
		LEFTIMAGE_TITLE_RIGHTIMAGE,
		/** 返回键 + 标题栏 + 右边文字 */
		LEFTIMAGE_TITLE_RIGHTTEXT,
		/** 左边文字 + 标题栏 + 右边文字 */
		LEFTTEXT_TITLE_RIGHTTEXT;
	}

	/**
	 * 根据手机的分辨率从 DP 的单位 转成为 PX(像素)
	 */
	private int dip2px(float dpValue) {
		final float scale = getResources().getDisplayMetrics().density;
		return (int) (dpValue * scale + 0.5f);
	}

}
