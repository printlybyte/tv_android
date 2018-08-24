package com.hjjy.tv_android;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity implements   View.OnFocusChangeListener {

    /**
     * 1
     */
    private Button mBtn1;
    /**
     * 2
     */
    private Button mBtn2;
    /**
     * 3
     */
    private Button mBtn3;
    /**
     * 4
     */
    private Button mBtn4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFormat(PixelFormat.TRANSLUCENT);
        try {
            if (Integer.parseInt(android.os.Build.VERSION.SDK) >= 11) {
                getWindow()
                        .setFlags(
                                android.view.WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED,
                                android.view.WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED);
            }
        } catch (Exception e) {
        }

        setContentView(R.layout.activity_main2);


        initView();

    }

    private void initView() {

        mBtn1 = (Button) findViewById(R.id.btn1);
        mBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity2.this, JiaoHhaoActivity.class));
            }
        });
        mBtn1.setOnFocusChangeListener(this);
        mBtn2 = (Button) findViewById(R.id.btn2);

        mBtn2.setOnFocusChangeListener(this);
        mBtn3 = (Button) findViewById(R.id.btn3);
        mBtn3.setOnFocusChangeListener(this);
        mBtn4 = (Button) findViewById(R.id.btn4);
        mBtn4.setOnFocusChangeListener(this);
    }



    @SuppressLint("ResourceAsColor")
    @Override
    public void onFocusChange(View view, boolean b) {
        switch (view.getId()) {
            default:
                break;
            case R.id.btn1:
                if (b) {
                    mBtn1.setText("叫号系统");
                    mBtn1.setBackgroundColor(Color.parseColor("#FF4081"));
                } else {
                    mBtn1.setText("叫号系统");
                    mBtn1.setBackgroundColor(Color.parseColor("#bebebe"));
                }
                break;
            case R.id.btn2:
                if (b) {
                    mBtn2.setText("刷新刷新");
                    mBtn2.setBackgroundColor(Color.parseColor("#FF4081"));
                } else {
                    mBtn2.setText("刷新刷新");
                    mBtn2.setBackgroundColor(Color.parseColor("#bebebe"));
                }
                break;
            case R.id.btn3:
                if (b) {
                    mBtn3.setText("其他系统");

                    mBtn3.setBackgroundColor(Color.parseColor("#FF4081"));
                } else {
                    mBtn3.setText("其他系统");
                    mBtn3.setBackgroundColor(Color.parseColor("#bebebe"));
                }
                break;
            case R.id.btn4:
                if (b) {
                    mBtn4.setText("视频视频");
                    showtoast("点击其他系统");
                    mBtn4.setBackgroundColor(Color.parseColor("#FF4081"));
                } else {
                    mBtn4.setText("视频视频");
                    mBtn4.setBackgroundColor(Color.parseColor("#bebebe"));
                }
                break;
        }
    }

    private void showtoast(String msg) {
        Toast.makeText(this, "" + msg, Toast.LENGTH_SHORT).show();
    }





//    private void initProgressBar() {
//        mPageLoadingProgressBar = (ProgressBar) findViewById(R.id.progressBar1);// new
//        // ProgressBar(getApplicationContext(),
//        // null,
//        // android.R.attr.progressBarStyleHorizontal);
//        mPageLoadingProgressBar.setMax(100);
//        mPageLoadingProgressBar.setProgressDrawable(this.getResources()
//                .getDrawable(R.drawable.color_progressbar));
//    }


}
