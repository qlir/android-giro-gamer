package com.admob.android.ads;

import java.lang.ref.WeakReference;

final class a
  extends Thread
{
  private WeakReference<AdView> a;
  
  public a(AdView paramAdView)
  {
    this.a = new WeakReference(paramAdView);
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 19	com/admob/android/ads/a:a	Ljava/lang/ref/WeakReference;
    //   4: invokevirtual 26	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   7: checkcast 28	com/admob/android/ads/AdView
    //   10: astore_1
    //   11: aload_1
    //   12: ifnull +75 -> 87
    //   15: aload_1
    //   16: invokevirtual 32	com/admob/android/ads/AdView:getContext	()Landroid/content/Context;
    //   19: astore 7
    //   21: new 34	com/admob/android/ads/g
    //   24: dup
    //   25: aconst_null
    //   26: aload 7
    //   28: aload_1
    //   29: invokespecial 37	com/admob/android/ads/g:<init>	(Lcom/admob/android/ads/d;Landroid/content/Context;Lcom/admob/android/ads/AdView;)V
    //   32: astore 8
    //   34: aload_1
    //   35: invokevirtual 41	com/admob/android/ads/AdView:getMeasuredWidth	()I
    //   38: i2f
    //   39: invokestatic 45	com/admob/android/ads/g:c	()F
    //   42: fdiv
    //   43: f2i
    //   44: istore 9
    //   46: iload 9
    //   48: i2f
    //   49: ldc 46
    //   51: fcmpg
    //   52: ifgt +36 -> 88
    //   55: ldc 48
    //   57: iconst_3
    //   58: invokestatic 54	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   61: ifeq +11 -> 72
    //   64: ldc 48
    //   66: ldc 56
    //   68: invokestatic 60	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   71: pop
    //   72: aload_1
    //   73: invokestatic 62	com/admob/android/ads/AdView:c	(Lcom/admob/android/ads/AdView;)V
    //   76: aload_1
    //   77: iconst_0
    //   78: invokestatic 65	com/admob/android/ads/AdView:a	(Lcom/admob/android/ads/AdView;Z)Z
    //   81: pop
    //   82: aload_1
    //   83: iconst_1
    //   84: invokestatic 69	com/admob/android/ads/AdView:b	(Lcom/admob/android/ads/AdView;Z)V
    //   87: return
    //   88: aload_1
    //   89: invokestatic 72	com/admob/android/ads/AdView:d	(Lcom/admob/android/ads/AdView;)Lcom/admob/android/ads/d$a;
    //   92: aload 7
    //   94: aload_1
    //   95: invokestatic 76	com/admob/android/ads/AdView:e	(Lcom/admob/android/ads/AdView;)Ljava/lang/String;
    //   98: aload_1
    //   99: invokestatic 79	com/admob/android/ads/AdView:f	(Lcom/admob/android/ads/AdView;)Ljava/lang/String;
    //   102: aload_1
    //   103: invokevirtual 82	com/admob/android/ads/AdView:getPrimaryTextColor	()I
    //   106: aload_1
    //   107: invokevirtual 85	com/admob/android/ads/AdView:getSecondaryTextColor	()I
    //   110: aload_1
    //   111: invokevirtual 88	com/admob/android/ads/AdView:getBackgroundColor	()I
    //   114: aload 8
    //   116: iload 9
    //   118: invokestatic 93	com/admob/android/ads/u:a	(Lcom/admob/android/ads/d$a;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;IIILcom/admob/android/ads/g;I)Lcom/admob/android/ads/d;
    //   121: ifnonnull -45 -> 76
    //   124: aload_1
    //   125: invokestatic 62	com/admob/android/ads/AdView:c	(Lcom/admob/android/ads/AdView;)V
    //   128: goto -52 -> 76
    //   131: astore 4
    //   133: ldc 48
    //   135: ldc 95
    //   137: aload 4
    //   139: invokestatic 98	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   142: pop
    //   143: aload_1
    //   144: invokestatic 62	com/admob/android/ads/AdView:c	(Lcom/admob/android/ads/AdView;)V
    //   147: aload_1
    //   148: iconst_0
    //   149: invokestatic 65	com/admob/android/ads/AdView:a	(Lcom/admob/android/ads/AdView;Z)Z
    //   152: pop
    //   153: aload_1
    //   154: iconst_1
    //   155: invokestatic 69	com/admob/android/ads/AdView:b	(Lcom/admob/android/ads/AdView;Z)V
    //   158: return
    //   159: astore_2
    //   160: aload_1
    //   161: iconst_0
    //   162: invokestatic 65	com/admob/android/ads/AdView:a	(Lcom/admob/android/ads/AdView;Z)Z
    //   165: pop
    //   166: aload_1
    //   167: iconst_1
    //   168: invokestatic 69	com/admob/android/ads/AdView:b	(Lcom/admob/android/ads/AdView;Z)V
    //   171: aload_2
    //   172: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	173	0	this	a
    //   10	157	1	localAdView	AdView
    //   159	13	2	localObject	Object
    //   131	7	4	localException	Exception
    //   19	74	7	localContext	android.content.Context
    //   32	83	8	localg	g
    //   44	73	9	i	int
    // Exception table:
    //   from	to	target	type
    //   15	46	131	java/lang/Exception
    //   55	72	131	java/lang/Exception
    //   72	76	131	java/lang/Exception
    //   88	128	131	java/lang/Exception
    //   15	46	159	finally
    //   55	72	159	finally
    //   72	76	159	finally
    //   88	128	159	finally
    //   133	147	159	finally
  }
}


/* Location:              F:\Java\android-giro-gamer\Decompile\1\doodle_dex2jar.jar!\com\admob\android\ads\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */