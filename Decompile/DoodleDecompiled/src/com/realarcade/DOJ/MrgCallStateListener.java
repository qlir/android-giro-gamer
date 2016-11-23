package com.realarcade.DOJ;

import android.content.Intent;
import android.telephony.PhoneStateListener;

class MrgCallStateListener
  extends PhoneStateListener
{
  public void onCallStateChanged(int paramInt, String paramString)
  {
    if (MrGame.android_appStatus == 3) {}
    do
    {
      return;
      switch (paramInt)
      {
      default: 
        return;
      }
    } while (MrGame.android_appStatus != 2);
    MrGame.android_appStatus = 1;
    Intent localIntent = MrGame.p_mrgame.getIntent();
    localIntent.addFlags(131072);
    MrGame.p_mrgame.startActivity(localIntent);
    return;
    MrGame.android_appStatus = 2;
  }
}


/* Location:              F:\Java\android-giro-gamer\Decompile\1\doodle_dex2jar.jar!\com\realarcade\DOJ\MrgCallStateListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */