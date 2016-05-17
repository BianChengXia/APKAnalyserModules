package com.tencent.mobileqq.activity.aio.tips;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.operation.QQOperateManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.servlet.ReduFriendServlet;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.HashMap;
import lmw;
import mqq.app.NewIntent;

public class FriendHotTipsBar
  implements TipsBarTask
{
  public static final int a = 1;
  private static final String jdField_a_of_type_JavaLangString = FriendHotTipsBar.class.getSimpleName();
  private static HashMap jdField_a_of_type_JavaUtilHashMap;
  public static final int b = 2;
  private static HashMap b;
  public static final int c = 3;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private TipsManager jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    b = new HashMap();
  }
  
  public FriendHotTipsBar(QQAppInterface paramQQAppInterface, TipsManager paramTipsManager, Activity paramActivity, SessionInfo paramSessionInfo)
  {
    jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager = paramTipsManager;
    jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public static String a(String paramString)
  {
    return "voice_shown_hot_friend_tip_bar_" + paramString;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    String str1 = paramQQAppInterface.a();
    String str2 = str1 + "_" + paramString;
    if (QLog.isColorLevel()) {
      QLog.d(ReduFriendServlet.b, 2, "afterShowHotFriendTip() is called,mapKey is:" + str2);
    }
    Object localObject = BaseApplication.getContext().getSharedPreferences("free_call", 0);
    String str3 = a(str1);
    boolean bool = ((SharedPreferences)localObject).getBoolean(str3, false);
    if (bool) {
      if (QLog.isColorLevel()) {
        QLog.d(ReduFriendServlet.b, 2, "shownHotFriendTip is:" + bool + ",not need to save value");
      }
    }
    do
    {
      return;
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putBoolean(str3, true);
      long l = MessageCache.a();
      ((SharedPreferences.Editor)localObject).putString("voice_hot_friend_tip_show_time" + str1, String.valueOf(l * 1000L));
      ((SharedPreferences.Editor)localObject).commit();
      jdField_a_of_type_JavaUtilHashMap.put(str2, Boolean.TRUE);
      b(paramQQAppInterface, paramString);
    } while (!QLog.isColorLevel());
    QLog.d(ReduFriendServlet.b, 2, "shownHotFriendTip is:" + bool + ",need to save value");
  }
  
  public static String[] a(QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    paramQQAppInterface = BaseApplication.getContext().getSharedPreferences("free_call", 0);
    long l = Long.parseLong(paramQQAppInterface.getString(b(paramString), "-1"));
    if (Math.abs(paramLong - l) >= 86400000L)
    {
      if (QLog.isColorLevel()) {
        QLog.d(ReduFriendServlet.b, 2, "currTime is:" + paramLong + ",pullHotFriendTimeLong is:" + l + ",need to pull hot friend");
      }
      return null;
    }
    return paramQQAppInterface.getString(c(paramString), "").split("\\|");
  }
  
  public static String b(String paramString)
  {
    return "free_call_pull_hot_friend_time_" + paramString;
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = paramQQAppInterface.a();
    paramQQAppInterface = paramQQAppInterface + "_" + paramString;
    if (QLog.isColorLevel()) {
      QLog.d(ReduFriendServlet.b, 2, "incrementHotFriendEnterAIOTimes() is called,mapKey is:" + paramQQAppInterface);
    }
    if (jdField_a_of_type_JavaUtilHashMap.get(paramQQAppInterface) != null)
    {
      paramString = (Integer)b.get(paramQQAppInterface);
      if (paramString == null)
      {
        b.put(paramQQAppInterface, Integer.valueOf(1));
        if (QLog.isColorLevel()) {
          QLog.d(ReduFriendServlet.b, 2, "shownHotFriendTip flag exist,beforeTimes is:" + paramString);
        }
      }
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        return;
        b.put(paramQQAppInterface, Integer.valueOf(paramString.intValue() + 1));
      }
    }
    QLog.d(ReduFriendServlet.b, 2, "shownHotFriendTip flag does not exist,not increment time");
  }
  
  public static String c(String paramString)
  {
    return "free_call_hot_friend_" + paramString;
  }
  
  public static void c(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(ReduFriendServlet.b, 2, "removeShownHotFriendTipFlag() is called");
    }
    paramQQAppInterface = paramQQAppInterface.a();
    paramQQAppInterface = paramQQAppInterface + "_" + paramString;
    jdField_a_of_type_JavaUtilHashMap.remove(paramQQAppInterface);
  }
  
  public int a()
  {
    return 5;
  }
  
  public int a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    Object localObject3 = paramQQAppInterface.a();
    Object localObject4 = (String)localObject3 + "_" + paramString;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "shouldShowHotFriendVoiceCallBar() ==> ,mapKey is:" + (String)localObject4);
    }
    Object localObject2 = "";
    localObject1 = localObject2;
    label224:
    label313:
    label396:
    label989:
    label1223:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            try
                            {
                              if (jdField_a_of_type_JavaUtilHashMap.get(localObject4) == null) {
                                break label396;
                              }
                              localObject1 = localObject2;
                              localObject3 = (Integer)b.get(localObject4);
                              if (localObject3 != null)
                              {
                                localObject1 = localObject2;
                                if (((Integer)localObject3).intValue() > 3) {
                                  break label313;
                                }
                              }
                              localObject1 = localObject2;
                              localObject3 = ((FriendsManager)paramQQAppInterface.getManager(50)).c(paramString);
                              if (localObject3 == null) {
                                break;
                              }
                              localObject1 = localObject2;
                              if ((abilityBits & 1L) == 0L) {
                                break;
                              }
                              localObject1 = localObject2;
                              i = ((Friends)localObject3).getNetWorkType();
                              if (i != 2) {
                                break label224;
                              }
                              j = 2;
                              i = j;
                              if (QLog.isColorLevel())
                              {
                                QLog.d(jdField_a_of_type_JavaLangString, 2, "shouldShowVoiceHotFriendTipBar() ==> step is:" + "");
                                i = j;
                              }
                            }
                            finally
                            {
                              try
                              {
                                do
                                {
                                  int j;
                                  Object localObject5;
                                  long l;
                                  int k;
                                  int m;
                                  int n;
                                  int i1;
                                  ReportController.b(paramQQAppInterface, "CliOper", "", "", "Free_call", "Free_call_tips", 0, 0, "", "", "", "");
                                  int i = 1;
                                } while (!QLog.isColorLevel());
                                QLog.d(jdField_a_of_type_JavaLangString, 2, "shouldShowVoiceHotFriendTipBar() ==> step is:" + "can show hot friend voice call bar");
                                return 1;
                              }
                              finally
                              {
                                localObject1 = "can show hot friend voice call bar";
                              }
                              paramQQAppInterface = finally;
                            }
                            return i;
                            i = 1;
                          } while (!QLog.isColorLevel());
                          QLog.d(jdField_a_of_type_JavaLangString, 2, "shouldShowVoiceHotFriendTipBar() ==> step is:" + "find true flag from memory");
                          return 1;
                          localObject1 = localObject2;
                          c(paramQQAppInterface, paramString);
                          i = 2;
                        } while (!QLog.isColorLevel());
                        QLog.d(jdField_a_of_type_JavaLangString, 2, "shouldShowVoiceHotFriendTipBar() ==> step is:" + "find true flag from memory but friend abilityBits does not contain support voice flag");
                        return 2;
                        localObject1 = localObject2;
                        c(paramQQAppInterface, paramString);
                        localObject1 = localObject2;
                        paramQQAppInterface = "find true flag from memory but enterAIOTimes is too large,enterAIOTimes is:" + localObject3 + ",MAX_ENTER_TIMES is:" + 3;
                        i = 2;
                      } while (!QLog.isColorLevel());
                      QLog.d(jdField_a_of_type_JavaLangString, 2, "shouldShowVoiceHotFriendTipBar() ==> step is:" + paramQQAppInterface);
                      return 2;
                      localObject1 = localObject2;
                      localObject4 = BaseApplication.getContext().getSharedPreferences("free_call", 0);
                      localObject1 = localObject2;
                      if (!((SharedPreferences)localObject4).getBoolean(a((String)localObject3), false)) {
                        break;
                      }
                      i = 2;
                    } while (!QLog.isColorLevel());
                    QLog.d(jdField_a_of_type_JavaLangString, 2, "shouldShowVoiceHotFriendTipBar() ==> step is:" + "has shown hot friend tip");
                    return 2;
                    localObject1 = localObject2;
                    localObject5 = ((SharedPreferences)localObject4).getString("voice_remark_tip_show_time" + (String)localObject3, "");
                    localObject1 = localObject2;
                    l = MessageCache.a() * 1000L;
                    localObject1 = localObject2;
                    localObject4 = new Time();
                    localObject1 = localObject2;
                    if (QLog.isColorLevel())
                    {
                      localObject1 = localObject2;
                      QLog.d(jdField_a_of_type_JavaLangString, 2, "multiRemarkTipShowTime is:" + (String)localObject5 + ",currTimeMillis is:" + l);
                    }
                    if (localObject5 == null) {
                      break;
                    }
                    localObject1 = localObject2;
                    if (((String)localObject5).length() <= 0) {
                      break;
                    }
                    localObject1 = localObject2;
                    localObject5 = ((String)localObject5).split("\\|");
                    localObject1 = localObject2;
                    ((Time)localObject4).set(l);
                    localObject1 = localObject2;
                    i = year;
                    localObject1 = localObject2;
                    j = month;
                    localObject1 = localObject2;
                    k = monthDay;
                    localObject1 = localObject2;
                    ((Time)localObject4).set(Long.parseLong(localObject5[(localObject5.length - 1)]));
                    localObject1 = localObject2;
                    m = year;
                    localObject1 = localObject2;
                    n = month;
                    localObject1 = localObject2;
                    i1 = monthDay;
                    if ((i != m) || (j != n) || (k != i1)) {
                      break;
                    }
                    i = 2;
                  } while (!QLog.isColorLevel());
                  QLog.d(jdField_a_of_type_JavaLangString, 2, "shouldShowVoiceHotFriendTipBar() ==> step is:" + "has shown remark tip this day");
                  return 2;
                  localObject1 = localObject2;
                  if (NetworkUtil.h(BaseApplication.getContext())) {
                    break;
                  }
                  localObject1 = localObject2;
                  if (NetworkUtil.d(BaseApplication.getContext())) {
                    break;
                  }
                  i = 2;
                } while (!QLog.isColorLevel());
                QLog.d(jdField_a_of_type_JavaLangString, 2, "shouldShowVoiceHotFriendTipBar() ==> step is:" + "my network is not wifi or 3g or 4g");
                return 2;
                localObject1 = localObject2;
                localObject4 = a(paramQQAppInterface, (String)localObject3, MessageCache.a());
                if (localObject4 != null) {
                  break label989;
                }
                paramString = "there is no hot friend,need to pull";
                if (!paramBoolean) {
                  break;
                }
                localObject1 = paramString;
                localObject2 = new NewIntent(paramQQAppInterface.a(), ReduFriendServlet.class);
                localObject1 = paramString;
                ((NewIntent)localObject2).putExtra("k_uin", (String)localObject3);
                localObject1 = paramString;
                paramQQAppInterface.startServlet((NewIntent)localObject2);
                i = 3;
              } while (!QLog.isColorLevel());
              QLog.d(jdField_a_of_type_JavaLangString, 2, "shouldShowVoiceHotFriendTipBar() ==> step is:" + "there is no hot friend,need to pull");
              return 3;
              i = 2;
            } while (!QLog.isColorLevel());
            QLog.d(jdField_a_of_type_JavaLangString, 2, "shouldShowVoiceHotFriendTipBar() ==> step is:" + "there is no hot friend,need to pull");
            return 2;
            localObject1 = localObject2;
            localObject3 = new HashMap();
            i = 0;
            for (;;)
            {
              localObject1 = localObject2;
              if (i >= localObject4.length) {
                break;
              }
              localObject1 = localObject2;
              ((HashMap)localObject3).put(localObject4[i], localObject4[i]);
              i += 1;
            }
            localObject1 = localObject2;
            if (((HashMap)localObject3).get(paramString) == null) {
              break;
            }
            localObject1 = localObject2;
            localObject3 = ((FriendsManager)paramQQAppInterface.getManager(50)).c(paramString);
            if (localObject3 != null) {
              break label1223;
            }
            localObject1 = localObject2;
            paramQQAppInterface = "can not find friend,friendUin is:" + paramString;
            i = 2;
          } while (!QLog.isColorLevel());
          QLog.d(jdField_a_of_type_JavaLangString, 2, "shouldShowVoiceHotFriendTipBar() ==> step is:" + paramQQAppInterface);
          return 2;
          localObject1 = localObject2;
          paramQQAppInterface = "friend does not exist in hot friend,friendUin is:" + paramString + ",hotFriend is:" + Arrays.toString((Object[])localObject4);
          i = 2;
        } while (!QLog.isColorLevel());
        QLog.d(jdField_a_of_type_JavaLangString, 2, "shouldShowVoiceHotFriendTipBar() ==> step is:" + paramQQAppInterface);
        return 2;
        localObject1 = localObject2;
        if ((abilityBits & 1L) != 0L) {
          break;
        }
        localObject1 = localObject2;
        paramQQAppInterface = "friend abilityBits does not contain support voice flag,f.abilityBits is:" + abilityBits;
        i = 2;
      } while (!QLog.isColorLevel());
      QLog.d(jdField_a_of_type_JavaLangString, 2, "shouldShowVoiceHotFriendTipBar() ==> step is:" + paramQQAppInterface);
      return 2;
      localObject1 = localObject2;
      i = ((Friends)localObject3).getNetWorkType();
      if (i != 2) {
        break;
      }
      i = 2;
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "shouldShowVoiceHotFriendTipBar() ==> step is:" + "");
    return 2;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "shouldShowVoiceHotFriendTipBar() ==> step is:" + (String)localObject1);
    }
    throw paramQQAppInterface;
  }
  
  public View a(Object... paramVarArgs)
  {
    paramVarArgs = LayoutInflater.from(jdField_a_of_type_AndroidAppActivity).inflate(2130904003, null);
    paramVarArgs.findViewById(2131300892).setOnClickListener(new lmw(this));
    return paramVarArgs;
  }
  
  public void a()
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 0) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "curType != Friend");
      }
    }
    QQOperateManager localQQOperateManager;
    do
    {
      do
      {
        return;
        localQQOperateManager = QQOperateManager.a(jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (!localQQOperateManager.b(jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 1)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d(jdField_a_of_type_JavaLangString, 2, "hasNetTipShow today");
      return;
    } while ((a(jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true) != 1) || (!jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this, new Object[0])));
    a(jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    localQQOperateManager.a(jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 1);
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt != 1000) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onAIOEvent() : TYPE_ON_SHOW =====>");
    }
    a();
  }
  
  public int[] a()
  {
    return new int[] { 2000 };
  }
  
  public int b()
  {
    return 40;
  }
}
