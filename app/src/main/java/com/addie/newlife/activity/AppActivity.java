package com.addie.newlife.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.addie.newlife.R;

public class AppActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnJump;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);
        initView();
    }

    private void initView() {
        btnJump = (Button)findViewById(R.id.btn_jump);
        btnJump.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.equals(btnJump)) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("boolean",true);
            Intent intent = new Intent();
            intent.setClass(AppActivity.this,MainActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    }
}
