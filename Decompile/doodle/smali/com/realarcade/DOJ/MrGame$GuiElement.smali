.class public Lcom/realarcade/DOJ/MrGame$GuiElement;
.super Ljava/lang/Object;
.source "MrGame.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/realarcade/DOJ/MrGame;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GuiElement"
.end annotation


# instance fields
.field align:I

.field ax:I

.field ay:I

.field drag_VX:I

.field drag_VY:I

.field drag_currX:I

.field drag_currY:I

.field drag_startOffsetX:I

.field drag_startOffsetY:I

.field drag_startX:I

.field drag_startY:I

.field draggableHoriz:Z

.field draggableVert:Z

.field eg_id:I

.field elementLevel:I

.field enabled:Z

.field event:I

.field eventMask:I

.field eventTime:I

.field eventTimeList:[I

.field h:I

.field id:I

.field isDragging:Z

.field isStatic:Z

.field keypadFocus:Z

.field params:[I

.field pos_align:I

.field pressX:I

.field pressY:I

.field txt:Ljava/lang/String;

.field type:I

.field visible:Z

.field w:I

.field x:I

.field y:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 5364
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
