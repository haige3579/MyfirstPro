package com.cyh.alertdialogtool;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Dialog dialog=null;
    String[] items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);
        findViewById(R.id.button5).setOnClickListener(this);
        items=getResources().getStringArray(R.array.hobby);
    }

    @Override
    public void onClick(View view) {
     switch (view.getId()){
         case R.id.button:
             System.out.println("1");
             dialog=DialogTool.createNormalDialog(this, R.mipmap.ic_launcher, "普通对话框",
                     "微微一笑很倾城", R.string.app_name, new DialogInterface.OnClickListener() {
                         @Override
                         public void onClick(DialogInterface dialogInterface, int i) {
                             Toast.makeText(MainActivity.this,"Hello World",Toast.LENGTH_SHORT).show();
                         }
                     }, null, null);
             dialog.show();
             break;
         case R.id.button2:
             System.out.println("2");
             dialog=DialogTool.createNormalDialog(this, R.mipmap.ic_launcher, "普通对话框",
                     "微微一笑很倾城", R.string.app_name, new DialogInterface.OnClickListener() {
                         @Override
                         public void onClick(DialogInterface dialogInterface, int i) {
                             Toast.makeText(MainActivity.this,"Hello World",Toast.LENGTH_SHORT).show();
                         }
                     }, R.string.app_name, null);
             dialog.show();
//             DialogTool.createListDialog(this, R.mipmap.ic_launcher, "列表对话框",
//                     R.array.hobby, new DialogInterface.OnClickListener() {
//                         @Override
//                         public void onClick(DialogInterface dialogInterface, int i) {
//                             Toast.makeText(MainActivity.this,"Hello World",Toast.LENGTH_SHORT).show();
//                         }
//                     }).show();
             break;
         case R.id.button3:
             System.out.println("3");
             DialogTool.createRadioDialog(this, R.mipmap.ic_launcher, "单选对话框",
                     R.array.hobby, new DialogInterface.OnClickListener() {
                         @Override
                         public void onClick(DialogInterface dialogInterface, int i) {
                             Toast.makeText(MainActivity.this,"Hello World;"+items[i],Toast.LENGTH_SHORT).show();
                         }
                     }, "取消", null).show();
             break;
         case R.id.button4:
             System.out.println("4");
             final boolean [] flags=new boolean[]{false,true,false,true};
             DialogTool.createCheckBoxDialog(this, R.mipmap.ic_launcher, "复选对话框",
                     R.array.hobby, new DialogInterface.OnMultiChoiceClickListener(){
                         @Override
                         public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                             flags[i]=b;
                             String result="你选择了：";
                                 if (flags[i]) {
                                     result = result + items[i] + ",";
                             }
                             Toast.makeText(MainActivity.this,"Hello World;"+result,Toast.LENGTH_SHORT).show();
                         }
                     }, flags,"确定", new DialogInterface.OnClickListener() {
                         @Override
                         public void onClick(DialogInterface dialogInterface, int i) {
                             Toast.makeText(MainActivity.this,"Hello World",Toast.LENGTH_SHORT).show();
                         }
                     },"取消",null).show();
             break;
         case R.id.button5:
             System.out.println("5");
             final TextView textView=new TextView(this);
             textView.setText("微微一笑很倾城");
             textView.setTextSize(44);
             DialogTool.createMyDialog(this, R.mipmap.ic_launcher, "自定义对话框",
                      textView,"确定", new DialogInterface.OnClickListener() {
                         @Override
                         public void onClick(DialogInterface dialogInterface, int i) {
                             Toast.makeText(MainActivity.this,"Hello "+textView.toString(),Toast.LENGTH_SHORT).show();
                         }
                     }, "取消", null).show();
             break;

     }
    }
}
