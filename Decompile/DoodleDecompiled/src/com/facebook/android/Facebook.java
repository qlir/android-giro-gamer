package com.facebook.android;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.CookieSyncManager;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

public class Facebook
{
  public static final String CANCEL_URI = "fbconnect:cancel";
  public static final String EXPIRES = "expires_in";
  protected static String GRAPH_BASE_URL = "https://graph.facebook.com/";
  private static final String LOGIN = "login";
  protected static String OAUTH_ENDPOINT = "https://graph.facebook.com/oauth/authorize";
  public static final String REDIRECT_URI = "fbconnect://success";
  protected static String RESTSERVER_URL = "https://api.facebook.com/restserver.php";
  public static final String TOKEN = "access_token";
  protected static String UI_SERVER = "https://www.facebook.com/connect/uiserver.php";
  private long mAccessExpires = 0L;
  private String mAccessToken = null;
  
  public void authorize(Context paramContext, String paramString, String[] paramArrayOfString, final DialogListener paramDialogListener)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("client_id", paramString);
    if (paramArrayOfString.length > 0) {
      localBundle.putString("scope", TextUtils.join(",", paramArrayOfString));
    }
    CookieSyncManager.createInstance(paramContext);
    dialog(paramContext, "login", localBundle, new DialogListener()
    {
      public void onCancel()
      {
        Log.d("Facebook-authorize", "Login cancelled");
        paramDialogListener.onCancel();
      }
      
      public void onComplete(Bundle paramAnonymousBundle)
      {
        CookieSyncManager.getInstance().sync();
        Facebook.this.setAccessToken(paramAnonymousBundle.getString("access_token"));
        Facebook.this.setAccessExpiresIn(paramAnonymousBundle.getString("expires_in"));
        if (Facebook.this.isSessionValid())
        {
          Log.d("Facebook-authorize", "Login Success! access_token=" + Facebook.this.getAccessToken() + " expires=" + Facebook.this.getAccessExpires());
          paramDialogListener.onComplete(paramAnonymousBundle);
          return;
        }
        onFacebookError(new FacebookError("failed to receive access_token"));
      }
      
      public void onError(DialogError paramAnonymousDialogError)
      {
        Log.d("Facebook-authorize", "Login failed: " + paramAnonymousDialogError);
        paramDialogListener.onError(paramAnonymousDialogError);
      }
      
      public void onFacebookError(FacebookError paramAnonymousFacebookError)
      {
        Log.d("Facebook-authorize", "Login failed: " + paramAnonymousFacebookError);
        paramDialogListener.onFacebookError(paramAnonymousFacebookError);
      }
    });
  }
  
  public void dialog(Context paramContext, String paramString, Bundle paramBundle, DialogListener paramDialogListener)
  {
    String str1;
    if (paramString.equals("login"))
    {
      str1 = OAUTH_ENDPOINT;
      paramBundle.putString("type", "user_agent");
      paramBundle.putString("redirect_uri", "fbconnect://success");
    }
    String str2;
    for (;;)
    {
      paramBundle.putString("display", "touch");
      if (isSessionValid()) {
        paramBundle.putString("access_token", getAccessToken());
      }
      str2 = str1 + "?" + Util.encodeUrl(paramBundle);
      if (paramContext.checkCallingOrSelfPermission("android.permission.INTERNET") == 0) {
        break;
      }
      Util.showAlert(paramContext, "Error", "Application requires permission to access the Internet");
      return;
      str1 = UI_SERVER;
      paramBundle.putString("method", paramString);
      paramBundle.putString("next", "fbconnect://success");
    }
    new FbDialog(paramContext, str2, paramDialogListener).show();
  }
  
  public void dialog(Context paramContext, String paramString, DialogListener paramDialogListener)
  {
    dialog(paramContext, paramString, new Bundle(), paramDialogListener);
  }
  
  public long getAccessExpires()
  {
    return this.mAccessExpires;
  }
  
  public String getAccessToken()
  {
    return this.mAccessToken;
  }
  
  public boolean isSessionValid()
  {
    return (getAccessToken() != null) && ((getAccessExpires() == 0L) || (System.currentTimeMillis() < getAccessExpires()));
  }
  
  public String logout(Context paramContext)
    throws MalformedURLException, IOException
  {
    Util.clearCookies(paramContext);
    Bundle localBundle = new Bundle();
    localBundle.putString("method", "auth.expireSession");
    String str = request(localBundle);
    setAccessToken(null);
    setAccessExpires(0L);
    return str;
  }
  
  public String request(Bundle paramBundle)
    throws MalformedURLException, IOException
  {
    if (!paramBundle.containsKey("method")) {
      throw new IllegalArgumentException("API method must be specified. (parameters must contain key \"method\" and value). See http://developers.facebook.com/docs/reference/rest/");
    }
    return request(null, paramBundle, "GET");
  }
  
  public String request(String paramString)
    throws MalformedURLException, IOException
  {
    return request(paramString, new Bundle(), "GET");
  }
  
  public String request(String paramString, Bundle paramBundle)
    throws MalformedURLException, IOException
  {
    return request(paramString, paramBundle, "GET");
  }
  
  public String request(String paramString1, Bundle paramBundle, String paramString2)
    throws FileNotFoundException, MalformedURLException, IOException
  {
    paramBundle.putString("format", "json");
    if (isSessionValid()) {
      paramBundle.putString("access_token", getAccessToken());
    }
    if (paramString1 != null) {}
    for (String str = GRAPH_BASE_URL + paramString1;; str = RESTSERVER_URL) {
      return Util.openUrl(str, paramString2, paramBundle);
    }
  }
  
  public void setAccessExpires(long paramLong)
  {
    this.mAccessExpires = paramLong;
  }
  
  public void setAccessExpiresIn(String paramString)
  {
    if ((paramString != null) && (!paramString.equals("0"))) {
      setAccessExpires(System.currentTimeMillis() + 1000 * Integer.parseInt(paramString));
    }
  }
  
  public void setAccessToken(String paramString)
  {
    this.mAccessToken = paramString;
  }
  
  public static abstract interface DialogListener
  {
    public abstract void onCancel();
    
    public abstract void onComplete(Bundle paramBundle);
    
    public abstract void onError(DialogError paramDialogError);
    
    public abstract void onFacebookError(FacebookError paramFacebookError);
  }
}


/* Location:              F:\Java\android-giro-gamer\Decompile\1\doodle_dex2jar.jar!\com\facebook\android\Facebook.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */