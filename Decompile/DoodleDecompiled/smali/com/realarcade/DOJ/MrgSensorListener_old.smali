.class Lcom/realarcade/DOJ/MrgSensorListener_old;
.super Ljava/lang/Object;
.source "MrGame.java"

# interfaces
.implements Landroid/hardware/SensorListener;


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 61
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAccuracyChanged(II)V
    .locals 0
    .param p1, "sensor"    # I
    .param p2, "accuracy"    # I

    .prologue
    .line 64
    return-void
.end method

.method public onSensorChanged(I[F)V
    .locals 6
    .param p1, "sensor"    # I
    .param p2, "values"    # [F

    .prologue
    const/4 v5, 0x5

    const/4 v4, 0x4

    const/4 v3, 0x3

    const/high16 v2, 0x47000000    # 32768.0f

    const v1, 0x411ce80a

    .line 70
    packed-switch p1, :pswitch_data_0

    .line 95
    :goto_0
    return-void

    .line 75
    :pswitch_0
    sget v0, Lcom/realarcade/DOJ/MrGame;->device_orientation:I

    packed-switch v0, :pswitch_data_1

    goto :goto_0

    .line 84
    :pswitch_1
    aget v0, p2, v3

    mul-float/2addr v0, v2

    div-float/2addr v0, v1

    float-to-int v0, v0

    sput v0, Lcom/realarcade/DOJ/MrGame;->p_acceleration_x:I

    .line 85
    aget v0, p2, v4

    mul-float/2addr v0, v2

    div-float/2addr v0, v1

    float-to-int v0, v0

    sput v0, Lcom/realarcade/DOJ/MrGame;->p_acceleration_y:I

    .line 86
    aget v0, p2, v5

    mul-float/2addr v0, v2

    div-float/2addr v0, v1

    float-to-int v0, v0

    sput v0, Lcom/realarcade/DOJ/MrGame;->p_acceleration_z:I

    goto :goto_0

    .line 78
    :pswitch_2
    aget v0, p2, v4

    mul-float/2addr v0, v2

    neg-float v0, v0

    div-float/2addr v0, v1

    float-to-int v0, v0

    sput v0, Lcom/realarcade/DOJ/MrGame;->p_acceleration_x:I

    .line 79
    aget v0, p2, v3

    mul-float/2addr v0, v2

    div-float/2addr v0, v1

    float-to-int v0, v0

    sput v0, Lcom/realarcade/DOJ/MrGame;->p_acceleration_y:I

    .line 80
    aget v0, p2, v5

    mul-float/2addr v0, v2

    div-float/2addr v0, v1

    float-to-int v0, v0

    sput v0, Lcom/realarcade/DOJ/MrGame;->p_acceleration_z:I

    goto :goto_0

    .line 70
    nop

    :pswitch_data_0
    .packed-switch 0x2
        :pswitch_0
    .end packed-switch

    .line 75
    :pswitch_data_1
    .packed-switch 0x1
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method
