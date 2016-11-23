package com.admob.android.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.admob.android.ads.view.AdMobWebView;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
  implements h
{
  private static final int c = Color.rgb(102, 102, 102);
  private static final Rect d = new Rect(0, 0, 0, 0);
  private static final PointF e;
  private static final PointF f;
  private static final PointF g = new PointF(0.5F, 0.5F);
  private static final Matrix h = new Matrix();
  private static final RectF i = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
  private Hashtable<String, byte[]> A = new Hashtable();
  private HashSet<r> B = new HashSet();
  private Vector<Bitmap> C = new Vector();
  private b D = null;
  private double E = -1.0D;
  private double F = -1.0D;
  private Vector<WeakReference<View>> G = null;
  protected View a;
  protected g b;
  private String j = null;
  private String k = null;
  private boolean l;
  private boolean m;
  private Vector<Intent> n = new Vector();
  private Vector<String> o = new Vector();
  private Vector<e> p = new Vector();
  private f q;
  private Rect r = null;
  private long s = 0L;
  private int t = -1;
  private int u = -1;
  private a v = null;
  private int w = -1;
  private int x = -1;
  private int y = -16777216;
  private JSONObject z;
  
  static
  {
    PointF localPointF = new PointF(0.0F, 0.0F);
    e = localPointF;
    f = localPointF;
  }
  
  private static float a(JSONObject paramJSONObject, String paramString, float paramFloat)
  {
    return (float)paramJSONObject.optDouble(paramString, paramFloat);
  }
  
  private static int a(JSONObject paramJSONObject, String paramString, int paramInt)
  {
    if ((paramJSONObject != null) && (paramJSONObject.has(paramString))) {
      try
      {
        JSONArray localJSONArray = paramJSONObject.getJSONArray(paramString);
        int i1 = (int)(255.0D * localJSONArray.getDouble(0));
        int i2 = (int)(255.0D * localJSONArray.getDouble(1));
        int i3 = (int)(255.0D * localJSONArray.getDouble(2));
        int i4 = Color.argb((int)(255.0D * localJSONArray.getDouble(3)), i1, i2, i3);
        return i4;
      }
      catch (Exception localException)
      {
        return paramInt;
      }
    }
    return paramInt;
  }
  
  private static Matrix a(JSONArray paramJSONArray)
  {
    float[] arrayOfFloat = b(paramJSONArray);
    Matrix localMatrix = null;
    if (arrayOfFloat != null)
    {
      int i1 = arrayOfFloat.length;
      localMatrix = null;
      if (i1 == 9)
      {
        localMatrix = new Matrix();
        localMatrix.setValues(arrayOfFloat);
      }
    }
    return localMatrix;
  }
  
  private static Matrix a(JSONObject paramJSONObject, String paramString, Matrix paramMatrix)
  {
    float[] arrayOfFloat = b(paramJSONObject, paramString);
    if ((arrayOfFloat != null) && (arrayOfFloat.length == 9))
    {
      Matrix localMatrix = new Matrix();
      localMatrix.setValues(arrayOfFloat);
      return localMatrix;
    }
    return paramMatrix;
  }
  
  private static PointF a(RectF paramRectF, PointF paramPointF)
  {
    float f1 = paramRectF.width();
    float f2 = paramRectF.height();
    return new PointF(paramRectF.left + f1 * paramPointF.x, paramRectF.top + f2 * paramPointF.y);
  }
  
  private static PointF a(JSONObject paramJSONObject, String paramString, PointF paramPointF)
  {
    if ((paramJSONObject != null) && (paramJSONObject.has(paramString))) {
      try
      {
        PointF localPointF = e(paramJSONObject.getJSONArray(paramString));
        return localPointF;
      }
      catch (JSONException localJSONException)
      {
        return paramPointF;
      }
    }
    return paramPointF;
  }
  
  private static Rect a(JSONObject paramJSONObject, String paramString, Rect paramRect)
  {
    if ((paramJSONObject != null) && (paramJSONObject.has(paramString))) {
      try
      {
        JSONArray localJSONArray = paramJSONObject.getJSONArray(paramString);
        int i1 = (int)localJSONArray.getDouble(0);
        int i2 = (int)localJSONArray.getDouble(1);
        int i3 = (int)localJSONArray.getDouble(2);
        int i4 = (int)localJSONArray.getDouble(3);
        Rect localRect = new Rect(i1, i2, i3 + i1, i4 + i2);
        return localRect;
      }
      catch (JSONException localJSONException)
      {
        return paramRect;
      }
    }
    return paramRect;
  }
  
  private static RectF a(JSONObject paramJSONObject, String paramString, RectF paramRectF)
  {
    if ((paramJSONObject != null) && (paramJSONObject.has(paramString))) {
      try
      {
        RectF localRectF = d(paramJSONObject.getJSONArray(paramString));
        return localRectF;
      }
      catch (JSONException localJSONException)
      {
        return paramRectF;
      }
    }
    return paramRectF;
  }
  
  private View a(JSONObject paramJSONObject, Rect paramRect)
    throws JSONException
  {
    if (this.b != null)
    {
      float f1 = a(paramJSONObject, "ia", 0.5F);
      float f2 = a(paramJSONObject, "epy", 0.4375F);
      int i1 = a(paramJSONObject, "bc", this.y);
      try
      {
        Bitmap localBitmap = Bitmap.createBitmap(paramRect.width(), paramRect.height(), Bitmap.Config.ARGB_8888);
        this.C.add(localBitmap);
        Canvas localCanvas = new Canvas(localBitmap);
        int i2 = (int)(f1 * 255.0F);
        int i3 = (int)(f2 * paramRect.height()) + paramRect.top;
        Rect localRect1 = new Rect(paramRect.left, paramRect.top, paramRect.right, i3);
        Paint localPaint1 = new Paint();
        localPaint1.setColor(-1);
        localPaint1.setStyle(Paint.Style.FILL);
        localCanvas.drawRect(localRect1, localPaint1);
        int[] arrayOfInt = { Color.argb(i2, Color.red(i1), Color.green(i1), Color.blue(i1)), i1 };
        GradientDrawable localGradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, arrayOfInt);
        localGradientDrawable.setBounds(localRect1);
        localGradientDrawable.draw(localCanvas);
        Rect localRect2 = new Rect(paramRect.left, i3, paramRect.right, paramRect.bottom);
        Paint localPaint2 = new Paint();
        localPaint2.setColor(i1);
        localPaint2.setStyle(Paint.Style.FILL);
        localCanvas.drawRect(localRect2, localPaint2);
        View localView = new View(this.b.getContext());
        localView.setBackgroundDrawable(new BitmapDrawable(localBitmap));
        return localView;
      }
      catch (Throwable localThrowable)
      {
        return null;
      }
    }
    return null;
  }
  
  private static Animation a(int paramInt, String paramString1, String paramString2, float[] paramArrayOfFloat, JSONArray paramJSONArray1, String[] paramArrayOfString, long paramLong, View paramView, Rect paramRect, JSONObject paramJSONObject, JSONArray paramJSONArray2)
  {
    int i1 = paramInt + 1;
    float f1 = paramArrayOfFloat[paramInt];
    float f2 = paramArrayOfFloat[i1];
    if ((paramString1 == null) || (paramString2 == null))
    {
      if (!Log.isLoggable("AdMobSDK", 6)) {
        break label520;
      }
      Log.e("AdMobSDK", "Could not read keyframe animation: keyPath(" + paramString1 + ") or valueType(" + paramString2 + ") is null.");
    }
    label520:
    for (Object localObject = null;; localObject = null) {
      for (;;)
      {
        if (localObject != null)
        {
          int i2 = (int)(f1 * (float)paramLong);
          long l1 = (int)((f2 - f1) * (float)paramLong);
          ((Animation)localObject).setDuration(paramLong);
          Interpolator localInterpolator = a(paramArrayOfString[paramInt], i2, l1, paramLong);
          if (localInterpolator != null) {
            ((Animation)localObject).setInterpolator(localInterpolator);
          }
        }
        return (Animation)localObject;
        try
        {
          if (("position".equals(paramString1)) && ("P".equals(paramString2)))
          {
            localObject = a(e(paramJSONArray1.getJSONArray(paramInt)), e(paramJSONArray1.getJSONArray(i1)), paramView, paramRect);
          }
          else if (("opacity".equals(paramString1)) && ("F".equals(paramString2)))
          {
            localObject = a((float)paramJSONArray1.getDouble(paramInt), (float)paramJSONArray1.getDouble(i1));
          }
          else if (("bounds".equals(paramString1)) && ("R".equals(paramString2)))
          {
            localObject = a(d(paramJSONArray1.getJSONArray(paramInt)), d(paramJSONArray1.getJSONArray(i1)), paramView, paramRect);
          }
          else if (("zPosition".equals(paramString1)) && ("F".equals(paramString2)))
          {
            localObject = a((float)paramJSONArray1.getDouble(paramInt), (float)paramJSONArray1.getDouble(i1), paramView);
          }
          else if (("backgroundColor".equals(paramString1)) && ("C".equals(paramString2)))
          {
            localObject = a(c(paramJSONArray1.getJSONArray(paramInt)), c(paramJSONArray1.getJSONArray(i1)), paramView);
          }
          else
          {
            if (("transform".equals(paramString1)) && ("AT".equals(paramString2)))
            {
              if (paramJSONArray2 != null)
              {
                a(paramJSONArray1.getJSONArray(paramInt));
                a(paramJSONArray1.getJSONArray(i1));
                localObject = a(paramView, paramRect, paramJSONObject, paramJSONArray2.getJSONArray(paramInt), paramJSONArray2.getJSONArray(i1));
              }
            }
            else if (Log.isLoggable("AdMobSDK", 6)) {
              Log.e("AdMobSDK", "Could not read keyframe animation: could not interpret keyPath(" + paramString1 + ") and valueType(" + paramString2 + ") combination.");
            }
            localObject = null;
          }
        }
        catch (JSONException localJSONException) {}
      }
    }
  }
  
  private static Animation a(View paramView, Rect paramRect, JSONObject paramJSONObject, JSONArray paramJSONArray1, JSONArray paramJSONArray2)
    throws JSONException
  {
    String str = paramJSONObject.optString("tt", null);
    if (str != null)
    {
      if ("t".equals(str)) {
        return a(e(paramJSONArray1), e(paramJSONArray2), paramView, paramRect);
      }
      if ("r".equals(str))
      {
        float[] arrayOfFloat5 = b(paramJSONArray1);
        float[] arrayOfFloat6 = b(paramJSONArray2);
        if ((arrayOfFloat5 == null) || (arrayOfFloat6 == null) || (Arrays.equals(arrayOfFloat5, arrayOfFloat6))) {
          break label284;
        }
        PointF localPointF3 = f.b(paramView);
        PointF localPointF4 = a(new RectF(paramRect), localPointF3);
        return new j(arrayOfFloat5, arrayOfFloat6, localPointF4.x, localPointF4.y, 0.0F, false);
      }
      if ("sc".equals(str))
      {
        float[] arrayOfFloat3 = b(paramJSONArray1);
        float[] arrayOfFloat4 = b(paramJSONArray2);
        PointF localPointF2 = f.b(paramView);
        return new ScaleAnimation(arrayOfFloat3[0], arrayOfFloat4[0], arrayOfFloat3[1], arrayOfFloat4[1], 1, localPointF2.x, 1, localPointF2.y);
      }
      if ("sk".equals(str))
      {
        float[] arrayOfFloat1 = b(paramJSONArray1);
        float[] arrayOfFloat2 = b(paramJSONArray2);
        if ((arrayOfFloat1 != null) && (arrayOfFloat2 != null) && (!Arrays.equals(arrayOfFloat1, arrayOfFloat2)))
        {
          PointF localPointF1 = f.b(paramView);
          return new p(arrayOfFloat1, arrayOfFloat2, a(new RectF(paramRect), localPointF1));
        }
      }
      else
      {
        "p".equals(str);
      }
    }
    else
    {
      return null;
    }
    return null;
    label284:
    return null;
  }
  
  private AnimationSet a(JSONArray paramJSONArray, JSONObject paramJSONObject, View paramView, Rect paramRect)
    throws JSONException
  {
    AnimationSet localAnimationSet = new AnimationSet(false);
    int i1 = 0;
    if (i1 < paramJSONArray.length())
    {
      JSONObject localJSONObject = paramJSONArray.getJSONObject(i1);
      String str1 = localJSONObject.optString("t", null);
      int i2 = (int)(1000.0D * a(localJSONObject, "d", 0.25F));
      String str2;
      String str3;
      Object localObject2;
      label162:
      Object localObject1;
      if ("B".equals(str1))
      {
        str2 = localJSONObject.optString("kp", null);
        str3 = localJSONObject.optString("vt", null);
        if ((str2 == null) || (str3 == null))
        {
          if (!Log.isLoggable("AdMobSDK", 6)) {
            break label643;
          }
          Log.e("AdMobSDK", "Could not read basic animation: keyPath(" + str2 + ") or valueType(" + str3 + ") is null.");
          localObject2 = null;
          if (localObject2 != null)
          {
            Interpolator localInterpolator = a(localJSONObject.optString("tf", null), -1L, -1L, -1L);
            if (localInterpolator == null) {
              localInterpolator = null;
            }
            if (localInterpolator != null) {
              ((Animation)localObject2).setInterpolator(localInterpolator);
            }
          }
          localObject1 = localObject2;
        }
      }
      for (;;)
      {
        if (localObject1 != null)
        {
          ((Animation)localObject1).setDuration(i2);
          a(localJSONObject, (Animation)localObject1, localAnimationSet);
          localAnimationSet.addAnimation((Animation)localObject1);
          ((Animation)localObject1).getDuration();
        }
        i1++;
        break;
        if (("position".equals(str2)) && ("P".equals(str3)))
        {
          localObject2 = a(a(localJSONObject, "fv", e), a(localJSONObject, "tv", f), paramView, paramRect);
          break label162;
        }
        if (("opacity".equals(str2)) && ("F".equals(str3)))
        {
          localObject2 = a(a(localJSONObject, "fv", 0.0F), a(localJSONObject, "tv", 0.0F));
          break label162;
        }
        if (("transform".equals(str2)) && ("AT".equals(str3)))
        {
          a(localJSONObject, "fv", h);
          a(localJSONObject, "fv", h);
          localObject2 = a(paramView, paramRect, localJSONObject, localJSONObject.getJSONArray("tfv"), localJSONObject.getJSONArray("ttv"));
          break label162;
        }
        if (("bounds".equals(str2)) && ("R".equals(str3)))
        {
          localObject2 = a(a(localJSONObject, "fv", i), a(localJSONObject, "tv", i), null, paramRect);
          break label162;
        }
        if (("zPosition".equals(str2)) && ("F".equals(str3)))
        {
          localObject2 = a(a(localJSONObject, "fv", 0.0F), a(localJSONObject, "tv", 0.0F), paramView);
          break label162;
        }
        if (("backgroundColor".equals(str2)) && ("C".equals(str3)))
        {
          localObject2 = a(a(localJSONObject, "fv", 0), a(localJSONObject, "tv", 0), paramView);
          break label162;
        }
        if (Log.isLoggable("AdMobSDK", 6)) {
          Log.e("AdMobSDK", "Could not read basic animation: could not interpret keyPath(" + str2 + ") and valueType(" + str3 + ") combination.");
        }
        label643:
        localObject2 = null;
        break label162;
        boolean bool = "K".equals(str1);
        localObject1 = null;
        if (bool) {
          localObject1 = a(localJSONObject, paramView, paramRect, i2);
        }
      }
    }
    if (paramJSONObject != null) {
      a(paramJSONObject, localAnimationSet, null);
    }
    return localAnimationSet;
  }
  
  private AnimationSet a(JSONObject paramJSONObject, View paramView, Rect paramRect, long paramLong)
    throws JSONException
  {
    String str1 = paramJSONObject.getString("vt");
    float[] arrayOfFloat = b(paramJSONObject, "kt");
    JSONArray localJSONArray1 = paramJSONObject.getJSONArray("vs");
    String[] arrayOfString = a(paramJSONObject, "tfs");
    JSONArray localJSONArray2 = paramJSONObject.optJSONArray("ttvs");
    int i1 = arrayOfFloat.length;
    int i2 = localJSONArray1.length();
    int i3 = arrayOfString.length;
    if (((i1 != i2) || (i2 != i3 + 1)) && (arrayOfFloat[0] == 0.0D) && (arrayOfFloat[(i1 - 1)] == 1.0D))
    {
      if (Log.isLoggable("AdMobSDK", 6)) {
        Log.e("AdMobSDK", "keyframe animations were invalid: numKeyTimes=" + i1 + " numKeyValues=" + i2 + " numKeyFunctions=" + i3 + " keyTimes[0]=" + arrayOfFloat[0] + " keyTimes[" + (i1 - 1) + "]=" + arrayOfFloat[(i1 - 1)]);
      }
      return null;
    }
    AnimationSet localAnimationSet = new AnimationSet(false);
    String str2 = paramJSONObject.getString("kp");
    int i4 = e(paramJSONObject);
    for (int i5 = 0; i5 < i1 - 1; i5++)
    {
      Animation localAnimation = a(i5, str2, str1, arrayOfFloat, localJSONArray1, arrayOfString, paramLong, paramView, paramRect, paramJSONObject, localJSONArray2);
      if (localAnimation != null)
      {
        localAnimation.setRepeatCount(i4);
        localAnimationSet.addAnimation(localAnimation);
      }
    }
    a(paramJSONObject.optString("fm", "r"), localAnimationSet);
    return localAnimationSet;
  }
  
  private static Interpolator a(String paramString, long paramLong1, long paramLong2, long paramLong3)
  {
    Object localObject;
    if ("i".equals(paramString)) {
      localObject = new AccelerateInterpolator();
    }
    for (;;)
    {
      if ((localObject != null) && (paramLong1 != -1L) && (paramLong2 != -1L) && (paramLong3 != -1L))
      {
        return new c((Interpolator)localObject, paramLong1, paramLong2, paramLong3);
        if ("o".equals(paramString))
        {
          localObject = new DecelerateInterpolator();
          continue;
        }
        if ("io".equals(paramString))
        {
          localObject = new AccelerateDecelerateInterpolator();
          continue;
        }
        if ("l".equals(paramString)) {
          localObject = new LinearInterpolator();
        }
      }
      else
      {
        return (Interpolator)localObject;
      }
      localObject = null;
    }
  }
  
  private static b a(float paramFloat1, float paramFloat2, View paramView)
  {
    boolean bool = paramFloat1 < paramFloat2;
    b localb = null;
    if (bool) {
      localb = new b(paramFloat1, paramFloat2, paramView);
    }
    return localb;
  }
  
  public static d a(a parama, JSONObject paramJSONObject, int paramInt1, int paramInt2, int paramInt3, g paramg)
  {
    d locald;
    if ((paramJSONObject == null) || (paramJSONObject.length() == 0)) {
      locald = null;
    }
    do
    {
      return locald;
      locald = new d();
      locald.v = parama;
      locald.w = paramInt1;
      locald.x = paramInt2;
      locald.y = paramInt3;
      locald.b = paramg;
    } while (locald.c(paramJSONObject));
    return null;
  }
  
  private static k a(int paramInt1, int paramInt2, View paramView)
  {
    k localk = null;
    if (paramInt1 != paramInt2) {
      localk = new k(paramInt1, paramInt2, paramView);
    }
    return localk;
  }
  
  private static l a(PointF paramPointF1, PointF paramPointF2, View paramView, Rect paramRect)
  {
    boolean bool = paramPointF1.equals(paramPointF2);
    l locall = null;
    if (!bool)
    {
      PointF localPointF = f.b(paramView);
      float f1 = paramRect.width() * localPointF.x + paramRect.left;
      float f2 = paramRect.height() * localPointF.y + paramRect.top;
      paramPointF1.x -= f1;
      paramPointF1.y -= f2;
      paramPointF2.x -= f1;
      paramPointF2.y -= f2;
      locall = new l(0, paramPointF1.x, 0, paramPointF2.x, 0, paramPointF1.y, 0, paramPointF2.y);
    }
    return locall;
  }
  
  private static m a(float paramFloat1, float paramFloat2)
  {
    boolean bool = paramFloat1 < paramFloat2;
    m localm = null;
    if (bool) {
      localm = new m(paramFloat1, paramFloat2);
    }
    return localm;
  }
  
  private static n a(RectF paramRectF1, RectF paramRectF2, View paramView, Rect paramRect)
  {
    boolean bool = paramRectF1.equals(paramRectF2);
    n localn = null;
    if (!bool)
    {
      PointF localPointF = a(paramRectF1, f.b(paramView));
      float f1 = paramRect.width();
      float f2 = paramRect.height();
      float f3 = paramRectF1.width() / f1;
      float f4 = paramRectF1.height() / f2;
      localn = new n(f3, paramRectF2.width() / f1, f4, paramRectF2.height() / f2, localPointF.x, localPointF.y);
    }
    return localn;
  }
  
  private static void a(Bundle paramBundle, String paramString, JSONArray paramJSONArray)
  {
    if ((paramString != null) && (paramJSONArray != null))
    {
      Vector localVector = new Vector();
      int i1 = paramJSONArray.length();
      int i2 = 0;
      while (i2 < i1) {
        try
        {
          localVector.add(paramJSONArray.get(i2));
          i2++;
        }
        catch (JSONException localJSONException)
        {
          if (Log.isLoggable("AdMobSDK", 6)) {
            Log.e("AdMobSDK", "couldn't read bundle array while adding extras");
          }
        }
      }
      if (i1 != 0) {
        try
        {
          localObject = localVector.get(0);
          if ((localObject instanceof String))
          {
            paramBundle.putStringArray(paramString, (String[])localVector.toArray(new String[0]));
            return;
          }
          if ((localObject instanceof Integer))
          {
            Integer[] arrayOfInteger = (Integer[])localVector.toArray(new Integer[0]);
            int[] arrayOfInt = new int[arrayOfInteger.length];
            for (int i6 = 0; i6 < arrayOfInteger.length; i6++) {
              arrayOfInt[i6] = arrayOfInteger[i6].intValue();
            }
            paramBundle.putIntArray(paramString, arrayOfInt);
            return;
          }
        }
        catch (ArrayStoreException localArrayStoreException)
        {
          Object localObject;
          if (Log.isLoggable("AdMobSDK", 6))
          {
            Log.e("AdMobSDK", "Couldn't read in array when making extras");
            return;
            if ((localObject instanceof Boolean))
            {
              Boolean[] arrayOfBoolean = (Boolean[])localVector.toArray(new Boolean[0]);
              boolean[] arrayOfBoolean1 = new boolean[arrayOfBoolean.length];
              for (int i5 = 0; i5 < arrayOfBoolean1.length; i5++) {
                arrayOfBoolean1[i5] = arrayOfBoolean[i5].booleanValue();
              }
              paramBundle.putBooleanArray(paramString, arrayOfBoolean1);
              return;
            }
            if ((localObject instanceof Double))
            {
              Double[] arrayOfDouble = (Double[])localVector.toArray(new Double[0]);
              double[] arrayOfDouble1 = new double[arrayOfDouble.length];
              for (int i4 = 0; i4 < arrayOfDouble1.length; i4++) {
                arrayOfDouble1[i4] = arrayOfDouble[i4].doubleValue();
              }
              paramBundle.putDoubleArray(paramString, arrayOfDouble1);
              return;
            }
            if ((localObject instanceof Long))
            {
              Long[] arrayOfLong = (Long[])localVector.toArray(new Long[0]);
              long[] arrayOfLong1 = new long[arrayOfLong.length];
              for (int i3 = 0; i3 < arrayOfLong1.length; i3++) {
                arrayOfLong1[i3] = arrayOfLong[i3].longValue();
              }
              paramBundle.putLongArray(paramString, arrayOfLong1);
            }
          }
        }
      }
    }
  }
  
  private static void a(Animation paramAnimation, int paramInt1, int paramInt2, float paramFloat, String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      paramAnimation.setRepeatMode(2);
    }
    paramAnimation.setRepeatCount(paramInt1);
    paramAnimation.setStartOffset(paramInt2);
    paramAnimation.startNow();
    paramAnimation.scaleCurrentDuration(paramFloat);
    a(paramString, paramAnimation);
  }
  
  private void a(String paramString)
  {
    if ((paramString != null) && (!"".equals(paramString))) {
      this.o.add(paramString);
    }
  }
  
  private static void a(String paramString, Animation paramAnimation)
  {
    Class localClass;
    if ((paramString != null) && (paramAnimation != null)) {
      localClass = paramAnimation.getClass();
    }
    try
    {
      Class[] arrayOfClass = new Class[1];
      arrayOfClass[0] = Boolean.TYPE;
      Method localMethod = localClass.getMethod("setFillEnabled", arrayOfClass);
      if (localMethod != null)
      {
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Boolean.valueOf(true);
        localMethod.invoke(paramAnimation, arrayOfObject);
      }
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    if ("b".equals(paramString))
    {
      paramAnimation.setFillBefore(true);
      paramAnimation.setFillAfter(false);
    }
    do
    {
      return;
      if (("fb".equals(paramString)) || ("r".equals(paramString)))
      {
        paramAnimation.setFillBefore(true);
        paramAnimation.setFillAfter(true);
        return;
      }
      if ("f".equals(paramString))
      {
        paramAnimation.setFillBefore(false);
        paramAnimation.setFillAfter(true);
        return;
      }
    } while (!"r".equals(paramString));
    paramAnimation.setFillBefore(false);
    paramAnimation.setFillAfter(false);
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if ((paramString != null) && (!"".equals(paramString))) {
      this.p.add(new e(paramString, paramBoolean));
    }
  }
  
  private void a(JSONObject paramJSONObject, Animation paramAnimation, AnimationSet paramAnimationSet)
  {
    float f1 = a(paramJSONObject, "bt", 0.0F);
    float f2 = a(paramJSONObject, "to", 0.0F);
    int i1 = e(paramJSONObject);
    boolean bool = paramJSONObject.optBoolean("ar", false);
    String str = paramJSONObject.optString("fm", "r");
    float f3 = a(paramJSONObject, "s", 1.0F);
    int i2 = (int)(1000.0D * (f2 + (f1 + 0.0F)));
    float f4 = 1.0F / f3;
    a(paramAnimation, i1, i2, f4, str, bool);
    if (paramAnimationSet != null) {
      a(paramAnimationSet, i1, i2, f4, str, bool);
    }
  }
  
  private boolean a(JSONObject paramJSONObject, d paramd)
    throws JSONException
  {
    for (;;)
    {
      Typeface localTypeface1;
      int i6;
      q localq1;
      try
      {
        String str1 = paramJSONObject.getString("t");
        Rect localRect = a(a(paramJSONObject, "f", d));
        if ("l".equals(str1))
        {
          if (this.b == null) {
            break label821;
          }
          String str3 = paramJSONObject.getString("x");
          float f1 = a(paramJSONObject, "fs", 13.0F);
          JSONArray localJSONArray2 = paramJSONObject.optJSONArray("fa");
          localTypeface1 = Typeface.DEFAULT;
          if (localJSONArray2 == null) {
            break label796;
          }
          int i5 = 0;
          i6 = 0;
          if (i6 < localJSONArray2.length())
          {
            String str4 = localJSONArray2.getString(i6);
            if ("b".equals(str4))
            {
              i5 |= 0x1;
              break label803;
            }
            if ("i".equals(str4))
            {
              i5 |= 0x2;
              break label803;
            }
            if ("m".equals(str4))
            {
              localTypeface1 = Typeface.MONOSPACE;
              break label803;
            }
            if ("s".equals(str4))
            {
              localTypeface1 = Typeface.SERIF;
              break label803;
            }
            if (!"ss".equals(str4)) {
              break label803;
            }
            localTypeface1 = Typeface.SANS_SERIF;
            break label803;
          }
          localTypeface2 = Typeface.create(localTypeface1, i5);
          int i2 = this.w;
          if (paramJSONObject.has("fco"))
          {
            int i4 = a(paramJSONObject, "fco", i2);
            if (i4 != i2) {
              i2 = i4;
            }
            boolean bool = paramJSONObject.optBoolean("afstfw", true);
            float f2 = a(paramJSONObject, "mfs", 8.0F);
            int i3 = paramJSONObject.optInt("nol", 1);
            q localq2 = new q(this.b.getContext(), g.c());
            localq2.b = bool;
            localq2.a = (f2 * localq2.c);
            localq2.setBackgroundColor(0);
            localq2.setText(str3);
            localq2.setTextColor(i2);
            localq2.setTextSize(1, f1);
            localq2.setTypeface(localTypeface2);
            localq2.setLines(i3);
            localq1 = localq2;
            break label809;
            if (localObject == null) {
              break label764;
            }
            if (i1 != 0) {
              ((View)localObject).setBackgroundColor(a(paramJSONObject, "bgc", 0));
            }
            PointF localPointF = a(paramJSONObject, "ap", g);
            f localf = f.c((View)localObject);
            localf.b = localPointF;
            ((View)localObject).setTag(localf);
            JSONArray localJSONArray1 = paramJSONObject.optJSONArray("a");
            JSONObject localJSONObject = paramJSONObject.optJSONObject("ag");
            AnimationSet localAnimationSet = null;
            if (localJSONArray1 != null) {
              localAnimationSet = a(localJSONArray1, localJSONObject, (View)localObject, localRect);
            }
            String str2 = paramJSONObject.optString("ut", null);
            if ((localObject != null) && (str2 != null)) {
              ((View)localObject).setTag(f.c((View)localObject));
            }
            RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(localRect.width(), localRect.height());
            localLayoutParams.addRule(9);
            localLayoutParams.addRule(10);
            localLayoutParams.setMargins(localRect.left, localRect.top, 0, 0);
            g localg = new g();
            localg.a = ((View)localObject);
            localg.b = localLayoutParams;
            localg.c = localAnimationSet;
            paramd.a.add(localg);
            if ((!paramJSONObject.optBoolean("cav")) || (this.b == null)) {
              break label819;
            }
            this.b.a((View)localObject, localLayoutParams);
            break label819;
          }
          if (paramJSONObject.optInt("fc", 0) == 1)
          {
            i2 = this.x;
            continue;
          }
          i2 = this.w;
          continue;
        }
        if ("bg".equals(str1))
        {
          localObject = a(paramJSONObject, localRect);
          i1 = 0;
          continue;
        }
        if ("i".equals(str1)) {
          localView = f(paramJSONObject);
        } else if ("P".equals(str1)) {
          if (this.b != null) {
            localView = new View(this.b.getContext());
          }
        }
      }
      catch (JSONException localJSONException)
      {
        if (Log.isLoggable("AdMobSDK", 6)) {
          Log.e("AdMobSDK", "exception while trying to create a flex view.", localJSONException);
        }
        return false;
      }
      View localView = null;
      break label827;
      label764:
      if (Log.isLoggable("AdMobSDK", 6)) {
        Log.e("AdMobSDK", "created a null view.");
      }
      return false;
      int i1 = 1;
      Object localObject = null;
      continue;
      label796:
      Typeface localTypeface2 = localTypeface1;
      continue;
      label803:
      i6++;
      continue;
      for (;;)
      {
        label809:
        localObject = localq1;
        i1 = 1;
        break;
        label819:
        return true;
        label821:
        localq1 = null;
      }
      label827:
      localObject = localView;
      i1 = 1;
    }
  }
  
  private static String[] a(JSONObject paramJSONObject, String paramString)
  {
    JSONArray localJSONArray = paramJSONObject.optJSONArray(paramString);
    if (localJSONArray == null) {
      return null;
    }
    int i1 = localJSONArray.length();
    try
    {
      String[] arrayOfString = new String[i1];
      for (int i2 = 0; i2 < i1; i2++) {
        arrayOfString[i2] = localJSONArray.getString(i2);
      }
      return arrayOfString;
    }
    catch (JSONException localJSONException) {}
    return null;
  }
  
  private void b(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      String str1 = paramJSONObject.optString("a", null);
      String str2 = paramJSONObject.optString("d", null);
      int i1 = paramJSONObject.optInt("f", 268435456);
      Bundle localBundle = d(paramJSONObject.optJSONObject("b"));
      Vector localVector = this.n;
      Intent localIntent = new Intent(str1, Uri.parse(str2));
      if (i1 != 0) {
        localIntent.addFlags(i1);
      }
      if (localBundle != null) {
        localIntent.putExtras(localBundle);
      }
      localVector.add(localIntent);
    }
  }
  
  private static float[] b(JSONArray paramJSONArray)
  {
    int i1 = paramJSONArray.length();
    try
    {
      float[] arrayOfFloat = new float[i1];
      for (int i2 = 0; i2 < i1; i2++) {
        arrayOfFloat[i2] = ((float)paramJSONArray.getDouble(i2));
      }
      return arrayOfFloat;
    }
    catch (JSONException localJSONException) {}
    return null;
  }
  
  private static float[] b(JSONObject paramJSONObject, String paramString)
  {
    JSONArray localJSONArray = paramJSONObject.optJSONArray(paramString);
    if (localJSONArray == null) {
      return null;
    }
    return b(localJSONArray);
  }
  
  private static int c(JSONArray paramJSONArray)
    throws JSONException
  {
    int i1 = (int)(255.0D * paramJSONArray.getDouble(0));
    int i2 = (int)(255.0D * paramJSONArray.getDouble(1));
    int i3 = (int)(255.0D * paramJSONArray.getDouble(2));
    return Color.argb((int)(255.0D * paramJSONArray.getDouble(3)), i1, i2, i3);
  }
  
  private boolean c(JSONObject paramJSONObject)
  {
    String str1 = paramJSONObject.optString("jsonp_url", null);
    String str2 = paramJSONObject.optString("tracking_url", null);
    a(str1, true);
    a(str2, false);
    this.j = paramJSONObject.optString("text", null);
    String str3 = paramJSONObject.optString("6", null);
    this.k = paramJSONObject.optString("8", null);
    f localf1 = f.d;
    f localf2;
    if ("map".equals(str3)) {
      localf2 = f.a;
    }
    for (;;)
    {
      this.q = localf2;
      if ((localf2 == f.g) && (!(this.b.getContext() instanceof Activity)))
      {
        if (this.v != null) {
          this.v.a();
        }
        return false;
        if ("video".equals(str3))
        {
          localf2 = f.b;
          continue;
        }
        if ("app".equals(str3))
        {
          localf2 = f.c;
          continue;
        }
        if ("url".equals(str3))
        {
          localf2 = f.d;
          continue;
        }
        if ("call".equals(str3))
        {
          localf2 = f.e;
          continue;
        }
        if ("itunes".equals(str3))
        {
          localf2 = f.f;
          continue;
        }
        if ("canvas".equals(str3))
        {
          localf2 = f.g;
          continue;
        }
        if ("contact".equals(str3)) {
          localf2 = f.h;
        }
      }
      else
      {
        if (paramJSONObject.has("refreshInterval")) {
          this.E = paramJSONObject.optDouble("refreshInterval");
        }
        if (paramJSONObject.has("density")) {}
        PointF localPointF;
        for (this.F = paramJSONObject.optDouble("density");; this.F = g.c())
        {
          localPointF = a(paramJSONObject, "d", null);
          if (localPointF == null) {
            localPointF = new PointF(320.0F, 48.0F);
          }
          if ((localPointF.x >= 0.0F) && (localPointF.y >= 0.0F)) {
            break;
          }
          return false;
        }
        int i1 = (int)localPointF.x;
        int i2 = (int)localPointF.y;
        this.t = i1;
        this.u = i2;
        JSONObject localJSONObject1 = paramJSONObject.optJSONObject("ac");
        if (localJSONObject1 != null) {
          b(localJSONObject1);
        }
        JSONArray localJSONArray = paramJSONObject.optJSONArray("ac");
        if (localJSONArray != null)
        {
          int i3 = 0;
          for (;;)
          {
            if (i3 < localJSONArray.length()) {
              try
              {
                b(localJSONArray.getJSONObject(i3));
                i3++;
              }
              catch (JSONException localJSONException2)
              {
                for (;;)
                {
                  if (Log.isLoggable("AdMobSDK", 6)) {
                    Log.e("AdMobSDK", "Could not form an intent from ad action response: " + localJSONArray.toString());
                  }
                }
              }
            }
          }
        }
        String str4 = paramJSONObject.optString("cpm_url", null);
        if (str4 != null)
        {
          this.l = true;
          a(str4);
        }
        Object localObject = paramJSONObject.optString("tracking_pixel", null);
        if (localObject != null) {}
        try
        {
          new URL((String)localObject);
          if (localObject != null) {
            a((String)localObject);
          }
          localJSONObject2 = paramJSONObject.optJSONObject("markup");
          if (localJSONObject2 == null) {
            return false;
          }
        }
        catch (MalformedURLException localMalformedURLException)
        {
          for (;;)
          {
            JSONObject localJSONObject2;
            try
            {
              String str5 = URLEncoder.encode((String)localObject, "UTF-8");
              localObject = str5;
            }
            catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
            if (str1 == null)
            {
              if (Log.isLoggable("AdMobSDK", 6)) {
                Log.e("AdMobSDK", "Bad response:  didn't get clickURLString.  erroring out.");
              }
              return false;
            }
            this.z = localJSONObject2;
            try
            {
              n();
              m();
              double d1 = this.z.optDouble("itid");
              if (d1 > 0.0D) {
                this.s = ((d1 * 1000.0D));
              }
            }
            catch (JSONException localJSONException1)
            {
              if (!Log.isLoggable("AdMobSDK", 6)) {
                continue;
              }
              Log.e("AdMobSDK", "Could not read in the flex ad.", localJSONException1);
              continue;
            }
            l();
            if (k()) {
              o();
            }
            return true;
          }
        }
      }
      localf2 = localf1;
    }
  }
  
  private static RectF d(JSONArray paramJSONArray)
    throws JSONException
  {
    float f1 = (float)paramJSONArray.getDouble(0);
    float f2 = (float)paramJSONArray.getDouble(1);
    float f3 = (float)paramJSONArray.getDouble(2);
    float f4 = (float)paramJSONArray.getDouble(3);
    return new RectF(f1, f2, f3 + f1, f4 + f2);
  }
  
  private static Bundle d(JSONObject paramJSONObject)
  {
    Object localObject1 = null;
    Iterator localIterator;
    Bundle localBundle;
    if (paramJSONObject != null)
    {
      localIterator = paramJSONObject.keys();
      if (!localIterator.hasNext()) {
        break label249;
      }
      localBundle = new Bundle();
    }
    for (;;)
    {
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Object localObject2 = paramJSONObject.opt(str);
        if ((str != null) && (localObject2 != null) && (str != null) && (localObject2 != null)) {
          if ((localObject2 instanceof String)) {
            localBundle.putString(str, (String)localObject2);
          } else if ((localObject2 instanceof Integer)) {
            localBundle.putInt(str, ((Integer)localObject2).intValue());
          } else if ((localObject2 instanceof Boolean)) {
            localBundle.putBoolean(str, ((Boolean)localObject2).booleanValue());
          } else if ((localObject2 instanceof Double)) {
            localBundle.putDouble(str, ((Double)localObject2).doubleValue());
          } else if ((localObject2 instanceof Long)) {
            localBundle.putLong(str, ((Long)localObject2).longValue());
          } else if ((localObject2 instanceof JSONObject)) {
            localBundle.putBundle(str, d((JSONObject)localObject2));
          } else if ((localObject2 instanceof JSONArray)) {
            a(localBundle, str, (JSONArray)localObject2);
          }
        }
      }
      else
      {
        localObject1 = localBundle;
        return (Bundle)localObject1;
        label249:
        localBundle = null;
      }
    }
  }
  
  private static int e(JSONObject paramJSONObject)
  {
    int i1 = (int)a(paramJSONObject, "rc", 1.0F);
    if (i1 > 0) {
      i1--;
    }
    return i1;
  }
  
  private static PointF e(JSONArray paramJSONArray)
    throws JSONException
  {
    return new PointF((float)paramJSONArray.getDouble(0), (float)paramJSONArray.getDouble(1));
  }
  
  private View f(JSONObject paramJSONObject)
    throws JSONException
  {
    Object localObject1;
    if (this.b != null)
    {
      localObject1 = null;
      String str = paramJSONObject.getString("$");
      byte[] arrayOfByte;
      if (str != null)
      {
        arrayOfByte = (byte[])this.A.get(str);
        if (arrayOfByte == null) {
          break label482;
        }
      }
      for (;;)
      {
        Object localObject2;
        ImageView localImageView;
        float f1;
        int i1;
        float f2;
        int i2;
        int i3;
        Bitmap localBitmap;
        Canvas localCanvas;
        float f3;
        Path localPath1;
        RectF localRectF;
        Paint localPaint;
        Path localPath2;
        float f4;
        try
        {
          localObject2 = BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length);
          localImageView = new ImageView(this.b.getContext());
        }
        catch (Throwable localThrowable1) {}
        try
        {
          localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
          if (paramJSONObject.optBoolean("b", false))
          {
            f1 = a(paramJSONObject, "bw", 0.5F);
            i1 = a(paramJSONObject, "bdc", c);
            f2 = a(paramJSONObject, "br", 6.5F);
            if (f1 < 1.0F) {
              f1 = 1.0F;
            }
            i2 = ((Bitmap)localObject2).getWidth();
            i3 = ((Bitmap)localObject2).getHeight();
          }
        }
        catch (Throwable localThrowable2)
        {
          for (;;)
          {
            localObject1 = localImageView;
          }
        }
        try
        {
          localBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
          localBitmap.eraseColor(0);
          localCanvas = new Canvas(localBitmap);
          localCanvas.setDrawFilter(new PaintFlagsDrawFilter(0, 1));
          f3 = f2 + f1;
          localPath1 = new Path();
          localRectF = new RectF(0.0F, 0.0F, i2, i3);
          localPath1.addRoundRect(localRectF, f3, f3, Path.Direction.CCW);
          localCanvas.clipPath(localPath1, Region.Op.REPLACE);
          localCanvas.drawBitmap((Bitmap)localObject2, 0.0F, 0.0F, new Paint(3));
          localCanvas.clipRect(localRectF, Region.Op.REPLACE);
          localPaint = new Paint(1);
          localPaint.setStrokeWidth(f1);
          localPaint.setColor(i1);
          localPaint.setStyle(Paint.Style.STROKE);
          localPath2 = new Path();
          f4 = f1 / 2.0F;
          localPath2.addRoundRect(new RectF(f4, f4, i2 - f4, i3 - f4), f2, f2, Path.Direction.CCW);
          localCanvas.drawPath(localPath2, localPaint);
          if (localObject2 != null) {
            ((Bitmap)localObject2).recycle();
          }
          localObject2 = localBitmap;
        }
        catch (Throwable localThrowable3) {}
      }
      this.C.add(localObject2);
      localImageView.setImageBitmap((Bitmap)localObject2);
      return localImageView;
      this.C.add(localObject2);
      localImageView.setImageBitmap((Bitmap)localObject2);
      return localImageView;
      if (Log.isLoggable("AdMobSDK", 6)) {
        Log.e("AdMobSDK", "couldn't create an imageView", localThrowable1);
      }
      return (View)localObject1;
      if (Log.isLoggable("AdMobSDK", 3)) {
        Log.d("AdMobSDK", "Could not find asset name " + paramJSONObject);
      }
      label482:
      return null;
    }
    return null;
  }
  
  private void j()
  {
    Context localContext;
    PackageManager localPackageManager;
    Iterator localIterator;
    if (this.b != null)
    {
      localContext = this.b.getContext();
      if (localContext == null) {
        break label96;
      }
      localPackageManager = localContext.getPackageManager();
      localIterator = this.n.iterator();
    }
    for (;;)
    {
      Intent localIntent;
      if (localIterator.hasNext())
      {
        localIntent = (Intent)localIterator.next();
        if (localPackageManager.resolveActivity(localIntent, 65536) == null) {}
      }
      else
      {
        for (;;)
        {
          label96:
          try
          {
            localContext.startActivity(localIntent);
            return;
          }
          catch (Exception localException) {}
          if (Log.isLoggable("AdMobSDK", 6))
          {
            Log.e("AdMobSDK", "Could not find a resolving intent on ad click");
            return;
            if (Log.isLoggable("AdMobSDK", 3))
            {
              Log.d("AdMobSDK", "Context null, not able to start Activity.");
              return;
            }
          }
        }
      }
    }
  }
  
  private boolean k()
  {
    return (this.B == null) || (this.B.size() == 0);
  }
  
  private void l()
  {
    if (this.B != null) {
      synchronized (this.B)
      {
        Iterator localIterator = this.B.iterator();
        if (localIterator.hasNext()) {
          ((r)localIterator.next()).g();
        }
      }
    }
  }
  
  private void m()
  {
    Object localObject = new Rect(0, 0, this.t, this.u);
    if (this.z.has("ta")) {}
    try
    {
      JSONArray localJSONArray = this.z.getJSONArray("ta");
      int i1 = localJSONArray.getInt(0);
      int i2 = localJSONArray.getInt(1);
      int i3 = localJSONArray.getInt(2);
      int i4 = localJSONArray.getInt(3);
      Rect localRect = new Rect(i1, i2, i3 + i1, i4 + i2);
      if (Math.abs(localRect.width()) >= 44)
      {
        int i5 = Math.abs(localRect.height());
        if (i5 >= 44) {
          localObject = localRect;
        }
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        if (Log.isLoggable("AdMobSDK", 3)) {
          Log.d("AdMobSDK", "could not read in the touchable area for the ad.");
        }
      }
    }
    this.r = ((Rect)localObject);
  }
  
  private void n()
    throws JSONException
  {
    JSONObject localJSONObject = this.z.optJSONObject("$");
    if (localJSONObject != null)
    {
      Iterator localIterator = localJSONObject.keys();
      if (this.B != null) {
        synchronized (this.B)
        {
          if (this.b != null)
          {
            Context localContext = this.b.getContext();
            if (localIterator.hasNext())
            {
              String str = (String)localIterator.next();
              r localr = e.a(localJSONObject.getJSONObject(str).getString("u"), str, AdManager.getUserId(localContext), this);
              this.B.add(localr);
            }
          }
        }
      }
    }
  }
  
  private void o()
  {
    JSONObject localJSONObject;
    if (this.z != null)
    {
      localJSONObject = this.z;
      this.z = null;
    }
    try
    {
      localJSONArray = localJSONObject.optJSONArray("v");
      if (localJSONArray == null) {
        break label182;
      }
      locald = new d(this.b, this);
      i1 = 0;
    }
    catch (JSONException localJSONException)
    {
      synchronized (this.B)
      {
        do
        {
          for (;;)
          {
            JSONArray localJSONArray;
            d locald;
            int i1;
            this.B.clear();
            this.B = null;
            if (this.A != null)
            {
              this.A.clear();
              this.A = null;
            }
            return;
            i1++;
            continue;
            AdView.a.post(locald);
            continue;
            localJSONException = localJSONException;
            if (Log.isLoggable("AdMobSDK", 3)) {
              Log.d("AdMobSDK", "couldn't construct the views.", localJSONException);
            }
          }
        } while (this.v == null);
        this.v.a();
      }
    }
    if (i1 < localJSONArray.length()) {
      if (!a(localJSONArray.getJSONObject(i1), locald))
      {
        if (this.v != null) {
          this.v.a();
        }
        if (this.B == null) {}
      }
    }
  }
  
  private void p()
  {
    if (this.B != null)
    {
      synchronized (this.B)
      {
        Iterator localIterator = this.B.iterator();
        if (localIterator.hasNext()) {
          ((r)localIterator.next()).b();
        }
      }
      this.B.clear();
      this.B = null;
    }
    if (this.A != null)
    {
      this.A.clear();
      this.A = null;
    }
    this.z = null;
    if (this.v != null) {
      this.v.a();
    }
  }
  
  final double a()
  {
    return this.E;
  }
  
  final int a(int paramInt)
  {
    double d1 = paramInt;
    if (this.F > 0.0D) {
      d1 *= this.F;
    }
    return (int)d1;
  }
  
  final Rect a(Rect paramRect)
  {
    Rect localRect = new Rect(paramRect);
    if (this.F > 0.0D)
    {
      localRect.left = a(paramRect.left);
      localRect.top = a(paramRect.top);
      localRect.right = a(paramRect.right);
      localRect.bottom = a(paramRect.bottom);
    }
    return localRect;
  }
  
  public final View a(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(paramContext);
    localRelativeLayout.setBackgroundColor(0);
    localRelativeLayout.setGravity(17);
    AdMobWebView localAdMobWebView = new AdMobWebView(paramContext, localRelativeLayout, paramString2, this);
    localAdMobWebView.setBackgroundColor(-1);
    localAdMobWebView.setId(1);
    localRelativeLayout.addView(localAdMobWebView, new RelativeLayout.LayoutParams(a(paramInt1), a(paramInt2)));
    localAdMobWebView.b = (paramString1 + "#sdk");
    localAdMobWebView.loadUrl("http://mm.admob.com/static/android/canvas.html");
    return localRelativeLayout;
  }
  
  public final void a(View paramView)
  {
    if (this.G == null) {
      this.G = new Vector();
    }
    WeakReference localWeakReference = new WeakReference(paramView);
    this.G.add(localWeakReference);
  }
  
  public final void a(b paramb)
  {
    this.D = paramb;
  }
  
  public final void a(g paramg)
  {
    this.b = paramg;
  }
  
  public final void a(r paramr)
  {
    String str = paramr.e();
    byte[] arrayOfByte = paramr.d();
    if (arrayOfByte != null)
    {
      this.A.put(str, arrayOfByte);
      if (this.B != null) {}
      synchronized (this.B)
      {
        this.B.remove(paramr);
        if (k()) {
          o();
        }
        return;
      }
    }
    if (Log.isLoggable("AdMobSDK", 3)) {
      Log.d("AdMobSDK", "Failed reading asset(" + str + ") for ad");
    }
    p();
  }
  
  public final void a(r paramr, Exception paramException)
  {
    String str7;
    String str6;
    String str5;
    if (paramException != null) {
      if (Log.isLoggable("AdMobSDK", 3))
      {
        if (paramr == null) {
          break label208;
        }
        str7 = paramr.e();
        URL localURL2 = paramr.f();
        if (localURL2 == null) {
          break label198;
        }
        String str8 = localURL2.toString();
        str6 = str7;
        str5 = str8;
      }
    }
    for (;;)
    {
      Log.d("AdMobSDK", "Failed downloading assets for ad: " + str6 + " " + str5, paramException);
      do
      {
        p();
        return;
      } while (!Log.isLoggable("AdMobSDK", 3));
      String str3;
      String str2;
      String str1;
      if (paramr != null)
      {
        str3 = paramr.e();
        URL localURL1 = paramr.f();
        if (localURL1 != null)
        {
          String str4 = localURL1.toString();
          str2 = str3;
          str1 = str4;
        }
      }
      for (;;)
      {
        Log.d("AdMobSDK", "Failed downloading assets for ad: " + str2 + " " + str1);
        break;
        str2 = str3;
        str1 = null;
        continue;
        str1 = null;
        str2 = null;
      }
      label198:
      str6 = str7;
      str5 = null;
      continue;
      label208:
      str5 = null;
      str6 = null;
    }
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    if (this.m)
    {
      Log.i("AdMobSDK", "Ad clicked again.  Stats on admob.com will only reflect the first click.");
      switch (1.a[this.q.ordinal()])
      {
      default: 
        j();
      }
    }
    for (;;)
    {
      if (this.D != null) {
        this.D.a();
      }
      return;
      this.m = true;
      Log.i("AdMobSDK", "Ad clicked.");
      if (this.b == null) {
        break;
      }
      Context localContext = this.b.getContext();
      Iterator localIterator = this.p.iterator();
      while (localIterator.hasNext())
      {
        e locale = (e)localIterator.next();
        h local2 = new h()
        {
          public final void a(r paramAnonymousr)
          {
            if (Log.isLoggable("AdMobSDK", 3)) {
              Log.d("AdMobSDK", "Click processed at " + paramAnonymousr.f());
            }
          }
          
          public final void a(r paramAnonymousr, Exception paramAnonymousException)
          {
            if (Log.isLoggable("AdMobSDK", 3)) {
              Log.d("AdMobSDK", "Click processing failed at " + paramAnonymousr.f(), paramAnonymousException);
            }
          }
        };
        boolean bool = locale.b;
        JSONObject localJSONObject = null;
        if (bool) {
          localJSONObject = paramJSONObject;
        }
        e.a(locale.a, "click_time_tracking", AdManager.getUserId(localContext), localJSONObject, local2).g();
      }
      Intent localIntent = (Intent)this.n.firstElement();
      if (localIntent != null)
      {
        Uri localUri = localIntent.getData();
        if (localUri != null)
        {
          String str1 = localUri.toString();
          String str2 = this.k;
          if (AdView.a != null) {
            AdView.a.post(new c(str1, str2, 320, 295, this));
          }
        }
      }
    }
  }
  
  public final g b()
  {
    return this.b;
  }
  
  public final void b(View paramView)
  {
    Object localObject1;
    Object localObject2;
    if ((this.G != null) && (paramView != null))
    {
      Iterator localIterator = this.G.iterator();
      localObject1 = null;
      if (localIterator.hasNext())
      {
        localObject2 = (WeakReference)localIterator.next();
        if (!paramView.equals(((WeakReference)localObject2).get())) {
          break label69;
        }
      }
    }
    for (;;)
    {
      localObject1 = localObject2;
      break;
      this.G.remove(localObject1);
      return;
      label69:
      localObject2 = localObject1;
    }
  }
  
  public final long c()
  {
    return this.s;
  }
  
  final boolean d()
  {
    return this.l;
  }
  
  public final int e()
  {
    return this.t;
  }
  
  public final boolean equals(Object paramObject)
  {
    if ((paramObject instanceof d))
    {
      d locald = (d)paramObject;
      return toString().equals(locald.toString());
    }
    return false;
  }
  
  public final int f()
  {
    return this.u;
  }
  
  public final Rect g()
  {
    if (this.r == null) {
      this.r = new Rect(0, 0, this.t, this.u);
    }
    return this.r;
  }
  
  final void h()
  {
    Iterator localIterator1 = this.C.iterator();
    while (localIterator1.hasNext())
    {
      Bitmap localBitmap = (Bitmap)localIterator1.next();
      if (localBitmap != null) {
        localBitmap.recycle();
      }
    }
    this.C.clear();
    if (this.b != null)
    {
      WindowManager localWindowManager = (WindowManager)this.b.getContext().getSystemService("window");
      if (this.G != null)
      {
        Iterator localIterator2 = this.G.iterator();
        while (localIterator2.hasNext())
        {
          View localView = (View)((WeakReference)localIterator2.next()).get();
          if (localView != null) {
            localWindowManager.removeView(localView);
          }
        }
        this.G.removeAllElements();
      }
    }
  }
  
  public final int hashCode()
  {
    return toString().hashCode();
  }
  
  final void i()
  {
    if (this.b != null)
    {
      Context localContext = this.b.getContext();
      Iterator localIterator = this.o.iterator();
      while (localIterator.hasNext()) {
        e.a((String)localIterator.next(), "impression_request", AdManager.getUserId(localContext)).g();
      }
    }
  }
  
  public final String toString()
  {
    String str = this.j;
    if (str == null) {
      str = "";
    }
    return str;
  }
  
  protected static class a
  {
    WeakReference<AdView> a;
    
    public a(AdView paramAdView)
    {
      this.a = new WeakReference(paramAdView);
    }
    
    public void a()
    {
      AdView localAdView = (AdView)this.a.get();
      if (localAdView != null) {
        AdView.c(localAdView);
      }
    }
    
    public void a(d paramd)
    {
      AdView localAdView = (AdView)this.a.get();
      if (localAdView != null) {
        try
        {
          if ((AdView.a(localAdView) != null) && (paramd.equals(AdView.a(localAdView).b()))) {
            if (Log.isLoggable("AdMobSDK", 3)) {
              Log.d("AdMobSDK", "Received the same ad we already had.  Discarding it.");
            }
          }
          for (;;)
          {
            return;
            if (Log.isLoggable("AdMobSDK", 4)) {
              Log.i("AdMobSDK", "Ad returned (" + (SystemClock.uptimeMillis() - AdView.g(localAdView)) + " ms):  " + paramd);
            }
            localAdView.getContext();
            localAdView.a(paramd, paramd.b());
          }
          return;
        }
        finally {}
      }
    }
  }
  
  static abstract interface b
  {
    public abstract void a();
  }
  
  static final class c
    implements Runnable
  {
    private String a;
    private int b;
    private int c;
    private String d;
    private WeakReference<d> e;
    
    public c(String paramString1, String paramString2, int paramInt1, int paramInt2, d paramd)
    {
      this.a = paramString1;
      this.b = 320;
      this.c = 295;
      this.d = paramString2;
      this.e = new WeakReference(paramd);
    }
    
    public final void run()
    {
      try
      {
        d locald = (d)this.e.get();
        if ((locald != null) && (locald.b != null))
        {
          Context localContext = locald.b.getContext();
          WindowManager localWindowManager = (WindowManager)localContext.getSystemService("window");
          WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams(-1, -1, 1000, 2, -3);
          localLayoutParams.dimAmount = 0.75F;
          locald.a = locald.a(localContext, this.a, this.d, this.b, this.c);
          localWindowManager.addView(locald.a, localLayoutParams);
          locald.a(locald.a);
        }
        return;
      }
      catch (Exception localException)
      {
        while (!Log.isLoggable("AdMobSDK", 6)) {}
        Log.e("AdMobSDK", "exception caught in Ad$WebViewLoader.run(), " + localException.getMessage());
      }
    }
  }
  
  private static final class d
    implements Runnable
  {
    Vector<d.g> a = new Vector();
    private g b;
    private WeakReference<d> c;
    
    public d(g paramg, d paramd)
    {
      this.b = paramg;
      this.c = new WeakReference(paramd);
    }
    
    public final void run()
    {
      try
      {
        if (this.b == null) {
          break label169;
        }
        this.b.setPadding(0, 0, 0, 0);
        Iterator localIterator = this.a.iterator();
        while (localIterator.hasNext())
        {
          d.g localg = (d.g)localIterator.next();
          View localView = localg.a;
          this.b.addView(localView, localg.b);
          AnimationSet localAnimationSet = localg.c;
          if (localAnimationSet != null)
          {
            localView.startAnimation(localAnimationSet);
            continue;
            return;
          }
        }
      }
      catch (Exception localException)
      {
        if (Log.isLoggable("AdMobSDK", 6)) {
          Log.e("AdMobSDK", "exception caught in Ad$ViewAdd.run(), " + localException.getMessage());
        }
      }
      this.b.invalidate();
      this.b.requestLayout();
      for (;;)
      {
        d locald = (d)this.c.get();
        if (locald == null) {
          break;
        }
        d.a(locald);
        return;
        label169:
        if (Log.isLoggable("AdMobSDK", 6)) {
          Log.e("AdMobSDK", "containerView was null in ViewAdd!");
        }
      }
    }
  }
  
  private static final class e
  {
    public String a;
    public boolean b;
    
    public e(String paramString, boolean paramBoolean)
    {
      this.a = paramString;
      this.b = paramBoolean;
    }
  }
  
  protected static enum f
  {
    static
    {
      f[] arrayOff = new f[8];
      arrayOff[0] = a;
      arrayOff[1] = b;
      arrayOff[2] = c;
      arrayOff[3] = d;
      arrayOff[4] = e;
      arrayOff[5] = f;
      arrayOff[6] = g;
      arrayOff[7] = h;
      i = arrayOff;
    }
    
    private f() {}
  }
  
  private static final class g
  {
    public View a;
    public RelativeLayout.LayoutParams b;
    public AnimationSet c;
    
    private g(byte paramByte) {}
  }
}


/* Location:              F:\Java\android-giro-gamer\Decompile\1\doodle_dex2jar.jar!\com\admob\android\ads\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */