.class Lcom/realarcade/DOJ/MrGame$MrgView;
.super Landroid/view/SurfaceView;
.source "MrGame.java"

# interfaces
.implements Landroid/view/SurfaceHolder$Callback;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/realarcade/DOJ/MrGame;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "MrgView"
.end annotation


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 2944
    invoke-direct {p0, p1}, Landroid/view/SurfaceView;-><init>(Landroid/content/Context;)V

    .line 2946
    invoke-virtual {p0}, Lcom/realarcade/DOJ/MrGame$MrgView;->getHolder()Landroid/view/SurfaceHolder;

    move-result-object v0

    sput-object v0, Lcom/realarcade/DOJ/MrGame;->mSurfaceHolder:Landroid/view/SurfaceHolder;

    .line 2947
    sget-object v0, Lcom/realarcade/DOJ/MrGame;->mSurfaceHolder:Landroid/view/SurfaceHolder;

    const/4 v1, 0x2

    invoke-interface {v0, v1}, Landroid/view/SurfaceHolder;->setType(I)V

    .line 2948
    sget-object v0, Lcom/realarcade/DOJ/MrGame;->mSurfaceHolder:Landroid/view/SurfaceHolder;

    const/4 v1, 0x1

    invoke-interface {v0, v1}, Landroid/view/SurfaceHolder;->setKeepScreenOn(Z)V

    .line 2949
    sget-object v0, Lcom/realarcade/DOJ/MrGame;->mSurfaceHolder:Landroid/view/SurfaceHolder;

    invoke-interface {v0, p0}, Landroid/view/SurfaceHolder;->addCallback(Landroid/view/SurfaceHolder$Callback;)V

    .line 2950
    return-void
.end method


# virtual methods
.method public resolutionChanged()V
    .locals 0

    .prologue
    .line 2975
    return-void
.end method

.method public surfaceChanged(Landroid/view/SurfaceHolder;III)V
    .locals 0
    .param p1, "holder"    # Landroid/view/SurfaceHolder;
    .param p2, "format"    # I
    .param p3, "w"    # I
    .param p4, "h"    # I

    .prologue
    .line 2953
    invoke-interface {p1}, Landroid/view/SurfaceHolder;->setSizeFromLayout()V

    .line 2954
    return-void
.end method

.method public surfaceCreated(Landroid/view/SurfaceHolder;)V
    .locals 1
    .param p1, "holder"    # Landroid/view/SurfaceHolder;

    .prologue
    .line 2960
    const/4 v0, 0x1

    sput-boolean v0, Lcom/realarcade/DOJ/MrGame;->surfaceReady:Z

    .line 2961
    const/4 v0, 0x0

    sput-boolean v0, Lcom/realarcade/DOJ/MrGame;->p_paused:Z

    .line 2962
    sget-boolean v0, Lcom/realarcade/DOJ/MrGame;->activityInited:Z

    if-eqz v0, :cond_0

    sget-object v0, Lcom/realarcade/DOJ/MrGame;->p_mrgame:Lcom/realarcade/DOJ/MrGame;

    invoke-virtual {v0}, Lcom/realarcade/DOJ/MrGame;->showNotify()V

    .line 2963
    :cond_0
    return-void
.end method

.method public surfaceDestroyed(Landroid/view/SurfaceHolder;)V
    .locals 1
    .param p1, "holder"    # Landroid/view/SurfaceHolder;

    .prologue
    .line 2967
    const/4 v0, 0x0

    sput-boolean v0, Lcom/realarcade/DOJ/MrGame;->surfaceReady:Z

    .line 2971
    return-void
.end method
