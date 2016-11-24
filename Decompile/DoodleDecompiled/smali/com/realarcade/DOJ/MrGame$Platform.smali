.class public Lcom/realarcade/DOJ/MrGame$Platform;
.super Ljava/lang/Object;
.source "MrGame.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/realarcade/DOJ/MrGame;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Platform"
.end annotation


# instance fields
.field fp_x:I

.field fp_y:I

.field id:I

.field objOffset:I

.field speed:I

.field updateTime:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 9986
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
