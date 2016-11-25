package com.example.sergey.test2;

import android.app.Instrumentation;
import android.app.UiAutomation;
import android.graphics.Bitmap;
import android.support.test.uiautomator.UiDevice;
import android.util.Log;
import android.view.accessibility.AccessibilityNodeInfo;

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
    private final List<Bitmap> mNeededBitmaps;
    private final UiDevice mUiDevice;
    private UiAutomation mUiAutomation;

    public Worker(UiDevice uiDevice, Instrumentation inst) {
        mUiDevice = uiDevice;
        //mActivityManager = (ActivityManager)inst.getContext().getSystemService(Context.ACTIVITY_SERVICE);
        mBitmaps = new ArrayList<>();
        mNeededBitmaps = new ArrayList<>();
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
                    long start = System.currentTimeMillis();
                    Log.d("test", "TakeScreenshot:" + start);
                    takeScreenshot();
                    long end = System.currentTimeMillis();
                    try {
                        long newTimeout = SCREENSHOT_INTERVAL - (end - start);
                        Log.d("test", "timeout:" + newTimeout);
                        if (newTimeout > 0){
                            Thread.sleep(newTimeout);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        thread.start();
    }

    private void takeScreenshot() {
        AccessibilityNodeInfo root = mUiAutomation.getRootInActiveWindow();
        addBitmap(mUiAutomation.takeScreenshot());
    }

    private void addBitmap(Bitmap b) {
        mBitmaps.add(b);
        if (mBitmaps.size() > IMAGETS_LIMIT - 1) {
            Bitmap bitm = mBitmaps.remove(0);
            if (!mNeededBitmaps.contains(bitm)) {
                bitm.recycle();
            }
        }
    }

    public List<Bitmap> getBitmaps() {
        for (Bitmap mNeededBitmap : mNeededBitmaps) {
            mNeededBitmap.recycle();
        }
        mNeededBitmaps.clear();
        synchronized (mBitmaps) {
            mNeededBitmaps.addAll(mBitmaps);
            //mBitmaps.clear();
        }
        return mNeededBitmaps;

    }

//    public List<Double> calculate(List<Double> input) {
//
//    }
}
