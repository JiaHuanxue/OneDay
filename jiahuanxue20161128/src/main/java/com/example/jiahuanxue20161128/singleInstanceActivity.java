package com.example.jiahuanxue20161128;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class singleInstanceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_instance);
        Button button_singleTop = (Button) findViewById(R.id.singleTop);
        button_singleTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(singleInstanceActivity.this,singleTopActivity.class);
                startActivity(intent);
            }
        });
        Button button_singleTask = (Button) findViewById(R.id.singleTask);
        button_singleTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(singleInstanceActivity.this,singleTaskActivity.class);
                startActivity(intent);
            }
        });
        Button button_singleInstance = (Button) findViewById(R.id.singleInstance);
        button_singleInstance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(singleInstanceActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
    //Activity创建或者从后台重新回到前台时被调用
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("TAG_Instance", "onStart called.");
    }

    //Activity从后台重新回到前台时被调用
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("TAG_Instance", "onRestart called.");
    }

    //Activity创建或者从被覆盖、后台重新回到前台时被调用
    @Override
    protected void onResume() {
        super.onResume();
        Log.i("TAG_Instance", "onResume called.");
    }


    //Activity被覆盖到下面或者锁屏时被调用
    @Override
    protected void onPause() {
        super.onPause();
        Log.i("TAG_Instance", "onPause called.");
        //有可能在执行完onPause或onStop后,系统资源紧张将Activity杀死,所以有必要在此保存持久数据
    }

    protected void onStop() {
        super.onStop();
        Log.i("TAG_Instance", "onStop called.");
    }

    //退出当前Activity时被调用,调用之后Activity就结束了
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("TAG_Instance", "onDestory called.");
    }
}
