package com.hencoder.hencoderpracticedraw6.practice;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.hencoder.hencoderpracticedraw6.R;

import static com.hencoder.hencoderpracticedraw6.Utils.dpToPixel;

public class Practice05MultiProperties extends ConstraintLayout {
    Button animateBt;
    ImageView imageView;

    int stateCount = 2;
    int state = 0;

    public Practice05MultiProperties(Context context) {
        super(context);
    }

    public Practice05MultiProperties(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice05MultiProperties(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        animateBt = (Button) findViewById(R.id.animateBt);
        imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setScaleX(0);
        imageView.setScaleY(0);
        imageView.setAlpha(0f);
        animateBt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO 在这里处理点击事件，同时对多个属性做动画
                switch (state) {
                    case 0:
                        imageView.animate()
                                .translationX(dpToPixel(250))
                                .rotation(2160)
                                .scaleX(1)
                                .scaleY(1)
                                .alpha(100);
                        break;

                    case 1:
                        imageView.animate()
                                .translationX(dpToPixel(0))
                                .rotation(0)
                                .scaleX(0)
                                .scaleY(0)
                                .alpha(0);
                        break;
                }
                state++;
                if (state == stateCount) {
                    state = 0;
                }
            }
        });
    }
}
