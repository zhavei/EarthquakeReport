package com.example.earthquakereport;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class EffectTouchListernerClickImage implements View.OnTouchListener {
    private static final int FILTERED_GREY = Color.argb(120, 0, 0, 0);

    public EffectTouchListernerClickImage() {
    }

    Rect rect;

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        if (view instanceof ImageView) {
            ImageView imageView = (ImageView) view;

            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN: {
                    rect = new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
                    imageView.setColorFilter(FILTERED_GREY, PorterDuff.Mode.SRC_ATOP);
                    view.invalidate();
                    break;
                }
                case MotionEvent.ACTION_MOVE:
                    if (rect.contains(view.getLeft() + (int) event.getX(), view.getTop() + (int) view.getY()))
                        break;
                case MotionEvent.ACTION_UP:
                case MotionEvent.ACTION_CANCEL:
                    imageView.clearColorFilter();
                    view.invalidate();
            }
        }
        return false;
    }
}
