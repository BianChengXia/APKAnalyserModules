import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public final class mho
  implements Runnable
{
  public mho(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    QQMessageFacade.Message localMessage = jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(jdField_a_of_type_JavaLangString, 1008);
    String str1 = "0";
    if (localMessage != null)
    {
      localObject = localMessage.getExtInfoFromExtStr("gdt_msgClick");
      if (TextUtils.isEmpty((CharSequence)localObject)) {}
    }
    try
    {
      localObject = new JSONObject((String)localObject);
      if (((JSONObject)localObject).has("ad_id")) {
        str1 = ((JSONObject)localObject).getString("ad_id");
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str3;
        if (QLog.isColorLevel()) {
          QLog.i("Q.recent", 2, "from_enterchat");
        }
        String str2 = "0";
        continue;
        localObject = "0X8005C39";
      }
    }
    str3 = localMessage.getExtInfoFromExtStr("pa_msgId");
    if (jdField_a_of_type_Int == 1)
    {
      localObject = "0X8005C36";
      ReportController.b(jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "" + frienduin, (String)localObject, (String)localObject, 0, 1, 0, str3, String.valueOf(NetConnInfoCenter.getServerTime() * 1000L), "", str1);
      return;
    }
  }
}
