import com.tencent.biz.helper.TroopCardAppInfoHelper.IGetAppInfoCB;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.data.TroopAppInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class llm
  implements TroopCardAppInfoHelper.IGetAppInfoCB
{
  public llm(TroopChatPie paramTroopChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a() {}
  
  public void a(ArrayList paramArrayList)
  {
    if (ChatActivityUtils.a(a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()) != null) {}
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = new ArrayList();
      localArrayList.add(Long.valueOf(1L));
      localArrayList.add(Long.valueOf(2L));
      localArrayList.add(Long.valueOf(1101236949L));
      localArrayList.add(Long.valueOf(1101484419L));
      localArrayList.add(Long.valueOf(1102858908L));
      if ((paramArrayList != null) && (paramArrayList.size() > 0))
      {
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext()) {
          localArrayList.add(Long.valueOf(nextappId));
        }
      }
      paramArrayList = (TroopHandler)a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
    } while (paramArrayList == null);
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.TroopChatPie", 2, "send_oidb_0x8c9_2, appIds : " + localArrayList);
    }
    paramArrayList.a(a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, localArrayList);
  }
}
