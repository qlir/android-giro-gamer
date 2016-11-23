package com.admob.android.ads;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.SystemClock;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

final class u
{
  private static String a = "http://r.admob.com/ad_source.php";
  private static int b;
  private static long c;
  private static String d = null;
  
  static d a(d.a parama, Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, g paramg, int paramInt4)
  {
    if (paramContext.checkCallingOrSelfPermission("android.permission.INTERNET") == -1) {
      AdManager.clientError("Cannot request an ad without Internet permissions!  Open manifest.xml and just before the final </manifest> tag add:  <uses-permission android:name=\"android.permission.INTERNET\" />");
    }
    o.a(paramContext);
    long l1 = SystemClock.uptimeMillis();
    String str1 = a(paramContext, paramString1, paramString2, paramInt4);
    r localr = e.a(a, null, AdManager.getUserId(paramContext), null, 3000, null, str1);
    if (Log.isLoggable("AdMobSDK", 3)) {
      Log.d("AdMobSDK", "Requesting an ad with POST params:  " + str1);
    }
    boolean bool = localr.a();
    String str3;
    if (bool)
    {
      byte[] arrayOfByte = localr.d();
      str3 = new String(arrayOfByte);
    }
    for (String str2 = str3;; str2 = null)
    {
      JSONTokener localJSONTokener;
      if (bool)
      {
        if (Log.isLoggable("AdMobSDK", 3)) {
          Log.d("AdMobSDK", "Ad response: ");
        }
        if (!str2.equals("")) {
          localJSONTokener = new JSONTokener(str2);
        }
      }
      for (;;)
      {
        try
        {
          JSONObject localJSONObject = new JSONObject(localJSONTokener);
          if (Log.isLoggable("AdMobSDK", 3)) {
            Log.d("AdMobSDK", localJSONObject.toString(4));
          }
          d locald2 = d.a(parama, localJSONObject, paramInt1, paramInt2, paramInt3, paramg);
          locald1 = locald2;
          if (Log.isLoggable("AdMobSDK", 4))
          {
            long l2 = SystemClock.uptimeMillis() - l1;
            if (locald1 == null) {
              Log.i("AdMobSDK", "No fill.  Server replied that no ads are available (" + l2 + "ms)");
            }
          }
          return locald1;
        }
        catch (JSONException localJSONException)
        {
          Log.w("AdMobSDK", "Problem decoding ad response.  Cannot display ad.", localJSONException);
        }
        d locald1 = null;
      }
    }
  }
  
  static String a()
  {
    return a;
  }
  
  static String a(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    if (Log.isLoggable("AdMobSDK", 3)) {
      Log.d("AdMobSDK", "Ad request:");
    }
    AdManager.a(paramContext);
    StringBuilder localStringBuilder1 = new StringBuilder();
    long l = System.currentTimeMillis();
    localStringBuilder1.append("z").append("=").append(l / 1000L).append(".").append(l % 1000L);
    a(localStringBuilder1, "rt", "0");
    String str1 = AdManager.getPublisherId(paramContext);
    if (str1 == null) {
      throw new IllegalStateException("Publisher ID is not set!  To serve ads you must set your publisher ID assigned from www.admob.com.  Either add it to AndroidManifest.xml under the <application> tag or call AdManager.setPublisherId().");
    }
    a(localStringBuilder1, "s", str1);
    a(localStringBuilder1, "l", o.a());
    a(localStringBuilder1, "f", "jsonp");
    a(localStringBuilder1, "client_sdk", "1");
    a(localStringBuilder1, "ex", "1");
    a(localStringBuilder1, "v", "20100709-ANDROID-3312276cc1406347");
    a(localStringBuilder1, "isu", AdManager.getUserId(paramContext));
    a(localStringBuilder1, "so", AdManager.getOrientation(paramContext));
    if (paramInt > 0) {
      a(localStringBuilder1, "screen_width", String.valueOf(paramInt));
    }
    a(localStringBuilder1, "d[coord]", AdManager.b(paramContext));
    a(localStringBuilder1, "d[coord_timestamp]", AdManager.a());
    a(localStringBuilder1, "d[pc]", AdManager.getPostalCode());
    a(localStringBuilder1, "d[dob]", AdManager.b());
    a(localStringBuilder1, "d[gender]", AdManager.c());
    a(localStringBuilder1, "k", paramString1);
    a(localStringBuilder1, "search", paramString2);
    a(localStringBuilder1, "density", String.valueOf(g.c()));
    if (AdManager.isTestDevice(paramContext))
    {
      if (Log.isLoggable("AdMobSDK", 4)) {
        Log.i("AdMobSDK", "Making ad request in test mode");
      }
      a(localStringBuilder1, "m", "test");
      a(localStringBuilder1, "test_action", AdManager.getTestAction());
    }
    if (d == null)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      PackageManager localPackageManager = paramContext.getPackageManager();
      List localList1 = localPackageManager.queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse("geo:0,0?q=donuts")), 65536);
      if ((localList1 == null) || (localList1.size() == 0)) {
        localStringBuilder2.append("m");
      }
      List localList2 = localPackageManager.queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse("market://search?q=pname:com.admob")), 65536);
      if ((localList2 == null) || (localList2.size() == 0))
      {
        if (localStringBuilder2.length() > 0) {
          localStringBuilder2.append(",");
        }
        localStringBuilder2.append("a");
      }
      List localList3 = localPackageManager.queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse("tel://6509313940")), 65536);
      if ((localList3 == null) || (localList3.size() == 0))
      {
        if (localStringBuilder2.length() > 0) {
          localStringBuilder2.append(",");
        }
        localStringBuilder2.append("t");
      }
      d = localStringBuilder2.toString();
    }
    String str2 = d;
    if ((str2 != null) && (str2.length() > 0)) {
      a(localStringBuilder1, "ic", str2);
    }
    int i = 1 + b;
    b = i;
    if (i == 1)
    {
      c = System.currentTimeMillis();
      a(localStringBuilder1, "pub_data[identifier]", AdManager.getApplicationPackageName(paramContext));
      a(localStringBuilder1, "pub_data[version]", String.valueOf(AdManager.getApplicationVersion(paramContext)));
    }
    for (;;)
    {
      return localStringBuilder1.toString();
      a(localStringBuilder1, "stats[reqs]", String.valueOf(b));
      a(localStringBuilder1, "stats[time]", String.valueOf((System.currentTimeMillis() - c) / 1000L));
    }
  }
  
  static void a(String paramString)
  {
    if (paramString == null) {}
    for (String str = "http://r.admob.com/ad_source.php";; str = paramString)
    {
      if (!"http://r.admob.com/ad_source.php".equals(str)) {
        Log.w("AdMobSDK", "NOT USING PRODUCTION AD SERVER!  Using " + str);
      }
      a = str;
      return;
    }
  }
  
  private static void a(StringBuilder paramStringBuilder, String paramString1, String paramString2)
  {
    if ((paramString2 != null) && (paramString2.length() > 0)) {}
    try
    {
      paramStringBuilder.append("&").append(URLEncoder.encode(paramString1, "UTF-8")).append("=").append(URLEncoder.encode(paramString2, "UTF-8"));
      if (Log.isLoggable("AdMobSDK", 3)) {
        Log.d("AdMobSDK", "    " + paramString1 + ": " + paramString2);
      }
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      Log.e("AdMobSDK", "UTF-8 encoding is not supported on this device.  Ad requests are impossible.", localUnsupportedEncodingException);
    }
  }
}


/* Location:              F:\Java\android-giro-gamer\Decompile\1\doodle_dex2jar.jar!\com\admob\android\ads\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */