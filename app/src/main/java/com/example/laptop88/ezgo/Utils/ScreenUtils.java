package com.example.laptop88.ezgo.Utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.view.Display;

public class ScreenUtils {
    private ScreenUtils(){
        // No-op
    }

    public static int getWithScreen(Context context){
        Display display = ((Activity) context).getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return size.x;
    }

    public static int getheightScreen(Context context){
        Display display = ((Activity) context).getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return size.y;
    }


}
