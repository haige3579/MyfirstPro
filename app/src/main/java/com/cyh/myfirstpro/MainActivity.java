package com.cyh.myfirstpro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE ="com.cyh.myfirstpro.message" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
      *@cyh  页面跳转， 带参数
      * 
      *created at 2016/9/26 15:00
      */
    public void sendMessage(View v){
        Intent intent=new Intent(this,DisplayMessageActivity.class);
        EditText editText= (EditText) findViewById(R.id.edit_message);
        String message=editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE,message);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity_actions,menu);
        return super.onCreateOptionsMenu(menu);
    }

    //    为操作按钮添加相应事件
    public boolean onOptionsItemSelected(MenuItem item) {
       switch (item.getItemId()){
           case R.id.action_search:
               openSearch();
               return true;
           case R.id.action_settings:
               openSettings();
               return true;
           default:
               return super.onOptionsItemSelected(item);  
       }
    }

    private void openSettings() {
        Toast.makeText(this,"微微一笑很倾城",Toast.LENGTH_SHORT).show();
    }

    private void openSearch() {
        Toast.makeText(this,"Friends are lost by calling often and calling seldom",Toast.LENGTH_SHORT).show();
    }
}
