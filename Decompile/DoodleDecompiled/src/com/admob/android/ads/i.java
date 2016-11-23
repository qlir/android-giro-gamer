package com.admob.android.ads;

import android.util.Log;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

final class i
  extends r
{
  private HttpURLConnection m;
  private URL n;
  
  public i(String paramString1, String paramString2, String paramString3, h paramh, int paramInt, Map<String, String> paramMap, String paramString4)
  {
    super(paramString2, paramString3, paramh, paramInt, paramMap, paramString4);
    try
    {
      this.n = new URL(paramString1);
      this.i = this.n;
      this.m = null;
      this.e = 0;
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      for (;;)
      {
        this.n = null;
        this.c = localMalformedURLException;
      }
    }
  }
  
  private void h()
  {
    if (this.m != null)
    {
      this.m.disconnect();
      this.m = null;
    }
  }
  
  /* Error */
  public final boolean a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 22	com/admob/android/ads/i:n	Ljava/net/URL;
    //   4: ifnonnull +58 -> 62
    //   7: aload_0
    //   8: getfield 49	com/admob/android/ads/i:h	Lcom/admob/android/ads/h;
    //   11: ifnull +22 -> 33
    //   14: aload_0
    //   15: getfield 49	com/admob/android/ads/i:h	Lcom/admob/android/ads/h;
    //   18: aload_0
    //   19: new 46	java/lang/Exception
    //   22: dup
    //   23: ldc 51
    //   25: invokespecial 52	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   28: invokeinterface 57 3 0
    //   33: iconst_0
    //   34: istore_2
    //   35: iload_2
    //   36: ifne +24 -> 60
    //   39: aload_0
    //   40: getfield 49	com/admob/android/ads/i:h	Lcom/admob/android/ads/h;
    //   43: ifnull +17 -> 60
    //   46: aload_0
    //   47: getfield 49	com/admob/android/ads/i:h	Lcom/admob/android/ads/h;
    //   50: aload_0
    //   51: aload_0
    //   52: getfield 35	com/admob/android/ads/i:c	Ljava/lang/Exception;
    //   55: invokeinterface 57 3 0
    //   60: iload_2
    //   61: ireturn
    //   62: iconst_1
    //   63: invokestatic 61	java/net/HttpURLConnection:setFollowRedirects	(Z)V
    //   66: iconst_0
    //   67: istore_1
    //   68: aload_0
    //   69: getfield 31	com/admob/android/ads/i:e	I
    //   72: aload_0
    //   73: getfield 64	com/admob/android/ads/i:f	I
    //   76: if_icmpge +673 -> 749
    //   79: iload_1
    //   80: ifne +669 -> 749
    //   83: ldc 66
    //   85: iconst_2
    //   86: invokestatic 72	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   89: ifeq +43 -> 132
    //   92: ldc 66
    //   94: new 74	java/lang/StringBuilder
    //   97: dup
    //   98: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   101: ldc 78
    //   103: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: aload_0
    //   107: getfield 31	com/admob/android/ads/i:e	I
    //   110: invokevirtual 85	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   113: ldc 87
    //   115: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: aload_0
    //   119: getfield 22	com/admob/android/ads/i:n	Ljava/net/URL;
    //   122: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   125: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: invokestatic 98	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   131: pop
    //   132: aload_0
    //   133: invokespecial 100	com/admob/android/ads/i:h	()V
    //   136: aload_0
    //   137: aload_0
    //   138: getfield 22	com/admob/android/ads/i:n	Ljava/net/URL;
    //   141: invokevirtual 104	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   144: checkcast 39	java/net/HttpURLConnection
    //   147: putfield 27	com/admob/android/ads/i:m	Ljava/net/HttpURLConnection;
    //   150: aload_0
    //   151: getfield 27	com/admob/android/ads/i:m	Ljava/net/HttpURLConnection;
    //   154: ifnull +589 -> 743
    //   157: aload_0
    //   158: getfield 27	com/admob/android/ads/i:m	Ljava/net/HttpURLConnection;
    //   161: ldc 106
    //   163: invokestatic 108	com/admob/android/ads/i:c	()Ljava/lang/String;
    //   166: invokevirtual 112	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   169: aload_0
    //   170: getfield 116	com/admob/android/ads/i:g	Ljava/lang/String;
    //   173: ifnull +16 -> 189
    //   176: aload_0
    //   177: getfield 27	com/admob/android/ads/i:m	Ljava/net/HttpURLConnection;
    //   180: ldc 118
    //   182: aload_0
    //   183: getfield 116	com/admob/android/ads/i:g	Ljava/lang/String;
    //   186: invokevirtual 112	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   189: aload_0
    //   190: getfield 27	com/admob/android/ads/i:m	Ljava/net/HttpURLConnection;
    //   193: aload_0
    //   194: getfield 121	com/admob/android/ads/i:b	I
    //   197: invokevirtual 125	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   200: aload_0
    //   201: getfield 27	com/admob/android/ads/i:m	Ljava/net/HttpURLConnection;
    //   204: aload_0
    //   205: getfield 121	com/admob/android/ads/i:b	I
    //   208: invokevirtual 128	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   211: aload_0
    //   212: getfield 132	com/admob/android/ads/i:d	Ljava/util/Map;
    //   215: ifnull +155 -> 370
    //   218: aload_0
    //   219: getfield 132	com/admob/android/ads/i:d	Ljava/util/Map;
    //   222: invokeinterface 138 1 0
    //   227: invokeinterface 144 1 0
    //   232: astore 20
    //   234: aload 20
    //   236: invokeinterface 149 1 0
    //   241: ifeq +129 -> 370
    //   244: aload 20
    //   246: invokeinterface 153 1 0
    //   251: checkcast 155	java/lang/String
    //   254: astore 21
    //   256: aload 21
    //   258: ifnull -24 -> 234
    //   261: aload_0
    //   262: getfield 132	com/admob/android/ads/i:d	Ljava/util/Map;
    //   265: aload 21
    //   267: invokeinterface 159 2 0
    //   272: checkcast 155	java/lang/String
    //   275: astore 22
    //   277: aload 22
    //   279: ifnull -45 -> 234
    //   282: aload_0
    //   283: getfield 27	com/admob/android/ads/i:m	Ljava/net/HttpURLConnection;
    //   286: aload 21
    //   288: aload 22
    //   290: invokevirtual 162	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   293: goto -59 -> 234
    //   296: astore 6
    //   298: aconst_null
    //   299: astore 4
    //   301: ldc 66
    //   303: new 74	java/lang/StringBuilder
    //   306: dup
    //   307: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   310: ldc -92
    //   312: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: aload_0
    //   316: getfield 22	com/admob/android/ads/i:n	Ljava/net/URL;
    //   319: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   322: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   325: aload 6
    //   327: invokestatic 168	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   330: pop
    //   331: aload_0
    //   332: aload 6
    //   334: putfield 35	com/admob/android/ads/i:c	Ljava/lang/Exception;
    //   337: aload 4
    //   339: ifnull +8 -> 347
    //   342: aload 4
    //   344: invokevirtual 173	java/io/BufferedWriter:close	()V
    //   347: aload_0
    //   348: invokespecial 100	com/admob/android/ads/i:h	()V
    //   351: iconst_0
    //   352: istore 8
    //   354: aload_0
    //   355: iconst_1
    //   356: aload_0
    //   357: getfield 31	com/admob/android/ads/i:e	I
    //   360: iadd
    //   361: putfield 31	com/admob/android/ads/i:e	I
    //   364: iload 8
    //   366: istore_1
    //   367: goto -299 -> 68
    //   370: aload_0
    //   371: getfield 176	com/admob/android/ads/i:l	Ljava/lang/String;
    //   374: ifnull +259 -> 633
    //   377: aload_0
    //   378: getfield 27	com/admob/android/ads/i:m	Ljava/net/HttpURLConnection;
    //   381: ldc -78
    //   383: invokevirtual 181	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   386: aload_0
    //   387: getfield 27	com/admob/android/ads/i:m	Ljava/net/HttpURLConnection;
    //   390: iconst_1
    //   391: invokevirtual 184	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   394: aload_0
    //   395: getfield 27	com/admob/android/ads/i:m	Ljava/net/HttpURLConnection;
    //   398: ldc -70
    //   400: aload_0
    //   401: getfield 188	com/admob/android/ads/i:a	Ljava/lang/String;
    //   404: invokevirtual 112	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   407: aload_0
    //   408: getfield 27	com/admob/android/ads/i:m	Ljava/net/HttpURLConnection;
    //   411: ldc -66
    //   413: aload_0
    //   414: getfield 176	com/admob/android/ads/i:l	Ljava/lang/String;
    //   417: invokevirtual 194	java/lang/String:length	()I
    //   420: invokestatic 199	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   423: invokevirtual 112	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   426: new 170	java/io/BufferedWriter
    //   429: dup
    //   430: new 201	java/io/OutputStreamWriter
    //   433: dup
    //   434: aload_0
    //   435: getfield 27	com/admob/android/ads/i:m	Ljava/net/HttpURLConnection;
    //   438: invokevirtual 205	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   441: invokespecial 208	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
    //   444: sipush 4096
    //   447: invokespecial 211	java/io/BufferedWriter:<init>	(Ljava/io/Writer;I)V
    //   450: astore 4
    //   452: aload 4
    //   454: aload_0
    //   455: getfield 176	com/admob/android/ads/i:l	Ljava/lang/String;
    //   458: invokevirtual 214	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   461: aload 4
    //   463: invokevirtual 173	java/io/BufferedWriter:close	()V
    //   466: aload_0
    //   467: getfield 27	com/admob/android/ads/i:m	Ljava/net/HttpURLConnection;
    //   470: invokevirtual 217	java/net/HttpURLConnection:getResponseCode	()I
    //   473: istore 13
    //   475: ldc 66
    //   477: iconst_2
    //   478: invokestatic 72	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   481: ifeq +40 -> 521
    //   484: aload_0
    //   485: getfield 27	com/admob/android/ads/i:m	Ljava/net/HttpURLConnection;
    //   488: ldc -37
    //   490: invokevirtual 223	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   493: astore 18
    //   495: ldc 66
    //   497: new 74	java/lang/StringBuilder
    //   500: dup
    //   501: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   504: ldc -31
    //   506: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: aload 18
    //   511: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   517: invokestatic 98	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   520: pop
    //   521: iload 13
    //   523: sipush 200
    //   526: if_icmplt +211 -> 737
    //   529: iload 13
    //   531: sipush 300
    //   534: if_icmpge +203 -> 737
    //   537: aload_0
    //   538: aload_0
    //   539: getfield 27	com/admob/android/ads/i:m	Ljava/net/HttpURLConnection;
    //   542: invokevirtual 229	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   545: putfield 25	com/admob/android/ads/i:i	Ljava/net/URL;
    //   548: aload_0
    //   549: getfield 233	com/admob/android/ads/i:k	Z
    //   552: ifeq +100 -> 652
    //   555: new 235	java/io/BufferedInputStream
    //   558: dup
    //   559: aload_0
    //   560: getfield 27	com/admob/android/ads/i:m	Ljava/net/HttpURLConnection;
    //   563: invokevirtual 239	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   566: sipush 4096
    //   569: invokespecial 242	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   572: astore 14
    //   574: sipush 4096
    //   577: newarray <illegal type>
    //   579: astore 15
    //   581: new 244	java/io/ByteArrayOutputStream
    //   584: dup
    //   585: sipush 4096
    //   588: invokespecial 246	java/io/ByteArrayOutputStream:<init>	(I)V
    //   591: astore 16
    //   593: aload 14
    //   595: aload 15
    //   597: invokevirtual 250	java/io/BufferedInputStream:read	([B)I
    //   600: istore 17
    //   602: iload 17
    //   604: iconst_m1
    //   605: if_icmpeq +38 -> 643
    //   608: aload 16
    //   610: aload 15
    //   612: iconst_0
    //   613: iload 17
    //   615: invokevirtual 253	java/io/ByteArrayOutputStream:write	([BII)V
    //   618: goto -25 -> 593
    //   621: astore 12
    //   623: aload 12
    //   625: astore 6
    //   627: aconst_null
    //   628: astore 4
    //   630: goto -329 -> 301
    //   633: aload_0
    //   634: getfield 27	com/admob/android/ads/i:m	Ljava/net/HttpURLConnection;
    //   637: invokevirtual 256	java/net/HttpURLConnection:connect	()V
    //   640: goto -174 -> 466
    //   643: aload_0
    //   644: aload 16
    //   646: invokevirtual 260	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   649: putfield 264	com/admob/android/ads/i:j	[B
    //   652: aload_0
    //   653: getfield 49	com/admob/android/ads/i:h	Lcom/admob/android/ads/h;
    //   656: ifnull +98 -> 754
    //   659: aload_0
    //   660: getfield 49	com/admob/android/ads/i:h	Lcom/admob/android/ads/h;
    //   663: aload_0
    //   664: invokeinterface 267 2 0
    //   669: goto +85 -> 754
    //   672: aload_0
    //   673: invokespecial 100	com/admob/android/ads/i:h	()V
    //   676: aload_0
    //   677: invokespecial 100	com/admob/android/ads/i:h	()V
    //   680: iload 10
    //   682: istore 8
    //   684: goto -330 -> 354
    //   687: astore_3
    //   688: aconst_null
    //   689: astore 4
    //   691: aload 4
    //   693: ifnull +8 -> 701
    //   696: aload 4
    //   698: invokevirtual 173	java/io/BufferedWriter:close	()V
    //   701: aload_0
    //   702: invokespecial 100	com/admob/android/ads/i:h	()V
    //   705: aload_3
    //   706: athrow
    //   707: astore 9
    //   709: goto -362 -> 347
    //   712: astore 5
    //   714: goto -13 -> 701
    //   717: astore_3
    //   718: goto -27 -> 691
    //   721: astore 11
    //   723: aload 11
    //   725: astore_3
    //   726: aconst_null
    //   727: astore 4
    //   729: goto -38 -> 691
    //   732: astore 6
    //   734: goto -433 -> 301
    //   737: iload_1
    //   738: istore 10
    //   740: goto -68 -> 672
    //   743: iload_1
    //   744: istore 10
    //   746: goto -74 -> 672
    //   749: iload_1
    //   750: istore_2
    //   751: goto -716 -> 35
    //   754: iconst_1
    //   755: istore 10
    //   757: goto -85 -> 672
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	760	0	this	i
    //   67	683	1	bool1	boolean
    //   34	717	2	bool2	boolean
    //   687	19	3	localObject1	Object
    //   717	1	3	localObject2	Object
    //   725	1	3	localObject3	Object
    //   299	429	4	localBufferedWriter	java.io.BufferedWriter
    //   712	1	5	localException1	Exception
    //   296	37	6	localException2	Exception
    //   625	1	6	localObject4	Object
    //   732	1	6	localException3	Exception
    //   352	331	8	bool3	boolean
    //   707	1	9	localException4	Exception
    //   680	76	10	bool4	boolean
    //   721	3	11	localObject5	Object
    //   621	3	12	localException5	Exception
    //   473	62	13	i	int
    //   572	22	14	localBufferedInputStream	java.io.BufferedInputStream
    //   579	32	15	arrayOfByte	byte[]
    //   591	54	16	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   600	14	17	j	int
    //   493	17	18	str1	String
    //   232	13	20	localIterator	java.util.Iterator
    //   254	33	21	str2	String
    //   275	14	22	str3	String
    // Exception table:
    //   from	to	target	type
    //   132	189	296	java/lang/Exception
    //   189	234	296	java/lang/Exception
    //   234	256	296	java/lang/Exception
    //   261	277	296	java/lang/Exception
    //   282	293	296	java/lang/Exception
    //   370	452	296	java/lang/Exception
    //   633	640	296	java/lang/Exception
    //   466	521	621	java/lang/Exception
    //   537	593	621	java/lang/Exception
    //   593	602	621	java/lang/Exception
    //   608	618	621	java/lang/Exception
    //   643	652	621	java/lang/Exception
    //   652	669	621	java/lang/Exception
    //   672	676	621	java/lang/Exception
    //   132	189	687	finally
    //   189	234	687	finally
    //   234	256	687	finally
    //   261	277	687	finally
    //   282	293	687	finally
    //   370	452	687	finally
    //   633	640	687	finally
    //   342	347	707	java/lang/Exception
    //   696	701	712	java/lang/Exception
    //   301	337	717	finally
    //   452	466	717	finally
    //   466	521	721	finally
    //   537	593	721	finally
    //   593	602	721	finally
    //   608	618	721	finally
    //   643	652	721	finally
    //   652	669	721	finally
    //   672	676	721	finally
    //   452	466	732	java/lang/Exception
  }
  
  public final void b()
  {
    h();
    this.h = null;
  }
  
  public final void run()
  {
    try
    {
      a();
      return;
    }
    catch (Exception localException)
    {
      while (!Log.isLoggable("AdMobSDK", 6)) {}
      Log.e("AdMobSDK", "exception caught in AdMobURLConnector.run(), " + localException.getMessage());
    }
  }
}


/* Location:              F:\Java\android-giro-gamer\Decompile\1\doodle_dex2jar.jar!\com\admob\android\ads\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */