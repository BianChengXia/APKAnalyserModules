package com.tencent.mobileqq.activity.aio.tips;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import lnd;

public class ReaderTipsBar
  implements TipsBarTask
{
  private static final String b = ReaderTipsBar.class.getSimpleName();
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private Intent jdField_a_of_type_AndroidContentIntent;
  private TipsManager jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected String a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ReaderTipsBar(QQAppInterface paramQQAppInterface, TipsManager paramTipsManager, Context paramContext, Intent paramIntent)
  {
    jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager = paramTipsManager;
    jdField_a_of_type_AndroidContentContext = paramContext;
    jdField_a_of_type_AndroidContentIntent = paramIntent;
  }
  
  public int a()
  {
    return 1;
  }
  
  public View a(Object... paramVarArgs)
  {
    paramVarArgs = LayoutInflater.from(jdField_a_of_type_AndroidContentContext).inflate(2130903087, null);
    paramVarArgs.setOnClickListener(new lnd(this));
    ((TextView)paramVarArgs.findViewById(2131296955)).setText(jdField_a_of_type_JavaLangString);
    return paramVarArgs;
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt != 1000) {}
    String str;
    do
    {
      do
      {
        do
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.d(b, 2, "onAIOEvent() : TYPE_ON_SHOW =====>");
          }
          paramVarArgs = jdField_a_of_type_AndroidContentIntent.getExtras();
          if (paramVarArgs != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d(b, 2, "data == null");
        return;
        str = paramVarArgs.getString("bookname");
        if (!TextUtils.isEmpty(str)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d(b, 2, "onAIOEvent() : bookName is empty");
      return;
      jdField_a_of_type_JavaLangString = String.format("正在阅读《%s》", new Object[] { str });
      jdField_a_of_type_Long = paramVarArgs.getLong("bookid");
      jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this, new Object[0]);
    } while (!QLog.isColorLevel());
    QLog.d(b, 2, "onAIOEvent() : show ReaderTipBar, bookName : " + str);
  }
  
  public int[] a()
  {
    return null;
  }
  
  public int b()
  {
    return 30;
  }
}
