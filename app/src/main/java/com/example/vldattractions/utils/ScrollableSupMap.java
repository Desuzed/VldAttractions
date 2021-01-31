package com.example.vldattractions.utils;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.gms.maps.SupportMapFragment;
//ScrollView blocks vertical map scrolling and this class decides scrolling task
public class ScrollableSupMap extends SupportMapFragment {
    private OnTouchListener onTouchListener;

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View layout = super.onCreateView(layoutInflater, viewGroup, bundle);
        TouchableWrapper touchableWrapper = new TouchableWrapper(getActivity());
        touchableWrapper.setBackgroundColor(getResources().getColor(android.R.color.transparent));
        ((ViewGroup) layout).addView(touchableWrapper, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        return layout;
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
        this.onTouchListener = onTouchListener;
    }

    public interface OnTouchListener {
        public abstract void onTouch();
    }


    public class TouchableWrapper extends FrameLayout {

        public TouchableWrapper(@NonNull Context context) {
            super(context);
        }

        @Override
        public boolean dispatchTouchEvent(MotionEvent ev) {
            switch (ev.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    onTouchListener.onTouch();
                    break;
                case MotionEvent.ACTION_UP:
                    onTouchListener.onTouch();
                    break;
            }
            return super.dispatchTouchEvent(ev);
        }
    }

}
