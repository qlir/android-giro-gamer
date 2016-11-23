.class public Lcom/realarcade/DOJ/MrGame$CharArraySeq;
.super Ljava/lang/Object;
.source "MrGame.java"

# interfaces
.implements Ljava/lang/CharSequence;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/realarcade/DOJ/MrGame;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CharArraySeq"
.end annotation


# instance fields
.field public arr:[C

.field public len:I

.field public start:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 1233
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public charAt(I)C
    .locals 2
    .param p1, "i"    # I

    .prologue
    .line 1237
    iget-object v0, p0, Lcom/realarcade/DOJ/MrGame$CharArraySeq;->arr:[C

    iget v1, p0, Lcom/realarcade/DOJ/MrGame$CharArraySeq;->start:I

    add-int/2addr v1, p1

    aget-char v0, v0, v1

    return v0
.end method

.method public length()I
    .locals 1

    .prologue
    .line 1238
    iget v0, p0, Lcom/realarcade/DOJ/MrGame$CharArraySeq;->len:I

    return v0
.end method

.method public subSequence(II)Ljava/lang/CharSequence;
    .locals 3
    .param p1, "xstart"    # I
    .param p2, "xend"    # I

    .prologue
    .line 1239
    iget-object v0, p0, Lcom/realarcade/DOJ/MrGame$CharArraySeq;->arr:[C

    iget v1, p0, Lcom/realarcade/DOJ/MrGame$CharArraySeq;->start:I

    add-int/2addr v1, p1

    sub-int v2, p2, p1

    invoke-static {v0, v1, v2}, Lcom/realarcade/DOJ/MrGame;->charseq_wrapArray([CII)Ljava/lang/CharSequence;

    move-result-object v0

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 4

    .prologue
    .line 1240
    new-instance v0, Ljava/lang/String;

    iget-object v1, p0, Lcom/realarcade/DOJ/MrGame$CharArraySeq;->arr:[C

    iget v2, p0, Lcom/realarcade/DOJ/MrGame$CharArraySeq;->start:I

    iget v3, p0, Lcom/realarcade/DOJ/MrGame$CharArraySeq;->len:I

    invoke-direct {v0, v1, v2, v3}, Ljava/lang/String;-><init>([CII)V

    return-object v0
.end method
