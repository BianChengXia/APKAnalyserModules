package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import nhg;

public class CheckMsgCount
  extends AsyncStep
{
  public CheckMsgCount()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected int a()
  {
    ThreadManager.a(new nhg(this), 5, null, false);
    return 7;
  }
}
