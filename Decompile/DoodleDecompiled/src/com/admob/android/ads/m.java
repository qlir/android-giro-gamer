package com.admob.android.ads;

import android.view.animation.AlphaAnimation;
import android.view.animation.Transformation;

public final class m
  extends AlphaAnimation
{
  public m(float paramFloat1, float paramFloat2)
  {
    super(paramFloat1, paramFloat2);
  }
  
  protected final void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    if ((paramFloat >= 0.0D) || (paramFloat <= 1.0D)) {
      super.applyTransformation(paramFloat, paramTransformation);
    }
  }
}


/* Location:              F:\Java\android-giro-gamer\Decompile\1\doodle_dex2jar.jar!\com\admob\android\ads\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */