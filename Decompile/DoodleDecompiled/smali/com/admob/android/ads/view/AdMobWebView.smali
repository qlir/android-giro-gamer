.class public Lcom/admob/android/ads/view/AdMobWebView;
.super Landroid/webkit/WebView;
.source "AdMobWebView.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/admob/android/ads/view/AdMobWebView$a;
    }
.end annotation


# instance fields
.field a:Ljava/lang/String;

.field public b:Ljava/lang/String;

.field c:Z

.field private d:Landroid/widget/RelativeLayout;

.field private e:Lcom/admob/android/ads/d;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/widget/RelativeLayout;Ljava/lang/String;Lcom/admob/android/ads/d;)V
    .locals 3

    .prologue
    const/4 v1, 0x0

    const/4 v2, 0x1

    .line 41
    invoke-direct {p0, p1}, Landroid/webkit/WebView;-><init>(Landroid/content/Context;)V

    .line 42
    iput-object p4, p0, Lcom/admob/android/ads/view/AdMobWebView;->e:Lcom/admob/android/ads/d;

    .line 43
    iput-object p2, p0, Lcom/admob/android/ads/view/AdMobWebView;->d:Landroid/widget/RelativeLayout;

    .line 45
    invoke-virtual {p0}, Lcom/admob/android/ads/view/AdMobWebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v0

    .line 46
    invoke-virtual {v0, v2}, Landroid/webkit/WebSettings;->setLoadsImagesAutomatically(Z)V

    .line 47
    invoke-virtual {v0, v2}, Landroid/webkit/WebSettings;->setPluginsEnabled(Z)V

    .line 48
    invoke-virtual {v0, v2}, Landroid/webkit/WebSettings;->setJavaScriptEnabled(Z)V

    .line 49
    invoke-virtual {v0, v2}, Landroid/webkit/WebSettings;->setJavaScriptCanOpenWindowsAutomatically(Z)V

    .line 50
    invoke-virtual {v0, v1}, Landroid/webkit/WebSettings;->setSaveFormData(Z)V

    .line 51
    invoke-virtual {v0, v1}, Landroid/webkit/WebSettings;->setSavePassword(Z)V

    .line 52
    invoke-static {}, Lcom/admob/android/ads/r;->c()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/webkit/WebSettings;->setUserAgentString(Ljava/lang/String;)V

    .line 54
    new-instance v0, Lcom/admob/android/ads/view/AdMobWebView$a;

    invoke-direct {v0, p0, p0}, Lcom/admob/android/ads/view/AdMobWebView$a;-><init>(Lcom/admob/android/ads/view/AdMobWebView;Lcom/admob/android/ads/view/AdMobWebView;)V

    invoke-virtual {p0, v0}, Lcom/admob/android/ads/view/AdMobWebView;->setWebViewClient(Landroid/webkit/WebViewClient;)V

    .line 56
    iput-boolean v2, p0, Lcom/admob/android/ads/view/AdMobWebView;->c:Z

    .line 57
    iput-object p3, p0, Lcom/admob/android/ads/view/AdMobWebView;->a:Ljava/lang/String;

    .line 58
    return-void
.end method


# virtual methods
.method public final a()V
    .locals 2

    .prologue
    .line 66
    iget-object v0, p0, Lcom/admob/android/ads/view/AdMobWebView;->e:Lcom/admob/android/ads/d;

    if-eqz v0, :cond_0

    .line 67
    iget-object v0, p0, Lcom/admob/android/ads/view/AdMobWebView;->e:Lcom/admob/android/ads/d;

    iget-object v1, p0, Lcom/admob/android/ads/view/AdMobWebView;->d:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v1}, Lcom/admob/android/ads/d;->b(Landroid/view/View;)V

    .line 70
    :cond_0
    invoke-virtual {p0}, Lcom/admob/android/ads/view/AdMobWebView;->getContext()Landroid/content/Context;

    move-result-object v0

    const-string v1, "window"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/WindowManager;

    .line 71
    iget-object v1, p0, Lcom/admob/android/ads/view/AdMobWebView;->d:Landroid/widget/RelativeLayout;

    invoke-interface {v0, v1}, Landroid/view/WindowManager;->removeView(Landroid/view/View;)V

    .line 72
    return-void
.end method

.method protected onFocusChanged(ZILandroid/graphics/Rect;)V
    .locals 3

    .prologue
    .line 104
    const-string v0, "AdMobSDK"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "onFocusChanged("

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ")"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 105
    invoke-super {p0, p1, p2, p3}, Landroid/webkit/WebView;->onFocusChanged(ZILandroid/graphics/Rect;)V

    .line 106
    return-void
.end method

.method public onKeyDown(ILandroid/view/KeyEvent;)Z
    .locals 1

    .prologue
    .line 85
    const/4 v0, 0x4

    if-ne p1, v0, :cond_0

    .line 87
    invoke-virtual {p0}, Lcom/admob/android/ads/view/AdMobWebView;->a()V

    .line 88
    const/4 v0, 0x1

    .line 91
    :goto_0
    return v0

    :cond_0
    invoke-super {p0, p1, p2}, Landroid/webkit/WebView;->onKeyDown(ILandroid/view/KeyEvent;)Z

    move-result v0

    goto :goto_0
.end method

.method protected onSaveInstanceState()Landroid/os/Parcelable;
    .locals 2

    .prologue
    .line 117
    const-string v0, "AdMobSDK"

    const-string v1, "onSaveInstanceState()"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 118
    invoke-super {p0}, Landroid/webkit/WebView;->onSaveInstanceState()Landroid/os/Parcelable;

    move-result-object v0

    return-object v0
.end method

.method protected onWindowVisibilityChanged(I)V
    .locals 3

    .prologue
    .line 130
    const-string v0, "AdMobSDK"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "onWindowVisibilityChanged("

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ")"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 131
    invoke-super {p0, p1}, Landroid/webkit/WebView;->onWindowVisibilityChanged(I)V

    .line 132
    return-void
.end method
