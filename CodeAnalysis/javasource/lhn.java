import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class lhn
  implements DialogInterface.OnClickListener
{
  public lhn(HotChatPie paramHotChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = "http://ti.qq.com/meilizhigl/index.html?_wv=1027&isguest=[isguest]&uin=[uin]".replace("[isguest]", "0").replace("[uin]", a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    Intent localIntent = new Intent(a.a(), QQBrowserActivity.class);
    localIntent.putExtra("url", paramDialogInterface);
    a.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
  }
}
