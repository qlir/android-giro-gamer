package com.facebook.android;

public class FacebookError
  extends Throwable
{
  private static final long serialVersionUID = 1L;
  private int mErrorCode = 0;
  private String mErrorType;
  
  public FacebookError(String paramString)
  {
    super(paramString);
  }
  
  public FacebookError(String paramString1, String paramString2, int paramInt)
  {
    super(paramString1);
    this.mErrorType = paramString2;
    this.mErrorCode = paramInt;
  }
  
  public int getErrorCode()
  {
    return this.mErrorCode;
  }
  
  public String getErrorType()
  {
    return this.mErrorType;
  }
}


/* Location:              F:\Java\android-giro-gamer\Decompile\1\doodle_dex2jar.jar!\com\facebook\android\FacebookError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */