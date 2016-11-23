package com.facebook.android;

public class DialogError
  extends Throwable
{
  private static final long serialVersionUID = 1L;
  private int mErrorCode;
  private String mFailingUrl;
  
  public DialogError(String paramString1, int paramInt, String paramString2)
  {
    super(paramString1);
    this.mErrorCode = paramInt;
    this.mFailingUrl = paramString2;
  }
  
  int getErrorCode()
  {
    return this.mErrorCode;
  }
  
  String getFailingUrl()
  {
    return this.mFailingUrl;
  }
}


/* Location:              F:\Java\android-giro-gamer\Decompile\1\doodle_dex2jar.jar!\com\facebook\android\DialogError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */