package com.xmy.test.sqlitedemo;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @projectName: SQLiteDemo
 * @packageName: com.xmy.test.sqlitedemo
 * @className: BaseActivity
 * @author:xiamingyan
 * @time: 2017/1/19	11:01
 * @E-mail：xmydeveloper@163.com
 * @desc: TODO
 * @upDateAuthor: lenovo
 * @upDate: 2017/1/19
 * @upDateDesc: TODO
 */
public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
    }

    public static enum Position {
        LEFT, CENTER
    }

    public void setHeaderTitle(View headerView, String title, Position position) {
        TextView tv = (TextView) headerView.findViewById(R.id.tv_header_title);

        if (title == null) {
            tv.setText("TITLE");
        } else {
            tv.setText(title);
        }
        tv.setGravity(Gravity.CENTER);

    }

    public void setHeaderTitle(View headerView, String title) {
        setHeaderTitle(headerView, title, Position.CENTER);
    }

    public String getHeaderTitle(View headerView) {
        String title = "";
        TextView tv = (TextView) headerView.findViewById(R.id.tv_header_title);
        title = tv.getText().toString();
        return title;
    }

    public void setHeaderImage(View headerView, int resId, Position position,
                               View.OnClickListener listener) {
        ImageView iv = null;
        switch (position) {
            case LEFT:
                iv = (ImageView) headerView.findViewById(R.id.iv_header_left);
                iv.setVisibility(View.VISIBLE);
                break;

            default:
                iv = (ImageView) headerView.findViewById(R.id.iv_header_right);
                break;
        }
        iv.setImageResource(resId);
        iv.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);
        if (listener != null) {
            iv.setOnClickListener(listener);
        }
    }

    public void noHeaderImg(View headerView) {
        ImageView ivv = null;
        ivv = (ImageView) headerView.findViewById(R.id.iv_header_left);
        ivv.setVisibility(View.GONE);
    }

    public void setHeaderImage(View headerView, int resId, Position position) {
        setHeaderImage(headerView, resId, position, null);
    }


}
