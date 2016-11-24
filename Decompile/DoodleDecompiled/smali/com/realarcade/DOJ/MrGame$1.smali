.class Lcom/realarcade/DOJ/MrGame$1;
.super Ljava/lang/Object;
.source "MrGame.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/realarcade/DOJ/MrGame;->createViews()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/realarcade/DOJ/MrGame;


# direct methods
.method constructor <init>(Lcom/realarcade/DOJ/MrGame;)V
    .locals 0

    .prologue
    .line 3256
    iput-object p1, p0, Lcom/realarcade/DOJ/MrGame$1;->this$0:Lcom/realarcade/DOJ/MrGame;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 8
    .param p1, "v"    # Landroid/view/View;

    .prologue
    const/4 v7, 0x0

    .line 3258
    sget v3, Lcom/realarcade/DOJ/MrGame;->api_version:I

    const/4 v4, 0x3

    if-lt v3, v4, :cond_0

    .line 3260
    :try_start_0
    const-string v3, "android.view.inputmethod.InputMethodManager"

    invoke-static {v3}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v1

    .line 3261
    .local v1, "immclass":Ljava/lang/Class;
    sget-object v3, Lcom/realarcade/DOJ/MrGame;->p_mrgame:Lcom/realarcade/DOJ/MrGame;

    const-string v4, "input_method"

    invoke-virtual {v3, v4}, Lcom/realarcade/DOJ/MrGame;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    .line 3262
    .local v0, "imm":Ljava/lang/Object;
    const-string v3, "hideSoftInputFromWindow"

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/Class;

    const/4 v5, 0x0

    const-class v6, Landroid/os/IBinder;

    aput-object v6, v4, v5

    const/4 v5, 0x1

    sget-object v6, Ljava/lang/Integer;->TYPE:Ljava/lang/Class;

    aput-object v6, v4, v5

    invoke-virtual {v1, v3, v4}, Ljava/lang/Class;->getDeclaredMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v2

    .line 3263
    .local v2, "immhideSoftInput":Ljava/lang/reflect/Method;
    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    sget-object v5, Lcom/realarcade/DOJ/MrGame;->mEditText:Landroid/widget/EditText;

    invoke-virtual {v5}, Landroid/widget/EditText;->getWindowToken()Landroid/os/IBinder;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x1

    new-instance v5, Ljava/lang/Integer;

    const/4 v6, 0x0

    invoke-direct {v5, v6}, Ljava/lang/Integer;-><init>(I)V

    aput-object v5, v3, v4

    invoke-virtual {v2, v0, v3}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 3267
    .end local v0    # "imm":Ljava/lang/Object;
    .end local v1    # "immclass":Ljava/lang/Class;
    .end local v2    # "immhideSoftInput":Ljava/lang/reflect/Method;
    :cond_0
    :goto_0
    sput-boolean v7, Lcom/realarcade/DOJ/MrGame;->mDo_textinput:Z

    .line 3268
    return-void

    .line 3264
    :catch_0
    move-exception v3

    goto :goto_0
.end method
