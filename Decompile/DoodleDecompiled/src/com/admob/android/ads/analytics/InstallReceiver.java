package com.admob.android.ads.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.admob.android.ads.AdManager;
import com.admob.android.ads.e;
import com.admob.android.ads.h;
import com.admob.android.ads.r;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class InstallReceiver
  extends BroadcastReceiver
{
  private static String a(String paramString1, String paramString2, String paramString3)
  {
    int i = 0;
    if (paramString1 != null) {}
    for (;;)
    {
      StringBuilder localStringBuilder;
      try
      {
        String[] arrayOfString1 = paramString1.split("&");
        localStringBuilder = null;
        if (i < arrayOfString1.length)
        {
          String str4 = arrayOfString1[i];
          if (!str4.startsWith("admob_")) {
            break label237;
          }
          String[] arrayOfString2 = str4.substring("admob_".length()).split("=");
          String str5 = URLEncoder.encode(arrayOfString2[0], "UTF-8");
          String str6 = URLEncoder.encode(arrayOfString2[1], "UTF-8");
          if (localStringBuilder == null)
          {
            localStringBuilder = new StringBuilder(128);
            localStringBuilder.append(str5).append("=").append(str6);
            break label237;
          }
          localStringBuilder.append("&");
          continue;
          return null;
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        Log.e("AdMobSDK", "Could not create install URL.  Install not tracked.", localUnsupportedEncodingException);
      }
      while (localStringBuilder == null) {}
      String str1 = URLEncoder.encode(paramString2, "UTF-8");
      localStringBuilder.append("&").append("isu").append("=").append(str1);
      String str2 = URLEncoder.encode(paramString3, "UTF-8");
      localStringBuilder.append("&").append("app_id").append("=").append(str2);
      String str3 = "http://a.admob.com/f0?" + localStringBuilder.toString();
      return str3;
      label237:
      i++;
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    try
    {
      String str1 = paramIntent.getStringExtra("referrer");
      String str2 = AdManager.getUserId(paramContext);
      String str3 = a(str1, str2, AdManager.getApplicationPackageName(paramContext));
      if (str3 != null)
      {
        if (Log.isLoggable("AdMobSDK", 2)) {
          Log.v("AdMobSDK", "Processing install from an AdMob ad (" + str3 + ").");
        }
        r localr = e.a(str3, "Conversion", str2);
        localr.a(new h()
        {
          public final void a(r paramAnonymousr)
          {
            if (Log.isLoggable("AdMobSDK", 3)) {
              Log.d("AdMobSDK", "Recorded install from an AdMob ad.");
            }
          }
          
          public final void a(r paramAnonymousr, Exception paramAnonymousException)
          {
            if (Log.isLoggable("AdMobSDK", 3)) {
              Log.d("AdMobSDK", "Failed to record install from an AdMob ad.", paramAnonymousException);
            }
          }
        });
        localr.a();
      }
      return;
    }
    catch (Exception localException)
    {
      Log.e("AdMobSDK", "Unhandled exception processing Market install.", localException);
    }
  }
}


/* Location:              F:\Java\android-giro-gamer\Decompile\1\doodle_dex2jar.jar!\com\admob\android\ads\analytics\InstallReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */