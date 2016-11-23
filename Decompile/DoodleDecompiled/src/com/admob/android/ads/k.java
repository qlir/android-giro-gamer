package com.admob.android.ads;

import android.graphics.Color;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public final class k
  extends Animation
{
  private int[] a;
  private int[] b;
  private View c;
  
  public k(int paramInt1, int paramInt2, View paramView)
  {
    this.c = paramView;
    this.a = new int[4];
    this.b = new int[4];
    this.a[0] = Color.alpha(paramInt1);
    this.a[1] = Color.red(paramInt1);
    this.a[2] = Color.green(paramInt1);
    this.a[3] = Color.blue(paramInt1);
    this.b[0] = Color.alpha(paramInt2);
    this.b[1] = Color.red(paramInt2);
    this.b[2] = Color.green(paramInt2);
    this.b[3] = Color.blue(paramInt2);
  }
  
  protected final void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    paramTransformation.setTransformationType(Transformation.TYPE_IDENTITY);
    if ((paramFloat < 0.0D) || (paramFloat > 1.0D)) {
      return;
    }
    int[] arrayOfInt = new int[4];
    for (int i = 0; i < 4; i++) {
      arrayOfInt[i] = ((int)(this.a[i] + paramFloat * (this.b[i] - this.a[i])));
    }
    int j = Color.argb(arrayOfInt[0], arrayOfInt[1], arrayOfInt[2], arrayOfInt[3]);
    this.c.setBackgroundColor(j);
  }
}


/* Location:              F:\Java\android-giro-gamer\Decompile\1\doodle_dex2jar.jar!\com\admob\android\ads\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */