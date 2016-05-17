import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.DiscussChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class kpr
  implements View.OnLongClickListener
{
  public kpr(BaseBubbleBuilder paramBaseBubbleBuilder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onLongClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return false;
    }
    Object localObject = (FragmentActivity)paramView.getContext();
    String str = (String)paramView.getTag(2131296317);
    paramView = (ChatMessage)paramView.getTag();
    if (paramView != null)
    {
      localObject = ((FragmentActivity)localObject).getChatFragment().a();
      if (!(localObject instanceof HotChatPie)) {
        break label164;
      }
      HotChatInfo localHotChatInfo = ((HotChatManager)a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59)).a(a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      if ((localHotChatInfo == null) || (!localHotChatInfo.isOwnerOrAdmin(a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())) || (localHotChatInfo.isOwnerOrAdmin(senderuin))) {
        break label147;
      }
      ((HotChatPie)localObject).a(paramView, str);
    }
    for (;;)
    {
      return true;
      label147:
      ((HotChatPie)localObject).a(senderuin, str, false, 1);
      continue;
      label164:
      if ((localObject instanceof TroopChatPie))
      {
        ((TroopChatPie)localObject).a(senderuin, str, false, 1);
      }
      else if ((localObject instanceof DiscussChatPie))
      {
        ((DiscussChatPie)localObject).a(senderuin, str, false);
        ReportController.b(a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006210", "0X8006210", 0, 0, "", "", "", "");
      }
    }
  }
}
