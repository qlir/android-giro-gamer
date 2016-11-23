package com.admob.android.ads;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;

final class o
  implements h
{
  private static o a = null;
  private static Context b = null;
  private static Thread c = null;
  private static String d = null;
  private Properties e;
  private Context f;
  
  private o(Context paramContext)
  {
    this.f = paramContext;
    this.e = null;
    d = a();
    if (a != null) {
      a.e = null;
    }
    if ((!b()) && (c == null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("http://mm.admob.com/static/android/i18n/20100709");
      localStringBuilder.append("/");
      localStringBuilder.append(d);
      localStringBuilder.append(".properties");
      Thread localThread = new Thread(e.a(localStringBuilder.toString(), null, AdManager.getUserId(this.f), this, 1));
      c = localThread;
      localThread.start();
    }
  }
  
  private static File a(Context paramContext, String paramString)
    throws IOException
  {
    File localFile1 = new File(paramContext.getCacheDir(), "admob_cache");
    if (!localFile1.exists()) {
      localFile1.mkdir();
    }
    File localFile2 = new File(localFile1, "20100709");
    if (!localFile2.exists()) {
      localFile2.mkdir();
    }
    return new File(localFile2, paramString + ".properties");
  }
  
  public static String a()
  {
    if (d == null)
    {
      String str = Locale.getDefault().getLanguage();
      d = str;
      if (str == null) {
        d = "en";
      }
    }
    return d;
  }
  
  public static void a(Context paramContext)
  {
    if (b == null) {
      b = paramContext.getApplicationContext();
    }
    if (a == null) {
      a = new o(b);
    }
  }
  
  private boolean b()
  {
    if (this.e == null) {}
    try
    {
      Properties localProperties = new Properties();
      File localFile = a(this.f, d);
      if (localFile.exists())
      {
        localProperties.load(new FileInputStream(localFile));
        this.e = localProperties;
      }
      if (this.e != null) {
        return true;
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        this.e = null;
      }
    }
    return false;
  }
  
  public final void a(r paramr)
  {
    try
    {
      byte[] arrayOfByte = paramr.d();
      if (arrayOfByte != null)
      {
        FileOutputStream localFileOutputStream = new FileOutputStream(a(this.f, d));
        localFileOutputStream.write(arrayOfByte);
        localFileOutputStream.close();
      }
      return;
    }
    catch (Exception localException)
    {
      while (!Log.isLoggable("AdMobSDK", 3)) {}
      Log.d("AdMobSDK", "Could not store localized strings to cache file.");
    }
  }
  
  public final void a(r paramr, Exception paramException)
  {
    if (Log.isLoggable("AdMobSDK", 3)) {
      Log.d("AdMobSDK", "Could not get localized strings from the AdMob servers.");
    }
  }
}


/* Location:              F:\Java\android-giro-gamer\Decompile\1\doodle_dex2jar.jar!\com\admob\android\ads\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */