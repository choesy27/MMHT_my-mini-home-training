package com.example.mmht_my_mini_home_training;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class CustomToolbar extends LinearLayout {
    TextView textView;

    public CustomToolbar(Context context) {
        super(context);
        initView();
    }

    public CustomToolbar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        initView();
        getAttrs(attrs);
    }

    public CustomToolbar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs);

        initView();
        getAttrs(attrs, defStyleAttr);
    }

    private void initView() {
        String infService = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(infService);
        View v = layoutInflater.inflate(R.layout.re_toolbar, this, false);
        addView(v);

        textView = (TextView) findViewById(R.id.fragmentTitle_text);
    }

    private void getAttrs(AttributeSet attrs) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.CustomToolbar);

        setTypeArray(typedArray);
    }

    private void getAttrs(AttributeSet attrs, int defStyle) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.CustomToolbar, defStyle, 0);

        setTypeArray(typedArray);
    }

    private void setTypeArray(TypedArray typedArray) {      // attrs.xml
        int textColor = typedArray.getColor(R.styleable.CustomToolbar_textColor, 0);
        textView.setTextColor(textColor);

        String text_string = typedArray.getString(R.styleable.CustomToolbar_text);
        textView.setText(text_string);

        typedArray.recycle();
    }
}
