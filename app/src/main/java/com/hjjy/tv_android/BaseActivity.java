package com.hjjy.tv_android;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public abstract class BaseActivity extends AppCompatActivity {
    protected boolean mCheckNetWork = true; //默认检查网络状态
    private Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initWidows();
        int layId = getContentLayoutId();
        setContentView(layId);
        AppManager.getInstance().addActivity(this); //添加到栈中
//设置 paddingTop
        ViewGroup rootView = (ViewGroup) getWindow().getDecorView().findViewById(android.R.id.content);
        rootView.setPadding(0, 0, 0, 0);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //5.0 以上直接设置状态栏颜色
            getWindow().setStatusBarColor(Color.parseColor("#353439"));
        } else {
            //根布局添加占位状态栏
            ViewGroup decorView = (ViewGroup) getWindow().getDecorView();
            View statusBarView = new View(this);
            ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    getStatusBarHeight());
            statusBarView.setBackgroundColor(Color.parseColor("#353439"));
            decorView.addView(statusBarView, lp);
        }


        //        BarUtils.setStatusBarColor(this, Color.parseColor("#353439"));
//        BarUtils.setStatusBarAlpha(this, 220);
        mContext = this;
        getSupportActionBar().hide();

    }


    /**
     * 利用反射获取状态栏高度
     *
     * @return
     */
    public int getStatusBarHeight() {
        int result = 0;
        //获取状态栏高度的资源id
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }


    protected void initWidows() {
        //设置屏幕适配 360为设计图尺寸px/2
        if (ScreenUtils.isPortrait()) {
            ScreenUtils.adaptScreen4VerticalSlide(this, 1000);
            Log.i("initWidows", "adaptScreen4VerticalSlide");
        } else {
            ScreenUtils.adaptScreen4HorizontalSlide(this, 1000);
            Log.i("initWidows", "adaptScreen4HorizontalSlide");
        }

    }

    protected abstract int getContentLayoutId();

    public void showToast(String msg) {
        Toast.makeText(this, "" + msg, Toast.LENGTH_SHORT).show();
    }




    private void hasNetWork(boolean has) {
        if (isCheckNetWork()) {
            if (!has) {
                showToast("网络链接异常");
            } else {
//                showToastC("网络链接恢复");
            }
        }
    }

    public void setCheckNetWork(boolean checkNetWork) {
        mCheckNetWork = checkNetWork;
    }

    public boolean isCheckNetWork() {
        return mCheckNetWork;
    }


    @Override
    protected void onDestroy() {
        AppManager.getInstance().finishActivity(this); //从栈中移除
        Log.i("qweqwe", "baseactivity 退出监听");
        super.onDestroy();

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

}
