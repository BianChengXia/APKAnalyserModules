package com.tencent.mobileqq.app.readinjoy;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ReadInJoyObserver
  implements BusinessObserver
{
  public ReadInJoyObserver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
      } while (paramObject == null);
      if (!paramBoolean) {
        break;
      }
      paramObject = (Object[])paramObject;
    } while (paramObject.length < 2);
    a(true, ((Boolean)paramObject[0]).booleanValue(), ((Integer)paramObject[1]).intValue());
    return;
    a(false, false, -1);
  }
}
