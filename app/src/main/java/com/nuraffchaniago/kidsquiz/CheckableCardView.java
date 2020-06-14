package com.nuraffchaniago.kidsquiz;

import android.content.Context;
import android.widget.Checkable;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;

public class CheckableCardView extends CardView implements Checkable {


    private boolean isChecked = false;

    @Override
    public boolean performClick() {
        toggle();
        return super.performClick();
    }

    public CheckableCardView(@NonNull Context context) {
        super(context);
    }

    @Override
    public void setChecked(boolean checked) {

    }

    @Override
    public boolean isChecked() {
        return false;
    }

    @Override
    public void toggle() {
        setChecked(!this.isChecked);
    }
}
