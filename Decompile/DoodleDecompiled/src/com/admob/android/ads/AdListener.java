package com.admob.android.ads;

public abstract interface AdListener
{
  public abstract void onFailedToReceiveAd(AdView paramAdView);
  
  public abstract void onFailedToReceiveRefreshedAd(AdView paramAdView);
  
  public abstract void onReceiveAd(AdView paramAdView);
  
  public abstract void onReceiveRefreshedAd(AdView paramAdView);
}


/* Location:              F:\Java\android-giro-gamer\Decompile\1\doodle_dex2jar.jar!\com\admob\android\ads\AdListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */