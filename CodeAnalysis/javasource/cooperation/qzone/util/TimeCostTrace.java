package cooperation.qzone.util;

import android.os.Debug;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class TimeCostTrace
{
  public static final String a = "qzone_launch";
  public static HashMap a;
  public static final String b = "qzone_refresh";
  public static final String c = "qzone_refresh_more";
  public static final String d = "100";
  public static final String e = "101";
  public int a;
  public long a;
  private Map a;
  public boolean a;
  private String f;
  
  private TimeCostTrace(String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_Long = 0L;
    jdField_a_of_type_JavaUtilMap = Collections.synchronizedMap(new LinkedHashMap(16, 0.75F, true));
    jdField_a_of_type_Int = 0;
    f = paramString;
  }
  
  public static TimeCostTrace a(String paramString)
  {
    if (jdField_a_of_type_JavaUtilHashMap == null) {
      jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    TimeCostTrace localTimeCostTrace2 = (TimeCostTrace)jdField_a_of_type_JavaUtilHashMap.get(paramString);
    TimeCostTrace localTimeCostTrace1 = localTimeCostTrace2;
    if (localTimeCostTrace2 == null)
    {
      localTimeCostTrace1 = new TimeCostTrace(paramString);
      jdField_a_of_type_JavaUtilHashMap.put(paramString, localTimeCostTrace1);
    }
    return localTimeCostTrace1;
  }
  
  private static long b()
  {
    return System.currentTimeMillis();
  }
  
  public static void c(String paramString)
  {
    if (jdField_a_of_type_JavaUtilHashMap == null) {}
    TimeCostTrace localTimeCostTrace;
    do
    {
      return;
      localTimeCostTrace = (TimeCostTrace)jdField_a_of_type_JavaUtilHashMap.get(paramString);
    } while (localTimeCostTrace == null);
    localTimeCostTrace.b();
    jdField_a_of_type_JavaUtilHashMap.remove(paramString);
  }
  
  public long a()
  {
    long l1;
    if ((jdField_a_of_type_JavaUtilMap == null) || (jdField_a_of_type_Long <= 0L) || (jdField_a_of_type_Int < 0)) {
      l1 = -1L;
    }
    long l2;
    do
    {
      return l1;
      l2 = b() - jdField_a_of_type_Long;
      l1 = l2;
    } while (!QLog.isColorLevel());
    QLog.d(f, 2, "getTimeCost:" + l2);
    return l2;
  }
  
  public String a()
  {
    if ((jdField_a_of_type_JavaUtilMap == null) || (jdField_a_of_type_JavaUtilMap.size() <= 0)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    synchronized (jdField_a_of_type_JavaUtilMap)
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        long[] arrayOfLong = (long[])jdField_a_of_type_JavaUtilMap.get(str);
        if (arrayOfLong != null)
        {
          localStringBuilder.append(str).append(":");
          if (arrayOfLong.length > 0)
          {
            localStringBuilder.append(arrayOfLong[0] - jdField_a_of_type_Long);
            localStringBuilder.append(",");
          }
          if (arrayOfLong.length > 1) {
            localStringBuilder.append(arrayOfLong[1] - jdField_a_of_type_Long);
          }
          localStringBuilder.append(";");
        }
      }
    }
    ??? = localObject2.substring(0, localObject2.length() - 1);
    QLog.i(f, 1, "dump step cost detail:" + (String)???);
    return ???;
  }
  
  public Map a()
  {
    return jdField_a_of_type_JavaUtilMap;
  }
  
  public void a()
  {
    a(b(), 0, false);
  }
  
  public void a(long paramLong, int paramInt, boolean paramBoolean)
  {
    jdField_a_of_type_Long = paramLong;
    jdField_a_of_type_Int = paramInt;
    jdField_a_of_type_Boolean = paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.d(f, 2, "TimeCostTrace--markFirst");
    }
  }
  
  public void a(String paramString)
  {
    a(paramString, -1L);
  }
  
  public void a(String paramString, long paramLong)
  {
    if (jdField_a_of_type_Int < 0) {}
    do
    {
      do
      {
        return;
      } while (TextUtils.isEmpty(paramString));
      long l = paramLong;
      if (paramLong <= 0L) {
        l = b();
      }
      long[] arrayOfLong2 = (long[])jdField_a_of_type_JavaUtilMap.get(paramString);
      long[] arrayOfLong1 = arrayOfLong2;
      if (arrayOfLong2 == null)
      {
        arrayOfLong1 = new long[5];
        jdField_a_of_type_JavaUtilMap.put(paramString, arrayOfLong1);
      }
      arrayOfLong1[0] = l;
      arrayOfLong1[2] = Thread.currentThread().getId();
      arrayOfLong1[3] = Debug.threadCpuTimeNanos();
    } while (!QLog.isColorLevel());
    QLog.d(f, 2, paramString + " start");
  }
  
  public void b()
  {
    if (jdField_a_of_type_JavaUtilMap != null)
    {
      jdField_a_of_type_JavaUtilMap.clear();
      jdField_a_of_type_Long = 0L;
      jdField_a_of_type_Int = 0;
      jdField_a_of_type_Boolean = false;
    }
  }
  
  public void b(String paramString)
  {
    if (jdField_a_of_type_Int < 0) {}
    long l2;
    long l3;
    long l1;
    do
    {
      do
      {
        return;
      } while (TextUtils.isEmpty(paramString));
      l2 = b();
      long[] arrayOfLong2 = (long[])jdField_a_of_type_JavaUtilMap.get(paramString);
      long[] arrayOfLong1 = arrayOfLong2;
      if (arrayOfLong2 == null)
      {
        arrayOfLong1 = new long[5];
        jdField_a_of_type_JavaUtilMap.put(paramString, arrayOfLong1);
      }
      arrayOfLong1[1] = l2;
      arrayOfLong1[4] = Debug.threadCpuTimeNanos();
      l3 = Thread.currentThread().getId();
      l1 = -1L;
      if (l3 == arrayOfLong1[2]) {
        l1 = arrayOfLong1[4] - arrayOfLong1[3];
      }
      l3 = arrayOfLong1[0];
    } while ((!QLog.isColorLevel()) || (l3 <= 0L));
    QLog.d(f, 2, paramString + " stop, cpuTime(ns):" + l1 + " ,cost:" + (l2 - l3));
  }
}
