package com.admob.android.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;

public class AdManager
{
  public static final String LOG = "AdMobSDK";
  public static final String SDK_VERSION = "20100709-ANDROID-3312276cc1406347";
  public static final String SDK_VERSION_DATE = "20100709";
  public static final String TEST_EMULATOR = "emulator";
  private static String a;
  private static int b;
  private static String c;
  private static String d = "url";
  private static String[] e = null;
  private static String f;
  private static Location g;
  private static boolean h = false;
  private static boolean i = false;
  private static long j;
  private static String k;
  private static GregorianCalendar l;
  private static Gender m;
  private static boolean n = false;
  
  static
  {
    Log.i("AdMobSDK", "AdMob SDK version is 20100709-ANDROID-3312276cc1406347");
    for (;;)
    {
      try
      {
        Class localClass = Class.forName("com.admob.android.ads.analytics.InstallReceiver");
        if (localClass != null)
        {
          i1 = 1;
          if (i1 == 0) {
            Log.w("AdMobSDK", "Could not find InstallReceiver class so cannot track installs from AdMob ads.  Did you obfuscate this class away?");
          }
          return;
        }
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        localClassNotFoundException = localClassNotFoundException;
        Log.w("AdMobSDK", "Could not find InstallReceiver class so cannot track installs from AdMob ads.  Did you obfuscate this class away?");
        return;
      }
      finally
      {
        localObject = finally;
        Log.w("AdMobSDK", "Could not find InstallReceiver class so cannot track installs from AdMob ads.  Did you obfuscate this class away?");
        throw ((Throwable)localObject);
      }
      int i1 = 0;
    }
  }
  
  static String a()
  {
    return String.valueOf(j / 1000L);
  }
  
