.class Lcom/realarcade/DOJ/EditorCallback;
.super Ljava/lang/Object;
.source "MrGame.java"

# interfaces
.implements Ljava/lang/Runnable;


# static fields
.field public static final ANDROID_GAMEVIEW:I = 0x0

.field public static final ANDROID_VIDEOVIEW:I = 0x1


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 101
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 8

    .prologue
    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 105
    sget-boolean v4, Lcom/realarcade/DOJ/MrGame;->mDo_textinput:Z

    if-eqz v4, :cond_1

    .line 108
    sget-object v4, Lcom/realarcade/DOJ/MrGame;->mViewGroup:Landroid/widget/AbsoluteLayout;

    sget-object v5, Lcom/realarcade/DOJ/MrGame;->mDimView:Landroid/widget/ImageView;

    invoke-virtual {v4, v5}, Landroid/widget/AbsoluteLayout;->addView(Landroid/view/View;)V

    .line 109
    sget-object v4, Lcom/realarcade/DOJ/MrGame;->mViewGroup:Landroid/widget/AbsoluteLayout;

    sget-object v5, Lcom/realarcade/DOJ/MrGame;->mLinearLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v4, v5}, Landroid/widget/AbsoluteLayout;->addView(Landroid/view/View;)V

    .line 111
    sget-object v4, Lcom/realarcade/DOJ/MrGame;->mEditCaption:Landroid/widget/TextView;

    sget-object v5, Lcom/realarcade/DOJ/MrGame;->mTextCaption:Ljava/lang/String;

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 112
    sget-object v4, Lcom/realarcade/DOJ/MrGame;->mEditText:Landroid/widget/EditText;

    sget-object v5, Lcom/realarcade/DOJ/MrGame;->mDefaultText:Ljava/lang/String;

    invoke-virtual {v4, v5}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 113
    sget-object v4, Lcom/realarcade/DOJ/MrGame;->mTextInputButton:Landroid/widget/Button;

    sget-object v5, Lcom/realarcade/DOJ/MrGame;->mOkText:Ljava/lang/String;

    invoke-virtual {v4, v5}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 115
    new-array v0, v7, [Landroid/text/InputFilter;

    .line 116
    .local v0, "FilterArray":[Landroid/text/InputFilter;
    new-instance v4, Landroid/text/InputFilter$LengthFilter;

    sget v5, Lcom/realarcade/DOJ/MrGame;->mTextMaxLength:I

    invoke-direct {v4, v5}, Landroid/text/InputFilter$LengthFilter;-><init>(I)V

    aput-object v4, v0, v6

    .line 117
    sget-object v4, Lcom/realarcade/DOJ/MrGame;->mEditText:Landroid/widget/EditText;

    invoke-virtual {v4, v0}, Landroid/widget/EditText;->setFilters([Landroid/text/InputFilter;)V

    .line 119
    sget-object v4, Lcom/realarcade/DOJ/MrGame;->mEditText:Landroid/widget/EditText;

    invoke-virtual {v4}, Landroid/widget/EditText;->requestFocusFromTouch()Z

    .line 120
    sget-object v4, Lcom/realarcade/DOJ/MrGame;->mEditText:Landroid/widget/EditText;

    invoke-virtual {v4}, Landroid/widget/EditText;->selectAll()V

    .line 123
    sget v4, Lcom/realarcade/DOJ/MrGame;->api_version:I

    const/4 v5, 0x3

    if-lt v4, v5, :cond_0

    .line 125
    :try_start_0
    const-string v4, "android.view.inputmethod.InputMethodManager"

    invoke-static {v4}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v2

    .line 126
    .local v2, "immclass":Ljava/lang/Class;
    sget-object v4, Lcom/realarcade/DOJ/MrGame;->p_mrgame:Lcom/realarcade/DOJ/MrGame;

    const-string v5, "input_method"

    invoke-virtual {v4, v5}, Lcom/realarcade/DOJ/MrGame;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    .line 127
    .local v1, "imm":Ljava/lang/Object;
    const-string v4, "showSoftInput"

    const/4 v5, 0x2

    new-array v5, v5, [Ljava/lang/Class;

    const/4 v6, 0x0

    const-class v7, Landroid/view/View;

    aput-object v7, v5, v6

    const/4 v6, 0x1

    sget-object v7, Ljava/lang/Integer;->TYPE:Ljava/lang/Class;

    aput-object v7, v5, v6

    invoke-virtual {v2, v4, v5}, Ljava/lang/Class;->getDeclaredMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v3

    .line 128
    .local v3, "immshowSoftInput":Ljava/lang/reflect/Method;
    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    sget-object v6, Lcom/realarcade/DOJ/MrGame;->mEditText:Landroid/widget/EditText;

    aput-object v6, v4, v5

    const/4 v5, 0x1

    new-instance v6, Ljava/lang/Integer;

    const/4 v7, 0x0

    invoke-direct {v6, v7}, Ljava/lang/Integer;-><init>(I)V

    aput-object v6, v4, v5

    invoke-virtual {v3, v1, v4}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 136
    .end local v0    # "FilterArray":[Landroid/text/InputFilter;
    .end local v1    # "imm":Ljava/lang/Object;
    .end local v2    # "immclass":Ljava/lang/Class;
    .end local v3    # "immshowSoftInput":Ljava/lang/reflect/Method;
    :cond_0
    :goto_0
    return-void

    .line 133
    :cond_1
    sget-object v4, Lcom/realarcade/DOJ/MrGame;->mViewGroup:Landroid/widget/AbsoluteLayout;

    sget-object v5, Lcom/realarcade/DOJ/MrGame;->mDimView:Landroid/widget/ImageView;

    invoke-virtual {v4, v5}, Landroid/widget/AbsoluteLayout;->removeView(Landroid/view/View;)V

    .line 134
    sget-object v4, Lcom/realarcade/DOJ/MrGame;->mViewGroup:Landroid/widget/AbsoluteLayout;

    sget-object v5, Lcom/realarcade/DOJ/MrGame;->mLinearLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v4, v5}, Landroid/widget/AbsoluteLayout;->removeView(Landroid/view/View;)V

    goto :goto_0

    .line 129
    .restart local v0    # "FilterArray":[Landroid/text/InputFilter;
    :catch_0
    move-exception v4

    goto :goto_0
.end method
