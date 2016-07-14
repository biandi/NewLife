package com.addie.newlife.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.addie.newlife.R;

import java.lang.ref.WeakReference;

public class AppActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = AppActivity.class.getSimpleName();

    private Button btnJump;
    private Button btnStartThread;
    private Button btnThreadOther;
    private TextView textNum;
    private static final int MSG_UPDATE = 1;
    private static final int MSG_TEST = 2;
    private boolean stopThread = false;
    private MyHandler myHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);
        initView();
    }

    private void initView() {
        btnJump = (Button) findViewById(R.id.btn_jump);
        btnStartThread = (Button)findViewById(R.id.btn_start_thread);
        btnThreadOther = (Button)findViewById(R.id.btn_start_thread_other);
        textNum = (TextView)findViewById(R.id.text_num);
        btnJump.setOnClickListener(this);
        btnStartThread.setOnClickListener(this);
        btnThreadOther.setOnClickListener(this);
        myHandler = new MyHandler(this);
    }
    static class MyHandler extends Handler {
        private WeakReference<Activity> activity;

        public MyHandler(AppActivity activity) {
            this.activity = new WeakReference<Activity>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            if (msg == null)
                return;
            final AppActivity a = (AppActivity)activity.get();
            if (a != null) {
                a.textNum.setText(String.valueOf(msg.arg1));
            }

        }
    }
    @Override
    public void onClick(View view) {
        if (view.equals(btnJump)) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("boolean", true);
            Intent intent = new Intent();
            intent.setClass(AppActivity.this, MainActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
            finish();
        } else if (view.equals(btnStartThread)){
            myThread.start();
        } else if (view.equals(btnThreadOther)) {
            mySThread.start();
        }

    }

    Thread mySThread = new Thread(new Runnable() {
        @Override
        public void run() {
            Message msg = new Message();
            msg.what = MSG_TEST;
            myHandler.sendMessage(msg);
        }
    });

    Thread myThread = new Thread(new Runnable() {
        @Override
        public void run() {

            for (int i=0;i<10;i++){
                if (stopThread) {
                    return;
                }
                Message msg = new Message();
                msg.what = MSG_UPDATE;
                msg.arg1 = i;
                myHandler.sendMessage(msg);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    );

    @Override
    protected void onDestroy() {
        stopThread = true;
        super.onDestroy();

    }
}
