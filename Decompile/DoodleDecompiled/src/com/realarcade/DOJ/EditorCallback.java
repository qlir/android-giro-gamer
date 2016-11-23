package com.realarcade.DOJ;

import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.view.View;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.lang.reflect.Method;

class EditorCallback
  implements Runnable
{
  public static final int ANDROID_GAMEVIEW = 0;
  public static final int ANDROID_VIDEOVIEW = 1;
  
  public void run()
  {
    if (MrGame.mDo_textinput)
    {
      MrGame.mViewGroup.addView(MrGame.mDimView);
      MrGame.mViewGroup.addView(MrGame.mLinearLayout);
      MrGame.mEditCaption.setText(MrGame.mTextCaption);
      MrGame.mEditText.setText(MrGame.mDefaultText);
      MrGame.mTextInputButton.setText(MrGame.mOkText);
      InputFilter[] arrayOfInputFilter = new InputFilter[1];
      arrayOfInputFilter[0] = new InputFilter.LengthFilter(MrGame.mTextMaxLength);
      MrGame.mEditText.setFilters(arrayOfInputFilter);
      MrGame.mEditText.requestFocusFromTouch();
      MrGame.mEditText.selectAll();
      if (MrGame.api_version < 3) {}
    }
    try
    {
      Class localClass = Class.forName("android.view.inputmethod.InputMethodManager");
      Object localObject = MrGame.p_mrgame.getSystemService("input_method");
      Class[] arrayOfClass = new Class[2];
      arrayOfClass[0] = View.class;
      arrayOfClass[1] = Integer.TYPE;
      Method localMethod = localClass.getDeclaredMethod("showSoftInput", arrayOfClass);
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = MrGame.mEditText;
      arrayOfObject[1] = new Integer(0);
      localMethod.invoke(localObject, arrayOfObject);
      return;
    }
    catch (Exception localException) {}
    MrGame.mViewGroup.removeView(MrGame.mDimView);
    MrGame.mViewGroup.removeView(MrGame.mLinearLayout);
    return;
  }
}


/* Location:              F:\Java\android-giro-gamer\Decompile\1\doodle_dex2jar.jar!\com\realarcade\DOJ\EditorCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */