package com.admob.android.ads;

import android.content.Context;
import android.util.Log;
import org.json.JSONObject;
import org.json.JSONTokener;

final class t
{
  private static boolean a = false;
  
  public static void a(Context paramContext)
  {
    if (!a)
    {
      a = true;
      if (AdManager.getUserId(paramContext) != null) {
        break label155;
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0) {}
      try
      {
        String str1 = u.a(paramContext, null, null, 0);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("http://api.admob.com/v1/pubcode/android_sdk_emulator_notice");
        localStringBuilder.append("?");
        localStringBuilder.append(str1);
        r localr = e.a(localStringBuilder.toString(), "developer_message", AdManager.getUserId(paramContext));
        if (localr.a())
        {
          byte[] arrayOfByte = localr.d();
          if (arrayOfByte != null)
          {
            String str2 = new JSONObject(new JSONTokener(new String(arrayOfByte))).getString("data");
            if ((str2 != null) && (!str2.equals(""))) {
              Log.w("AdMobSDK", str2);
            }
          }
        }
        return;
      }
      catch (Exception localException)
      {
        label155:
        while (!Log.isLoggable("AdMobSDK", 2)) {}
        Log.v("AdMobSDK", "Unhandled exception retrieving developer message.", localException);
      }
    }
  }
}


/* Location:              F:\Java\android-giro-gamer\Decompile\1\doodle_dex2jar.jar!\com\admob\android\ads\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */