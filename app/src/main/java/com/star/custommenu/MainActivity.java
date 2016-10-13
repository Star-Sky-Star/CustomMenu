package com.star.custommenu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    protected StelliteView mMyView;
    protected QqMessageCount mMessage;
    protected Button mBtnAdd;
    protected Button mDelet;
    private TextView mCount;
    private int msgCount = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mMyView = (StelliteView) findViewById(R.id.myView);
        mMyView.mIcon1Click(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "icon1", Toast.LENGTH_SHORT).show();
            }
        });
        mMyView.mIcon2Click(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "icon2", Toast.LENGTH_SHORT).show();
            }
        });
        mMessage = (QqMessageCount) findViewById(R.id.message);
        mBtnAdd = (Button) findViewById(R.id.btn_add);
        mCount = (TextView) findViewById(R.id.count);
        mBtnAdd.setOnClickListener(MainActivity.this);
        mMessage.setMessageCount(0);
        mDelet = (Button) findViewById(R.id.delet);
        mDelet.setOnClickListener(MainActivity.this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_add) {
            mMessage.addMsg();
        } else if (view.getId() == R.id.delet) {
            mMessage.setMessageCount(0);
        }
    }
}
