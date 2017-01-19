package com.xmy.test.sqlitedemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

/**
 * @projectName: SQLiteDemo
 * @packageName: com.xmy.test.sqlitedemo
 * @className: EditTextActivity
 * @author:xiamingyan
 * @time: 2017/1/19	10:40
 * @E-mail：xmydeveloper@163.com
 * @desc: TODO
 * @upDateAuthor: lenovo
 * @upDate: 2017/1/19
 * @upDateDesc: TODO
 */
public class EditTextActivity extends AppCompatActivity {
    public static void startEditTextActivity(Context context) {
        Intent intent = new Intent();
        intent.setClass(context, EditTextActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.edittext_view);


    }
}
