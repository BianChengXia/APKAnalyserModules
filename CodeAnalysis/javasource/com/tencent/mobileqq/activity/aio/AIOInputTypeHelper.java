package com.tencent.mobileqq.activity.aio;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kpi;
import mqq.os.MqqHandler;

public class AIOInputTypeHelper
{
  public static final String a = "sp_aio_input_helper";
  public static volatile boolean a = false;
  public static final String b = "ptt_guide_have_show";
  public static boolean b = false;
  public static final String c = "ptt_first_open_c2c";
  public static boolean c = false;
  private static boolean d;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    a = false;
    b = false;
    d = false;
  }
  
  public AIOInputTypeHelper() {}
  
  public static SharedPreferences a(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.a().getSharedPreferences("sp_aio_input_helper_" + paramQQAppInterface.getAccount(), 0);
  }
  
  public static void a()
  {
    c = true;
    BaseApplication.getContext().getSharedPreferences("sp_upgrade", 0).edit().putBoolean("upgrade", true).commit();
  }
  
  /* Error */
  public static void a(QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnull +11 -> 15
    //   7: getstatic 30	com/tencent/mobileqq/activity/aio/AIOInputTypeHelper:d	Z
    //   10: istore_1
    //   11: iload_1
    //   12: ifeq +7 -> 19
    //   15: ldc 2
    //   17: monitorexit
    //   18: return
    //   19: aload_0
    //   20: invokestatic 90	com/tencent/mobileqq/activity/aio/AIOInputTypeHelper:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Landroid/content/SharedPreferences;
    //   23: ldc 13
    //   25: iconst_1
    //   26: invokeinterface 94 3 0
    //   31: putstatic 26	com/tencent/mobileqq/activity/aio/AIOInputTypeHelper:a	Z
    //   34: iconst_1
    //   35: putstatic 30	com/tencent/mobileqq/activity/aio/AIOInputTypeHelper:d	Z
    //   38: goto -23 -> 15
    //   41: astore_0
    //   42: ldc 2
    //   44: monitorexit
    //   45: aload_0
    //   46: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	paramQQAppInterface	QQAppInterface
    //   10	2	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   7	11	41	finally
    //   19	38	41	finally
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    boolean bool1 = false;
    if (!d) {
      a(paramQQAppInterface);
    }
    if (a)
    {
      a = false;
      ThreadManager.a().post(new kpi(paramQQAppInterface));
      boolean bool2 = true;
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.aio.BaseChatPie", 2, "inputhelper : need guide");
        bool1 = bool2;
      }
    }
    return bool1;
  }
}
