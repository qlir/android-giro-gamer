package com.admob.android.ads;

import android.view.View;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public final class b
  extends Animation
{
  private View a;
  private float b;
  private float c;
  
  public b(float paramFloat1, float paramFloat2, View paramView)
  {
    this.b = paramFloat1;
    this.c = paramFloat2;
    this.a = paramView;
  }
  
  protected final void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    paramTransformation.setTransformationType(Transformation.TYPE_IDENTITY);
    if ((paramFloat < 0.0D) || (paramFloat > 1.0D)) {}
    ViewParent localViewParent;
    do
    {
      return;
      float f = this.b + paramFloat * (this.c - this.b);
      View localView = this.a;
      if (localView != null)
      {
        f localf = f.c(localView);
        localf.a = f;
        localView.setTag(localf);
      }
      localViewParent = this.a.getParent();
    } while (!(localViewParent instanceof a));
    ((a)localViewParent).f();
  }
  
  public static abstract interface a
  {
    public abstract void f();
  }
}


/* Location:              F:\Java\android-giro-gamer\Decompile\1\doodle_dex2jar.jar!\com\admob\android\ads\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */