package com.tencent.mobileqq.activity.aio;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class AbilityUtils
{
  public AbilityUtils()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 1003) || (paramInt == 1006) || (paramInt == 1000) || (paramInt == 1020) || (paramInt == 1004) || (paramInt == 1025);
  }
}
