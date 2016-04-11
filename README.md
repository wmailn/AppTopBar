# AppTopBar
自己封装的一个简单的APP顶部视图，注释很详细调用方法很简单


就一个类文件，直接拷贝到自己项目中；

XML中：
   <com.example.apptopbar.AppTopBar
        android:id="@+id/mAppTopBar"
        android:layout_width="match_parent"
        android:layout_height="50dp" />

代码中：
AppTopBar mAppTopBar = (AppTopBar) findViewById(R.id.mAppTopBar);

调用显示模式：
// 返回键 + 标题栏
mAppTopBar.setMode(Mode.LEFTIMAGE_TITLE);
// 返回键 + 标题栏 + 右边图片
mAppTopBar.setMode(Mode.LEFTIMAGE_TITLE_RIGHTIMAGE);
// 返回键 + 标题栏 + 右边文字
mAppTopBar.setMode(Mode.LEFTIMAGE_TITLE_RIGHTTEXT);
// 左边文字 + 标题栏 + 右边文字
mAppTopBar.setMode(Mode.LEFTTEXT_TITLE_RIGHTTEXT);

