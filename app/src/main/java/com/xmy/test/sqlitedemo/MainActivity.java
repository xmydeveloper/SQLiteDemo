package com.xmy.test.sqlitedemo;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends BaseActivity {

    private Button btnCreateTable;
    private Button mAdd;
    private Button updata;
    private Button delete;
    private Button query;
    private Button btnEditText;
    private View headerview;
    private Button btnBinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        btnCreateTable = (Button) findViewById(R.id.btn_create_table);
        mAdd = (Button) findViewById(R.id.add);
        updata = (Button) findViewById(R.id.update);
        delete = (Button) findViewById(R.id.delete);
        query = (Button) findViewById(R.id.query);
        btnEditText = (Button) findViewById(R.id.btn_edittext);
        headerview = findViewById(R.id.main_tittle);
        btnBinner = (Button) findViewById(R.id.btn_binner);



        initHeadView();


        final SQLHelper helper = new SQLHelper(this, "BookStore.db", null, 2);

        btnCreateTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helper.getWritableDatabase();
            }
        });


        mAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "插入数据成功！", Toast.LENGTH_SHORT).show();
                SQLiteDatabase db = helper.getReadableDatabase();
                ContentValues values = new ContentValues();

                //第一组
                values.put("author", "xiamingyan1");
                values.put("price", "100");
                values.put("pages", "500");
                values.put("name", "the first code");
                db.insert("book", null, values);

                values.clear();

                //第二组
                values.put("author", "xiamingyan2");
                values.put("price", "19.95");
                values.put("pages", "500");
                values.put("name", "the second code");
                db.insert("book", null, values);

            }
        });


        updata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "更新成功了！", Toast.LENGTH_SHORT).show();
                SQLiteDatabase db = helper.getReadableDatabase();
                ContentValues values = new ContentValues();
                values.put("price", "520");
                db.update("book", values, "name=?", new String[]{"the first code"});
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "删除数据成功！", Toast.LENGTH_SHORT).show();
                SQLiteDatabase db = helper.getWritableDatabase();
                db.delete("book", "price>?", new String[]{"500"});
            }
        });

        query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "查询成功！", Toast.LENGTH_SHORT).show();
                SQLiteDatabase db = helper.getWritableDatabase();
                Cursor cursor = db.query("book", null, null, null, null, null, null);
                if (cursor.moveToNext()) {

                    do {
                        String author = cursor.getString(cursor.getColumnIndex("author"));
                        String price = cursor.getString(cursor.getColumnIndex("price"));
                        String pages = cursor.getString(cursor.getColumnIndex("pages"));
                        String name = cursor.getString(cursor.getColumnIndex("name"));
                        Log.e("MainActivity", "author--------------" + author);
                        Log.e("MainActivity", "price--------------" + price);
                        Log.e("MainActivity", "pages--------------" + pages);
                        Log.e("MainActivity", "name--------------" + name);


                    } while (cursor.moveToNext());

                }
                cursor.close();


            }
        });


        btnEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditTextActivity.startEditTextActivity(MainActivity.this);
            }
        });


        btnBinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BinnerActivity.startActivity(MainActivity.this);
            }
        });


    }


    private void initHeadView() {
        setHeaderTitle(headerview, "测试");
        setHeaderImage(headerview, R.mipmap.ic_launcher, BaseActivity.Position.LEFT, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }





}
