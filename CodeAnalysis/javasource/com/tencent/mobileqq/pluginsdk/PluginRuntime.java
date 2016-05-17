package com.tencent.mobileqq.pluginsdk;

import android.content.Context;
import android.os.Bundle;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.WtloginManagerImpl;
import mqq.manager.Manager;

public class PluginRuntime
  extends AppRuntime
{
  private static final String b = "pluginsdk_carsh_throwable";
  private static final String c = "pluginsdk_carsh_pluginID";
  private static final String d = "com.tencent.mobileqq.ACTION_PLUGIN_CRASH";
  private static final boolean e = false;
  private IClickEventReportor a;
  
  public PluginRuntime() {}
  
  public static PluginRuntime getRuntime()
  {
    AppRuntime localAppRuntime = MobileQQ.getMobileQQ().waitAppRuntime(null);
    if ((localAppRuntime != null) && ((localAppRuntime instanceof PluginRuntime))) {
      return (PluginRuntime)localAppRuntime;
    }
    return null;
  }
  
  public static PluginRuntime getRuntime(String paramString)
  {
    return getRuntime();
  }
  
  public static void handleCrash(Throwable paramThrowable, String paramString, Context paramContext) {}
  
  public Manager getManager(int paramInt)
  {
    Object localObject1 = super.getManager(paramInt);
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      return localObject2;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        break;
      }
      addManager(paramInt, (Manager)localObject1);
      return localObject1;
      localObject1 = new WtloginManagerImpl(this);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    PluginRecoverReceiver.register(getApplication(), new PluginRecoverReceiver());
  }
  
  public void reportClickEvent(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    if (a != null) {
      a.reportClickEvent(paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9);
    }
  }
  
  public void reportClickEventRuntime(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    if (a != null) {
      a.reportClickEventRuntime(paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9);
    }
  }
  
  public void sendAppDataIncerment(String paramString, String[] paramArrayOfString, long paramLong)
  {
    if (DebugHelper.sDebug) {
      DebugHelper.log("PluginRuntime.sendAppDataIncerment:" + paramArrayOfString);
    }
    super.sendAppDataIncermentMsg(paramString, paramArrayOfString, paramLong);
  }
  
  public void setClickEventReportor(IClickEventReportor paramIClickEventReportor)
  {
    a = paramIClickEventReportor;
  }
  
  public static abstract interface IClickEventReportor
  {
    public abstract void reportClickEvent(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9);
    
    public abstract void reportClickEventRuntime(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9);
  }
}
