.class final Lcom/admob/android/ads/analytics/InstallReceiver$1;
.super Ljava/lang/Object;
.source "InstallReceiver.java"

# interfaces
.implements Lcom/admob/android/ads/h;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/admob/android/ads/analytics/InstallReceiver;->onReceive(Landroid/content/Context;Landroid/content/Intent;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# direct methods
.method constructor <init>(Lcom/admob/android/ads/analytics/InstallReceiver;)V
    .locals 0

    .prologue
    .line 99
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final a(Lcom/admob/android/ads/r;)V
    .locals 2

    .prologue
    const-string v1, "AdMobSDK"

    .line 108
    const-string v0, "AdMobSDK"

    const/4 v0, 0x3

    invoke-static {v1, v0}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 110
    const-string v0, "AdMobSDK"

    const-string v0, "Recorded install from an AdMob ad."

    invoke-static {v1, v0}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 112
    :cond_0
    return-void
.end method

.method public final a(Lcom/admob/android/ads/r;Ljava/lang/Exception;)V
    .locals 2

    .prologue
    const-string v1, "AdMobSDK"

    .line 117
    const-string v0, "AdMobSDK"

    const/4 v0, 0x3

    invoke-static {v1, v0}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 119
    const-string v0, "AdMobSDK"

    const-string v0, "Failed to record install from an AdMob ad."

    invoke-static {v1, v0, p2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 121
    :cond_0
    return-void
.end method
