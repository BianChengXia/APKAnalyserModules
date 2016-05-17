package com.tencent.mobileqq.msf.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

final class h
  extends BroadcastReceiver
{
  h() {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (TextUtils.isEmpty(paramContext)) {
      if (QLog.isColorLevel()) {
        QLog.d(f.a, 2, "onReceive broadcastreceiver.action null");
      }
    }
    for (;;)
    {
      return;
      QLog.d(f.a, 1, "onReceive broadcastreceiver.action = " + paramContext);
      boolean bool;
      if (paramContext.equals("android.intent.action.SCREEN_OFF"))
      {
        f.b = false;
        w.P = -1;
        w.Q.set(false);
        if ((com.tencent.mobileqq.msf.core.a.a.q()) || (f.e()))
        {
          f.f().removeMessages(10000);
          f.f().sendEmptyMessageDelayed(10000, com.tencent.mobileqq.msf.core.a.a.o());
        }
        for (;;)
        {
          try
          {
            bool = com.tencent.mobileqq.msf.core.a.a.aI();
            if (!bool) {
              break;
            }
            try
            {
              coresender.F.c().c();
              return;
            }
            catch (Exception paramContext) {}
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d(f.a, 2, "failed to call adaptorcontroller screenoff ", paramContext);
            return;
          }
          catch (Exception paramContext)
          {
            QLog.d(f.a, 1, "onReceive ScreenOff to controller failed " + paramContext.toString(), paramContext);
            return;
          }
          f.c += 1;
          if (f.c == BaseConstants.checkExpiresLogScreenOffCount) {
            f.g();
          }
        }
      }
      if (paramContext.equals("android.intent.action.SCREEN_ON"))
      {
        f.b = true;
        f.f().removeMessages(10000);
        try
        {
          bool = com.tencent.mobileqq.msf.core.a.a.aI();
          if (bool)
          {
            try
            {
              coresender.F.c().d();
              return;
            }
            catch (Exception paramContext) {}
            if (QLog.isColorLevel())
            {
              QLog.d(f.a, 2, "failed to call adaptorcontroller screenon ", paramContext);
              return;
            }
          }
        }
        catch (Exception paramContext)
        {
          QLog.d(f.a, 1, "onReceive ScreenOn to controller failed " + paramContext.toString(), paramContext);
        }
      }
    }
  }
}
