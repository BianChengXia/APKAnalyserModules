import android.content.Context;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;
import com.tencent.mobileqq.activity.aio.audiopanel.ListenPanel;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ktg
  extends AccessibilityDelegateCompat
{
  public ktg(ListenPanel paramListenPanel)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
    if (ListenPanel.a(a) < 1000.0D) {}
    for (int i = 0;; i = (int)(ListenPanel.a(a) / 1000.0D + 0.5D))
    {
      paramAccessibilityNodeInfoCompat.setContentDescription(i + a.getContext().getString(2131362086));
      return;
    }
  }
}
