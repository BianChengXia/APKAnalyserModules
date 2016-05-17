package com.tencent.common.config.provider;

import android.text.TextUtils;
import com.qq.jce.wup.UniAttribute;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.WiFiDash;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ExtraConfig
{
  public static final int a = 0;
  public static String a;
  private static Map a;
  public static final int b = 3;
  public static final String b = "ExtraConfig";
  public static final int c = 4;
  public static final String c = "WifiCarrierType";
  public static final int d = 5;
  public static final String d = "0";
  public static final int e = 8;
  public static final String e = "1";
  public static final String f = "2";
  public static final String g = "3";
  static String h = "wns_share_data";
  private static String i;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    i = ExtraConfig.class.getName();
    jdField_a_of_type_JavaLangString = "EXTRA_DATAV1";
    jdField_a_of_type_JavaUtilMap = null;
  }
  
  public ExtraConfig() {}
  
  public static int a()
  {
    try
    {
      Map localMap = QZConfigProviderUtil.a();
      if (localMap == null) {
        return 0;
      }
      Object localObject;
      if (NetworkState.c()) {
        localObject = WiFiDash.a();
      }
      while (localObject != null)
      {
        localObject = (String)localMap.get(localObject);
        if (localObject == null)
        {
          return 0;
          localObject = NetworkState.b();
        }
        else
        {
          localObject = ((String)localObject).split(":");
          if ((localObject != null) && (localObject.length > 0))
          {
            int j = Integer.valueOf(localObject[0]).intValue();
            return j;
          }
          return 0;
        }
      }
      return 0;
    }
    catch (Exception localException)
    {
      QLog.e(i, 2, "read wifi operator by bssid fail", localException);
    }
    return 0;
  }
  
  public static void a(int paramInt)
  {
    if (paramInt <= 0) {
      return;
    }
    String str2 = "";
    String str1 = str2;
    switch (paramInt)
    {
    default: 
      str1 = str2;
    }
    while (!TextUtils.isEmpty(str1))
    {
      a(str1);
      return;
      str1 = "3";
      continue;
      str1 = "0";
      continue;
      str1 = "2";
      continue;
      str1 = "1";
    }
  }
  
  public static void a(String paramString)
  {
    String str;
    if (NetworkState.c())
    {
      str = WiFiDash.a();
      if (str != null)
      {
        a(str, paramString + ":" + System.currentTimeMillis());
        QLog.d("QzoneIPStracyConfig", 2, "save bssid=" + str + "" + ",value=" + paramString + ":" + System.currentTimeMillis());
      }
    }
    do
    {
      return;
      str = NetworkState.b();
    } while (str == null);
    a(str.toLowerCase(), paramString + ":" + System.currentTimeMillis());
    QLog.d("QzoneIPStracyConfig", 2, "save apn=" + str.toLowerCase() + "" + ",value=" + paramString + ":" + System.currentTimeMillis());
  }
  
  public static void a(String paramString1, String paramString2)
  {
    jdField_a_of_type_JavaUtilMap = QZConfigProviderUtil.a();
    if (jdField_a_of_type_JavaUtilMap != null) {
      jdField_a_of_type_JavaUtilMap.put(paramString1, paramString2);
    }
    for (;;)
    {
      a(jdField_a_of_type_JavaUtilMap);
      QZConfigProviderUtil.a(jdField_a_of_type_JavaUtilMap);
      return;
      jdField_a_of_type_JavaUtilMap = new HashMap();
      jdField_a_of_type_JavaUtilMap.put(paramString1, paramString2);
    }
  }
  
  private static void a(Map paramMap)
  {
    if ((paramMap == null) || (true == paramMap.isEmpty())) {}
    long l;
    do
    {
      do
      {
        return;
      } while (BaseApplication.getContext() == null);
      l = QZConfigProviderUtil.a();
      QLog.d("ConfigProvider", 2, "last_check_time:" + l);
    } while (System.currentTimeMillis() - l <= 86400000L);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      String[] arrayOfString = ((String)paramMap.get(str)).split(":");
      if ((arrayOfString != null) && (arrayOfString.length >= 2) && (System.currentTimeMillis() - Long.parseLong(arrayOfString[1]) > 2592000000L)) {
        localArrayList.add(str);
      }
    }
    localIterator = localArrayList.iterator();
    while (localIterator.hasNext()) {
      paramMap.remove((String)localIterator.next());
    }
    localArrayList.clear();
    QLog.e("ConfigProvider", 2, " last_check_time:" + System.currentTimeMillis());
    QZConfigProviderUtil.a(System.currentTimeMillis());
  }
  
  public static boolean a(Map paramMap, boolean paramBoolean)
  {
    if (paramMap == null) {
      return false;
    }
    Set localSet = paramMap.keySet();
    Iterator localIterator = localSet.iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      Object localObject1 = (String)localIterator.next();
      if ((localObject1 == null) || (!((String)localObject1).equals("ExtraConfig"))) {
        break label506;
      }
      Object localObject2 = (byte[])paramMap.get(localObject1);
      localObject1 = new UniAttribute();
      ((UniAttribute)localObject1).decode((byte[])localObject2);
      localObject2 = ((UniAttribute)localObject1).getKeySet();
      if (localSet == null) {
        break label506;
      }
      localObject2 = ((Set)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str2 = (String)((Iterator)localObject2).next();
        String str1 = (String)((UniAttribute)localObject1).get(str2);
        if ((str2 == null) || (!str2.equals("WifiCarrierType")) || (str1 == null)) {
          break label503;
        }
        QLog.d("QzoneIPStracyConfig", 2, str2 + "=" + str1);
        try
        {
          if (Integer.valueOf(str1).intValue() >= 0) {
            break label274;
          }
          QLog.i("ConfigProvider", 2, "receive WiFiOperator error,value=" + str1);
          bool = true;
        }
        catch (Exception localException)
        {
          QLog.i("ConfigProvider", 2, "receive WiFiOperator error,value=" + str1, localException);
          bool = true;
        }
        continue;
        label274:
        String str3;
        if (NetworkState.c())
        {
          if (!paramBoolean) {
            WiFiDash.b();
          }
          str3 = WiFiDash.a();
          if (str3 != null)
          {
            a(str3, str1 + ":" + System.currentTimeMillis());
            QLog.d("QzoneIPStracyConfig", 2, "save bssid=" + str3 + "" + ",value=" + str1 + ":" + System.currentTimeMillis());
          }
        }
        for (bool = false;; bool = false)
        {
          label383:
          break;
          if (!paramBoolean) {
            NetworkState.d();
          }
          str3 = NetworkState.b();
          if (str3 != null)
          {
            a(str3.toLowerCase(), str1 + ":" + System.currentTimeMillis());
            QLog.d("QzoneIPStracyConfig", 2, "save apn=" + str3.toLowerCase() + "" + ",value=" + str1 + ":" + System.currentTimeMillis());
          }
        }
      }
    }
    label503:
    label506:
    for (;;)
    {
      break;
      return bool;
      break label383;
    }
  }
}
