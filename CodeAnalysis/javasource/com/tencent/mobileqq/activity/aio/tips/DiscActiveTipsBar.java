package com.tencent.mobileqq.activity.aio.tips;

import android.app.Activity;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.config.operation.QQOperateManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.List;
import lms;

public class DiscActiveTipsBar
  implements TipsBarTask
{
  private static final String jdField_a_of_type_JavaLangString = DiscActiveTipsBar.class.getSimpleName();
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Time jdField_a_of_type_AndroidTextFormatTime;
  private ChatAdapter1 jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private TipsManager jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public DiscActiveTipsBar(QQAppInterface paramQQAppInterface, TipsManager paramTipsManager, Activity paramActivity, SessionInfo paramSessionInfo, ChatAdapter1 paramChatAdapter1)
  {
    jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager = paramTipsManager;
    jdField_a_of_type_AndroidAppActivity = paramActivity;
    jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 = paramChatAdapter1;
  }
  
  public int a()
  {
    return 4;
  }
  
  public View a(Object... paramVarArgs)
  {
    paramVarArgs = LayoutInflater.from(jdField_a_of_type_AndroidAppActivity).inflate(2130904003, null);
    ((TextView)paramVarArgs.findViewById(2131300893)).setText(2131367017);
    ((ImageView)paramVarArgs.findViewById(2131300891)).setImageResource(2130842489);
    paramVarArgs.findViewById(2131300892).setOnClickListener(new lms(this));
    return paramVarArgs;
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt != 1001) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onAIOEvent() : TYPE_ON_MSG_SENT_RECV =====>");
    }
    for (;;)
    {
      int i;
      int j;
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000) {
          return;
        }
        if (QQOperateManager.a(jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 1)) {
          return;
        }
        paramVarArgs = jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a();
        if (paramVarArgs == null) {
          return;
        }
        if (paramVarArgs.size() < 10)
        {
          paramVarArgs = "msgList size < 10, size = " + paramVarArgs.size();
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d(jdField_a_of_type_JavaLangString, 2, "onAIOEvent() : TYPE_ON_MSG_SENT_RECV <=====, step is:" + paramVarArgs);
          return;
        }
        long l1 = Long.valueOf(jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue();
        paramInt = UITools.a(jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        if (jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramInt, l1)) {
          return;
        }
        Object localObject2 = "voice_disc_chat_freq_bar_show_count" + jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        Object localObject1 = BaseApplication.getContext().getSharedPreferences("free_call", 0);
        paramInt = ((SharedPreferences)localObject1).getInt((String)localObject2, 0);
        if (paramInt >= 3) {
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "discChatFreqBarShowCount : " + paramInt);
        }
        l1 = MessageCache.a() * 1000L;
        if (jdField_a_of_type_AndroidTextFormatTime == null) {
          jdField_a_of_type_AndroidTextFormatTime = new Time();
        }
        jdField_a_of_type_AndroidTextFormatTime.set(l1);
        paramInt = jdField_a_of_type_AndroidTextFormatTime.year;
        i = jdField_a_of_type_AndroidTextFormatTime.month;
        j = jdField_a_of_type_AndroidTextFormatTime.monthDay;
        jdField_a_of_type_AndroidTextFormatTime.set(0, 0, 20, j, i, paramInt);
        long l2 = jdField_a_of_type_AndroidTextFormatTime.toMillis(false);
        jdField_a_of_type_AndroidTextFormatTime.set(0, 0, 23, j, i, paramInt);
        long l3 = jdField_a_of_type_AndroidTextFormatTime.toMillis(false);
        if ((l1 < l2) || (l1 > l3))
        {
          paramVarArgs = "current time not in " + 20 + "-" + 23;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d(jdField_a_of_type_JavaLangString, 2, "onAIOEvent() : TYPE_ON_MSG_SENT_RECV <=====, step is:" + paramVarArgs);
          return;
        }
        localObject2 = ((SharedPreferences)localObject1).getString("voice_disc_chat_freq_bar_show_time" + jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), null);
        if (QLog.isColorLevel())
        {
          String str = paramInt + "-" + i + "-" + j;
          QLog.d(jdField_a_of_type_JavaLangString, 2, "currDate is:" + str + ",curr hour is:" + jdField_a_of_type_AndroidTextFormatTime.hour + ",discPttFreqTipMsgInsertTime is:" + (String)localObject2);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          jdField_a_of_type_AndroidTextFormatTime.set(Long.parseLong((String)localObject2));
          int k = jdField_a_of_type_AndroidTextFormatTime.year;
          int m = jdField_a_of_type_AndroidTextFormatTime.month;
          int n = jdField_a_of_type_AndroidTextFormatTime.monthDay;
          if ((paramInt == k) && (i == m) && (j == n)) {
            return;
          }
        }
        localObject1 = ((SharedPreferences)localObject1).getString("start_group_audio_time" + jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), null);
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (l1 - Long.parseLong((String)localObject1) <= 600000L)) {
          return;
        }
        l1 = (l1 - 600000L) / 1000L;
        i = paramVarArgs.size();
        paramInt = 0;
        localObject1 = new HashSet();
        j = i - 1;
        if (j >= 0)
        {
          localObject2 = (ChatMessage)paramVarArgs.get(j);
          i = paramInt;
          if (time >= l1)
          {
            i = paramInt;
            if (MsgProxyUtils.l(msgtype))
            {
              i = paramInt;
              if (extraflag == 0)
              {
                i = paramInt + 1;
                ((HashSet)localObject1).add(senderuin);
              }
            }
          }
        }
        else
        {
          i = ((HashSet)localObject1).size();
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "basicMsgNum : " + paramInt + ", msgUinNum : " + i);
          }
          return;
        }
      }
      finally
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "onAIOEvent() : TYPE_ON_MSG_SENT_RECV <=====, step is:" + "");
        }
      }
      j -= 1;
      paramInt = i;
    }
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
