package com.star.custommenu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/10/13.
 */
public class QqMessageCount extends RelativeLayout {
    private View mInflate;
    private int msgCount;
    private TextView mCount;
    public QqMessageCount(Context context) {
        super(context);
        init(context);
    }

    public QqMessageCount(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }
    private void init(Context context){
        mInflate = inflate(context, R.layout.qqmesage,this);
        mCount= (TextView) mInflate.findViewById(R.id.count);
 }
    public void setMessageCount(int count) {
        msgCount = count;
        if (count == 0) {
            mCount.setVisibility(View.GONE);
        } else {
            mCount.setVisibility(View.VISIBLE);
            if (count < 20) {
                mCount.setText(count + "");
            } else {
                mCount.setText("19+");
            }
        }
        invalidate();//重绘
    }

    public void addMsg() {
        setMessageCount(msgCount + 1);
    }
}
