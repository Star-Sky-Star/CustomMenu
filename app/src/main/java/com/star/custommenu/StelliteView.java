package com.star.custommenu;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

/**
 * Created by Administrator on 2016/10/13.
 */
public class StelliteView extends FrameLayout{
    private View mInflate;
    private ImageView mMain,mIcon1,mIcon2;
    private boolean isOpen=false;

    public StelliteView(Context context) {
        super(context);
        init(context);
    }

    public StelliteView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void  init(Context context){
        mInflate = inflate(context, R.layout.stelliteview,this);
        mMain= (ImageView) mInflate.findViewById(R.id.image_main);
        mIcon1= (ImageView) mInflate.findViewById(R.id.image_icon1);
        mIcon2= (ImageView) mInflate.findViewById(R.id.image_icon2);

        mMain.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                //给改背景图片
                mMain.setImageResource(isOpen?R.drawable.main:R.drawable.sat_item);
                //发射卫星图片
                if (!isOpen){
                    openMenu();
                }
                //关闭卫星图片
                else{
                    closeMenu();
                }
              isOpen=!isOpen;
            }
        });
    }

    private void closeMenu() {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mIcon1, "translationY", -400,-200,0);
        objectAnimator.setDuration(1000);
        objectAnimator.start();

        ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(mIcon2, "translationY", -200,-100,0);
        objectAnimator2.setDuration(1000);
        objectAnimator2.start();
    }

    private void openMenu() {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mIcon1, "translationY", -200,
                -430, -400);
        objectAnimator.setDuration(1000);
        objectAnimator.start();
//属性 动画
        ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(mIcon2, "translationY", -100,
                -230, -200);
        objectAnimator2.setDuration(1000);
        objectAnimator2.start();
    }

    public void mIcon1Click(OnClickListener onClickListener){
        mIcon1.setOnClickListener(onClickListener);
    }
    public void mIcon2Click(OnClickListener onClickListener){
        mIcon2.setOnClickListener(onClickListener);
    }
}
