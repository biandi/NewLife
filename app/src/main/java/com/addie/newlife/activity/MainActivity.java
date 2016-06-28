package com.addie.newlife.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.addie.newlife.R;
import com.addie.newlife.service.MyBinder;
import com.addie.newlife.service.MyService;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public static final String TAG = MainActivity.class.getSimpleName();
    private Button btnStartSer;
    private Button btnStopSer;
    private Button btnBindSer;
    private Button btnUnBindSer;
    private Button btnFinish;
    private Intent intent;
    private MyBinder myBinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        intent = new Intent(this,MyService.class);
    }

    private void initView() {
        btnStartSer = (Button)findViewById(R.id.btn_start_service);
        btnStopSer = (Button)findViewById(R.id.btn_stop_service);
        btnBindSer = (Button)findViewById(R.id.btn_bind_service);
        btnUnBindSer = (Button)findViewById(R.id.btn_unBind_service);
        btnFinish = (Button)findViewById(R.id.btn_finish);


        btnStartSer.setOnClickListener(this);
        btnStopSer.setOnClickListener(this);
        btnBindSer.setOnClickListener(this);
        btnUnBindSer.setOnClickListener(this);
        btnFinish.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.btn_start_service:
                startService(intent);
                break;
            case R.id.btn_stop_service:
                stopService(intent);
                break;
            case R.id.btn_bind_service:
                //bindService(intent,conn, Context.BIND_AUTO_CREATE);
                break;
            case R.id.btn_unBind_service:
                //unbindService(conn);
                break;
            case R.id.btn_finish:
                finish();
                break;
        }
    }
}
