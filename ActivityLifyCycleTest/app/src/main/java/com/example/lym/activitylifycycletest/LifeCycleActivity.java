package com.example.lym.activitylifycycletest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class LifeCycleActivity extends AppCompatActivity {
    public static final String TAG = "LifeCycleActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, this.toString());
        setContentView(R.layout.lifecycle_layout);

        if(null !=savedInstanceState)
        {
            String data = savedInstanceState.getString("key_save");
            Log.i(TAG, data);
        }

        Button startNormalActivity = (Button) findViewById(R.id.start_normal_activity);
        Button startDialogActivity = (Button) findViewById(R.id.start_dialog_activity);

        startNormalActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LifeCycleActivity.this,NormalActivity.class);
                startActivity(intent);
            }
        });

        startDialogActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LifeCycleActivity.this,DialogActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onStart()
    {
        super.onStart();
        Log.i(TAG, "onStart: Test Start");
    }
    
    @Override
    protected  void onStop()
    {
        super.onStop();
        Log.i(TAG, "onStop: Test stop");
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        Log.i(TAG, "onResume: Test resume");
    }

    @Override
    protected  void onPause()
    {
        super.onPause();
        Log.i(TAG, "onPause: Test Pause");
    }
    
    @Override
    protected  void onDestroy()
    {
        super.onDestroy();
        Log.i(TAG, "onDestroy: Test Destroy");
    }
    
    @Override
    protected  void onRestart()
    {
        super.onRestart();
        Log.d(TAG, "onRestart: Test restart");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("key_save","Save data before destroy");

    }
}
