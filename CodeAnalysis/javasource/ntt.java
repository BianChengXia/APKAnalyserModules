import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.AboutConfig;
import com.tencent.mobileqq.config.ConfigManager;
import com.tencent.mobileqq.config.ResourcePluginListener;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.observer.ServerConfigObserver;
import protocol.KQQConfig.GetResourceRespInfoV2;
import protocol.KQQConfig.GetResourceRespV2;

public class ntt
  extends ServerConfigObserver
{
  public ntt(AboutConfig paramAboutConfig)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onGetPluginConfig(boolean paramBoolean, int paramInt, GetResourceRespV2 paramGetResourceRespV2)
  {
    int i = 0;
    int m = 0;
    if ((paramInt & 0x20) == 0) {
      return;
    }
    paramInt = i;
    Object localObject1;
    Object localObject2;
    int j;
    label60:
    GetResourceRespInfoV2 localGetResourceRespInfoV2;
    if (paramBoolean)
    {
      paramInt = i;
      if (paramGetResourceRespV2 != null)
      {
        localObject1 = AboutConfig.a(a).a().createEntityManager();
        localObject2 = vecAddedResInfo.iterator();
        paramInt = 0;
        j = 0;
        i = 0;
        while (((Iterator)localObject2).hasNext())
        {
          localGetResourceRespInfoV2 = (GetResourceRespInfoV2)((Iterator)localObject2).next();
          if (iPluginType == 32)
          {
            if ((sResSubType != 0) && (sResSubType != 2)) {
              break label523;
            }
            if (aaa), localGetResourceRespInfoV2).cDefaultState != 0) {
              break label514;
            }
            paramInt = 1;
            i = 1;
            j = 1;
          }
        }
      }
    }
    for (;;)
    {
      int k = j;
      j = i;
      i = k;
      break label60;
      localObject2 = vecDeletedResInfo.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localGetResourceRespInfoV2 = (GetResourceRespInfoV2)((Iterator)localObject2).next();
        if ((iPluginType == 32) && ((sResSubType == 0) || (sResSubType == 2)))
        {
          ResourcePluginInfo.remove((EntityManager)localObject1, strPkgName);
          i = 1;
        }
      }
      paramGetResourceRespV2 = vecUpdatedResInfo.iterator();
      while (paramGetResourceRespV2.hasNext())
      {
        localObject2 = (GetResourceRespInfoV2)paramGetResourceRespV2.next();
        if ((iPluginType == 32) && ((sResSubType == 0) || (sResSubType == 2)))
        {
          ConfigManager.a((EntityManager)localObject1, AboutConfig.a(a), (GetResourceRespInfoV2)localObject2);
          i = 1;
        }
      }
      ((EntityManager)localObject1).a();
      a.a(true);
      k = m;
      if (i != 0)
      {
        paramGetResourceRespV2 = new ArrayList(AboutConfig.a(a)).iterator();
        while (paramGetResourceRespV2.hasNext())
        {
          localObject1 = (ResourcePluginListener)paramGetResourceRespV2.next();
          if (j != 0)
          {
            ResourcePluginListener.a((ResourcePluginListener)localObject1, (byte)3, 2);
            if (paramInt != 0)
            {
              if (QLog.isColorLevel()) {
                QLog.d("AboutConfig", 2, "inform STATE_NEW_OPEN_PLUGIN");
              }
              ResourcePluginListener.a((ResourcePluginListener)localObject1, (byte)4, 2);
            }
          }
          else
          {
            ResourcePluginListener.a((ResourcePluginListener)localObject1, (byte)2, 2);
          }
        }
        break;
      }
      label414:
      if (k >= AboutConfig.a(a).size()) {
        break;
      }
      try
      {
        ResourcePluginListener.a((ResourcePluginListener)AboutConfig.a(a).get(k), (byte)1, 2);
        k += 1;
        break label414;
        while (paramInt < AboutConfig.a(a).size()) {
          try
          {
            ResourcePluginListener.a((ResourcePluginListener)AboutConfig.a(a).get(paramInt), (byte)-1, 2);
            paramInt += 1;
          }
          catch (Exception paramGetResourceRespV2)
          {
            for (;;) {}
          }
        }
      }
      catch (Exception paramGetResourceRespV2)
      {
        for (;;) {}
      }
      label514:
      j = 1;
      i = 1;
      continue;
      label523:
      k = i;
      i = j;
      j = k;
    }
  }
}
