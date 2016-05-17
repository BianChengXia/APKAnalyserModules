import android.os.Bundle;
import android.os.Message;
import com.tencent.mobileqq.activity.messagesearch.BaseMessageResultAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatHistorySearchData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.HistoryChatMsgSearchKeyUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import java.util.ArrayList;

public class lvr
  implements Runnable
{
  public lvr(BaseMessageResultAdapter paramBaseMessageResultAdapter, String paramString, int paramInt, long paramLong)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i(BaseMessageResultAdapter.b(), 2, "loadMessageResult, run(), keyword = " + jdField_a_of_type_JavaLangString + ", loadType = " + jdField_a_of_type_Int);
    }
    ??? = null;
    if (jdField_a_of_type_Int == 1)
    {
      ??? = jdField_a_of_type_ComTencentMobileqqActivityMessagesearchBaseMessageResultAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(jdField_a_of_type_ComTencentMobileqqActivityMessagesearchBaseMessageResultAdapter.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, jdField_a_of_type_JavaLangString);
      HistoryChatMsgSearchKeyUtil.a(jdField_a_of_type_ComTencentMobileqqActivityMessagesearchBaseMessageResultAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      Object localObject2 = new ArrayList();
      Object localObject4 = jdField_a_of_type_ComTencentMobileqqActivityMessagesearchBaseMessageResultAdapter.a((ChatHistorySearchData)???, (ArrayList)localObject2);
      if (QLog.isColorLevel()) {
        QLog.i(BaseMessageResultAdapter.b(), 2, "loadMessageResult, get: messageItems[] = " + localObject2);
      }
      synchronized (jdField_a_of_type_ComTencentMobileqqActivityMessagesearchBaseMessageResultAdapter.jdField_a_of_type_JavaLangObject)
      {
        if (jdField_a_of_type_ComTencentMobileqqActivityMessagesearchBaseMessageResultAdapter.jdField_a_of_type_JavaLangString.equals(jdField_a_of_type_JavaLangString))
        {
          if (jdField_a_of_type_Int != 1) {
            break label269;
          }
          jdField_a_of_type_ComTencentMobileqqActivityMessagesearchBaseMessageResultAdapter.jdField_a_of_type_ComTencentMobileqqDataChatHistorySearchData = ((ChatHistorySearchData)localObject4);
          localObject2 = jdField_a_of_type_ComTencentMobileqqActivityMessagesearchBaseMessageResultAdapter.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.obtainMessage(2, localObject2);
          arg1 = 1;
          localObject4 = new Bundle();
          ((Bundle)localObject4).putLong("searchSequence", jdField_a_of_type_Long);
          ((Bundle)localObject4).putString("searchKeyword", jdField_a_of_type_JavaLangString);
          ((Message)localObject2).setData((Bundle)localObject4);
          ((Message)localObject2).sendToTarget();
        }
        label269:
        while (jdField_a_of_type_Int != 2)
        {
          return;
          if (jdField_a_of_type_Int != 2) {
            break;
          }
          ??? = jdField_a_of_type_ComTencentMobileqqActivityMessagesearchBaseMessageResultAdapter.jdField_a_of_type_ComTencentMobileqqDataChatHistorySearchData;
          break;
        }
        jdField_a_of_type_ComTencentMobileqqActivityMessagesearchBaseMessageResultAdapter.jdField_a_of_type_ComTencentMobileqqDataChatHistorySearchData = ((ChatHistorySearchData)localObject4);
        localObject2 = jdField_a_of_type_ComTencentMobileqqActivityMessagesearchBaseMessageResultAdapter.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.obtainMessage(2, localObject2);
        arg1 = 2;
        localObject4 = new Bundle();
        ((Bundle)localObject4).putLong("searchSequence", jdField_a_of_type_Long);
        ((Bundle)localObject4).putString("searchKeyword", jdField_a_of_type_JavaLangString);
        ((Message)localObject2).setData((Bundle)localObject4);
        ((Message)localObject2).sendToTarget();
      }
    }
  }
}
