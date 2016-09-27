package com.cyh.myfirstpro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        接收intent
        Intent intent=getIntent();
        String message=intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
//        设置显示文本
        TextView textView=new TextView(this);
        textView.setTextSize(40);
        textView.setText(message);
//        设置activity视图
        setContentView(textView);
//        添加向上按钮
//      getActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
