import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.mobileqq.activity.aio.rebuild.BusinessCmrTmpChatPie;
import com.tencent.mobileqq.data.EqqDetail;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mp.mobileqq_mp.GetEqqAccountDetailInfoResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public class lfm
  implements BusinessObserver
{
  public lfm(BusinessCmrTmpChatPie paramBusinessCmrTmpChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BusinessChatPie", 2, "success:" + String.valueOf(paramBoolean));
    }
    if (paramBoolean)
    {
      paramBundle = paramBundle.getByteArray("data");
      if (paramBundle != null) {
        localGetEqqAccountDetailInfoResponse = new mobileqq_mp.GetEqqAccountDetailInfoResponse();
      }
    }
    while (!QLog.isColorLevel())
    {
      do
      {
        try
        {
          mobileqq_mp.GetEqqAccountDetailInfoResponse localGetEqqAccountDetailInfoResponse;
          localGetEqqAccountDetailInfoResponse.mergeFrom(paramBundle);
          paramInt = ret_info.get()).ret_code.get();
          if (paramInt == 0)
          {
            paramBundle = new EqqDetail(localGetEqqAccountDetailInfoResponse);
            CrmUtils.a(a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBundle);
            BusinessCmrTmpChatPie.a(a, PublicAccountInfo.createPublicAccount(paramBundle, 0L));
            BusinessCmrTmpChatPie.a(a, BusinessCmrTmpChatPie.a(a));
            BusinessCmrTmpChatPie.a(a, a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent());
          }
          while (!QLog.isColorLevel()) {
            return;
          }
          QLog.d("BusinessChatPie", 2, "showEqqLbsEnableDialog() get eqq detail ret code error: " + paramInt);
          return;
        }
        catch (InvalidProtocolBufferMicroException paramBundle) {}
      } while (!QLog.isColorLevel());
      QLog.d("BusinessChatPie", 2, "showEqqLbsEnableDialog() get eqq detail data is null");
      return;
    }
    QLog.d("BusinessChatPie", 2, "showEqqLbsEnableDialog() get eqq detail isSuccess is null");
    return;
  }
}
