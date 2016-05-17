package com.tencent.mobileqq.pluginsdk;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import com.tencent.commonsdk.soload.SoLoadCore;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import mqq.app.MobileQQ;

class c
  extends ContextThemeWrapper
{
  private static final String a = c.class.getSimpleName();
  private static final HashMap e = new HashMap();
  private static final boolean f = false;
  private a b;
  private ClassLoader c;
  private Context d;
  
  public c(Context paramContext, int paramInt1, String paramString, ClassLoader paramClassLoader, Resources paramResources, int paramInt2)
  {
    super(paramContext, paramInt1);
    c = paramClassLoader;
    if (paramInt2 == 2) {
      paramString = a(paramContext, new String[] { SoLoadCore.getApkPath(MobileQQ.getContext()), paramString });
    }
    for (;;)
    {
      b = paramString;
      d = paramContext;
      return;
      if (paramInt2 == 1)
      {
        paramString = new a(null, paramResources);
        a(paramString);
      }
      else
      {
        paramString = a(paramContext, new String[] { paramString });
      }
    }
  }
  
  private static int a(String paramString)
  {
    try
    {
      String str2 = paramString.substring(0, paramString.indexOf(".R.") + 2);
      i = paramString.lastIndexOf(".");
      String str1 = paramString.substring(i + 1, paramString.length());
      paramString = paramString.substring(0, i);
      String str3 = paramString.substring(paramString.lastIndexOf(".") + 1, paramString.length());
      str2 = str2 + "$" + str3;
      i = Class.forName(str2).getDeclaredField(str1).getInt(null);
      paramString.printStackTrace();
    }
    catch (Throwable paramString)
    {
      try
      {
        if (DebugHelper.sDebug)
        {
          DebugHelper.log("plugin_tag", "getInnderR rStrnig:" + paramString);
          DebugHelper.log("plugin_tag", "getInnderR className:" + str2);
          DebugHelper.log("plugin_tag", "getInnderR fieldName:" + str1);
        }
        return i;
      }
      catch (Throwable paramString)
      {
        int i;
        for (;;) {}
      }
      paramString = paramString;
      i = -1;
    }
    return i;
  }
  
  private static Resources a(Context paramContext, AssetManager paramAssetManager)
  {
    return new Resources(paramAssetManager, paramContext.getResources().getDisplayMetrics(), paramContext.getResources().getConfiguration());
  }
  
  private static a a(Context paramContext, String... paramVarArgs)
  {
    ArrayList localArrayList = new ArrayList();
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(paramVarArgs[i]);
      i += 1;
    }
    Collections.sort(localArrayList);
    paramContext = new a(null, b(paramContext, paramVarArgs));
    a(paramContext);
    return paramContext;
  }
  
  private static void a(a paramA)
  {
    Resources.Theme localTheme = b.newTheme();
    localTheme.applyStyle(a("com.android.internal.R.style.Theme"), true);
    a = localTheme;
  }
  
  private static Resources b(Context paramContext, String[] paramArrayOfString)
  {
    AssetManager localAssetManager = new AssetManager();
    localAssetManager.addAssetPaths(paramArrayOfString);
    paramArrayOfString = a(paramContext, localAssetManager);
    paramArrayOfString.getDisplayMetrics().setTo(paramContext.getResources().getDisplayMetrics());
    return paramArrayOfString;
  }
  
  public Context a()
  {
    return d;
  }
  
  public void a(ClassLoader paramClassLoader)
  {
    c = paramClassLoader;
  }
  
  public AssetManager getAssets()
  {
    return b.b.getAssets();
  }
  
  public ClassLoader getClassLoader()
  {
    if (c != null) {
      return c;
    }
    return super.getClassLoader();
  }
  
  public Resources getResources()
  {
    return b.b;
  }
  
  public Resources.Theme getTheme()
  {
    return b.a;
  }
  
  private static class a
  {
    public Resources.Theme a;
    public Resources b;
    
    public a(Resources.Theme paramTheme, Resources paramResources)
    {
      a = paramTheme;
      b = paramResources;
    }
  }
}
