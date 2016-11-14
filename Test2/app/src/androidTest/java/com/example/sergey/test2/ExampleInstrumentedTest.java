package com.example.sergey.test2;

import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.Until;
import android.util.Log;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    private UiDevice mDevice;
    private Instrumentation mInst;
    private static final int TIMEOUT = 5000;

    private final String TESST_PACKAGE = "com.android.browser";

    private void runApp(String packageName) {
        Context context = mInst.getContext();
        Intent intent = context.getPackageManager().getLaunchIntentForPackage(TESST_PACKAGE);  //sets the intent to start your app
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);  //clear out any previous task, i.e., make sure it starts on the initial screen
        context.startActivity(intent);  //starts the app
        mDevice = UiDevice.getInstance(mInst);
        mDevice.wait(Until.hasObject(By.pkg(packageName)), TIMEOUT); //ofc you need to set timeout
    }

    @Test
    public void useAppContext() throws Exception {
        mInst = InstrumentationRegistry.getInstrumentation();
        mDevice = UiDevice.getInstance(mInst);
        runApp(TESST_PACKAGE);

        //Activity childActivity = inst.waitForMonitorWithTimeout(inst.addMonitor("com.alexblackapps.game2048", null, false), 5000);

        Worker w = new Worker(mDevice, mInst);
        Thread.sleep(5000);
        Bitmap b = w.mBitmaps.get(3);
        Log.d("my: ", String.format("#%06X", (0xFFFFFF & b.getPixel(100, 100))));

//
//        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
//        mDevice.pressHome();
//        final String launcherPackage = mDevice.getLauncherPackageName();
//        mDevice.wait(Until.hasObject(By.pkg(launcherPackage).depth(0)), LAUNCH_TIMEOUT);
//
//        List<UiObject2> buttons = mDevice.findObjects(By.clazz("android.widget.TextView").pkg("com.teslacoilsw.launcher"));
//        buttons.get(buttons.size() - 3).click();
//        synchronized (mDevice) {
//            mDevice.wait(5000);
//        }
//
//        mDevice.findObject(By.text("2048")).click();
//
//        synchronized (mDevice) {
//            mDevice.wait(5000);
//        }
//
//        for (int i=0 ; i< 20; i++) {
//            double r = Math.random();
//
//            if (r < 0.25){
//                mDevice.swipe(300, 300, 300, 400, 5);
//            } else if(r < 0.5){
//                mDevice.swipe(300, 300, 400, 300, 5);
//            } else if (r < 0.75){
//                mDevice.swipe(300, 400, 300, 300, 5);
//            }else
//            mDevice.swipe(400, 300, 300, 300, 5);
//
//            synchronized (mDevice) {
//                mDevice.wait(500);
//            }
       //s }
    }
}
