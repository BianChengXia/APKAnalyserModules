import android.os.Process;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.CoreService;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.app.MemoryManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class mtc
  extends myg
{
  public mtc()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a()
  {
    super.a();
    if (b == GuardManager.s * 50 - 1)
    {
      l = MemoryManager.a(Process.myPid());
      localHashMap = new HashMap();
      localHashMap.put("qqUsedMemory", String.valueOf(l / 1024L));
      a.a("GM_reborn", localHashMap);
      if (QLog.isColorLevel()) {
        QLog.d("GuardManager", 2, "suicide to free memory! suicide_factor=" + GuardManager.s);
      }
    }
    while (((b != GuardManager.s * 50) && (b != GuardManager.s * 50 + 1)) || (a.d != null))
    {
      long l;
      HashMap localHashMap;
      return;
    }
    System.exit(-1);
  }
  
  protected void a(String paramString)
  {
    a.a(3, paramString);
  }
  
  protected void b()
  {
    a.a(4, "fake_p_msg");
  }
  
  protected void b(String paramString)
  {
    super.b(paramString);
    a.b(false);
    if (!"trick_p_msg".equals(paramString)) {
      a.a(false, new String[] { paramString });
    }
    long l = MemoryManager.a(Process.myPid());
    if (mye.a().a(l) != 2) {
      a.f();
    }
    BaseApplicationImpl.a.a().onGuardEvent(2, aa, 0L);
    CoreService.b();
  }
}
