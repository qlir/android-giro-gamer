.class public Lcom/admob/android/ads/AdManager;
.super Ljava/lang/Object;
.source "AdManager.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/admob/android/ads/AdManager$Gender;
    }
.end annotation


# static fields
.field public static final LOG:Ljava/lang/String; = "AdMobSDK"

.field public static final SDK_VERSION:Ljava/lang/String; = "20100709-ANDROID-3312276cc1406347"

.field public static final SDK_VERSION_DATE:Ljava/lang/String; = "20100709"

.field public static final TEST_EMULATOR:Ljava/lang/String; = "emulator"

.field private static a:Ljava/lang/String;

.field private static b:I

.field private static c:Ljava/lang/String;

.field private static d:Ljava/lang/String;

.field private static e:[Ljava/lang/String;

.field private static f:Ljava/lang/String;

.field private static g:Landroid/location/Location;

.field private static h:Z

.field private static i:Z

.field private static j:J

.field private static k:Ljava/lang/String;

.field private static l:Ljava/util/GregorianCalendar;

.field private static m:Lcom/admob/android/ads/AdManager$Gender;

.field private static n:Z


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v1, 0x0

    const-string v3, "Could not find InstallReceiver class so cannot track installs from AdMob ads.  Did you obfuscate this class away?"

    const-string v2, "AdMobSDK"

    .line 104
    const-string v0, "url"

    sput-object v0, Lcom/admob/android/ads/AdManager;->d:Ljava/lang/String;

    .line 114
    const/4 v0, 0x0

    sput-object v0, Lcom/admob/android/ads/AdManager;->e:[Ljava/lang/String;

    .line 130
    sput-boolean v1, Lcom/admob/android/ads/AdManager;->h:Z

    .line 135
    sput-boolean v1, Lcom/admob/android/ads/AdManager;->i:Z

    .line 165
    sput-boolean v1, Lcom/admob/android/ads/AdManager;->n:Z

    .line 172
    const-string v0, "AdMobSDK"

    const-string v0, "AdMob SDK version is 20100709-ANDROID-3312276cc1406347"

    invoke-static {v2, v0}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 180
    :try_start_0
    const-string v0, "com.admob.android.ads.analytics.InstallReceiver"

    invoke-static {v0}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;
    :try_end_0
    .catch Ljava/lang/ClassNotFoundException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    if-eqz v0, :cond_1

    .line 182
    const/4 v0, 0x1

    .line 190
    :goto_0
    if-nez v0, :cond_0

    .line 192
    const-string v0, "AdMobSDK"

    const-string v0, "Could not find InstallReceiver class so cannot track installs from AdMob ads.  Did you obfuscate this class away?"

    invoke-static {v2, v3}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 195
    :cond_0
    :goto_1
    return-void

    .line 190
    :catch_0
    move-exception v0

    const-string v0, "AdMobSDK"

    const-string v0, "Could not find InstallReceiver class so cannot track installs from AdMob ads.  Did you obfuscate this class away?"

    invoke-static {v2, v3}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1

    :catchall_0
    move-exception v0

    .line 192
    const-string v1, "AdMobSDK"

    const-string v1, "Could not find InstallReceiver class so cannot track installs from AdMob ads.  Did you obfuscate this class away?"

    invoke-static {v2, v3}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    throw v0

    :cond_1
    move v0, v1

    goto :goto_0
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 201
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 203
    return-void
.end method

.method static synthetic a(J)J
    .locals 0

    .prologue
    .line 29
    sput-wide p0, Lcom/admob/android/ads/AdManager;->j:J

    return-wide p0
.end method

.method static synthetic a(Landroid/location/Location;)Landroid/location/Location;
    .locals 0

    .prologue
    .line 29
    sput-object p0, Lcom/admob/android/ads/AdManager;->g:Landroid/location/Location;

    return-object p0
.end method

.method static a()Ljava/lang/String;
    .locals 4

    .prologue
    .line 816
    sget-wide v0, Lcom/admob/android/ads/AdManager;->j:J

    const-wide/16 v2, 0x3e8

    div-long/2addr v0, v2

    invoke-static {v0, v1}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private static a(Ljava/lang/String;)Ljava/lang/String;
    .locals 7

    .prologue
    const/4 v6, 0x0

    .line 588
    const/4 v0, 0x0

    .line 590
    if-eqz p0, :cond_0

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v1

    if-lez v1, :cond_0

    .line 594
    :try_start_0
    const-string v0, "MD5"

    invoke-static {v0}, Ljava/security/MessageDigest;->getInstance(Ljava/lang/String;)Ljava/security/MessageDigest;

    move-result-object v0

    .line 595
    invoke-virtual {p0}, Ljava/lang/String;->getBytes()[B

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v3

    invoke-virtual {v0, v1, v2, v3}, Ljava/security/MessageDigest;->update([BII)V

    .line 596
    const-string v1, "%032X"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    new-instance v4, Ljava/math/BigInteger;

    const/4 v5, 0x1

    invoke-virtual {v0}, Ljava/security/MessageDigest;->digest()[B

    move-result-object v0

    invoke-direct {v4, v5, v0}, Ljava/math/BigInteger;-><init>(I[B)V

    aput-object v4, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 607
    :cond_0
    :goto_0
    return-object v0

    .line 598
    :catch_0
    move-exception v0

    .line 600
    const-string v1, "AdMobSDK"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Could not generate hash of "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, v0}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 603
    const/16 v0, 0x20

    invoke-virtual {p0, v6, v0}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method static a(Landroid/content/Context;)V
    .locals 6

    .prologue
    const-string v0, "AdMobSDK"

    .line 247
    sget-boolean v0, Lcom/admob/android/ads/AdManager;->n:Z

    if-eqz v0, :cond_1

    .line 325
    :cond_0
    :goto_0
    return-void

    .line 253
    :cond_1
    const/4 v0, 0x1

    sput-boolean v0, Lcom/admob/android/ads/AdManager;->n:Z

    .line 259
    :try_start_0
    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    .line 261
    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v1

    const/16 v2, 0x80

    invoke-virtual {v0, v1, v2}, Landroid/content/pm/PackageManager;->getApplicationInfo(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;

    move-result-object v1

    .line 262
    if-eqz v1, :cond_6

    .line 266
    iget-object v2, v1, Landroid/content/pm/ApplicationInfo;->metaData:Landroid/os/Bundle;

    if-eqz v2, :cond_4

    .line 268
    iget-object v2, v1, Landroid/content/pm/ApplicationInfo;->metaData:Landroid/os/Bundle;

    const-string v3, "ADMOB_PUBLISHER_ID"

    invoke-virtual {v2, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 270
    const-string v3, "AdMobSDK"

    const/4 v4, 0x3

    invoke-static {v3, v4}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 272
    const-string v3, "AdMobSDK"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Publisher ID read from AndroidManifest.xml is "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 276
    :cond_2
    sget-object v3, Lcom/admob/android/ads/AdManager;->c:Ljava/lang/String;

    if-nez v3, :cond_4

    if-eqz v2, :cond_4

    .line 278
    const-string v3, "a1496ced2842262"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_7

    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v3

    const-string v4, "com.admob.android.ads"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_3

    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v3

    const-string v4, "com.example.admob.lunarlander"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_7

    .line 283
    :cond_3
    const-string v3, "AdMobSDK"

    const-string v4, "This is a sample application so allowing sample publisher ID."

    invoke-static {v3, v4}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 284
    sput-object v2, Lcom/admob/android/ads/AdManager;->c:Ljava/lang/String;

    .line 294
    :cond_4
    :goto_1
    sget-boolean v2, Lcom/admob/android/ads/AdManager;->i:Z

    if-nez v2, :cond_5

    .line 296
    iget-object v2, v1, Landroid/content/pm/ApplicationInfo;->metaData:Landroid/os/Bundle;

    const-string v3, "ADMOB_ALLOW_LOCATION_FOR_ADS"

    const/4 v4, 0x0

    invoke-virtual {v2, v3, v4}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v2

    sput-boolean v2, Lcom/admob/android/ads/AdManager;->h:Z

    .line 302
    :cond_5
    iget-object v1, v1, Landroid/content/pm/ApplicationInfo;->packageName:Ljava/lang/String;

    sput-object v1, Lcom/admob/android/ads/AdManager;->a:Ljava/lang/String;

    .line 303
    const-string v1, "AdMobSDK"

    const/4 v2, 0x2

    invoke-static {v1, v2}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v1

    if-eqz v1, :cond_6

    .line 305
    const-string v1, "AdMobSDK"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Application\'s package name is "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    sget-object v3, Lcom/admob/android/ads/AdManager;->a:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 309
    :cond_6
    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v0

    .line 310
    if-eqz v0, :cond_0

    .line 314
    iget v0, v0, Landroid/content/pm/PackageInfo;->versionCode:I

    sput v0, Lcom/admob/android/ads/AdManager;->b:I

    .line 315
    const-string v0, "AdMobSDK"

    const/4 v1, 0x2

    invoke-static {v0, v1}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 317
    const-string v0, "AdMobSDK"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Application\'s version number is "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    sget v2, Lcom/admob/android/ads/AdManager;->b:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_0

    .line 325
    :catch_0
    move-exception v0

    goto/16 :goto_0

    .line 288
    :cond_7
    invoke-static {v2}, Lcom/admob/android/ads/AdManager;->setPublisherId(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1
.end method

.method static b()Ljava/lang/String;
    .locals 7

    .prologue
    const/4 v6, 0x2

    const/4 v5, 0x1

    .line 883
    const/4 v0, 0x0

    .line 884
    invoke-static {}, Lcom/admob/android/ads/AdManager;->getBirthday()Ljava/util/GregorianCalendar;

    move-result-object v1

    .line 886
    if-eqz v1, :cond_0

    .line 888
    const-string v0, "%04d%02d%02d"

    const/4 v2, 0x3

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-virtual {v1, v5}, Ljava/util/GregorianCalendar;->get(I)I

    move-result v4

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-virtual {v1, v6}, Ljava/util/GregorianCalendar;->get(I)I

    move-result v3

    add-int/lit8 v3, v3, 0x1

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v2, v5

    const/4 v3, 0x5

    invoke-virtual {v1, v3}, Ljava/util/GregorianCalendar;->get(I)I

    move-result v1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    aput-object v1, v2, v6

    invoke-static {v0, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 894
    :cond_0
    return-object v0
.end method

.method static b(Landroid/content/Context;)Ljava/lang/String;
    .locals 5

    .prologue
    const-string v4, "AdMobSDK"

    .line 792
    const/4 v0, 0x0

    .line 793
    invoke-static {p0}, Lcom/admob/android/ads/AdManager;->getCoordinates(Landroid/content/Context;)Landroid/location/Location;

    move-result-object v1

    .line 795
    if-eqz v1, :cond_0

    .line 797
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1}, Landroid/location/Location;->getLatitude()D

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, ","

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v1}, Landroid/location/Location;->getLongitude()D

    move-result-wide v1

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 800
    :cond_0
    const-string v1, "AdMobSDK"

    const/4 v1, 0x3

    invoke-static {v4, v1}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 802
    const-string v1, "AdMobSDK"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "User coordinates are "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v4, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 805
    :cond_1
    return-object v0
.end method

.method static c()Ljava/lang/String;
    .locals 2

    .prologue
    .line 939
    sget-object v0, Lcom/admob/android/ads/AdManager;->m:Lcom/admob/android/ads/AdManager$Gender;

    sget-object v1, Lcom/admob/android/ads/AdManager$Gender;->MALE:Lcom/admob/android/ads/AdManager$Gender;

    if-ne v0, v1, :cond_0

    .line 941
    const-string v0, "m"

    .line 949
    :goto_0
    return-object v0

    .line 943
    :cond_0
    sget-object v0, Lcom/admob/android/ads/AdManager;->m:Lcom/admob/android/ads/AdManager$Gender;

    sget-object v1, Lcom/admob/android/ads/AdManager$Gender;->FEMALE:Lcom/admob/android/ads/AdManager$Gender;

    if-ne v0, v1, :cond_1

    .line 945
    const-string v0, "f"

    goto :goto_0

    .line 949
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected static clientError(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 215
    const-string v0, "AdMobSDK"

    invoke-static {v0, p0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 218
    new-instance v0, Ljava/lang/IllegalArgumentException;

    invoke-direct {v0, p0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method static synthetic d()Landroid/location/Location;
    .locals 1

    .prologue
    .line 29
    sget-object v0, Lcom/admob/android/ads/AdManager;->g:Landroid/location/Location;

    return-object v0
.end method

.method static synthetic e()J
    .locals 2

    .prologue
    .line 29
    sget-wide v0, Lcom/admob/android/ads/AdManager;->j:J

    return-wide v0
.end method

.method private static f()Z
    .locals 3

    .prologue
    const-string v2, "generic"

    .line 525
    const-string v0, "unknown"

    sget-object v1, Landroid/os/Build;->BOARD:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    const-string v0, "generic"

    sget-object v0, Landroid/os/Build;->DEVICE:Ljava/lang/String;

    invoke-virtual {v2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    const-string v0, "generic"

    sget-object v0, Landroid/os/Build;->BRAND:Ljava/lang/String;

    invoke-virtual {v2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static getApplicationPackageName(Landroid/content/Context;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 337
    sget-object v0, Lcom/admob/android/ads/AdManager;->a:Ljava/lang/String;

    if-nez v0, :cond_0

    .line 339
    invoke-static {p0}, Lcom/admob/android/ads/AdManager;->a(Landroid/content/Context;)V

    .line 342
    :cond_0
    sget-object v0, Lcom/admob/android/ads/AdManager;->a:Ljava/lang/String;

    return-object v0
.end method

.method protected static getApplicationVersion(Landroid/content/Context;)I
    .locals 1

    .prologue
    .line 355
    sget-object v0, Lcom/admob/android/ads/AdManager;->a:Ljava/lang/String;

    if-nez v0, :cond_0

    .line 357
    invoke-static {p0}, Lcom/admob/android/ads/AdManager;->a(Landroid/content/Context;)V

    .line 360
    :cond_0
    sget v0, Lcom/admob/android/ads/AdManager;->b:I

    return v0
.end method

.method public static getBirthday()Ljava/util/GregorianCalendar;
    .locals 1

    .prologue
    .line 872
    sget-object v0, Lcom/admob/android/ads/AdManager;->l:Ljava/util/GregorianCalendar;

    return-object v0
.end method

.method public static getCoordinates(Landroid/content/Context;)Landroid/location/Location;
    .locals 9

    .prologue
    const/4 v8, 0x0

    const/4 v7, 0x0

    const/4 v6, 0x1

    const-string v1, "AdMobSDK"

    .line 646
    invoke-static {}, Lcom/admob/android/ads/AdManager;->f()Z

    move-result v0

    if-eqz v0, :cond_0

    sget-boolean v0, Lcom/admob/android/ads/AdManager;->h:Z

    if-nez v0, :cond_0

    .line 647
    const-string v0, "AdMobSDK"

    const-string v0, "Location information is not being used for ad requests. Enable location"

    invoke-static {v1, v0}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 648
    const-string v0, "AdMobSDK"

    const-string v0, "based ads with AdManager.setAllowUseOfLocation(true) or by setting "

    invoke-static {v1, v0}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 649
    const-string v0, "AdMobSDK"

    const-string v0, "meta-data ADMOB_ALLOW_LOCATION_FOR_ADS to true in AndroidManifest.xml"

    invoke-static {v1, v0}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 651
    :cond_0
    sget-boolean v0, Lcom/admob/android/ads/AdManager;->h:Z

    if-eqz v0, :cond_7

    if-eqz p0, :cond_7

    .line 654
    sget-object v0, Lcom/admob/android/ads/AdManager;->g:Landroid/location/Location;

    if-eqz v0, :cond_1

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    sget-wide v2, Lcom/admob/android/ads/AdManager;->j:J

    const-wide/32 v4, 0xdbba0

    add-long/2addr v2, v4

    cmp-long v0, v0, v2

    if-lez v0, :cond_7

    .line 657
    :cond_1
    monitor-enter p0

    .line 661
    :try_start_0
    sget-object v0, Lcom/admob/android/ads/AdManager;->g:Landroid/location/Location;

    if-eqz v0, :cond_2

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    sget-wide v2, Lcom/admob/android/ads/AdManager;->j:J

    const-wide/32 v4, 0xdbba0

    add-long/2addr v2, v4

    cmp-long v0, v0, v2

    if-lez v0, :cond_6

    .line 664
    :cond_2
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    sput-wide v0, Lcom/admob/android/ads/AdManager;->j:J

    .line 671
    const-string v0, "android.permission.ACCESS_COARSE_LOCATION"

    invoke-virtual {p0, v0}, Landroid/content/Context;->checkCallingOrSelfPermission(Ljava/lang/String;)I

    move-result v0

    if-nez v0, :cond_d

    .line 673
    const-string v0, "AdMobSDK"

    const/4 v1, 0x3

    invoke-static {v0, v1}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 675
    const-string v0, "AdMobSDK"

    const-string v1, "Trying to get locations from the network."

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 679
    :cond_3
    const-string v0, "location"

    invoke-virtual {p0, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/location/LocationManager;

    .line 681
    if-eqz v0, :cond_c

    .line 683
    new-instance v1, Landroid/location/Criteria;

    invoke-direct {v1}, Landroid/location/Criteria;-><init>()V

    .line 684
    const/4 v2, 0x2

    invoke-virtual {v1, v2}, Landroid/location/Criteria;->setAccuracy(I)V

    .line 685
    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/location/Criteria;->setCostAllowed(Z)V

    .line 686
    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Landroid/location/LocationManager;->getBestProvider(Landroid/location/Criteria;Z)Ljava/lang/String;

    move-result-object v1

    move v2, v6

    .line 691
    :goto_0
    if-nez v1, :cond_5

    .line 693
    const-string v3, "android.permission.ACCESS_FINE_LOCATION"

    invoke-virtual {p0, v3}, Landroid/content/Context;->checkCallingOrSelfPermission(Ljava/lang/String;)I

    move-result v3

    if-nez v3, :cond_5

    .line 695
    const-string v0, "AdMobSDK"

    const/4 v2, 0x3

    invoke-static {v0, v2}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 697
    const-string v0, "AdMobSDK"

    const-string v2, "Trying to get locations from GPS."

    invoke-static {v0, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 701
    :cond_4
    const-string v0, "location"

    invoke-virtual {p0, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/location/LocationManager;

    .line 703
    if-eqz v0, :cond_b

    .line 705
    new-instance v1, Landroid/location/Criteria;

    invoke-direct {v1}, Landroid/location/Criteria;-><init>()V

    .line 706
    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Landroid/location/Criteria;->setAccuracy(I)V

    .line 707
    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/location/Criteria;->setCostAllowed(Z)V

    .line 708
    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Landroid/location/LocationManager;->getBestProvider(Landroid/location/Criteria;Z)Ljava/lang/String;

    move-result-object v1

    move v2, v6

    .line 714
    :cond_5
    :goto_1
    if-nez v2, :cond_8

    .line 716
    const-string v0, "AdMobSDK"

    const/4 v1, 0x3

    invoke-static {v0, v1}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v0

    if-eqz v0, :cond_6

    .line 718
    const-string v0, "AdMobSDK"

    const-string v1, "Cannot access user\'s location.  Permissions are not set."

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 775
    :cond_6
    :goto_2
    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 779
    :cond_7
    sget-object v0, Lcom/admob/android/ads/AdManager;->g:Landroid/location/Location;

    return-object v0

    .line 721
    :cond_8
    if-nez v1, :cond_9

    .line 723
    :try_start_1
    const-string v0, "AdMobSDK"

    const/4 v1, 0x3

    invoke-static {v0, v1}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v0

    if-eqz v0, :cond_6

    .line 725
    const-string v0, "AdMobSDK"

    const-string v1, "No location providers are available.  Ads will not be geotargeted."

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_2

    .line 775
    :catchall_0
    move-exception v0

    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0

    .line 730
    :cond_9
    :try_start_2
    const-string v2, "AdMobSDK"

    const/4 v3, 0x3

    invoke-static {v2, v3}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v2

    if-eqz v2, :cond_a

    .line 732
    const-string v2, "AdMobSDK"

    const-string v3, "Location provider setup successfully."

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 737
    :cond_a
    const-wide/16 v2, 0x0

    const/4 v4, 0x0

    new-instance v5, Lcom/admob/android/ads/AdManager$1;

    invoke-direct {v5, v0}, Lcom/admob/android/ads/AdManager$1;-><init>(Landroid/location/LocationManager;)V

    invoke-virtual {p0}, Landroid/content/Context;->getMainLooper()Landroid/os/Looper;

    move-result-object v6

    invoke-virtual/range {v0 .. v6}, Landroid/location/LocationManager;->requestLocationUpdates(Ljava/lang/String;JFLandroid/location/LocationListener;Landroid/os/Looper;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_2

    :cond_b
    move v2, v6

    goto :goto_1

    :cond_c
    move-object v1, v8

    move v2, v6

    goto/16 :goto_0

    :cond_d
    move-object v1, v8

    move-object v0, v8

    move v2, v7

    goto/16 :goto_0
.end method

.method static getEndpoint()Ljava/lang/String;
    .locals 1

    .prologue
    .line 979
    invoke-static {}, Lcom/admob/android/ads/u;->a()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getGender()Lcom/admob/android/ads/AdManager$Gender;
    .locals 1

    .prologue
    .line 928
    sget-object v0, Lcom/admob/android/ads/AdManager;->m:Lcom/admob/android/ads/AdManager$Gender;

    return-object v0
.end method

.method public static getOrientation(Landroid/content/Context;)Ljava/lang/String;
    .locals 3

    .prologue
    .line 836
    const-string v0, "p"

    .line 838
    const-string v1, "window"

    invoke-virtual {p0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, Landroid/view/WindowManager;

    invoke-interface {p0}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v1

    .line 839
    invoke-virtual {v1}, Landroid/view/Display;->getOrientation()I

    move-result v1

    .line 840
    const/4 v2, 0x1

    if-ne v1, v2, :cond_0

    .line 842
    const-string v0, "l"

    .line 844
    :cond_0
    return-object v0
.end method

.method public static getPostalCode()Ljava/lang/String;
    .locals 1

    .prologue
    .line 826
    sget-object v0, Lcom/admob/android/ads/AdManager;->k:Ljava/lang/String;

    return-object v0
.end method

.method public static getPublisherId(Landroid/content/Context;)Ljava/lang/String;
    .locals 2

    .prologue
    const-string v1, "AdMobSDK"

    .line 371
    sget-object v0, Lcom/admob/android/ads/AdManager;->c:Ljava/lang/String;

    if-nez v0, :cond_0

    .line 373
    invoke-static {p0}, Lcom/admob/android/ads/AdManager;->a(Landroid/content/Context;)V

    .line 377
    :cond_0
    sget-object v0, Lcom/admob/android/ads/AdManager;->c:Ljava/lang/String;

    if-nez v0, :cond_1

    const-string v0, "AdMobSDK"

    const/4 v0, 0x6

    invoke-static {v1, v0}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 379
    const-string v0, "AdMobSDK"

    const-string v0, "getPublisherId returning null publisher id.  Please set the publisher id in AndroidManifest.xml or using AdManager.setPublisherId(String)"

    invoke-static {v1, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 383
    :cond_1
    sget-object v0, Lcom/admob/android/ads/AdManager;->c:Ljava/lang/String;

    return-object v0
.end method

.method protected static getScreenWidth(Landroid/content/Context;)I
    .locals 2

    .prologue
    .line 229
    const-string v0, "window"

    invoke-virtual {p0, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, Landroid/view/WindowManager;

    invoke-interface {p0}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v0

    .line 230
    const/4 v1, 0x0

    .line 231
    if-eqz v0, :cond_0

    .line 233
    invoke-virtual {v0}, Landroid/view/Display;->getWidth()I

    move-result v0

    .line 235
    :goto_0
    return v0

    :cond_0
    move v0, v1

    goto :goto_0
.end method

.method public static getTestAction()Ljava/lang/String;
    .locals 1

    .prologue
    .line 422
    sget-object v0, Lcom/admob/android/ads/AdManager;->d:Ljava/lang/String;

    return-object v0
.end method

.method static getTestDevices()[Ljava/lang/String;
    .locals 1

    .prologue
    .line 468
    sget-object v0, Lcom/admob/android/ads/AdManager;->e:[Ljava/lang/String;

    return-object v0
.end method

.method public static getUserId(Landroid/content/Context;)Ljava/lang/String;
    .locals 4

    .prologue
    const-string v3, "emulator"

    const-string v2, "AdMobSDK"

    .line 542
    sget-object v0, Lcom/admob/android/ads/AdManager;->f:Ljava/lang/String;

    if-nez v0, :cond_1

    .line 544
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    const-string v1, "android_id"

    invoke-static {v0, v1}, Landroid/provider/Settings$Secure;->getString(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 547
    if-eqz v0, :cond_0

    invoke-static {}, Lcom/admob/android/ads/AdManager;->f()Z

    move-result v1

    if-eqz v1, :cond_2

    .line 550
    :cond_0
    const-string v0, "emulator"

    sput-object v3, Lcom/admob/android/ads/AdManager;->f:Ljava/lang/String;

    .line 553
    const-string v0, "AdMobSDK"

    const-string v0, "To get test ads on the emulator use AdManager.setTestDevices( new String[] { AdManager.TEST_EMULATOR } )"

    invoke-static {v2, v0}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 563
    :goto_0
    const-string v0, "AdMobSDK"

    const/4 v0, 0x3

    invoke-static {v2, v0}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 565
    const-string v0, "AdMobSDK"

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "The user ID is "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v1, Lcom/admob/android/ads/AdManager;->f:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v2, v0}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 570
    :cond_1
    sget-object v0, Lcom/admob/android/ads/AdManager;->f:Ljava/lang/String;

    const-string v1, "emulator"

    if-ne v0, v3, :cond_3

    .line 572
    const/4 v0, 0x0

    .line 576
    :goto_1
    return-object v0

    .line 558
    :cond_2
    invoke-static {v0}, Lcom/admob/android/ads/AdManager;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/admob/android/ads/AdManager;->f:Ljava/lang/String;

    .line 560
    const-string v0, "AdMobSDK"

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "To get test ads on this device use AdManager.setTestDevices( new String[] { \""

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v1, Lcom/admob/android/ads/AdManager;->f:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\" } )"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v2, v0}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 576
    :cond_3
    sget-object v0, Lcom/admob/android/ads/AdManager;->f:Ljava/lang/String;

    goto :goto_1
.end method

.method public static isTestDevice(Landroid/content/Context;)Z
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 481
    .line 483
    sget-object v0, Lcom/admob/android/ads/AdManager;->e:[Ljava/lang/String;

    if-eqz v0, :cond_2

    .line 485
    invoke-static {p0}, Lcom/admob/android/ads/AdManager;->getUserId(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    .line 487
    if-nez v0, :cond_0

    .line 490
    const-string v0, "emulator"

    .line 493
    :cond_0
    sget-object v1, Lcom/admob/android/ads/AdManager;->e:[Ljava/lang/String;

    invoke-static {v1, v0}, Ljava/util/Arrays;->binarySearch([Ljava/lang/Object;Ljava/lang/Object;)I

    move-result v0

    if-ltz v0, :cond_1

    const/4 v0, 0x1

    .line 496
    :goto_0
    return v0

    :cond_1
    move v0, v2

    .line 493
    goto :goto_0

    :cond_2
    move v0, v2

    goto :goto_0
.end method

.method public static setAllowUseOfLocation(Z)V
    .locals 1

    .prologue
    .line 629
    const/4 v0, 0x1

    sput-boolean v0, Lcom/admob/android/ads/AdManager;->i:Z

    .line 630
    sput-boolean p0, Lcom/admob/android/ads/AdManager;->h:Z

    .line 631
    return-void
.end method

.method public static setBirthday(III)V
    .locals 2

    .prologue
    .line 916
    new-instance v0, Ljava/util/GregorianCalendar;

    invoke-direct {v0}, Ljava/util/GregorianCalendar;-><init>()V

    .line 917
    const/4 v1, 0x1

    sub-int v1, p1, v1

    invoke-virtual {v0, p0, v1, p2}, Ljava/util/GregorianCalendar;->set(III)V

    .line 918
    invoke-static {v0}, Lcom/admob/android/ads/AdManager;->setBirthday(Ljava/util/GregorianCalendar;)V

    .line 919
    return-void
.end method

.method public static setBirthday(Ljava/util/GregorianCalendar;)V
    .locals 0

    .prologue
    .line 904
    sput-object p0, Lcom/admob/android/ads/AdManager;->l:Ljava/util/GregorianCalendar;

    .line 905
    return-void
.end method

.method static setEndpoint(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 970
    invoke-static {p0}, Lcom/admob/android/ads/u;->a(Ljava/lang/String;)V

    .line 971
    return-void
.end method

.method public static setGender(Lcom/admob/android/ads/AdManager$Gender;)V
    .locals 0

    .prologue
    .line 960
    sput-object p0, Lcom/admob/android/ads/AdManager;->m:Lcom/admob/android/ads/AdManager$Gender;

    .line 961
    return-void
.end method

.method public static setPostalCode(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 861
    sput-object p0, Lcom/admob/android/ads/AdManager;->k:Ljava/lang/String;

    .line 862
    return-void
.end method

.method public static setPublisherId(Ljava/lang/String;)V
    .locals 3

    .prologue
    .line 398
    if-eqz p0, :cond_0

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v0

    const/16 v1, 0xf

    if-eq v0, v1, :cond_1

    .line 400
    :cond_0
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "SETUP ERROR:  Incorrect AdMob publisher ID.  Should 15 [a-f,0-9] characters:  "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v1, Lcom/admob/android/ads/AdManager;->c:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/admob/android/ads/AdManager;->clientError(Ljava/lang/String;)V

    .line 403
    :cond_1
    const-string v0, "a1496ced2842262"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 406
    const-string v0, "SETUP ERROR:  Cannot use the sample publisher ID (a1496ced2842262).  Yours is available on www.admob.com."

    invoke-static {v0}, Lcom/admob/android/ads/AdManager;->clientError(Ljava/lang/String;)V

    .line 409
    :cond_2
    const-string v0, "AdMobSDK"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Publisher ID set to "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 411
    sput-object p0, Lcom/admob/android/ads/AdManager;->c:Ljava/lang/String;

    .line 412
    return-void
.end method

.method public static setTestAction(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 517
    sput-object p0, Lcom/admob/android/ads/AdManager;->d:Ljava/lang/String;

    .line 518
    return-void
.end method

.method public static setTestDevices([Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 451
    if-nez p0, :cond_0

    .line 453
    const/4 v0, 0x0

    sput-object v0, Lcom/admob/android/ads/AdManager;->e:[Ljava/lang/String;

    .line 461
    :goto_0
    return-void

    .line 458
    :cond_0
    invoke-virtual {p0}, [Ljava/lang/String;->clone()Ljava/lang/Object;

    move-result-object p0

    check-cast p0, [Ljava/lang/String;

    .line 459
    sput-object p0, Lcom/admob/android/ads/AdManager;->e:[Ljava/lang/String;

    invoke-static {p0}, Ljava/util/Arrays;->sort([Ljava/lang/Object;)V

    goto :goto_0
.end method
