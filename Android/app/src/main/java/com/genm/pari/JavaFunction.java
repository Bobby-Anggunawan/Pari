package com.genm.pari;

import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;

public class JavaFunction {
    public static void setMargins (View view, boolean tambahMargin) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            if(tambahMargin){
                final TypedArray styledAttributes = MainActivity.mainContext.getTheme().obtainStyledAttributes(
                        new int[] { android.R.attr.actionBarSize });
                int mActionBarSize = (int) styledAttributes.getDimension(0, 0);
                styledAttributes.recycle();
                p.setMargins(0, 0, 0, mActionBarSize);
            }
            else{
                p.setMargins(0, 0, 0, 0);
            }
            view.requestLayout();
        }
    }
}
