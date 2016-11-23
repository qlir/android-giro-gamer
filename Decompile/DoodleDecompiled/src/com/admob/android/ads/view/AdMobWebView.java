package com.admob.android.ads.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Parcelable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import com.admob.android.ads.d;
import com.admob.android.ads.r;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Hashtable;
import java.util.StringTokenizer;

public class AdMobWebView
  extends WebView
{
  String a;
  public String b;
  boolean c;
  private RelativeLayout d;
  private d e;
  
  public AdMobWebView(Context paramContext, RelativeLayout paramRelativeLayout, String paramString, d paramd)
  {
    super(paramContext);
    this.e = paramd;
    this.d = paramRelativeLayout;
    WebSettings localWebSettings = getSettings();
    localWebSettings.setLoadsImagesAutomatically(true);
    localWebSettings.setPluginsEnabled(true);
    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setJavaScriptCanOpenWindowsAutomatically(true);
    localWebSettings.setSaveFormData(false);
    localWebSettings.setSavePassword(false);
    localWebSettings.setUserAgentString(r.c());
    setWebViewClient(new a(this));
    this.c = true;
    this.a = paramString;
  }
  
  public final void a()
  {
    if (this.e != null) {
      this.e.b(this.d);
    }
    ((WindowManager)getContext().getSystemService("window")).removeView(this.d);
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    Log.d("AdMobSDK", "onFocusChanged(" + paramBoolean + ")");
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      a();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    Log.d("AdMobSDK", "onSaveInstanceState()");
    return super.onSaveInstanceState();
  }
  
  protected void onWindowVisibilityChanged(int paramInt)
  {
    Log.d("AdMobSDK", "onWindowVisibilityChanged(" + paramInt + ")");
    super.onWindowVisibilityChanged(paramInt);
  }
  
  private final class a
    extends WebViewClient
  {
    private AdMobWebView a;
    
    public a(AdMobWebView paramAdMobWebView)
    {
      this.a = paramAdMobWebView;
    }
    
    private static Hashtable<String, String> a(String paramString)
    {
      Hashtable localHashtable = null;
      if (paramString != null)
      {
        localHashtable = new Hashtable();
        StringTokenizer localStringTokenizer1 = new StringTokenizer(paramString, "&");
        while (localStringTokenizer1.hasMoreTokens())
        {
          StringTokenizer localStringTokenizer2 = new StringTokenizer(localStringTokenizer1.nextToken(), "=");
          if (localStringTokenizer2.hasMoreTokens())
          {
            String str1 = localStringTokenizer2.nextToken();
            if (localStringTokenizer2.hasMoreTokens())
            {
              String str2 = localStringTokenizer2.nextToken();
              if ((str1 != null) && (str2 != null)) {
                localHashtable.put(str1, str2);
              }
            }
          }
        }
      }
      return localHashtable;
    }
    
    public final void onPageFinished(WebView paramWebView, String paramString)
    {
      if (("http://mm.admob.com/static/android/canvas.html".equals(paramString)) && (this.a.c))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("javascript:cb('");
        localStringBuilder.append(AdMobWebView.this.b);
        localStringBuilder.append("','");
        localStringBuilder.append(AdMobWebView.this.a);
        localStringBuilder.append("')");
        this.a.c = false;
        this.a.loadUrl(localStringBuilder.toString());
      }
    }
    
    public final boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      try
      {
        URI localURI = new URI(paramString);
        if ("admob".equals(localURI.getScheme()))
        {
          String str1 = localURI.getHost();
          if ("launch".equals(str1))
          {
            String str2 = localURI.getQuery();
            if (str2 != null)
            {
              Hashtable localHashtable = a(str2);
              if (localHashtable != null)
              {
                String str3 = (String)localHashtable.get("url");
                if (str3 != null)
                {
                  AdMobWebView.this.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str3)));
                  this.a.a();
                  return true;
                }
              }
            }
          }
          else if (("closecanvas".equals(str1)) && (paramWebView == this.a))
          {
            this.a.a();
            return true;
          }
        }
      }
      catch (URISyntaxException localURISyntaxException)
      {
        Log.w("AdMobSDK", "Bad link URL in AdMob web view.", localURISyntaxException);
      }
      return false;
    }
  }
}


/* Location:              F:\Java\android-giro-gamer\Decompile\1\doodle_dex2jar.jar!\com\admob\android\ads\view\AdMobWebView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */