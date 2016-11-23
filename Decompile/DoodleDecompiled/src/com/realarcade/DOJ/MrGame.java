package com.realarcade.DOJ;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Canvas.VertexMode;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PowerManager.WakeLock;
import android.os.Process;
import android.os.Vibrator;
import android.telephony.TelephonyManager;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.VideoView;
import android.widget.ViewAnimator;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Random;

public class MrGame
  extends Activity
  implements Runnable, View.OnTouchListener
{
  public static final int ANDROID_APP_STATUS_BACKGROUNDED = 3;
  public static final int ANDROID_APP_STATUS_INCALL = 2;
  public static final int ANDROID_APP_STATUS_PREINIT = 0;
  public static final int ANDROID_APP_STATUS_STARTED = 1;
  public static final int ANDROID_GAMEVIEW = 0;
  public static final int ANDROID_THREAD_READY = 1;
  public static final int ANDROID_THREAD_STARTED = 2;
  public static final int ANDROID_VIDEOVIEW = 1;
  public static byte VC_defaultVolume;
  public static int VC_maxVolume;
  public static int acc_x;
  public static boolean activityInited;
  public static int android_appStatus;
  public static int android_loadbalance_frames;
  public static int api_version;
  public static int character_fp_accX;
  public static int character_fp_accY;
  public static int character_fp_height;
  public static int character_fp_posX;
  public static int character_fp_posY;
  public static int character_fp_stateTime;
  public static int character_fp_velX;
  public static int character_fp_velY;
  public static int character_fp_width;
  public static boolean character_isFacingLeft;
  public static int character_state;
  public static int common_fp_configBrownPlatformFallVelY;
  public static int common_fp_configCharacterSpringVelY;
  public static int common_fp_configCharacterYLimit;
  public static int common_fp_configJumpVelY;
  public static int common_fp_configLogicScreenHeight;
  public static int common_fp_configLogicScreenWidth;
  public static int common_fp_configMaxFallVelY;
  public static int common_fp_configMaxVelX;
  public static int common_fp_configNormalAccX;
  public static int common_fp_configNormalAccY;
  public static int common_fp_configNormalDecX;
  public static int common_fp_configPropellerHat1stPhaseDur;
  public static int common_fp_configPropellerHat2ndPhaseDur;
  public static int common_fp_configPropellerHat3rdPhaseDur;
  public static int common_fp_configShortLegsVelY;
  public static int common_fp_screenHeight;
  public static int common_fp_screenWidth;
  public static int common_fp_xRatio;
  public static int common_fp_yRatio;
  public static boolean cursorBlink;
  public static int device_height;
  public static int device_orientation;
  public static int device_width;
  public static int doj_backgroundPixelsOffset;
  public static boolean doj_classicMode;
  public static boolean doj_exitGame;
  public static int doj_fp_keyDownTime;
  public static int doj_fp_pixelAccX;
  public static int doj_fp_screenYOffset;
  public static int doj_fp_time;
  public static boolean doj_gameOver;
  public static int doj_initialMenu;
  public static boolean doj_isInGameMenu;
  public static boolean doj_leftKeyDown;
  public static boolean doj_pointerDown;
  public static int doj_pointerX;
  public static boolean doj_rightKeyDown;
  public static int doj_score;
  public static boolean doj_sfx_monsterWarning;
  public static boolean doj_sfx_ufoWarning;
  public static int doj_textInputMode;
  public static int dynamic_X_RES;
  public static int dynamic_Y_RES;
  public static int frameNum;
  public static int gametime;
  public static boolean gametimePaused;
  public static Typeface hack_font_b1;
  public static Typeface hack_font_b2;
  public static Typeface hack_font_b3;
  public static Typeface hack_font_sm;
  public static String highscores_playerName;
  public static int hs_currentTable;
  public static int[] hs_data_int;
  public static String[] hs_data_string;
  public static int intro_time;
  public static int loading_fp_posY;
  public static int loading_fp_velY;
  public static int loading_lastLoadingTime;
  public static int loading_stepsCounter;
  public static String mDefaultText;
  public static ColorDrawable mDimRect;
  public static ImageView mDimView;
  public static boolean mDo_textinput;
  public static TextView mEditCaption;
  public static EditText mEditText;
  public static EditorCallback mEditorCallback;
  public static LinearLayout mLinearLayout;
  public static MrgCallStateListener mMrgCallStateListener;
  public static MrgView mMrgView;
  public static String mOkText;
  public static SensorListener mSensorListener;
  public static SensorManager mSensorManager;
  public static SurfaceHolder mSurfaceHolder;
  public static String mTextCaption;
  public static Button mTextInputButton;
  public static int mTextMaxLength;
  public static VideoCallback mVideoCallback;
  public static VideoView mVideoView;
  public static ViewAnimator mViewAnimator;
  public static AbsoluteLayout mViewGroup;
  public static PowerManager.WakeLock mWakeLock;
  public static int m_currentvideoId;
  public static boolean m_videoCallback_called;
  public static boolean m_videoPlaying;
  public static boolean mainTextLoaded;
  public static int menu_fp_time;
  public static boolean menu_intro;
  public static int menu_softkey1;
  public static int menu_softkey2;
  public static boolean multiplayer_enabled;
  public static boolean multiplayer_loadingState;
  public static int multiplayer_maxplayers;
  public static int multiplayer_player;
  public static String multiplayer_player1;
  public static String multiplayer_player2;
  public static String multiplayer_player3;
  public static String multiplayer_player4;
  public static String multiplayer_player5;
  public static String multiplayer_player6;
  public static String multiplayer_player7;
  public static String multiplayer_player8;
  public static GameObject[] objects_array;
  public static int objects_begin;
  public static int objects_collidedIndex;
  public static int objects_end;
  public static int objects_holdOnIndex;
  public static int objects_maxHeight;
  public static int p_acceleration_x;
  public static int p_acceleration_y;
  public static int p_acceleration_z;
  public static Canvas p_activeGraphics;
  public static Bitmap[] p_allImages;
  public static String[] p_allTexts;
  public static ByteArrayInputStream p_bd_byteStream;
  public static DataInputStream p_bd_dataStream;
  public static ByteArrayOutputStream p_be_byteStream;
  public static DataOutputStream p_be_dataStream;
  public static int p_cal_day;
  public static int p_cal_month;
  public static int p_cal_secs;
  public static int p_cal_timezoneTemp;
  public static String p_cal_tmpstr;
  public static int p_cal_year;
  public static Canvas p_canvas;
  public static CharArraySeq[] p_charseq_pool;
  public static int p_clip_height;
  public static int p_clip_width;
  public static int p_clip_x;
  public static int p_clip_y;
  public static int p_confirmationPage;
  public static DataInputStream p_currentFile;
  public static boolean p_doPaint;
  public static int p_eg_areaH;
  public static int p_eg_areaW;
  public static int p_eg_areaX;
  public static int p_eg_areaY;
  public static boolean p_eg_autoScroll;
  public static int p_eg_compareBottomThreshold;
  public static int p_eg_compareLeftThreshold;
  public static int p_eg_compareRightThreshold;
  public static int p_eg_compareTopThreshold;
  public static boolean p_eg_draggingHorizontal;
  public static boolean p_eg_draggingVertical;
  public static int p_eg_elementAmount;
  public static GuiElement[] p_eg_elementList;
  public static int[] p_eg_elementOrdering;
  public static boolean p_eg_eventRegistered;
  public static int p_eg_focusElement;
  public static boolean p_eg_gameAreaFocusable;
  public static int p_eg_guiBorderBottom;
  public static int p_eg_guiBorderLeft;
  public static int p_eg_guiBorderRight;
  public static int p_eg_guiBorderTop;
  public static boolean p_eg_guiLocked;
  public static boolean p_eg_guiPainted;
  public static int p_eg_guiScrollDuration;
  public static int p_eg_guiScrollSrcX;
  public static int p_eg_guiScrollSrcY;
  public static int p_eg_guiScrollT;
  public static int p_eg_guiScrollX;
  public static int p_eg_guiScrollY;
  public static boolean p_eg_hackPressingKeyInsideGui;
  public static boolean p_eg_hidden;
  public static boolean p_eg_horizontalMovementEnabled;
  public static int p_eg_keyBindAmount;
  public static GuiKeyBind[] p_eg_keyBinds;
  public static boolean p_eg_keyMode;
  public static int p_eg_lastKeyRepeat;
  public static int p_eg_lastScrollPX;
  public static int p_eg_lastScrollPY;
  public static boolean p_eg_listeningKeyPresses;
  public static boolean p_eg_numpadEvent;
  public static int p_eg_oldTbInputFlags;
  public static int p_eg_origFocusElement;
  public static int p_eg_origPointerX;
  public static int p_eg_origPointerY;
  public static int p_eg_pointerDraggingElement;
  public static boolean p_eg_pointerReportedDown;
  public static int p_eg_pointerVX;
  public static int p_eg_pointerVY;
  public static boolean p_eg_pressEventRegistered;
  public static boolean p_eg_pressingGuiSoftkey;
  public static int p_eg_prevElementOnPointer;
  public static int p_eg_prevFocusElement;
  public static int p_eg_prevPointerX;
  public static int p_eg_prevPointerY;
  public static int p_eg_repeatAmount;
  public static int p_eg_repeatingKey;
  public static int p_eg_scrollMargin;
  public static boolean p_eg_scrollingWithPointer;
  public static boolean p_eg_verticalMovementOnly;
  public static boolean p_eg_wrappingEnabled;
  public static int p_em_confirmElement;
  public static String p_em_confirmText;
  public static boolean p_em_confirming;
  public static int[] p_em_currentMenuElements;
  public static int p_em_currentMenuLength;
  public static int p_em_currentMenuPointer;
  public static int p_em_currentMenuScroll;
  public static String p_em_currentMenuTextboxString;
  public static int p_em_currentMenuTopic;
  public static int p_em_currentMenuType;
  public static int p_em_cursorY;
  public static boolean p_em_gotoGame;
  public static boolean p_em_introMode;
  public static int p_em_maxLines;
  public static int[] p_em_menuStack;
  public static int[] p_em_pointerStack;
  public static boolean p_em_softkeysPaintedInThisFrame;
  public static int p_em_specialIngameMenu;
  public static int p_em_specialStartMenu;
  public static int p_em_stackPos;
  public static int p_em_textboxCurrentLine;
  public static int p_fonts_activeFont;
  public static int p_fonts_activeFrame;
  public static Canvas p_fonts_activeGraphics;
  public static boolean p_forcedPaint;
  public static boolean p_gameDisplay;
  public static boolean p_gameIntroInited;
  public static boolean p_game_menuInited;
  public static int p_gfx_currentColor;
  public static Paint p_gfx_paint;
  public static int[] p_gfx_typetable_fake;
  public static short[][] p_globalPalettes;
  public static boolean p_gp_loaded;
  public static int p_hacktime;
  public static String p_hs_userId;
  public static boolean p_inGame;
  public static byte[] p_indexTable1;
  public static short[] p_indexTable2;
  public static int[] p_indexTable3;
  public static boolean p_initializingState;
  public static boolean p_inputtingText;
  public static int[] p_keyBuffer;
  public static int p_keyCounter;
  public static boolean[] p_keyTypeBuffer;
  public static boolean[] p_keys;
  public static int p_lastCursorBlink;
  public static int p_lastFreeStream;
  public static long p_lastloadtime;
  public static int p_lasttime;
  public static boolean p_lb_fillScreen;
  public static int p_loadingBoxCounter;
  public static boolean p_mainGroupsLoaded;
  public static MrGame p_mrgame;
  public static int p_mspf;
  public static boolean p_newKeyEvent;
  public static int p_oldhacktime;
  public static byte[] p_options;
  public static boolean p_paintFinished;
  public static boolean[] p_pauseLock;
  public static boolean p_paused;
  public static int p_pointer_drag_x;
  public static int p_pointer_drag_y;
  public static boolean p_pointer_dragged;
  public static int p_pointer_lastPress_x;
  public static int p_pointer_lastPress_y;
  public static boolean p_pointer_moved;
  public static boolean p_pointer_moved2;
  public static int p_pointer_x;
  public static int p_pointer_y;
  public static int[] p_realsounds;
  public static int[] p_realsounds_streamID;
  public static int p_realtime;
  public static int[] p_riDestImage;
  public static int p_riPalIndex;
  public static int p_riXres;
  public static int p_riYres;
  public static long[] p_soundResumePosition;
  public static int[] p_sounds;
  public static int p_start;
  public static int p_starttime;
  public static int[] p_streamPriority;
  public static int[] p_stream_loopCount;
  public static long[] p_stream_playLength;
  public static long[] p_stream_startTime;
  public static int[] p_streams;
  public static char[] p_sw_tmparr;
  public static int p_tbBackupBorderHeight;
  public static int p_tbBackupBorderWidth;
  public static int p_tbBackupBorderX;
  public static int p_tbBackupBorderY;
  public static boolean p_tbBackupEmulateOld;
  public static int p_tbBackupFont;
  public static int p_tbBackupHandleFlags;
  public static int p_tbBackupHeight;
  public static int p_tbBackupId;
  public static String p_tbBackupString;
  public static int p_tbBackupTextX;
  public static int p_tbBackupTextY;
  public static int p_tbBackupWidth;
  public static int p_tbBorderHeight;
  public static int p_tbBorderWidth;
  public static int p_tbBorderX;
  public static int p_tbBorderY;
  public static int p_tbCurrentLine;
  public static int p_tbFont;
  public static int p_tbMaxLineWidth;
  public static int p_tbTextX;
  public static int p_tbTextY;
  public static int p_tb_anchorCount;
  public static int p_tb_avgLinesPerPage;
  public static int p_tb_backupConfirmHandleFlags;
  public static int p_tb_boxSizeHeight;
  public static int p_tb_changeTime;
  public static int p_tb_currenBoxId;
  public static int p_tb_imageCount;
  public static short[] p_tb_images;
  public static int p_tb_inputHandleFlags;
  public static int p_tb_lastVisibleLine;
  public static int p_tb_lineCount;
  public static short[] p_tb_lines;
  public static boolean p_tb_oldBehavior;
  public static int p_tb_origScroll;
  public static boolean p_tb_pointerHandleRelease;
  public static int p_tb_pointerLastY;
  public static int p_tb_pointerLastYSpeed;
  public static int p_tb_pointerOrigScroll;
  public static boolean p_tb_pointerPressedInside;
  public static int p_tb_realLineCount;
  public static int p_tb_scroll;
  public static int p_tb_scrollHeight;
  public static int p_tb_scrollTime;
  public static int p_tb_scrollVelocity;
  public static boolean p_tb_showScrollbar;
  public static short[] p_tb_stuff;
  public static int p_tb_stuffCount;
  public static int p_tb_stuffHeight;
  public static String p_tb_text;
  public static int p_tb_timeLeft;
  public static byte[] p_tempImage1;
  public static int[] p_tempImage2;
  public static String p_textinputCaption;
  public static int p_textinputOkLabel;
  public static String p_textinputString;
  public static Thread p_thread;
  public static int[] p_timebuffer;
  public static int p_timebufferlen;
  public static String p_uid_instanceId;
  public static Platform[] platforms_array;
  public static int platforms_begin;
  public static int platforms_end;
  public static int platforms_fp_wHeight;
  public static int platforms_fp_wWidth;
  public static int platforms_fp_width;
  public static int platforms_minDistance;
  public static short[] platforms_scenes;
  public static short[] platforms_scenes_easyIndexes;
  public static int platforms_scenes_easyUsed;
  public static int platforms_scenes_easyUsedMask;
  public static short[] platforms_scenes_hardIndexes;
  public static int platforms_scenes_hardUsed;
  public static int platforms_scenes_hardUsedMask;
  public static boolean popup_active;
  public static int popup_buttonTextId;
  public static short popup_type;
  public static boolean powerup_fallDirectionLeft;
  public static int powerup_fp_fallAccX;
  public static int powerup_fp_fallAccY;
  public static int powerup_fp_fallPosX;
  public static int powerup_fp_fallPosY;
  public static int powerup_fp_fallVelX;
  public static int powerup_fp_fallVelY;
  public static int powerup_fp_shieldTime;
  public static int powerup_nextJetPackHeight;
  public static int powerup_nextPropellerHatHeight;
  public static int powerup_usedJetPacks;
  public static boolean preinit_done;
  public static Projectile[] projectiles_array;
  public static int projectiles_count;
  public static int projectiles_holdOnIndex;
  public static Random rand_randomi;
  public static boolean repaintAll;
  public static boolean repaintScreen;
  public static short[] sinTbl;
  public static int smoothtime;
  public static SoundPool soundPool;
  public static HashMap<Integer, Integer> soundPoolMap;
  public static boolean surfaceReady;
  public static int tb_lScrollLine;
  public static boolean tb_loadFinished;
  public static int tb_maxLines;
  public static int tb_numLines;
  public static int tb_numPages;
  public static int thread_start_status;
  public static int timedelta;
  public static boolean tutorial_active;
  public static short tutorial_mode;
  
  static
  {
    if (!MrGame.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      p_clip_x = 0;
      p_clip_y = 0;
      p_clip_width = dynamic_X_RES;
      p_clip_height = dynamic_Y_RES;
      p_gfx_paint = new Paint();
      p_gfx_currentColor = -1;
      hack_font_b1 = Typeface.create(Typeface.SANS_SERIF, 1);
      hack_font_b2 = Typeface.create(Typeface.SANS_SERIF, 1);
      hack_font_b3 = Typeface.create(Typeface.SANS_SERIF, 1);
      hack_font_sm = Typeface.create(Typeface.DEFAULT, 0);
      p_sw_tmparr = new char[0];
      p_fonts_activeFont = -1;
      p_fonts_activeFrame = -1;
      p_fonts_activeGraphics = null;
      p_gp_loaded = false;
      p_tempImage1 = new byte[422289];
      p_allImages = new Bitmap[119];
      p_gfx_typetable_fake = new int[119];
      p_timebuffer = new int[4];
      p_charseq_pool = new CharArraySeq[16];
      p_allTexts = new String[71];
      p_pointer_moved2 = false;
      p_keyBuffer = new int[20];
      p_keys = new boolean['ǂ'];
      p_keyTypeBuffer = new boolean[20];
      p_keyCounter = 0;
      p_doPaint = false;
      p_hacktime = 0;
      p_oldhacktime = 0;
      p_initializingState = false;
      preinit_done = false;
      surfaceReady = false;
      activityInited = false;
      thread_start_status = 0;
      android_appStatus = 0;
      android_loadbalance_frames = 0;
      p_pauseLock = new boolean[] { false };
      p_em_menuStack = new int[5];
      p_em_pointerStack = new int[5];
      p_em_currentMenuElements = new int[8];
      p_tb_stuff = new short['܈'];
      p_tb_lines = new short['Ĭ'];
      p_tb_images = new short[80];
      p_inputtingText = false;
      return;
    }
  }
  
  public static String AndroidGetJADProperty(String paramString)
  {
    Resources localResources = p_mrgame.getApplicationContext().getResources();
    String str = paramString.replace('-', '_');
    return localResources.getString(localResources.getIdentifier(p_mrgame.getPackageName() + ":string/" + str, null, null));
  }
  
  public static boolean AndroidLaunchBrowser(String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
    p_mrgame.startActivity(localIntent);
    return true;
  }
  
  public static void AndroidVibrate(long paramLong)
  {
    ((Vibrator)p_mrgame.getSystemService("vibrator")).vibrate(paramLong);
  }
  
  public static int EG_NERP(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt3 < 0) {
      return paramInt1;
    }
    if (paramInt3 > paramInt4) {
      return paramInt2;
    }
    int i = (paramInt1 * (paramInt4 - (paramInt3 * (512 + -(paramInt3 << 8) / paramInt4) >> 8)) + paramInt2 * (paramInt3 * (512 + -(paramInt3 << 8) / paramInt4) >> 8)) / paramInt4;
    int j;
    label79:
    int k;
    if (paramInt1 < paramInt2)
    {
      j = paramInt1;
      if (i < j)
      {
        if (paramInt1 >= paramInt2) {
          break label111;
        }
        i = paramInt1;
      }
      if (paramInt1 <= paramInt2) {
        break label117;
      }
      k = paramInt1;
      label87:
      if (i > k) {
        if (paramInt1 <= paramInt2) {
          break label123;
        }
      }
    }
    label111:
    label117:
    label123:
    for (i = paramInt1;; i = paramInt2)
    {
      return i;
      j = paramInt2;
      break;
      i = paramInt2;
      break label79;
      k = paramInt2;
      break label87;
    }
  }
  
  public static int abs(int paramInt)
  {
    if (paramInt < 0) {
      return -paramInt;
    }
    return paramInt;
  }
  
  public static int alerp(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return lerp(paramInt1, paramInt2, (paramInt3 * (paramInt3 * 4) / paramInt4 - paramInt3) / 3, paramInt4);
  }
  
  public static String cal_format(String paramString)
  {
    p_cal_tmpstr = paramString;
    p_cal_fmt(1, p_cal_year, 4);
    p_cal_fmt(2, p_cal_month, 2);
    p_cal_fmt(3, p_cal_day, 2);
    p_cal_fmt(4, p_cal_secs / 3600, 2);
    p_cal_fmt(5, p_cal_secs / 60 % 60, 2);
    p_cal_fmt(6, p_cal_secs % 60, 2);
    return p_cal_tmpstr;
  }
  
  public static void character_addState(int paramInt)
  {
    character_state = paramInt | character_state;
    character_fp_stateTime = 0;
    if ((paramInt & 0x3000) != 0) {
      powerup_fp_shieldTime = 0;
    }
  }
  
  public static void character_draw()
  {
    int i;
    int j;
    if (character_fp_velX < 0)
    {
      character_isFacingLeft = true;
      i = doj_worldToScreenY(character_fp_posY);
      if ((character_fp_posY >= 0) || ((0x400 & character_state) == 0)) {
        break label534;
      }
      if (-character_fp_posY <= common_fp_configCharacterYLimit) {
        break label403;
      }
      j = doj_worldToScreenY(common_fp_configCharacterYLimit);
    }
    for (;;)
    {
      label50:
      int k = j;
      if (((0x1000 & character_state) != 0) || ((0x2000 & character_state) != 0)) {
        gfx_drawImage(96, doj_worldToScreenX(character_fp_posX), j - 23, 3, 0);
      }
      int n;
      int i1;
      int i8;
      int i10;
      int i11;
      label232:
      label301:
      int i2;
      int i3;
      int i7;
      int i5;
      if (projectiles_isAnyOnScreen())
      {
        n = doj_worldToScreenX(character_fp_posX);
        gfx_drawImage(42, n, j, 33, 0);
        i1 = k - 39;
        gfx_drawImage(43, n, i1, 33, 0);
        if ((0x800 & character_state) != 0)
        {
          int i14 = 44 + (smoothtime >> 6) % 2;
          int i15 = -8;
          int i16 = 4;
          if (character_isFacingLeft)
          {
            i15 = 8;
            i16 = 0;
          }
          gfx_drawImage(i14, i15 + n, i1, 3, i16);
        }
        if ((0x7 & character_state) != 0)
        {
          i8 = n;
          if (!character_isFacingLeft) {
            break label470;
          }
          (-1 + (8 + 23));
          int i13 = i8 + 30;
          i10 = 0;
          i11 = i13;
          int i12 = 5 + doj_worldToScreenY(character_fp_posY) - 46;
          gfx_drawImage(91 + (smoothtime >> 3) % 2, i11, i12, 17, i10);
        }
        if ((0x8 & character_state) != 0)
        {
          if (!powerup_fallDirectionLeft) {
            break label492;
          }
          gfx_drawImage(91, doj_worldToScreenX(powerup_fp_fallPosX), doj_worldToScreenY(powerup_fp_fallPosY), 17, 0);
        }
        if ((0x70 & character_state) != 0)
        {
          i2 = i1 + 11;
          i3 = n;
          if (!character_isFacingLeft) {
            break label515;
          }
          (8 + 0);
          i7 = i3 + 8;
          i5 = 0;
        }
      }
      label403:
      label470:
      label492:
      label515:
      int i4;
      for (int i6 = i7;; i6 = i4)
      {
        gfx_drawImage(94, i6, i2, 33, i5);
        if ((0x80 & character_state) != 0) {
          gfx_drawImage(93, doj_worldToScreenX(powerup_fp_fallPosX), doj_worldToScreenY(powerup_fp_fallPosY), 33, 0);
        }
        return;
        if (character_fp_velX <= 0) {
          break;
        }
        character_isFacingLeft = false;
        break;
        j = doj_worldToScreenY(0 - character_fp_posY);
        break label50;
        int m = 0;
        if (character_isFacingLeft) {
          n = doj_worldToScreenX(character_fp_posX) - 8;
        }
        for (;;)
        {
          gfx_drawImage(20, n, j, 33, m);
          i1 = k - 46;
          break;
          n = 8 + doj_worldToScreenX(character_fp_posX);
          m = 4;
        }
        int i9 = i8 - (-1 + (8 + 23));
        i10 = 4;
        i11 = i9;
        break label232;
        gfx_drawImage(91, doj_worldToScreenX(powerup_fp_fallPosX), doj_worldToScreenY(powerup_fp_fallPosY), 17, 4);
        break label301;
        i4 = i3 - (8 + 0);
        i5 = 4;
      }
      label534:
      j = i;
    }
  }
  
  public static void character_fire()
  {
    if ((0x14D77 & character_state) != 0) {}
    label152:
    label176:
    label273:
    label286:
    do
    {
      return;
      int i = objects_begin;
      int j = objects_end;
      int k = 0;
      if (i != j) {}
      int m;
      for (int n = objects_begin;; n++)
      {
        int i1 = 10 + objects_end;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5;
        if (n < i1)
        {
          if (objects_begin >= objects_end) {
            break label152;
          }
          i5 = n;
          int i6 = objects_end;
          i2 = 0;
          i3 = 0;
          i4 = 0;
          if (i5 != i6) {
            break label176;
          }
        }
        for (;;)
        {
          k = 0;
          if (i2 != 0) {
            k = (i3 - character_fp_posX) * (2457600 / (i4 - character_fp_posY - character_fp_height));
          }
          if (k != 0) {
            break label286;
          }
          for (m = rand() % 20 - 10; m == 0; m = rand() % 20 - 10) {}
          if (n < 10) {}
          for (i5 = n;; i5 = n - 10) {
            break;
          }
          if ((objects_array[i5].id == 4) || (objects_array[i5].id == 20) || (objects_array[i5].fp_y - doj_fp_screenYOffset <= character_fp_posY) || (objects_array[i5].fp_y - doj_fp_screenYOffset >= common_fp_configLogicScreenHeight)) {
            break label273;
          }
          i3 = objects_array[i5].fp_x;
          i4 = objects_array[i5].fp_y - doj_fp_screenYOffset;
          i2 = 1;
        }
      }
      k = 2457600 / m;
      projectiles_add(character_fp_posX, character_fp_posY + character_fp_height, k, 2457600);
    } while (rand() % 2 != 0);
  }
  
  public static void character_free() {}
  
  public static void character_init() {}
  
  public static void character_removeState(int paramInt)
  {
    character_state &= (paramInt ^ 0xFFFFFFFF);
  }
  
  public static void character_reset()
  {
    character_fp_velX = 0;
    character_fp_velY = common_fp_configJumpVelY;
    character_fp_accX = 0;
    character_fp_accY = -common_fp_configNormalAccY;
    character_fp_posX = common_fp_configLogicScreenWidth >> 1;
    character_fp_posY = 0;
    character_isFacingLeft = true;
    character_state = 0;
    character_fp_stateTime = 0;
    powerup_nextPropellerHatHeight = 1000 + rand() % 9000;
    powerup_nextJetPackHeight = 2500 + rand() % 9500;
    powerup_usedJetPacks = 0;
  }
  
  public static void character_setMenuMode()
  {
    character_reset();
    character_fp_accX = 0;
    character_fp_velX = 0;
    character_fp_posX = platforms_array[platforms_begin].fp_x;
    character_fp_accY = -1769472;
    character_fp_velY = 1105920;
    character_fp_posY = -163840;
    character_isFacingLeft = false;
  }
  
  public static void character_updateState(int paramInt)
  {
    character_fp_stateTime = paramInt + character_fp_stateTime;
    if ((0x3000 & character_state) != 0) {
      powerup_fp_shieldTime = paramInt + powerup_fp_shieldTime;
    }
  }
  
  public static CharSequence charseq_wrapArray(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    CharArraySeq localCharArraySeq = null;
    if (p_charseq_pool[0] == null) {
      for (int k = 0; k < 16; k++) {
        p_charseq_pool[k] = new CharArraySeq();
      }
    }
    for (int i = 0; i < 16; i++) {
      if (p_charseq_pool[i].arr == null) {
        localCharArraySeq = p_charseq_pool[i];
      }
    }
    if (localCharArraySeq == null)
    {
      for (int j = 0; j < 15; j++) {
        p_charseq_pool[j] = p_charseq_pool[(j + 1)];
      }
      CharArraySeq[] arrayOfCharArraySeq = p_charseq_pool;
      localCharArraySeq = new CharArraySeq();
      arrayOfCharArraySeq[15] = localCharArraySeq;
    }
    localCharArraySeq.arr = paramArrayOfChar;
    localCharArraySeq.start = paramInt1;
    localCharArraySeq.len = paramInt2;
    return localCharArraySeq;
  }
  
  public static void common_free() {}
  
  public static void common_init()
  {
    platforms_fp_wWidth = 116736;
    platforms_fp_wHeight = 30720;
    platforms_minDistance = platforms_fp_wHeight + (platforms_fp_wHeight >> 1) >> 11;
    common_fp_configNormalAccX = 798720;
    common_fp_configNormalDecX = 1024000;
    common_fp_configNormalAccY = 1769472;
    common_fp_configMaxVelX = 884736;
    common_fp_configMaxFallVelY = -1105920;
    common_fp_configJumpVelY = 1105920;
    common_fp_configShortLegsVelY = 983040;
    common_fp_configCharacterYLimit = 471040;
    common_fp_configBrownPlatformFallVelY = 614400;
    common_fp_configCharacterSpringVelY = 1843200;
    common_fp_configPropellerHat1stPhaseDur = 2730;
    common_fp_configPropellerHat2ndPhaseDur = 3072;
    common_fp_configPropellerHat3rdPhaseDur = 1024;
    common_fp_configLogicScreenWidth = 655360;
    common_fp_configLogicScreenHeight = 983040;
    common_reset();
  }
  
  public static void common_reset() {}
  
  public static void data_closeFile()
  {
    if (p_currentFile != null) {}
    try
    {
      p_currentFile.close();
      p_currentFile = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public static void data_openFile(String paramString, long paramLong)
  {
    int i = (int)paramLong;
    try
    {
      mrg_loading(4, i);
      data_closeFile();
      DataInputStream localDataInputStream = new DataInputStream(p_mrgame.getClass().getResourceAsStream("/assets/data/" + paramString));
      while (paramLong > 0L) {
        paramLong -= localDataInputStream.skip(paramLong);
      }
      p_currentFile = localDataInputStream;
      return;
    }
    catch (Exception localException) {}
  }
  
  public static void data_readFile(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
    throws IOException
  {
    data_openFile(paramString, paramInt1);
    data_readToByteArray(paramInt1, paramInt2, paramArrayOfByte);
    data_closeFile();
    mrg_loading(4, 0);
  }
  
  public static void data_readToByteArray(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
    throws IOException
  {
    while (paramInt2 > 0)
    {
      int i = p_currentFile.read(paramArrayOfByte, paramInt1, paramInt2);
      paramInt1 += i;
      paramInt2 -= i;
    }
  }
  
  public static void data_skip(long paramLong)
    throws IOException
  {
    while (paramLong > 0L) {
      paramLong -= p_currentFile.skip(paramLong);
    }
  }
  
  public static void demo_keyPressed(int paramInt) {}
  
  public static void demo_keyReleased(int paramInt)
  {
    if ((mrg_isKey(paramInt, 355)) || (mrg_isKey(paramInt, 50)))
    {
      popup_delete();
      doj_endGame();
    }
  }
  
  public static void demo_screenSizeChanged()
  {
    popup_delete();
    popup_create(p_allTexts[69], 1016, 70, (short)2);
  }
  
  public static void doj_DrawGameBackground()
  {
    if (p_em_introMode) {}
    gfx_setColor(16052202);
    gfx_fillRect(0, 0, dynamic_X_RES, dynamic_Y_RES - 0);
  }
  
  public static void doj_DrawHud()
  {
    int i = gfx_getFontHeight(0) + (gfx_getFontHeight(0) >> 2);
    gfx_setColor(13228253);
    gfx_fillRect(0, 0, dynamic_X_RES, i);
    int j = dynamic_Y_RES >> 6;
    String str1 = txt_addThousandSeparator_s("" + doj_score, p_allTexts[30]);
    gfx_setColor(0);
    gfx_drawString(0, str1, dynamic_X_RES >> 4, j, 20);
    gfx_drawImage(104, dynamic_X_RES - (dynamic_X_RES >> 4), 0, 24, 0);
    if (multiplayer_enabled)
    {
      String str2 = txt_stringParam(p_allTexts[40], "" + (1 + multiplayer_player), 1);
      gfx_setColor(0);
      gfx_drawString(0, str2, dynamic_X_RES - 22 - (dynamic_X_RES >> 3), 0, 24);
    }
  }
  
  public static void doj_clearGameState()
  {
    platforms_reset();
    objects_reset();
    doj_exitGame = false;
    doj_fp_screenYOffset = 0;
    doj_score = 0;
    doj_backgroundPixelsOffset = 0;
    doj_leftKeyDown = false;
    doj_rightKeyDown = false;
    doj_fp_keyDownTime = 0;
    doj_pointerDown = false;
    if (p_options[4] == 0) {}
    for (boolean bool = true;; bool = false)
    {
      doj_classicMode = bool;
      character_reset();
      doj_fp_time = 0;
      projectiles_reset();
      doj_sfx_monsterWarning = false;
      doj_sfx_ufoWarning = false;
      return;
    }
  }
  
  public static void doj_drawGameOverScreen()
  {
    int i = eg_getElementHeight(1005);
    int j = 8 + (i + eg_getElementY(1005));
    for (int k = 0;; k++)
    {
      int m = 0;
      if (k < 10)
      {
        if (doj_score > hs_data_int[k]) {
          m = 1;
        }
      }
      else
      {
        if (m != 0)
        {
          gfx_setColor(0);
          gfx_drawString(0, highscores_playerName, dynamic_X_RES >> 1, j, 17);
          j += 8 + (i >> 1);
        }
        p_doj_drawScoreWithLabel(p_allTexts[52], doj_score, j);
        int n = j + (8 + (i >> 1));
        int i1 = hs_data_int[0];
        if (i1 <= 0) {
          i1 = doj_score;
        }
        p_doj_drawScoreWithLabel(p_allTexts[53], i1, n);
        return;
      }
    }
  }
  
  public static void doj_drawMultiplayerGameOverScreen()
  {
    int i = 8 + (eg_getElementHeight(1004) + eg_getElementY(1004));
    if (doj_score >= 0) {
      p_doj_drawScoreWithLabel(p_allTexts[52], doj_score, i);
    }
    tb_drawEx(p_tbFont, p_tbTextX, p_tbTextY, p_tb_scroll >> 10);
    drawTextBoxArrows();
  }
  
  public static void doj_endGame()
  {
    if ((doj_gameOver) && (!multiplayer_loadingState)) {
      return;
    }
    doj_gameOver = true;
    doj_stopWarningSounds();
    mrg_resetKeys();
    eg_reset();
    if (multiplayer_enabled)
    {
      eg_listenKeyPresses(false);
      int n = -1;
      int i2;
      int i3;
      if (!multiplayer_loadingState)
      {
        int i1 = dynamic_Y_RES >> 10;
        i2 = dynamic_X_RES >> 4;
        i3 = 48 + (48 + (i1 + 8));
        mrg_resetKeys();
        doj_textInputMode = 1;
        eg_lockGui(true);
        multiplayer_setCurrentPlayerName(mrp_textinput(p_allTexts[38], multiplayer_getCurrentPlayerName(), 51, 8, 0));
        eg_lockGui(false);
        highscores_multi_add(multiplayer_getCurrentPlayerName(), doj_score);
        multiplayer_saveState();
        if (multiplayer_player == multiplayer_maxplayers) {
          egi_eventPressed(22);
        }
      }
      for (;;)
      {
        eg_setFocus(n);
        mrg_resetKeys();
        return;
        n = p_menu_createMultiplayerEndGameMenu();
        mrg_resetKeys();
        menu_createMultiplayerScoresTB(i2, i3);
        continue;
        n = p_menu_createMultiplayerEndGameMenu();
      }
    }
    int k;
    for (int i = 0;; i++)
    {
      int j = 0;
      if (i < 10)
      {
        if (doj_score > hs_data_int[i]) {
          j = 1;
        }
      }
      else
      {
        if (j == 0) {
          break label291;
        }
        eg_listenKeyPresses(false);
        mrg_resetKeys();
        doj_textInputMode = 1;
        eg_lockGui(true);
        highscores_playerName = mrp_textinput(p_allTexts[38], highscores_playerName, 51, 8, 0);
        eg_lockGui(false);
        mrg_resetKeys();
        highscores_add(highscores_playerName, doj_score);
        k = 1;
        for (int m = 0; m < 10; m++) {
          if (doj_score < hs_data_int[m]) {
            k = 0;
          }
        }
      }
    }
    if (k != 0) {}
    label291:
    p_menu_createSingleplayerEndGameMenu();
    eg_listenKeyPresses(true);
    eg_setFocus(1005);
  }
  
  public static void doj_free()
  {
    platforms_free();
    objects_free();
    common_free();
    highscores_free();
    projectiles_free();
    sinTbl = null;
  }
  
  public static void doj_init()
  {
    doj_gameOver = false;
    menu_intro = true;
    common_init();
    loading_init();
    doj_updateScreenSizes();
    multiplayer_init();
    doj_initialMenu = 0;
    acc_x = -1;
    popup_init();
    platforms_init();
    objects_init();
    initSinTables();
    menu_reset();
  }
  
  public static void doj_postInit()
  {
    doj_restartGame();
    highscores_init();
    projectiles_init();
    tutorial_init();
  }
  
  public static void doj_restartGame()
  {
    doj_clearGameState();
    doj_gameOver = false;
    eg_reset();
  }
  
  public static void doj_stopWarningSounds()
  {
    if (doj_sfx_ufoWarning)
    {
      sfx_stop(16);
      doj_sfx_ufoWarning = false;
    }
    if (doj_sfx_monsterWarning) {
      doj_sfx_monsterWarning = false;
    }
  }
  
  public static void doj_updateScreenSizes()
  {
    common_fp_screenWidth = dynamic_X_RES << 11;
    common_fp_screenHeight = dynamic_Y_RES << 11;
    common_fp_xRatio = fp_div(common_fp_screenWidth, common_fp_configLogicScreenWidth);
    common_fp_yRatio = fp_div(common_fp_screenHeight, common_fp_configLogicScreenHeight);
    platforms_fp_width = fp_mul(common_fp_xRatio, platforms_fp_wWidth);
    character_fp_width = fp_div(63488, common_fp_xRatio);
    character_fp_height = fp_div(94208, common_fp_yRatio);
    doj_fp_pixelAccX = common_fp_configNormalAccX / ((dynamic_X_RES >> 1) - (dynamic_X_RES >> 3));
    if ((!p_inGame) || ((!p_gameDisplay) && (p_inGame) && (!doj_gameOver))) {
      menu_screenSizeUpdate();
    }
    for (;;)
    {
      if (popup_active) {
        popup_screenSizeUpdate();
      }
      return;
      if ((!doj_gameOver) && (!popup_active)) {
        mrg_requestIngameMenu();
      }
      if (doj_gameOver)
      {
        eg_reset();
        menu_reinitializeEndGameMenu();
      }
    }
  }
  
  public static int doj_worldToScreenX(int paramInt)
  {
    return fp_mul(paramInt, common_fp_xRatio) >> 11;
  }
  
  public static int doj_worldToScreenY(int paramInt)
  {
    return 0 - (fp_mul(paramInt, common_fp_yRatio) >> 11) + dynamic_Y_RES;
  }
  
  public static void dojmenu_createGui(int paramInt)
  {
    p_indexTable2['Ʋ'] = 0;
    eg_reset();
    if ((em_getMenuType(paramInt) == 0) || (em_getMenuType(paramInt) == 5))
    {
      int i = em_getAmountOfVisibleElements(paramInt);
      (85 + (4 + (dynamic_Y_RES >> 4) + (0 + gfx_getFontHeight(1))));
      (dynamic_Y_RES - 1 - (0 + gfx_getFontHeight(0)));
      int j = dynamic_X_RES >> 5;
      int k = dynamic_X_RES - (dynamic_X_RES >> 5);
      int m = 21 + 85;
      int n;
      label136:
      int i2;
      label169:
      int i35;
      int i36;
      int i37;
      label237:
      int i38;
      int i40;
      if (gfx_getFontHeight(0) > gfx_getFontHeight(0))
      {
        n = gfx_getFontHeight(0);
        if ((paramInt != 0) && (paramInt != 10)) {
          break label350;
        }
        int i1 = 50 + 85;
        eg_setArea(0, 85, dynamic_X_RES, dynamic_Y_RES - i1);
        if (paramInt == 2) {
          eg_setArea(0, 85 + gfx_getFontHeight(0), dynamic_X_RES, dynamic_Y_RES - 85 - gfx_getFontHeight(0));
        }
        i2 = 0;
        if (i2 >= i) {
          break label399;
        }
        i35 = em_getVisibleMenuElement(paramInt, i2);
        i36 = p_indexTable2[(348 + (3 + i35 * 4))];
        String str = p_allTexts[i36];
        i37 = 0;
        if (str != null) {
          i37 = 21 + gfx_stringWidth(0, p_allTexts[i36]);
        }
        if (i37 <= 105) {
          break label385;
        }
        i38 = i37 + (dynamic_X_RES >> 3);
        int i39 = gfx_getFontHeight(0);
        (21 >> 1);
        i40 = i39 + 10;
        if (i40 <= 40) {
          break label392;
        }
      }
      for (;;)
      {
        if (p_indexTable2[(348 + i35 * 4)] == 4)
        {
          i40 = n * 5 >> 1;
          i38 = k - j;
        }
        eg_addTextButton(i35, p_allTexts[i36], 17, 17, 0, m, i38, i40);
        m += i40 + 8;
        i2++;
        break label169;
        n = gfx_getFontHeight(0);
        break;
        label350:
        int i41 = 50 + (85 + gfx_getFontHeight(0));
        eg_setArea(0, 85 + gfx_getFontHeight(0), dynamic_X_RES, dynamic_Y_RES - i41);
        break label136;
        label385:
        i37 = 105;
        break label237;
        label392:
        i40 = 40;
      }
      label399:
      int i3 = em_getVisibleMenuElement(paramInt, 0);
      eg_setVerticalMenuMode(true);
      eg_enableAutoScroll(true);
      eg_listenKeyPresses(true);
      eg_enableWrapping(true);
      eg_setFocus(i3);
    }
    int i4;
    int i5;
    int i6;
    int i7;
    int i31;
    label681:
    int i33;
    if ((em_getMenuType(paramInt) == 1) || (em_getMenuType(paramInt) == 4))
    {
      i4 = 85 + gfx_getFontHeight(0);
      i5 = dynamic_Y_RES - 40;
      i6 = dynamic_X_RES >> 5;
      i7 = dynamic_X_RES - (dynamic_X_RES >> 5);
      if (paramInt == 3)
      {
        int i34 = i6 + 5;
        menu_createHighscoresTB(0, i34, i4, i7 - 5 - i34, i5 - i4, 0, 0, 8);
        p_tb_handleInput(-1, true);
      }
    }
    else
    {
      if (paramInt != 9) {
        break label1571;
      }
      eg_reset();
      eg_listenKeyPresses(false);
      mrg_resetKeys();
      multiplayer_enabled = true;
      int i22 = gfx_getFontHeight(0);
      int i23 = i22 * 5 >> 1;
      int i24 = dynamic_X_RES - (dynamic_X_RES >> 5) - (dynamic_X_RES >> 5);
      int i25 = 60 + (i24 >> 2);
      int i26 = (dynamic_X_RES >> 1) - (i24 >> 1) + (i25 >> 1);
      int i27 = i24 - i25;
      (21 + 85);
      int i28 = 106 + gfx_getFontHeight(0);
      eg_addSelector(1009, 0, 6, multiplayer_maxplayers - 1, false, 5, 20, i26, i28, i27, i23);
      int i29 = i28 + (i23 + 8);
      int i30 = p_indexTable2['ţ'];
      i31 = gfx_stringWidth(0, p_allTexts[i30]);
      if (i31 <= 105) {
        break label785;
      }
      int i32 = i31 + (dynamic_X_RES >> 3);
      i33 = i22 * 3 >> 1;
      if (i33 <= 40) {
        break label792;
      }
      label706:
      eg_addTextButton(1, p_allTexts[i30], 17, 17, 0, i29, i32, i33);
      eg_setFocus(1009);
      multiplayer_loadState();
      if (!multiplayer_loadingState) {
        break label799;
      }
      eg_reset();
      p_em_gotoGame = true;
    }
    label785:
    label792:
    label799:
    label950:
    label971:
    label1089:
    label1110:
    label1322:
    label1343:
    do
    {
      return;
      if (em_getCurrentMenuText() != null) {
        p_tb_makeBordered(0, em_getCurrentMenuText(), i6, i4, i7 - i6, i5 - i4, 0, 0, 8, true);
      }
      break;
      i31 = 105;
      break label681;
      i33 = 40;
      break label706;
      eg_setVerticalMenuMode(true);
      eg_listenKeyPresses(true);
      if (paramInt == 10)
      {
        eg_reset();
        eg_listenKeyPresses(false);
        mrg_resetKeys();
        int i20 = 85 + (8 + (dynamic_Y_RES >> 10));
        menu_addTextButton(1004, p_allTexts[36], 17, 17, 0, i20);
        eg_setFocus(1004);
        (40 + 8);
        int i21 = i20 + 48;
        menu_addTextButton(1008, p_allTexts[42], 17, 17, 0, i21);
        (40 + 8);
        menu_createMultiplayerScoresTB(21, i21 + 48);
        eg_setVerticalMenuMode(true);
      }
      if (paramInt == 6)
      {
        eg_reset();
        int i17 = p_indexTable2['ţ'];
        if (21 + gfx_stringWidth(0, p_allTexts[i17]) <= 105) {
          break label1582;
        }
        int i18 = gfx_getFontHeight(0);
        (21 >> 1);
        if (i18 + 10 <= 40) {
          break label1585;
        }
        if (highscores_hasUserScore(0)) {
          menu_addTextButton(1011, p_allTexts[46], 17, 17, 0, 21 + (85 + gfx_getFontHeight(0)));
        }
        (21 * 2);
        int i19 = 42 + gfx_getFontHeight(0);
        menu_addTextButton(1012, p_allTexts[47], 17, 17, 0, i19 + (85 + gfx_getFontHeight(0)));
        mrg_resetKeys();
        eg_listenKeyPresses(true);
      }
      if (paramInt == 7)
      {
        eg_reset();
        int i13 = p_indexTable2['ţ'];
        if (21 + gfx_stringWidth(0, p_allTexts[i13]) <= 105) {
          break label1588;
        }
        int i14 = gfx_getFontHeight(0);
        (21 >> 1);
        if (i14 + 10 <= 40) {
          break label1591;
        }
        int i15 = 85 + gfx_getFontHeight(0);
        eg_addTextButton(1013, p_allTexts[2], 5, 24, (dynamic_X_RES >> 1) + 21 / 2, i15, 79 + gfx_stringWidth(0, p_allTexts[2]), 40);
        eg_addTextButton(1015, p_allTexts[3], 5, 20, (dynamic_X_RES >> 1) + 21 / 2, i15, 79 + gfx_stringWidth(0, p_allTexts[3]), 40);
        int i16 = i15 + 60;
        p_tb_makeBordered(0, txt_stringParam(p_allTexts[48], "" + hs_data_int[0], 1), dynamic_X_RES >> 4, i16, dynamic_X_RES - (dynamic_X_RES >> 3), dynamic_Y_RES - i16 - 60, 0, 0, 8, true);
        p_tb_handleInput(-1, true);
        mrg_resetKeys();
        eg_listenKeyPresses(true);
      }
      if (paramInt == 8)
      {
        eg_reset();
        int i9 = p_indexTable2['ţ'];
        if (21 + gfx_stringWidth(0, p_allTexts[i9]) <= 105) {
          break label1594;
        }
        int i10 = gfx_getFontHeight(0);
        (21 >> 1);
        if (i10 + 10 <= 40) {
          break label1597;
        }
        int i11 = 85 + gfx_getFontHeight(0);
        eg_addTextButton(1014, p_allTexts[2], 5, 24, (dynamic_X_RES >> 1) + 21 / 2, i11, 79 + gfx_stringWidth(0, p_allTexts[2]), 40);
        eg_addTextButton(1015, p_allTexts[3], 5, 20, (dynamic_X_RES >> 1) + 21 / 2, i11, 79 + gfx_stringWidth(0, p_allTexts[3]), 40);
        int i12 = i11 + 60;
        p_tb_makeBordered(0, p_allTexts[49], dynamic_X_RES >> 4, i12, dynamic_X_RES - (dynamic_X_RES >> 3), dynamic_Y_RES - i12 - 60, 0, 0, 8, true);
        p_tb_handleInput(-1, true);
        mrg_resetKeys();
        eg_listenKeyPresses(true);
      }
    } while ((em_getBackKeyHint() == -1) || (paramInt == 2) || (paramInt == 10));
    int i8 = 2 + gfx_getFontHeight(0);
    if (i8 > 40) {}
    for (;;)
    {
      eg_addTextButton(1003, p_allTexts[em_getBackKeyHint()], 5, 24, dynamic_X_RES - 10, dynamic_Y_RES - i8, (dynamic_X_RES >> 1) - 21, i8, true);
      eg_setElementStatic(1003, true);
      return;
      label1571:
      if (paramInt != 0) {
        break;
      }
      multiplayer_enabled = false;
      break;
      label1582:
      break label950;
      label1585:
      break label971;
      label1588:
      break label1089;
      label1591:
      break label1110;
      label1594:
      break label1322;
      label1597:
      break label1343;
      i8 = 40;
    }
  }
  
  public static void drawTextBoxArrows()
  {
    int i = dynamic_X_RES >> 1;
    int j = p_tbBorderY;
    int k = p_tbBorderY + p_tbBorderHeight;
    if ((p_game_menuInited) && (p_em_stackPos >= 0)) {}
    for (int m = p_em_menuStack[p_em_stackPos];; m = 0)
    {
      if (m == 10) {
        j -= (gfx_getFontHeight(0) << 1) / 3;
      }
      gfx_setColor(16763955);
      if ((p_tbCurrentLine > 0) || (p_tb_scroll > 0)) {
        gfx_drawImage(11, i, j, 33, 0);
      }
      if (p_tbCurrentLine < p_tb_lineCount - 1) {
        gfx_drawImage(10, i, k, 17, 0);
      }
      return;
    }
  }
  
  public static void eg_addSelector(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10)
  {
    int i = 1;
    GuiElement localGuiElement = new GuiElement();
    localGuiElement.type = 2;
    localGuiElement.id = paramInt1;
    localGuiElement.x = paramInt7;
    localGuiElement.y = paramInt8;
    localGuiElement.w = paramInt9;
    localGuiElement.h = paramInt10;
    localGuiElement.txt = "";
    localGuiElement.eventMask = i;
    localGuiElement.pos_align = paramInt5;
    boolean bool;
    int[] arrayOfInt;
    if (!paramBoolean)
    {
      bool = i;
      localGuiElement.draggableHoriz = bool;
      localGuiElement.draggableVert = paramBoolean;
      localGuiElement.params = new int[6];
      localGuiElement.params[0] = paramInt2;
      localGuiElement.params[i] = paramInt3;
      arrayOfInt = localGuiElement.params;
      if (!paramBoolean) {
        break label180;
      }
    }
    for (;;)
    {
      arrayOfInt[2] = i;
      localGuiElement.params[3] = paramInt4;
      localGuiElement.params[4] = (paramInt4 << 10);
      p_eg_addElement(localGuiElement, paramInt6);
      localGuiElement.params = null;
      return;
      bool = false;
      break;
      label180:
      i = 0;
    }
  }
  
  public static void eg_addTextButton(int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    int i;
    if ((paramInt2 & 0x10) != 0)
    {
      i = 0x0 | 0x1;
      if ((paramInt2 & 0x20) == 0) {
        break label49;
      }
    }
    label49:
    for (int j = i | 0x2;; j = i | 0x10)
    {
      eg_addTextButton(paramInt1, paramString, paramInt2, j, paramInt3, paramInt4, paramInt5, paramInt6);
      return;
      i = 0x0 | 0x4;
      break;
    }
  }
  
  public static void eg_addTextButton(int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    eg_addTextButton(paramInt1, paramString, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, false);
  }
  
  public static void eg_addTextButton(int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, boolean paramBoolean)
  {
    GuiElement localGuiElement = new GuiElement();
    localGuiElement.type = 0;
    localGuiElement.id = paramInt1;
    localGuiElement.x = paramInt4;
    localGuiElement.y = paramInt5;
    localGuiElement.w = paramInt6;
    localGuiElement.h = paramInt7;
    localGuiElement.txt = paramString;
    localGuiElement.eventMask = 1;
    localGuiElement.pos_align = paramInt2;
    localGuiElement.params = null;
    localGuiElement.draggableHoriz = false;
    localGuiElement.draggableVert = false;
    p_eg_addElement(localGuiElement, paramInt3, paramBoolean);
  }
  
  public static void eg_allocGui(Gui paramGui)
  {
    paramGui.elementList = new GuiElement[10];
    for (int i = 0; i < 10; i++) {
      paramGui.elementList[i] = new GuiElement();
    }
    paramGui.elementAmount = 0;
  }
  
  public static void eg_bindAction(int paramInt1, int paramInt2, int paramInt3)
  {
    p_eg_keyBinds[p_eg_keyBindAmount] = new GuiKeyBind();
    GuiKeyBind localGuiKeyBind = p_eg_keyBinds[p_eg_keyBindAmount];
    p_eg_keyBindAmount = 1 + p_eg_keyBindAmount;
    localGuiKeyBind.elId = paramInt1;
    localGuiKeyBind.key = paramInt2;
    localGuiKeyBind.action = paramInt3;
  }
  
  public static boolean eg_canScrollDown()
  {
    return p_eg_guiBorderBottom + p_eg_guiScrollY > p_eg_areaY + p_eg_areaH;
  }
  
  public static boolean eg_canScrollUp()
  {
    return p_eg_guiBorderTop + p_eg_guiScrollY < p_eg_areaY;
  }
  
  public static void eg_disableHorizontalMovement(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (boolean bool = true;; bool = false)
    {
      p_eg_horizontalMovementEnabled = bool;
      return;
    }
  }
  
  public static boolean eg_elementExists(int paramInt)
  {
    return p_eg_getRealId(paramInt) != -1;
  }
  
  public static void eg_enableAutoScroll(boolean paramBoolean)
  {
    p_eg_autoScroll = paramBoolean;
  }
  
  public static void eg_enableWrapping(boolean paramBoolean)
  {
    p_eg_wrappingEnabled = paramBoolean;
  }
  
  public static int eg_eventOccured(int paramInt1, int paramInt2)
  {
    int i = p_eg_getRealId(paramInt1);
    if (p_eg_elementList[i].eventTimeList[(paramInt2 - 1)] != Integer.MIN_VALUE) {
      return smoothtime - p_eg_elementList[i].eventTimeList[(paramInt2 - 1)];
    }
    return Integer.MAX_VALUE;
  }
  
  public static void eg_freeGui(Gui paramGui)
  {
    for (int i = 0; i < 10; i++) {
      paramGui.elementList[i] = null;
    }
    paramGui.elementList = null;
  }
  
  public static int eg_getDragStartOffsetX()
  {
    if (p_eg_pointerDraggingElement != -1) {
      return p_eg_elementList[p_eg_pointerDraggingElement].drag_startOffsetX;
    }
    return Integer.MIN_VALUE;
  }
  
  public static int eg_getDragStartOffsetY()
  {
    if (p_eg_pointerDraggingElement != -1) {
      return p_eg_elementList[p_eg_pointerDraggingElement].drag_startOffsetY;
    }
    return Integer.MIN_VALUE;
  }
  
  public static GuiElement eg_getElement(int paramInt)
  {
    int i = p_eg_getElementWithId(paramInt);
    if (i >= 0) {
      return p_eg_elementList[i];
    }
    return p_eg_elementList[0];
  }
  
  public static int eg_getElementHeight(int paramInt)
  {
    int i = -1;
    int j = p_eg_getRealId(paramInt);
    if (j != i) {
      i = p_eg_elementList[j].h;
    }
    return i;
  }
  
  public static int eg_getElementType(int paramInt)
  {
    return p_eg_getElementType(paramInt);
  }
  
  public static int eg_getElementWidth(int paramInt)
  {
    int i = -1;
    int j = p_eg_getRealId(paramInt);
    if (j != i) {
      i = p_eg_elementList[j].w;
    }
    return i;
  }
  
  public static int eg_getElementX(int paramInt)
  {
    int i = -1;
    int j = p_eg_getRealId(paramInt);
    if (j != i) {
      i = p_eg_scrX(j);
    }
    return i;
  }
  
  public static int eg_getElementY(int paramInt)
  {
    int i = -1;
    int j = p_eg_getRealId(paramInt);
    if (j != i) {
      i = p_eg_scrY(j);
    }
    return i;
  }
  
  public static int eg_getFocusElementId()
  {
    if (p_eg_focusElement == -1) {
      return -1;
    }
    return p_eg_elementList[p_eg_focusElement].id;
  }
  
  public static int eg_getPreviousFocusElement()
  {
    if (p_eg_prevFocusElement == -1) {
      return -1;
    }
    return p_eg_elementList[p_eg_prevFocusElement].id;
  }
  
  public static int eg_getSelectorValue(int paramInt)
  {
    int i = p_eg_getRealId(paramInt);
    if (i != -1) {
      return p_eg_getSelectorValue(i);
    }
    return 0;
  }
  
  public static boolean eg_hasFocus(int paramInt)
  {
    if (paramInt == -1) {
      return p_eg_focusElement == -1;
    }
    int i = p_eg_getRealId(paramInt);
    if (i == -1) {
      return false;
    }
    return p_eg_focusElement == i;
  }
  
  public static void eg_hide(boolean paramBoolean)
  {
    if ((p_eg_hidden == paramBoolean) || ((p_eg_hidden) && (!paramBoolean))) {
      for (int i = 0; i < p_eg_elementAmount; i++) {
        p_eg_registerEvent(i, 6);
      }
    }
    p_eg_hidden = paramBoolean;
  }
  
  public static void eg_init(int paramInt) {}
  
  public static void eg_init(int paramInt1, int paramInt2, int paramInt3) {}
  
  public static boolean eg_isDisabled(int paramInt)
  {
    int i = p_eg_getRealId(paramInt);
    if (i >= 0) {
      return !p_eg_elementList[i].enabled;
    }
    return false;
  }
  
  public static boolean eg_isEnabled(int paramInt)
  {
    int i = p_eg_getRealId(paramInt);
    if (i != -1) {
      return p_eg_elementList[i].enabled;
    }
    return false;
  }
  
  public static void eg_listenKeyPresses(boolean paramBoolean)
  {
    p_eg_listeningKeyPresses = paramBoolean;
  }
  
  public static void eg_loadGui(Gui paramGui)
  {
    for (int i = 0; i < paramGui.elementAmount; i++) {
      p_eg_copyGuiElement(p_eg_elementList[i], paramGui.elementList[i]);
    }
    p_eg_elementAmount = paramGui.elementAmount;
  }
  
  public static void eg_lockGui(boolean paramBoolean)
  {
    p_eg_guiLocked = paramBoolean;
  }
  
  public static void eg_paint() {}
  
  public static void eg_removeBinds(int paramInt)
  {
    for (int i = 0; i < p_eg_keyBindAmount; i++) {
      if (p_eg_keyBinds[i].elId == paramInt)
      {
        p_eg_removeBind(i);
        i--;
      }
    }
  }
  
  public static void eg_removeElement(int paramInt)
  {
    int i = p_eg_getRealId(paramInt);
    if (i != -1)
    {
      eg_removeBinds(paramInt);
      p_eg_freeElement(p_eg_elementList[i]);
      p_eg_elementList[i] = null;
      for (int j = i; j < p_eg_elementAmount - 1; j++) {
        p_eg_elementList[j] = p_eg_elementList[(j + 1)];
      }
      for (int k = 0;; k++) {
        if ((k >= p_eg_elementAmount) || (p_eg_elementOrdering[k] == i)) {
          for (int m = k; m < p_eg_elementAmount - 1; m++) {
            p_eg_elementOrdering[m] = p_eg_elementOrdering[(m + 1)];
          }
        }
      }
      p_eg_elementAmount -= 1;
      for (int n = 0; n < p_eg_elementAmount; n++) {
        if (p_eg_elementOrdering[n] > i)
        {
          int[] arrayOfInt = p_eg_elementOrdering;
          arrayOfInt[n] -= 1;
        }
      }
      if (p_eg_focusElement == i) {
        p_eg_focusElement = -1;
      }
      if (p_eg_focusElement > i) {
        p_eg_focusElement -= 1;
      }
      if (p_eg_origFocusElement > i) {
        p_eg_origFocusElement -= 1;
      }
      if (p_eg_prevElementOnPointer > i) {
        p_eg_prevElementOnPointer -= 1;
      }
      if (p_eg_pointerDraggingElement > i) {
        p_eg_pointerDraggingElement -= 1;
      }
    }
  }
  
  public static void eg_reset()
  {
    for (int i = 0; i < p_eg_elementAmount; i++)
    {
      p_eg_freeElement(p_eg_elementList[i]);
      p_eg_elementList[i] = null;
    }
    p_eg_elementAmount = 0;
    p_eg_focusElement = -1;
    p_eg_prevFocusElement = -1;
    p_eg_prevElementOnPointer = -1;
    p_eg_pressingGuiSoftkey = false;
    p_eg_gameAreaFocusable = true;
    eg_hide(false);
    eg_listenKeyPresses(false);
    p_eg_resetKeypad();
    eg_setVerticalMenuMode(false);
    eg_setScrollMargin(0);
    p_eg_guiScrollDuration = 400;
    eg_enableWrapping(false);
    p_eg_pointerReportedDown = false;
    eg_enableAutoScroll(false);
    eg_resetArea();
    eg_resetScroll();
    eg_lockGui(false);
    p_eg_repeatingKey = 0;
    p_eg_numpadEvent = false;
    eg_disableHorizontalMovement(false);
    p_eg_draggingHorizontal = false;
    p_eg_draggingVertical = false;
    p_eg_guiBorderLeft = Integer.MAX_VALUE;
    p_eg_guiBorderTop = Integer.MAX_VALUE;
    p_eg_guiBorderRight = Integer.MIN_VALUE;
    p_eg_guiBorderBottom = Integer.MIN_VALUE;
  }
  
  public static void eg_resetArea()
  {
    eg_setArea(0, 0, dynamic_X_RES, dynamic_Y_RES);
  }
  
  public static void eg_resetScroll()
  {
    p_eg_guiScrollT = 0;
    p_eg_guiScrollSrcY = 0;
    p_eg_guiScrollSrcX = 0;
    p_eg_guiScrollY = 0;
    p_eg_guiScrollX = 0;
    p_eg_scrollingWithPointer = false;
  }
  
  public static void eg_saveGui(Gui paramGui)
  {
    for (int i = 0; i < p_eg_elementAmount; i++)
    {
      paramGui.elementList[i] = new GuiElement();
      p_eg_copyGuiElement(paramGui.elementList[i], p_eg_elementList[i]);
    }
    paramGui.elementAmount = p_eg_elementAmount;
  }
  
  public static void eg_scrollTo(int paramInt)
  {
    int i = p_eg_getRealId(paramInt);
    if (i != -1) {
      p_eg_scrollTo(i);
    }
  }
  
  public static void eg_setAlwaysOnTop(int paramInt, boolean paramBoolean)
  {
    eg_setElementLevel(paramInt, Integer.MAX_VALUE);
  }
  
  public static void eg_setArea(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    p_eg_areaX = paramInt1;
    p_eg_areaY = paramInt2;
    p_eg_areaW = paramInt3;
    p_eg_areaH = paramInt4;
  }
  
  public static void eg_setDraggable(int paramInt, boolean paramBoolean)
  {
    int i = p_eg_getRealId(paramInt);
    if (i != -1)
    {
      p_eg_elementList[i].draggableHoriz = paramBoolean;
      p_eg_elementList[i].draggableVert = paramBoolean;
    }
  }
  
  public static void eg_setElementDimensions(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int i = p_eg_getRealId(paramInt1);
    if (i == -1) {
      return;
    }
    p_eg_elementList[i].ax = paramInt2;
    p_eg_elementList[i].ay = paramInt3;
    p_eg_elementList[i].w = paramInt4;
    p_eg_elementList[i].h = paramInt5;
    p_eg_setAlignment(p_eg_elementList[i]);
    p_eg_recomputeBBox();
  }
  
  public static void eg_setElementLevel(int paramInt1, int paramInt2)
  {
    int i = p_eg_getRealId(paramInt1);
    if (i != -1)
    {
      p_eg_elementList[i].elementLevel = paramInt2;
      if (paramInt2 > p_eg_elementList[i].elementLevel) {
        p_eg_riseElement(i);
      }
    }
  }
  
  public static void eg_setElementStatic(int paramInt, boolean paramBoolean)
  {
    int i = p_eg_getRealId(paramInt);
    if (i != -1) {
      p_eg_elementList[i].isStatic = paramBoolean;
    }
  }
  
  public static void eg_setElementText(int paramInt, String paramString)
  {
    int i = p_eg_getRealId(paramInt);
    if (i != -1) {
      p_eg_elementList[i].txt = paramString;
    }
  }
  
  public static void eg_setEnabled(int paramInt, boolean paramBoolean)
  {
    int i = p_eg_getElementWithId(paramInt);
    if ((i >= 0) && (p_eg_elementList[i].enabled != paramBoolean))
    {
      p_eg_elementList[i].enabled = paramBoolean;
      if (!paramBoolean) {
        break label44;
      }
      p_eg_registerEvent(i, 8);
    }
    for (;;)
    {
      p_eg_recomputeBBox();
      return;
      label44:
      p_eg_registerEvent(i, 7);
    }
  }
  
  public static void eg_setFocus(int paramInt)
  {
    if (paramInt == -1) {
      p_eg_setFocus(-1);
    }
    int i = p_eg_getRealId(paramInt);
    if (i != -1) {
      p_eg_setFocus(i);
    }
  }
  
  public static void eg_setKeypadFocusable(int paramInt, boolean paramBoolean)
  {
    int i = p_eg_getRealId(paramInt);
    if (i != -1) {
      p_eg_elementList[i].keypadFocus = paramBoolean;
    }
  }
  
  public static void eg_setScrollMargin(int paramInt)
  {
    p_eg_scrollMargin = paramInt;
  }
  
  public static void eg_setSelectorValue(int paramInt1, int paramInt2)
  {
    int i = p_eg_getRealId(paramInt1);
    if (i != -1) {
      p_eg_setSelectorValue(i, paramInt2);
    }
  }
  
  public static void eg_setVerticalMenuMode(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (boolean bool = true;; bool = false)
    {
      p_eg_horizontalMovementEnabled = bool;
      p_eg_verticalMovementOnly = paramBoolean;
      return;
    }
  }
  
  public static void eg_skipPaint()
  {
    p_eg_guiPainted = true;
  }
  
  public static void egi_eventPressed(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      if ((!p_inGame) || ((!p_gameDisplay) && (p_inGame))) {
        em_selectItem(paramInt);
      }
    case 1009: 
      return;
    case 1000: 
      em_doAction(14, 1);
      return;
    case 1001: 
      em_doAction(15, 1);
      return;
    case 1002: 
      mrg_requestIngameMenu();
      return;
    case 1003: 
      em_back();
      return;
    case 1004: 
      if (p_inGame)
      {
        if (multiplayer_player == multiplayer_maxplayers) {
          multiplayer_clearState(true);
        }
        p_em_gotoGame = true;
        game_exit();
        p_tb_handleInput(-1, true);
        return;
      }
      em_popMenu();
      return;
    case 1005: 
      doj_restartGame();
      return;
    case 1006: 
      p_tb_handleInput(0, true);
      multiplayer_player = 1 + multiplayer_player;
      highscores_playerName = "";
      eg_reset();
      doj_restartGame();
      return;
    case 1008: 
      p_tb_handleInput(0, true);
      multiplayer_clearState(false);
      multiplayer_player = 0;
      multiplayer_enabled = true;
      eg_reset();
      p_em_gotoGame = true;
      doj_restartGame();
      return;
    case 1010: 
      tutorial_nextScreen();
      return;
    case 1016: 
      popup_delete();
      doj_endGame();
      return;
    case 1011: 
      em_pushMenu(7);
      return;
    case 1012: 
      em_pushMenu(8);
      return;
    case 1013: 
      highscores_uploadScores();
      return;
    case 1014: 
      highscores_viewUploadedScores();
      return;
    case 1015: 
      em_popMenu();
      return;
    }
    p_em_gotoGame = true;
    game_exit(10);
  }
  
  public static int egi_moveFocus(int paramInt1, int paramInt2, int paramInt3)
  {
    int i;
    int j;
    if ((p_game_menuInited) && (p_em_stackPos >= 0))
    {
      i = p_em_menuStack[p_em_stackPos];
      j = em_getAmountOfVisibleElements(i);
      if (paramInt2 + paramInt3 <= 0) {}
    }
    else
    {
      for (int m = 0;; m++)
      {
        if (m >= j - 1) {
          break label74;
        }
        if (paramInt1 == em_getVisibleMenuElement(i, m))
        {
          return em_getVisibleMenuElement(i, m + 1);
          i = 0;
          break;
        }
      }
      label74:
      if (paramInt1 == em_getVisibleMenuElement(i, j - 1))
      {
        if ((em_getBackKeyHint() != -1) && (i != 2)) {
          return 1003;
        }
        return em_getVisibleMenuElement(i, 0);
      }
      if (paramInt1 != 1003) {
        break label212;
      }
      return em_getVisibleMenuElement(i, 0);
    }
    if (paramInt2 + paramInt3 < 0)
    {
      for (int k = 1; k < j; k++) {
        if (paramInt1 == em_getVisibleMenuElement(i, k)) {
          return em_getVisibleMenuElement(i, k - 1);
        }
      }
      if (paramInt1 == em_getVisibleMenuElement(i, 0))
      {
        if ((em_getBackKeyHint() != -1) && (i != 2)) {
          return 1003;
        }
        return em_getVisibleMenuElement(i, j - 1);
      }
      if (paramInt1 == 1003) {
        return em_getVisibleMenuElement(i, j - 1);
      }
    }
    label212:
    return -1;
  }
  
  public static void egi_paintSelector(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    int i;
    String str;
    int k;
    if ((p_game_menuInited) && (p_em_stackPos >= 0))
    {
      i = p_em_menuStack[p_em_stackPos];
      int j;
      if ((i != 1) || (eg_getFocusElementId() != 6))
      {
        j = 0;
        if (i == 9)
        {
          int i1 = eg_getFocusElementId();
          j = 0;
          if (i1 != 1009) {}
        }
      }
      else
      {
        j = 1;
      }
      str = p_allTexts[p_indexTable2['ŷ']];
      if (paramInt1 == 1009) {
        str = txt_stringParam(p_allTexts[39], "" + (1 + multiplayer_maxplayers), 1);
      }
      if (gfx_getFontHeight(0) <= gfx_getFontHeight(0)) {
        break label253;
      }
      k = gfx_getFontHeight(0);
      label137:
      if (j == 0) {
        break label262;
      }
      gfx_setColor(52224);
      gfx_drawString(0, str, dynamic_X_RES >> 1, paramInt3 + (k >> 2), 17);
      gfx_setColor(0);
      gfx_drawRect(paramInt2 - 30, paramInt3, 30 + (paramInt4 + 30), paramInt5);
    }
    int m;
    for (;;)
    {
      m = -21 - k;
      gfx_drawImage(6, paramInt2 - 30, paramInt3 - m, 4, 0);
      for (int n = 30; n < paramInt4 + 30; n += 4) {
        gfx_drawImage(7, paramInt2 + n - 30, paramInt3 - m, 4, 0);
      }
      i = 0;
      break;
      label253:
      k = gfx_getFontHeight(0);
      break label137;
      label262:
      gfx_setColor(0);
      gfx_drawString(0, str, dynamic_X_RES >> 1, paramInt3 + (k >> 2), 17);
    }
    gfx_drawImage(8, 30 + (paramInt2 + paramInt4), paramInt3 - m, 8, 0);
    (paramInt4 - 21);
    gfx_drawImage(9, paramInt2 + paramInt6, paramInt3 - m, 3, 0);
  }
  
  public static void egi_selectorValueChanged(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 6: 
      p_indexTable2['ŵ'] = ((short)eg_getSelectorValue(paramInt));
      if (eg_getSelectorValue(paramInt) == 0)
      {
        p_options[0] = 0;
        emi_optionNotify(0);
        return;
      }
      p_options[0] = 1;
      emi_optionNotify(0);
      return;
    }
    multiplayer_maxplayers = 1 + eg_getSelectorValue(paramInt);
  }
  
  public static void egi_textButtonPaint(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString, int paramInt6, int paramInt7, boolean paramBoolean)
  {
    int m;
    int n;
    switch (paramInt1)
    {
    default: 
      if ((paramInt1 >= 1000) || (p_indexTable2[(348 + paramInt1 * 4)] != 4)) {
        break label537;
      }
      if (gfx_getFontHeight(0) > gfx_getFontHeight(0))
      {
        m = gfx_getFontHeight(0);
        n = m >> 2;
        if (!paramBoolean) {
          break label464;
        }
        gfx_setColor(52224);
        gfx_drawString(0, p_allTexts[p_indexTable2[(348 + (3 + paramInt1 * 4))]], dynamic_X_RES >> 1, paramInt3 + n, 17);
        gfx_setColor(0);
        gfx_drawRect(paramInt2, paramInt3, paramInt4, paramInt5);
      }
      break;
    }
    for (;;)
    {
      if (p_options[p_indexTable2[(348 + (1 + paramInt1 * 4))]] != 1) {
        break label503;
      }
      gfx_setColor(13421772);
      gfx_drawString(0, p_allTexts[10], dynamic_X_RES >> 1, paramInt3 + paramInt5 - n - m, 17);
      return;
      int k = gfx_getFontHeight(0);
      if (paramBoolean)
      {
        gfx_setColor(52224);
        gfx_drawString(0, paramString, dynamic_X_RES >> 1, paramInt3, 17);
        gfx_setColor(0);
        gfx_drawRect(paramInt2, paramInt3, paramInt4, paramInt5);
      }
      while (p_options[4] == 0)
      {
        gfx_setColor(13421772);
        gfx_drawString(0, p_allTexts[27], dynamic_X_RES >> 1, 2 + (k + paramInt3), 17);
        return;
        gfx_setColor(0);
        gfx_drawString(0, paramString, dynamic_X_RES >> 1, paramInt3, 17);
      }
      gfx_setColor(13421772);
      gfx_drawString(0, p_allTexts[28], dynamic_X_RES >> 1, 2 + (k + paramInt3), 17);
      return;
      String str = txt_stringParam(p_allTexts[39], "" + (1 + multiplayer_maxplayers), 1);
      if (paramBoolean)
      {
        gfx_setColor(52224);
        gfx_drawString(0, str, paramInt2, paramInt3, 20);
        gfx_setColor(0);
        gfx_drawRect(paramInt2, paramInt3, paramInt4, paramInt5);
        if (gfx_getFontHeight(0) <= gfx_getFontHeight(0)) {
          break label446;
        }
      }
      label446:
      for (int i = gfx_getFontHeight(0);; i = gfx_getFontHeight(0))
      {
        int j = i >> 2;
        menu_drawSlider(multiplayer_maxplayers - 1, 6, paramInt2, j + (paramInt3 + paramInt5), paramInt4, 16);
        return;
        gfx_setColor(0);
        gfx_drawString(0, str, paramInt2, paramInt3, 20);
        break;
      }
      m = gfx_getFontHeight(0);
      break;
      label464:
      gfx_setColor(0);
      gfx_drawString(0, p_allTexts[p_indexTable2[(348 + (3 + paramInt1 * 4))]], dynamic_X_RES >> 1, paramInt3 + n, 17);
    }
    label503:
    gfx_setColor(13421772);
    gfx_drawString(0, p_allTexts[11], dynamic_X_RES >> 1, paramInt3 + paramInt5 - n - m, 17);
    return;
    label537:
    menu_buttonPaint(paramString, paramInt2, paramInt3, paramInt4, paramInt5, paramBoolean);
  }
  
  public static void em_addElement(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = em_getElementPosition(paramInt1, paramInt3);
    int j = p_indexTable2[(paramInt1 + 337)];
    em_insertElement(paramInt1, paramInt2, p_indexTable2[(277 + (i + (j + 4)))]);
  }
  
  public static void em_back()
  {
    if (p_em_stackPos > 0)
    {
      em_popMenu();
      return;
    }
    if (!p_inGame)
    {
      em_doAction(3, 1);
      return;
    }
    p_em_gotoGame = true;
  }
  
  public static boolean em_confirm(int paramInt)
  {
    return em_confirm(paramInt, false);
  }
  
  public static boolean em_confirm(int paramInt, boolean paramBoolean)
  {
    int i = p_indexTable2[(348 + (1 + paramInt * 4))];
    if ((!p_em_confirming) && (i == 1))
    {
      p_em_confirming = true;
      p_em_confirmElement = paramInt;
      p_tb_backupConfirmHandleFlags = p_tb_inputHandleFlags;
      p_em_confirmText = txt_stringParam(p_allTexts[4], p_allTexts[p_indexTable2[(348 + (3 + paramInt * 4))]], 1);
      p_confirmationPage = 0;
      if ((p_game_menuInited) && (p_em_stackPos >= 0)) {}
      for (int j = p_em_menuStack[p_em_stackPos];; j = 0)
      {
        p_em_dispatchEvent(j, 2, paramInt);
        return false;
      }
    }
    return true;
  }
  
  public static void em_doAction(int paramInt1, int paramInt2)
  {
    int i = p_indexTable2[(348 + paramInt1 * 4)];
    int j = p_indexTable2[(348 + (1 + paramInt1 * 4))];
    if ((i == 1) && (paramInt2 == 1)) {
      em_pushMenu(j);
    }
    if ((i == 4) && (paramInt2 == 1))
    {
      p_options[j] = ((byte)(1 - p_options[j]));
      mrg_saveOptions();
      if (j == 0) {
        sfx_stopAll();
      }
      if ((j == 1) && (p_options[1] != 0)) {
        setVibra(200);
      }
      emi_optionNotify(j);
    }
    if ((i == 2) && (paramInt2 == 1) && (em_confirm(paramInt1))) {
      p_em_runkoAction(paramInt1);
    }
    if ((i == 3) && (paramInt2 == 1) && (em_confirm(paramInt1))) {
      emi_gameAction(paramInt1);
    }
  }
  
  public static void em_drawTopic()
  {
    gfx_setColor(16711680);
    gfx_drawString(1, p_allTexts[p_em_currentMenuTopic], dynamic_X_RES >> 1, dynamic_Y_RES >> 4, 17);
  }
  
  public static int em_getAmountOfVisibleElements(int paramInt)
  {
    int i = p_indexTable2[(paramInt + 337)];
    int j = p_indexTable2[(277 + (i + 0))];
    if ((j != 5) && (j != 0)) {
      return 0;
    }
    int k = 0;
    for (int m = 3; m < 3 + p_indexTable2[(277 + (i + 2))]; m++)
    {
      int n = p_indexTable2[(277 + (i + m))];
      if ((n != -1) && (p_indexTable2[(348 + (2 + n * 4))] != 2)) {
        k++;
      }
    }
    return k;
  }
  
  public static int em_getBackKeyHint()
  {
    return em_getBackKeyHint(-1);
  }
  
  public static int em_getBackKeyHint(int paramInt)
  {
    if (!p_mainGroupsLoaded) {
      return -1;
    }
    if (p_em_confirming) {
      return 3;
    }
    if (p_em_stackPos > 0) {
      return 6;
    }
    if (p_inGame) {
      return 9;
    }
    return 8;
  }
  
  public static int em_getContinueKeyHint()
  {
    return em_getContinueKeyHint(-1);
  }
  
  public static int em_getContinueKeyHint(int paramInt)
  {
    if (!p_mainGroupsLoaded) {
      return -1;
    }
    if (p_em_introMode) {
      return 58;
    }
    if (p_em_confirming) {
      return 2;
    }
    if (eg_getElementType(eg_getFocusElementId()) == 0) {
      return 5;
    }
    return -1;
  }
  
  public static int em_getCurrentMenuElementHeight()
  {
    if (p_em_currentMenuType != 0) {
      return 0;
    }
    return 0 + gfx_getFontHeight(0);
  }
  
  public static int em_getCurrentMenuHeight()
  {
    if (p_em_currentMenuType != 0) {
      return 0;
    }
    int i = (0 + gfx_getFontHeight(0)) * p_em_currentMenuLength;
    if (i > dynamic_Y_RES - 1 - (0 + gfx_getFontHeight(0)) - (4 + (dynamic_Y_RES >> 4) + (0 + gfx_getFontHeight(1)))) {
      i = dynamic_Y_RES - 1 - (0 + gfx_getFontHeight(0)) - (4 + (dynamic_Y_RES >> 4) + (0 + gfx_getFontHeight(1)));
    }
    return i;
  }
  
  public static String em_getCurrentMenuText()
  {
    return p_em_currentMenuTextboxString;
  }
  
  public static int em_getCurrentMenuWidth()
  {
    if (p_em_currentMenuType != 0) {
      return 0;
    }
    int i = p_em_currentMenuPointer;
    int j = 0;
    for (int k = 0; k < p_em_currentMenuLength; k++)
    {
      p_em_currentMenuPointer = k;
      int m = em_getSelectWidth(0);
      if (m > j) {
        j = m;
      }
    }
    p_em_currentMenuPointer = i;
    return j;
  }
  
  public static int em_getElementAmount(int paramInt)
  {
    return p_indexTable2[(277 + (2 + p_indexTable2[(paramInt + 337)]))];
  }
  
  public static int em_getElementIdAtPos(int paramInt1, int paramInt2)
  {
    int i = p_indexTable2[(paramInt1 + 337)];
    return p_indexTable2[(277 + (3 + (i + paramInt2)))];
  }
  
  public static int em_getElementPosition(int paramInt1, int paramInt2)
  {
    int i = p_indexTable2[(paramInt1 + 337)];
    for (int j = 0; j < p_indexTable2[(277 + (i + 2))]; j++) {
      if (p_indexTable2[(277 + (j + (i + 3)))] == paramInt2) {
        return j;
      }
    }
    return -1;
  }
  
  public static int em_getMenuTopic(int paramInt)
  {
    int i = p_indexTable2[(paramInt + 337)];
    return p_indexTable2[(277 + (i + 1))];
  }
  
  public static int em_getMenuType(int paramInt)
  {
    int i = p_indexTable2[(paramInt + 337)];
    return (short)(0xFFFF7FFF & p_indexTable2[(277 + (i + 0))]);
  }
  
  public static int em_getSelectWidth(int paramInt)
  {
    int i = 4 * p_em_currentMenuElements[p_em_currentMenuPointer];
    int j = p_indexTable2[(348 + (i + 1))];
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(p_allTexts[p_indexTable2[(348 + (i + 3))]]);
    String str;
    if (p_indexTable2[(i + 348)] == 4)
    {
      localStringBuffer.append(" : ");
      if (p_options[j] != 0)
      {
        str = p_allTexts[10];
        localStringBuffer.append(str);
      }
    }
    for (int k = gfx_stringWidth(paramInt, localStringBuffer.toString());; k = gfx_stringWidth(paramInt, localStringBuffer.toString()))
    {
      return k;
      str = p_allTexts[11];
      break;
    }
  }
  
  public static int em_getVisibleMenuElement(int paramInt1, int paramInt2)
  {
    int i = p_indexTable2[(paramInt1 + 337)];
    p_indexTable2[(277 + (i + 0))];
    int j = 0;
    for (int k = 3; k < 3 + p_indexTable2[(277 + (i + 2))]; k++)
    {
      int m = p_indexTable2[(277 + (i + k))];
      if ((m != -1) && (p_indexTable2[(348 + (2 + m * 4))] != 2))
      {
        if (j == paramInt2) {
          return m;
        }
        j++;
      }
    }
    return -1;
  }
  
  public static boolean em_hasElementConfirmation(int paramInt)
  {
    if ((p_indexTable2[(348 + paramInt * 4)] == 3) || (p_indexTable2[(348 + paramInt * 4)] == 2)) {
      return p_indexTable2[(348 + (1 + paramInt * 4))] == 1;
    }
    return false;
  }
  
  public static void em_insertElement(int paramInt1, int paramInt2, int paramInt3)
  {
    em_insertElementToPosition(paramInt1, paramInt2, em_getElementPosition(paramInt1, paramInt3));
  }
  
  public static void em_insertElementToPosition(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = p_indexTable2[(paramInt1 + 337)];
    for (int j = p_indexTable2[(277 + (i + 2))] - 1; j > paramInt3; j--) {
      p_indexTable2[(277 + (3 + (i + j)))] = p_indexTable2[(277 + (2 + (i + j)))];
    }
    p_indexTable2[(277 + (3 + (i + paramInt3)))] = ((short)paramInt2);
  }
  
  public static void em_invokeCustomConfirmation(String paramString)
  {
    p_em_confirming = true;
    p_em_confirmText = paramString;
    p_em_confirmElement = -1;
    if ((p_game_menuInited) && (p_em_stackPos >= 0)) {}
    for (int i = p_em_menuStack[p_em_stackPos];; i = 0)
    {
      p_em_dispatchEvent(i, 2, -1);
      return;
    }
  }
  
  public static boolean em_isCustomizationActive()
  {
    short[] arrayOfShort = p_indexTable2;
    if ((p_game_menuInited) && (p_em_stackPos >= 0)) {}
    for (int i = p_em_menuStack[p_em_stackPos];; i = 0)
    {
      int j = arrayOfShort[(i + 337)];
      if ((0x8000 & p_indexTable2[(277 + (j + 0))]) == 0) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public static void em_paintScrollArrows(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (p_lb_fillScreen) {
      return;
    }
    int i = dynamic_Y_RES - (dynamic_Y_RES - 1 - gfx_getFontHeight(0)) >> 1;
    int j = dynamic_Y_RES - i;
    int k = dynamic_X_RES >> 1;
    gfx_setColor(0);
    if (paramBoolean1) {
      p_gfx_paint.setAntiAlias(true);
    }
    gfx_fillTriangle(k - i, j - 1, k, j - i - 1, k + i, j - 1);
    p_gfx_paint.setAntiAlias(false);
    if (paramBoolean2) {
      p_gfx_paint.setAntiAlias(true);
    }
    gfx_fillTriangle(k - i, j + 1, k, 1 + (j + i), k + i, j + 1);
    p_gfx_paint.setAntiAlias(false);
    int m = k + 1;
    int n = j - 1;
    boolean bool1 = p_em_isPointerOnArrow(2);
    boolean bool2 = p_em_isPointerOnArrow(3);
    if (bool1)
    {
      gfx_setColor(16777215);
      if (paramBoolean1) {
        p_gfx_paint.setAntiAlias(true);
      }
      gfx_fillTriangle(m - i, n - 1, m, n - i - 1, m + i, n - 1);
      p_gfx_paint.setAntiAlias(false);
      if (!bool2) {
        break label270;
      }
      gfx_setColor(16777215);
    }
    for (;;)
    {
      if (paramBoolean2) {
        p_gfx_paint.setAntiAlias(true);
      }
      gfx_fillTriangle(m - i, n + 1, m, 1 + (n + i), m + i, n + 1);
      p_gfx_paint.setAntiAlias(false);
      return;
      gfx_setColor(11184810);
      break;
      label270:
      gfx_setColor(11184810);
    }
  }
  
  public static void em_paintScrollbar(int paramInt1, int paramInt2, int paramInt3)
  {
    gfx_setColor(6974058);
    int i = dynamic_Y_RES - 1 - (0 + gfx_getFontHeight(0)) - (4 + (dynamic_Y_RES >> 4) + (0 + gfx_getFontHeight(1))) - dynamic_X_RES / 24;
    int j = i * paramInt1 / paramInt3;
    int k = i * paramInt2 / paramInt3;
    if (i * paramInt2 % paramInt3 == 0) {}
    for (int m = 0;; m = 1)
    {
      int n = k + m;
      p_gfx_paint.setAntiAlias(true);
      gfx_fillEllipse(dynamic_X_RES - dynamic_X_RES / 20, j + (4 + (dynamic_Y_RES >> 4) + (0 + gfx_getFontHeight(1))), dynamic_X_RES / 24, dynamic_X_RES / 24);
      p_gfx_paint.setAntiAlias(false);
      p_gfx_paint.setAntiAlias(true);
      gfx_fillEllipse(dynamic_X_RES - dynamic_X_RES / 20, n + (j + (4 + (dynamic_Y_RES >> 4) + (0 + gfx_getFontHeight(1)))), dynamic_X_RES / 24, dynamic_X_RES / 24);
      p_gfx_paint.setAntiAlias(false);
      gfx_fillRect(dynamic_X_RES - dynamic_X_RES / 20, j + (4 + (dynamic_Y_RES >> 4) + (0 + gfx_getFontHeight(1))) + (dynamic_X_RES / 24 >> 1), dynamic_X_RES / 24, n);
      return;
    }
  }
  
  public static void em_paintSoftkeys(int paramInt1, int paramInt2)
  {
    if (p_lb_fillScreen) {
      return;
    }
    p_em_softkeysPaintedInThisFrame = true;
    int i = p_pointer_y;
    int j = dynamic_Y_RES - 1 - gfx_getFontHeight(0);
    int k = 0;
    int m = 0;
    if (i > j)
    {
      int n = p_pointer_y;
      int i1 = dynamic_Y_RES;
      k = 0;
      m = 0;
      if (n < i1)
      {
        if (p_pointer_x >= (dynamic_X_RES >> 1) - gfx_getFontHeight(0)) {
          break label186;
        }
        k = 1;
      }
    }
    for (;;)
    {
      gfx_setColor(11184810);
      if (k != 0) {
        gfx_setColor(16777215);
      }
      if (paramInt1 != -1) {
        gfx_drawString(0, p_allTexts[paramInt1], 0 + (dynamic_X_RES >> 6), dynamic_Y_RES - 1 - gfx_getFontHeight(0), 20);
      }
      gfx_setColor(11184810);
      if (m != 0) {
        gfx_setColor(16777215);
      }
      if (paramInt2 == -1) {
        break;
      }
      gfx_drawString(0, p_allTexts[paramInt2], dynamic_X_RES - (dynamic_X_RES >> 6) - 0, dynamic_Y_RES - 1 - gfx_getFontHeight(0), 24);
      return;
      label186:
      int i2 = p_pointer_x;
      int i3 = (dynamic_X_RES >> 1) + gfx_getFontHeight(0);
      k = 0;
      m = 0;
      if (i2 > i3)
      {
        m = 1;
        k = 0;
      }
    }
  }
  
  public static void em_popMenu()
  {
    if ((p_game_menuInited) && (p_em_stackPos >= 0)) {}
    for (int i = p_em_menuStack[p_em_stackPos];; i = 0)
    {
      p_em_dispatchEvent(i, 1, 0);
      p_em_stackPos -= 1;
      p_em_currentMenuPointer = p_em_pointerStack[p_em_stackPos];
      p_em_initCurrentMenu();
      return;
    }
  }
  
  public static void em_pushMenu(int paramInt)
  {
    if (p_em_stackPos >= 0) {
      if ((!p_game_menuInited) || (p_em_stackPos < 0)) {
        break label75;
      }
    }
    label75:
    for (int i = p_em_menuStack[p_em_stackPos];; i = 0)
    {
      p_em_dispatchEvent(i, 1, 0);
      p_em_stackPos = 1 + p_em_stackPos;
      p_em_menuStack[p_em_stackPos] = paramInt;
      if ((em_getMenuType(paramInt) == 0) || (em_getMenuType(paramInt) == 5)) {
        p_em_pointerStack[p_em_stackPos] = -1;
      }
      p_em_initCurrentMenu();
      return;
    }
  }
  
  public static void em_removeElement(int paramInt1, int paramInt2)
  {
    int i = em_getElementPosition(paramInt1, paramInt2);
    int j = p_indexTable2[(paramInt1 + 337)];
    int k = p_indexTable2[(277 + (j + 2))];
    for (int m = i; m < k - 1; m++) {
      p_indexTable2[(277 + (3 + (j + m)))] = p_indexTable2[(277 + (4 + (j + m)))];
    }
    p_indexTable2[(277 + (2 + (j + k)))] = -1;
  }
  
  public static void em_replaceElement(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = em_getElementPosition(paramInt1, paramInt3);
    p_indexTable2[(277 + (i + (3 + p_indexTable2[(paramInt1 + 337)])))] = ((short)paramInt2);
  }
  
  public static void em_resetStack()
  {
    p_em_stackPos = -1;
  }
  
  public static void em_selectItem(int paramInt)
  {
    em_doAction(paramInt, 1);
  }
  
  public static void em_setElementType(int paramInt1, int paramInt2, int paramInt3)
  {
    p_indexTable2[(348 + paramInt1 * 4)] = ((short)paramInt2);
    p_indexTable2[(348 + (1 + paramInt1 * 4))] = ((short)paramInt3);
  }
  
  public static void em_setSpecialIngameMenu(int paramInt)
  {
    p_em_specialIngameMenu = paramInt;
  }
  
  public static void em_setSpecialStartMenu(int paramInt)
  {
    p_em_specialStartMenu = paramInt;
  }
  
  public static void em_storeActiveElement(int paramInt)
  {
    if (p_em_stackPos >= 0) {
      p_em_pointerStack[p_em_stackPos] = paramInt;
    }
  }
  
  public static void emi_event(int paramInt1, int paramInt2, int paramInt3)
  {
    switch (paramInt2)
    {
    }
    for (;;)
    {
      return;
      mrg_resetKeys();
      em_storeActiveElement(eg_getFocusElementId());
      if (paramInt3 != 0) {}
      for (int n = 1;; n = 0)
      {
        eg_reset();
        if (((paramInt1 == 2) && (n != 0)) && (paramInt1 != 10)) {
          break;
        }
        multiplayer_clearState(true);
        return;
      }
      continue;
      p_tb_handleInput(0, true);
      mrg_resetKeys();
      eg_reset();
      dojmenu_createGui(paramInt1);
      if ((paramInt1 == 0) && (doj_initialMenu != 0))
      {
        em_pushMenu(doj_initialMenu);
        doj_initialMenu = 0;
        return;
        em_storeActiveElement(eg_getFocusElementId());
        eg_reset();
        int i = gfx_getFontHeight(0);
        int j = i + 5;
        if (j > 40) {}
        for (;;)
        {
          int k = 8 + (85 + (i << 1));
          eg_addTextButton(1000, p_allTexts[2], 17, 17, 0, k, dynamic_X_RES >> 1, j);
          int m = k + (j + 8);
          eg_addTextButton(1001, p_allTexts[3], 17, 17, 0, m, dynamic_X_RES >> 1, j);
          eg_bindAction(1001, 196616, 0);
          eg_enableAutoScroll(true);
          eg_listenKeyPresses(true);
          eg_enableWrapping(true);
          eg_setFocus(-1);
          return;
          j = 40;
        }
        if (paramInt3 != 0) {}
        for (;;)
        {
          eg_reset();
          if (menu_intro) {
            break;
          }
          dojmenu_createGui(paramInt1);
          return;
        }
      }
    }
  }
  
  public static void emi_free() {}
  
  public static void emi_gameAction(int paramInt)
  {
    if (paramInt == 1) {
      p_em_gotoGame = true;
    }
    if (paramInt == 12)
    {
      p_em_gotoGame = true;
      game_exit();
    }
    if (paramInt == 10) {
      menu_resetGame();
    }
    if (paramInt == 5) {
      p_hs_reset(0);
    }
  }
  
  public static void emi_init()
  {
    menu_softkey1 = 51;
    menu_softkey2 = -1;
    menu_intro = false;
    doj_postInit();
    if (!highscores_initialized())
    {
      highscores_savePlayerName();
      menu_resetGame();
    }
    menu_reset();
  }
  
  public static void emi_introPaint()
  {
    int i = smoothtime - intro_time;
    int j = dynamic_Y_RES - 158 - 21 - 158 >> 2;
    int k = dynamic_X_RES - 136 - 138 >> 2;
    doj_DrawGameBackground();
    if (i > 100)
    {
      int n = (158 + (158 + j * 2) + dynamic_Y_RES) / 2;
      gfx_drawImage(26, k, n, 6, 0);
      gfx_drawImage(27, dynamic_X_RES - k, n, 10, 0);
    }
    if ((i > 500) && (i < 800)) {
      gfx_drawImage(24, (k + 136) * (i - 500) / 300 - 136, 158 + j * 2, 20, 0);
    }
    if (i >= 800) {
      gfx_drawImage(24, k, 158 + j * 2, 20, 0);
    }
    if ((i > 900) && (i < 1200)) {
      gfx_drawImage(23, 138 - (k + 138) * (i - 900) / 300 + dynamic_X_RES, 158 + j * 2, 24, 0);
    }
    if (i >= 1200) {
      gfx_drawImage(23, dynamic_X_RES - k, 158 + j * 2, 24, 0);
    }
    if ((i > 1300) && (i < 1600))
    {
      int m = (j + 158) * (i - 1300) / 300 - 158;
      gfx_drawImage(25, dynamic_X_RES >> 1, m, 17, 0);
    }
    if (i >= 1600) {
      gfx_drawImage(25, dynamic_X_RES >> 1, j, 17, 0);
    }
    if (i > 2000) {
      p_mrgame.keyPressed(p_indexTable2[11] - 50);
    }
  }
  
  public static void emi_introStart()
  {
    intro_time = smoothtime;
    (dynamic_Y_RES - 158 - 21 >> 2);
    (dynamic_X_RES - 138 - 136 >> 2);
  }
  
  public static void emi_keyPressed(int paramInt1, int paramInt2)
  {
    if ((mrg_isKey(paramInt2, 196621)) && (!p_em_introMode))
    {
      if ((paramInt1 == 2) || (paramInt1 == 10)) {
        break label128;
      }
      em_back();
    }
    int j;
    for (;;)
    {
      if (mrg_isKey(paramInt2, 350))
      {
        int i = p_pointer_x;
        j = p_pointer_y;
        if (((em_getMenuType(paramInt1) != 1) && (em_getMenuType(paramInt1) != 4)) || (abs(i - (dynamic_X_RES >> 1)) > 43)) {
          break;
        }
        int i2 = p_tbBorderY;
        int i3 = p_tbBorderY + p_tbBorderHeight;
        if (abs(j - i2) <= 21) {
          p_tb_changePage(3);
        }
        if (abs(j - i3) <= 21) {
          p_tb_changePage(1);
        }
      }
      return;
      label128:
      if ((!p_gameDisplay) && (p_inGame)) {
        p_em_gotoGame = true;
      }
    }
    int k = 85;
    if (paramInt1 == 1) {
      k += gfx_getFontHeight(0);
    }
    int m = dynamic_Y_RES - 50;
    if (paramInt1 == 2) {
      m = dynamic_Y_RES - 40;
    }
    int n = 10 + gfx_getFontHeight(0);
    if (n > 40) {}
    for (;;)
    {
      int i1 = n + 8;
      if ((abs(j - k) <= 21) && (eg_canScrollUp())) {
        p_eg_guiScrollY = i1 + p_eg_guiScrollY;
      }
      if ((abs(j - m) > 21) || (!eg_canScrollDown())) {
        break;
      }
      p_eg_guiScrollY -= i1;
      return;
      n = 40;
    }
  }
  
  public static void emi_keyReleased(int paramInt1, int paramInt2)
  {
    if (mrg_isKey(paramInt2, 355))
    {
      if (paramInt1 == 7) {
        highscores_uploadScores();
      }
      if (paramInt1 == 8) {
        highscores_viewUploadedScores();
      }
    }
  }
  
  public static void emi_logic(int paramInt)
  {
    if ((!p_gameDisplay) && (p_inGame)) {
      doj_isInGameMenu = true;
    }
    if ((character_fp_posX == platforms_array[platforms_begin].fp_x) && (paramInt == 0) && (!p_em_confirming) && (!p_inGame)) {
      physics_menu();
    }
  }
  
  public static void emi_menuInitCallback(int paramInt) {}
  
  public static void emi_optionNotify(int paramInt)
  {
    if (paramInt == 5) {
      tutorial_reset();
    }
  }
  
  public static void emi_paint(int paramInt)
  {
    if (!p_mainGroupsLoaded)
    {
      gfx_setColor(0);
      gfx_fillRect(0, 0, dynamic_X_RES, dynamic_Y_RES);
    }
    do
    {
      return;
      if ((paramInt != 2) && (paramInt != 0) && (paramInt != 5) && (paramInt != 4) && (paramInt != 1) && (paramInt != 3) && (paramInt != 9) && (paramInt != 10) && (paramInt != 4) && (paramInt != 6) && (paramInt != 7) && (paramInt != 8))
      {
        gfx_setColor(0);
        gfx_fillRect(0, 0, dynamic_X_RES, dynamic_Y_RES);
        return;
      }
      gfx_setColor(16052202);
      gfx_fillRect(0, 0, dynamic_X_RES, dynamic_Y_RES);
      if (((paramInt == 0) || (paramInt == 1) || (paramInt == 9)) && (!p_em_confirming) && (!p_inGame))
      {
        gfx_drawImage(28, dynamic_X_RES - (dynamic_X_RES >> 5), dynamic_Y_RES - (dynamic_Y_RES >> 3), 40, 0);
        gfx_drawImage(29, dynamic_X_RES - (dynamic_X_RES >> 5), (dynamic_Y_RES >> 1) - (dynamic_Y_RES >> 4), 24, 0);
        gfx_drawImage(30, dynamic_X_RES >> 4, dynamic_Y_RES >> 2, 20, 0);
        gfx_drawImage(31, dynamic_X_RES >> 3, (dynamic_Y_RES >> 1) - (dynamic_Y_RES >> 3), 20, 0);
        gfx_drawImage(32, dynamic_X_RES - (dynamic_X_RES >> 4), (dynamic_Y_RES >> 1) + (dynamic_Y_RES >> 3), 24, 0);
        if (paramInt == 0)
        {
          platforms_draw();
          character_draw();
          objects_draw();
        }
      }
      if (((em_getMenuType(paramInt) == 1) || (em_getMenuType(paramInt) == 4) || (paramInt == 10) || (paramInt == 6) || (paramInt == 7) || (paramInt == 8)) && (!p_em_confirming) && (!p_inGame))
      {
        gfx_drawImage(28, dynamic_X_RES - ((dynamic_X_RES >> 4) + (dynamic_X_RES >> 5)), 0, 24, 0);
        gfx_drawImage(29, dynamic_X_RES - (dynamic_X_RES >> 5), 85, 24, 0);
        gfx_drawImage(32, dynamic_X_RES - (dynamic_X_RES >> 3), 42, 24, 0);
      }
      if ((paramInt == 0) || (paramInt == 1) || (paramInt == 3) || (paramInt == 9) || (paramInt == 10) || (paramInt == 5) || (paramInt == 4) || (paramInt == 2) || (paramInt == 6) || (paramInt == 7) || (paramInt == 8))
      {
        gfx_drawImage(14, 0, 0, 20, 0);
        if ((paramInt != 0) && (paramInt != 10))
        {
          gfx_setColor(0);
          gfx_drawString(0, p_allTexts[em_getMenuTopic(paramInt)], dynamic_X_RES - 54, 75, 24);
        }
      }
      if ((em_getMenuType(paramInt) == 1) || (em_getMenuType(paramInt) == 4) || (paramInt == 7) || (paramInt == 8) || (paramInt == 10))
      {
        gfx_setColor(0);
        tb_drawEx(p_tbFont, p_tbTextX, p_tbTextY, p_tb_scroll >> 10);
        drawTextBoxArrows();
      }
      if (p_em_confirming)
      {
        gfx_setColor(0);
        int k = gfx_getFontHeight(0);
        gfx_drawString(0, p_em_confirmText, dynamic_X_RES >> 1, 8 + (k + 85), 17);
      }
      if (paramInt == 10) {
        menu_drawMultiplayerFinal();
      }
      eg_paint();
      if (eg_canScrollUp())
      {
        int j = 85;
        if (paramInt == 1) {
          j += gfx_getFontHeight(0);
        }
        gfx_drawImage(11, dynamic_X_RES >> 1, j, 33, 0);
      }
    } while (!eg_canScrollDown());
    int i = dynamic_Y_RES - 50;
    if (paramInt == 2) {
      i = dynamic_Y_RES - 40;
    }
    gfx_drawImage(10, dynamic_X_RES >> 1, i, 17, 0);
  }
  
  public static int fp_div(int paramInt1, int paramInt2)
  {
    long l1 = paramInt1;
    long l2 = paramInt2;
    return (int)((l1 << 11) / l2);
  }
  
  public static int fp_mul(int paramInt1, int paramInt2)
  {
    return (int)(paramInt1 * paramInt2 >> 11);
  }
  
  public static void game_exit()
  {
    doj_exitGame = true;
    doj_initialMenu = 0;
  }
  
  public static void game_exit(int paramInt)
  {
    game_exit();
    doj_initialMenu = paramInt;
  }
  
  public static void game_forcedPaint()
  {
    
    if (!p_mainGroupsLoaded)
    {
      gfx_setColor(16052202);
      gfx_fillRect(0, 0, dynamic_X_RES, dynamic_Y_RES);
      int k = doj_worldToScreenY(loading_fp_posY) - (dynamic_Y_RES >> 1);
      gfx_setColor(0);
      gfx_fillRect((dynamic_X_RES >> 1) - 15 - 1, k - 1, 33, 33);
      gfx_setColor(13289493);
      gfx_fillRect((dynamic_X_RES >> 1) - 15, k, 31, 31);
      return;
    }
    doj_DrawGameBackground();
    gfx_setColor(0);
    gfx_drawString(0, p_allTexts[24], dynamic_X_RES >> 1, (dynamic_Y_RES >> 1) + (dynamic_Y_RES >> 1 >> 1), 17);
    if (loading_stepsCounter > 2000)
    {
      int j = doj_worldToScreenY(loading_fp_posY) - (dynamic_Y_RES >> 1);
      gfx_drawImage(20, -8 + (dynamic_X_RES >> 1), j, 33, 0);
    }
    int i = (dynamic_X_RES >> 1) - 28;
    gfx_drawImage(15, i, dynamic_Y_RES >> 1, 20, 0);
    gfx_drawImage(17, i + 28, dynamic_Y_RES >> 1, 20, 0);
  }
  
  public static void game_free() {}
  
  public static int game_hs_defaultextra(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public static String game_hs_defaultname(int paramInt1, int paramInt2)
  {
    return "";
  }
  
  public static int game_hs_defaultscore(int paramInt1, int paramInt2)
  {
    return -1;
  }
  
  public static void game_keyPressed(int paramInt)
  {
    if ((doj_gameOver) || (multiplayer_loadingState)) {}
    do
    {
      return;
      if (popup_active)
      {
        popup_keyPressed(paramInt);
        return;
      }
      if ((mrg_isKey(paramInt, 196616)) && (!doj_gameOver)) {
        mrg_requestIngameMenu();
      }
      if (mrg_isKey(paramInt, 131076)) {
        doj_leftKeyDown = true;
      }
      if (mrg_isKey(paramInt, 131078)) {
        doj_rightKeyDown = true;
      }
      if ((mrg_isKey(paramInt, 50)) && (!doj_gameOver)) {
        character_fire();
      }
    } while (!mrg_isKey(paramInt, 350));
    if ((p_pointer_y < 52) && (p_pointer_x > dynamic_X_RES - 44 - (dynamic_X_RES >> 4)))
    {
      mrg_requestIngameMenu();
      mrg_resetKeys();
      return;
    }
    int i = p_pointer_y;
    if (p_options[2] != 0)
    {
      character_fire();
      return;
    }
    if (i > doj_worldToScreenY(character_fp_posY))
    {
      character_fp_accX = (p_pointer_x - (dynamic_X_RES >> 1)) * doj_fp_pixelAccX;
      doj_pointerDown = true;
      return;
    }
    character_fire();
  }
  
  public static void game_keyReleased(int paramInt)
  {
    if ((doj_gameOver) || (multiplayer_loadingState)) {}
    do
    {
      return;
      if (popup_active)
      {
        popup_keyReleased(paramInt);
        return;
      }
      if (mrg_isKey(paramInt, 131076)) {
        doj_leftKeyDown = false;
      }
      if (mrg_isKey(paramInt, 131078)) {
        doj_rightKeyDown = false;
      }
    } while (!mrg_isKey(paramInt, 350));
    character_fp_accX = 0;
    doj_pointerDown = false;
  }
  
  public static void game_loadingCallback(int paramInt1, int paramInt2)
  {
    loading_update((timedelta << 11) / 1000);
    if (loading_lastLoadingTime > smoothtime) {
      loading_lastLoadingTime = smoothtime - 1000;
    }
    if (smoothtime - loading_lastLoadingTime > 100)
    {
      mrg_forcePaintNow();
      loading_lastLoadingTime = smoothtime;
      loading_stepsCounter = 100 + loading_stepsCounter;
    }
  }
  
  public static boolean game_logic()
  {
    if (doj_isInGameMenu)
    {
      doj_isInGameMenu = false;
      if (!doj_gameOver) {
        break label35;
      }
      menu_reinitializeEndGameMenu();
    }
    for (;;)
    {
      acc_x = 3 * p_acceleration_x;
      if (!doj_exitGame) {
        break;
      }
      return false;
      label35:
      doj_leftKeyDown = false;
      doj_rightKeyDown = false;
    }
    if ((doj_gameOver) || (multiplayer_loadingState))
    {
      repaintScreen = true;
      return true;
    }
    platforms_generate();
    int i = (timedelta << 11) / 1000;
    if ((tutorial_active) && (tutorial_mode == 0)) {
      tutorial_nextScreen();
    }
    if (popup_active)
    {
      repaintScreen = true;
      return true;
    }
    if (i > 204) {
      i = 204;
    }
    doj_fp_time = i + doj_fp_time;
    if (doj_fp_time < 34) {
      return true;
    }
    if ((p_pointer_dragged) && (doj_pointerDown)) {
      character_fp_accX = (p_pointer_x - (dynamic_X_RES >> 1)) * doj_fp_pixelAccX;
    }
    physics_updateControls(doj_fp_time);
    boolean bool = false;
    platforms_update(doj_fp_time);
    while ((doj_fp_time > 34) && (!bool))
    {
      physics_update(34);
      if ((0x14D00 & character_state) == 0) {
        bool = physics_updateCollisions();
      }
      character_updateState(34);
      doj_fp_time -= 34;
      if (objects_begin == objects_end) {
        doj_stopWarningSounds();
      }
    }
    platforms_generate();
    platforms_cleanup();
    repaintScreen = true;
    return true;
  }
  
  public static void game_paint()
  {
    if (p_mainGroupsLoaded)
    {
      doj_DrawGameBackground();
      if (!doj_gameOver) {
        if (multiplayer_enabled)
        {
          highscores_draw_multiplayer_markers();
          objects_drawBackground();
          platforms_draw();
          objects_draw();
          character_draw();
          projectiles_draw();
          doj_DrawHud();
          if (popup_active) {
            popup_paint();
          }
        }
      }
      label88:
      label127:
      label129:
      label132:
      for (;;)
      {
        return;
        highscores_draw_local_markers();
        break;
        if (multiplayer_enabled)
        {
          doj_drawMultiplayerGameOverScreen();
          return;
        }
        int i;
        if ((p_game_menuInited) && (p_em_stackPos >= 0))
        {
          i = p_em_menuStack[p_em_stackPos];
          if (i == 7) {
            break label127;
          }
          if ((!p_game_menuInited) || (p_em_stackPos < 0)) {
            break label129;
          }
        }
        for (int j = p_em_menuStack[p_em_stackPos];; j = 0)
        {
          if (j == 8) {
            break label132;
          }
          doj_drawGameOverScreen();
          return;
          i = 0;
          break label88;
          break;
        }
      }
    }
    gfx_setColor(0);
    gfx_fillRect(0, 0, dynamic_X_RES, dynamic_Y_RES);
  }
  
  public static void game_preinit()
  {
    doj_isInGameMenu = false;
    doj_init();
  }
  
  public static void game_resolutionChanged()
  {
    if (p_mainGroupsLoaded) {
      doj_updateScreenSizes();
    }
    repaintAll = true;
  }
  
  public static void game_showNotify()
  {
    if ((p_inGame) && ((p_gameDisplay) || (!p_inGame)) && (!doj_gameOver) && (!popup_active))
    {
      mrg_resetKeys();
      repaintAll = true;
      repaintScreen = true;
      sfx_pauseAll();
      mrg_requestIngameMenu();
    }
  }
  
  public static void game_start()
  {
    p_indexTable2['Ų'] = 2;
    p_indexTable2['Ɔ'] = 2;
    p_indexTable2['Ʀ'] = 2;
    mrg_startAccelerationSensor();
    doj_clearGameState();
    if (!multiplayer_loadingState) {
      doj_gameOver = false;
    }
    for (;;)
    {
      repaintAll = true;
      gfx_loadGroup(3);
      txt_loadGroup(3);
      sfx_loadGroup(1);
      objects_load();
      platforms_scenesLoad();
      platforms_reset();
      loading_stepsCounter = 0;
      return;
      doj_score = -1;
      doj_endGame();
      multiplayer_loadingState = false;
    }
  }
  
  public static void game_unload()
  {
    p_indexTable2['Ų'] = 0;
    p_indexTable2['Ɔ'] = 0;
    p_indexTable2['Ʀ'] = 0;
    gfx_unloadGroup(3);
    txt_unloadGroup(3);
    sfx_unloadGroup(1);
    objects_unload();
    platforms_scenesUnload();
    doj_gameOver = true;
    highscores_savePlayerName();
    mrg_stopAccelerationSensor();
    menu_reset();
    doj_fp_screenYOffset = 0;
  }
  
  public static int gfx_charArrayWidth(int paramInt1, char[] paramArrayOfChar, int paramInt2, int paramInt3)
  {
    CharSequence localCharSequence = charseq_wrapArray(paramArrayOfChar, paramInt2, paramInt3);
    int i = gfx_stringWidth(paramInt1, localCharSequence);
    if (p_cs_clean_from_pool(localCharSequence)) {
      return i;
    }
    return i;
  }
  
  public static void gfx_drawArc(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {}
  
  public static void gfx_drawEllipse(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    RectF localRectF = new RectF();
    localRectF.top = paramInt2;
    localRectF.bottom = (paramInt2 + paramInt4);
    localRectF.left = paramInt1;
    localRectF.right = (paramInt1 + paramInt3);
    p_gfx_paint.setStyle(Paint.Style.STROKE);
    p_activeGraphics.drawOval(localRectF, p_gfx_paint);
  }
  
  public static void gfx_drawHLine(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 < paramInt1)
    {
      int i = paramInt1;
      paramInt1 = paramInt3;
      paramInt3 = i;
    }
    gfx_fillRect(paramInt1, paramInt2, paramInt3 - paramInt1, 1);
  }
  
  public static void gfx_drawImage(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int i = gfx_getImageWidth(paramInt1);
    int j = gfx_getImageHeight(paramInt1);
    if ((paramInt5 == 1) || (paramInt5 == 3) || (paramInt5 == 6) || (paramInt5 == 7))
    {
      int k = i;
      i = j;
      j = k;
    }
    int m = paramInt2 - gfx_getAlignX(paramInt4, i);
    int n = paramInt3 - gfx_getAlignY(paramInt4, j);
    int i1 = p_getTransImageNum(paramInt1, paramInt5);
    if ((p_allImages[i1] != null) && (!p_allImages[i1].isRecycled())) {
      p_activeGraphics.drawBitmap(p_allImages[i1], m, n, p_gfx_paint);
    }
  }
  
  public static void gfx_drawLine(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    p_activeGraphics.drawLine(paramInt1, paramInt2, paramInt3, paramInt4, p_gfx_paint);
  }
  
  public static void gfx_drawRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    p_gfx_paint.setStyle(Paint.Style.STROKE);
    p_activeGraphics.drawRect(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4, p_gfx_paint);
  }
  
  public static void gfx_drawRoundRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    p_gfx_paint.setStyle(Paint.Style.STROKE);
    p_activeGraphics.drawRect(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4, p_gfx_paint);
  }
  
  public static void gfx_drawString(int paramInt1, CharSequence paramCharSequence, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramCharSequence == null) {
      paramCharSequence = "";
    }
    int k;
    int m;
    switch (paramInt1 & 0x7F)
    {
    default: 
      p_gfx_paint.setTextSize(22.0F);
      p_gfx_paint.setTypeface(hack_font_sm);
      p_getFont(paramInt1);
      int i = gfx_stringWidth(paramInt1, paramCharSequence);
      int j = gfx_getFontHeight(paramInt1);
      k = paramInt2 - gfx_getAlignX(paramInt4, i);
      m = paramInt3 - gfx_getAlignY(paramInt4, j);
      p_gfx_paint.setAntiAlias(true);
      p_setFont(p_activeGraphics, paramInt1 & 0x7F);
      if ((paramInt1 & 0x7F) >= 3) {
        p_bmfont_drawString(paramInt1 & 0x7F, paramCharSequence, k, m);
      }
      break;
    }
    for (;;)
    {
      p_gfx_paint.setAntiAlias(false);
      return;
      p_gfx_paint.setTextSize(28.0F);
      p_gfx_paint.setTypeface(hack_font_b1);
      break;
      p_gfx_paint.setTextSize(28.0F);
      p_gfx_paint.setTypeface(hack_font_b2);
      break;
      p_gfx_paint.setTextSize(28.0F);
      p_gfx_paint.setTypeface(hack_font_b3);
      break;
      Canvas localCanvas = p_activeGraphics;
      int n = paramCharSequence.length();
      float f1 = k;
      float f2 = m - p_gfx_paint.ascent();
      Paint localPaint = p_gfx_paint;
      localCanvas.drawText(paramCharSequence, 0, n, f1, f2, localPaint);
    }
  }
  
  public static void gfx_drawSubImage(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    int i = paramInt2 - gfx_getAlignX(paramInt4, paramInt5);
    int j = paramInt3 - gfx_getAlignY(paramInt4, paramInt6);
    if ((i < dynamic_X_RES) && (j < dynamic_Y_RES) && (i + paramInt5 >= 0) && (j + paramInt6 >= 0))
    {
      p_setSubClip(i, j, paramInt5, paramInt6);
      gfx_drawImage(paramInt1, i - paramInt7, j - paramInt8, 0, 0);
      p_resumeClip();
    }
  }
  
  public static void gfx_drawSubImage(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, short[] paramArrayOfShort)
  {
    int i = paramInt5 << 2;
    gfx_drawSubImage(paramInt4, paramInt1, paramInt2, paramInt3, paramArrayOfShort[i], paramArrayOfShort[(i + 1)], paramArrayOfShort[(i + 2)], paramArrayOfShort[(i + 3)]);
  }
  
  public static void gfx_drawThickLineAA(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    for (int i = -1; i <= 1; i++) {
      for (int j = -1; j <= 1; j++)
      {
        p_gfx_paint.setAntiAlias(true);
        gfx_drawLine(paramInt1 + i, paramInt2 + j, paramInt3 + i, paramInt4 + j);
        p_gfx_paint.setAntiAlias(false);
      }
    }
  }
  
  public static void gfx_drawTriangle(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    float[] arrayOfFloat = new float[6];
    arrayOfFloat[0] = paramInt1;
    arrayOfFloat[1] = paramInt2;
    arrayOfFloat[2] = paramInt3;
    arrayOfFloat[3] = paramInt4;
    arrayOfFloat[4] = paramInt5;
    arrayOfFloat[5] = paramInt6;
    p_gfx_paint.setStyle(Paint.Style.STROKE);
    p_activeGraphics.drawVertices(Canvas.VertexMode.TRIANGLES, 6, arrayOfFloat, 0, null, 0, null, 0, null, 0, 0, p_gfx_paint);
  }
  
  public static void gfx_drawVLine(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 < paramInt2)
    {
      int i = paramInt2;
      paramInt2 = paramInt3;
      paramInt3 = i;
    }
    gfx_fillRect(paramInt1, paramInt2, 1, paramInt3 - paramInt2);
  }
  
  public static void gfx_fillArc(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {}
  
  public static void gfx_fillAreaWithImage(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int i = p_clip_x;
    int j = p_clip_y;
    int k = p_clip_width;
    int m = p_clip_height;
    gfx_setClip(paramInt2, paramInt3, paramInt4, paramInt5);
    int n = gfx_getImageWidth(paramInt1);
    int i1 = gfx_getImageHeight(paramInt1);
    int i2 = paramInt3;
    while (i2 < paramInt3 + paramInt5)
    {
      int i3 = paramInt2;
      while (i3 < paramInt2 + paramInt4)
      {
        gfx_drawImage(paramInt1, i3, i2, 20, 0);
        i3 += n;
      }
      i2 += i1;
    }
    gfx_setClip(i, j, k, m);
  }
  
  public static void gfx_fillEllipse(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    RectF localRectF = new RectF();
    localRectF.top = paramInt2;
    localRectF.bottom = (paramInt2 + paramInt4);
    localRectF.left = paramInt1;
    localRectF.right = (paramInt1 + paramInt3);
    p_gfx_paint.setStyle(Paint.Style.FILL);
    p_activeGraphics.drawOval(localRectF, p_gfx_paint);
  }
  
  public static void gfx_fillRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    p_gfx_paint.setStyle(Paint.Style.FILL);
    p_activeGraphics.drawRect(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4, p_gfx_paint);
  }
  
  public static void gfx_fillRoundRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    p_gfx_paint.setStyle(Paint.Style.FILL);
    p_activeGraphics.drawRect(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4, p_gfx_paint);
  }
  
  public static void gfx_fillScreenWithImage(int paramInt)
  {
    int i = gfx_getImageWidth(paramInt);
    int j = gfx_getImageHeight(paramInt);
    int k = 0;
    while (k < dynamic_Y_RES)
    {
      int m = 0;
      while (m < dynamic_X_RES)
      {
        gfx_drawImage(paramInt, m, k, 20, 0);
        m += i;
      }
      k += j;
    }
  }
  
  public static void gfx_fillTriangle(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    Path localPath = new Path();
    localPath.moveTo(paramInt1, paramInt2);
    localPath.lineTo(paramInt3, paramInt4);
    localPath.lineTo(paramInt5, paramInt6);
    localPath.lineTo(paramInt1, paramInt2);
    p_gfx_paint.setStyle(Paint.Style.FILL);
    p_activeGraphics.drawPath(localPath, p_gfx_paint);
  }
  
  public static int gfx_getAlignX(int paramInt1, int paramInt2)
  {
    if ((paramInt1 & 0x1) != 0) {
      return paramInt2 >> 1;
    }
    if ((paramInt1 & 0x8) != 0) {
      return paramInt2;
    }
    return 0;
  }
  
  public static int gfx_getAlignY(int paramInt1, int paramInt2)
  {
    if ((paramInt1 & 0x2) != 0) {
      return paramInt2 >> 1;
    }
    if ((paramInt1 & 0x20) != 0) {
      return paramInt2;
    }
    return 0;
  }
  
  public static int gfx_getColor()
  {
    return p_gfx_currentColor;
  }
  
  public static int gfx_getFontHeight(int paramInt)
  {
    int i = paramInt & 0x7F;
    if (i >= 3) {
      return p_indexTable1[(4 + (i - 3))];
    }
    switch (i & 0x7F)
    {
    default: 
      p_gfx_paint.setTextSize(22.0F);
    }
    for (;;)
    {
      Typeface localTypeface = p_getFont(i);
      p_gfx_paint.setTypeface(localTypeface);
      return (int)(p_gfx_paint.descent() - p_gfx_paint.ascent());
      p_gfx_paint.setTextSize(28.0F);
      continue;
      p_gfx_paint.setTextSize(28.0F);
      continue;
      p_gfx_paint.setTextSize(28.0F);
    }
  }
  
  public static int gfx_getImageHeight(int paramInt)
  {
    int i = p_getTransImageNum(paramInt, 0);
    if (p_allImages[i] == null) {
      return 0;
    }
    return p_allImages[i].getHeight();
  }
  
  public static int gfx_getImageWidth(int paramInt)
  {
    int i = p_getTransImageNum(paramInt, 0);
    if (p_allImages[i] == null) {
      return 0;
    }
    return p_allImages[i].getWidth();
  }
  
  public static void gfx_loadGroup(int paramInt)
  {
    int i = p_indexTable2[(paramInt + 140)];
    p_p_loadGlobalPalettes();
    if (p_allImages[i] != null) {
      return;
    }
    try
    {
      data_openFile("g" + paramInt, 0L);
      while (i < p_indexTable2[(140 + (paramInt + 1))])
      {
        mrg_loading(2, i);
        i = loadImage(i);
      }
      data_closeFile();
      return;
    }
    catch (Exception localException) {}
  }
  
  public static void gfx_setClip(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    p_clip_x = paramInt1;
    p_clip_y = paramInt2;
    p_clip_width = paramInt3;
    p_clip_height = paramInt4;
    p_resumeClip();
  }
  
  public static void gfx_setColor(int paramInt)
  {
    p_gfx_currentColor = paramInt;
    p_gfx_paint.setColor(0xFF000000 | p_gfx_currentColor);
  }
  
  public static int gfx_stringWidth(int paramInt, CharSequence paramCharSequence)
  {
    if ((paramInt & 0x7F) >= 3) {
      return p_bmfont_stringWidth(paramInt & 0x7F, paramCharSequence);
    }
    Typeface localTypeface = p_getFont(paramInt);
    switch (paramInt & 0x7F)
    {
    default: 
      p_gfx_paint.setTextSize(22.0F);
      if (paramCharSequence != null) {
        if (paramCharSequence.length() <= 0) {
          break;
        }
      }
      break;
    }
    Rect localRect;
    int i;
    for (paramCharSequence = paramCharSequence.toString().replace(' ', '_');; paramCharSequence = "")
    {
      localRect = new Rect();
      p_gfx_paint.setTypeface(localTypeface);
      i = paramCharSequence.length();
      if (i > p_sw_tmparr.length) {
        p_sw_tmparr = new char[i + 16];
      }
      for (int j = 0; j < i; j++) {
        p_sw_tmparr[j] = paramCharSequence.charAt(j);
      }
      p_gfx_paint.setTextSize(28.0F);
      break;
      p_gfx_paint.setTextSize(28.0F);
      break;
      p_gfx_paint.setTextSize(28.0F);
      break;
    }
    p_gfx_paint.getTextBounds(p_sw_tmparr, 0, i, localRect);
    return localRect.width();
  }
  
  public static void gfx_unloadGroup(int paramInt)
  {
    for (int i = p_indexTable2[(paramInt + 140)]; i < p_indexTable2[(140 + (paramInt + 1))]; i++) {
      p_allImages[i] = null;
    }
  }
  
  public static int highscores_add(String paramString, int paramInt)
  {
    return hs_addScore(0, paramString, paramInt, 0, 0, "");
  }
  
  public static void highscores_draw_local_markers()
  {
    highscores_draw_markers(0, 103);
  }
  
  public static void highscores_draw_markers(int paramInt1, int paramInt2)
  {
    int i = hs_queryPlace(paramInt1, doj_score + (common_fp_configLogicScreenHeight >> 11));
    if (i == -1) {
      return;
    }
    int j = i;
    label23:
    int k;
    if (j < 10)
    {
      k = hs_data_int[j];
      if (k > 0) {
        break label47;
      }
    }
    for (;;)
    {
      j++;
      break label23;
      break;
      label47:
      int m = k << 11;
      if ((k >= doj_score + (common_fp_configLogicScreenHeight >> 11)) || (m - (doj_score << 11) <= 0)) {
        break;
      }
      int n = doj_worldToScreenY(m - doj_fp_screenYOffset);
      gfx_drawImage(paramInt2, dynamic_X_RES, n, 10, 0);
      int i1 = n - gfx_getFontHeight(0);
      gfx_setColor(0);
      gfx_drawString(0, hs_data_string[j], dynamic_X_RES, i1, 24);
    }
  }
  
  public static void highscores_draw_multiplayer_markers()
  {
    highscores_draw_markers(1, 103);
  }
  
  public static void highscores_free()
  {
    hs_unload();
    highscores_savePlayerName();
    highscores_playerName = null;
  }
  
  public static int highscores_getBestUserScore(int paramInt)
  {
    if (hs_currentTable != paramInt) {
      hs_load(paramInt);
    }
    int i = 0;
    for (int j = 0; j < 10; j++)
    {
      int k = hs_data_int[j];
      if (k > i) {
        i = k;
      }
    }
    return i;
  }
  
  public static boolean highscores_hasUserScore(int paramInt)
  {
    if (hs_currentTable != paramInt) {
      hs_load(paramInt);
    }
    for (int i = 0; i < 10; i++) {
      if (hs_data_int[i] > 0) {
        return true;
      }
    }
    return false;
  }
  
  public static void highscores_init()
  {
    hs_load(0);
    highscores_playerName = "";
    byte[] arrayOfByte = mrg_loadData("player");
    if (arrayOfByte != null) {}
    try
    {
      p_bd_byteStream = new ByteArrayInputStream(arrayOfByte);
      p_bd_dataStream = new DataInputStream(p_bd_byteStream);
      highscores_playerName = p_bd_dataStream.readUTF();
      p_bd_byteStream = null;
      p_bd_dataStream = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public static boolean highscores_initialized()
  {
    return mrg_loadData("player") != null;
  }
  
  public static int highscores_multi_add(String paramString, int paramInt)
  {
    return hs_addScore(1, paramString, paramInt, 0, 0, "");
  }
  
  public static void highscores_multi_reset()
  {
    p_hs_reset(1);
  }
  
  public static void highscores_savePlayerName()
  {
    try
    {
      p_be_byteStream = new ByteArrayOutputStream();
      p_be_dataStream = new DataOutputStream(p_be_byteStream);
      p_be_dataStream.writeUTF(highscores_playerName);
      byte[] arrayOfByte = p_be_byteStream.toByteArray();
      p_be_byteStream = null;
      p_be_dataStream = null;
      mrg_saveData("player", arrayOfByte);
      return;
    }
    catch (Exception localException) {}
  }
  
  public static void highscores_uploadScores() {}
  
  public static void highscores_viewUploadedScores() {}
  
  public static int hs_addScore(int paramInt1, String paramString1, int paramInt2, int paramInt3, int paramInt4, String paramString2)
  {
    if ((hs_currentTable != paramInt1) || (hs_data_int == null)) {
      hs_load(paramInt1);
    }
    int i = 0;
    int i1;
    int j;
    if (i < 10) {
      if (paramInt2 > hs_data_int[i])
      {
        if (paramInt4 == 0) {
          for (int i10 = 8; i10 >= i; i10--)
          {
            for (int i11 = 0; i11 < 5; i11++) {
              hs_data_int[(i10 + 1 + i11 * 10)] = hs_data_int[(i10 + i11 * 10)];
            }
            for (int i12 = 0; i12 < 2; i12++) {
              hs_data_string[(i10 + 1 + i12 * 10)] = hs_data_string[(i10 + i12 * 10)];
            }
          }
        }
        i1 = -1;
        for (int i2 = 0; i2 < 10; i2++) {
          if (hs_data_int[(i2 + 40)] == paramInt4) {
            i1 = i2;
          }
        }
        if (i1 == -1) {
          for (int i7 = 8; i7 >= i; i7--)
          {
            for (int i8 = 0; i8 < 5; i8++) {
              hs_data_int[(i7 + 1 + i8 * 10)] = hs_data_int[(i7 + i8 * 10)];
            }
            for (int i9 = 0; i9 < 2; i9++) {
              hs_data_string[(i7 + 1 + i9 * 10)] = hs_data_string[(i7 + i9 * 10)];
            }
          }
        }
        if (i1 < i) {
          j = -1;
        }
      }
    }
    for (;;)
    {
      if (j < 0)
      {
        return -1;
        if (i1 > i) {
          for (int i4 = i1 - 1; i4 >= i; i4--)
          {
            for (int i5 = 0; i5 < 5; i5++) {
              hs_data_int[(i4 + 1 + i5 * 10)] = hs_data_int[(i4 + i5 * 10)];
            }
            for (int i6 = 0; i6 < 2; i6++) {
              hs_data_string[(i4 + 1 + i6 * 10)] = hs_data_string[(i4 + i6 * 10)];
            }
          }
        }
        hs_data_int[i] = paramInt2;
        hs_data_int[(i + 10)] = i;
        hs_data_int[(i + 20)] = paramInt3;
        hs_data_int[(i + 30)] = ((int)(System.currentTimeMillis() / 1000L));
        hs_data_int[(i + 40)] = paramInt4;
        hs_data_string[i] = paramString1;
        String[] arrayOfString = hs_data_string;
        int i3 = i + 10;
        if (paramString2 == null) {}
        for (String str = "";; str = paramString2)
        {
          arrayOfString[i3] = str;
          j = i;
          break;
        }
        i++;
        break;
      }
      int k = 1;
      int m = -1;
      int n = 0;
      if (n < 10)
      {
        if ((hs_data_int[n] == m) && (hs_data_int[(n + 40)] != 0)) {
          hs_data_int[(n + 10)] = k;
        }
        for (;;)
        {
          n++;
          break;
          hs_data_int[(n + 10)] = (n + 1);
          k = n + 1;
          m = hs_data_int[n];
        }
      }
      hs_save();
      return j;
      j = -1;
    }
  }
  
  public static String hs_browserlaunch_getScoreParameters()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    for (int j = 0; j < 1; j++) {
      if (highscores_hasUserScore(j))
      {
        if (i != 0) {
          localStringBuffer.append("_");
        }
        localStringBuffer.append("s");
        localStringBuffer.append(j);
        localStringBuffer.append(highscores_getBestUserScore(j));
        i = 1;
      }
    }
    return localStringBuffer.toString();
  }
  
  public static int hs_generateSessionID()
  {
    return (int)(System.currentTimeMillis() / 1000L);
  }
  
  public static String hs_getHighscore_text(int paramInt)
  {
    if (hs_currentTable != paramInt) {
      hs_load(paramInt);
    }
    StringBuffer localStringBuffer = new StringBuffer();
    for (int i = 0; i < 10; i++)
    {
      localStringBuffer.append('\024');
      localStringBuffer.append(hs_data_int[(i + 10)]);
      localStringBuffer.append(' ');
      localStringBuffer.append(hs_data_string[i]);
      localStringBuffer.append('\025');
      localStringBuffer.append(hs_data_int[i]);
    }
    return localStringBuffer.toString();
  }
  
  public static boolean hs_load(int paramInt)
  {
    if (hs_data_int == null)
    {
      hs_data_int = new int[50];
      hs_data_string = new String[20];
    }
    hs_currentTable = paramInt;
    byte[] arrayOfByte = mrg_loadData("420" + hs_currentTable);
    if (arrayOfByte != null)
    {
      for (;;)
      {
        try
        {
          p_bd_byteStream = new ByteArrayInputStream(arrayOfByte);
          p_bd_dataStream = new DataInputStream(p_bd_byteStream);
          int i = 0;
          if (i >= hs_data_int.length) {
            continue;
          }
          hs_data_int[i] = p_bd_dataStream.readInt();
          i++;
          continue;
        }
        catch (Exception localException)
        {
          continue;
          int j = 0;
          continue;
        }
        if (j >= hs_data_string.length) {
          continue;
        }
        hs_data_string[j] = p_bd_dataStream.readUTF();
        j++;
      }
      p_bd_byteStream = null;
      p_bd_dataStream = null;
      return true;
    }
    p_hs_reset(paramInt);
    return false;
  }
  
  public static int hs_queryPlace(int paramInt1, int paramInt2)
  {
    if ((hs_currentTable != paramInt1) || (hs_data_int == null)) {
      hs_load(paramInt1);
    }
    for (int i = 0; i < 10; i++) {
      if (paramInt2 > hs_data_int[i]) {
        return i;
      }
    }
    return -1;
  }
  
  public static boolean hs_save()
  {
    if (hs_currentTable < 0) {
      return false;
    }
    for (;;)
    {
      try
      {
        p_be_byteStream = new ByteArrayOutputStream();
        p_be_dataStream = new DataOutputStream(p_be_byteStream);
        int i = 0;
        if (i >= hs_data_int.length) {
          continue;
        }
        p_be_dataStream.writeInt(hs_data_int[i]);
        i++;
        continue;
      }
      catch (Exception localException)
      {
        byte[] arrayOfByte;
        boolean bool2;
        boolean bool1 = false;
        continue;
        int j = 0;
        continue;
      }
      if (j >= hs_data_string.length) {
        continue;
      }
      p_be_dataStream.writeUTF(hs_data_string[j]);
      j++;
    }
    arrayOfByte = p_be_byteStream.toByteArray();
    p_be_byteStream = null;
    p_be_dataStream = null;
    bool2 = mrg_saveData("420" + hs_currentTable, arrayOfByte);
    bool1 = bool2;
    return bool1;
  }
  
  public static void hs_unload()
  {
    if (hs_data_int != null)
    {
      for (int i = 0; i < 20; i++) {
        hs_data_string[i] = null;
      }
      hs_data_int = null;
      hs_data_string = null;
    }
  }
  
  public static void hs_uploadScores()
  {
    String str = p_hs_browserlaunch_getUploadURL();
    if (str != null) {
      mrg_launchBrowser(str);
    }
    mrg_exitApp();
  }
  
  public static void hs_viewScores()
  {
    mrg_launchBrowser("http://www.doodle-jump.com/H_ANDLGGT540/?mb=1&cid=1");
    mrg_exitApp();
  }
  
  public static void initSinTables()
  {
    if (sinTbl != null) {
      return;
    }
    int[] arrayOfInt = new int['Ũ'];
    long l1 = 1073741824L;
    long l2 = 1073578287L;
    arrayOfInt[0] = ((int)(l1 >> 14));
    arrayOfInt[1] = ((int)(l2 >> 14));
    for (int i = 2; i < 90; i++)
    {
      long l3 = (2147156574L * l2 >> 30) - l1;
      arrayOfInt[i] = ((int)(l3 >> 14));
      l1 = l2;
      l2 = l3;
    }
    arrayOfInt[90] = 0;
    for (int j = 89; j > 0; j--) {
      arrayOfInt[(j + 90)] = (-arrayOfInt[(90 - j)]);
    }
    arrayOfInt['´'] = -65536;
    for (int k = 179; k > 0; k--) {
      arrayOfInt[(k + 180)] = arrayOfInt[(180 - k)];
    }
    sinTbl = new short['Ũ'];
    for (int m = 0; m < 360; m++) {
      sinTbl[m] = ((short)(arrayOfInt[((m + 270) % 360)] >> 2));
    }
  }
  
  public static int lerp(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt3 < 0) {
      return paramInt1;
    }
    if (paramInt3 > paramInt4) {
      return paramInt2;
    }
    return (paramInt1 * (paramInt4 - paramInt3) + paramInt2 * paramInt3) / paramInt4;
  }
  
  public static int loadImage(int paramInt)
  {
    for (;;)
    {
      int i;
      try
      {
        i = p_currentFile.readUnsignedShort();
        int j = p_currentFile.readUnsignedShort();
        int k = p_currentFile.readUnsignedByte();
        if (k != 255) {
          break label433;
        }
        m = i * 4;
        data_readToByteArray(0, 5 + m * j - 5, p_tempImage1);
        p_tempImage2 = new int[i * j];
        p_riXres = i;
        p_riYres = j;
        p_riPalIndex = k;
        p_riDestImage = p_tempImage2;
        if (k != 255) {
          break label439;
        }
        i6 = 1;
        int i10 = 0;
        if (i10 < i * j)
        {
          p_tempImage2[i10] = (0xFF000000 & p_tempImage1[(3 + i10 * 4)] << 24 | 0xFF0000 & p_tempImage1[(2 + i10 * 4)] << 16 | 0xFF00 & p_tempImage1[(1 + i10 * 4)] << 8 | 0xFF & p_tempImage1[(0 + i10 * 4)]);
          i10++;
          continue;
          if (i1 >= i * j) {
            break label457;
          }
          int i2 = 0xFF & p_tempImage1[i1];
          int i3 = p_globalPalettes[k][i2];
          if (i2 == 0) {
            break label448;
          }
          i5 = 0xFF000000 | 0xF8 & i3 << 3 | 0xFC00 & i3 << 5 | 0xF80000 & i3 << 8;
          i4 = n;
          p_tempImage2[i1] = i5;
          i1++;
          n = i4;
          continue;
        }
        Bitmap.Config localConfig;
        if (i6 != 0)
        {
          localConfig = Bitmap.Config.ARGB_8888;
          p_allImages[paramInt] = Bitmap.createBitmap(p_tempImage2, i, j, localConfig);
          (i * j);
          int i7 = 0xF & p_currentFile.readByte();
          if (i7 <= 0) {
            continue;
          }
          int i8 = 0;
          if (i8 >= i7) {
            break label423;
          }
          p_riDestImage = new int[i * j];
          int i9 = p_currentFile.readByte();
          if (!p_makeModifiedImage(i9))
          {
            p_allImages[(paramInt + 1)] = Bitmap.createBitmap(p_riDestImage, i, j, localConfig);
            p_gfx_typetable_fake[paramInt] = i9;
            paramInt++;
            p_riDestImage = null;
            i8++;
            continue;
          }
        }
        else
        {
          localConfig = Bitmap.Config.RGB_565;
          continue;
        }
        p_allImages[(paramInt + 1)] = Bitmap.createBitmap(p_riDestImage, j, i, localConfig);
        continue;
        p_gfx_typetable_fake[paramInt] = 15;
      }
      catch (Exception localException)
      {
        p_tempImage2 = null;
        return paramInt + 1;
      }
      label423:
      continue;
      label433:
      int m = i;
      continue;
      label439:
      int n = 0;
      int i1 = 0;
      continue;
      label448:
      int i4 = 1;
      int i5 = 0;
      continue;
      label457:
      int i6 = n;
    }
  }
  
  public static void loading_init()
  {
    loading_stepsCounter = 0;
    loading_lastLoadingTime = 0;
    loading_fp_posY = 0;
    loading_fp_velY = common_fp_configJumpVelY;
  }
  
  public static void loading_update(int paramInt)
  {
    loading_fp_velY += fp_mul(-common_fp_configNormalAccY, paramInt);
    if (loading_fp_velY < common_fp_configMaxFallVelY) {
      loading_fp_velY = common_fp_configMaxFallVelY;
    }
    loading_fp_posY += fp_mul(loading_fp_velY, paramInt);
    if (loading_fp_posY < 0)
    {
      loading_fp_velY = common_fp_configJumpVelY;
      loading_fp_posY = 0;
    }
  }
  
  public static void menu_addTextButton(int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int i = dynamic_X_RES >> 4;
    int j = i + gfx_stringWidth(0, paramString);
    int k;
    int m;
    if (j > 105)
    {
      k = j + (dynamic_X_RES >> 3);
      m = gfx_getFontHeight(0) + (i >> 1);
      if (m <= 40) {
        break label75;
      }
    }
    for (;;)
    {
      eg_addTextButton(paramInt1, paramString, paramInt2, paramInt3, paramInt4, paramInt5, k, m);
      return;
      j = 105;
      break;
      label75:
      m = 40;
    }
  }
  
  public static void menu_addTextButton(int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    int i = (dynamic_X_RES >> 4) + gfx_stringWidth(0, paramString);
    if (i > 105) {}
    for (;;)
    {
      eg_addTextButton(paramInt1, paramString, paramInt2, paramInt3, paramInt4, paramInt5, i, paramInt6);
      return;
      i = 105;
    }
  }
  
  public static void menu_buttonPaint(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    (paramInt4 - gfx_getFontHeight(0) >> 1);
    if (paramBoolean) {}
    for (int i = 14257788;; i = 16049353)
    {
      gfx_setColor(i);
      gfx_fillRect(paramInt1, paramInt2, paramInt3, paramInt4);
      gfx_setColor(1118481);
      gfx_drawRect(paramInt1, paramInt2, paramInt3, paramInt4);
      gfx_setColor(0);
      gfx_setColor(0);
      gfx_drawString(0, paramString, paramInt1 + (paramInt3 >> 1), paramInt2 + paramInt4 - (paramInt4 - gfx_getFontHeight(0) >> 1), 33);
      return;
    }
  }
  
  public static String menu_createHighscoreLine(int paramInt1, int paramInt2, String paramString)
  {
    String str1 = "" + paramInt1;
    String str2 = txt_stringParam(txt_stringParam(p_allTexts[43], str1, 1), paramString, 2);
    if (paramInt2 != -1) {}
    for (String str3 = txt_addThousandSeparator_s(paramInt2, p_allTexts[30]);; str3 = "\n") {
      return txt_stringParam(str2, str3, 3);
    }
  }
  
  public static void menu_createHighscoresTB(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    hs_queryPlace(0, 0);
    String str1 = "";
    for (int i = 0; i < 10; i++)
    {
      String str2 = menu_createHighscoreLine(i + 1, hs_data_int[i], hs_data_string[i]);
      str1 = str1 + str2;
    }
    p_tb_makeBordered(paramInt1, str1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, true);
    p_tb_handleInput(-1, true);
  }
  
  public static void menu_createMultiplayerScoresTB(int paramInt1, int paramInt2)
  {
    hs_queryPlace(1, 0);
    String str1 = "";
    for (int i = 0; i <= multiplayer_maxplayers; i++)
    {
      String str2 = menu_createHighscoreLine(i + 1, hs_data_int[i], hs_data_string[i]);
      str1 = str1 + str2;
    }
    p_tb_makeBordered(0, str1, paramInt1, 0 + (paramInt2 + 21), dynamic_X_RES - (paramInt1 << 1), dynamic_Y_RES - paramInt2 - paramInt1 * 2 - 21 - 21 - 0, 0, 0, 8, true);
    p_tb_handleInput(-1, true);
  }
  
  public static void menu_drawMultiplayerFinal()
  {
    int i = 85 + (8 + (dynamic_Y_RES >> 10));
    (40 + 8 << 1);
    int j = i + 96;
    String str = txt_stringParam(p_allTexts[44], hs_data_string[0], 1);
    gfx_setColor(0);
    gfx_drawString(0, str, dynamic_X_RES >> 1, j, 17);
  }
  
  public static void menu_drawSlider(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    int i = 7;
    if (paramInt6 == 16) {
      i = 0 - i;
    }
    gfx_drawImage(6, paramInt3, paramInt4 - i, paramInt6 | 0x4, 0);
    for (int j = 30; j < paramInt5 - 30; j += 4) {
      gfx_drawImage(7, paramInt3 + j, paramInt4 - i, paramInt6 | 0x4, 0);
    }
    gfx_drawImage(8, paramInt3 + paramInt5, paramInt4 - i, paramInt6 | 0x8, 0);
    gfx_drawImage(9, 10 + (paramInt3 + paramInt1 * ((paramInt5 - 21) / paramInt2)), paramInt4, paramInt6 | 0x1, 0);
  }
  
  public static void menu_keyPressed(int paramInt)
  {
    if (p_em_gotoGame) {}
    label69:
    do
    {
      return;
      if ((p_game_menuInited) && (p_em_stackPos >= 0)) {}
      for (int i = p_em_menuStack[p_em_stackPos];; i = 0)
      {
        emi_keyPressed(i, paramInt);
        if (p_em_confirming) {
          break;
        }
        if (!p_em_introMode) {
          break label69;
        }
        if ((!p_gameIntroInited) || (!mrg_isKey(paramInt, 131090))) {
          break;
        }
        p_em_exitIntro();
        return;
      }
      switch (p_em_currentMenuType)
      {
      }
    } while (!mrg_isKey(paramInt, 196621));
  }
  
  public static void menu_keyReleased(int paramInt)
  {
    int i;
    if ((p_game_menuInited) && (p_em_stackPos >= 0))
    {
      i = p_em_menuStack[p_em_stackPos];
      emi_keyReleased(i, paramInt);
      if ((mrg_isKey(paramInt, 350)) && (p_em_softkeysPaintedInThisFrame))
      {
        if (p_pointer_y <= dynamic_Y_RES - 1 - gfx_getFontHeight(0)) {
          break label193;
        }
        if (p_pointer_x >= (dynamic_X_RES >> 1) - gfx_getFontHeight(0)) {
          break label165;
        }
        p_mrgame.keyPressed(305);
        if ((p_tb_inputHandleFlags == 0) && (p_em_currentMenuType != 2))
        {
          if (p_em_isPointerOnArrow(1)) {
            p_mrgame.keyPressed(304);
          }
          if (p_em_isPointerOnArrow(0)) {
            p_mrgame.keyPressed(303);
          }
          if (p_em_isPointerOnArrow(2)) {
            p_mrgame.keyPressed(301);
          }
          if (p_em_isPointerOnArrow(3)) {
            p_mrgame.keyPressed(302);
          }
        }
      }
    }
    label165:
    label193:
    while ((p_em_confirming) || (p_em_currentMenuType != 4)) {
      for (;;)
      {
        return;
        i = 0;
        break;
        if (p_pointer_x > (dynamic_X_RES >> 1) + gfx_getFontHeight(0)) {
          p_mrgame.keyPressed(306);
        }
      }
    }
    p_mrgame.keyPressed(p_indexTable2[11] - 50);
  }
  
  public static boolean menu_logic()
  {
    if (p_em_introMode)
    {
      if ((!p_gameIntroInited) && (!p_em_confirming))
      {
        emi_introStart();
        p_gameIntroInited = true;
      }
      repaintScreen = true;
      return true;
    }
    if (p_em_gotoGame)
    {
      if ((p_game_menuInited) && (p_em_stackPos >= 0)) {}
      for (int j = p_em_menuStack[p_em_stackPos];; j = 0)
      {
        p_em_dispatchEvent(j, 1, 1);
        return false;
      }
    }
    if ((p_game_menuInited) && (p_em_stackPos >= 0)) {}
    for (int i = p_em_menuStack[p_em_stackPos];; i = 0)
    {
      emi_logic(i);
      repaintScreen = true;
      return true;
    }
  }
  
  public static void menu_paint()
  {
    p_em_softkeysPaintedInThisFrame = false;
    gfx_setClip(0, 0, dynamic_X_RES, dynamic_Y_RES);
    if (p_em_confirming)
    {
      if ((p_game_menuInited) && (p_em_stackPos >= 0)) {}
      for (int j = p_em_menuStack[p_em_stackPos];; j = 0)
      {
        emi_paint(j);
        return;
      }
    }
    if (p_em_introMode)
    {
      emi_introPaint();
      return;
    }
    if ((p_game_menuInited) && (p_em_stackPos >= 0)) {}
    for (int i = p_em_menuStack[p_em_stackPos];; i = 0)
    {
      emi_paint(i);
      return;
    }
  }
  
  public static void menu_paintSoftkeys(int paramInt1, int paramInt2)
  {
    boolean bool1 = mrg_isPointerOnSoftkey1();
    boolean bool2 = mrg_isPointerOnSoftkey2();
    if (1 != 0)
    {
      if (0 != 0)
      {
        p_menu_drawSoftKeysAtBottom(paramInt2, bool2, paramInt1, bool1);
        return;
      }
      p_menu_drawSoftKeysAtBottom(paramInt1, bool1, paramInt2, bool2);
      return;
    }
    if (0 != 0)
    {
      p_menu_drawSoftKeysAtRight(paramInt2, bool2, paramInt1, bool1);
      return;
    }
    p_menu_drawSoftKeysAtRight(paramInt1, bool1, paramInt2, bool2);
  }
  
  public static void menu_preinit()
  {
    p_em_introMode = true;
    p_em_specialStartMenu = -1;
    p_gameIntroInited = false;
    p_game_menuInited = false;
    p_em_currentMenuTopic = -1;
    p_em_specialIngameMenu = -1;
    p_em_cursorY = -1;
    p_em_confirming = false;
  }
  
  public static void menu_reinitializeEndGameMenu()
  {
    
    if (multiplayer_enabled)
    {
      eg_setFocus(p_menu_createMultiplayerEndGameMenu());
      return;
    }
    p_menu_createSingleplayerEndGameMenu();
    eg_listenKeyPresses(true);
    eg_setFocus(1005);
  }
  
  public static void menu_reset()
  {
    platforms_reset();
    platforms_pushMenuPlatform();
    character_setMenuMode();
    menu_fp_time = 0;
    objects_pushMenuObject();
    doj_fp_screenYOffset = 0;
  }
  
  public static void menu_resetGame()
  {
    p_options[5] = 1;
    p_options[4] = 1;
    p_hs_resetAll();
    multiplayer_reset();
  }
  
  public static void menu_screenSizeUpdate()
  {
    if ((p_mainGroupsLoaded) && (!p_em_confirming)) {
      if ((!p_game_menuInited) || (p_em_stackPos < 0)) {
        break label46;
      }
    }
    label46:
    for (int i = p_em_menuStack[p_em_stackPos];; i = 0)
    {
      em_storeActiveElement(eg_getFocusElementId());
      eg_reset();
      dojmenu_createGui(i);
      return;
    }
  }
  
  public static void menu_start()
  {
    if (p_em_introMode)
    {
      gfx_loadGroup(1);
      txt_loadGroup(1);
      p_options[0] = 0;
      em_confirm(7);
    }
    do
    {
      return;
      p_em_gotoGame = false;
      em_resetStack();
      if (p_inGame)
      {
        if (p_em_specialIngameMenu != -1)
        {
          em_pushMenu(p_em_specialIngameMenu);
          p_em_specialIngameMenu = -1;
        }
        for (;;)
        {
          sfx_pauseAll();
          return;
          em_pushMenu(2);
        }
      }
      gfx_loadGroup(2);
      txt_loadGroup(2);
      if ((!p_game_menuInited) && (!p_game_menuInited))
      {
        emi_init();
        p_game_menuInited = true;
      }
      em_pushMenu(0);
    } while (p_em_specialStartMenu == -1);
    em_pushMenu(p_em_specialStartMenu);
    p_em_specialStartMenu = -1;
  }
  
  public static void menu_unload()
  {
    gfx_unloadGroup(2);
    txt_unloadGroup(2);
    p_em_confirmText = null;
  }
  
  public static void mrg_drawLoadingBox()
  {
    p_lb_fillScreen = true;
    mrg_forcePaintNow();
  }
  
  public static void mrg_eraseData(String paramString)
  {
    try
    {
      boolean bool = p_mrgame.deleteFile(paramString);
      if (!bool) {}
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static void mrg_exitApp()
  {
    p_exitMrgame();
    p_mrgame.android_exitApp();
  }
  
  public static void mrg_forcePaintNow()
  {
    if (!p_paintFinished) {
      return;
    }
    repaintScreen = false;
    p_forcedPaint = true;
    p_mrgame.p_repaintScreen();
    try
    {
      do
      {
        Thread.yield();
      } while (!p_paintFinished);
      p_forcedPaint = false;
      repaintAll = true;
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public static boolean mrg_isKey(int paramInt)
  {
    if (paramInt < 65536)
    {
      if (paramInt < 450) {
        return p_keys[paramInt];
      }
    }
    else {
      for (int i = 0; i < paramInt >> 16; i++)
      {
        int j = p_indexTable2[(i + (0xFFFF & paramInt))];
        if ((j < 450) && (p_keys[j] != 0)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static boolean mrg_isKey(int paramInt1, int paramInt2)
  {
    if (paramInt2 < 65536) {
      return paramInt1 == paramInt2;
    }
    for (int i = 0; i < paramInt2 >> 16; i++) {
      if (p_indexTable2[(i + (0xFFFF & paramInt2))] == paramInt1) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean mrg_isPointerOnSoftkey1()
  {
    return (p_pointer_y > dynamic_Y_RES - 1 - gfx_getFontHeight(0)) && (p_pointer_x < (dynamic_X_RES >> 1) - (gfx_getFontHeight(0) << 1));
  }
  
  public static boolean mrg_isPointerOnSoftkey2()
  {
    return (p_pointer_y > dynamic_Y_RES - 1 - gfx_getFontHeight(0)) && (p_pointer_x > (dynamic_X_RES >> 1) + (gfx_getFontHeight(0) << 1));
  }
  
  public static boolean mrg_launchBrowser(String paramString)
  {
    try
    {
      AndroidLaunchBrowser(paramString);
      return true;
    }
    catch (Exception localException) {}
    return false;
  }
  
  /* Error */
  public static byte[] mrg_loadData(String paramString)
  {
    // Byte code:
    //   0: getstatic 609	com/realarcade/DOJ/MrGame:p_mrgame	Lcom/realarcade/DOJ/MrGame;
    //   3: aload_0
    //   4: invokevirtual 2461	com/realarcade/DOJ/MrGame:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   7: astore_2
    //   8: aload_2
    //   9: invokevirtual 2466	java/io/FileInputStream:available	()I
    //   12: istore 4
    //   14: iload 4
    //   16: newarray <illegal type>
    //   18: astore 5
    //   20: aload_2
    //   21: aload 5
    //   23: invokevirtual 2469	java/io/FileInputStream:read	([B)I
    //   26: pop
    //   27: aload_2
    //   28: invokevirtual 2470	java/io/FileInputStream:close	()V
    //   31: aload 5
    //   33: areturn
    //   34: astore_1
    //   35: aconst_null
    //   36: areturn
    //   37: astore_3
    //   38: aconst_null
    //   39: areturn
    //   40: astore 6
    //   42: aload 6
    //   44: invokevirtual 2433	java/lang/Exception:printStackTrace	()V
    //   47: aconst_null
    //   48: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	paramString	String
    //   34	1	1	localFileNotFoundException	FileNotFoundException
    //   7	21	2	localFileInputStream	java.io.FileInputStream
    //   37	1	3	localIOException	IOException
    //   12	3	4	i	int
    //   18	14	5	arrayOfByte	byte[]
    //   40	3	6	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   0	8	34	java/io/FileNotFoundException
    //   8	14	37	java/io/IOException
    //   20	31	40	java/lang/Exception
  }
  
  public static void mrg_loading(int paramInt1, int paramInt2)
  {
    long l = System.currentTimeMillis() - p_lastloadtime;
    if ((l >= 0L) && (l < 50L)) {}
    while (!mainTextLoaded) {
      return;
    }
    mrp_doTime();
    game_loadingCallback(paramInt1, paramInt2);
    repaintAll = true;
    p_lastloadtime = System.currentTimeMillis();
  }
  
  public static void mrg_requestIngameMenu()
  {
    mrg_requestIngameMenuPauseSound(true);
  }
  
  public static void mrg_requestIngameMenuPauseSound(boolean paramBoolean)
  {
    if (paramBoolean) {
      sfx_pauseAll();
    }
    p_gameDisplay = false;
    repaintAll = true;
    menu_start();
  }
  
  public static void mrg_resetKeys()
  {
    p_keyCounter = 0;
    for (int i = 0; i < 450; i++) {
      p_keys[i] = false;
    }
    p_pointer_x = -1;
    p_pointer_y = -1;
    p_pointer_lastPress_x = -1;
    p_pointer_lastPress_y = -1;
  }
  
  public static void mrg_resetTime()
  {
    frameNum = 0;
    p_timebufferlen = 0;
    timedelta = 0;
    gametime = 0;
    gametimePaused = false;
    smoothtime = (int)System.currentTimeMillis() - p_starttime;
    for (int i = 0; i < 4; i++) {
      p_timebuffer[i] = 0;
    }
    cursorBlink = true;
    p_lastCursorBlink = 0;
  }
  
  public static boolean mrg_saveData(String paramString, byte[] paramArrayOfByte)
  {
    try
    {
      FileOutputStream localFileOutputStream = p_mrgame.openFileOutput(paramString, 1);
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      localByteArrayOutputStream.write(paramArrayOfByte, 0, paramArrayOfByte.length);
      byte[] arrayOfByte = localByteArrayOutputStream.toByteArray();
      return false;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      try
      {
        localFileOutputStream.write(arrayOfByte);
        localFileOutputStream.flush();
        localFileOutputStream.close();
        return true;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      localFileNotFoundException = localFileNotFoundException;
      return false;
    }
  }
  
  public static void mrg_saveOptions()
  {
    mrg_saveData("ropt", p_options);
  }
  
  public static void mrg_startAccelerationSensor() {}
  
  public static void mrg_stopAccelerationSensor()
  {
    p_acceleration_x = 0;
    p_acceleration_y = 0;
    p_acceleration_z = 0;
  }
  
  public static void mrp_doTime()
  {
    frameNum = 1 + frameNum;
    p_lasttime = smoothtime;
    p_realtime = (int)System.currentTimeMillis() - p_starttime;
    int i = p_realtime - p_lasttime;
    for (int j = 0; j < 3; j++) {
      p_timebuffer[j] = p_timebuffer[(j + 1)];
    }
    p_timebuffer[3] = p_realtime;
    if (p_timebufferlen < 4) {
      p_timebufferlen = 1 + p_timebufferlen;
    }
    if (p_timebufferlen > 1)
    {
      p_mspf = (p_realtime - p_timebuffer[(4 - p_timebufferlen)]) / (p_timebufferlen - 1);
      timedelta = smoothtime;
      smoothtime += p_mspf;
      smoothtime += (p_realtime - smoothtime >> 2);
      timedelta = smoothtime - timedelta;
      if ((i < 64536) || (i > 1000)) {
        timedelta = 10;
      }
      if (timedelta < 0) {
        timedelta = 0;
      }
      if ((p_gameDisplay) && (!gametimePaused)) {
        gametime += timedelta;
      }
      if (smoothtime - p_lastCursorBlink > 300) {
        if (cursorBlink) {
          break label242;
        }
      }
    }
    label242:
    for (boolean bool = true;; bool = false)
    {
      cursorBlink = bool;
      p_lastCursorBlink = smoothtime;
      return;
      p_mspf = 0;
      break;
    }
  }
  
  public static void mrp_initTime()
  {
    p_starttime = (int)System.currentTimeMillis();
    smoothtime = 0;
    p_realtime = 0;
    p_lasttime = 0;
    mrg_resetTime();
  }
  
  public static String mrp_textinput(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    mTextCaption = paramString1;
    mDefaultText = paramString2;
    mOkText = p_allTexts[paramInt1];
    mTextMaxLength = paramInt2;
    mDo_textinput = true;
    p_inputtingText = true;
    p_mrgame.runOnUiThread(mEditorCallback);
    while (mDo_textinput) {}
    p_inputtingText = false;
    p_mrgame.runOnUiThread(mEditorCallback);
    return mEditText.getText().toString();
  }
  
  public static void multiplayer_clearState(boolean paramBoolean)
  {
    if (multiplayer_maxplayers == multiplayer_player) {}
    try
    {
      p_be_byteStream = new ByteArrayOutputStream();
      p_be_dataStream = new DataOutputStream(p_be_byteStream);
      p_be_dataStream.writeInt(-1);
      p_be_dataStream.writeInt(-1);
      byte[] arrayOfByte = p_be_byteStream.toByteArray();
      p_be_byteStream = null;
      p_be_dataStream = null;
      mrg_saveData("multi", arrayOfByte);
      highscores_multi_reset();
      multiplayer_player = -1;
      if (paramBoolean)
      {
        multiplayer_player1 = "";
        multiplayer_player2 = "";
        multiplayer_player3 = "";
        multiplayer_player4 = "";
        multiplayer_player5 = "";
        multiplayer_player6 = "";
        multiplayer_player7 = "";
        multiplayer_player8 = "";
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public static String multiplayer_getCurrentPlayerName()
  {
    switch (multiplayer_player)
    {
    default: 
      return "";
    case 0: 
      return multiplayer_player1;
    case 1: 
      return multiplayer_player2;
    case 2: 
      return multiplayer_player3;
    case 3: 
      return multiplayer_player4;
    case 4: 
      return multiplayer_player5;
    case 5: 
      return multiplayer_player6;
    case 6: 
      return multiplayer_player7;
    }
    return multiplayer_player8;
  }
  
  public static void multiplayer_init()
  {
    multiplayer_enabled = false;
    multiplayer_loadingState = false;
    multiplayer_maxplayers = 1;
    multiplayer_player = -1;
    multiplayer_player1 = "";
    multiplayer_player2 = "";
    multiplayer_player3 = "";
    multiplayer_player4 = "";
    multiplayer_player5 = "";
    multiplayer_player6 = "";
    multiplayer_player7 = "";
    multiplayer_player8 = "";
  }
  
  public static void multiplayer_loadState()
  {
    int i = -1;
    int j = -1;
    byte[] arrayOfByte = mrg_loadData("multi");
    if (arrayOfByte != null) {}
    try
    {
      p_bd_byteStream = new ByteArrayInputStream(arrayOfByte);
      p_bd_dataStream = new DataInputStream(p_bd_byteStream);
      i = p_bd_dataStream.readInt();
      j = p_bd_dataStream.readInt();
      if ((i != -1) && (j != -1))
      {
        multiplayer_player1 = p_bd_dataStream.readUTF();
        multiplayer_player2 = p_bd_dataStream.readUTF();
        multiplayer_player3 = p_bd_dataStream.readUTF();
        multiplayer_player4 = p_bd_dataStream.readUTF();
        multiplayer_player5 = p_bd_dataStream.readUTF();
        multiplayer_player6 = p_bd_dataStream.readUTF();
        multiplayer_player7 = p_bd_dataStream.readUTF();
        multiplayer_player8 = p_bd_dataStream.readUTF();
      }
      p_bd_byteStream = null;
      p_bd_dataStream = null;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    if ((i == -1) && (j == -1))
    {
      hs_load(1);
      multiplayer_player = 0;
      multiplayer_loadingState = false;
      return;
    }
    multiplayer_player = j;
    multiplayer_maxplayers = i;
    hs_load(1);
    multiplayer_loadingState = true;
  }
  
  public static void multiplayer_reset()
  {
    multiplayer_player = multiplayer_maxplayers;
    multiplayer_clearState(true);
  }
  
  public static void multiplayer_saveState()
  {
    try
    {
      p_be_byteStream = new ByteArrayOutputStream();
      p_be_dataStream = new DataOutputStream(p_be_byteStream);
      p_be_dataStream.writeInt(multiplayer_maxplayers);
      p_be_dataStream.writeInt(multiplayer_player);
      p_be_dataStream.writeUTF(multiplayer_player1);
      p_be_dataStream.writeUTF(multiplayer_player2);
      p_be_dataStream.writeUTF(multiplayer_player3);
      p_be_dataStream.writeUTF(multiplayer_player4);
      p_be_dataStream.writeUTF(multiplayer_player5);
      p_be_dataStream.writeUTF(multiplayer_player6);
      p_be_dataStream.writeUTF(multiplayer_player7);
      p_be_dataStream.writeUTF(multiplayer_player8);
      byte[] arrayOfByte = p_be_byteStream.toByteArray();
      p_be_byteStream = null;
      p_be_dataStream = null;
      mrg_saveData("multi", arrayOfByte);
      return;
    }
    catch (Exception localException) {}
  }
  
  public static void multiplayer_setCurrentPlayerName(String paramString)
  {
    switch (multiplayer_player)
    {
    default: 
      return;
    case 0: 
      multiplayer_player1 = paramString;
      return;
    case 1: 
      multiplayer_player2 = paramString;
      return;
    case 2: 
      multiplayer_player3 = paramString;
      return;
    case 3: 
      multiplayer_player4 = paramString;
      return;
    case 4: 
      multiplayer_player5 = paramString;
      return;
    case 5: 
      multiplayer_player6 = paramString;
      return;
    case 6: 
      multiplayer_player7 = paramString;
      return;
    }
    multiplayer_player8 = paramString;
  }
  
  public static int nlerp(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (paramInt3 < 0) {
      return paramInt1;
    }
    if (paramInt3 > paramInt4) {
      return paramInt2;
    }
    int i = -paramInt5 << 16;
    int j = (i - 65536) / paramInt4;
    int k = 131072 - i;
    return (paramInt1 * (paramInt4 - (paramInt3 * (k + j * paramInt3) >> 16)) + paramInt2 * (paramInt3 * (k + j * paramInt3) >> 16)) / paramInt4;
  }
  
  public static void objects_draw()
  {
    int i = objects_begin;
    if (i < 10 + objects_end)
    {
      if (objects_begin < objects_end)
      {
        j = i;
        if (j != objects_end) {
          break label52;
        }
      }
    }
    else {
      return;
    }
    if (i < 10) {}
    for (int j = i;; j = i - 10) {
      break;
    }
    label52:
    switch (objects_array[j].id)
    {
    }
    for (;;)
    {
      i++;
      break;
      if (objects_array[j].fp_rangeX > 0)
      {
        gfx_drawImage(19, doj_worldToScreenX(objects_array[j].fp_x), doj_worldToScreenY(objects_array[j].fp_y - doj_fp_screenYOffset), 3, 0);
      }
      else
      {
        gfx_drawImage(19, doj_worldToScreenX(objects_array[j].fp_x), doj_worldToScreenY(objects_array[j].fp_y - doj_fp_screenYOffset), 3, 4);
        continue;
        gfx_drawImage(97, doj_worldToScreenX(objects_array[j].fp_x), doj_worldToScreenY(objects_array[j].fp_y - doj_fp_screenYOffset), 3, 0);
        continue;
        gfx_drawImage(98, doj_worldToScreenX(objects_array[j].fp_x), doj_worldToScreenY(objects_array[j].fp_y - doj_fp_screenYOffset), 3, 0);
        continue;
        gfx_drawImage(99, doj_worldToScreenX(objects_array[j].fp_x), doj_worldToScreenY(objects_array[j].fp_y - doj_fp_screenYOffset), 3, 0);
        continue;
        gfx_drawImage(99, doj_worldToScreenX(objects_array[j].fp_x), doj_worldToScreenY(objects_array[j].fp_y - doj_fp_screenYOffset), 3, 0);
        continue;
        gfx_drawImage(100, doj_worldToScreenX(objects_array[j].fp_x), doj_worldToScreenY(objects_array[j].fp_y - doj_fp_screenYOffset), 3, 0);
        continue;
        gfx_drawImage(101, doj_worldToScreenX(objects_array[j].fp_x), doj_worldToScreenY(objects_array[j].fp_y - doj_fp_screenYOffset), 3, 0);
        continue;
        if (rand() % 3 == 1) {
          gfx_drawImage(22, doj_worldToScreenX(objects_array[j].fp_x), doj_worldToScreenY(objects_array[j].fp_y - doj_fp_screenYOffset) - 46, 3, 0);
        } else {
          gfx_drawImage(21, doj_worldToScreenX(objects_array[j].fp_x), doj_worldToScreenY(objects_array[j].fp_y - doj_fp_screenYOffset), 3, 0);
        }
      }
    }
  }
  
  public static void objects_drawBackground()
  {
    int i = objects_begin;
    if (i < 10 + objects_end)
    {
      if (objects_begin < objects_end)
      {
        j = i;
        if (j != objects_end) {
          break label52;
        }
      }
    }
    else {
      return;
    }
    if (i < 10) {}
    for (int j = i;; j = i - 10) {
      break;
    }
    label52:
    switch (objects_array[j].id)
    {
    }
    for (;;)
    {
      i++;
      break;
      gfx_drawImage(18, doj_worldToScreenX(objects_array[j].fp_x), doj_worldToScreenY(objects_array[j].fp_y - doj_fp_screenYOffset), 3, 0);
    }
  }
  
  public static void objects_free()
  {
    for (int i = 0; i < 10; i++) {
      objects_array[i] = null;
    }
    objects_array = null;
  }
  
  public static void objects_init()
  {
    objects_array = new GameObject[10];
    for (int i = 0; i < 10; i++) {
      objects_array[i] = new GameObject();
    }
    objects_reset();
    objects_maxHeight = 126;
  }
  
  public static void objects_load() {}
  
  public static void objects_push(int paramInt1, int paramInt2, int paramInt3)
  {
    objects_array[objects_end].fp_x = paramInt1;
    objects_array[objects_end].fp_y = paramInt2;
    objects_array[objects_end].id = paramInt3;
    objects_array[objects_end].fp_velY = 0;
    objects_array[objects_end].fp_rangeX = 0;
    objects_array[objects_end].fp_rangeY = 0;
    objects_array[objects_end].fp_offsetX = 0;
    objects_array[objects_end].fp_offsetY = 0;
    objects_array[objects_end].fp_timeUpdate = 0;
    for (objects_end = 1 + objects_end; objects_end >= 10; objects_end -= 10) {}
  }
  
  public static void objects_pushMenuObject()
  {
    objects_reset();
    objects_push(532480, 778240, 6);
  }
  
  public static void objects_reset()
  {
    objects_begin = 0;
    objects_end = 0;
    objects_collidedIndex = 0;
    objects_holdOnIndex = -1;
  }
  
  public static void objects_unload() {}
  
  public static void objects_update(int paramInt)
  {
    int i = fp_div(objects_maxHeight << 11, common_fp_yRatio) >> 1;
    int j = objects_begin;
    if (j < 10 + objects_end)
    {
      if (objects_begin < objects_end)
      {
        k = j;
        if (k != objects_end) {
          break label67;
        }
      }
    }
    else {
      return;
    }
    if (j < 10) {}
    for (int k = j;; k = j - 10) {
      break;
    }
    label67:
    if ((objects_array[k].fp_y - doj_fp_screenYOffset < -i) && (objects_array[k].id != 20))
    {
      objects_array[k].id = 20;
      doj_stopWarningSounds();
    }
    for (;;)
    {
      j++;
      break;
      if ((objects_array[k].id != 20) && (k != objects_holdOnIndex)) {
        if (objects_array[k].fp_velY != 0)
        {
          GameObject localGameObject16 = objects_array[k];
          localGameObject16.fp_y += fp_mul(objects_array[k].fp_velY, paramInt);
        }
        else if ((objects_array[k].id == 10) || (objects_array[k].id == 11) || (objects_array[k].id == 22) || (objects_array[k].id == 21) || (objects_array[k].id == 8) || (objects_array[k].id == 7))
        {
          int m = 10 * sinTbl[(objects_array[k].fp_rangeX >> 11)] >> 3;
          GameObject localGameObject1 = objects_array[k];
          localGameObject1.fp_x += m - objects_array[k].fp_offsetX;
          objects_array[k].fp_offsetX = m;
          GameObject localGameObject2 = objects_array[k];
          GameObject localGameObject7;
          for (localGameObject2.fp_rangeX = (28672 + localGameObject2.fp_rangeX); objects_array[k].fp_rangeX >= 737280; localGameObject7.fp_rangeX -= 737280) {
            localGameObject7 = objects_array[k];
          }
          int n = 5 * sinTbl[(objects_array[k].fp_rangeY >> 11)] >> 3;
          GameObject localGameObject3 = objects_array[k];
          localGameObject3.fp_y += n - objects_array[k].fp_offsetY;
          objects_array[k].fp_offsetY = n;
          GameObject localGameObject4 = objects_array[k];
          GameObject localGameObject6;
          for (localGameObject4.fp_rangeY = (5734 + localGameObject4.fp_rangeY); objects_array[k].fp_rangeY >= 737280; localGameObject6.fp_rangeY -= 737280) {
            localGameObject6 = objects_array[k];
          }
          if (objects_array[k].id == 22)
          {
            GameObject localGameObject5 = objects_array[k];
            localGameObject5.fp_timeUpdate = (paramInt + localGameObject5.fp_timeUpdate);
            if (objects_array[k].fp_timeUpdate > 192) {
              objects_array[k].id = 21;
            }
          }
        }
        else
        {
          if (objects_array[k].id == 9)
          {
            if (objects_array[k].fp_rangeX == 0) {
              objects_array[k].fp_rangeX = 245760;
            }
            int i5 = fp_mul(paramInt, objects_array[k].fp_rangeX);
            GameObject localGameObject12 = objects_array[k];
            localGameObject12.fp_x = (i5 + localGameObject12.fp_x);
            int i6 = fp_mul(75776, common_fp_xRatio) >> 1;
            if (i6 + objects_array[k].fp_x > common_fp_configLogicScreenWidth)
            {
              objects_array[k].fp_x = (common_fp_configLogicScreenWidth - i6);
              objects_array[k].fp_rangeX = -245760;
            }
            for (;;)
            {
              int i7 = 10 * sinTbl[(objects_array[k].fp_rangeY >> 11)] >> 3;
              GameObject localGameObject13 = objects_array[k];
              localGameObject13.fp_y += i7 - objects_array[k].fp_offsetY;
              objects_array[k].fp_offsetY = i7;
              GameObject localGameObject14 = objects_array[k];
              GameObject localGameObject15;
              for (localGameObject14.fp_rangeY = (17408 + localGameObject14.fp_rangeY); objects_array[k].fp_rangeY >= 737280; localGameObject15.fp_rangeY -= 737280) {
                localGameObject15 = objects_array[k];
              }
              break;
              if (objects_array[k].fp_x - i6 < 0)
              {
                objects_array[k].fp_x = i6;
                objects_array[k].fp_rangeX = 245760;
              }
            }
          }
          if (objects_array[k].id == 6)
          {
            int i1 = 360 * fp_div(fp_mul(objects_array[k].fp_rangeX, 40), 12868);
            int i2 = 20 * (sinTbl[(i1 >> 11)] >> 3);
            GameObject localGameObject8 = objects_array[k];
            localGameObject8.fp_x += i2 - objects_array[k].fp_offsetX;
            objects_array[k].fp_offsetX = i2;
            GameObject localGameObject9 = objects_array[k];
            localGameObject9.fp_rangeX = (2048 + localGameObject9.fp_rangeX);
            if (objects_array[k].fp_rangeX >= 645120) {
              objects_array[k].fp_rangeX = 0;
            }
            int i3 = 360 * fp_div(fp_mul(objects_array[k].fp_rangeY, 81), 12868);
            int i4 = 10 * (sinTbl[(i3 >> 11)] >> 3);
            GameObject localGameObject10 = objects_array[k];
            localGameObject10.fp_y += i4 - objects_array[k].fp_offsetY;
            objects_array[k].fp_offsetY = i4;
            GameObject localGameObject11 = objects_array[k];
            localGameObject11.fp_rangeY = (2048 + localGameObject11.fp_rangeY);
            if (objects_array[k].fp_rangeY >= 323584) {
              objects_array[k].fp_rangeY = 0;
            }
          }
        }
      }
    }
  }
  
  public static int p_bmfont_characterIndex_slow(int paramInt, char paramChar)
  {
    for (int i = 0; i < p_indexTable1[(3 + (paramInt + 1 - 3))] - p_indexTable1[(3 + (paramInt - 3))]; i++) {
      if (p_indexTable1[(4 + (i + p_indexTable1[(3 + (paramInt - 3))]))] == paramChar) {
        return i;
      }
    }
    return 0;
  }
  
  public static void p_bmfont_drawString(int paramInt1, CharSequence paramCharSequence, int paramInt2, int paramInt3)
  {
    for (int i = 0; i < paramCharSequence.length(); i++)
    {
      int j = p_bmfont_characterIndex_slow(paramInt1, paramCharSequence.charAt(i));
      int k = p_indexTable1[(28 + (j + p_indexTable1[(27 + (paramInt1 - 3))]))];
      if (k > 0) {
        gfx_drawImage(k - 1, paramInt2 + p_indexTable1[(2 + (j + p_indexTable1[(1 + (paramInt1 - 3))]))], paramInt3 + p_indexTable1[(3 + (j + p_indexTable1[(2 + (paramInt1 - 3))]))], 20, 0);
      }
      paramInt2 += p_indexTable1[(1 + (j + p_indexTable1[(0 + (paramInt1 - 3))]))];
    }
  }
  
  public static void p_bmfont_free() {}
  
  public static void p_bmfont_init() {}
  
  public static int p_bmfont_stringWidth(int paramInt, CharSequence paramCharSequence)
  {
    int i = 0;
    for (int j = 0; j < paramCharSequence.length(); j++)
    {
      int k = p_bmfont_characterIndex_slow(paramInt, paramCharSequence.charAt(j));
      i += p_indexTable1[(1 + (k + p_indexTable1[(0 + (paramInt - 3))]))];
    }
    return i;
  }
  
  public static void p_cal_fmt(int paramInt1, int paramInt2, int paramInt3)
  {
    String str = "" + paramInt2;
    p_cal_tmpstr = txt_stringParam(p_cal_tmpstr, str, paramInt1);
  }
  
  public static void p_cal_setTime(int paramInt)
  {
    p_cal_day = 730 + (718812 + paramInt / 86400) - 28 - 31;
    p_cal_secs = paramInt % 86400;
    p_cal_year = (3 + 4 * p_cal_day) / 1461;
    p_cal_day -= 1461 * p_cal_year / 4;
    p_cal_month = (2 + 5 * p_cal_day) / 153;
    p_cal_day += 1 - (2 + 153 * p_cal_month) / 5;
    int i = p_cal_month / 10;
    p_cal_month += 3 - i * 12;
    p_cal_year = i + p_cal_year;
  }
  
  public static boolean p_cs_clean_from_pool(Object paramObject)
  {
    for (int i = 0; i < 16; i++) {
      if (p_charseq_pool[i] == paramObject)
      {
        p_charseq_pool[i].arr = null;
        return true;
      }
    }
    return false;
  }
  
  public static void p_doj_drawScoreWithLabel(String paramString, int paramInt1, int paramInt2)
  {
    String str = " " + paramInt1;
    int i = gfx_stringWidth(0, paramString);
    int j = gfx_stringWidth(0, str);
    int k = (dynamic_X_RES >> 1) - (i + j) / 2;
    gfx_setColor(0);
    gfx_drawString(0, paramString, k, paramInt2, 20);
    gfx_drawString(0, str, k + i, paramInt2, 20);
  }
  
  public static void p_eg_addElement(GuiElement paramGuiElement)
  {
    p_eg_addElement(paramGuiElement, 20);
  }
  
  public static void p_eg_addElement(GuiElement paramGuiElement, int paramInt)
  {
    p_eg_addElement(paramGuiElement, paramInt, false);
  }
  
  public static void p_eg_addElement(GuiElement paramGuiElement, int paramInt, boolean paramBoolean)
  {
    paramGuiElement.ax = paramGuiElement.x;
    paramGuiElement.ay = paramGuiElement.y;
    paramGuiElement.align = paramInt;
    p_eg_setAlignment(paramGuiElement);
    p_eg_elementList[p_eg_elementAmount] = new GuiElement();
    p_eg_elementList[p_eg_elementAmount].eventTimeList = new int[12];
    for (int i = 0; i < 12; i++) {
      p_eg_elementList[p_eg_elementAmount].eventTimeList[i] = Integer.MIN_VALUE;
    }
    p_eg_copyGuiElement(p_eg_elementList[p_eg_elementAmount], paramGuiElement);
    p_eg_elementList[p_eg_elementAmount].eg_id = p_eg_elementAmount;
    p_eg_elementList[p_eg_elementAmount].event = -1;
    p_eg_elementList[p_eg_elementAmount].enabled = true;
    p_eg_elementList[p_eg_elementAmount].keypadFocus = true;
    p_eg_elementList[p_eg_elementAmount].visible = true;
    p_eg_elementList[p_eg_elementAmount].elementLevel = 0;
    p_eg_elementList[p_eg_elementAmount].isDragging = false;
    for (int j = p_eg_elementAmount - 1; j >= 0; j--) {
      p_eg_elementOrdering[(j + 1)] = p_eg_elementOrdering[j];
    }
    p_eg_elementOrdering[0] = p_eg_elementAmount;
    p_eg_elementList[p_eg_elementAmount].isStatic = paramBoolean;
    if (!paramBoolean)
    {
      int k = p_eg_scrXWithoutScroll(p_eg_elementAmount);
      int m = p_eg_scrYWithoutScroll(p_eg_elementAmount);
      int n = k + paramGuiElement.w;
      int i1 = m + paramGuiElement.h;
      if (k < p_eg_guiBorderLeft) {
        p_eg_guiBorderLeft = k;
      }
      if (m < p_eg_guiBorderTop) {
        p_eg_guiBorderTop = m;
      }
      if (n > p_eg_guiBorderRight) {
        p_eg_guiBorderRight = n;
      }
      if (i1 > p_eg_guiBorderBottom) {
        p_eg_guiBorderBottom = i1;
      }
    }
    p_eg_elementAmount = 1 + p_eg_elementAmount;
    p_eg_registerEvent(p_eg_elementAmount - 1, 6);
    p_eg_riseElementFromElementOrderId(0);
  }
  
  public static boolean p_eg_canScroll()
  {
    return (p_eg_canScrollVert()) || (p_eg_canScrollHoriz());
  }
  
  public static boolean p_eg_canScrollHoriz()
  {
    return (p_eg_guiBorderLeft + p_eg_guiScrollX < p_eg_areaX) || (p_eg_guiBorderRight + p_eg_guiScrollX >= p_eg_areaX + p_eg_areaW);
  }
  
  public static boolean p_eg_canScrollVert()
  {
    return (p_eg_guiBorderTop + p_eg_guiScrollY < p_eg_areaY) || (p_eg_guiBorderBottom + p_eg_guiScrollY >= p_eg_areaY + p_eg_areaH);
  }
  
  public static int p_eg_clampScrollX(int paramInt)
  {
    if (!p_eg_horizontalMovementEnabled) {
      return p_eg_guiScrollX;
    }
    int i = p_eg_guiBorderRight - p_eg_guiBorderLeft + 2 * p_eg_scrollMargin;
    int j;
    int k;
    if (paramInt + (p_eg_guiBorderLeft - p_eg_scrollMargin) > p_eg_areaX)
    {
      j = 1;
      if (paramInt + (p_eg_guiBorderRight + p_eg_scrollMargin) >= p_eg_areaX + p_eg_areaW) {
        break label132;
      }
      k = 1;
      label62:
      if (i >= p_eg_areaW) {
        break label137;
      }
      if ((j != 0) && (k == 0)) {
        paramInt = p_eg_areaX + p_eg_areaW - p_eg_scrollMargin - p_eg_guiBorderRight - 1;
      }
      if (((j != 0) || (k == 0)) && ((j != 0) || (k != 0))) {}
    }
    for (paramInt = 1 + (p_eg_areaX + p_eg_scrollMargin - p_eg_guiBorderLeft);; paramInt = p_eg_areaX + p_eg_areaW - p_eg_scrollMargin - p_eg_guiBorderRight) {
      label132:
      label137:
      do
      {
        return paramInt;
        j = 0;
        break;
        k = 0;
        break label62;
        if ((j != 0) && (k == 0)) {
          paramInt = p_eg_areaX + p_eg_scrollMargin - p_eg_guiBorderLeft;
        }
      } while ((j != 0) || (k == 0));
    }
  }
  
  public static int p_eg_clampScrollY(int paramInt)
  {
    int i = p_eg_guiBorderBottom - p_eg_guiBorderTop + 2 * p_eg_scrollMargin;
    int j;
    int k;
    if (paramInt + (p_eg_guiBorderTop - p_eg_scrollMargin) > p_eg_areaY)
    {
      j = 1;
      if (paramInt + (p_eg_guiBorderBottom + p_eg_scrollMargin) >= p_eg_areaY + p_eg_areaH) {
        break label122;
      }
      k = 1;
      label52:
      if (i >= p_eg_areaH) {
        break label127;
      }
      if ((j != 0) && (k == 0)) {
        paramInt = p_eg_areaY + p_eg_areaH - p_eg_scrollMargin - p_eg_guiBorderBottom - 1;
      }
      if (((j == 0) && (k != 0)) || ((j == 0) && (k == 0))) {
        paramInt = 1 + (p_eg_areaY + p_eg_scrollMargin - p_eg_guiBorderTop);
      }
    }
    label122:
    label127:
    do
    {
      return paramInt;
      j = 0;
      break;
      k = 0;
      break label52;
      if ((j != 0) && (k == 0)) {
        paramInt = p_eg_areaY + p_eg_scrollMargin - p_eg_guiBorderTop;
      }
    } while ((j != 0) || (k == 0));
    return p_eg_areaY + p_eg_areaH - p_eg_scrollMargin - p_eg_guiBorderBottom;
  }
  
  public static void p_eg_copyGuiElement(GuiElement paramGuiElement1, GuiElement paramGuiElement2)
  {
    paramGuiElement1.type = paramGuiElement2.type;
    paramGuiElement1.id = paramGuiElement2.id;
    paramGuiElement1.eg_id = paramGuiElement2.eg_id;
    paramGuiElement1.pos_align = paramGuiElement2.pos_align;
    paramGuiElement1.align = paramGuiElement2.align;
    paramGuiElement1.x = paramGuiElement2.x;
    paramGuiElement1.y = paramGuiElement2.y;
    paramGuiElement1.w = paramGuiElement2.w;
    paramGuiElement1.h = paramGuiElement2.h;
    paramGuiElement1.txt = paramGuiElement2.txt;
    paramGuiElement1.eventMask = paramGuiElement2.eventMask;
    paramGuiElement1.draggableHoriz = paramGuiElement2.draggableHoriz;
    paramGuiElement1.draggableVert = paramGuiElement2.draggableVert;
    if (paramGuiElement2.params == null) {
      paramGuiElement1.params = null;
    }
    for (;;)
    {
      return;
      paramGuiElement1.params = new int[paramGuiElement2.params.length];
      for (int i = 0; i < paramGuiElement2.params.length; i++) {
        paramGuiElement1.params[i] = paramGuiElement2.params[i];
      }
    }
  }
  
  public static void p_eg_doAction(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == -1) {}
    do
    {
      do
      {
        do
        {
          return;
          if (paramInt3 == 2)
          {
            p_eg_doAction(paramInt1, paramInt2, 0);
            p_eg_doAction(paramInt1, paramInt2, 1);
            return;
          }
          switch (paramInt2)
          {
          case 1: 
          case 2: 
          default: 
            return;
          }
        } while (paramInt3 != 0);
        p_eg_registerEvent(paramInt1, 1, true);
        return;
      } while (paramInt3 != 0);
      p_eg_selectorIncrease(paramInt1);
      return;
    } while (paramInt3 != 0);
    p_eg_selectorDecrease(paramInt1);
  }
  
  public static void p_eg_dragEvent(int paramInt, boolean paramBoolean)
  {
    int i = p_eg_getRealId(paramInt);
    if (i != -1)
    {
      p_eg_elementList[i].isDragging = paramBoolean;
      if (paramBoolean)
      {
        GuiElement localGuiElement1 = p_eg_elementList[i];
        GuiElement localGuiElement2 = p_eg_elementList[i];
        int j = p_eg_pointerX();
        localGuiElement2.drag_startX = j;
        localGuiElement1.drag_currX = j;
        GuiElement localGuiElement3 = p_eg_elementList[i];
        GuiElement localGuiElement4 = p_eg_elementList[i];
        int k = p_eg_pointerY();
        localGuiElement4.drag_startY = k;
        localGuiElement3.drag_currY = k;
        p_eg_elementList[i].drag_startOffsetX = (p_eg_pointerX() - p_eg_elementList[i].x);
        p_eg_elementList[i].drag_startOffsetY = (p_eg_pointerY() - p_eg_elementList[i].y);
      }
      if (p_eg_elementList[i].type == 2) {
        p_eg_selector_dragEvent(i, paramBoolean);
      }
    }
  }
  
  public static void p_eg_eventAppeared(int paramInt) {}
  
  public static void p_eg_eventPressed(int paramInt)
  {
    p_eg_eventPressed(paramInt, false);
  }
  
  public static void p_eg_eventPressed(int paramInt, boolean paramBoolean)
  {
    int i = p_eg_getElementWithId(paramInt);
    if ((i >= -1) && (!p_eg_elementList[i].enabled)) {
      return;
    }
    if (paramInt == 268435456)
    {
      eg_reset();
      em_doAction(14, 1);
      mrg_resetKeys();
      return;
    }
    if (paramInt == 268435457)
    {
      eg_reset();
      em_doAction(15, 1);
      mrg_resetKeys();
      return;
    }
    if (paramInt == 268435458)
    {
      eg_reset();
      em_doAction(13, 1);
    }
    if ((!paramBoolean) && (p_eg_elementList[i].type == 2)) {
      p_eg_selector_pressEvent(i);
    }
    egi_eventPressed(paramInt);
  }
  
  public static boolean p_eg_focusCompare(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int i = p_eg_getComparableX(paramInt1);
    int j = p_eg_getComparableY(paramInt1);
    int k = p_eg_elementList[(0xF0FFFFFF & paramInt1)].w;
    int m = p_eg_elementList[(paramInt1 & 0xF0FFFFFF)].h;
    int n = p_eg_getComparableX(paramInt2);
    int i1 = p_eg_getComparableY(paramInt2);
    int i2 = p_eg_elementList[(0xF0FFFFFF & paramInt2)].w;
    int i3 = p_eg_elementList[(paramInt2 & 0xF0FFFFFF)].h;
    int i4 = p_eg_getComparableX(paramInt3);
    int i5 = p_eg_getComparableY(paramInt3);
    int i6 = p_eg_elementList[(0xF0FFFFFF & paramInt3)].w;
    int i7 = p_eg_elementList[(0xF0FFFFFF & paramInt3)].h;
    if (p_eg_verticalMovementOnly)
    {
      i = 0;
      n = 0;
      i4 = 0;
      k = 1;
      i2 = 1;
      i6 = 1;
    }
    if (paramInt5 == 0) {
      return p_eg_focusCompareX(i, k, n, i2, i4, i6, 0, j, m, i1, i3, i5, i7) == -1;
    }
    if (paramInt4 == 0) {
      return p_eg_focusCompareX(j, m, i1, i3, i5, i7, 0, i, k, n, i2, i4, i6) == -1;
    }
    return false;
  }
  
  public static int p_eg_focusCompareX(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, int paramInt13)
  {
    int i1;
    int n;
    if (paramInt7 > 0)
    {
      int i5;
      if (paramInt1 + paramInt2 - paramInt3 < 0)
      {
        i5 = -(paramInt1 + paramInt2 - paramInt3);
        if (paramInt1 + paramInt2 - paramInt5 >= 0) {
          break label66;
        }
      }
      label66:
      for (int i6 = -(paramInt1 + paramInt2 - paramInt5);; i6 = paramInt1 + paramInt2 - paramInt5)
      {
        i1 = i6;
        n = i5;
        if (n != i1) {
          break label402;
        }
        return 0;
        i5 = paramInt1 + paramInt2 - paramInt3;
        break;
      }
    }
    if (paramInt7 < 0)
    {
      int i2;
      if (paramInt1 - paramInt3 - paramInt4 < 0)
      {
        i2 = -(paramInt1 - paramInt3 - paramInt4);
        label98:
        if (paramInt1 - paramInt5 - paramInt6 >= 0) {
          break label143;
        }
      }
      label143:
      for (int i3 = -(paramInt1 - paramInt5 - paramInt6);; i3 = paramInt1 - paramInt5 - paramInt6)
      {
        int i4 = i3;
        n = i2;
        i1 = i4;
        break;
        i2 = paramInt1 - paramInt3 - paramInt4;
        break label98;
      }
    }
    int i;
    label183:
    int j;
    label215:
    int k;
    if (paramInt1 + (paramInt2 >> 1) - (paramInt3 + (paramInt4 >> 1)) < 0)
    {
      i = -(paramInt1 + (paramInt2 >> 1) - (paramInt3 + (paramInt4 >> 1)));
      if (paramInt1 + (paramInt2 >> 1) - (paramInt5 + (paramInt6 >> 1)) >= 0) {
        break label344;
      }
      j = -(paramInt1 + (paramInt2 >> 1) - (paramInt5 + (paramInt6 >> 1)));
      if (paramInt8 + (paramInt9 >> 1) - (paramInt10 + (paramInt11 >> 1)) >= 0) {
        break label362;
      }
      k = -(paramInt8 + (paramInt9 >> 1) - (paramInt10 + (paramInt11 >> 1)));
      label251:
      if (paramInt8 + (paramInt9 >> 1) - (paramInt12 + (paramInt13 >> 1)) >= 0) {
        break label382;
      }
    }
    label344:
    label362:
    label382:
    for (int m = -(paramInt8 + (paramInt9 >> 1) - (paramInt12 + (paramInt13 >> 1)));; m = paramInt8 + (paramInt9 >> 1) - (paramInt12 + (paramInt13 >> 1)))
    {
      n = (i << 16) / (i * i + k * k);
      i1 = (j << 16) / (j * j + m * m);
      break;
      i = paramInt1 + (paramInt2 >> 1) - (paramInt3 + (paramInt4 >> 1));
      break label183;
      j = paramInt1 + (paramInt2 >> 1) - (paramInt5 + (paramInt6 >> 1));
      break label215;
      k = paramInt8 + (paramInt9 >> 1) - (paramInt10 + (paramInt11 >> 1));
      break label251;
    }
    label402:
    if (n > i1) {
      return -1;
    }
    return 1;
  }
  
  public static void p_eg_free()
  {
    eg_reset();
    p_eg_freeKeypad();
    for (int i = 0; i < p_eg_elementAmount; i++)
    {
      p_eg_freeElement(p_eg_elementList[i]);
      p_eg_elementList[i] = null;
    }
    p_eg_elementList = null;
    p_eg_elementOrdering = null;
  }
  
  public static void p_eg_freeElement(GuiElement paramGuiElement)
  {
    if (paramGuiElement.params != null) {
      paramGuiElement.params = null;
    }
    paramGuiElement.txt = null;
    paramGuiElement.eventTimeList = null;
  }
  
  public static void p_eg_freeKeypad()
  {
    p_eg_keyBinds = null;
  }
  
  public static int p_eg_getComparableX(int paramInt)
  {
    int i = p_eg_scrXWithoutScroll(paramInt);
    if (!p_eg_elementList[(paramInt & 0xF0FFFFFF)].isStatic) {
      return i;
    }
    if (i < p_eg_areaX + (p_eg_areaW >> 1)) {
      return i - p_eg_compareLeftThreshold;
    }
    return i + p_eg_compareRightThreshold;
  }
  
  public static int p_eg_getComparableY(int paramInt)
  {
    int i = p_eg_scrYWithoutScroll(paramInt);
    if (!p_eg_elementList[(paramInt & 0xF0FFFFFF)].isStatic) {
      return i;
    }
    if (i < p_eg_areaY + (p_eg_areaH >> 1)) {
      return i - p_eg_compareTopThreshold;
    }
    return i + p_eg_compareBottomThreshold;
  }
  
  public static int p_eg_getElementAt(int paramInt1, int paramInt2)
  {
    for (int i = p_eg_elementAmount - 1; i >= 0; i--)
    {
      int j = p_eg_elementOrdering[i];
      int k = p_eg_elementList[j].w;
      int m = p_eg_elementList[j].h;
      if ((p_eg_elementList[j].enabled) && (paramInt1 >= p_eg_scrX(j)) && (paramInt2 >= p_eg_scrY(j)) && (paramInt1 < k + p_eg_scrX(j)) && (paramInt2 < m + p_eg_scrY(j)) && (((paramInt1 >= p_eg_areaX) && (paramInt1 < p_eg_areaX + p_eg_areaW) && (paramInt2 >= p_eg_areaY) && (paramInt2 < p_eg_areaY + p_eg_areaH) && (!p_eg_elementList[j].isStatic)) || (p_eg_elementList[j].isStatic))) {
        return j;
      }
    }
    return -1;
  }
  
  public static int p_eg_getElementType(int paramInt)
  {
    int i = p_eg_getRealId(paramInt);
    if (i < 0) {
      return -1;
    }
    return p_eg_elementList[i].type;
  }
  
  public static int p_eg_getElementWithId(int paramInt)
  {
    for (int i = 0; i < p_eg_elementAmount; i++) {
      if (p_eg_elementList[i].id == paramInt) {
        return i;
      }
    }
    return -1;
  }
  
  public static int p_eg_getRealId(int paramInt)
  {
    for (int i = 0; i < p_eg_elementAmount; i++) {
      if (p_eg_elementList[i].id == paramInt) {
        return i;
      }
    }
    return -1;
  }
  
  public static int p_eg_getScrollX()
  {
    return EG_NERP(p_eg_guiScrollSrcX, p_eg_guiScrollX, smoothtime - p_eg_guiScrollT, p_eg_guiScrollDuration);
  }
  
  public static int p_eg_getScrollY()
  {
    return EG_NERP(p_eg_guiScrollSrcY, p_eg_guiScrollY, smoothtime - p_eg_guiScrollT, p_eg_guiScrollDuration);
  }
  
  public static int p_eg_getSelectorValue(int paramInt)
  {
    return p_eg_elementList[paramInt].params[3];
  }
  
  public static int p_eg_getSelectorVisualValue(int paramInt)
  {
    if (!p_eg_elementList[paramInt].isDragging) {
      return EG_NERP(p_eg_elementList[paramInt].params[4], p_eg_elementList[paramInt].params[3] << 10, smoothtime - p_eg_elementList[paramInt].params[5], 250);
    }
    int i = p_eg_elementList[paramInt].params[0];
    int j = p_eg_elementList[paramInt].params[1] - i;
    if (p_eg_elementList[paramInt].params[2] == 0)
    {
      int n = p_eg_pointerX() - p_eg_scrX(paramInt);
      int i1 = p_eg_elementList[paramInt].w;
      if (n < 0) {
        n = 0;
      }
      if (n > i1) {
        n = i1;
      }
      return (i + j * n << 10) / i1;
    }
    int k = p_eg_pointerY() - p_eg_scrY(paramInt);
    int m = p_eg_elementList[paramInt].h;
    if (k < 0) {
      k = 0;
    }
    if (k > m) {
      k = m;
    }
    return (i + j * k << 10) / m;
  }
  
  public static boolean p_eg_handleKeyBindsPressed(int paramInt)
  {
    boolean bool = false;
    p_eg_numpadEvent = true;
    for (int i = 0; i < p_eg_keyBindAmount; i++) {
      if (mrg_isKey(paramInt, p_eg_keyBinds[i].key))
      {
        p_eg_doAction(p_eg_getRealId(p_eg_keyBinds[i].elId), p_eg_keyBinds[i].action, 0);
        bool = true;
      }
    }
    p_eg_numpadEvent = false;
    return bool;
  }
  
  public static boolean p_eg_handleKeyBindsReleased(int paramInt)
  {
    boolean bool = false;
    p_eg_numpadEvent = true;
    for (int i = 0; i < p_eg_keyBindAmount; i++) {
      if (mrg_isKey(paramInt, p_eg_keyBinds[i].key))
      {
        p_eg_doAction(p_eg_getRealId(p_eg_keyBinds[i].elId), p_eg_keyBinds[i].action, 1);
        bool = true;
      }
    }
    p_eg_numpadEvent = false;
    return bool;
  }
  
  public static void p_eg_handleKeypress(int paramInt)
  {
    if (p_eg_hackPressingKeyInsideGui) {
      p_eg_hackPressingKeyInsideGui = false;
    }
    do
    {
      do
      {
        return;
      } while ((p_eg_hidden) || (p_eg_elementAmount <= 0));
      if (p_eg_handleKeyBindsPressed(paramInt))
      {
        p_eg_eventRegistered = true;
        mrg_resetKeys();
        return;
      }
    } while (!p_eg_listeningKeyPresses);
    int i;
    int k;
    if (p_eg_focusElement != -1)
    {
      i = 1;
      p_eg_numpadEvent = true;
      if ((p_eg_keyMode) && (p_eg_focusElement == -1)) {
        p_eg_setFocus(0);
      }
      if (!p_eg_keyMode)
      {
        p_eg_setKeypadMode(true);
        if (p_eg_focusElement == -1) {
          p_eg_setKeypadSelectionRealID(0);
        }
      }
      if (i != 0)
      {
        if (!mrg_isKey(paramInt, 355)) {
          break label239;
        }
        p_eg_doAction(p_eg_focusElement, 0, 0);
        k = 1;
      }
    }
    for (;;)
    {
      if (k == 0)
      {
        boolean bool2 = mrg_isKey(paramInt, 131076);
        int n = 0;
        if (bool2)
        {
          boolean bool4 = p_eg_horizontalMovementEnabled;
          n = 0;
          if (bool4) {
            n = 0 - 1;
          }
        }
        if ((mrg_isKey(paramInt, 131078)) && (p_eg_horizontalMovementEnabled)) {
          n++;
        }
        boolean bool3 = mrg_isKey(paramInt, 131072);
        int i1 = 0;
        if (bool3) {
          i1 = 0 - 1;
        }
        if (mrg_isKey(paramInt, 131074)) {
          i1++;
        }
        if ((n != 0) || (i1 != 0)) {
          p_eg_moveFocus(n, i1);
        }
      }
      p_eg_numpadEvent = false;
      return;
      i = 0;
      break;
      label239:
      int j = p_eg_focusElement;
      k = 0;
      if (j != -1)
      {
        int m = p_eg_elementList[p_eg_focusElement].type;
        k = 0;
        if (m == 2) {
          if (mrg_isKey(paramInt, 131076))
          {
            p_eg_doAction(p_eg_focusElement, 4, 0);
            k = 1;
          }
          else
          {
            boolean bool1 = mrg_isKey(paramInt, 131078);
            k = 0;
            if (bool1)
            {
              p_eg_doAction(p_eg_focusElement, 3, 0);
              k = 1;
            }
          }
        }
      }
    }
  }
  
  public static void p_eg_init()
  {
    p_eg_elementList = new GuiElement[10];
    p_eg_elementOrdering = new int[10];
    p_eg_elementAmount = 0;
    p_eg_focusElement = -1;
    p_eg_prevElementOnPointer = -1;
    p_eg_pointerDraggingElement = -1;
    p_eg_hackPressingKeyInsideGui = false;
    p_eg_hidden = false;
    p_eg_initKeypad();
    p_eg_setKeypadMode(false);
    eg_reset();
  }
  
  public static void p_eg_initKeypad()
  {
    p_eg_listeningKeyPresses = false;
    p_eg_keyBinds = new GuiKeyBind[10];
    p_eg_keyBindAmount = 0;
  }
  
  public static void p_eg_keyPressed(int paramInt)
  {
    if (p_eg_guiLocked) {
      return;
    }
    p_eg_repeatingKey = paramInt;
    p_eg_repeatAmount = 0;
    p_eg_lastKeyRepeat = smoothtime;
    p_eg_handleKeypress(paramInt);
  }
  
  public static void p_eg_keyReleased(int paramInt)
  {
    if (p_eg_guiLocked) {}
    label6:
    label80:
    do
    {
      do
      {
        break label6;
        for (;;)
        {
          return;
          if ((!p_eg_hackPressingKeyInsideGui) && (!p_eg_hidden) && (p_eg_elementAmount > 0))
          {
            if (p_eg_handleKeyBindsReleased(paramInt))
            {
              p_eg_eventRegistered = true;
              return;
            }
            if (!p_eg_listeningKeyPresses) {
              break;
            }
            if (p_eg_focusElement != -1) {}
            for (int i = 1; i != 0; i = 0)
            {
              if (!mrg_isKey(paramInt, 355)) {
                break label80;
              }
              p_eg_doAction(p_eg_focusElement, 0, 1);
              return;
            }
          }
        }
      } while ((p_eg_focusElement == -1) || (p_eg_elementList[p_eg_focusElement].type != 1));
      if (mrg_isKey(paramInt, 131076))
      {
        p_eg_doAction(p_eg_focusElement, 1, 1);
        return;
      }
    } while (!mrg_isKey(paramInt, 131078));
    p_eg_doAction(p_eg_focusElement, 2, 1);
  }
  
  public static void p_eg_keyRepeatLogic() {}
  
  public static void p_eg_logic()
  {
    if (p_eg_guiLocked) {
      eg_setFocus(-1);
    }
    p_eg_scrollLogic();
    for (int i = 0; i < p_eg_elementAmount; i++) {}
    p_eg_keyRepeatLogic();
  }
  
  public static void p_eg_moveFocus(int paramInt1, int paramInt2)
  {
    int i = -1;
    int j;
    if (p_eg_focusElement == -1)
    {
      j = -1;
      int k = egi_moveFocus(j, paramInt1, paramInt2);
      if (k == -1) {
        break label45;
      }
      eg_setFocus(k);
    }
    label45:
    label111:
    label231:
    label313:
    label357:
    label401:
    label734:
    do
    {
      return;
      j = p_eg_elementList[p_eg_focusElement].id;
      break;
      int m;
      int n;
      int i2;
      int i1;
      int i3;
      int i15;
      int i16;
      if (p_eg_focusElement != -1)
      {
        m = p_eg_getComparableX(p_eg_focusElement);
        n = p_eg_getComparableY(p_eg_focusElement);
        i2 = p_eg_elementList[p_eg_focusElement].w;
        i1 = p_eg_elementList[p_eg_focusElement].h;
        p_eg_compareLeftThreshold = 0;
        p_eg_compareRightThreshold = 0;
        p_eg_compareBottomThreshold = 0;
        p_eg_compareTopThreshold = 0;
        i3 = 0;
        if (i3 >= p_eg_elementAmount) {
          break label401;
        }
        if ((p_eg_elementList[i3].isStatic) && (p_eg_elementList[i3].keypadFocus))
        {
          i15 = p_eg_scrXWithoutScroll(i3);
          i16 = p_eg_scrYWithoutScroll(i3);
          int i17 = p_eg_elementList[i3].w;
          if ((i16 + p_eg_elementList[i3].h > p_eg_guiBorderTop) && (i16 < p_eg_guiBorderBottom))
          {
            if ((i15 >= p_eg_areaX) || (i15 <= p_eg_guiBorderLeft)) {
              break label313;
            }
            int i21 = i15 - p_eg_guiBorderLeft;
            if (i21 > p_eg_compareLeftThreshold) {
              p_eg_compareLeftThreshold = i21;
            }
          }
          if ((i15 + i17 > p_eg_guiBorderLeft) && (i15 < p_eg_guiBorderRight))
          {
            if ((i16 >= p_eg_areaY) || (i16 <= p_eg_guiBorderTop)) {
              break label357;
            }
            int i19 = i16 - p_eg_guiBorderTop;
            if (i19 > p_eg_compareTopThreshold) {
              p_eg_compareTopThreshold = i19;
            }
          }
        }
      }
      for (;;)
      {
        i3++;
        break label111;
        m = p_eg_pointerX();
        n = p_eg_pointerY();
        i1 = 1;
        i2 = i1;
        break;
        if ((i15 <= p_eg_areaX + p_eg_areaW) || (i15 >= p_eg_guiBorderRight)) {
          break label231;
        }
        int i20 = p_eg_guiBorderRight - i15;
        if (i20 <= p_eg_compareRightThreshold) {
          break label231;
        }
        p_eg_compareRightThreshold = i20;
        break label231;
        if ((i16 > p_eg_areaY + p_eg_areaH) && (i16 < p_eg_guiBorderBottom))
        {
          int i18 = p_eg_guiBorderBottom - i16;
          if (i18 > p_eg_compareBottomThreshold) {
            p_eg_compareBottomThreshold = i18;
          }
        }
      }
      int i4 = 0;
      if (i4 < p_eg_elementAmount)
      {
        if ((i4 == p_eg_focusElement) || (!p_eg_elementList[i4].enabled)) {}
        for (;;)
        {
          i4++;
          break;
          int i5 = p_eg_getComparableX(i4);
          int i6 = p_eg_getComparableY(i4);
          int i7 = p_eg_elementList[i4].w;
          int i8 = p_eg_elementList[i4].h;
          if (p_eg_verticalMovementOnly) {}
          for (i = p_eg_test(0, paramInt2, 0, n, 1, i1, 0, i6, 1, i8, i4, i);; i = p_eg_test(paramInt1, paramInt2, m, n, i2, i1, i5, i6, i7, i8, i4, i))
          {
            if (!p_eg_wrappingEnabled) {
              break label734;
            }
            if (paramInt2 > 0)
            {
              i6 = p_eg_getComparableY(0x2000000 | i4);
              int i14 = i4 | 0x2000000;
              i = p_eg_test(paramInt1, paramInt2, m, n, i2, i1, i5, i6, i7, i8, i14, i);
            }
            if (paramInt2 < 0)
            {
              i6 = p_eg_getComparableY(0x1000000 | i4);
              int i13 = i4 | 0x1000000;
              i = p_eg_test(paramInt1, paramInt2, m, n, i2, i1, i5, i6, i7, i8, i13, i);
            }
            if (!p_eg_horizontalMovementEnabled) {
              break;
            }
            if (paramInt1 < 0)
            {
              int i11 = p_eg_getComparableX(0x4000000 | i4);
              int i12 = i4 | 0x4000000;
              i = p_eg_test(paramInt1, paramInt2, m, n, i2, i1, i11, i6, i7, i8, i12, i);
            }
            if (paramInt1 <= 0) {
              break;
            }
            int i9 = p_eg_getComparableX(0x8000000 | i4);
            int i10 = i4 | 0x8000000;
            i = p_eg_test(paramInt1, paramInt2, m, n, i2, i1, i9, i6, i7, i8, i10, i);
            break;
          }
        }
      }
    } while (i == -1);
    p_eg_setFocus(0xF0FFFFFF & i);
  }
  
  public static void p_eg_paint()
  {
    if (p_eg_elementAmount > 0)
    {
      (p_eg_guiScrollX + p_eg_guiBorderLeft);
      (p_eg_guiScrollX + p_eg_guiBorderRight);
      (p_eg_guiScrollY + p_eg_guiBorderTop);
      (p_eg_guiScrollY + p_eg_guiBorderBottom);
    }
    p_eg_guiPainted = true;
    if (p_eg_hidden) {}
    int i;
    int j;
    int k;
    int m;
    int i1;
    label150:
    label259:
    do
    {
      return;
      i = p_clip_x;
      j = p_clip_y;
      k = p_clip_width;
      m = p_clip_height;
      int n = 0;
      i1 = 0;
      if (n < p_eg_elementAmount)
      {
        int i2 = p_eg_elementOrdering[n];
        int i3 = p_eg_elementList[i2].id;
        int i4 = p_eg_scrX(i2);
        int i5 = p_eg_scrY(i2);
        int i6 = p_eg_elementList[i2].w;
        int i7 = p_eg_elementList[i2].h;
        int i9;
        if (!p_eg_elementList[i2].visible) {
          i9 = i1;
        }
        for (;;)
        {
          n++;
          i1 = i9;
          break;
          if (!p_eg_elementList[i2].isStatic)
          {
            if (i1 == 1) {
              break label259;
            }
            gfx_setClip(p_eg_areaX, p_eg_areaY, p_eg_areaW, p_eg_areaH);
          }
          for (int i8 = 1;; i8 = i1) {
            switch (p_eg_elementList[i2].type)
            {
            case 1: 
            default: 
              i9 = i8;
              break label150;
              if (i1 != 2)
              {
                i1 = 2;
                gfx_setClip(0, 0, dynamic_X_RES, dynamic_Y_RES);
              }
              break;
            }
          }
          String str = p_eg_elementList[i2].txt;
          int i10 = p_eg_elementList[i2].event;
          int i11 = smoothtime - p_eg_elementList[i2].eventTime;
          if (p_eg_focusElement == i2) {}
          for (boolean bool = true;; bool = false)
          {
            egi_textButtonPaint(i3, i4, i5, i6, i7, str, i10, i11, bool);
            i9 = i8;
            break;
          }
          p_eg_selector_paint(i2);
          i9 = i8;
        }
      }
    } while (i1 == 0);
    gfx_setClip(i, j, k, m);
  }
  
  public static boolean p_eg_pointerDown()
  {
    return p_eg_pointerReportedDown;
  }
  
  public static void p_eg_pointerPressed()
  {
    if (p_eg_pointerReportedDown) {}
    int i;
    int j;
    int k;
    do
    {
      do
      {
        return;
        p_eg_pointerReportedDown = true;
      } while (p_eg_guiLocked);
      p_eg_setKeypadMode(false);
      i = p_eg_pointerX();
      j = p_eg_pointerY();
      p_eg_origPointerX = i;
      p_eg_prevPointerX = i;
      p_eg_origPointerY = j;
      p_eg_prevPointerY = j;
      k = p_eg_getElementAt(i, j);
    } while ((k != -1) && (!p_eg_elementList[k].enabled));
    p_eg_setFocus(k);
    p_eg_origFocusElement = p_eg_focusElement;
    if (k != -1)
    {
      p_eg_elementList[k].pressX = i;
      p_eg_elementList[k].pressY = j;
    }
    p_eg_pointerDraggingElement = -1;
    p_eg_registerEvent(k, 2);
  }
  
  public static void p_eg_pointerReleased()
  {
    if (!p_eg_pointerReportedDown) {}
    do
    {
      return;
      p_eg_pointerReportedDown = false;
    } while (p_eg_guiLocked);
    p_eg_stopScrollingWithPointer();
    int i = p_eg_getElementAt(p_eg_pointerX(), p_eg_pointerY());
    if (p_eg_pointerDraggingElement == -1) {
      if (p_eg_focusElement == i) {
        p_eg_registerEvent(i, 1);
      }
    }
    for (;;)
    {
      p_eg_prevElementOnPointer = -1;
      p_eg_draggingHorizontal = false;
      p_eg_draggingVertical = false;
      return;
      if ((p_eg_focusElement != -1) && (p_eg_elementList[p_eg_focusElement].event == 2)) {
        p_eg_registerEvent(p_eg_focusElement, 3);
      }
      for (int j = 0; j < p_eg_elementAmount; j++) {
        if (p_eg_elementList[j].event == 2) {
          p_eg_registerEvent(j, 3);
        }
      }
      p_eg_setFocus(-1);
      continue;
      p_eg_resetDragging();
    }
  }
  
  public static int p_eg_pointerX()
  {
    return p_pointer_x;
  }
  
  public static int p_eg_pointerY()
  {
    return p_pointer_y;
  }
  
  public static void p_eg_recomputeBBox()
  {
    p_eg_guiBorderLeft = Integer.MAX_VALUE;
    p_eg_guiBorderTop = Integer.MAX_VALUE;
    p_eg_guiBorderRight = Integer.MIN_VALUE;
    p_eg_guiBorderBottom = Integer.MIN_VALUE;
    int i = 0;
    if (i < p_eg_elementAmount)
    {
      GuiElement localGuiElement = p_eg_elementList[i];
      if ((!localGuiElement.enabled) || (localGuiElement.isStatic)) {}
      for (;;)
      {
        i++;
        break;
        int j = p_eg_scrXWithoutScroll(i);
        int k = p_eg_scrYWithoutScroll(i);
        int m = j + localGuiElement.w;
        int n = k + localGuiElement.h;
        if (j < p_eg_guiBorderLeft) {
          p_eg_guiBorderLeft = j;
        }
        if (k < p_eg_guiBorderTop) {
          p_eg_guiBorderTop = k;
        }
        if (m > p_eg_guiBorderRight) {
          p_eg_guiBorderRight = m;
        }
        if (n > p_eg_guiBorderBottom) {
          p_eg_guiBorderBottom = n;
        }
      }
    }
  }
  
  public static void p_eg_registerEvent(int paramInt1, int paramInt2)
  {
    p_eg_registerEvent(paramInt1, paramInt2, false);
  }
  
  public static void p_eg_registerEvent(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((p_eg_hidden) || (paramInt1 < 0)) {}
    do
    {
      do
      {
        return;
      } while ((!p_eg_elementList[paramInt1].enabled) && (paramInt2 != 7));
      p_eg_eventRegistered = true;
      if (paramInt2 == 1) {
        p_eg_pressEventRegistered = true;
      }
      p_eg_elementList[paramInt1].event = paramInt2;
      p_eg_elementList[paramInt1].eventTime = smoothtime;
      p_eg_elementList[paramInt1].eventTimeList[(paramInt2 - 1)] = smoothtime;
      switch (paramInt2)
      {
      default: 
        return;
      }
    } while ((0x1 & p_eg_elementList[paramInt1].eventMask) == 0);
    p_eg_eventPressed(p_eg_elementList[paramInt1].id, paramBoolean);
    return;
    p_eg_eventAppeared(p_eg_elementList[paramInt1].id);
    return;
    p_eg_dragEvent(p_eg_elementList[paramInt1].id, true);
    return;
    p_eg_dragEvent(p_eg_elementList[paramInt1].id, false);
    return;
    egi_selectorValueChanged(p_eg_elementList[paramInt1].id);
  }
  
  public static void p_eg_removeBind(int paramInt)
  {
    p_eg_keyBinds[paramInt] = null;
    for (int i = paramInt; i < p_eg_keyBindAmount - 1; i++) {
      p_eg_keyBinds[i] = p_eg_keyBinds[(i + 1)];
    }
    p_eg_keyBindAmount -= 1;
  }
  
  public static void p_eg_resetDragging()
  {
    if (p_eg_pointerDraggingElement != -1)
    {
      p_eg_registerEvent(p_eg_pointerDraggingElement, 9);
      p_eg_pointerDraggingElement = -1;
    }
    p_eg_draggingVertical = false;
    p_eg_draggingHorizontal = false;
  }
  
  public static void p_eg_resetKeypad()
  {
    for (int i = 0; i < p_eg_keyBindAmount; i++) {
      p_eg_keyBinds[i] = null;
    }
    p_eg_keyBindAmount = 0;
  }
  
  public static void p_eg_riseElement(int paramInt)
  {
    for (int i = 0;; i++) {
      if (i < p_eg_elementAmount)
      {
        if (p_eg_elementOrdering[i] == paramInt) {
          p_eg_riseElementFromElementOrderId(i);
        }
      }
      else {
        return;
      }
    }
  }
  
  public static void p_eg_riseElementFromElementOrderId(int paramInt)
  {
    int i = p_eg_elementOrdering[paramInt];
    for (int j = paramInt + 1; (j < p_eg_elementAmount) && (p_eg_elementList[i].elementLevel >= p_eg_elementList[p_eg_elementOrdering[j]].elementLevel); j++) {}
    for (int k = paramInt; k < j - 1; k++) {
      p_eg_elementOrdering[k] = p_eg_elementOrdering[(k + 1)];
    }
    p_eg_elementOrdering[(j - 1)] = i;
  }
  
  public static int p_eg_scrX(int paramInt)
  {
    int i = paramInt & 0xF0FFFFFF;
    if (!p_eg_elementList[i].isStatic) {
      return p_eg_scrXWithoutScroll(i) + p_eg_getScrollX();
    }
    return p_eg_scrXWithoutScroll(i);
  }
  
  public static int p_eg_scrXWithoutScroll(int paramInt)
  {
    int i = p_eg_guiBorderRight - p_eg_guiBorderLeft;
    int j = 0x4000000 & paramInt;
    int k = 0;
    if (j != 0) {
      k = -i << 2;
    }
    if ((0x8000000 & paramInt) != 0) {
      k = i << 2;
    }
    int m = paramInt & 0xF0FFFFFF;
    int n = p_eg_elementList[m].w;
    if ((0x4 & p_eg_elementList[m].pos_align) != 0) {
      return k + p_eg_elementList[m].x;
    }
    if ((0x10 & p_eg_elementList[m].pos_align) != 0) {
      return k + ((dynamic_X_RES >> 1) + p_eg_elementList[m].x - (n >> 1));
    }
    return k + (dynamic_X_RES - p_eg_elementList[m].x);
  }
  
  public static int p_eg_scrY(int paramInt)
  {
    int i = paramInt & 0xF0FFFFFF;
    if (!p_eg_elementList[i].isStatic) {
      return 0 + (p_eg_scrYWithoutScroll(i) + p_eg_getScrollY());
    }
    return 0 + p_eg_scrYWithoutScroll(i);
  }
  
  public static int p_eg_scrYWithoutScroll(int paramInt)
  {
    int i = p_eg_guiBorderBottom - p_eg_guiBorderTop;
    int j = 0x1000000 & paramInt;
    int k = 0;
    if (j != 0) {
      k = -i << 2;
    }
    if ((0x2000000 & paramInt) != 0) {
      k = i << 2;
    }
    int m = paramInt & 0xF0FFFFFF;
    int n = p_eg_elementList[m].h;
    if ((0x1 & p_eg_elementList[m].pos_align) != 0) {
      return k + p_eg_elementList[m].y;
    }
    if ((0x20 & p_eg_elementList[m].pos_align) != 0) {
      return k + ((dynamic_Y_RES >> 1) + p_eg_elementList[m].y - (n >> 1));
    }
    return k + (dynamic_Y_RES - p_eg_elementList[m].y);
  }
  
  public static void p_eg_scroll(int paramInt1, int paramInt2)
  {
    p_eg_scroll(paramInt1, paramInt2, 400);
  }
  
  public static void p_eg_scroll(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = p_eg_clampScrollX(paramInt1);
    int j = p_eg_clampScrollY(paramInt2);
    if ((i != p_eg_guiScrollX) || (j != p_eg_guiScrollY))
    {
      p_eg_guiScrollDuration = paramInt3;
      p_eg_guiScrollSrcX = p_eg_getScrollX();
      p_eg_guiScrollSrcY = p_eg_getScrollY();
      p_eg_guiScrollX = i;
      p_eg_guiScrollY = j;
      p_eg_guiScrollT = smoothtime;
    }
  }
  
  public static void p_eg_scrollImmediately(int paramInt1, int paramInt2)
  {
    int i = p_eg_clampScrollX(paramInt1);
    int j = p_eg_clampScrollY(paramInt2);
    p_eg_guiScrollX = i;
    p_eg_guiScrollSrcX = i;
    p_eg_guiScrollY = j;
    p_eg_guiScrollSrcY = j;
    p_eg_guiScrollT = smoothtime;
  }
  
  public static void p_eg_scrollLogic()
  {
    if (!p_eg_autoScroll) {}
    do
    {
      return;
      if ((p_eg_focusElement != -1) && (!p_eg_elementList[p_eg_focusElement].isStatic)) {
        p_eg_scrollTo(p_eg_focusElement);
      }
    } while (!p_eg_scrollingWithPointer);
    int i;
    if (p_eg_guiBorderLeft + p_eg_guiScrollX >= p_eg_areaX)
    {
      int n = p_eg_guiBorderRight + p_eg_guiScrollX;
      int i1 = p_eg_areaX + p_eg_areaW;
      i = 0;
      if (n < i1) {}
    }
    else
    {
      i = p_eg_pointerX() - p_eg_lastScrollPX;
    }
    int j;
    if (p_eg_guiBorderTop + p_eg_guiScrollY >= p_eg_areaY)
    {
      int k = p_eg_guiBorderBottom + p_eg_guiScrollY;
      int m = p_eg_areaY + p_eg_areaH;
      j = 0;
      if (k < m) {}
    }
    else
    {
      j = p_eg_pointerY() - p_eg_lastScrollPY;
    }
    p_eg_scrollImmediately(i + p_eg_guiScrollX, j + p_eg_guiScrollY);
    p_eg_lastScrollPX = p_eg_pointerX();
    p_eg_lastScrollPY = p_eg_pointerY();
  }
  
  public static void p_eg_scrollTo(int paramInt)
  {
    int i = p_eg_scrXWithoutScroll(paramInt) + p_eg_guiScrollX;
    int j = p_eg_scrYWithoutScroll(paramInt) + p_eg_guiScrollY;
    int k = p_eg_elementList[paramInt].w;
    int m = p_eg_elementList[paramInt].h;
    int n = i + k + p_eg_scrollMargin;
    int i1 = p_eg_areaX + p_eg_areaW;
    int i2 = 0;
    if (n > i1) {
      i2 = p_eg_areaX + p_eg_areaW - i - k - p_eg_scrollMargin;
    }
    int i3 = j + m + p_eg_scrollMargin;
    int i4 = p_eg_areaY + p_eg_areaH;
    int i5 = 0;
    if (i3 > i4) {
      i5 = p_eg_areaY + p_eg_areaH - j - m - p_eg_scrollMargin;
    }
    if (i - p_eg_scrollMargin < p_eg_areaX) {
      i2 = p_eg_areaX - i + p_eg_scrollMargin;
    }
    if (j - p_eg_scrollMargin < p_eg_areaY) {
      i5 = p_eg_areaY - j + p_eg_scrollMargin;
    }
    p_eg_scroll(i2 + p_eg_guiScrollX, i5 + p_eg_guiScrollY);
  }
  
  public static void p_eg_selectorDecrease(int paramInt)
  {
    p_eg_setSelectorValue(paramInt, p_eg_getSelectorValue(paramInt) - 1);
  }
  
  public static void p_eg_selectorIncrease(int paramInt)
  {
    p_eg_setSelectorValue(paramInt, 1 + p_eg_getSelectorValue(paramInt));
  }
  
  public static void p_eg_selector_dragEvent(int paramInt, boolean paramBoolean)
  {
    int i;
    int j;
    int k;
    if (!paramBoolean)
    {
      i = p_eg_elementList[paramInt].params[1] - p_eg_elementList[paramInt].params[0];
      j = p_eg_elementList[paramInt].params[0];
      if (p_eg_elementList[paramInt].params[2] != 0) {
        break label128;
      }
      k = p_eg_pointerX() - p_eg_scrX(paramInt);
    }
    for (int m = p_eg_elementList[paramInt].w;; m = p_eg_elementList[paramInt].h)
    {
      int n = j + (k * i + (m >> 1)) / m;
      p_eg_elementList[paramInt].params[4] = ((j + i * k << 10) / m);
      p_eg_elementList[paramInt].params[5] = smoothtime;
      p_eg_setSelectorValue(paramInt, n);
      return;
      label128:
      k = p_eg_pointerY() - p_eg_scrY(paramInt);
    }
  }
  
  public static void p_eg_selector_paint(int paramInt)
  {
    int i = p_eg_elementList[paramInt].id;
    int j = p_eg_scrX(paramInt);
    int k = p_eg_scrY(paramInt);
    int m = p_eg_elementList[paramInt].w;
    int n = p_eg_elementList[paramInt].h;
    int i1 = p_eg_getSelectorVisualValue(paramInt);
    if (p_eg_elementList[paramInt].params[2] == 0) {}
    for (int i2 = i1 * m / (p_eg_elementList[paramInt].params[1] - p_eg_elementList[paramInt].params[0]) >> 10;; i2 = i1 * n / (p_eg_elementList[paramInt].params[1] - p_eg_elementList[paramInt].params[0]) >> 10)
    {
      egi_paintSelector(i, j, k, m, n, i2);
      return;
    }
  }
  
  public static void p_eg_selector_pressEvent(int paramInt)
  {
    int i = p_eg_elementList[paramInt].params[1] - p_eg_elementList[paramInt].params[0];
    int j = p_eg_elementList[paramInt].params[0];
    int k;
    if (p_eg_elementList[paramInt].params[2] == 0) {
      k = p_eg_pointerX() - p_eg_scrX(paramInt);
    }
    for (int m = p_eg_elementList[paramInt].w;; m = p_eg_elementList[paramInt].h)
    {
      p_eg_setSelectorValue(paramInt, j + (k * i + (m >> 1)) / m);
      return;
      k = p_eg_pointerY() - p_eg_scrY(paramInt);
    }
  }
  
  public static void p_eg_setAlignment(GuiElement paramGuiElement)
  {
    int i = paramGuiElement.align;
    int j = paramGuiElement.pos_align;
    int m;
    int i1;
    if ((j & 0x10) == 0)
    {
      int i3 = i & 0x8;
      m = 0;
      if (i3 != 0) {
        m = 2;
      }
      if ((i & 0x1) != 0) {
        m = 1;
      }
      if ((j & 0x8) != 0) {
        m *= -1;
      }
      if ((j & 0x20) != 0) {
        break label165;
      }
      int i2 = i & 0x20;
      i1 = 0;
      if (i2 != 0) {
        i1 = 2;
      }
      if ((i & 0x2) != 0) {
        i1 = 1;
      }
      if ((j & 0x2) != 0) {
        i1 *= -1;
      }
    }
    for (;;)
    {
      paramGuiElement.x = (paramGuiElement.ax - (m * paramGuiElement.w >> 1));
      paramGuiElement.y = (paramGuiElement.ay - (i1 * paramGuiElement.h >> 1));
      return;
      int k = i & 0x4;
      m = 0;
      if (k != 0) {
        m = 1;
      }
      if ((i & 0x8) == 0) {
        break;
      }
      m = -1;
      break;
      label165:
      int n = i & 0x10;
      i1 = 0;
      if (n != 0) {
        i1 = 1;
      }
      if ((i & 0x20) != 0) {
        i1 = -1;
      }
    }
  }
  
  public static void p_eg_setFocus(int paramInt)
  {
    if ((paramInt == -1) && (!p_eg_gameAreaFocusable)) {}
    do
    {
      do
      {
        return;
      } while ((paramInt != -1) && (!p_eg_elementList[paramInt].enabled));
      if (p_eg_focusElement != paramInt)
      {
        p_eg_prevFocusElement = p_eg_focusElement;
        int i = p_eg_focusElement;
        p_eg_focusElement = paramInt;
        p_eg_registerEvent(i, 5);
        p_eg_registerEvent(p_eg_focusElement, 4);
      }
    } while (paramInt == -1);
    p_eg_riseElement(paramInt);
  }
  
  public static void p_eg_setKeypadMode(boolean paramBoolean)
  {
    if (p_eg_keyMode != paramBoolean)
    {
      p_eg_keyMode = paramBoolean;
      if ((paramBoolean) && (p_eg_elementAmount > 0))
      {
        p_eg_resetDragging();
        if (p_eg_focusElement == -1) {
          p_eg_setKeypadSelection(0);
        }
      }
    }
  }
  
  public static void p_eg_setKeypadSelection(int paramInt)
  {
    int i = p_eg_getRealId(paramInt);
    if (i != -1) {
      p_eg_setKeypadSelectionRealID(i);
    }
  }
  
  public static void p_eg_setKeypadSelectionRealID(int paramInt)
  {
    if (p_eg_elementList[paramInt].keypadFocus) {
      p_eg_setFocus(paramInt);
    }
  }
  
  public static void p_eg_setSelectorValue(int paramInt1, int paramInt2)
  {
    GuiElement localGuiElement = p_eg_elementList[paramInt1];
    int i = localGuiElement.params[0];
    int j = localGuiElement.params[1];
    if (paramInt2 < i) {
      paramInt2 = i;
    }
    if (paramInt2 > j) {
      paramInt2 = j;
    }
    if (paramInt2 != localGuiElement.params[3])
    {
      localGuiElement.params[4] = p_eg_getSelectorVisualValue(paramInt1);
      localGuiElement.params[5] = smoothtime;
      localGuiElement.params[3] = paramInt2;
      p_eg_registerEvent(paramInt1, 12);
    }
  }
  
  public static void p_eg_startScrollingWithPointer()
  {
    if ((p_eg_canScroll()) && (!p_eg_scrollingWithPointer))
    {
      p_eg_scrollingWithPointer = true;
      p_eg_lastScrollPX = p_eg_pointerX();
      p_eg_lastScrollPY = p_eg_pointerY();
      eg_setFocus(-1);
    }
  }
  
  public static void p_eg_stopScrollingWithPointer()
  {
    if (p_eg_scrollingWithPointer) {
      p_eg_scrollingWithPointer = false;
    }
  }
  
  public static int p_eg_test(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12)
  {
    if (((paramInt1 > 0) && (paramInt7 + paramInt9 <= paramInt3 + paramInt5)) || ((paramInt1 < 0) && (paramInt7 >= paramInt3)) || ((paramInt2 > 0) && (paramInt8 + paramInt10 <= paramInt4 + paramInt6)) || ((paramInt2 < 0) && (paramInt8 >= paramInt4)) || (!p_eg_elementList[(0xF0FFFFFF & paramInt11)].keypadFocus)) {
      return paramInt12;
    }
    if (paramInt12 == -1) {
      return paramInt11;
    }
    if (p_eg_focusCompare(p_eg_focusElement, paramInt11, paramInt12, paramInt1, paramInt2)) {
      return paramInt11;
    }
    return paramInt12;
  }
  
  public static void p_eg_updatePointer()
  {
    if ((p_eg_pointerReportedDown) && (!mrg_isKey(350))) {
      p_eg_pointerReleased();
    }
    if ((!p_eg_pointerReportedDown) && (mrg_isKey(350))) {
      p_eg_pointerPressed();
    }
    if (p_eg_guiLocked) {
      return;
    }
    int i = p_eg_pointerX();
    int j = p_eg_pointerY();
    int k = p_eg_prevPointerX;
    int m = p_eg_prevPointerY;
    int n = p_eg_getElementAt(i, j);
    int i1 = p_eg_prevElementOnPointer;
    int i2 = i - p_eg_origPointerX;
    int i3 = j - p_eg_origPointerY;
    if (p_eg_pointerDown())
    {
      if ((i2 < -10) || (i2 > 10)) {
        p_eg_draggingHorizontal = true;
      }
      if ((i3 < -20) || (i3 > 20)) {
        p_eg_draggingVertical = true;
      }
    }
    int i8;
    int i9;
    label174:
    label251:
    int i6;
    label286:
    int i7;
    label321:
    int i4;
    label353:
    int i5;
    if ((p_eg_pointerDown()) && (p_eg_pointerDraggingElement == -1)) {
      if ((i2 < -10) || (i2 > 10))
      {
        i8 = 1;
        if ((i3 >= -10) && (i3 <= 10)) {
          break label492;
        }
        i9 = 1;
        if ((i8 != 0) || (i9 != 0))
        {
          if ((n == -1) || (((i8 == 0) || (!p_eg_elementList[n].draggableHoriz)) && ((i9 == 0) || (!p_eg_elementList[n].draggableVert) || (p_eg_scrollingWithPointer)))) {
            break label498;
          }
          if (n == p_eg_focusElement)
          {
            p_eg_pointerDraggingElement = n;
            p_eg_registerEvent(p_eg_pointerDraggingElement, 10);
          }
        }
        if (p_eg_focusElement != -1)
        {
          GuiElement localGuiElement1 = p_eg_elementList[p_eg_focusElement];
          if (timedelta == 0) {
            break label542;
          }
          i6 = 1000 * (i - k) / timedelta;
          localGuiElement1.drag_VX = i6;
          GuiElement localGuiElement2 = p_eg_elementList[p_eg_focusElement];
          if (timedelta == 0) {
            break label548;
          }
          i7 = 1000 * (j - m) / timedelta;
          localGuiElement2.drag_VY = i7;
        }
        if (p_eg_pointerDown())
        {
          if (timedelta == 0) {
            break label554;
          }
          i4 = 1000 * (i - k) / timedelta;
          p_eg_pointerVX = i4;
          if (timedelta == 0) {
            break label560;
          }
          i5 = 1000 * (j - m) / timedelta;
          label377:
          p_eg_pointerVY = i5;
        }
        if ((!p_eg_scrollingWithPointer) && (p_eg_pointerDraggingElement == -1) && (n != i1) && (p_eg_origFocusElement != -1))
        {
          if (!p_eg_pointerDown()) {
            break label566;
          }
          p_eg_setFocus(n);
          if ((p_eg_focusElement != -1) && (p_eg_elementList[p_eg_focusElement].event != 3)) {
            p_eg_registerEvent(p_eg_focusElement, 3);
          }
          if (p_eg_getElementAt(p_eg_pointerX(), p_eg_pointerY()) == n) {
            p_eg_registerEvent(n, 2);
          }
        }
      }
    }
    for (;;)
    {
      p_eg_prevPointerX = i;
      p_eg_prevPointerY = j;
      p_eg_prevElementOnPointer = n;
      return;
      i8 = 0;
      break;
      label492:
      i9 = 0;
      break label174;
      label498:
      if (!p_eg_autoScroll) {
        break label251;
      }
      p_eg_startScrollingWithPointer();
      break label251;
      if (p_eg_pointerDraggingElement == -1) {
        break label251;
      }
      p_eg_elementList[p_eg_pointerDraggingElement].drag_currX = i;
      p_eg_elementList[p_eg_pointerDraggingElement].drag_currY = j;
      break label251;
      label542:
      i6 = 0;
      break label286;
      label548:
      i7 = 0;
      break label321;
      label554:
      i4 = 0;
      break label353;
      label560:
      i5 = 0;
      break label377;
      label566:
      if ((i1 == p_eg_focusElement) && (p_eg_pointerDown())) {
        p_eg_registerEvent(i1, 3);
      }
    }
  }
  
  public static void p_em_dispatchEvent(int paramInt1, int paramInt2, int paramInt3)
  {
    emi_event(paramInt1, paramInt2, paramInt3);
  }
  
  public static void p_em_exitIntro()
  {
    p_em_introMode = false;
    gfx_unloadGroup(1);
    txt_unloadGroup(1);
    menu_start();
    mrg_resetKeys();
  }
  
  public static void p_em_free() {}
  
  public static void p_em_initCurrentMenu()
  {
    p_em_initCurrentMenuEx(false);
  }
  
  public static void p_em_initCurrentMenuEx(boolean paramBoolean)
  {
    int i = p_em_menuStack[p_em_stackPos];
    int j = p_indexTable2[(i + 337)];
    p_em_currentMenuType = (short)(0xFFFF7FFF & p_indexTable2[(277 + (j + 0))]);
    p_em_currentMenuTopic = p_indexTable2[(277 + (j + 1))];
    p_em_currentMenuLength = 0;
    p_em_currentMenuScroll = 0;
    p_tb_handleInput(0, false);
    int k = 0 + gfx_getFontHeight(0);
    p_em_maxLines = (dynamic_Y_RES - 1 - (0 + gfx_getFontHeight(0)) - (4 + (dynamic_Y_RES >> 4) + (0 + gfx_getFontHeight(1)))) / k;
    if (p_em_currentMenuScroll > p_em_currentMenuPointer) {
      p_em_currentMenuScroll = p_em_currentMenuPointer;
    }
    if (p_em_currentMenuScroll <= p_em_currentMenuPointer - p_em_maxLines) {
      p_em_currentMenuScroll = 1 + (p_em_currentMenuPointer - p_em_maxLines);
    }
    if (p_em_currentMenuType == 0)
    {
      int i1 = -1;
      for (int i2 = 3; i2 < 3 + p_indexTable2[(277 + (j + 2))]; i2++)
      {
        int i3 = p_indexTable2[(277 + (j + i2))];
        if ((i3 != -1) && (p_indexTable2[(348 + (2 + i3 * 4))] != 2))
        {
          p_em_currentMenuElements[p_em_currentMenuLength] = i3;
          if ((i1 == -1) && (p_indexTable2[(348 + (2 + i3 * 4))] == 0)) {
            i1 = p_em_currentMenuLength;
          }
          p_em_currentMenuLength = 1 + p_em_currentMenuLength;
        }
      }
    }
    String str;
    int m;
    int n;
    if (p_em_currentMenuType == 1)
    {
      str = "";
      m = p_indexTable2[(277 + (j + 2))];
      n = p_indexTable2[(277 + (j + 3))];
    }
    switch (m)
    {
    default: 
      p_em_currentMenuTextboxString = str;
      p_em_textboxCurrentLine = 0;
      p_em_currentMenuLength = 1 + p_em_currentMenuLength;
      emi_menuInitCallback(i);
      if ((!p_em_introMode) && (!p_em_confirming))
      {
        if (!paramBoolean) {
          break label437;
        }
        p_em_dispatchEvent(i, 4, 0);
      }
      break;
    }
    for (;;)
    {
      p_em_updateCursorY();
      return;
      str = p_allTexts[n];
      if (i != 5) {
        break;
      }
      str = str + "\n\n" + p_allTexts[23];
      break;
      if (n >= 256) {
        break;
      }
      str = hs_getHighscore_text(n);
      break;
      label437:
      p_em_dispatchEvent(i, 0, 0);
    }
  }
  
  public static boolean p_em_isPointerOnArrow(int paramInt)
  {
    int i = p_pointer_y;
    int j = dynamic_Y_RES - 1 - gfx_getFontHeight(0);
    int k = 0;
    int m = 0;
    if (i > j)
    {
      int n = p_pointer_x;
      int i1 = (dynamic_X_RES >> 1) - (gfx_getFontHeight(0) >> 1);
      k = 0;
      m = 0;
      if (n > i1)
      {
        int i2 = p_pointer_x;
        int i3 = (dynamic_X_RES >> 1) + (gfx_getFontHeight(0) >> 1);
        k = 0;
        m = 0;
        if (i2 < i3)
        {
          int i4 = p_pointer_y;
          int i5 = dynamic_Y_RES - 1 - gfx_getFontHeight(0) + (gfx_getFontHeight(0) >> 1);
          m = 0;
          if (i4 < i5) {
            m = 1;
          }
          int i6 = p_pointer_y;
          int i7 = dynamic_Y_RES - 1 - gfx_getFontHeight(0) + (gfx_getFontHeight(0) >> 1);
          k = 0;
          if (i6 > i7) {
            k = 1;
          }
        }
      }
    }
    if ((paramInt == 0) && (0 != 0)) {
      return true;
    }
    if ((paramInt == 1) && (0 != 0)) {
      return true;
    }
    if ((paramInt == 2) && (m != 0)) {
      return true;
    }
    return (paramInt == 3) && (k != 0);
  }
  
  public static void p_em_resolutionChanged()
  {
    if (!p_mainGroupsLoaded) {
      return;
    }
    p_em_initCurrentMenuEx(true);
  }
  
  public static void p_em_runkoAction(int paramInt)
  {
    if (paramInt == 11) {
      p_em_gotoGame = true;
    }
    if (paramInt == 3) {
      mrg_exitApp();
    }
    if (paramInt == 13) {
      em_popMenu();
    }
    int k;
    label78:
    int i;
    if (paramInt == 14)
    {
      if (p_em_confirmElement != -1)
      {
        em_doAction(p_em_confirmElement, 1);
        p_em_confirming = false;
        p_tb_handleInput(p_tb_backupConfirmHandleFlags, false);
        if ((!p_game_menuInited) || (p_em_stackPos < 0)) {
          break label183;
        }
        k = p_em_menuStack[p_em_stackPos];
        p_em_dispatchEvent(k, 3, p_em_confirmElement);
      }
    }
    else if (paramInt == 15)
    {
      p_em_confirming = false;
      if (p_em_confirmElement != -1) {
        p_tb_handleInput(p_tb_backupConfirmHandleFlags, false);
      }
      if ((!p_game_menuInited) || (p_em_stackPos < 0)) {
        break label188;
      }
      i = p_em_menuStack[p_em_stackPos];
      label130:
      if (p_em_confirmElement == 7) {
        break label193;
      }
    }
    label183:
    label188:
    label193:
    for (int j = -1;; j = p_em_confirmElement)
    {
      p_em_dispatchEvent(i, 3, j);
      if (paramInt == 10) {
        p_resetRecordStore();
      }
      if (paramInt == 5) {
        p_hs_resetAll();
      }
      if (paramInt == 7) {
        p_options[0] = 1;
      }
      return;
      p_em_confirming = false;
      break;
      k = 0;
      break label78;
      i = 0;
      break label130;
    }
  }
  
  public static void p_em_updateCursorY()
  {
    int i;
    if (p_em_currentMenuType == 0) {
      i = 0 + gfx_getFontHeight(0);
    }
    for (p_em_cursorY = 4 + (dynamic_Y_RES >> 4) + (0 + gfx_getFontHeight(1)) + i * (p_em_currentMenuPointer - p_em_currentMenuScroll);; p_em_cursorY = -1)
    {
      if (p_em_confirming) {
        p_em_cursorY = -1;
      }
      return;
    }
  }
  
  public static void p_exitMrgame()
  {
    p_thread = null;
    sfx_stopAll();
    mrg_saveOptions();
  }
  
  public static void p_flip(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 1;
    int j = 0;
    int k = 0;
    int m = 0;
    if (paramBoolean1)
    {
      i = -1;
      k = 0 + (p_riXres - 1);
      m = 0;
      if (!paramBoolean2) {
        m = 2 * p_riXres;
      }
    }
    if (paramBoolean2)
    {
      k += p_riXres * (p_riYres - 1);
      if (!paramBoolean1) {
        m = 2 * -p_riXres;
      }
    }
    for (int n = 0; n < p_riYres; n++)
    {
      for (int i1 = 0; i1 < p_riXres; i1++)
      {
        p_riDestImage[k] = p_tempImage2[j];
        k += i;
        j++;
      }
      k += m;
    }
  }
  
  public static void p_freeGlobalPalettes()
  {
    p_globalPalettes = (short[][])null;
    p_gp_loaded = false;
  }
  
  public static byte[] p_getFile_byte(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < paramInt3)) {
      paramArrayOfByte = new byte[paramInt3];
    }
    try
    {
      data_openFile("b" + paramInt1, paramInt2);
      data_readToByteArray(0, paramInt3, paramArrayOfByte);
      data_closeFile();
      return paramArrayOfByte;
    }
    catch (Exception localException) {}
    return paramArrayOfByte;
  }
  
  public static int[] p_getFile_int(int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length < paramInt3 >> 2)) {
      paramArrayOfInt = new int[paramInt3 >> 2];
    }
    byte[] arrayOfByte = p_getFile_byte(paramInt1, paramInt2, paramInt3, null);
    for (int i = 0; i < paramInt3; i += 4) {
      paramArrayOfInt[(i >> 2)] = (((0xFF & arrayOfByte[(i + 0)]) << 24) + ((0xFF & arrayOfByte[(i + 1)]) << 16) + ((0xFF & arrayOfByte[(i + 2)]) << 8) + (0xFF & arrayOfByte[(i + 3)]));
    }
    return paramArrayOfInt;
  }
  
  public static short[] p_getFile_short(int paramInt1, int paramInt2, int paramInt3, short[] paramArrayOfShort)
  {
    if ((paramArrayOfShort == null) || (paramArrayOfShort.length < paramInt3 >> 1)) {
      paramArrayOfShort = new short[paramInt3 >> 1];
    }
    byte[] arrayOfByte = p_getFile_byte(paramInt1, paramInt2, paramInt3, null);
    for (int i = 0; i < paramInt3; i += 2) {
      paramArrayOfShort[(i >> 1)] = ((short)(((0xFF & arrayOfByte[i]) << 8) + (0xFF & arrayOfByte[(i + 1)])));
    }
    return paramArrayOfShort;
  }
  
  public static Typeface p_getFont(int paramInt)
  {
    switch (paramInt & 0x7F)
    {
    default: 
      return null;
    case 16: 
      return hack_font_sm;
    case 0: 
      return hack_font_b1;
    case 1: 
      return hack_font_b2;
    }
    return hack_font_b3;
  }
  
  public static int p_getTransImageNum(int paramInt1, int paramInt2)
  {
    int i = p_indexTable2[(paramInt1 + 145)];
    if (paramInt2 != 0)
    {
      int j;
      do
      {
        j = p_gfx_typetable_fake[i];
        if (j == 15) {
          break;
        }
        i++;
      } while (j != paramInt2);
      return i;
    }
    return i;
  }
  
  public static byte[] p_getvideoFile_byte(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < paramInt3)) {
      paramArrayOfByte = new byte[paramInt3];
    }
    try
    {
      data_openFile("v" + paramInt1, paramInt2);
      data_readToByteArray(0, paramInt3, paramArrayOfByte);
      data_closeFile();
      return paramArrayOfByte;
    }
    catch (Exception localException) {}
    return paramArrayOfByte;
  }
  
  public static String p_hs_browserlaunch_getUploadURL()
  {
    String str1 = hs_browserlaunch_getScoreParameters();
    if (str1 != null)
    {
      String str2 = "i" + uid_getId() + "_o" + "1" + "_";
      int i = stringSimpleHash(str2 + str1);
      return "http://www.doodle-jump.com/H_ANDLGGT540/?request=" + p_hs_encode(new StringBuilder().append(str2).append(str1).append("_z").append(i).toString());
    }
    return null;
  }
  
  public static void p_hs_browserlaunch_init()
  {
    p_hs_userId = null;
  }
  
  public static String p_hs_encode(String paramString)
  {
    return p_hs_rotUriSafeChars(paramString, 27);
  }
  
  public static void p_hs_reset(int paramInt)
  {
    if (hs_data_int == null)
    {
      hs_data_int = new int[50];
      hs_data_string = new String[20];
    }
    hs_currentTable = paramInt;
    for (int i = 0; i < 10; i++)
    {
      hs_data_int[(i + 10)] = (i + 1);
      hs_data_int[i] = game_hs_defaultscore(paramInt, i);
      hs_data_int[(i + 20)] = game_hs_defaultextra(paramInt, i);
      hs_data_string[i] = game_hs_defaultname(paramInt, i);
      hs_data_int[(i + 40)] = 0;
      hs_data_int[(i + 30)] = ((int)(System.currentTimeMillis() / 1000L));
      hs_data_string[(i + 10)] = "";
    }
    hs_save();
  }
  
  public static void p_hs_resetAll()
  {
    int i = hs_currentTable;
    for (int j = 0; j < 2; j++) {
      p_hs_reset(j);
    }
    hs_currentTable = i;
  }
  
  public static char p_hs_rotUriSafeChar(char paramChar, int paramInt, String paramString)
  {
    int i = paramString.indexOf(paramChar);
    if (i == -1) {
      return paramChar;
    }
    int j = paramString.length();
    int k = i + (1 + paramInt % (j - 1));
    if (k >= j) {
      k -= j;
    }
    return paramString.charAt(k);
  }
  
  public static String p_hs_rotUriSafeChars(String paramString, int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    for (int i = 0; i < paramString.length(); i++) {
      localStringBuffer.append(p_hs_rotUriSafeChar(paramString.charAt(i), paramInt, "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz-_.!~*'()"));
    }
    return localStringBuffer.toString();
  }
  
  public static void p_loadIndexTables()
  {
    try
    {
      data_openFile("i", 0L);
      p_indexTable1 = new byte[28];
      data_readToByteArray(0, 28, p_indexTable1);
      p_indexTable2 = new short['Ƹ'];
      for (int i = 0; i < 440; i++) {
        p_indexTable2[i] = p_currentFile.readShort();
      }
      p_indexTable3 = new int[' '];
      for (int j = 0; j < 160; j++) {
        p_indexTable3[j] = p_currentFile.readInt();
      }
      data_closeFile();
      return;
    }
    catch (Exception localException) {}
  }
  
  public static void p_loadMain()
  {
    if (mainTextLoaded) {
      return;
    }
    p_sfx_preinit();
    mrp_initTime();
    p_loadOptions();
    sfx_loadGroup(0);
    p_cal_timezoneTemp = -1;
    p_eg_init();
    menu_preinit();
    game_preinit();
    txt_loadGroup(0);
    mainTextLoaded = true;
    gfx_loadGroup(0);
    p_mainGroupsLoaded = true;
  }
  
  public static void p_loadOptions()
  {
    p_options = mrg_loadData("ropt");
    if ((p_options == null) || (p_options.length != 6))
    {
      if (p_options != null) {
        p_options = null;
      }
      p_options = new byte[6];
      for (int i = 0; i < 6; i++) {
        p_options[i] = 0;
      }
      p_options[0] = 1;
      p_options[1] = 1;
      p_options[2] = 1;
    }
    p_options[0] = 0;
  }
  
  public static boolean p_makeModifiedImage(int paramInt)
    throws Exception
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 4: 
      p_flip(true, false);
      return false;
    case 5: 
      p_flip(false, true);
      return false;
    case 2: 
      p_flip(true, true);
      return false;
    case 1: 
      p_rotate(true, false);
      return true;
    case 3: 
      p_rotate(false, true);
      return true;
    case 6: 
      p_rotate(false, false);
      return true;
    }
    p_rotate(true, true);
    return true;
  }
  
  public static int p_menu_createMultiplayerEndGameMenu()
  {
    int i = dynamic_Y_RES >> 10;
    int j = dynamic_X_RES >> 4;
    (gfx_getFontHeight(0) << 1);
    int k = i + 8;
    int m = -1;
    eg_setArea(0, 0, dynamic_X_RES, dynamic_Y_RES);
    eg_setVerticalMenuMode(true);
    eg_setFocus(1004);
    if (multiplayer_player < multiplayer_maxplayers) {
      menu_addTextButton(1006, p_allTexts[41], 17, 17, 0, k);
    }
    for (;;)
    {
      int n = k + 48;
      menu_addTextButton(1004, p_allTexts[36], 17, 17, 0, n);
      menu_createMultiplayerScoresTB(j, n + 48);
      return m;
      menu_addTextButton(22, p_allTexts[56], 17, 17, 0, k);
      m = 22;
    }
  }
  
  public static void p_menu_createSingleplayerEndGameMenu()
  {
    int i = dynamic_Y_RES >> 10;
    (dynamic_X_RES >> 4);
    (gfx_getFontHeight(0) << 1);
    eg_setArea(0, 0, dynamic_X_RES, dynamic_Y_RES);
    menu_addTextButton(1004, p_allTexts[36], 17, 17, 0, i + 8);
    int j = i + 48;
    menu_addTextButton(1005, p_allTexts[37], 17, 17, 0, j + 8);
  }
  
  public static void p_menu_drawSoftKeysAtBottom(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    int k;
    if (paramInt1 >= 0)
    {
      k = 53 + gfx_stringWidth(0, p_allTexts[paramInt1]);
      if (k < 106) {
        k = 106;
      }
      if (paramInt1 != 17) {
        break label107;
      }
      gfx_drawImage(104, dynamic_X_RES >> 4, dynamic_Y_RES, 36, 0);
    }
    int i;
    for (;;)
    {
      if (paramInt2 >= 0)
      {
        i = 53 + gfx_stringWidth(0, p_allTexts[paramInt2]);
        if (i < 106) {
          i = 106;
        }
        if (paramInt2 != 17) {
          break;
        }
        gfx_drawImage(104, dynamic_X_RES - (dynamic_X_RES >> 4), dynamic_Y_RES, 40, 0);
      }
      return;
      label107:
      int m = dynamic_Y_RES - gfx_getFontHeight(0) - (dynamic_X_RES >> 5);
      menu_buttonPaint(p_allTexts[paramInt1], 0, m, k, gfx_getFontHeight(0) + (dynamic_Y_RES >> 6), paramBoolean1);
    }
    int j = dynamic_Y_RES - gfx_getFontHeight(0) - (dynamic_X_RES >> 5);
    menu_buttonPaint(p_allTexts[paramInt2], dynamic_X_RES - i - 1, j, i, gfx_getFontHeight(0) + (dynamic_Y_RES >> 6), paramBoolean2);
  }
  
  public static void p_menu_drawSoftKeysAtRight(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    if (paramInt1 >= 0)
    {
      if (paramInt1 != 17) {
        break label59;
      }
      gfx_drawImage(104, dynamic_X_RES - (dynamic_X_RES >> 4), dynamic_Y_RES, 40, 0);
    }
    for (;;)
    {
      if (paramInt2 >= 0)
      {
        if (paramInt2 != 17) {
          break;
        }
        gfx_drawImage(104, dynamic_X_RES - (dynamic_X_RES >> 4), 0, 24, 0);
      }
      return;
      label59:
      int k = 53 + gfx_stringWidth(0, p_allTexts[paramInt1]);
      int m = dynamic_X_RES - k;
      int n = dynamic_Y_RES - 40;
      menu_buttonPaint(p_allTexts[paramInt1], m, n, k, gfx_getFontHeight(0), paramBoolean1);
    }
    int i = 53 + gfx_stringWidth(0, p_allTexts[paramInt2]);
    int j = dynamic_X_RES - i;
    menu_buttonPaint(p_allTexts[paramInt2], j, 0, i, gfx_getFontHeight(0), paramBoolean2);
  }
  
  public static void p_p_loadGlobalPalettes()
  {
    if (p_gp_loaded) {
      return;
    }
    for (;;)
    {
      int j;
      try
      {
        data_openFile("p", 0L);
        int i = p_currentFile.readUnsignedByte();
        p_globalPalettes = new short[i][];
        j = 0;
        if (j < i)
        {
          int k = p_currentFile.readUnsignedByte();
          p_globalPalettes[j] = new short[k];
          int m = 1;
          if (m < k)
          {
            p_globalPalettes[j][m] = p_currentFile.readShort();
            m++;
            continue;
          }
        }
        else
        {
          p_gp_loaded = true;
          return;
        }
      }
      catch (Exception localException)
      {
        return;
      }
      j++;
    }
  }
  
  public static void p_platforms_drawRegularPlatformWithGfx(int paramInt)
  {
    int i = platforms_fp_width >> 11;
    int j = 15;
    int k = 16;
    int m = 17;
    if ((0x5 & platforms_array[paramInt].id) == 5)
    {
      j = 58;
      k = 59;
      m = 60;
    }
    for (;;)
    {
      int n = i - gfx_getImageWidth(j) - gfx_getImageWidth(m);
      int i1 = 0;
      if (n < 0)
      {
        i1 = n;
        n = 0;
      }
      int i2 = doj_worldToScreenX(platforms_array[paramInt].fp_x) - (platforms_fp_width >> 11 >> 1);
      int i3 = doj_worldToScreenY(platforms_array[paramInt].fp_y - doj_fp_screenYOffset);
      gfx_drawImage(j, i2, i3, 20, 0);
      int i4 = i2 + gfx_getImageWidth(j);
      platform_fillHorizontal(k, i4, i3, n);
      gfx_drawImage(m, i4 + (n + i1), i3, 20, 0);
      return;
      if ((0x2 & platforms_array[paramInt].id) == 2)
      {
        j = 61;
        k = 62;
        m = 63;
      }
      else if ((0x100 & platforms_array[paramInt].id) == 256)
      {
        j = 64;
        k = 65;
        m = 66;
      }
      else if ((0x200 & platforms_array[paramInt].id) == 512)
      {
        j = 67;
        k = 68;
        m = 69;
      }
      else if ((0x400 & platforms_array[paramInt].id) == 1024)
      {
        j = 70;
        k = 71;
        m = 72;
      }
      else if ((0x800 & platforms_array[paramInt].id) == 2048)
      {
        j = 73;
        k = 74;
        m = 75;
      }
      else if ((0x1000 & platforms_array[paramInt].id) == 4096)
      {
        j = 76;
        k = 77;
        m = 78;
      }
      else if ((0x2000 & platforms_array[paramInt].id) == 8192)
      {
        j = 79;
        k = 80;
        m = 81;
      }
      else if ((0x4000 & platforms_array[paramInt].id) == 16384)
      {
        j = 82;
        k = 83;
        m = 84;
      }
      else if ((0x8000 & platforms_array[paramInt].id) == 32768)
      {
        j = 85;
        k = 86;
        m = 87;
      }
    }
  }
  
  public static int p_projectiles_indexInArea(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = fp_div(22528, common_fp_xRatio);
    int j = fp_div(22528, common_fp_yRatio);
    int k = paramInt1 - (paramInt3 >> 1) - (i >> 1);
    int m = paramInt1 + (paramInt3 >> 1) + (i >> 1);
    int n = paramInt2 - (paramInt4 >> 1) - (j >> 1);
    int i1 = paramInt2 + (paramInt4 >> 1) + (j >> 1);
    for (int i2 = 0; i2 < projectiles_count; i2++) {
      if ((projectiles_array[i2].fp_pos_x > k) && (projectiles_array[i2].fp_pos_x < m) && (projectiles_array[i2].fp_pos_y > n) && (projectiles_array[i2].fp_pos_y < i1)) {
        return i2;
      }
    }
    return -1;
  }
  
  public static void p_projectiles_remove(int paramInt)
  {
    for (int i = paramInt; i < projectiles_count - 1; i++)
    {
      projectiles_array[i].fp_pos_x = projectiles_array[(i + 1)].fp_pos_x;
      projectiles_array[i].fp_pos_y = projectiles_array[(i + 1)].fp_pos_y;
      projectiles_array[i].fp_vel_x = projectiles_array[(i + 1)].fp_vel_x;
      projectiles_array[i].fp_vel_y = projectiles_array[(i + 1)].fp_vel_y;
    }
    projectiles_count -= 1;
  }
  
  public static void p_realPaint()
  {
    repaintAll = true;
    if (repaintAll) {
      gfx_setClip(0, 0, dynamic_X_RES, dynamic_Y_RES);
    }
    p_eg_guiPainted = false;
    if (p_forcedPaint) {
      if (p_lb_fillScreen)
      {
        String str = p_allTexts[19];
        for (int i = 0; i < 1 + p_loadingBoxCounter % 3; i++) {
          str = str + ".";
        }
        p_loadingBoxCounter = 1 + p_loadingBoxCounter;
        int j = gfx_stringWidth(0, p_allTexts[19] + "...");
        int k = j + (j >> 2);
        int m = (dynamic_Y_RES >> 1) - (28 >> 1) - 28;
        gfx_setColor(0);
        gfx_fillRect((dynamic_X_RES >> 1) - (k >> 1) - 1, m + 2, k, 28 << 1);
        gfx_setColor(7829367);
        gfx_fillRect((dynamic_X_RES >> 1) - (k >> 1), m, k, 28 << 1);
        gfx_setColor(16777215);
        gfx_drawRect((dynamic_X_RES >> 1) - (k >> 1), m, k, 28 << 1);
        gfx_drawString(0, str, (dynamic_X_RES >> 1) - (gfx_stringWidth(0, p_allTexts[19] + "...") >> 1), dynamic_Y_RES >> 1, 36);
        p_lb_fillScreen = false;
      }
    }
    for (;;)
    {
      if (!p_eg_guiPainted) {
        p_eg_paint();
      }
      return;
      game_forcedPaint();
      continue;
      if (!p_gameDisplay) {
        menu_paint();
      } else {
        game_paint();
      }
    }
  }
  
  public static void p_resetRecordStore()
  {
    try
    {
      String[] arrayOfString = p_mrgame.fileList();
      if (arrayOfString.length > 0) {
        for (int i = 0; i < arrayOfString.length; i++)
        {
          boolean bool = p_mrgame.deleteFile(arrayOfString[i]);
          if (bool) {}
        }
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static void p_resumeClip()
  {
    p_activeGraphics.clipRect(p_clip_x, p_clip_y, p_clip_x + p_clip_width, p_clip_y + p_clip_height, Region.Op.REPLACE);
  }
  
  public static void p_rotate(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = p_riYres;
    int j = 1 + -p_riXres * p_riYres;
    int k = 0;
    int m;
    if ((paramBoolean1) && (paramBoolean2))
    {
      i = -p_riYres;
      j = p_riYres * p_riXres - 1;
      m = 0 + (p_riXres * p_riYres - 1);
    }
    for (int n = 0;; n++)
    {
      if (n >= p_riYres) {
        return;
      }
      int i1 = 0;
      for (;;)
      {
        if (i1 < p_riXres)
        {
          p_riDestImage[m] = p_tempImage2[k];
          m += i;
          k++;
          i1++;
          continue;
          if (paramBoolean1)
          {
            j = -p_riYres * p_riXres - 1;
            m = 0 + (p_riYres - 1);
            break;
          }
          m = 0;
          if (!paramBoolean2) {
            break;
          }
          j = 1 + p_riYres * p_riXres;
          i = -p_riYres;
          m = 0 + p_riYres * (p_riXres - 1);
          break;
        }
      }
      m += j;
    }
  }
  
  public static void p_runKeyEvents()
  {
    int i;
    label16:
    int j;
    if (p_pointer_moved2)
    {
      p_pointer_moved2 = false;
      p_pointer_moved = true;
      i = 0;
      if (i >= p_keyCounter) {
        break label226;
      }
      j = p_keyBuffer[i];
      if (p_keyTypeBuffer[i] == 0) {
        break label155;
      }
      p_keys[j] = true;
      if ((p_tb_inputHandleFlags == 0) || ((p_tb_inputHandleFlags != 0) && (!p_tb_keyPressed(j))))
      {
        p_eg_eventRegistered = false;
        p_eg_pressEventRegistered = false;
        if (p_eg_pressingGuiSoftkey) {
          break label128;
        }
        if (!mrg_isKey(j, 350)) {
          break label121;
        }
        p_eg_pointerPressed();
        label89:
        if ((!p_eg_eventRegistered) || ((p_eg_focusElement == -1) && (!p_eg_pressEventRegistered))) {
          break label135;
        }
      }
    }
    for (;;)
    {
      i++;
      break label16;
      p_pointer_moved = false;
      break;
      label121:
      p_eg_keyPressed(j);
      break label89;
      label128:
      p_eg_pressingGuiSoftkey = false;
      break label89;
      label135:
      if (!p_gameDisplay)
      {
        menu_keyPressed(j);
      }
      else
      {
        game_keyPressed(j);
        continue;
        label155:
        if (p_keys[j] != 0)
        {
          p_keys[j] = false;
          p_eg_eventRegistered = false;
          if (mrg_isKey(j, 350)) {
            p_eg_pointerReleased();
          }
          for (;;)
          {
            if ((p_eg_eventRegistered) && (p_eg_focusElement != -1)) {
              break label217;
            }
            if (p_gameDisplay) {
              break label219;
            }
            menu_keyReleased(j);
            break;
            p_eg_keyReleased(j);
          }
          label217:
          continue;
          label219:
          game_keyReleased(j);
        }
      }
    }
    label226:
    p_keyCounter = 0;
  }
  
  public static void p_setFont(Canvas paramCanvas, int paramInt)
  {
    int i = paramInt & 0x7F;
    if ((p_fonts_activeGraphics == paramCanvas) && (p_fonts_activeFrame == frameNum) && (p_fonts_activeFont == i)) {
      return;
    }
    p_fonts_activeGraphics = paramCanvas;
    p_fonts_activeFrame = frameNum;
    p_fonts_activeFont = i;
    Typeface localTypeface = p_getFont(i);
    p_gfx_paint.setTypeface(localTypeface);
  }
  
  public static void p_setSubClip(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    p_activeGraphics.clipRect(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4, Region.Op.INTERSECT);
  }
  
  public static void p_sfx_free()
  {
    soundPool.release();
    p_sounds = null;
    p_realsounds = null;
    p_streams = null;
    p_soundResumePosition = null;
  }
  
  public static void p_sfx_preinit()
  {
    if (preinit_done) {
      return;
    }
    VC_defaultVolume = 16;
    p_sounds = new int[23];
    p_realsounds = new int[23];
    p_realsounds_streamID = new int[23];
    p_soundResumePosition = new long[23];
    p_streams = new int[8];
    p_streamPriority = new int[8];
    p_stream_startTime = new long[8];
    p_stream_playLength = new long[8];
    p_stream_loopCount = new int[8];
    for (int i = 0; i < 23; i++)
    {
      p_sounds[i] = 0;
      p_realsounds[i] = 65280;
      p_realsounds_streamID[i] = 0;
      p_soundResumePosition[i] = 0L;
    }
    for (int j = 0; j < 8; j++)
    {
      p_streams[j] = 65281;
      p_streamPriority[j] = 0;
      p_stream_loopCount[j] = 0;
      p_stream_startTime[j] = 0L;
      p_stream_playLength[j] = 0L;
    }
    p_lastFreeStream = 0;
    soundPool = new SoundPool(18, 3, 40);
    soundPoolMap = new HashMap();
    Field[] arrayOfField = R.raw.class.getFields();
    int k = arrayOfField.length;
    int m = 0;
    for (;;)
    {
      Field localField;
      int n;
      if (m < k)
      {
        localField = arrayOfField[m];
        if ((localField.getName().length() > 3) && (localField.getName().substring(0, 4).equals("sfx_"))) {
          n = Integer.valueOf(localField.getName().substring(4)).intValue();
        }
      }
      try
      {
        p_sounds[n] = localField.getInt(null);
        m++;
        continue;
        preinit_done = true;
        return;
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
  }
  
  public static void p_tb2_make(int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2)
  {
    p_tbCurrentLine = 0;
    p_tb_realLineCount = 0;
    p_tb_scroll = 0;
    p_tb_initSmoothScroll(0, 0);
    int i = (int)System.currentTimeMillis();
    tb_loadFinished = false;
    if (paramBoolean1)
    {
      p_tbBackupId = paramInt1;
      p_tbBackupFont = paramInt2;
      p_tbBackupWidth = paramInt3;
      p_tbBackupHeight = paramInt4;
      p_tbBackupString = paramString;
      p_tbBackupEmulateOld = paramBoolean2;
    }
    p_tb_currenBoxId = paramInt1;
    p_tb_oldBehavior = paramBoolean2;
    p_tb_text = null;
    p_tb_text = paramString;
    p_tb_boxSizeHeight = paramInt4;
    p_tb_stuffCount = 0;
    p_tb_lineCount = 0;
    p_tbMaxLineWidth = 0;
    p_tb_lastVisibleLine = -1;
    int j = gfx_getFontHeight(paramInt2);
    int k = gfx_stringWidth(paramInt2, " ");
    int m;
    int n;
    int i1;
    int i2;
    int i4;
    int i5;
    int i6;
    int i7;
    int i8;
    int i9;
    int i10;
    int i11;
    int i12;
    int i13;
    int i14;
    int i15;
    int i16;
    int i17;
    int i18;
    int i19;
    int i20;
    int i21;
    int i22;
    int i23;
    int i24;
    int i25;
    int i26;
    int i27;
    int i31;
    int i32;
    int i33;
    int i155;
    int i156;
    int i157;
    int i158;
    int i159;
    label395:
    label412:
    int i172;
    int i58;
    int i160;
    int i42;
    int i161;
    label524:
    int i162;
    int i163;
    int i39;
    int i169;
    label665:
    int i41;
    int i38;
    int i51;
    int i37;
    int i59;
    int i57;
    int i55;
    int i53;
    int i56;
    int i43;
    int i45;
    int i48;
    int i50;
    int i36;
    int i40;
    int i44;
    int i46;
    int i47;
    int i49;
    int i52;
    label759:
    int i85;
    if (paramBoolean2)
    {
      m = 2;
      p_tb_lines[0] = 0;
      n = 0;
      i1 = 0;
      i2 = 0;
      int i3 = m;
      i4 = paramString.length();
      i5 = 0;
      i6 = k;
      i7 = 0;
      i8 = 0;
      i9 = 0;
      i10 = 0;
      i11 = paramInt3;
      i12 = i3;
      i13 = 1;
      i14 = 0;
      i15 = 0;
      i16 = 0;
      i17 = 0;
      i18 = 0;
      i19 = paramInt3;
      i20 = j;
      i21 = i;
      i22 = 0;
      i23 = 0;
      i24 = 0;
      i25 = -1;
      i26 = 0;
      i27 = 0;
      if (i26 >= i4) {
        break label3875;
      }
      if (((p_inGame) && ((p_gameDisplay) || (!p_inGame))) || ((int)(System.currentTimeMillis() - i21) <= 250) || (0 != 0)) {
        break label3868;
      }
      mrg_drawLoadingBox();
      i31 = (int)System.currentTimeMillis();
      i32 = paramString.charAt(i26);
      i33 = i26 + 1;
      switch (i32)
      {
      default: 
        i155 = i33 - 1;
        i156 = i155;
        i157 = -1;
        i158 = i11 - i22;
        i159 = i19 - i16;
        if (i155 > i4) {
          break label3435;
        }
        if (i155 == i4)
        {
          i32 = -1;
          if ((i32 != 32) && (i32 != 10) && (i32 != 9) && ((i32 < 19) || (i32 > 28)) && (i32 != -1)) {
            break label2569;
          }
          String str1 = paramString.substring(i156, i155);
          i172 = gfx_stringWidth(paramInt2, str1);
          if (i172 <= i158) {
            break label2477;
          }
          if (i157 < 0) {
            break label2292;
          }
          i155 = i157;
          if ((i32 != 32) || (i172 - i5 >= i159)) {
            break label3435;
          }
          i58 = 0;
          i160 = i155;
          i42 = i5;
          i161 = 1;
          if (i58 != 0) {
            break label3339;
          }
          i162 = i22;
          i163 = i22 + i42;
          short[] arrayOfShort15 = p_tb_stuff;
          int i164 = i9 + 1;
          arrayOfShort15[i9] = ((short)i156);
          short[] arrayOfShort16 = p_tb_stuff;
          int i165 = i164 + 1;
          arrayOfShort16[i164] = ((short)(i160 - i156));
          short[] arrayOfShort17 = p_tb_stuff;
          int i166 = i165 + 1;
          arrayOfShort17[i165] = ((short)i162);
          short[] arrayOfShort18 = p_tb_stuff;
          int i167 = i166 + 1;
          arrayOfShort18[i166] = ((short)i7);
          short[] arrayOfShort19 = p_tb_stuff;
          int i168 = i167 + 1;
          arrayOfShort19[i167] = ((short)i42);
          short[] arrayOfShort20 = p_tb_stuff;
          i39 = i168 + 1;
          arrayOfShort20[i168] = ((short)i20);
          if (i161 == 0) {
            break label3332;
          }
          i169 = 1;
          if (i23 >= i20) {
            break label3242;
          }
          int i171 = i20;
          i41 = i163;
          i58 = i169;
          i38 = i7;
          i51 = i11;
          i37 = i171;
          i59 = 0;
          i57 = i27;
          i55 = i20;
          i53 = i162;
          i56 = i160;
          i43 = i18;
          i45 = i25;
          i48 = i17;
          i50 = i163;
          i36 = i19;
          i40 = i16;
          i44 = i24;
          i46 = i13;
          i47 = i10;
          i49 = i12;
          i52 = i6;
          if (i56 == i4) {
            i58 = 1;
          }
          if ((i57 == 0) && (i58 == 0)) {
            break label3227;
          }
          if (p_tbMaxLineWidth < i41) {
            p_tbMaxLineWidth = i41;
          }
          if (m == 0) {
            break label2758;
          }
          i85 = i51 - i50;
          if (m == 2) {
            i85 = (i85 + 1) / 2;
          }
        }
        break;
      }
    }
    int i98;
    int i101;
    int i135;
    int i136;
    int i140;
    int i141;
    label1087:
    int i103;
    int i105;
    int i106;
    int i111;
    int i102;
    int i110;
    int i109;
    int i108;
    int i104;
    label1156:
    int i112;
    int i113;
    int i114;
    label1204:
    int i124;
    int i125;
    label1402:
    int i121;
    int i123;
    int i147;
    int i148;
    int i94;
    label1993:
    int i91;
    int i92;
    label2121:
    int i34;
    int i35;
    label2257:
    label2292:
    int i179;
    int i180;
    int i181;
    for (;;)
    {
      if (i1 >= i39) {
        break label2581;
      }
      if (p_tb_stuff[i1] >= 0)
      {
        short[] arrayOfShort4 = p_tb_stuff;
        int i89 = i1 + 2;
        arrayOfShort4[i89] = ((short)(i85 + arrayOfShort4[i89]));
        i1 += 6;
        continue;
        m = 0;
        break;
        int i95 = i33 - 1;
        int i96 = 0;
        int i97 = i33;
        while (paramString.charAt(i97) != ':')
        {
          int i154 = i96 * 10 + (paramString.charAt(i97) - '0');
          i97++;
          i96 = i154;
        }
        i98 = i97 + 1;
        int i100;
        int i117;
        if ((i32 == 25) || (i32 == 28))
        {
          int i99 = tbi_getImageSize(paramInt1, i96);
          i100 = 0xFFFF & i99 >> 16;
          i101 = 0xFFFF & i99;
          if (i32 == 25)
          {
            i135 = i22;
            i136 = i22 + i100;
            if ((i136 <= i11) || (paramInt3 < i100))
            {
              short[] arrayOfShort9 = p_tb_images;
              int i137 = i24 + 1;
              arrayOfShort9[i24] = ((short)i96);
              short[] arrayOfShort10 = p_tb_images;
              int i138 = i137 + 1;
              arrayOfShort10[i137] = ((short)i135);
              short[] arrayOfShort11 = p_tb_images;
              int i139 = i138 + 1;
              arrayOfShort11[i138] = ((short)i7);
              short[] arrayOfShort12 = p_tb_images;
              i140 = i139 + 1;
              arrayOfShort12[i139] = ((short)i101);
              if (i23 >= i101) {
                break label3861;
              }
              i141 = i101;
              if (i98 != i4) {
                break label3796;
              }
              i41 = i136;
              i103 = 0;
              i37 = i141;
              i46 = i13;
              i105 = i11;
              i106 = i135;
              int i144 = i16;
              i111 = i136;
              i102 = i98;
              i110 = i19;
              i40 = i144;
              int i145 = i10;
              i109 = 1;
              i108 = i145;
              i45 = i25;
              i104 = i140;
              i112 = i6;
              i113 = i106;
              i114 = i9;
              i36 = i110;
              i43 = i101;
              int i115 = i111;
              i44 = i104;
              i48 = i100;
              i50 = i115;
              int i116 = i102;
              i117 = i20;
              i56 = i116;
            }
          }
        }
        for (;;)
        {
          i38 = i7;
          i53 = i113;
          i42 = i5;
          int i118 = i27;
          i55 = i117;
          i57 = i118;
          int i119 = i103;
          i58 = i109;
          i49 = i12;
          i52 = i112;
          i39 = i114;
          i59 = i119;
          int i120 = i108;
          i51 = i105;
          i47 = i120;
          break;
          i102 = i95;
          int i146 = i136 - i100;
          i37 = i23;
          i41 = i146;
          i110 = i19;
          i40 = i16;
          i111 = i14;
          i108 = i10;
          i109 = 1;
          i45 = i25;
          i104 = i24;
          i46 = i13;
          i105 = i11;
          i106 = i135;
          i103 = 0;
          break label1156;
          if (i22 == 0)
          {
            switch (m)
            {
            default: 
              i124 = i19;
              i103 = 0;
              i109 = 0;
              i37 = i23;
              i40 = i16;
              i41 = i22;
              i125 = i13;
              i105 = i11;
              i106 = i8;
            case 0: 
            case 1: 
              for (;;)
              {
                i2 = i41;
                i45 = 2 + (i7 + i101);
                short[] arrayOfShort5 = p_tb_images;
                int i126 = i24 + 1;
                arrayOfShort5[i24] = ((short)i96);
                short[] arrayOfShort6 = p_tb_images;
                int i127 = i126 + 1;
                arrayOfShort6[i126] = ((short)i106);
                short[] arrayOfShort7 = p_tb_images;
                int i128 = i127 + 1;
                arrayOfShort7[i127] = ((short)i7);
                short[] arrayOfShort8 = p_tb_images;
                i104 = i128 + 1;
                arrayOfShort8[i128] = ((short)i101);
                int i129 = i104;
                n = i104;
                int i130 = i14;
                i108 = i129;
                i46 = i125;
                i111 = i130;
                int i131 = i124;
                i102 = i98;
                i110 = i131;
                break;
                int i134 = i100 + 0;
                i125 = i13;
                i37 = i23;
                i105 = i11;
                i41 = i134;
                i124 = i19;
                i40 = i134;
                i109 = 0;
                i103 = 0;
                i106 = 0;
                continue;
                int i132 = paramInt3 - i100;
                int i133 = i132 - 0;
                i40 = i16;
                i37 = i23;
                i106 = i132;
                i125 = i13;
                i41 = i22;
                i124 = i133;
                i105 = i133;
                i109 = 0;
                i103 = 0;
              }
            }
            i121 = (paramInt3 - i100) / 2;
            int i122 = i20;
            i123 = i13;
            while (i122 < i101)
            {
              p_tb_lines[i123] = ((short)(i7 + i122));
              ???++;
              i122 += i20;
            }
          }
          i102 = i95;
          i103 = 1;
          i37 = i23;
          i45 = i25;
          i41 = i22;
          i104 = i24;
          i46 = i13;
          i105 = i11;
          i106 = i8;
          int i107 = i14;
          i108 = i10;
          i109 = 1;
          i110 = i19;
          i40 = i16;
          i111 = i107;
          break label1156;
          if (i32 == 27)
          {
            short[] arrayOfShort14 = p_tb_stuff;
            int i153 = i9 + 1;
            arrayOfShort14[i9] = ((short)-(16383 + (i96 + 1)));
            i36 = i19;
            i37 = i23;
            i40 = i16;
            i41 = i22;
            i44 = i24;
            i112 = i6;
            i46 = i13;
            i105 = i11;
            i114 = i153;
            i117 = i20;
            i56 = i98;
            i43 = i18;
            i45 = i25;
            i48 = i17;
            i50 = i14;
            i108 = i10;
            i113 = i8;
            i109 = 0;
            i103 = 0;
          }
          else
          {
            short[] arrayOfShort13 = p_tb_stuff;
            i147 = i9 + 1;
            arrayOfShort13[i9] = ((short)-(i96 + 1));
            paramInt2 = tbi_getFont(paramInt1, i96);
            i148 = gfx_stringWidth(paramInt2, " ");
            i117 = gfx_getFontHeight(paramInt2);
            if (i22 != i2) {
              break label3678;
            }
            int i151 = i117;
            i41 = i22;
            i112 = i148;
            i37 = i151;
            i56 = i98;
            i43 = i18;
            i45 = i25;
            i48 = i17;
            i50 = i14;
            i108 = i10;
            i113 = i8;
            int i152 = i13;
            i105 = i11;
            i114 = i147;
            i36 = i19;
            i40 = i16;
            i44 = i24;
            i46 = i152;
            i109 = 0;
            i103 = 0;
          }
        }
        int i93 = i25 - i23;
        if (i7 >= i93) {
          break label3671;
        }
        i94 = i25 - i23;
        i42 = i5;
        i58 = 1;
        i38 = i94;
        i53 = i8;
        i36 = i19;
        i37 = i23;
        i40 = i16;
        i41 = i22;
        i44 = i24;
        i39 = i9;
        i46 = i13;
        i47 = i10;
        i49 = i12;
        i52 = i6;
        i48 = i17;
        i50 = i14;
        i51 = i11;
        i59 = 1;
        i57 = i27;
        i55 = i20;
        i56 = i33;
        i43 = i18;
        i45 = -1;
        break label759;
        i91 = i32 - 20;
        if ((!paramBoolean2) || (m != 1) || (i91 != 0) || (i22 <= i2)) {
          break label3665;
        }
        i92 = 1;
        if ((m != 2) || (i91 == 2) || (i22 <= i2)) {
          break label3569;
        }
        i42 = i5;
        i58 = 1;
        i37 = i23;
        i52 = i6;
        i38 = i7;
        i36 = i19;
        i41 = i22;
        i40 = i16;
        i39 = i9;
        i44 = i24;
        i46 = i13;
        i47 = i10;
        i49 = i91;
        i55 = i20;
        i56 = i33;
        i43 = i18;
        i45 = i25;
        i48 = i17;
        i50 = i14;
        i51 = i11;
        i53 = i8;
        i57 = 1;
        i59 = 0;
        break label759;
        if (i22 <= i2) {
          break label3558;
        }
        int i90 = i22 + i6;
        i34 = i33;
        i35 = i90;
        while ((i34 < i4) && (paramString.charAt(i34) == ' ')) {
          i34++;
        }
        i32 = paramString.charAt(i155);
        break label412;
        if ((i158 < i159) && (i172 < i159))
        {
          i42 = i5;
          i58 = 1;
          i160 = i156;
          i161 = 0;
          break label524;
        }
        int i175 = i156 + 1;
        String str3 = paramString.substring(i156, i175);
        int i176 = gfx_stringWidth(paramInt2, str3);
        int i177 = i176;
        while (i176 < i158)
        {
          ???++;
          i177 = i176;
          String str5 = paramString.substring(i156, i175);
          i176 = gfx_stringWidth(paramInt2, str5);
        }
        int i178 = i177;
        i179 = i175 - 1;
        if (i156 != i179) {
          break label3425;
        }
        if (i176 < i159) {
          i180 = i179;
        }
        for (i181 = 1;; i181 = 0)
        {
          label2423:
          i42 = i178;
          i58 = i181;
          i160 = i180;
          i161 = 0;
          break;
          i180 = i179 + 1;
          String str4 = paramString.substring(i156, i180);
          i178 = gfx_stringWidth(paramInt2, str4);
        }
        label2477:
        i157 = i155;
        i5 = i172;
        if (i32 != 32)
        {
          int i173 = i155;
          while (paramString.charAt(i173 - 1) == ' ') {
            ???--;
          }
          String str2;
          if (i173 > i156) {
            str2 = paramString.substring(i156, i173);
          }
          for (int i174 = gfx_stringWidth(paramInt2, str2);; i174 = 0)
          {
            i42 = i174;
            i160 = i173;
            i161 = 0;
            i58 = 0;
            break;
          }
        }
        label2569:
        ???++;
        break label395;
      }
      i1++;
    }
    label2581:
    while (n < i44)
    {
      short[] arrayOfShort3 = p_tb_images;
      int i88 = n + 1;
      arrayOfShort3[i88] = ((short)(i85 + arrayOfShort3[i88]));
      n += 4;
    }
    int i86;
    int i87;
    int i62;
    int i63;
    label2649:
    int i64;
    label2660:
    int i76;
    label2758:
    label2791:
    int i77;
    int i78;
    label2858:
    int i69;
    int i68;
    int i70;
    int i71;
    int i72;
    int i73;
    int i66;
    int i67;
    int i65;
    int i74;
    if (m == 1)
    {
      p_tbMaxLineWidth = i51;
      i86 = i2;
      i87 = i86 + i85;
      i62 = i87;
      i63 = i86;
      i2 = i63;
      i64 = 0;
      m = i49;
      if (i58 != 0) {
        i76 = i15;
      }
    }
    else
    {
      for (;;)
      {
        if (i76 >= i39) {
          break label2791;
        }
        if (p_tb_stuff[i76] >= 0)
        {
          short[] arrayOfShort2 = p_tb_stuff;
          int i84 = i76 + 3;
          arrayOfShort2[i84] = ((short)(arrayOfShort2[i84] + (i37 - p_tb_stuff[(i76 + 5)]) / 2));
          i76 += 6;
          continue;
          if (i49 == 1)
          {
            i86 = i50;
            i87 = i51;
            break;
          }
          i86 = i2;
          i87 = i51 - i50;
          break;
          int i60 = i39;
          int i61 = i44;
          i1 = i60;
          n = i61;
          i62 = i51;
          i63 = i41;
          break label2649;
        }
        i76++;
      }
      while (i47 < i44)
      {
        short[] arrayOfShort1 = p_tb_images;
        int i83 = i47 + 2;
        arrayOfShort1[i83] = ((short)(arrayOfShort1[i83] + (i37 - p_tb_images[(i47 + 3)]) / 2));
        i47 += 4;
      }
      i77 = i38 + i37;
      if (i59 != 0)
      {
        i78 = i77 + 0;
        int i79 = i55;
        int i81;
        int i82;
        if (i78 > i45)
        {
          i81 = paramInt3;
          i82 = 0;
          i69 = 0;
          i68 = paramInt3;
        }
        for (;;)
        {
          i2 = i82;
          i70 = i82;
          p_tb_lines[i46] = ((short)i78);
          i71 = i46 + 1;
          i72 = i79;
          i73 = i76;
          i66 = i47;
          i67 = i81;
          i65 = i82;
          i74 = i78;
          label2928:
          i5 = i42;
          i11 = i67;
          i6 = i52;
          i7 = i74;
          i8 = i53;
          i9 = i39;
          i22 = i65;
          i13 = i71;
          i15 = i73;
          i12 = i49;
          i23 = i72;
          i17 = i48;
          i10 = i66;
          i25 = i45;
          i24 = i44;
          i14 = i70;
          i16 = i69;
          i19 = i68;
          i18 = i43;
          i21 = i31;
          int i75 = i56;
          i20 = i55;
          i27 = i64;
          i26 = i75;
          break;
          int i80 = i40;
          i81 = i36;
          i82 = i80;
          i68 = i36;
          i69 = i40;
        }
      }
    }
    for (;;)
    {
      int i29;
      int i28;
      if (i29 <= i25)
      {
        i29 += i20;
        p_tb_lines[i28] = ((short)i29);
        i28++;
      }
      else
      {
        p_tb_stuffHeight = i29;
        p_tb_stuffCount = i9;
        p_tb_imageCount = i24;
        p_tb_realLineCount = i28;
        if (p_tb_stuffHeight > 0) {}
        for (int i30 = paramInt4 / (p_tb_stuffHeight / p_tb_realLineCount);; i30 = 0)
        {
          p_tb_avgLinesPerPage = i30;
          while (i28 > 1)
          {
            i28--;
            if (p_tb_lines[(p_tb_realLineCount - 1)] - p_tb_lines[(i28 - 1)] > paramInt4) {
              i28++;
            }
          }
          p_tb_lineCount = i28;
          tb_loadFinished = true;
          p_lb_fillScreen = false;
          return;
        }
        i78 = i77;
        break label2858;
        i65 = i63;
        i66 = i47;
        i67 = i62;
        i68 = i36;
        i69 = i40;
        i70 = i50;
        i71 = i46;
        i72 = i37;
        i73 = i15;
        i74 = i38;
        break label2928;
        label3227:
        i64 = i57;
        i62 = i51;
        i63 = i41;
        break label2660;
        label3242:
        i57 = i27;
        i58 = i169;
        i38 = i7;
        i51 = i11;
        i55 = i20;
        i56 = i160;
        i43 = i18;
        i53 = i162;
        i45 = i25;
        i48 = i17;
        i50 = i163;
        i36 = i19;
        i40 = i16;
        i44 = i24;
        i46 = i13;
        i47 = i10;
        i49 = i12;
        i52 = i6;
        int i170 = i23;
        i41 = i163;
        i37 = i170;
        i59 = 0;
        break label759;
        label3332:
        i169 = i58;
        break label665;
        label3339:
        i57 = i27;
        i36 = i19;
        i37 = i23;
        i38 = i7;
        i40 = i16;
        i41 = i22;
        i55 = i20;
        i44 = i24;
        i56 = i160;
        i39 = i9;
        i46 = i13;
        i43 = i18;
        i45 = i25;
        i47 = i10;
        i49 = i12;
        i48 = i17;
        i50 = i14;
        i52 = i6;
        i51 = i11;
        i53 = i8;
        i59 = 0;
        break label759;
        label3425:
        i180 = i179;
        i181 = 0;
        break label2423;
        label3435:
        i42 = i5;
        i160 = i155;
        i161 = 0;
        i58 = 0;
        break label524;
        i36 = i19;
        i37 = i23;
        i38 = i7;
        i39 = i9;
        i40 = i16;
        i41 = i35;
        i42 = i5;
        i43 = i18;
        i44 = i24;
        i45 = i25;
        i46 = i13;
        i47 = i10;
        i48 = i17;
        i49 = i12;
        i50 = i14;
        i51 = i11;
        i52 = i6;
        i53 = i8;
        int i54 = i27;
        i55 = i20;
        i56 = i34;
        i57 = i54;
        i58 = 0;
        i59 = 0;
        break label759;
        label3558:
        i34 = i33;
        i35 = i22;
        break label2257;
        label3569:
        i42 = i5;
        i58 = i92;
        i37 = i23;
        i52 = i6;
        i38 = i7;
        i36 = i19;
        i41 = i22;
        i40 = i16;
        i39 = i9;
        i44 = i24;
        i46 = i13;
        i47 = i10;
        i49 = i91;
        i55 = i20;
        i56 = i33;
        i43 = i18;
        i45 = i25;
        i48 = i17;
        i50 = i14;
        i51 = i11;
        i53 = i8;
        i57 = 1;
        i59 = 0;
        break label759;
        label3665:
        i92 = 0;
        break label2121;
        label3671:
        i94 = i7;
        break label1993;
        label3678:
        i56 = i98;
        i43 = i18;
        i45 = i25;
        i48 = i17;
        i50 = i14;
        i108 = i10;
        i113 = i8;
        int i149 = i22;
        i112 = i148;
        i37 = i23;
        i41 = i149;
        int i150 = i13;
        i105 = i11;
        i114 = i147;
        i36 = i19;
        i40 = i16;
        i44 = i24;
        i46 = i150;
        i109 = 0;
        i103 = 0;
        break label1204;
        i105 = i11;
        i41 = i22;
        i103 = 1;
        i109 = 1;
        i106 = i121;
        i37 = i101;
        i124 = i19;
        i40 = i16;
        i125 = i123;
        break label1402;
        label3796:
        i108 = i10;
        i41 = i136;
        i37 = i141;
        i46 = i13;
        i105 = i11;
        i106 = i135;
        int i142 = i25;
        i104 = i140;
        i45 = i142;
        int i143 = i19;
        i40 = i16;
        i111 = i136;
        i102 = i98;
        i110 = i143;
        i109 = 0;
        i103 = 0;
        break label1156;
        label3861:
        i141 = i23;
        break label1087;
        label3868:
        i31 = i21;
        break;
        label3875:
        i28 = i13;
        i29 = i7;
      }
    }
  }
  
  public static void p_tb_addVelocity(int paramInt)
  {
    p_tb_scrollVelocity = paramInt + p_tb_scrollVelocity;
    p_tb_scrollHeight = 0;
  }
  
  public static boolean p_tb_changeLine(int paramInt)
  {
    if ((paramInt == 4) && ((0x3FF & p_tb_scroll) != 0) && (!p_tb_isScrolling()))
    {
      p_tb_initSmoothScroll(250, -(p_tb_scroll - (p_tb_lines[p_tbCurrentLine] << 10)));
      return true;
    }
    if (paramInt == 2)
    {
      int j = 1 + p_tbCurrentLine;
      p_tbCurrentLine = j;
      if (j > tb_lScrollLine)
      {
        p_tbCurrentLine = tb_lScrollLine;
        return false;
      }
    }
    if (paramInt == 4)
    {
      int i = p_tbCurrentLine - 1;
      p_tbCurrentLine = i;
      if (i < 0)
      {
        p_tbCurrentLine = 0;
        return false;
      }
    }
    p_tb_initSmoothScroll(250, (p_tb_lines[p_tbCurrentLine] << 10) - p_tb_scroll);
    return true;
  }
  
  public static boolean p_tb_changePage(int paramInt)
  {
    if (paramInt == 1) {
      for (int j = 1 + p_tbCurrentLine; j < p_tb_realLineCount; j++) {
        if ((p_tb_lines[j] - p_tb_lines[p_tbCurrentLine] > p_tb_boxSizeHeight) || (j > tb_lScrollLine))
        {
          int k = j - 1;
          if (p_tbCurrentLine != k) {}
          for (p_tbCurrentLine = k;; p_tbCurrentLine = 1 + p_tbCurrentLine)
          {
            p_tb_initSmoothScroll(500, (p_tb_lines[p_tbCurrentLine] << 10) - p_tb_scroll);
            return true;
          }
        }
      }
    }
    if (paramInt == 3)
    {
      if (p_tbCurrentLine == 0) {
        return false;
      }
      int i = p_tbCurrentLine;
      while (p_tbCurrentLine > 0)
      {
        p_tbCurrentLine -= 1;
        if (p_tb_lines[i] - p_tb_lines[p_tbCurrentLine] > p_tb_boxSizeHeight)
        {
          p_tbCurrentLine = 1 + p_tbCurrentLine;
          if (i == p_tbCurrentLine) {
            p_tbCurrentLine -= 1;
          }
          p_tb_initSmoothScroll(500, (p_tb_lines[p_tbCurrentLine] << 10) - p_tb_scroll);
          return true;
        }
      }
      p_tbCurrentLine = 0;
      p_tb_initSmoothScroll(500, (p_tb_lines[p_tbCurrentLine] << 10) - p_tb_scroll);
      return true;
    }
    return false;
  }
  
  public static void p_tb_clampScroll()
  {
    if (p_tb_scroll < 0) {
      p_tb_scroll = 0;
    }
    while ((p_tb_lineCount <= 0) || (p_tb_scroll <= p_tb_lines[(p_tb_lineCount - 1)] << 10)) {
      return;
    }
    p_tb_scroll = p_tb_lines[(p_tb_lineCount - 1)] << 10;
  }
  
  public static int p_tb_getScrollHeight()
  {
    return p_tb_lines[(p_tb_lineCount - 1)] << 10;
  }
  
  public static void p_tb_handleInput(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      p_tbBackupHandleFlags = paramInt;
    }
    p_tb_inputHandleFlags = paramInt;
  }
  
  public static void p_tb_initSmoothScroll(int paramInt1, int paramInt2)
  {
    p_tb_origScroll = p_tb_scroll;
    p_tb_changeTime = smoothtime;
    p_tb_scrollHeight = paramInt2;
    p_tb_scrollTime = paramInt1;
    p_tb_scrollVelocity = 0;
  }
  
  public static void p_tb_inputHandlerLogic()
  {
    if ((0x1 & p_tb_inputHandleFlags) != 0)
    {
      if ((mrg_isKey(351)) && (!p_tb_isScrolling()) && ((p_tbCurrentLine > 0) || (p_tb_scroll > 0))) {
        p_tb_addVelocity(48 * -timedelta);
      }
      if ((mrg_isKey(352)) && (!p_tb_isScrolling()) && (p_tbCurrentLine < p_tb_lineCount - 1)) {
        p_tb_addVelocity(48 * timedelta);
      }
    }
    if ((0x2 & p_tb_inputHandleFlags) != 0)
    {
      if (((0x4 & p_tb_inputHandleFlags) == 0) || (!mrg_isKey(350)) || ((!p_em_isPointerOnArrow(2)) && (!p_em_isPointerOnArrow(3))) || (p_tb_pointerPressedInside)) {
        break label186;
      }
      if ((p_em_isPointerOnArrow(2)) && ((p_tbCurrentLine > 0) || (p_tb_scroll > 0))) {
        p_tb_addVelocity(48 * -timedelta);
      }
      if ((p_em_isPointerOnArrow(3)) && (p_tbCurrentLine < p_tb_lineCount - 1)) {
        p_tb_addVelocity(48 * timedelta);
      }
      p_tb_pointerPressedInside = false;
    }
    label186:
    do
    {
      return;
      if ((mrg_isKey(350)) && (p_tb_pointerPressedInside))
      {
        p_tb_setScroll(p_tb_pointerOrigScroll + (p_pointer_lastPress_y - p_pointer_y << 10));
        p_tb_pointerLastYSpeed = p_tb_pointerLastY - p_pointer_y;
        p_tb_pointerLastY = p_pointer_y;
        p_tb_pointerHandleRelease = true;
        p_tb_showScrollbar = true;
        return;
      }
    } while (!p_tb_pointerHandleRelease);
    p_tb_addVelocity(p_tb_pointerLastYSpeed << 10);
    p_tb_pointerHandleRelease = false;
  }
  
  public static boolean p_tb_isScrolling()
  {
    return p_tb_changeTime + p_tb_scrollTime > smoothtime;
  }
  
  public static boolean p_tb_keyPressed(int paramInt)
  {
    if ((0x1 & p_tb_inputHandleFlags) == 1)
    {
      if (mrg_isKey(paramInt, 351))
      {
        p_tb_changeLine(4);
        return true;
      }
      if (mrg_isKey(paramInt, 352))
      {
        p_tb_changeLine(2);
        return true;
      }
    }
    if (((0x2 & p_tb_inputHandleFlags) == 2) && (mrg_isKey(paramInt, 350)))
    {
      p_tb_pointerPressedInside = false;
      if ((p_pointer_x > p_tbBorderX) && (p_pointer_y > p_tbBorderY) && (p_pointer_x < p_tbBorderX + p_tbBorderWidth) && (p_pointer_y < p_tbBorderY + p_tbBorderHeight))
      {
        if ((!p_em_isPointerOnArrow(3)) && (!p_em_isPointerOnArrow(2))) {
          p_tb_pointerPressedInside = true;
        }
        p_tb_pointerOrigScroll = p_tb_scroll;
        p_tb_pointerLastY = p_pointer_y;
      }
    }
    return false;
  }
  
  public static void p_tb_make(int paramInt1, String paramString, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    p_tb2_make(-1, paramInt1, paramString, paramInt2 - 2, paramInt3, paramBoolean, true);
    tb_maxLines = paramInt3 / gfx_getFontHeight(paramInt1);
    if (tb_maxLines < 1) {
      tb_maxLines = 1;
    }
    tb_numLines = p_tb_realLineCount;
    tb_numPages = 1;
    for (int i = 1; i < p_tb_realLineCount; i++) {
      if (p_tb_lines[i] - p_tb_lines[p_tbCurrentLine] >= p_tb_boxSizeHeight)
      {
        p_tbCurrentLine = i - 1;
        tb_numPages = 1 + tb_numPages;
      }
    }
    tb_lScrollLine = p_tb_lineCount - 1;
  }
  
  public static void p_tb_makeBordered(int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    p_tb_make(paramInt1, paramString, paramInt4 - (paramInt6 << 1), paramInt5 - (paramInt7 << 1), paramBoolean);
    p_tbBorderX = paramInt2 + paramInt6;
    p_tbBorderY = paramInt3 + paramInt7;
    p_tbBorderWidth = paramInt4 - (paramInt6 << 1);
    p_tbBorderHeight = paramInt5 - (paramInt7 << 1);
    p_tbTextX = p_tbBorderX;
    p_tbTextY = p_tbBorderY;
    int i = p_tb_stuffHeight;
    if (i < p_tbBorderHeight) {
      p_tbTextY += (p_tbBorderHeight - i >> 1);
    }
    int j;
    if (paramInt8 != 0)
    {
      if (tb_numPages == 1)
      {
        int k = paramInt5 - (paramInt7 << 1) - i;
        if (((paramInt8 & 0x4) == 0) || ((paramInt8 & 0x8) == 0)) {
          break label291;
        }
        p_tbBorderY += (k >> 1);
        p_tbBorderHeight -= k;
      }
      j = paramInt4 - (paramInt6 << 1) - p_tbMaxLineWidth;
      if (((paramInt8 & 0x1) == 0) || ((paramInt8 & 0x2) == 0)) {
        break label347;
      }
      p_tbBorderX += (j >> 1);
      p_tbBorderWidth -= j;
    }
    for (;;)
    {
      p_tbBorderX -= paramInt6;
      p_tbBorderY -= paramInt7;
      p_tbBorderWidth += (paramInt6 << 1);
      p_tbBorderHeight += (paramInt7 << 1);
      p_tbFont = paramInt1;
      p_tbCurrentLine = 0;
      if (paramBoolean)
      {
        p_tbBackupBorderX = p_tbBorderX;
        p_tbBackupBorderY = p_tbBorderY;
        p_tbBackupBorderWidth = p_tbBorderWidth;
        p_tbBackupBorderHeight = p_tbBorderHeight;
        p_tbBackupTextX = p_tbTextX;
        p_tbBackupTextY = p_tbTextY;
      }
      return;
      label291:
      if ((paramInt8 & 0x4) != 0)
      {
        p_tbTextY = p_tbBorderY + p_tbBorderHeight - i;
        p_tbBorderY = p_tbTextY;
        p_tbBorderHeight = i;
        break;
      }
      if ((paramInt8 & 0x8) == 0) {
        break;
      }
      p_tbTextY = p_tbBorderY;
      p_tbBorderHeight = i;
      break;
      label347:
      if ((paramInt8 & 0x1) != 0)
      {
        p_tbBorderX += (j >> 1);
        p_tbBorderWidth -= (j >> 1);
      }
      else if ((paramInt8 & 0x2) != 0)
      {
        p_tbBorderWidth -= (j >> 1);
      }
    }
  }
  
  public static void p_tb_setScroll(int paramInt)
  {
    p_tb_scroll = paramInt;
    p_tb_clampScroll();
    p_tb_origScroll = p_tb_scroll;
    p_tb_scrollHeight = 0;
  }
  
  public static void p_tb_updateSmoothScroll()
  {
    if (p_tb_text == null) {}
    label278:
    for (;;)
    {
      return;
      if ((p_tb_changeTime + p_tb_scrollTime > smoothtime) && (p_tb_scrollTime != 0))
      {
        int j = smoothtime - p_tb_changeTime - (p_tb_scrollTime >> 1);
        if (j < 0) {}
        for (int k = -j;; k = j)
        {
          int m = (p_tb_scrollTime >> 1) - k;
          int n = m * m / (p_tb_scrollTime >> 1);
          int i1 = (p_tb_scrollTime >> 1) - n;
          if (j < 0) {
            i1 = -i1;
          }
          int i2 = i1 + (p_tb_scrollTime >> 1);
          p_tb_scroll = p_tb_origScroll + i2 * p_tb_scrollHeight / p_tb_scrollTime;
          p_tb_showScrollbar = true;
          return;
        }
      }
      if (p_tb_scrollVelocity != 0)
      {
        for (p_tb_timeLeft += timedelta; p_tb_timeLeft > 10; p_tb_timeLeft -= 10)
        {
          p_tb_scroll += p_tb_scrollVelocity;
          p_tb_origScroll = p_tb_scroll;
          p_tb_scrollVelocity = 920 * p_tb_scrollVelocity >> 10;
          if ((p_tb_scrollVelocity > -10) && (p_tb_scrollVelocity < 10)) {
            p_tb_scrollVelocity = 0;
          }
          p_tb_clampScroll();
        }
        p_tb_showScrollbar = true;
        p_tb_clampScroll();
      }
      for (int i = 0;; i++)
      {
        if (i >= p_tb_lineCount) {
          break label278;
        }
        if ((p_tb_lines[i] <= p_tb_scroll >> 10) && (p_tb_lines[(i + 1)] > p_tb_scroll >> 10))
        {
          p_tbCurrentLine = i;
          return;
          p_tb_scroll = p_tb_origScroll + p_tb_scrollHeight;
          break;
        }
      }
    }
  }
  
  public static boolean p_uid_loadInstanceID()
  {
    byte[] arrayOfByte = mrg_loadData("p_uid_uid");
    if (arrayOfByte != null) {
      try
      {
        p_bd_byteStream = new ByteArrayInputStream(arrayOfByte);
        p_bd_dataStream = new DataInputStream(p_bd_byteStream);
        p_uid_instanceId = p_bd_dataStream.readUTF();
        p_bd_byteStream = null;
        p_bd_dataStream = null;
        return true;
      }
      catch (Exception localException) {}
    }
    return false;
  }
  
  public static boolean p_uid_saveInstanceID()
  {
    if (p_uid_instanceId == null) {
      return false;
    }
    try
    {
      p_be_byteStream = new ByteArrayOutputStream();
      p_be_dataStream = new DataOutputStream(p_be_byteStream);
      p_be_dataStream.writeUTF(p_uid_instanceId);
      byte[] arrayOfByte = p_be_byteStream.toByteArray();
      p_be_byteStream = null;
      p_be_dataStream = null;
      mrg_saveData("p_uid_uid", arrayOfByte);
      return true;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public static void physics_menu()
  {
    int i = (timedelta << 11) / 1000;
    if (i > 204) {
      i = 204;
    }
    menu_fp_time = i + menu_fp_time;
    if (menu_fp_time < 34) {}
    for (;;)
    {
      return;
      boolean bool = false;
      objects_update(menu_fp_time);
      while ((menu_fp_time > 34) && (!bool))
      {
        physics_menuUpdate(34);
        if ((character_state == 0) || ((0x3088 & character_state) != 0)) {
          bool = physics_menuUpdateCollisions();
        }
        menu_fp_time -= 34;
      }
    }
  }
  
  public static void physics_menuUpdate(int paramInt)
  {
    character_fp_velY += fp_mul(character_fp_accY, paramInt);
    if (character_fp_velY < common_fp_configMaxFallVelY) {
      character_fp_velY = common_fp_configMaxFallVelY;
    }
    character_fp_posY += fp_mul(character_fp_velY, paramInt);
  }
  
  public static boolean physics_menuUpdateCollisions()
  {
    int i = platforms_array[platforms_begin].fp_x;
    int j = platforms_array[platforms_begin].fp_y - doj_fp_screenYOffset;
    int k = j - platforms_fp_wHeight;
    int m = i - (platforms_fp_wWidth >> 1) - (character_fp_width >> 1);
    int n = i + (platforms_fp_wWidth >> 1) + (character_fp_width >> 1);
    if ((character_fp_velY < 0) && (character_fp_posX >= m) && (character_fp_posX <= n) && (character_fp_posY >= k) && (character_fp_posY <= j))
    {
      character_fp_posY = j;
      character_fp_velY = common_fp_configJumpVelY;
      character_fp_accY = -common_fp_configNormalAccY;
      sfx_playExt(4, 128, 1);
      return true;
    }
    return false;
  }
  
  public static void physics_update(int paramInt)
  {
    if (doj_gameOver) {}
    do
    {
      return;
      projectiles_update(paramInt);
      if (((0x10400 & character_state) == 0) || ((0xC300 & character_state) != 0)) {
        break;
      }
      character_fp_velY += fp_mul(character_fp_accY, paramInt);
      if (character_fp_velY < common_fp_configMaxFallVelY) {
        character_fp_velY = common_fp_configMaxFallVelY;
      }
      character_fp_posY += fp_mul(character_fp_velY, paramInt);
      if (((0x10000 & character_state) != 0) && (character_fp_stateTime > 1269)) {
        doj_endGame();
      }
    } while ((0x400 & character_state) == 0);
    if (character_fp_stateTime > 1751)
    {
      character_removeState(1024);
      character_addState(65536);
      character_fp_posY = common_fp_configCharacterYLimit;
      return;
    }
    int i4 = paramInt * 1200;
    doj_fp_screenYOffset -= i4;
    return;
    objects_update(paramInt);
    character_fp_velY += fp_mul(character_fp_accY, paramInt);
    if (character_fp_velY < common_fp_configMaxFallVelY) {
      character_fp_velY = common_fp_configMaxFallVelY;
    }
    character_fp_posY += fp_mul(character_fp_velY, paramInt);
    if ((character_fp_posY < 0) && ((0xC300 & character_state) == 0) && (!physics_updateCollisions()))
    {
      character_addState(1024);
      platforms_cleanup_invisible();
      return;
    }
    int i = character_fp_posY;
    int j = common_fp_configCharacterYLimit;
    int k = 0;
    if (i > j)
    {
      k = character_fp_posY - common_fp_configCharacterYLimit;
      doj_fp_screenYOffset = k + doj_fp_screenYOffset;
      character_fp_posY = common_fp_configCharacterYLimit;
      doj_score = doj_fp_screenYOffset >> 11;
    }
    if (((0x1 & character_state) != 0) && (character_fp_stateTime > 2048))
    {
      character_removeState(1);
      character_addState(2);
      character_fp_accY = 0;
    }
    if (((0x2 & character_state) != 0) && (character_fp_stateTime > 2048))
    {
      character_removeState(2);
      character_addState(4);
      character_fp_accY = -884736;
    }
    int i2;
    label401:
    int n;
    if (((0x4 & character_state) != 0) && (character_fp_stateTime > 2048))
    {
      character_removeState(4);
      character_addState(8);
      character_fp_accY = -common_fp_configNormalAccY;
      powerup_fallDirectionLeft = character_isFacingLeft;
      i2 = fp_div(62464, common_fp_xRatio);
      if (character_isFacingLeft)
      {
        powerup_fp_fallPosX = i2 + character_fp_posX;
        int i3 = fp_div(-83968, common_fp_yRatio);
        powerup_fp_fallPosY = character_fp_posY - i3;
        powerup_fp_fallVelY = character_fp_velY;
        powerup_fp_fallAccY = -3686400;
      }
    }
    else
    {
      if ((0x8 & character_state) != 0)
      {
        powerup_fp_fallVelY += fp_mul(powerup_fp_fallAccY, paramInt);
        if (powerup_fp_fallVelY < -614400) {
          powerup_fp_fallVelY = -614400;
        }
        powerup_fp_fallPosY += fp_mul(powerup_fp_fallVelY, paramInt) - k;
        if (powerup_fp_fallPosY < 0) {
          character_removeState(8);
        }
      }
      if (((0x10 & character_state) != 0) && (character_fp_stateTime > common_fp_configPropellerHat1stPhaseDur))
      {
        character_removeState(16);
        character_addState(32);
        character_fp_accY = 0;
      }
      if (((0x20 & character_state) != 0) && (character_fp_stateTime > common_fp_configPropellerHat2ndPhaseDur))
      {
        character_removeState(32);
        character_addState(64);
        character_fp_accY = -737280;
      }
      if (((0x40 & character_state) != 0) && (character_fp_stateTime > common_fp_configPropellerHat3rdPhaseDur))
      {
        character_removeState(64);
        character_addState(128);
        character_fp_accY = -common_fp_configNormalAccY;
        powerup_fallDirectionLeft = character_isFacingLeft;
        n = fp_div(14336, common_fp_xRatio);
        if (!character_isFacingLeft) {
          break label1160;
        }
        powerup_fp_fallPosX = n + character_fp_posX;
        powerup_fp_fallVelX = -368640;
      }
    }
    for (powerup_fp_fallAccX = 368640;; powerup_fp_fallAccX = -368640)
    {
      int i1 = fp_div(-83968, common_fp_yRatio);
      powerup_fp_fallPosY = character_fp_posY - i1;
      powerup_fp_fallVelY = 245760 + character_fp_velY;
      powerup_fp_fallAccY = -3686400;
      if ((0x80 & character_state) != 0)
      {
        powerup_fp_fallVelY += fp_mul(powerup_fp_fallAccY, paramInt);
        if (powerup_fp_fallVelY < -614400) {
          powerup_fp_fallVelY = -614400;
        }
        powerup_fp_fallPosY += fp_mul(powerup_fp_fallVelY, paramInt) - k;
        if (powerup_fp_fallPosY < 0) {
          character_removeState(128);
        }
        powerup_fp_fallVelX += fp_mul(powerup_fp_fallAccX, paramInt);
        powerup_fp_fallPosX += fp_mul(powerup_fp_fallVelX, paramInt);
      }
      if (((0x1000 & character_state) != 0) && (powerup_fp_shieldTime > 8533))
      {
        character_removeState(4096);
        character_addState(8192);
      }
      if (((0x2000 & character_state) != 0) && (powerup_fp_shieldTime > 4096)) {
        character_removeState(8192);
      }
      if ((0x100 & character_state) != 0)
      {
        if ((20480 + character_fp_posX > objects_array[objects_collidedIndex].fp_x) && (character_fp_posX - 20480 < objects_array[objects_collidedIndex].fp_x) && (20480 + (character_fp_posY + (character_fp_height >> 1)) + doj_fp_screenYOffset > objects_array[objects_collidedIndex].fp_y) && (character_fp_posY + (character_fp_height >> 1) - 20480 + doj_fp_screenYOffset < objects_array[objects_collidedIndex].fp_y))
        {
          character_removeState(256);
          character_addState(512);
        }
        if (character_fp_stateTime > 1228)
        {
          character_removeState(256);
          character_addState(512);
        }
      }
      if ((0x4000 & character_state) != 0)
      {
        int m = fp_div(129024, common_fp_yRatio);
        if ((20480 + character_fp_posX > objects_array[objects_collidedIndex].fp_x) && (character_fp_posX - 20480 < objects_array[objects_collidedIndex].fp_x) && (20480 + (character_fp_posY + (character_fp_height >> 1)) + doj_fp_screenYOffset > m + objects_array[objects_collidedIndex].fp_y) && (character_fp_posY + (character_fp_height >> 1) - 20480 + doj_fp_screenYOffset < m + objects_array[objects_collidedIndex].fp_y))
        {
          character_removeState(16384);
          character_addState(32768);
        }
        if (character_fp_stateTime > 2048)
        {
          character_removeState(16384);
          character_addState(32768);
        }
      }
      if ((0x8200 & character_state) == 0) {
        break;
      }
      doj_endGame();
      return;
      powerup_fp_fallPosX = character_fp_posX - i2;
      break label401;
      label1160:
      powerup_fp_fallPosX = character_fp_posX - n;
      powerup_fp_fallVelX = 368640;
    }
  }
  
  public static boolean physics_updateCollisions()
  {
    if ((doj_gameOver) || ((0x18E00 & character_state) != 0)) {
      return false;
    }
    int i = objects_begin;
    int i24;
    if (i < 10 + objects_end)
    {
      if (objects_begin >= objects_end) {
        break label86;
      }
      i24 = i;
      if (i24 != objects_end) {
        break label111;
      }
    }
    for (int j = platforms_begin;; j++)
    {
      int m;
      if (j < 100 + platforms_end)
      {
        if (platforms_begin < platforms_end)
        {
          m = j;
          if (m != platforms_end) {
            break label1279;
          }
        }
      }
      else
      {
        return false;
        label86:
        if (i < 10) {}
        for (int i23 = i;; i23 = i - 10)
        {
          i24 = i23;
          break;
        }
        label111:
        int i25 = objects_array[i24].fp_x;
        int i26 = objects_array[i24].fp_y - doj_fp_screenYOffset;
        if ((objects_array[i24].id == 4) && ((0x177 & character_state) == 0))
        {
          int i35 = i25 - fp_div(44032, common_fp_xRatio) - (character_fp_width >> 1);
          int i36 = i25 + fp_div(44032, common_fp_xRatio) + (character_fp_width >> 1);
          int i37 = i26 - fp_div(44032, common_fp_yRatio) - character_fp_height;
          int i38 = i26 + fp_div(44032, common_fp_yRatio);
          if ((character_fp_posX >= i35) && (character_fp_posX <= i36) && (character_fp_posY >= i37) && (character_fp_posY <= i38))
          {
            character_addState(256);
            objects_collidedIndex = i24;
            character_fp_accX = 0;
            character_fp_accY = 0;
            character_fp_velX = -(character_fp_posX - objects_array[i24].fp_x);
            character_fp_velY = -(character_fp_posY + doj_fp_screenYOffset + (character_fp_height >> 1) - objects_array[i24].fp_y);
            sfx_playExt(19, 128, 1);
            doj_stopWarningSounds();
          }
        }
        int i29;
        label680:
        label1252:
        for (;;)
        {
          i++;
          break;
          int i27;
          int i28;
          switch (objects_array[i24].id)
          {
          case 12: 
          case 13: 
          case 14: 
          case 15: 
          case 16: 
          case 17: 
          case 18: 
          case 19: 
          case 20: 
          default: 
            break;
          case 9: 
            i27 = fp_div(37888, common_fp_xRatio);
            i28 = fp_div(51200, common_fp_yRatio);
            i29 = i26;
          case 10: 
          case 8: 
          case 11: 
          case 21: 
          case 7: 
          case 6: 
            int i30;
            int i31;
            for (;;)
            {
              i30 = i27 - (i27 >> 4);
              i31 = i28 - (i28 >> 4);
              if (!projectiles_markForRemoveIfInArea(i25, i29, i30 << 1, i31 << 1)) {
                break label680;
              }
              objects_holdOnIndex = i24;
              if (objects_array[i24].id == 11) {
                break label1252;
              }
              doj_stopWarningSounds();
              break;
              i27 = fp_div(82944, common_fp_xRatio);
              i28 = fp_div(47104, common_fp_yRatio);
              i29 = i26;
              continue;
              i27 = fp_div(47104, common_fp_xRatio);
              i28 = fp_div(36864, common_fp_yRatio);
              i29 = i26;
              continue;
              i27 = fp_div(86016, common_fp_xRatio);
              i28 = fp_div(62464, common_fp_yRatio);
              i29 = i26;
              continue;
              i27 = fp_div(56320, common_fp_xRatio);
              i28 = fp_div(51200, common_fp_yRatio);
              i29 = i26;
              continue;
              i27 = fp_div(79872, common_fp_xRatio);
              i28 = fp_div(34816, common_fp_yRatio);
              i29 = i26 + fp_div(94208, common_fp_yRatio);
            }
            if ((0x70 & character_state) != 0)
            {
              int i34 = i31 + fp_div(77824, common_fp_yRatio);
              if ((character_fp_posX >= i25 - i30) && (character_fp_posX <= i30 + i25) && (character_fp_posY >= i29 - i34 - (character_fp_height >> 1)) && (character_fp_posY <= i34 + i29 - (character_fp_height >> 1)) && (objects_array[i24].fp_velY == 0))
              {
                objects_array[i24].id = 20;
                doj_stopWarningSounds();
              }
            }
            else
            {
              if ((0x7 & character_state) != 0) {
                continue;
              }
              if (objects_array[i24].id == 6)
              {
                i29 = objects_array[i24].fp_y - doj_fp_screenYOffset;
                i30 = fp_div(88064, common_fp_xRatio);
                i31 = fp_div(129024, common_fp_yRatio);
              }
              int i32 = i30 + (character_fp_width >> 1);
              int i33 = i31 + (character_fp_height >> 1);
              if ((character_fp_posX >= i25 - i32) && (character_fp_posX <= i32 + i25) && (character_fp_posY >= i29 - i33 - (character_fp_height >> 1)) && (character_fp_posY <= i29 + i33 - (character_fp_height >> 1)) && (objects_array[i24].fp_velY == 0))
              {
                if ((character_fp_velY >= 0) && ((0x3000 & character_state) == 0))
                {
                  if (objects_array[i24].id != 6)
                  {
                    character_addState(2048);
                    character_fp_velY = 0;
                    character_fp_accX = -character_fp_accX;
                    doj_stopWarningSounds();
                    continue;
                  }
                  character_addState(16384);
                  sfx_playExt(14, 128, 1);
                  doj_stopWarningSounds();
                  objects_collidedIndex = i24;
                  character_fp_velX = -(character_fp_posX - objects_array[i24].fp_x);
                  character_fp_velY = -(character_fp_posY + doj_fp_screenYOffset + (character_fp_height >> 1) - (i33 + objects_array[i24].fp_y));
                  character_fp_accX = 0;
                  character_fp_accY = 0;
                  continue;
                }
                if (character_fp_velY < 0)
                {
                  objects_array[i24].fp_velY = character_fp_velY;
                  character_fp_velY = 1843200;
                  sfx_playExt(20, 128, 1);
                  doj_stopWarningSounds();
                }
              }
              else if ((objects_array[i24].fp_y - doj_fp_screenYOffset < (common_fp_configLogicScreenHeight << 2) - common_fp_configLogicScreenHeight >> 1) && (objects_array[i24].fp_y - doj_fp_screenYOffset > 0) && (objects_array[i24].id != 4) && (objects_array[i24].id != 20))
              {
                if ((objects_array[i24].id == 6) && (!doj_sfx_ufoWarning))
                {
                  sfx_playExt(16, 0, 0);
                  doj_sfx_ufoWarning = true;
                }
                if ((objects_array[i24].id != 6) && (!doj_sfx_monsterWarning)) {
                  doj_sfx_monsterWarning = true;
                }
              }
            }
            break;
          }
        }
      }
      if (j < 100) {}
      for (int k = j;; k = j - 100)
      {
        m = k;
        break;
      }
      label1279:
      int n = platforms_array[m].fp_x;
      int i1 = platforms_array[m].fp_y - doj_fp_screenYOffset;
      int i2 = platforms_array[m].id;
      int i3 = fp_div(30720, common_fp_yRatio);
      if (i3 > platforms_fp_wHeight) {}
      int i4;
      int i5;
      int i6;
      for (;;)
      {
        i4 = i1 - i3;
        i5 = n - (platforms_fp_wWidth >> 1) - (character_fp_width >> 1);
        i6 = n + (platforms_fp_wWidth >> 1) + (character_fp_width >> 1);
        if ((i2 & 0x8) == 0) {
          break;
        }
        int i20 = n + platforms_array[m].objOffset - fp_div(17408, common_fp_xRatio) - (character_fp_width >> 1);
        int i21 = n + platforms_array[m].objOffset + fp_div(17408, common_fp_xRatio) + (character_fp_width >> 1);
        int i22 = i1 + fp_div(24576, common_fp_yRatio);
        if ((character_fp_velY >= 0) || (character_fp_posX < i20) || (character_fp_posX > i21) || (character_fp_posY < i1) || (character_fp_posY > i22)) {
          break label1921;
        }
        character_fp_posY = 57344 + i1;
        character_fp_velY = common_fp_configCharacterSpringVelY;
        character_fp_accY = -common_fp_configNormalAccY;
        Platform localPlatform4 = platforms_array[m];
        localPlatform4.id = (0xFFFFFFF7 & localPlatform4.id);
        Platform localPlatform5 = platforms_array[m];
        localPlatform5.id = (0x40 | localPlatform5.id);
        sfx_playExt(21, 128, 1);
        return true;
        i3 = platforms_fp_wHeight;
      }
      if (((i2 & 0x10) != 0) && ((0x77 & character_state) == 0))
      {
        int i16 = n + platforms_array[m].objOffset - fp_div(24576, common_fp_xRatio) - (character_fp_width >> 1);
        int i17 = n + platforms_array[m].objOffset + fp_div(24576, common_fp_xRatio) + (character_fp_width >> 1);
        int i18 = i1 - character_fp_height;
        int i19 = i1 + fp_div(73728, common_fp_yRatio);
        if ((character_fp_posX >= i16) && (character_fp_posX <= i17) && (character_fp_posY >= i18) && (character_fp_posY <= i19))
        {
          powerup_usedJetPacks = 1 + powerup_usedJetPacks;
          character_fp_velY = 1105920;
          character_fp_accY = 1253376;
          Platform localPlatform3 = platforms_array[m];
          localPlatform3.id = (0xFFFFFFEF & localPlatform3.id);
          character_addState(1);
          return true;
        }
      }
      else
      {
        if (((i2 & 0x20) == 0) || ((0x77 & character_state) != 0)) {
          break label2044;
        }
        int i12 = n + platforms_array[m].objOffset - fp_div(32768, common_fp_xRatio) - (character_fp_width >> 1);
        int i13 = n + platforms_array[m].objOffset + fp_div(32768, common_fp_xRatio) + (character_fp_width >> 1);
        int i14 = i1 - character_fp_height;
        int i15 = i1 + fp_div(55296, common_fp_yRatio);
        if ((character_fp_posX >= i12) && (character_fp_posX <= i13) && (character_fp_posY >= i14) && (character_fp_posY <= i15))
        {
          Platform localPlatform2 = platforms_array[m];
          localPlatform2.id = (0xFFFFFFDF & localPlatform2.id);
          character_addState(16);
          if (character_fp_velY <= 0) {
            break label2029;
          }
          character_fp_accY = fp_div(1228800 - character_fp_velY, 2730);
        }
      }
      label1921:
      if ((i2 <= 2097156) && (character_fp_velY < 0) && (character_fp_posX >= i5) && (character_fp_posX <= i6) && (character_fp_posY >= i4) && (character_fp_posY <= i1))
      {
        if (i2 < 2097152)
        {
          character_fp_posY = i1 - fp_div(0, common_fp_yRatio);
          character_fp_velY = common_fp_configJumpVelY;
          character_fp_accY = -common_fp_configNormalAccY;
          if (i2 == 2)
          {
            platforms_array[m].id = 1073741824;
            sfx_playExt(22, 128, 1);
          }
          for (;;)
          {
            return true;
            label2029:
            character_fp_velY = 245760;
            character_fp_accY = 737280;
            break;
            label2044:
            if ((i2 & 0x80) == 0) {
              break;
            }
            int i7 = n + platforms_array[m].objOffset - fp_div(36864, common_fp_xRatio) - (character_fp_width >> 1);
            int i8 = n + platforms_array[m].objOffset + fp_div(36864, common_fp_xRatio) + (character_fp_width >> 1);
            int i9 = i1 - character_fp_height;
            int i10 = i1 + fp_div(71680, common_fp_yRatio);
            if ((character_fp_posX < i7) || (character_fp_posX > i8) || (character_fp_posY < i9) || (character_fp_posY > i10)) {
              break;
            }
            Platform localPlatform1 = platforms_array[m];
            localPlatform1.id = (0xFF7F & localPlatform1.id);
            character_addState(4096);
            break;
            sfx_playExt(4, 128, 1);
          }
        }
        int i11 = 0x4 & platforms_array[m].id;
        platforms_array[m].id = (i11 | 0x400000);
        platforms_array[m].updateTime = smoothtime;
        sfx_playExt(5, 128, 1);
      }
    }
  }
  
  public static void physics_updateControls(int paramInt)
  {
    if (doj_gameOver) {
      return;
    }
    int i = 0x4900 & character_state;
    int j = 0;
    if (i == 0)
    {
      if (p_options[2] != 0)
      {
        character_fp_accX = 0;
        character_fp_velX = fp_mul(8192, acc_x >> 9 << 11);
      }
    }
    else
    {
      label51:
      if ((0x10C00 & character_state) != 0)
      {
        if (character_fp_velX <= 0) {
          break label305;
        }
        character_fp_accX = -common_fp_configNormalDecX;
        label74:
        j = 1;
      }
      int k = character_fp_velX;
      character_fp_velX += fp_mul(character_fp_accX, paramInt);
      if ((j != 0) && (((k > 0) && (character_fp_velX < 0)) || ((k < 0) && (character_fp_velX > 0)))) {
        character_fp_velX = 0;
      }
      if (character_fp_velX <= common_fp_configMaxVelX) {
        break label327;
      }
      character_fp_velX = common_fp_configMaxVelX;
    }
    for (;;)
    {
      character_fp_posX += fp_mul(character_fp_velX, paramInt);
      if (character_fp_posX < 0) {
        character_fp_posX = common_fp_configLogicScreenWidth;
      }
      if (character_fp_posX <= common_fp_configLogicScreenWidth) {
        break;
      }
      character_fp_posX = 0;
      return;
      if (mrg_isKey(131076))
      {
        if (character_fp_velX > 0)
        {
          character_fp_accX = -common_fp_configNormalDecX;
          j = 0;
          break label51;
        }
        character_fp_accX = -common_fp_configNormalAccX;
        j = 0;
        break label51;
      }
      if (mrg_isKey(131078))
      {
        if (character_fp_velX < 0)
        {
          character_fp_accX = common_fp_configNormalDecX;
          j = 0;
          break label51;
        }
        character_fp_accX = common_fp_configNormalAccX;
        j = 0;
        break label51;
      }
      boolean bool = doj_pointerDown;
      j = 0;
      if (bool) {
        break label51;
      }
      if (character_fp_velX > 0) {
        character_fp_accX = -common_fp_configNormalDecX;
      }
      for (;;)
      {
        j = 1;
        break;
        if (character_fp_velX < 0) {
          character_fp_accX = common_fp_configNormalDecX;
        } else {
          character_fp_accX = 0;
        }
      }
      label305:
      if (character_fp_velX < 0)
      {
        character_fp_accX = common_fp_configNormalDecX;
        break label74;
      }
      character_fp_accX = 0;
      break label74;
      label327:
      if (character_fp_velX < -common_fp_configMaxVelX) {
        character_fp_velX = -common_fp_configMaxVelX;
      }
    }
  }
  
  public static void platform_fillHorizontal(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = gfx_getImageWidth(paramInt1);
    int j = gfx_getImageHeight(paramInt1);
    if (paramInt4 >= i)
    {
      int k = paramInt4 / i;
      for (int m = 0; m < k; m++)
      {
        gfx_drawImage(paramInt1, paramInt2, paramInt3, 20, 0);
        paramInt2 += i;
        paramInt4 -= i;
      }
    }
    if (paramInt4 > 0) {
      gfx_drawSubImage(paramInt1, paramInt2, paramInt3, 20, paramInt4, j, 0, 0);
    }
  }
  
  public static void platforms_cleanup()
  {
    while ((platforms_begin != platforms_end) && (platforms_array[platforms_begin].fp_y - doj_fp_screenYOffset < -common_fp_configLogicScreenHeight))
    {
      platforms_begin = 1 + platforms_begin;
      if (platforms_begin >= 100) {
        platforms_begin -= 100;
      }
    }
    while ((objects_begin != objects_end) && (objects_array[objects_begin].fp_y - doj_fp_screenYOffset < -common_fp_configLogicScreenHeight))
    {
      objects_begin = 1 + objects_begin;
      if (objects_begin >= 10) {
        objects_begin -= 10;
      }
    }
  }
  
  public static void platforms_cleanup_invisible()
  {
    while ((platforms_begin != platforms_end) && (platforms_array[platforms_begin].fp_y - doj_fp_screenYOffset < 0))
    {
      platforms_begin = 1 + platforms_begin;
      if (platforms_begin >= 100) {
        platforms_begin -= 100;
      }
    }
    while ((objects_begin != objects_end) && (objects_array[objects_begin].fp_y - doj_fp_screenYOffset < -common_fp_configLogicScreenHeight))
    {
      objects_begin = 1 + objects_begin;
      if (objects_begin >= 10) {
        objects_begin -= 10;
      }
    }
  }
  
  public static void platforms_draw()
  {
    int i = (platforms_fp_width >> 11) - 15 - 13 - 11;
    int j = 0;
    if (i < 0)
    {
      j = i;
      i = 0;
    }
    int k = i - (i >> 1);
    int m = platforms_begin;
    int n;
    if (m < 100 + platforms_end)
    {
      if (platforms_begin < platforms_end)
      {
        i2 = m;
        if (i2 != platforms_end) {
          break label142;
        }
      }
    }
    else
    {
      n = (100 + (platforms_end - 1)) % 100;
      if (n >= platforms_begin - 100)
      {
        if (platforms_begin >= platforms_end) {
          break label636;
        }
        i1 = n;
        if ((i1 != platforms_begin - 1) && (i1 != 100)) {
          break label658;
        }
      }
      return;
    }
    if (m < 100) {}
    for (int i2 = m;; i2 = m - 100) {
      break;
    }
    label142:
    if ((0xFF03 & platforms_array[i2].id) != 0) {
      p_platforms_drawRegularPlatformWithGfx(i2);
    }
    for (;;)
    {
      m++;
      break;
      if ((0x400000 & platforms_array[i2].id) == 4194304)
      {
        int i12 = doj_worldToScreenX(platforms_array[i2].fp_x) - (platforms_fp_width >> 11 >> 1);
        int i13 = doj_worldToScreenY(platforms_array[i2].fp_y - doj_fp_screenYOffset);
        gfx_drawImage(52, i12, i13, 20, 0);
        gfx_drawImage(53, j + (doj_worldToScreenX(platforms_array[i2].fp_x) + (platforms_fp_width >> 11 >> 1)), i13, 24, 0);
      }
      else if ((0x800000 & platforms_array[i2].id) == 8388608)
      {
        int i10 = doj_worldToScreenX(platforms_array[i2].fp_x) - (platforms_fp_width >> 11 >> 1);
        int i11 = doj_worldToScreenY(platforms_array[i2].fp_y - doj_fp_screenYOffset);
        gfx_drawImage(54, i10, i11, 20, 0);
        gfx_drawImage(55, j + (doj_worldToScreenX(platforms_array[i2].fp_x) + (platforms_fp_width >> 11 >> 1)), i11, 24, 0);
      }
      else if ((0x1000000 & platforms_array[i2].id) == 16777216)
      {
        int i8 = doj_worldToScreenX(platforms_array[i2].fp_x) - (platforms_fp_width >> 11 >> 1);
        int i9 = doj_worldToScreenY(platforms_array[i2].fp_y - doj_fp_screenYOffset);
        gfx_drawImage(56, i8, i9, 20, 0);
        gfx_drawImage(57, j + (doj_worldToScreenX(platforms_array[i2].fp_x) + (platforms_fp_width >> 11 >> 1)), i9, 24, 0);
      }
      else if ((0x200000 & platforms_array[i2].id) == 2097152)
      {
        int i3 = doj_worldToScreenX(platforms_array[i2].fp_x) - (platforms_fp_width >> 11 >> 1);
        int i4 = doj_worldToScreenY(platforms_array[i2].fp_y - doj_fp_screenYOffset);
        gfx_drawImage(47, i3, i4, 20, 0);
        int i5 = i3 + 15;
        platform_fillHorizontal(48, i5, i4, k);
        int i6 = i5 + k;
        gfx_drawImage(49, i6, i4, 20, 0);
        int i7 = i6 + 11;
        platform_fillHorizontal(50, i7, i4, k);
        gfx_drawImage(51, j + (i7 + k), i4, 20, 0);
      }
    }
    label636:
    if (n < 0) {}
    for (int i1 = n + 100;; i1 = n) {
      break;
    }
    label658:
    if ((0x10 & platforms_array[i1].id) != 0) {
      gfx_drawImage(90, doj_worldToScreenX(platforms_array[i1].fp_x + platforms_array[i1].objOffset), doj_worldToScreenY(platforms_array[i1].fp_y - doj_fp_screenYOffset), 33, 0);
    }
    if ((0x20 & platforms_array[i1].id) != 0) {
      gfx_drawImage(93, doj_worldToScreenX(platforms_array[i1].fp_x + platforms_array[i1].objOffset), doj_worldToScreenY(platforms_array[i1].fp_y - doj_fp_screenYOffset), 33, 0);
    }
    if ((0x8 & platforms_array[i1].id) != 0) {
      gfx_drawImage(88, doj_worldToScreenX(platforms_array[i1].fp_x + platforms_array[i1].objOffset), doj_worldToScreenY(platforms_array[i1].fp_y - doj_fp_screenYOffset), 33, 0);
    }
    for (;;)
    {
      if ((0x80 & platforms_array[i1].id) != 0) {
        gfx_drawImage(95, doj_worldToScreenX(platforms_array[i1].fp_x + platforms_array[i1].objOffset), doj_worldToScreenY(platforms_array[i1].fp_y - doj_fp_screenYOffset), 33, 0);
      }
      n--;
      break;
      if ((0x40 & platforms_array[i1].id) != 0) {
        gfx_drawImage(89, doj_worldToScreenX(platforms_array[i1].fp_x + platforms_array[i1].objOffset), doj_worldToScreenY(platforms_array[i1].fp_y - doj_fp_screenYOffset), 33, 0);
      }
    }
  }
  
  public static void platforms_free()
  {
    for (int i = 0; i < 100; i++) {
      platforms_array[i] = null;
    }
    platforms_array = null;
    platforms_scenes = null;
    platforms_scenes = null;
    platforms_scenes_hardIndexes = null;
    platforms_scenes_hardIndexes = null;
    platforms_scenes_easyIndexes = null;
    platforms_scenes_easyIndexes = null;
  }
  
  public static void platforms_generate()
  {
    int i = platforms_end - 1;
    if (i < 0) {
      i += 100;
    }
    int j = platforms_array[i].fp_y;
    if (platforms_end == platforms_begin)
    {
      j = 61440;
      platforms_push(327680, j, 1, 0, 0);
    }
    if ((j > 10240000) && (j - doj_fp_screenYOffset < common_fp_configLogicScreenHeight) && (rand() % 20 == 10) && ((0x77 & character_state) == 0)) {
      platforms_generatePredefined();
    }
    platforms_generateRandom(true, common_fp_configLogicScreenHeight);
  }
  
  public static void platforms_generatePredefined()
  {
    if ((platforms_scenes_easyIndexes == null) || (platforms_scenes_hardIndexes == null)) {
      return;
    }
    int i = (100 + (platforms_end - 1)) % 100;
    platforms_generateRandom(false, 1024000 + (platforms_array[i].fp_y - doj_fp_screenYOffset));
    int j = platforms_end - 1;
    if (j < 0) {}
    for (int k = j + 100;; k = j)
    {
      int m = platforms_array[k].fp_y;
      int n = platforms_array[k].id;
      if (platforms_end == platforms_begin) {
        m = 0;
      }
      for (int i1 = 1;; i1 = n)
      {
        int i2 = objects_end - 1;
        if (i2 < 0) {
          i2 += 10;
        }
        if ((objects_end != objects_begin) && (m < objects_array[i2].fp_y)) {
          m = objects_array[i2].fp_y;
        }
        int i3 = (100 + (platforms_end - 1)) % 100;
        int i7;
        int i8;
        int i9;
        int i10;
        label245:
        int i14;
        int i16;
        int i18;
        int i19;
        int i20;
        if (m < 30720000)
        {
          int i21;
          do
          {
            i21 = rand() % (platforms_scenes_easyIndexes.length - 1);
          } while ((1 << i21 & platforms_scenes_easyUsed) != 0);
          int i22 = platforms_scenes_easyIndexes[i21];
          int i23 = platforms_scenes_easyIndexes[(i21 + 1)];
          platforms_scenes_easyUsed |= 1 << i21;
          if (platforms_scenes_easyUsed == platforms_scenes_easyUsedMask) {
            platforms_scenes_easyUsed = 0;
          }
          i7 = i23;
          i8 = i22;
          i9 = i8;
          i10 = 0;
          int i11 = m;
          if (i9 >= i7) {
            break label749;
          }
          i14 = platforms_scenes[(i9 + 1)] << 11;
          int i15 = platforms_scenes[(i9 + 2)];
          if ((i9 == i8) && (i15 < platforms_minDistance) && ((0x1E00000 & i1) == 0)) {
            i11 += (platforms_minDistance - i15 << 11);
          }
          i16 = i11 + (i15 << 11);
          int i17 = platforms_scenes[i9];
          i18 = rand() % (platforms_fp_wWidth - 34816) - (platforms_fp_wWidth - 34816 >> 1);
          i19 = 60 * (1024 + 102 * (rand() % 10)) + fp_div(doj_fp_screenYOffset, 6144000);
          if (i19 > 307200) {
            i19 = 307200;
          }
          switch (i17)
          {
          case 6: 
          case 7: 
          case 8: 
          case 9: 
          case 10: 
          case 11: 
          case 12: 
          case 13: 
          case 14: 
          case 15: 
          default: 
            if ((i17 >= 6) && (i17 <= 11))
            {
              objects_push(i14, i16, i17);
              i20 = 1;
            }
            break;
          }
        }
        for (;;)
        {
          i9 += 3;
          i10 = i20;
          break label245;
          int i4;
          do
          {
            i4 = rand() % (platforms_scenes_hardIndexes.length - 1);
          } while ((1 << i4 & platforms_scenes_hardUsed) != 0);
          int i5 = platforms_scenes_hardIndexes[i4];
          int i6 = platforms_scenes_hardIndexes[(i4 + 1)];
          platforms_scenes_hardUsed |= 1 << i4;
          if (platforms_scenes_hardUsed == platforms_scenes_hardUsedMask) {
            platforms_scenes_hardUsed = 0;
          }
          i7 = i6;
          i8 = i5;
          break;
          objects_push(i14, i16, 4);
          i20 = i10;
          continue;
          platforms_push(i14, i16, 1, 0, 0);
          i20 = i10;
          continue;
          platforms_push(i14, i16, 5, i19, 0);
          i20 = i10;
          continue;
          platforms_push(i14, i16, 2097152, 0, 0);
          i20 = i10;
          continue;
          platforms_push(i14, i16, 9, 0, i18);
          i20 = i10;
          continue;
          platforms_push(i14, i16, 2, 0, 0);
          i20 = i10;
          continue;
          platforms_push(i14, i16, 256, 0, 0);
          i20 = i10;
          continue;
          platforms_push(i14, i16, 256, 0, 1000 + rand() % 2000);
          i20 = i10;
          continue;
          label749:
          if ((i10 != 0) && (!doj_classicMode) && (rand() % 8 > 2) && (i != i3))
          {
            platforms_cleanup();
            for (int i13 = (i + rand() % ((i3 - i) % 100)) % 100; ((0x1 & platforms_array[i13].id) == 0) || ((0x38 & platforms_array[i13].id) != 0); i13 = (i + rand() % ((i3 - i) % 100)) % 100) {}
            Platform localPlatform = platforms_array[i13];
            localPlatform.id = (0x80 | localPlatform.id);
          }
          int i12 = (100 + (platforms_end - 1)) % 100;
          return;
          i20 = i10;
        }
      }
    }
  }
  
  public static void platforms_generateRandom(boolean paramBoolean, int paramInt)
  {
    int i = platforms_end - 1;
    if (i < 0) {}
    for (int j = i + 100;; j = i)
    {
      int k = platforms_array[j].fp_y;
      int m = platforms_array[j].id;
      if (platforms_end == platforms_begin) {
        k = 0;
      }
      for (int n = 1;; n = m)
      {
        int i1 = (10 + (objects_end - 1)) % 10;
        int i2;
        int i3;
        if ((objects_end != objects_begin) && (objects_array[i1].fp_y > k))
        {
          int i25 = objects_array[i1].fp_y;
          i2 = 2097152;
          i3 = i25;
        }
        for (;;)
        {
          int i4;
          if ((i3 - doj_fp_screenYOffset < paramInt) || ((0x1E00000 & i2) != 0))
          {
            i4 = i3 >> 11;
            if ((rand() % 5 != 0) || ((0x1E00000 & i2) != 0)) {
              break label701;
            }
          }
          label240:
          label701:
          for (int i5 = 2097152;; i5 = 1)
          {
            int i6 = 0;
            if (i4 > 5500)
            {
              int i23 = rand() % 100;
              int i24 = i4 / 400;
              i6 = 0;
              if (i23 < i24) {
                i6 = 1;
              }
            }
            int i20;
            int i21;
            int i8;
            int i7;
            if (i6 != 0)
            {
              i20 = 60 * (1024 + 102 * (rand() % 10)) + fp_div(doj_fp_screenYOffset, 6144000);
              if (i20 > 307200)
              {
                i21 = 307200;
                int i22 = i5 | 0x4;
                i8 = i21;
                i7 = i22;
              }
            }
            for (;;)
            {
              int i9 = (platforms_fp_wWidth >> 1) + rand() % (common_fp_configLogicScreenWidth - platforms_fp_wWidth);
              int i10 = 25 + rand() % ((i4 + 150) / 150);
              if (i10 > 90) {
                i10 = 90;
              }
              if (((0x1E00000 & i2) != 0) && (i10 > 50)) {
                i10 = 50;
              }
              if (((i2 & 0x38) != 0) && ((0x1E00000 & i2) == 0))
              {
                int i18 = i10 + 15;
                int i19 = 30 + rand() % ((i4 + 50) / 50);
                if ((i2 & 0x10) == 16) {
                  i19 += 10;
                }
                if (i19 > 70) {
                  i19 = 70;
                }
                i10 = i19 + i18;
              }
              if ((i10 < platforms_minDistance) && ((0x1E00000 & i2) == 0)) {
                i10 = platforms_minDistance;
              }
              int i11 = i10 + (i3 >> 11) << 11;
              int i14;
              int i12;
              int i13;
              if ((0x1E00000 & i7) == 0)
              {
                i14 = fp_div(34816, common_fp_xRatio);
                if ((powerup_usedJetPacks < 3) && (powerup_nextJetPackHeight < i4) && (!doj_classicMode))
                {
                  i12 = i7 | 0x10;
                  powerup_nextJetPackHeight = 2500 + rand() % 9500 + powerup_nextJetPackHeight;
                  int i17 = platforms_fp_wWidth - fp_div(49152, common_fp_xRatio) - i14;
                  i13 = rand() % i17 - (i17 >> 1);
                }
              }
              for (;;)
              {
                platforms_push(i9, i11, i12, i8, i13);
                i2 = i12;
                i3 = i11;
                break;
                if ((powerup_nextPropellerHatHeight < i4) && (!doj_classicMode))
                {
                  i12 = i7 | 0x20;
                  powerup_nextPropellerHatHeight = 1000 + rand() % 9000 + powerup_nextPropellerHatHeight;
                  int i16 = platforms_fp_wWidth - fp_div(65536, common_fp_xRatio) - i14;
                  i13 = rand() % i16 - (i16 >> 1);
                }
                else if ((rand() % 100 > 90) && (paramBoolean))
                {
                  i12 = i7 | 0x8;
                  int i15 = platforms_fp_wWidth - i14 - i14;
                  i13 = rand() % i15 - (i15 >> 1);
                }
                else
                {
                  i12 = i7;
                  i13 = 0;
                }
              }
              i21 = i20;
              break label240;
              i7 = i5;
              i8 = 0;
            }
          }
          i2 = n;
          i3 = k;
        }
      }
    }
  }
  
  public static void platforms_init()
  {
    platforms_array = new Platform[100];
    for (int i = 0; i < 100; i++) {
      platforms_array[i] = new Platform();
    }
    platforms_reset();
    platforms_scenes = null;
    platforms_scenes_hardIndexes = null;
    platforms_scenes_easyIndexes = null;
  }
  
  public static void platforms_push(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    platforms_array[platforms_end].fp_x = paramInt1;
    platforms_array[platforms_end].fp_y = paramInt2;
    platforms_array[platforms_end].id = paramInt3;
    platforms_array[platforms_end].updateTime = 0;
    platforms_array[platforms_end].speed = paramInt4;
    platforms_array[platforms_end].objOffset = paramInt5;
    for (platforms_end = 1 + platforms_end; platforms_end >= 100; platforms_end -= 100) {}
  }
  
  public static void platforms_pushMenuPlatform()
  {
    platforms_push(81920, 163840, 1, 0, 0);
  }
  
  public static void platforms_reset()
  {
    platforms_begin = 0;
    platforms_end = 0;
  }
  
  public static void platforms_scenesLoad()
  {
    platforms_scenes_easyIndexes = new short[8];
    platforms_scenes_hardIndexes = new short[23];
    int i = 0;
    for (int j = 0; j < platforms_scenes_easyIndexes.length - 1; j = (short)(j + 1))
    {
      short[] arrayOfShort4 = p_getFile_short(p_indexTable3[(73 + (0 + 3 * (j + 0)))], p_indexTable3[(73 + (1 + 3 * (j + 0)))], p_indexTable3[(73 + (2 + 3 * (j + 0)))], null);
      platforms_scenes_easyIndexes[j] = i;
      i = (short)(i + arrayOfShort4.length);
    }
    platforms_scenes_easyIndexes[(platforms_scenes_easyIndexes.length - 1)] = i;
    for (int k = 0; k < platforms_scenes_hardIndexes.length - 1; k = (short)(k + 1))
    {
      short[] arrayOfShort3 = p_getFile_short(p_indexTable3[(73 + (0 + 3 * (k + 7)))], p_indexTable3[(73 + (1 + 3 * (k + 7)))], p_indexTable3[(73 + (2 + 3 * (k + 7)))], null);
      platforms_scenes_hardIndexes[k] = i;
      i = (short)(i + arrayOfShort3.length);
    }
    platforms_scenes_hardIndexes[(platforms_scenes_hardIndexes.length - 1)] = i;
    platforms_scenes = new short[i];
    for (int m = 0; m < platforms_scenes_easyIndexes.length - 1; m = (short)(m + 1))
    {
      short[] arrayOfShort2 = p_getFile_short(p_indexTable3[(73 + (0 + 3 * (m + 0)))], p_indexTable3[(73 + (1 + 3 * (m + 0)))], p_indexTable3[(73 + (2 + 3 * (m + 0)))], null);
      System.arraycopy(arrayOfShort2, 0, platforms_scenes, platforms_scenes_easyIndexes[m], arrayOfShort2.length);
    }
    for (int n = 0; n < platforms_scenes_hardIndexes.length - 1; n = (short)(n + 1))
    {
      short[] arrayOfShort1 = p_getFile_short(p_indexTable3[(73 + (0 + 3 * (n + 7)))], p_indexTable3[(73 + (1 + 3 * (n + 7)))], p_indexTable3[(73 + (2 + 3 * (n + 7)))], null);
      System.arraycopy(arrayOfShort1, 0, platforms_scenes, platforms_scenes_hardIndexes[n], arrayOfShort1.length);
    }
    platforms_scenes_easyUsed = 0;
    platforms_scenes_hardUsed = 0;
    platforms_scenes_easyUsedMask = 127;
    platforms_scenes_hardUsedMask = 4194303;
  }
  
  public static void platforms_scenesUnload()
  {
    platforms_scenes = null;
    platforms_scenes = null;
    platforms_scenes_hardIndexes = null;
    platforms_scenes_hardIndexes = null;
    platforms_scenes_easyIndexes = null;
    platforms_scenes_easyIndexes = null;
  }
  
  public static void platforms_update(int paramInt)
  {
    int i = platforms_begin;
    if (i < 100 + platforms_end)
    {
      if (platforms_begin < platforms_end)
      {
        j = i;
        if (j != platforms_end) {
          break label52;
        }
      }
    }
    else {
      return;
    }
    if (i < 100) {}
    for (int j = i;; j = i - 100) {
      break;
    }
    label52:
    if ((platforms_array[j].id >= 4194304) && (platforms_array[j].id < 16777216) && (smoothtime - platforms_array[j].updateTime > 30)) {}
    while ((smoothtime - platforms_array[j].updateTime > 30) && (platforms_array[j].id < 16777216))
    {
      int n = 0x4 & platforms_array[j].id;
      platforms_array[j].id = (n | (0xFFFFFFFB & platforms_array[j].id) << 1);
      Platform localPlatform5 = platforms_array[j];
      localPlatform5.updateTime = (30 + localPlatform5.updateTime);
      continue;
      if ((0x1000000 & platforms_array[j].id) == 16777216)
      {
        Platform localPlatform4 = platforms_array[j];
        localPlatform4.fp_y -= fp_mul(common_fp_configBrownPlatformFallVelY, paramInt);
      }
    }
    int m;
    if ((0x4 & platforms_array[j].id) == 4)
    {
      Platform localPlatform1 = platforms_array[j];
      localPlatform1.fp_x += fp_mul(platforms_array[j].speed, paramInt);
      if (platforms_array[j].fp_x - (platforms_fp_wWidth >> 1) >= 0) {
        break label421;
      }
      Platform localPlatform3 = platforms_array[j];
      if (-platforms_array[j].speed > platforms_array[j].speed)
      {
        m = -platforms_array[j].speed;
        label326:
        localPlatform3.speed = m;
      }
    }
    else
    {
      label333:
      if ((0x100 & platforms_array[j].id) != 256) {
        break label626;
      }
      if ((platforms_array[j].objOffset != 0) || (platforms_array[j].fp_y >= 307200 + doj_fp_screenYOffset)) {
        break label502;
      }
      platforms_array[j].id = 512;
      platforms_array[j].updateTime = smoothtime;
    }
    for (;;)
    {
      i++;
      break;
      m = platforms_array[j].speed;
      break label326;
      label421:
      if (platforms_array[j].fp_x + (platforms_fp_wWidth >> 1) <= common_fp_configLogicScreenWidth) {
        break label333;
      }
      Platform localPlatform2 = platforms_array[j];
      if (-platforms_array[j].speed < platforms_array[j].speed) {}
      for (int k = -platforms_array[j].speed;; k = platforms_array[j].speed)
      {
        localPlatform2.speed = k;
        break;
      }
      label502:
      if ((platforms_array[j].updateTime == 0) && (platforms_array[j].objOffset > 0) && (platforms_array[j].fp_y - doj_fp_screenYOffset < common_fp_configLogicScreenHeight))
      {
        platforms_array[j].updateTime = smoothtime;
      }
      else if ((platforms_array[j].updateTime > 0) && (platforms_array[j].objOffset > 0) && (smoothtime - platforms_array[j].updateTime > platforms_array[j].objOffset))
      {
        platforms_array[j].id = 512;
        platforms_array[j].updateTime = smoothtime;
        continue;
        label626:
        if ((0x200 & platforms_array[j].id) == 512)
        {
          if (smoothtime - platforms_array[j].updateTime > 150)
          {
            platforms_array[j].id = 1024;
            platforms_array[j].updateTime = smoothtime;
          }
        }
        else if ((0x400 & platforms_array[j].id) == 1024)
        {
          if (smoothtime - platforms_array[j].updateTime > 150)
          {
            platforms_array[j].id = 2048;
            platforms_array[j].updateTime = smoothtime;
          }
        }
        else if ((0x800 & platforms_array[j].id) == 2048)
        {
          if (smoothtime - platforms_array[j].updateTime > 150)
          {
            platforms_array[j].id = 4096;
            platforms_array[j].updateTime = smoothtime;
          }
        }
        else if ((0x1000 & platforms_array[j].id) == 4096)
        {
          if (smoothtime - platforms_array[j].updateTime > 450)
          {
            platforms_array[j].id = 8192;
            platforms_array[j].updateTime = smoothtime;
            if (rand() % 2 != 1) {}
          }
        }
        else if ((0x2000 & platforms_array[j].id) == 8192)
        {
          if (smoothtime - platforms_array[j].updateTime > 100)
          {
            platforms_array[j].id = 16384;
            platforms_array[j].updateTime = smoothtime;
          }
        }
        else if ((0x4000 & platforms_array[j].id) == 16384)
        {
          if (smoothtime - platforms_array[j].updateTime > 100)
          {
            platforms_array[j].id = 32768;
            platforms_array[j].updateTime = smoothtime;
          }
        }
        else if (((0x8000 & platforms_array[j].id) == 32768) && (smoothtime - platforms_array[j].updateTime > 100)) {
          platforms_array[j].id = 1073741824;
        }
      }
    }
  }
  
  public static void popup_create(String paramString, int paramInt1, int paramInt2, short paramShort)
  {
    popup_active = true;
    eg_reset();
    popup_type = paramShort;
    popup_buttonTextId = paramInt2;
    int i = dynamic_Y_RES - (5 << 1);
    p_tb_makeBordered(0, paramString, 5, 5, dynamic_X_RES - (5 << 1), i, 23, 21, 15, true);
    p_tb_handleInput(-1, true);
    int j = p_tbBorderHeight;
    int k = p_tbBorderWidth;
    tb_setBorderedLocation(5 + 23 - ((k - 23 - 23) % 9 >> 1), 21 + p_tbBorderY - ((j - 21 - 21) % 9 >> 1));
    int m = j + (9 - (j - 42) % 9) + p_tbBorderY - 20;
    menu_addTextButton(paramInt1, p_allTexts[paramInt2], 17, 17, 0, m);
  }
  
  public static void popup_delete()
  {
    p_tb_handleInput(0, true);
    popup_active = false;
    popup_buttonTextId = -1;
    popup_type = 0;
    popup_active = false;
    eg_reset();
  }
  
  public static void popup_drawBack(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = p_clip_x;
    int j = p_clip_y;
    int k = p_clip_width;
    int m = p_clip_height;
    gfx_setColor(16052202);
    gfx_fillRect(paramInt1 + 0, paramInt2 + 0, paramInt3 - (0 << 1), paramInt4 - (0 << 1));
    gfx_setClip(paramInt1, paramInt2, paramInt3, paramInt4);
    popup_drawFrame(paramInt1, paramInt2, paramInt3, paramInt4);
    gfx_setClip(i, j, k, m);
  }
  
  public static void popup_drawFrame(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = p_clip_x;
    int j = p_clip_y;
    int k = p_clip_width;
    int m = p_clip_height;
    gfx_drawImage(12, paramInt1, paramInt2, 20, 0);
    gfx_drawImage(12, paramInt1 + paramInt3, paramInt2, 24, 1);
    gfx_drawImage(12, paramInt1, paramInt2 + paramInt4, 36, 3);
    gfx_drawImage(12, paramInt1 + paramInt3, paramInt2 + paramInt4, 40, 2);
    gfx_setClip(paramInt1 + 19, paramInt2 + 15, paramInt3 - (19 << 1), paramInt4 - (15 << 1));
    for (int n = paramInt1 + 19; n < paramInt1 + paramInt3 - 19; n++)
    {
      gfx_drawImage(13, n, paramInt2 + 15, 20, 0);
      gfx_drawImage(13, n, paramInt2 + paramInt4 - 15, 36, 2);
    }
    gfx_setClip(paramInt1 + 15, paramInt2 + 19, paramInt3 - (15 << 1), paramInt4 - (19 << 1));
    for (int i1 = paramInt2 + 19; i1 < paramInt2 + paramInt4 - 19; i1++)
    {
      gfx_drawImage(13, paramInt1 + 15, i1, 20, 3);
      gfx_drawImage(13, paramInt1 + paramInt3 - 15, i1, 24, 1);
    }
    gfx_setClip(i, j, k, m);
  }
  
  public static void popup_drawTutorial(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    int i = p_clip_x;
    int j = p_clip_y;
    int k = p_clip_width;
    int m = p_clip_height;
    int n = gfx_getImageWidth(paramInt5);
    int i1 = gfx_getImageHeight(paramInt5);
    gfx_drawImage(paramInt5, paramInt1, paramInt2, 20, 0);
    gfx_drawImage(paramInt5 + 2, paramInt1 + paramInt3, paramInt2, 24, 0);
    gfx_drawImage(paramInt5 + 5, paramInt1, paramInt2 + paramInt4, 36, 0);
    gfx_drawImage(paramInt5 + 7, paramInt1 + paramInt3, paramInt2 + paramInt4, 40, 0);
    gfx_setClip(paramInt1 + n, paramInt2, paramInt3 - n * 2, paramInt4);
    int i2 = paramInt1 + n;
    while (i2 < paramInt1 + paramInt3 - n)
    {
      gfx_drawImage(paramInt5 + 1, i2, paramInt2, 20, 0);
      gfx_drawImage(paramInt5 + 6, i2, paramInt2 + paramInt4, 36, 0);
      i2 += gfx_getImageWidth(paramInt5 + 1);
    }
    gfx_setClip(paramInt1, paramInt2 + i1, paramInt3, paramInt4 - i1 * 2);
    int i3 = paramInt2 + i1;
    while (i3 < paramInt2 + paramInt4 - i1)
    {
      gfx_drawImage(paramInt5 + 3, paramInt1, i3, 20, 0);
      gfx_drawImage(paramInt5 + 4, paramInt1 + paramInt3, i3, 24, 0);
      i3 += gfx_getImageHeight(paramInt5 + 3);
    }
    gfx_setClip(paramInt1 + n, paramInt2 + i1, paramInt3 - n * 2, paramInt4 - i1 * 2);
    int i4 = paramInt2 + i1;
    for (;;)
    {
      int i5 = paramInt4 + (paramInt2 + i1);
      if (i4 >= i5) {
        break;
      }
      int i6 = paramInt1 + n;
      for (;;)
      {
        int i7 = paramInt3 + (paramInt1 + n);
        if (i6 >= i7) {
          break;
        }
        gfx_drawImage(paramInt6, i6, i4, 20, 0);
        i6 += gfx_getImageWidth(paramInt6);
      }
      i4 += gfx_getImageHeight(paramInt6);
    }
    gfx_setClip(i, j, k, m);
  }
  
  public static int popup_getBorderSize()
  {
    return 19;
  }
  
  public static void popup_init()
  {
    popup_active = false;
    popup_type = 0;
    popup_buttonTextId = -1;
  }
  
  public static void popup_keyPressed(int paramInt)
  {
    switch (popup_type)
    {
    default: 
      return;
    case 1: 
      tutorial_keyPressed(paramInt);
      return;
    }
    demo_keyPressed(paramInt);
  }
  
  public static void popup_keyReleased(int paramInt)
  {
    switch (popup_type)
    {
    default: 
      return;
    case 1: 
      tutorial_keyReleased(paramInt);
      return;
    }
    demo_keyReleased(paramInt);
  }
  
  public static void popup_paint()
  {
    int i = p_tbBorderX;
    int j = p_tbBorderY;
    int k = p_tbBorderHeight;
    int m = p_tbBorderWidth;
    popup_drawTutorial(i, j, m + (9 - (m - 46) % 9), k + (9 - (k - 42) % 9), 33, 41);
    tb_drawEx(p_tbFont, p_tbTextX, p_tbTextY, p_tb_scroll >> 10);
    drawTextBoxArrows();
  }
  
  public static void popup_screenSizeUpdate()
  {
    switch (popup_type)
    {
    default: 
      return;
    case 1: 
      tutorial_screenSizeUpdate();
      return;
    }
    demo_screenSizeChanged();
  }
  
  public static boolean projectiles_add(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (projectiles_count < 10)
    {
      projectiles_array[projectiles_count].fp_pos_x = paramInt1;
      projectiles_array[projectiles_count].fp_pos_y = paramInt2;
      projectiles_array[projectiles_count].fp_vel_x = paramInt3;
      projectiles_array[projectiles_count].fp_vel_y = paramInt4;
      projectiles_count = 1 + projectiles_count;
      return true;
    }
    return false;
  }
  
  public static void projectiles_cleanup()
  {
    for (int i = projectiles_count - 1; i >= 0; i--) {
      if (projectiles_array[i].fp_pos_y > common_fp_configLogicScreenHeight)
      {
        for (int j = i; j < projectiles_count - 1; j++)
        {
          projectiles_array[j].fp_pos_x = projectiles_array[(j + 1)].fp_pos_x;
          projectiles_array[j].fp_pos_y = projectiles_array[(j + 1)].fp_pos_y;
          projectiles_array[j].fp_vel_x = projectiles_array[(j + 1)].fp_vel_x;
          projectiles_array[j].fp_vel_y = projectiles_array[(j + 1)].fp_vel_y;
        }
        projectiles_count -= 1;
      }
    }
  }
  
  public static void projectiles_draw()
  {
    for (int i = 0; i < projectiles_count; i++) {
      gfx_drawImage(102, doj_worldToScreenX(projectiles_array[i].fp_pos_x), doj_worldToScreenY(projectiles_array[i].fp_pos_y), 3, 0);
    }
    if (projectiles_holdOnIndex != -1)
    {
      p_projectiles_remove(projectiles_holdOnIndex);
      projectiles_holdOnIndex = -1;
      if (objects_array[objects_holdOnIndex].id != 11) {
        break label93;
      }
    }
    label93:
    for (objects_array[objects_holdOnIndex].id = 22;; objects_array[objects_holdOnIndex].id = 20)
    {
      objects_holdOnIndex = -1;
      return;
    }
  }
  
  public static void projectiles_free()
  {
    for (int i = 0; i < 10; i++) {
      projectiles_array[i] = null;
    }
    projectiles_array = null;
  }
  
  public static void projectiles_init()
  {
    projectiles_array = new Projectile[10];
    for (int i = 0; i < 10; i++) {
      projectiles_array[i] = new Projectile();
    }
    projectiles_reset();
  }
  
  public static boolean projectiles_isAnyOnScreen()
  {
    if (projectiles_holdOnIndex != -1) {
      return true;
    }
    return projectiles_count > 0;
  }
  
  public static boolean projectiles_markForRemoveIfInArea(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = p_projectiles_indexInArea(paramInt1, paramInt2, paramInt3, paramInt4);
    if (i != -1)
    {
      projectiles_holdOnIndex = i;
      return true;
    }
    return false;
  }
  
  public static boolean projectiles_removeIfInArea(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = p_projectiles_indexInArea(paramInt1, paramInt2, paramInt3, paramInt4);
    if (i != -1)
    {
      p_projectiles_remove(i);
      return true;
    }
    return false;
  }
  
  public static void projectiles_reset()
  {
    projectiles_count = 0;
    projectiles_holdOnIndex = -1;
  }
  
  public static void projectiles_update(int paramInt)
  {
    int i = 0;
    if (i < projectiles_count)
    {
      if (i == projectiles_holdOnIndex) {}
      for (;;)
      {
        i++;
        break;
        Projectile localProjectile1 = projectiles_array[i];
        localProjectile1.fp_pos_x += fp_mul(paramInt, projectiles_array[i].fp_vel_x);
        Projectile localProjectile2 = projectiles_array[i];
        localProjectile2.fp_pos_y += fp_mul(paramInt, projectiles_array[i].fp_vel_y);
      }
    }
    projectiles_cleanup();
  }
  
  public static int rand()
  {
    if (rand_randomi == null) {
      rand_randomi = new Random();
    }
    return 0x7FFFFFFF & rand_randomi.nextInt();
  }
  
  public static void setVibra(int paramInt)
  {
    if (p_options[1] != 0) {
      AndroidVibrate(paramInt);
    }
  }
  
  public static int sfx_getPlayLength(int paramInt)
  {
    return p_indexTable3[(paramInt + 27)];
  }
  
  public static void sfx_loadGroup(int paramInt)
  {
    if (!preinit_done) {
      p_sfx_preinit();
    }
    int i = p_indexTable2[(paramInt + 252)];
    int j = p_indexTable2[(paramInt + 250)];
    int k = i;
    while (k < i + j)
    {
      mrg_loading(3, k);
      int m = p_indexTable2[(k + 254)];
      try
      {
        soundPoolMap.put(Integer.valueOf(m), Integer.valueOf(soundPool.load(p_mrgame.getBaseContext(), p_sounds[m], 1)));
        k++;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        throw new RuntimeException(localException);
      }
    }
  }
  
  public static void sfx_pauseAll()
  {
    if ((p_sounds == null) || (soundPool == null)) {}
    for (;;)
    {
      return;
      for (int i = 0; i < 8; i++) {
        if (p_streams[i] != 65281) {
          soundPool.pause(p_streams[i]);
        }
      }
    }
  }
  
  public static void sfx_playExt(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((p_options[0] == 0) || (p_indexTable1[(paramInt1 + 4)] == 0)) {
      return;
    }
    int i = p_indexTable2[(paramInt1 + 254)];
    p_indexTable1[(paramInt1 + 4)];
    int j = p_sounds[i];
    int k = 0;
    if (j != 0) {
      p_soundResumePosition[i] = -1L;
    }
    for (int m = 0;; m = k)
    {
      for (;;)
      {
        try
        {
          if ((p_streams[m] != 65281) && (System.currentTimeMillis() >= p_stream_startTime[m] + p_stream_playLength[m] * p_stream_loopCount[m]) && (p_stream_loopCount[m] != 0))
          {
            soundPool.setLoop(p_streams[m], 0);
            soundPool.setVolume(p_streams[m], 0.0F, 0.0F);
            p_streams[m] = 65281;
          }
          if (p_streams[m] != 65281) {
            break;
          }
          if (paramInt3 == 0)
          {
            p_streams[m] = soundPool.play(((Integer)soundPoolMap.get(Integer.valueOf(i))).intValue(), 0.02F * VC_defaultVolume, 0.02F * VC_defaultVolume, 1, -1, 1.0F);
            p_realsounds_streamID[i] = m;
            p_stream_startTime[m] = System.currentTimeMillis();
            p_stream_playLength[m] = p_indexTable3[(paramInt1 + 27)];
            p_stream_loopCount[m] = paramInt3;
            p_streamPriority[m] = paramInt2;
            return;
          }
          if (paramInt3 == 1) {
            p_streams[m] = soundPool.play(((Integer)soundPoolMap.get(Integer.valueOf(i))).intValue(), 0.02F * VC_defaultVolume, 0.02F * VC_defaultVolume, 1, 0, 1.0F);
          } else {
            p_streams[m] = soundPool.play(((Integer)soundPoolMap.get(Integer.valueOf(i))).intValue(), 0.02F * VC_defaultVolume, 0.02F * VC_defaultVolume, 1, paramInt3 - 1, 1.0F);
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          return;
        }
      }
      k = m + 1;
      if (k >= 8) {
        return;
      }
    }
  }
  
  public static void sfx_stop(int paramInt)
  {
    int i = p_indexTable2[(paramInt + 254)];
    if ((p_sounds[i] != 0) && (p_streams[p_realsounds_streamID[i]] != 65281))
    {
      soundPool.setLoop(p_streams[p_realsounds_streamID[i]], 0);
      soundPool.setVolume(p_streams[p_realsounds_streamID[i]], 0.0F, 0.0F);
      p_streams[p_realsounds_streamID[i]] = 65281;
    }
  }
  
  public static void sfx_stopAll()
  {
    if (p_sounds != null) {
      for (int i = 0; i < 8; i++)
      {
        p_soundResumePosition[i] = -1L;
        if (p_streams[i] != 0)
        {
          soundPool.setLoop(p_streams[i], 0);
          soundPool.setVolume(p_streams[i], 0.0F, 0.0F);
          p_streams[i] = 65281;
        }
      }
    }
  }
  
  public static void sfx_unloadGroup(int paramInt)
  {
    int i = p_indexTable2[(paramInt + 252)];
    int j = p_indexTable2[(paramInt + 250)];
    for (int k = i; k < i + j; k++) {
      if (p_indexTable1[(k + 4)] != 0)
      {
        int m = p_indexTable2[(k + 254)];
        if (soundPoolMap.containsKey(Integer.valueOf(m)))
        {
          soundPool.unload(((Integer)soundPoolMap.get(Integer.valueOf(m))).intValue());
          soundPoolMap.remove(Integer.valueOf(m));
        }
      }
    }
  }
  
  public static void sfx_unpauseAll()
  {
    if ((p_sounds == null) || (soundPool == null)) {}
    for (;;)
    {
      return;
      for (int i = 0; i < 8; i++) {
        if (p_streams[i] != 65281) {
          soundPool.resume(p_streams[i]);
        }
      }
    }
  }
  
  public static int stringSimpleHash(String paramString)
  {
    int i = 29917;
    int j = 0;
    for (int k = 0; k < paramString.length(); k++)
    {
      j = 1 + (i * (j % 32768) + paramString.charAt(k) - 48);
      i = i * 32749 % 32768;
    }
    return j;
  }
  
  public static int stringToInt(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (Exception localException) {}
    return 0;
  }
  
  public static long stringToInt64(String paramString)
  {
    try
    {
      long l = Long.parseLong(paramString);
      return l;
    }
    catch (Exception localException) {}
    return 0L;
  }
  
  public static void tb_draw(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    tb_drawEx(paramInt1, paramInt2, paramInt3, p_tb_lines[paramInt4]);
  }
  
  public static void tb_drawEx(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!tb_loadFinished) {
      return;
    }
    int i = gfx_getColor();
    int j = paramInt1;
    int k = p_clip_x;
    int m = p_clip_y;
    int n = p_clip_width;
    int i1 = p_clip_height;
    int i2 = k + n;
    int i3 = m + i1;
    int i4 = paramInt3 - 1;
    int i5 = 0 + dynamic_X_RES;
    int i6 = 2 + (i4 + p_tbBorderHeight - (p_tbTextY - p_tbBorderY << 1));
    int i7 = 0;
    label96:
    label103:
    label110:
    int i8;
    int i9;
    label145:
    int i11;
    if (k > 0)
    {
      if (i4 <= m) {
        break label265;
      }
      if (i5 >= i2) {
        break label272;
      }
      if (i6 >= i3) {
        break label279;
      }
      gfx_setClip(i7, i4, i5 - i7, i6 - i4);
      i8 = paramInt4;
      if (p_tb_lastVisibleLine < 0) {
        break label286;
      }
      i9 = p_tb_lines[p_tb_lastVisibleLine];
      int i10 = p_tb_stuffHeight - p_tb_boxSizeHeight;
      if ((i10 <= 0) || (i8 <= i10)) {
        break label554;
      }
      i8 = i10;
      i11 = 0;
    }
    for (;;)
    {
      int i18;
      label210:
      int i12;
      int i13;
      if (i11 < p_tb_stuffCount)
      {
        if (p_tb_stuff[i11] < 0) {
          break label405;
        }
        i18 = p_tb_stuff[(i11 + 3)] - i8;
        if (i18 < i9) {}
      }
      else
      {
        i12 = 0;
        if (i12 < p_tb_imageCount)
        {
          i13 = p_tb_images[(i12 + 2)] - i8;
          if (i13 < i9) {
            break label488;
          }
        }
      }
      for (;;)
      {
        gfx_setClip(k, m, n, i1);
        gfx_setColor(i);
        return;
        i7 = k;
        break;
        label265:
        i4 = m;
        break label96;
        label272:
        i5 = i2;
        break label103;
        label279:
        i6 = i3;
        break label110;
        label286:
        i9 = 1 + p_tb_boxSizeHeight;
        break label145;
        if ((i18 > -p_tb_stuff[(i11 + 5)]) && (i18 <= p_tb_boxSizeHeight))
        {
          i19 = i18 + paramInt3;
          i20 = paramInt2 + p_tb_stuff[(i11 + 2)];
          i21 = p_tb_stuff[i11];
          localCharSequence = p_tb_text.subSequence(i21, i21 + p_tb_stuff[(i11 + 1)]);
          i22 = i19 + 0;
          gfx_drawString(paramInt1, localCharSequence, i20, i22, 20);
          if (!p_cs_clean_from_pool(localCharSequence)) {}
        }
        while (i18 < 0)
        {
          int i19;
          int i20;
          int i21;
          CharSequence localCharSequence;
          int i22;
          i11 += 6;
          break;
        }
        break label210;
        label405:
        int i15 = -p_tb_stuff[i11] - 1;
        if (i15 < 16383)
        {
          if (i15 == 0) {}
          for (paramInt1 = j;; paramInt1 = tbi_getFont(p_tb_currenBoxId, i15))
          {
            i11++;
            break;
          }
        }
        int i16 = i15 - 16383;
        if (i16 == 0) {}
        for (int i17 = i;; i17 = tbi_getFontColor(p_tb_currenBoxId, i16))
        {
          gfx_setColor(i17);
          break;
        }
        label488:
        if ((i13 >= -p_tb_images[(i12 + 3)]) && (i13 < p_tb_boxSizeHeight))
        {
          i14 = paramInt2 + p_tb_images[(i12 + 1)];
          tbi_drawImage(p_tb_currenBoxId, p_tb_images[i12], i14, i13 + paramInt3);
        }
        while (i13 < 0)
        {
          int i14;
          i12 += 4;
          break;
        }
      }
      label554:
      i11 = 0;
    }
  }
  
  public static void tb_setBorderedLocation(int paramInt1, int paramInt2)
  {
    int i = paramInt1 - p_tbTextX;
    int j = paramInt2 - p_tbTextY;
    p_tbTextX = paramInt1;
    p_tbTextY = paramInt2;
    p_tbBorderX = i + p_tbBorderX;
    p_tbBorderY = j + p_tbBorderY;
  }
  
  public static void tb_skipSmoothScroll()
  {
    p_tb_scrollTime = 0;
    p_tb_updateSmoothScroll();
  }
  
  public static void tbi_drawImage(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt2 == 1)
    {
      gfx_drawImage(15, paramInt3, paramInt4, 20, 0);
      int i = paramInt3 + 28;
      int j = (platforms_fp_width >> 11) - 28 - 26;
      int k = 0;
      if (j < 0)
      {
        k = j;
        j = 0;
      }
      platform_fillHorizontal(16, i, paramInt4, j);
      gfx_drawImage(17, i + (j + k), paramInt4, 20, 0);
      return;
    }
    gfx_drawImage(textbox_getImgId(paramInt1, paramInt2), paramInt3, paramInt4, 20, 0);
  }
  
  public static int tbi_getFont(int paramInt1, int paramInt2)
  {
    switch (paramInt2)
    {
    default: 
      return -1;
    case 1: 
      return 0;
    case 2: 
      return 0;
    case 3: 
      return 0;
    case 4: 
      return 0;
    }
    return 0;
  }
  
  public static int tbi_getFontColor(int paramInt1, int paramInt2)
  {
    switch (paramInt2)
    {
    default: 
      return -1;
    case 1: 
      return 0;
    case 2: 
      return 52224;
    case 3: 
      return 13421772;
    case 4: 
      return 0;
    }
    return 0;
  }
  
  public static int tbi_getImageSize(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 1) {
      return 0xF | platforms_fp_width >> 11 << 16;
    }
    int i = textbox_getImgId(paramInt1, paramInt2);
    return gfx_getImageWidth(i) << 16 | gfx_getImageHeight(i);
  }
  
  public static int textbox_getImgId(int paramInt1, int paramInt2)
  {
    switch (paramInt2)
    {
    default: 
      return -1;
    case 2: 
      return 18;
    }
    return 19;
  }
  
  public static void textinput_paint()
  {
    gfx_setColor(16052202);
    gfx_fillRect(0, 0, dynamic_X_RES, dynamic_Y_RES);
    switch (doj_textInputMode)
    {
    }
    for (;;)
    {
      menu_paintSoftkeys(p_textinputOkLabel, 50);
      return;
      if (doj_gameOver)
      {
        (dynamic_Y_RES >> 4);
        doj_DrawGameBackground();
        label77:
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        if (!multiplayer_enabled)
        {
          doj_drawGameOverScreen();
          eg_paint();
          int i2 = popup_getBorderSize();
          int i3 = dynamic_Y_RES - 0 - 40;
          int i4 = (i3 - (i2 << 1)) / 3;
          int i5 = dynamic_X_RES;
          popup_drawBack(0, 0, i5, i3);
          int i6 = i4 + (0 + i2);
          int i7 = 0 + i2;
          i8 = p_clip_x;
          i9 = p_clip_y;
          i10 = p_clip_width;
          i11 = p_clip_height;
          gfx_setClip(i7, i6, i5 - (i2 << 1), i3 - (i2 << 1));
          gfx_setColor(0);
          gfx_drawString(0, p_textinputCaption, dynamic_X_RES >> 1, i6, 17);
          i12 = i6 + i4;
          i13 = dynamic_X_RES - gfx_stringWidth(0, p_textinputString) >> 1;
          if (!cursorBlink) {
            break label261;
          }
          gfx_setColor(0);
          gfx_drawString(0, p_textinputString, i13, i12, 20);
        }
        for (;;)
        {
          gfx_setClip(i8, i9, i10, i11);
          break;
          doj_drawMultiplayerGameOverScreen();
          break label77;
          label261:
          gfx_setColor(0);
          gfx_drawString(0, p_textinputString + "_", i13, i12, 20);
        }
        if (multiplayer_enabled)
        {
          int i = dynamic_Y_RES >> 4;
          emi_paint(9);
          eg_skipPaint();
          int j = gfx_getFontHeight(0) << 2;
          int k = (dynamic_Y_RES >> 1) - (dynamic_Y_RES >> 3) + (i << 1);
          popup_drawBack(i, k, dynamic_X_RES - (i << 1), j);
          int m = k + popup_getBorderSize();
          int n = i + popup_getBorderSize();
          gfx_setColor(0);
          gfx_drawString(0, p_textinputCaption, n, m, 20);
          int i1 = m + gfx_getFontHeight(0);
          if (cursorBlink)
          {
            gfx_setColor(0);
            gfx_drawString(0, p_textinputString, n, i1, 20);
          }
          else
          {
            gfx_setColor(0);
            gfx_drawString(0, p_textinputString + "_", n, i1, 20);
          }
        }
      }
    }
  }
  
  public static void tutorial_init()
  {
    tutorial_reset();
    tutorial_mode = 0;
  }
  
  public static void tutorial_keyPressed(int paramInt) {}
  
  public static void tutorial_keyReleased(int paramInt)
  {
    if (mrg_isKey(paramInt, 355)) {
      tutorial_nextScreen();
    }
  }
  
  public static void tutorial_nextScreen()
  {
    tutorial_mode = (short)(1 + tutorial_mode);
    String str;
    if (tutorial_mode == 1) {
      str = p_allTexts[64] + "\n" + p_allTexts[66];
    }
    for (;;)
    {
      popup_create(str, 1010, 68, (short)1);
      return;
      if (tutorial_mode == 2)
      {
        str = p_allTexts[65];
      }
      else
      {
        if (tutorial_mode != 3) {
          break;
        }
        str = p_allTexts[67];
      }
    }
    popup_delete();
    tutorial_active = false;
  }
  
  public static void tutorial_reset()
  {
    if (p_options[5] == 1) {}
    for (boolean bool = true;; bool = false)
    {
      tutorial_active = bool;
      return;
    }
  }
  
  public static void tutorial_screenSizeUpdate()
  {
    if ((tutorial_mode < 4) && (tutorial_active))
    {
      tutorial_mode = (short)(tutorial_mode - 1);
      tutorial_nextScreen();
    }
  }
  
  public static String txt_addThousandSeparator_s(int paramInt, String paramString)
  {
    return txt_addThousandSeparator_s("" + paramInt, paramString);
  }
  
  public static String txt_addThousandSeparator_s(String paramString1, String paramString2)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = paramString1.length();
    int j = i % 3;
    localStringBuffer.append(paramString1.substring(0, j));
    while (j < i)
    {
      if (j > 0) {
        localStringBuffer.append(paramString2);
      }
      localStringBuffer.append(paramString1.substring(j, j + 3));
      j += 3;
    }
    return localStringBuffer.toString();
  }
  
  public static void txt_loadGroup(int paramInt)
  {
    if (p_allTexts[p_indexTable2[(paramInt + 20)]] != null) {
      return;
    }
    try
    {
      data_openFile("l", p_indexTable3[(paramInt + 0)]);
      for (int i = p_indexTable2[(paramInt + 20)]; i < p_indexTable2[(20 + (paramInt + 1))]; i++)
      {
        int j = p_currentFile.readUnsignedByte();
        if (j == 255) {
          j = p_currentFile.readUnsignedShort();
        }
        char[] arrayOfChar = new char[j];
        for (int k = 0; k < j; k++)
        {
          int m = p_currentFile.readUnsignedByte();
          arrayOfChar[k] = ((char)p_indexTable2[(m + 25)]);
        }
        p_allTexts[i] = new String(arrayOfChar);
      }
      data_closeFile();
      return;
    }
    catch (Exception localException) {}
  }
  
  public static String txt_stringParam(String paramString1, String paramString2, int paramInt)
  {
    String str = "%" + paramInt;
    int i = paramString1.indexOf(str);
    if (i == -1) {
      return paramString1;
    }
    return paramString1.substring(0, i) + paramString2 + paramString1.substring(i + str.length(), paramString1.length());
  }
  
  public static String txt_stringParam(String paramString, String[] paramArrayOfString)
  {
    for (int i = 0; i < paramArrayOfString.length; i++) {
      paramString = txt_stringParam(paramString, paramArrayOfString[i], i + 1);
    }
    return paramString;
  }
  
  public static void txt_unloadGroup(int paramInt)
  {
    for (int i = p_indexTable2[(paramInt + 20)]; i < p_indexTable2[(20 + (paramInt + 1))]; i++) {
      p_allTexts[i] = null;
    }
  }
  
  public static String uid_getDeviceID()
  {
    Object localObject = "";
    try
    {
      TelephonyManager localTelephonyManager = (TelephonyManager)p_mrgame.getSystemService("phone");
      if (localTelephonyManager != null)
      {
        if (localTelephonyManager.getDeviceId() != null)
        {
          String str = "android.com.device." + localTelephonyManager.getDeviceId();
          localObject = str;
        }
      }
      else {
        return (String)localObject;
      }
      return null;
    }
    catch (Exception localException) {}
    return (String)localObject;
  }
  
  public static String uid_getId()
  {
    if (p_uid_instanceId == null) {
      p_uid_loadInstanceID();
    }
    int i;
    String str2;
    StringBuilder localStringBuilder;
    if (p_uid_instanceId == null)
    {
      p_uid_instanceId = "" + (int)System.currentTimeMillis();
      String str1 = p_uid_instanceId;
      if (p_uid_instanceId.length() - 9 >= 0) {
        break label171;
      }
      i = 0;
      p_uid_instanceId = str1.substring(i);
      str2 = "" + smoothtime;
      localStringBuilder = new StringBuilder().append("").append(p_uid_instanceId);
      if (str2.length() - 6 >= 0) {
        break label184;
      }
    }
    label171:
    label184:
    for (int j = 0;; j = str2.length() - 6)
    {
      p_uid_instanceId = str2.substring(j);
      if (p_uid_instanceId.length() > 15) {
        p_uid_instanceId = p_uid_instanceId.substring(0, 14);
      }
      p_uid_saveInstanceID();
      return p_uid_instanceId;
      i = p_uid_instanceId.length() - 9;
      break;
    }
  }
  
  public static void video_play(int paramInt)
  {
    m_currentvideoId = paramInt;
    m_videoPlaying = true;
    m_videoCallback_called = false;
    p_mrgame.runOnUiThread(mVideoCallback);
    while (!m_videoCallback_called) {}
    while (!mVideoView.isPlaying()) {}
    int i;
    do
    {
      i = mVideoView.getCurrentPosition();
    } while (i < mVideoView.getDuration());
    m_videoPlaying = false;
    p_mrgame.runOnUiThread(mVideoCallback);
  }
  
  public void android_exitApp()
  {
    mSensorManager.unregisterListener(mSensorListener);
    Process.killProcess(Process.myPid());
  }
  
  public void createViews()
  {
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
    mViewGroup = new AbsoluteLayout(this);
    mDimView = new ImageView(this);
    mDimView.setLayoutParams(localLayoutParams);
    mDimRect = new ColorDrawable(-16777216);
    mDimView.setImageDrawable(mDimRect);
    if (api_version >= 3) {}
    try
    {
      Class.forName("android.graphics.drawable.ColorDrawable").getDeclaredMethod("mutate", new Class[] { IBinder.class }).invoke(mDimRect, new Object[0]);
      mDimRect.setAlpha(164);
      for (;;)
      {
        mMrgView = new MrgView(this);
        mMrgView.setOnTouchListener(this);
        mLinearLayout = new LinearLayout(this);
        mEditText = new EditText(this);
        mEditText.setSingleLine();
        mEditCaption = new TextView(this);
        mTextInputButton = new Button(this);
        mTextInputButton.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            if (MrGame.api_version >= 3) {}
            try
            {
              Class localClass = Class.forName("android.view.inputmethod.InputMethodManager");
              Object localObject = MrGame.p_mrgame.getSystemService("input_method");
              Class[] arrayOfClass = new Class[2];
              arrayOfClass[0] = IBinder.class;
              arrayOfClass[1] = Integer.TYPE;
              Method localMethod = localClass.getDeclaredMethod("hideSoftInputFromWindow", arrayOfClass);
              Object[] arrayOfObject = new Object[2];
              arrayOfObject[0] = MrGame.mEditText.getWindowToken();
              arrayOfObject[1] = new Integer(0);
              localMethod.invoke(localObject, arrayOfObject);
              MrGame.mDo_textinput = false;
              return;
            }
            catch (Exception localException)
            {
              for (;;) {}
            }
          }
        });
        mEditorCallback = new EditorCallback();
        mDo_textinput = false;
        LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-1, -1, 1.0F);
        mLinearLayout.setLayoutParams(localLayoutParams1);
        mLinearLayout.setOrientation(1);
        mLinearLayout.setGravity(17);
        mVideoView = new VideoView(this);
        mVideoCallback = new VideoCallback();
        m_videoPlaying = false;
        m_videoCallback_called = false;
        mViewAnimator = new ViewAnimator(this);
        mViewAnimator.setLayoutParams(localLayoutParams);
        mLinearLayout.addView(mEditCaption);
        mLinearLayout.addView(mEditText);
        mLinearLayout.addView(mTextInputButton);
        mViewGroup.addView(mMrgView);
        mViewAnimator.addView(mViewGroup, 0, localLayoutParams);
        mViewAnimator.addView(mVideoView, 1, localLayoutParams);
        return;
        mDimRect.setAlpha(164);
      }
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public void hideNotify()
  {
    if ((p_em_introMode) && (!p_em_confirming) && (!p_initializingState)) {
      p_mrgame.keyPressed(p_indexTable2[11] - 50);
    }
    repaintAll = true;
    sfx_pauseAll();
    if (p_gameDisplay) {}
    p_paused = true;
  }
  
  public void keyPressed(int paramInt)
  {
    int i;
    if (paramInt + 50 >= 450)
    {
      i = 1;
      if (paramInt >= -50) {
        break label32;
      }
    }
    label32:
    for (int j = 1;; j = 0)
    {
      if ((i | j) == 0) {
        break label37;
      }
      return;
      i = 0;
      break;
    }
    label37:
    p_newKeyEvent = true;
    if (p_keyCounter >= 19) {
      mrg_resetKeys();
    }
    int k = paramInt + 50;
    p_keyBuffer[p_keyCounter] = k;
    p_keyTypeBuffer[p_keyCounter] = true;
    p_keyCounter = 1 + p_keyCounter;
  }
  
  public void keyReleased(int paramInt)
  {
    int i;
    if (paramInt + 50 >= 450)
    {
      i = 1;
      if (paramInt >= -50) {
        break label32;
      }
    }
    label32:
    for (int j = 1;; j = 0)
    {
      if ((i | j) == 0) {
        break label37;
      }
      return;
      i = 0;
      break;
    }
    label37:
    p_newKeyEvent = true;
    if (p_keyCounter >= 19) {
      mrg_resetKeys();
    }
    int k = paramInt + 50;
    p_keyBuffer[p_keyCounter] = k;
    p_keyTypeBuffer[p_keyCounter] = false;
    p_keyCounter = 1 + p_keyCounter;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (!mDo_textinput) {}
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (activityInited)
    {
      requestWindowFeature(1);
      getWindow().setFlags(1024, 1024);
      api_version = Integer.parseInt(Build.VERSION.SDK);
      mDo_textinput = false;
      createViews();
      mSensorManager = (SensorManager)getSystemService("sensor");
      mSensorListener = new MrgSensorListener_old();
      if (!mSensorManager.registerListener(mSensorListener, 2, 1)) {}
      mViewAnimator.setDisplayedChild(0);
      getResources().getConfiguration();
      Display localDisplay2 = getWindowManager().getDefaultDisplay();
      device_width = localDisplay2.getWidth();
      device_height = localDisplay2.getHeight();
      dynamic_X_RES = device_width;
      dynamic_Y_RES = device_height;
      device_orientation = 1;
      return;
    }
    requestWindowFeature(1);
    getWindow().setFlags(1024, 1024);
    api_version = Integer.parseInt(Build.VERSION.SDK);
    mDo_textinput = false;
    createViews();
    mSensorManager = (SensorManager)getSystemService("sensor");
    if (!mSensorManager.registerListener(new MrgSensorListener_old(), 2, 1)) {}
    mViewAnimator.setDisplayedChild(0);
    setContentView(mViewAnimator);
    getResources().getConfiguration();
    Display localDisplay1 = getWindowManager().getDefaultDisplay();
    device_width = localDisplay1.getWidth();
    device_height = localDisplay1.getHeight();
    dynamic_X_RES = device_width;
    dynamic_Y_RES = device_height;
    device_orientation = 1;
    TelephonyManager localTelephonyManager = (TelephonyManager)getSystemService("phone");
    assert (localTelephonyManager != null);
    mMrgCallStateListener = new MrgCallStateListener();
    localTelephonyManager.listen(mMrgCallStateListener, 32);
    p_mrgame = this;
    p_thread = new Thread(p_mrgame);
    thread_start_status = 1;
    android_appStatus = 1;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    keyPressed(paramInt);
    return true;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    keyReleased(paramInt);
    AudioManager localAudioManager = (AudioManager)p_mrgame.getSystemService("audio");
    if (paramInt == 24) {
      localAudioManager.adjustStreamVolume(3, 1, 1);
    }
    while (paramInt != 25) {
      return true;
    }
    localAudioManager.adjustStreamVolume(3, -1, 1);
    return true;
  }
  
  public void onPause()
  {
    super.onPause();
    do
    {
      synchronized (p_pauseLock)
      {
        p_pauseLock[0] = true;
        p_pauseLock.notifyAll();
        if (isFinishing())
        {
          android_exitApp();
          return;
        }
      }
      p_paused = true;
    } while ((thread_start_status != 2) || (android_appStatus < 1));
    p_mrgame.hideNotify();
  }
  
  public void onResume()
  {
    super.onResume();
    if (p_paused) {
      p_mrgame.showNotify();
    }
    p_paused = false;
    if (activityInited) {
      setContentView(mViewAnimator);
    }
    synchronized (p_pauseLock)
    {
      do
      {
        p_pauseLock[0] = false;
        p_pauseLock.notifyAll();
        return;
      } while (thread_start_status != 1);
      p_thread.start();
      thread_start_status = 2;
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getRawX();
    float f2 = paramMotionEvent.getRawY();
    if ((f1 < 0.0F) || (f2 < 0.0F) || (f1 > dynamic_X_RES) || (f2 > dynamic_Y_RES))
    {
      if (f1 >= dynamic_X_RES) {
        f1 = dynamic_X_RES - 1;
      }
      if (f2 >= dynamic_Y_RES) {
        f2 = dynamic_Y_RES - 1;
      }
      if (f1 < 0.0F) {
        f1 = 0.0F;
      }
      if (f2 < 0.0F) {
        f2 = 0.0F;
      }
      pointerDragged((int)f1, (int)f2);
      pointerReleased((int)f1, (int)f2);
    }
    try
    {
      for (;;)
      {
        Thread.sleep(16L);
        return true;
        switch (paramMotionEvent.getAction())
        {
        default: 
          return false;
        case 0: 
          pointerPressed((int)f1, (int)f2);
          break;
        case 1: 
          pointerReleased((int)f1, (int)f2);
          break;
        case 2: 
          pointerDragged((int)f1, (int)f2);
        }
      }
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean) {
      if (3 == android_appStatus) {
        android_appStatus = 1;
      }
    }
    while (1 != android_appStatus) {
      return;
    }
    android_appStatus = 3;
  }
  
  public int p_acceleration_x()
  {
    return p_acceleration_x;
  }
  
  public int p_acceleration_y()
  {
    return p_acceleration_y;
  }
  
  public int p_acceleration_z()
  {
    return p_acceleration_z;
  }
  
  public void p_repaintScreen()
  {
    p_paintFinished = false;
    p_doPaint = true;
    while (!surfaceReady) {
      try
      {
        Thread.sleep(1000L);
      }
      catch (Exception localException) {}
    }
    if (surfaceReady)
    {
      Canvas localCanvas = mSurfaceHolder.lockCanvas(null);
      if (localCanvas != null)
      {
        paint(localCanvas);
        mSurfaceHolder.unlockCanvasAndPost(localCanvas);
      }
    }
  }
  
  public void paint(Canvas paramCanvas)
  {
    p_fonts_activeFont = -1;
    if (!p_doPaint) {
      return;
    }
    p_doPaint = false;
    p_activeGraphics = paramCanvas;
    p_realPaint();
    p_paintFinished = true;
  }
  
  public void pointerDragged(int paramInt1, int paramInt2)
  {
    p_pointer_dragged = true;
    p_pointer_drag_x = p_pointer_lastPress_x - paramInt1;
    p_pointer_drag_y = p_pointer_lastPress_y - paramInt2;
    p_pointer_x = paramInt1;
    p_pointer_y = paramInt2;
    p_pointer_moved2 = true;
  }
  
  public void pointerMoved(int paramInt1, int paramInt2)
  {
    p_pointer_x = paramInt1;
    p_pointer_y = paramInt2;
    p_pointer_moved2 = true;
  }
  
  public void pointerPressed(int paramInt1, int paramInt2)
  {
    p_pointer_x = paramInt1;
    p_pointer_y = paramInt2;
    p_pointer_lastPress_x = paramInt1;
    p_pointer_lastPress_y = paramInt2;
    p_pointer_moved2 = true;
    p_pointer_drag_y = 0;
    p_pointer_drag_x = 0;
    if ((p_pointer_x >= 0) && (p_pointer_x < dynamic_X_RES) && (p_pointer_y >= 0) && (p_pointer_y < dynamic_Y_RES)) {
      keyPressed(300);
    }
  }
  
  public void pointerReleased(int paramInt1, int paramInt2)
  {
    p_pointer_x = paramInt1;
    p_pointer_y = paramInt2;
    p_pointer_moved2 = true;
    p_pointer_dragged = false;
    p_pointer_drag_y = 0;
    p_pointer_drag_x = 0;
    if ((p_pointer_x >= 0) && (p_pointer_x < dynamic_X_RES) && (p_pointer_y >= 0) && (p_pointer_y < dynamic_Y_RES)) {
      keyReleased(300);
    }
  }
  
  public void run()
  {
    mainTextLoaded = false;
    hs_currentTable = -1;
    p_paintFinished = true;
    p_tb_inputHandleFlags = 0;
    p_tb_initSmoothScroll(0, 0);
    p_tb_scroll = 0;
    p_tb_timeLeft = 0;
    p_tb_changeTime = 0;
    p_tb_text = null;
    p_loadIndexTables();
    p_inGame = false;
    p_gameDisplay = false;
    p_forcedPaint = false;
    repaintScreen = false;
    repaintAll = true;
    p_loadMain();
    p_inGame = false;
    p_gameDisplay = false;
    p_forcedPaint = false;
    repaintScreen = false;
    repaintAll = true;
    p_lb_fillScreen = false;
    p_paused = false;
    activityInited = true;
    menu_start();
    mrg_resetKeys();
    for (;;)
    {
      if ((p_thread == null) || (p_paused)) {}
      try
      {
        Thread.sleep(100L);
        if (p_thread != null) {
          continue;
        }
        do
        {
          do
          {
            do
            {
              return;
              mrp_doTime();
              p_runKeyEvents();
            } while (p_thread == null);
            if (p_tb_inputHandleFlags != 0) {
              p_tb_inputHandlerLogic();
            }
            p_eg_logic();
            p_eg_updatePointer();
            if (!p_gameDisplay) {
              break label258;
            }
            if (game_logic()) {
              break;
            }
            p_initializingState = true;
          } while (p_thread == null);
          game_unload();
          mrg_resetTime();
          p_inGame = false;
          p_gameDisplay = false;
          repaintAll = true;
          repaintScreen = false;
          menu_start();
          mrg_resetKeys();
          p_initializingState = false;
        } while (p_thread == null);
        p_tb_updateSmoothScroll();
        if (repaintScreen)
        {
          p_mrgame.p_repaintScreen();
          p_newKeyEvent = false;
        }
      }
      catch (Exception localException3)
      {
        try
        {
          label258:
          do
          {
            do
            {
              do
              {
                do
                {
                  Thread.yield();
                } while ((!p_paintFinished) || (p_newKeyEvent));
                repaintScreen = false;
                break;
              } while (menu_logic());
              p_initializingState = true;
            } while (p_thread == null);
            repaintScreen = false;
            repaintAll = true;
            p_gameDisplay = true;
            if (!p_inGame)
            {
              menu_unload();
              mrg_resetTime();
              p_inGame = true;
              game_start();
            }
            for (;;)
            {
              mrg_resetKeys();
              sfx_unpauseAll();
              p_initializingState = false;
              break;
              if (p_tbBackupString != null)
              {
                p_tb2_make(p_tbBackupId, p_tbBackupFont, p_tbBackupString, p_tbBackupWidth, p_tbBackupHeight, false, p_tbBackupEmulateOld);
                p_tbBorderX = p_tbBackupBorderX;
                p_tbBorderY = p_tbBackupBorderY;
                p_tbBorderWidth = p_tbBackupBorderWidth;
                p_tbBorderHeight = p_tbBackupBorderHeight;
                p_tbTextX = p_tbBackupTextX;
                p_tbTextY = p_tbBackupTextY;
                p_tb_inputHandleFlags = p_tbBackupHandleFlags;
              }
            }
          } while (p_thread == null);
          try
          {
            Thread.yield();
          }
          catch (Exception localException1) {}
          continue;
          localException3 = localException3;
        }
        catch (Exception localException2)
        {
          for (;;) {}
        }
      }
    }
  }
  
  public void showNotify()
  {
    if (!p_initializingState) {
      game_showNotify();
    }
    mrg_resetKeys();
    repaintAll = true;
    repaintScreen = true;
    sfx_unpauseAll();
    if ((p_em_introMode) && (!p_em_confirming) && (!p_initializingState)) {
      p_mrgame.keyPressed(p_indexTable2[11] - 50);
    }
    p_paused = false;
  }
  
  public void sizeChanged(int paramInt1, int paramInt2)
  {
    dynamic_X_RES = paramInt1;
    dynamic_Y_RES = paramInt2;
    repaintAll = true;
    game_resolutionChanged();
    int i = p_tb_inputHandleFlags;
    int j = p_tb_backupConfirmHandleFlags;
    if (!p_gameDisplay) {
      p_em_resolutionChanged();
    }
    p_tb_inputHandleFlags = i;
    if (p_em_confirming)
    {
      p_em_confirming = false;
      em_confirm(p_em_confirmElement, true);
    }
    p_tb_backupConfirmHandleFlags = j;
  }
  
  public static class CharArraySeq
    implements CharSequence
  {
    public char[] arr;
    public int len;
    public int start;
    
    public char charAt(int paramInt)
    {
      return this.arr[(paramInt + this.start)];
    }
    
    public int length()
    {
      return this.len;
    }
    
    public CharSequence subSequence(int paramInt1, int paramInt2)
    {
      return MrGame.charseq_wrapArray(this.arr, paramInt1 + this.start, paramInt2 - paramInt1);
    }
    
    public String toString()
    {
      return new String(this.arr, this.start, this.len);
    }
  }
  
  public static class GameObject
  {
    int fp_offsetX;
    int fp_offsetY;
    int fp_rangeX;
    int fp_rangeY;
    int fp_timeUpdate;
    int fp_velY;
    int fp_x;
    int fp_y;
    int id;
  }
  
  public static class Gui
  {
    int elementAmount;
    MrGame.GuiElement[] elementList;
  }
  
  public static class GuiElement
  {
    int align;
    int ax;
    int ay;
    int drag_VX;
    int drag_VY;
    int drag_currX;
    int drag_currY;
    int drag_startOffsetX;
    int drag_startOffsetY;
    int drag_startX;
    int drag_startY;
    boolean draggableHoriz;
    boolean draggableVert;
    int eg_id;
    int elementLevel;
    boolean enabled;
    int event;
    int eventMask;
    int eventTime;
    int[] eventTimeList;
    int h;
    int id;
    boolean isDragging;
    boolean isStatic;
    boolean keypadFocus;
    int[] params;
    int pos_align;
    int pressX;
    int pressY;
    String txt;
    int type;
    boolean visible;
    int w;
    int x;
    int y;
  }
  
  public static class GuiKeyBind
  {
    int action;
    int elId;
    int key;
  }
  
  private static class MrgView
    extends SurfaceView
    implements SurfaceHolder.Callback
  {
    public MrgView(Context paramContext)
    {
      super();
      MrGame.mSurfaceHolder = getHolder();
      MrGame.mSurfaceHolder.setType(2);
      MrGame.mSurfaceHolder.setKeepScreenOn(true);
      MrGame.mSurfaceHolder.addCallback(this);
    }
    
    public void resolutionChanged() {}
    
    public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
    {
      paramSurfaceHolder.setSizeFromLayout();
    }
    
    public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
    {
      MrGame.surfaceReady = true;
      MrGame.p_paused = false;
      if (MrGame.activityInited) {
        MrGame.p_mrgame.showNotify();
      }
    }
    
    public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
    {
      MrGame.surfaceReady = false;
    }
  }
  
  public static class Platform
  {
    int fp_x;
    int fp_y;
    int id;
    int objOffset;
    int speed;
    int updateTime;
  }
  
  public static class Projectile
  {
    int fp_pos_x;
    int fp_pos_y;
    int fp_vel_x;
    int fp_vel_y;
  }
}


/* Location:              F:\Java\android-giro-gamer\Decompile\1\doodle_dex2jar.jar!\com\realarcade\DOJ\MrGame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */