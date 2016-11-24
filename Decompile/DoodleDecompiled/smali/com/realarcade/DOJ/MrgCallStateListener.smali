.class Lcom/realarcade/DOJ/MrgCallStateListener;
.super Landroid/telephony/PhoneStateListener;
.source "MrGame.java"


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 35
    invoke-direct {p0}, Landroid/telephony/PhoneStateListener;-><init>()V

    return-void
.end method


# virtual methods
.method public onCallStateChanged(ILjava/lang/String;)V
    .locals 4
    .param p1, "state"    # I
    .param p2, "incomingNumber"    # Ljava/lang/String;

    .prologue
    const/4 v3, 0x2

    .line 40
    sget-object v1, Lcom/realarcade/DOJ/MrGame;->p_mrgame:Lcom/realarcade/DOJ/MrGame;

    sget v1, Lcom/realarcade/DOJ/MrGame;->android_appStatus:I

    const/4 v2, 0x3

    if-ne v1, v2, :cond_1

    .line 58
    :cond_0
    :goto_0
    return-void

    .line 44
    :cond_1
    packed-switch p1, :pswitch_data_0

    goto :goto_0

    .line 50
    :pswitch_0
    sget-object v1, Lcom/realarcade/DOJ/MrGame;->p_mrgame:Lcom/realarcade/DOJ/MrGame;

    sget v1, Lcom/realarcade/DOJ/MrGame;->android_appStatus:I

    if-ne v1, v3, :cond_0

    .line 51
    sget-object v1, Lcom/realarcade/DOJ/MrGame;->p_mrgame:Lcom/realarcade/DOJ/MrGame;

    const/4 v1, 0x1

    sput v1, Lcom/realarcade/DOJ/MrGame;->android_appStatus:I

    .line 52
    sget-object v1, Lcom/realarcade/DOJ/MrGame;->p_mrgame:Lcom/realarcade/DOJ/MrGame;

    invoke-virtual {v1}, Lcom/realarcade/DOJ/MrGame;->getIntent()Landroid/content/Intent;

    move-result-object v0

    .line 53
    .local v0, "intent":Landroid/content/Intent;
    const/high16 v1, 0x20000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 54
    sget-object v1, Lcom/realarcade/DOJ/MrGame;->p_mrgame:Lcom/realarcade/DOJ/MrGame;

    invoke-virtual {v1, v0}, Lcom/realarcade/DOJ/MrGame;->startActivity(Landroid/content/Intent;)V

    goto :goto_0

    .line 47
    .end local v0    # "intent":Landroid/content/Intent;
    :pswitch_1
    sget-object v1, Lcom/realarcade/DOJ/MrGame;->p_mrgame:Lcom/realarcade/DOJ/MrGame;

    sput v3, Lcom/realarcade/DOJ/MrGame;->android_appStatus:I

    goto :goto_0

    .line 44
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method
