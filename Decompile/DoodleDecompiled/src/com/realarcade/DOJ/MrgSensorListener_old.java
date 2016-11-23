package com.realarcade.DOJ;

import android.hardware.SensorListener;

class MrgSensorListener_old
  implements SensorListener
{
  public void onAccuracyChanged(int paramInt1, int paramInt2) {}
  
  public void onSensorChanged(int paramInt, float[] paramArrayOfFloat)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    switch (MrGame.device_orientation)
    {
    default: 
      return;
    case 1: 
      MrGame.p_acceleration_x = (int)(32768.0F * paramArrayOfFloat[3] / 9.80665F);
      MrGame.p_acceleration_y = (int)(32768.0F * paramArrayOfFloat[4] / 9.80665F);
      MrGame.p_acceleration_z = (int)(32768.0F * paramArrayOfFloat[5] / 9.80665F);
      return;
    }
    MrGame.p_acceleration_x = (int)(-(32768.0F * paramArrayOfFloat[4]) / 9.80665F);
    MrGame.p_acceleration_y = (int)(32768.0F * paramArrayOfFloat[3] / 9.80665F);
    MrGame.p_acceleration_z = (int)(32768.0F * paramArrayOfFloat[5] / 9.80665F);
  }
}


/* Location:              F:\Java\android-giro-gamer\Decompile\1\doodle_dex2jar.jar!\com\realarcade\DOJ\MrgSensorListener_old.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */