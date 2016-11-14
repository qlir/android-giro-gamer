package com.example.sergey.test2;

import android.app.Instrumentation;
import android.app.UiAutomation;
import android.graphics.Bitmap;
import android.support.test.uiautomator.UiDevice;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sergey on 12.11.2016.
 */

public class Worker {

    private static final int IMAGETS_LIMIT = 4;
    private static final int SCREENSHOT_INTERVAL = 250;
    // private final View mView;
    // private final ActivityManager mActivityManager;
    //  private final Activity mActivity;
    public final List<Bitmap> mBitmaps;
    private final UiDevice mUiDevice;
    private UiAutomation mUiAutomation;

    public Worker(UiDevice uiDevice, Instrumentation inst) {
        mUiDevice = uiDevice;
        //mActivityManager = (ActivityManager)inst.getContext().getSystemService(Context.ACTIVITY_SERVICE);
        mBitmaps = new ArrayList<>();
        //mBitmaps.add(Bitmap.createBitmap(mView.getWidth(), mView.getHeight(), Bitmap.Config.ARGB_8888));
        //final File f = new File("screenshot.png");
        mUiAutomation = inst.getUiAutomation();
        startScreenshotProvider();
    }

    private void startScreenshotProvider() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    /*Log.d("my", "1: " + System.currentTimeMillis());
                    mUiDevice.takeScreenshot(f);
                    Log.d("my", "2: " + System.currentTimeMillis());*/
                    Log.d("my", "1: " + System.currentTimeMillis());
                    takeScreenshot();
                    Log.d("my", "2: " + System.currentTimeMillis());
                    try {
                        Thread.sleep(SCREENSHOT_INTERVAL);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        thread.start();
    }

    private void takeScreenshot() {
        addBitmap(mUiAutomation.takeScreenshot());
    }

    private void addBitmap(Bitmap b) {
        mBitmaps.add(b);
        if (mBitmaps.size() > IMAGETS_LIMIT) {
            mBitmaps.remove(0).recycle();
        }
    }

    public Bitmap[] getBitmaps() {
        synchronized (mBitmaps) {
            Bitmap[] result = new Bitmap[IMAGETS_LIMIT];
            mBitmaps.toArray(result);
            mBitmaps.clear();
            return result;
        }
    }

//    public List<Double> calculate(List<Double> input) {
//
//    }
}
