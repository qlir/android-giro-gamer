package com.facebook.android;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FbDialog
  extends Dialog
{
  static final float[] DIMENSIONS_LANDSCAPE = { 460.0F, 260.0F };
  static final float[] DIMENSIONS_PORTRAIT = { 280.0F, 420.0F };
  static final String DISPLAY_STRING = "touch";
  static final int FB_BLUE = -9599820;
  static final String FB_ICON = "icon.png";
  static final FrameLayout.LayoutParams FILL = new FrameLayout.LayoutParams(-1, -1);
  static final int MARGIN = 4;
  static final int PADDING = 2;
  private LinearLayout mContent;
  private Facebook.DialogListener mListener;
  private ProgressDialog mSpinner;
  private TextView mTitle;
  private String mUrl;
  private WebView mWebView;
  
  public FbDialog(Context paramContext, String paramString, Facebook.DialogListener paramDialogListener)
  {
    super(paramContext);
    this.mUrl = paramString;
    this.mListener = paramDialogListener;
  }
  
  private void setUpTitle()
  {
    requestWindowFeature(1);
    this.mTitle = new TextView(getContext());
    this.mTitle.setText("Facebook");
    this.mTitle.setTextColor(-1);
    this.mTitle.setTypeface(Typeface.DEFAULT_BOLD);
    this.mTitle.setBackgroundColor(-9599820);
    this.mTitle.setPadding(6, 4, 4, 4);
    this.mTitle.setCompoundDrawablePadding(6);
    this.mTitle.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    this.mContent.addView(this.mTitle);
  }
  
  private void setUpWebView()
  {
    this.mWebView = new WebView(getContext());
    this.mWebView.setVerticalScrollBarEnabled(false);
    this.mWebView.setHorizontalScrollBarEnabled(false);
    this.mWebView.setWebViewClient(new FbWebViewClient(null));
    this.mWebView.getSettings().setJavaScriptEnabled(true);
    this.mWebView.loadUrl(this.mUrl);
    this.mWebView.setLayoutParams(FILL);
    this.mContent.addView(this.mWebView);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mSpinner = new ProgressDialog(getContext());
    this.mSpinner.requestWindowFeature(1);
    this.mSpinner.setMessage("Loading...");
    this.mContent = new LinearLayout(getContext());
    this.mContent.setOrientation(1);
    setUpTitle();
    setUpWebView();
    Display localDisplay = getWindow().getWindowManager().getDefaultDisplay();
    float f = getContext().getResources().getDisplayMetrics().density;
    if (localDisplay.getWidth() < localDisplay.getHeight()) {}
    for (float[] arrayOfFloat = DIMENSIONS_PORTRAIT;; arrayOfFloat = DIMENSIONS_LANDSCAPE)
    {
      addContentView(this.mContent, new FrameLayout.LayoutParams((int)(0.5F + f * arrayOfFloat[0]), (int)(0.5F + f * arrayOfFloat[1])));
      return;
    }
  }
  
  private class FbWebViewClient
    extends WebViewClient
  {
    private FbWebViewClient() {}
    
    public void onPageFinished(WebView paramWebView, String paramString)
    {
      super.onPageFinished(paramWebView, paramString);
      String str = FbDialog.this.mWebView.getTitle();
      if ((str != null) && (str.length() > 0)) {
        FbDialog.this.mTitle.setText(str);
      }
      FbDialog.this.mSpinner.dismiss();
    }
    
    public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      Log.d("Facebook-WebView", "Webview loading URL: " + paramString);
      super.onPageStarted(paramWebView, paramString, paramBitmap);
      FbDialog.this.mSpinner.show();
    }
    
    public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
      FbDialog.this.mListener.onError(new DialogError(paramString1, paramInt, paramString2));
      FbDialog.this.dismiss();
    }
    
    public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      Log.d("Facebook-WebView", "Redirect URL: " + paramString);
      if (paramString.startsWith("fbconnect://success"))
      {
        Bundle localBundle = Util.parseUrl(paramString);
        String str = localBundle.getString("error_reason");
        if (str == null) {
          FbDialog.this.mListener.onComplete(localBundle);
        }
        for (;;)
        {
          FbDialog.this.dismiss();
          return true;
          FbDialog.this.mListener.onFacebookError(new FacebookError(str));
        }
      }
      if (paramString.startsWith("fbconnect:cancel"))
      {
        FbDialog.this.mListener.onCancel();
        FbDialog.this.dismiss();
        return true;
      }
      if (paramString.contains("touch")) {
        return false;
      }
      FbDialog.this.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(paramString)));
      return true;
    }
  }
}


/* Location:              F:\Java\android-giro-gamer\Decompile\1\doodle_dex2jar.jar!\com\facebook\android\FbDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */