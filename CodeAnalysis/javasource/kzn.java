import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.QQWalletMsgItemBuilder;
import com.tencent.mobileqq.app.IndividualRedPacketManager;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import org.json.JSONObject;

public class kzn
  implements View.OnClickListener
{
  public kzn(QQWalletMsgItemBuilder paramQQWalletMsgItemBuilder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    Object localObject2 = (MessageForQQWalletMsg)paramView.getTag();
    if ((messageType == 2001) && (!((MessageForQQWalletMsg)localObject2).isSend()))
    {
      QQWalletMsgItemBuilder.a(a, a.jdField_a_of_type_AndroidContentContext, IndividualRedPacketManager.a(1, a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      return;
    }
    Object localObject1 = mQQWalletRedPacketMsg.redPacketId;
    localObject2 = mQQWalletRedPacketMsg.authkey;
    Object localObject3 = QQWalletMsgItemBuilder.a(a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    int i = ((Bundle)localObject3).getInt("groupType");
    localObject3 = ((Bundle)localObject3).getString("name");
    localObject2 = QQWalletMsgItemBuilder.a(a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, i, (String)localObject3, (String)localObject1, (String)localObject2, a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "appid#1344242394|bargainor_id#1000030201|channel#detailtips", "redgiftDetail", null);
    localObject1 = new Bundle();
    ((Bundle)localObject1).putString("json", ((JSONObject)localObject2).toString());
    ((Bundle)localObject1).putString("callbackSn", "0");
    localObject2 = new Intent(paramView.getContext(), PayBridgeActivity.class);
    ((Intent)localObject2).putExtras((Bundle)localObject1);
    ((Intent)localObject2).putExtra("pay_requestcode", 5);
    paramView.getContext().startActivity((Intent)localObject2);
  }
}
