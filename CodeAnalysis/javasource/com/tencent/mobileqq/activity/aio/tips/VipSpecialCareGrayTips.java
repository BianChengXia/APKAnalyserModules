package com.tencent.mobileqq.activity.aio.tips;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.text.TextUtils;
import android.text.format.Time;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialCareManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class VipSpecialCareGrayTips
  implements GrayTipsTask, Runnable
{
  private static final String jdField_a_of_type_JavaLangString = VipSpecialCareGrayTips.class.getSimpleName();
  private static final String jdField_b_of_type_JavaLangString = "key_specialcare_gray_tips_";
  private static final String jdField_c_of_type_JavaLangString = "key_specialcare_tips_count_";
  private final int jdField_a_of_type_Int = 30;
  private final long jdField_a_of_type_Long = 604800000L;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private Time jdField_a_of_type_AndroidTextFormatTime;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private TipsManager jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean jdField_a_of_type_Boolean = false;
  private final int jdField_b_of_type_Int;
  private final int jdField_c_of_type_Int;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public VipSpecialCareGrayTips(QQAppInterface paramQQAppInterface, TipsManager paramTipsManager, Activity paramActivity, SessionInfo paramSessionInfo)
  {
    b = 20;
    c = 2;
    jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager = paramTipsManager;
    jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    jdField_a_of_type_AndroidContentSharedPreferences = BaseApplication.getContext().getSharedPreferences("free_call", 0);
  }
  
  private boolean a()
  {
    boolean bool = false;
    SharedPreferences localSharedPreferences = jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("com.tencent.mobileqq_preferences", 4);
    if ((QvipSpecialCareManager.a(jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (localSharedPreferences.getBoolean("specialcare_already_set" + jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false))) {
      bool = true;
    }
    return bool;
  }
  
  private boolean a(String paramString)
  {
    boolean bool = false;
    paramString = "key_specialcare_tips_count_" + jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "_" + paramString;
    if (jdField_a_of_type_AndroidContentSharedPreferences.getInt(paramString, 0) >= 2) {
      bool = true;
    }
    return bool;
  }
  
  private boolean b()
  {
    boolean bool2 = true;
    String str = "key_specialcare_gray_tips_" + jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "_" + jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    str = jdField_a_of_type_AndroidContentSharedPreferences.getString(str, "");
    long l1 = MessageCache.a() * 1000L;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(str))
    {
      if (jdField_a_of_type_AndroidTextFormatTime == null) {
        jdField_a_of_type_AndroidTextFormatTime = new Time();
      }
      jdField_a_of_type_AndroidTextFormatTime.set(l1);
      int i = jdField_a_of_type_AndroidTextFormatTime.year;
      int j = jdField_a_of_type_AndroidTextFormatTime.month;
      int k = jdField_a_of_type_AndroidTextFormatTime.monthDay;
      int m = jdField_a_of_type_AndroidTextFormatTime.hour;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "curDate :" + i + " - " + j + " - " + k + " - " + m);
      }
      long l2 = Long.parseLong(str);
      jdField_a_of_type_AndroidTextFormatTime.set(l2);
      i = jdField_a_of_type_AndroidTextFormatTime.year;
      j = jdField_a_of_type_AndroidTextFormatTime.month;
      k = jdField_a_of_type_AndroidTextFormatTime.monthDay;
      m = jdField_a_of_type_AndroidTextFormatTime.hour;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "lastShowDate :" + i + " - " + j + " - " + k + " - " + m);
      }
      bool1 = bool2;
      if (l1 - l2 <= 604800000L)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "has show in a week, just return;");
        }
        bool1 = false;
      }
    }
    return bool1;
  }
  
  private boolean c()
  {
    if ((!b()) || (a()) || (a(jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      return false;
    }
    long l = System.currentTimeMillis() / 1000L;
    Object localObject1 = jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "no message. shouldShowTips=false ");
      }
      return false;
    }
    localObject1 = ((List)localObject1).iterator();
    int k = 0;
    int m = 0;
    int i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (MessageRecord)((Iterator)localObject1).next();
      int i2 = i;
      int i1 = k;
      int j;
      int n;
      int i4;
      if (time >= l - 86400L)
      {
        i2 = i;
        i1 = k;
        if (time <= l)
        {
          j = k;
          if (((MessageRecord)localObject2).isSend())
          {
            j = k;
            if (msgtype == 64536)
            {
              j = k;
              if (!jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b((MessageRecord)localObject2))
              {
                j = k;
                if (extraflag != 32768) {
                  j = k + 1;
                }
              }
            }
          }
          if (msgtype == 63534)
          {
            if (((MessageRecord)localObject2).isSend())
            {
              i2 = i;
              i1 = j;
              if (!jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b((MessageRecord)localObject2))
              {
                i2 = i;
                i1 = j;
                if (extraflag == 32768) {}
              }
            }
            else
            {
              m += 1;
              k = j;
              j = m;
              if (k <= 30) {
                break label642;
              }
              if (QLog.isColorLevel()) {
                QLog.d(jdField_a_of_type_JavaLangString, 2, "sendMsgCount>30. shouldShowTips=true , count=" + k);
              }
              return true;
            }
          }
          else
          {
            i2 = i;
            i1 = j;
            if (msgtype == 63527)
            {
              i2 = i;
              i1 = j;
              if ((localObject2 instanceof MessageForVideo))
              {
                localObject2 = (MessageForVideo)localObject2;
                ((MessageForVideo)localObject2).parse();
                i2 = i;
                i1 = j;
                if (text != null)
                {
                  i2 = i;
                  i1 = j;
                  if (text.contains(BaseApplicationImpl.a().getResources().getString(2131363223)))
                  {
                    localObject2 = text;
                    localObject2 = ((String)localObject2).substring(((String)localObject2).indexOf(':') - 2, ((String)localObject2).lastIndexOf(':') + 3).split(":");
                    i1 = 0;
                    n = 0;
                    k = 0;
                    if (localObject2.length != 3) {
                      break label601;
                    }
                    i4 = Integer.valueOf(localObject2[0]).intValue();
                    n = Integer.valueOf(localObject2[1]).intValue();
                    k = Integer.valueOf(localObject2[2]).intValue();
                  }
                }
              }
            }
          }
        }
      }
      for (;;)
      {
        int i3;
        if (i4 <= 0)
        {
          i3 = i;
          if (n < 10) {}
        }
        else
        {
          i3 = i + 1;
        }
        i2 = i3;
        i1 = j;
        if (QLog.isColorLevel())
        {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "video msg,hour=" + i4 + ",minute=" + n + ",second=" + k);
          i1 = j;
          i2 = i3;
        }
        i = i2;
        j = m;
        k = i1;
        break;
        label601:
        i4 = i1;
        if (localObject2.length == 2)
        {
          n = Integer.valueOf(localObject2[0]).intValue();
          k = Integer.valueOf(localObject2[1]).intValue();
          i4 = i1;
        }
      }
      label642:
      if (j > 20)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "pttMsgCount>20. shouldShowTips=true , count=" + j);
        }
        return true;
      }
      if (i > 2)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "longVideoMsgCount>2. shouldShowTips=true , count=" + i);
        }
        return true;
      }
      m = j;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "shouldShowTips=false , sendMsgCount=" + k + ", pttMsgCount=" + m + ", longVideoMsgCount=" + i);
    }
    return false;
  }
  
  public int a()
  {
    return 2001;
  }
  
  public MessageRecord a(Object... paramVarArgs)
  {
    paramVarArgs = MessageRecordFactory.a(60531);
    long l = MessageCache.a();
    String str = jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    paramVarArgs.init(str, jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, str, "", l, 60531, jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, l);
    isread = true;
    return paramVarArgs;
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if ((!MsgProxyUtils.c(jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) || (jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 0) || (paramInt != 1001)) {
      return;
    }
    ThreadManager.b().post(this);
  }
  
  public int[] a()
  {
    return null;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, ".....run......");
    }
    if (!jdField_a_of_type_Boolean) {
      jdField_a_of_type_Boolean = true;
    }
    long l1 = System.currentTimeMillis();
    Object localObject = jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "getAIOList cost:" + (l2 - l1) + " ms");
    }
    if (localObject == null) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "aioMsgList == null");
      }
    }
    while ((!c()) || (!jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this, new Object[0]))) {
      return;
    }
    String str = "key_specialcare_gray_tips_" + jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "_" + jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    localObject = jdField_a_of_type_AndroidContentSharedPreferences.edit();
    ((SharedPreferences.Editor)localObject).putString(str, String.valueOf(MessageCache.a() * 1000L));
    str = "key_specialcare_tips_count_" + jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "_" + jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    ((SharedPreferences.Editor)localObject).putInt(str, jdField_a_of_type_AndroidContentSharedPreferences.getInt(str, 0) + 1);
    ((SharedPreferences.Editor)localObject).commit();
    VipUtils.a(jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Vip_SpecialRemind", "0X8005056", "0X8005056", 0, 1, new String[0]);
  }
}
