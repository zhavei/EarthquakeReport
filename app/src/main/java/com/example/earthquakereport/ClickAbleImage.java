package com.example.earthquakereport;

import android.content.Context;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatImageView;

public class ClickAbleImage extends AppCompatImageView {

        public ClickAbleImage(Context context, AttributeSet attrs) {
            super(context, attrs);
            setOnTouchListener(new EffectTouchListernerClickImage());
        }
    }
