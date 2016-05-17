package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.subaccount.SubAccountProtocManager;
import com.tencent.qphone.base.util.QLog;

public class GetSubAccount
  extends AsyncStep
{
  public GetSubAccount()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected int a()
  {
    SubAccountProtocManager localSubAccountProtocManager = (SubAccountProtocManager)a.b.getManager(27);
    if (localSubAccountProtocManager != null) {
      localSubAccountProtocManager.a();
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "subaccount onGetSubAccountBind start int QQInitHandler...");
    }
    return 7;
  }
}