  private static String a(String paramString)
  {
    Object localObject = null;
    if (paramString != null)
    {
      int i1 = paramString.length();
      localObject = null;
      if (i1 <= 0) {}
    }
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramString.getBytes(), 0, paramString.length());
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = new BigInteger(1, localMessageDigest.digest());
      String str = String.format("%032X", arrayOfObject);
      localObject = str;
      return (String)localObject;
    }
    catch (Exception localException)
    {
      Log.d("AdMobSDK", "Could not generate hash of " + paramString, localException);
    }
    return paramString.substring(0, 32);
  }
  
  static void a(Context paramContext)
  {
    if (n) {}
    for (;;)
    {
      return;
      n = true;
      try
      {
        PackageManager localPackageManager = paramContext.getPackageManager();
        ApplicationInfo localApplicationInfo = localPackageManager.getApplicationInfo(paramContext.getPackageName(), 128);
        String str;
        if (localApplicationInfo != null) {
          if (localApplicationInfo.metaData != null)
          {
            str = localApplicationInfo.metaData.getString("ADMOB_PUBLISHER_ID");
            if (Log.isLoggable("AdMobSDK", 3)) {
              Log.d("AdMobSDK", "Publisher ID read from AndroidManifest.xml is " + str);
            }
            if ((c == null) && (str != null))
            {
              if ((!str.equals("a1496ced2842262")) || ((!paramContext.getPackageName().equals("com.admob.android.ads")) && (!paramContext.getPackageName().equals("com.example.admob.lunarlander")))) {
                break label266;
              }
              Log.i("AdMobSDK", "This is a sample application so allowing sample publisher ID.");
              c = str;
            }
          }
        }
        for (;;)
        {
          if (!i) {
            h = localApplicationInfo.metaData.getBoolean("ADMOB_ALLOW_LOCATION_FOR_ADS", false);
          }
          a = localApplicationInfo.packageName;
          if (Log.isLoggable("AdMobSDK", 2)) {
            Log.v("AdMobSDK", "Application's package name is " + a);
          }
          PackageInfo localPackageInfo = localPackageManager.getPackageInfo(paramContext.getPackageName(), 0);
          if (localPackageInfo == null) {
            break;
          }
          b = localPackageInfo.versionCode;
          if (!Log.isLoggable("AdMobSDK", 2)) {
            break;
          }
          Log.v("AdMobSDK", "Application's version number is " + b);
          return;
          label266:
          setPublisherId(str);
        }
        return;
      }
      catch (Exception localException) {}
    }
  }
  
  static String b()
  {
    GregorianCalendar localGregorianCalendar = getBirthday();
    String str = null;
    if (localGregorianCalendar != null)
    {
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = Integer.valueOf(localGregorianCalendar.get(1));
      arrayOfObject[1] = Integer.valueOf(1 + localGregorianCalendar.get(2));
      arrayOfObject[2] = Integer.valueOf(localGregorianCalendar.get(5));
      str = String.format("%04d%02d%02d", arrayOfObject);
    }
    return str;
  }
  
  static String b(Context paramContext)
  {
    Location localLocation = getCoordinates(paramContext);
    String str = null;
    if (localLocation != null) {
      str = localLocation.getLatitude() + "," + localLocation.getLongitude();
    }
    if (Log.isLoggable("AdMobSDK", 3)) {
      Log.d("AdMobSDK", "User coordinates are " + str);
    }
    return str;
  }
  
  static String c()
  {
    if (m == Gender.MALE) {
      return "m";
    }
    if (m == Gender.FEMALE) {
      return "f";
    }
    return null;
  }
  
  protected static void clientError(String paramString)
  {
    Log.e("AdMobSDK", paramString);
    throw new IllegalArgumentException(paramString);
  }
  
  private static boolean f()
  {
    return ("unknown".equals(Build.BOARD)) && ("generic".equals(Build.DEVICE)) && ("generic".equals(Build.BRAND));
  }
  
  public static String getApplicationPackageName(Context paramContext)
  {
    if (a == null) {
      a(paramContext);
    }
    return a;
  }
  
  protected static int getApplicationVersion(Context paramContext)
  {
    if (a == null) {
      a(paramContext);
    }
    return b;
  }
  
  public static GregorianCalendar getBirthday()
  {
    return l;
  }
  
  public static Location getCoordinates(Context paramContext)
  {
    if ((f()) && (!h))
    {
      Log.i("AdMobSDK", "Location information is not being used for ad requests. Enable location");
      Log.i("AdMobSDK", "based ads with AdManager.setAllowUseOfLocation(true) or by setting ");
      Log.i("AdMobSDK", "meta-data ADMOB_ALLOW_LOCATION_FOR_ADS to true in AndroidManifest.xml");
    }
    if ((h) && (paramContext != null) && ((g == null) || (System.currentTimeMillis() > 900000L + j))) {}
    for (;;)
    {
      try
      {
        if ((g == null) || (System.currentTimeMillis() > 900000L + j))
        {
          j = System.currentTimeMillis();
          if (paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") != 0) {
            break label364;
          }
          if (Log.isLoggable("AdMobSDK", 3)) {
            Log.d("AdMobSDK", "Trying to get locations from the network.");
          }
          localLocationManager = (LocationManager)paramContext.getSystemService("location");
          if (localLocationManager == null) {
            break label356;
          }
          Criteria localCriteria2 = new Criteria();
          localCriteria2.setAccuracy(2);
          localCriteria2.setCostAllowed(false);
          str = localLocationManager.getBestProvider(localCriteria2, true);
          i1 = 1;
          if ((str == null) && (paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0))
          {
            if (Log.isLoggable("AdMobSDK", 3)) {
              Log.d("AdMobSDK", "Trying to get locations from GPS.");
            }
            localLocationManager = (LocationManager)paramContext.getSystemService("location");
            if (localLocationManager == null) {
              break label350;
            }
            Criteria localCriteria1 = new Criteria();
            localCriteria1.setAccuracy(1);
            localCriteria1.setCostAllowed(false);
            str = localLocationManager.getBestProvider(localCriteria1, true);
            i1 = 1;
          }
          if (i1 != 0) {
            continue;
          }
          if (Log.isLoggable("AdMobSDK", 3)) {
            Log.d("AdMobSDK", "Cannot access user's location.  Permissions are not set.");
          }
        }
        return g;
        if (str == null)
        {
          if (!Log.isLoggable("AdMobSDK", 3)) {
            continue;
          }
          Log.d("AdMobSDK", "No location providers are available.  Ads will not be geotargeted.");
          continue;
        }
        if (!Log.isLoggable("AdMobSDK", 3)) {
          break label328;
        }
      }
      finally {}
      Log.d("AdMobSDK", "Location provider setup successfully.");
      label328:
      localLocationManager.requestLocationUpdates(str, 0L, 0.0F, new LocationListener()
      {
        public final void onLocationChanged(Location paramAnonymousLocation)
        {
          AdManager.a(paramAnonymousLocation);
          AdManager.a(System.currentTimeMillis());
          this.a.removeUpdates(this);
          if (Log.isLoggable("AdMobSDK", 3)) {
            Log.d("AdMobSDK", "Acquired location " + AdManager.d().getLatitude() + "," + AdManager.d().getLongitude() + " at " + new Date(AdManager.e()).toString() + ".");
          }
        }
        
        public final void onProviderDisabled(String paramAnonymousString) {}
        
        public final void onProviderEnabled(String paramAnonymousString) {}
        
        public final void onStatusChanged(String paramAnonymousString, int paramAnonymousInt, Bundle paramAnonymousBundle) {}
      }, paramContext.getMainLooper());
      continue;
      label350:
      int i1 = 1;
      continue;
      label356:
      i1 = 1;
      String str = null;
      continue;
      label364:
      LocationManager localLocationManager = null;
      str = null;
      i1 = 0;
    }
  }
  
  static String getEndpoint()
  {
    return u.a();
  }
  
  public static Gender getGender()
  {
    return m;
  }
  
  public static String getOrientation(Context paramContext)
  {
    String str = "p";
    if (((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getOrientation() == 1) {
      str = "l";
    }
    return str;
  }
  
  public static String getPostalCode()
  {
    return k;
  }
  
  public static String getPublisherId(Context paramContext)
  {
    if (c == null) {
      a(paramContext);
    }
    if ((c == null) && (Log.isLoggable("AdMobSDK", 6))) {
      Log.e("AdMobSDK", "getPublisherId returning null publisher id.  Please set the publisher id in AndroidManifest.xml or using AdManager.setPublisherId(String)");
    }
    return c;
  }
  
  protected static int getScreenWidth(Context paramContext)
  {
    Display localDisplay = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    if (localDisplay != null) {
      return localDisplay.getWidth();
    }
    return 0;
  }
  
  public static String getTestAction()
  {
    return d;
  }
  
  static String[] getTestDevices()
  {
    return e;
  }
  
  public static String getUserId(Context paramContext)
  {
    String str;
    if (f == null)
    {
      str = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
      if ((str != null) && (!f())) {
        break label88;
      }
      f = "emulator";
      Log.i("AdMobSDK", "To get test ads on the emulator use AdManager.setTestDevices( new String[] { AdManager.TEST_EMULATOR } )");
    }
    for (;;)
    {
      if (Log.isLoggable("AdMobSDK", 3)) {
        Log.d("AdMobSDK", "The user ID is " + f);
      }
      if (f != "emulator") {
        break;
      }
      return null;
      label88:
      f = a(str);
      Log.i("AdMobSDK", "To get test ads on this device use AdManager.setTestDevices( new String[] { \"" + f + "\" } )");
    }
    return f;
  }
  
  public static boolean isTestDevice(Context paramContext)
  {
    if (e != null)
    {
      String str = getUserId(paramContext);
      if (str == null) {
        str = "emulator";
      }
      return Arrays.binarySearch(e, str) >= 0;
    }
    return false;
  }
  
  public static void setAllowUseOfLocation(boolean paramBoolean)
  {
    i = true;
    h = paramBoolean;
  }
  
  public static void setBirthday(int paramInt1, int paramInt2, int paramInt3)
  {
    GregorianCalendar localGregorianCalendar = new GregorianCalendar();
    localGregorianCalendar.set(paramInt1, paramInt2 - 1, paramInt3);
    setBirthday(localGregorianCalendar);
  }
  
  public static void setBirthday(GregorianCalendar paramGregorianCalendar)
  {
    l = paramGregorianCalendar;
  }
  
  static void setEndpoint(String paramString)
  {
    u.a(paramString);
  }
  
  public static void setGender(Gender paramGender)
  {
    m = paramGender;
  }
  
  public static void setPostalCode(String paramString)
  {
    k = paramString;
  }
  
  public static void setPublisherId(String paramString)
  {
    if ((paramString == null) || (paramString.length() != 15)) {
      clientError("SETUP ERROR:  Incorrect AdMob publisher ID.  Should 15 [a-f,0-9] characters:  " + c);
    }
    if (paramString.equalsIgnoreCase("a1496ced2842262")) {
      clientError("SETUP ERROR:  Cannot use the sample publisher ID (a1496ced2842262).  Yours is available on www.admob.com.");
    }
    Log.i("AdMobSDK", "Publisher ID set to " + paramString);
    c = paramString;
  }
  
  public static void setTestAction(String paramString)
  {
    d = paramString;
  }
  
  public static void setTestDevices(String[] paramArrayOfString)
  {
    if (paramArrayOfString == null)
    {
      e = null;
      return;
    }
    String[] arrayOfString = (String[])paramArrayOfString.clone();
    e = arrayOfString;
    Arrays.sort(arrayOfString);
  }
  
  public static enum Gender
  {
    static
    {
      FEMALE = new Gender("FEMALE", 1);
      Gender[] arrayOfGender = new Gender[2];
      arrayOfGender[0] = MALE;
      arrayOfGender[1] = FEMALE;
      a = arrayOfGender;
    }
    
    private Gender() {}
  }
}


/* Location:              F:\Java\android-giro-gamer\Decompile\1\doodle_dex2jar.jar!\com\admob\android\ads\AdManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */