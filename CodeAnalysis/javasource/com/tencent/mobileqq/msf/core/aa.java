package com.tencent.mobileqq.msf.core;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.b.m;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.qphone.base.a;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class aa
{
  private static final String a = "WeakNetworkStat";
  private static a b = null;
  private static final ConcurrentHashMap c = new ConcurrentHashMap(100);
  private static final ConcurrentLinkedQueue d = new ConcurrentLinkedQueue();
  private static final int e = 100;
  private static final long f = 3600000L;
  private static final int g = 1000;
  private static Handler h = new ab(Looper.getMainLooper());
  
  public aa() {}
  
  public static void a(MsfCore paramMsfCore, ToServiceMsg paramToServiceMsg)
  {
    if ((b == null) || (TextUtils.isEmpty(ba)) || (!ba.equals(paramToServiceMsg.getUin())))
    {
      b = new a();
      ba = paramToServiceMsg.getUin();
      bb = paramToServiceMsg.getRequestSsoSeq();
      bc = SystemClock.elapsedRealtime();
      be = new StringBuilder();
      bi = new StringBuilder();
    }
    if (!h.hasMessages(1000)) {
      h.sendEmptyMessageDelayed(1000, 3600000L);
    }
  }
  
  private static void a(a paramA, boolean paramBoolean, long paramLong)
  {
    if ((paramA != null) && (e.length() > 0)) {
      if (paramLong != -1L) {
        break label132;
      }
    }
    for (d = (SystemClock.elapsedRealtime() - c);; d = (paramLong - c))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("uin", a);
      localHashMap.put("ssoSeq", "" + b);
      localHashMap.put("closeConnReason", e.toString());
      localHashMap.put("infoVersion", "6.2.0");
      MsfService.core.getStatReporter().a("dim.Msf.WEAKNET_INFOLOGIN4", paramBoolean, d, 0L, localHashMap, false, false);
      return;
      label132:
      if (QLog.isColorLevel()) {
        QLog.d("WeakNetworkStat", 2, "report infologin start timestamp:" + c);
      }
    }
  }
  
  private static void a(a paramA, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramA != null) && ((e.length() > 0) || (paramBoolean2)))
    {
      d = (SystemClock.elapsedRealtime() - c);
      HashMap localHashMap = new HashMap();
      localHashMap.put("uin", a);
      localHashMap.put("ssoSeq", "" + b);
      localHashMap.put("closeConnReason", e.toString());
      localHashMap.put("msgSeq", "" + f);
      localHashMap.put("fromUin", g);
      localHashMap.put("toUin", h);
      localHashMap.put("sendFailReason", i.toString());
      localHashMap.put("quickSend", "" + paramBoolean2);
      localHashMap.put("quickSuccTime", "" + j);
      MsfService.core.getStatReporter().a("dim.Msf.WEAKNET_SENDCHATMSG4", paramBoolean1, d, 0L, localHashMap, false, false);
    }
  }
  
  public static void a(a paramA)
  {
    Iterator localIterator;
    if (b != null)
    {
      if (be.length() < 100) {
        be.append(paramA.ordinal()).append(",");
      }
    }
    else
    {
      if ((c == null) || (c.size() <= 0)) {
        break label162;
      }
      localIterator = c.entrySet().iterator();
    }
    a localA;
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label162;
      }
      localA = (a)((Map.Entry)localIterator.next()).getValue();
      if (e.length() < 100)
      {
        e.append(paramA.ordinal()).append(",");
        continue;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("WeakNetworkStat", 2, "onCloseConn, fail to append closeConnQueue by max size limit.");
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("WeakNetworkStat", 2, "onCloseConn, fail to append closeConnQueue by max size limit.");
      }
    }
    label162:
    if ((d != null) && (d.size() > 0))
    {
      long l = SystemClock.elapsedRealtime();
      localIterator = d.iterator();
      while (localIterator.hasNext())
      {
        localA = (a)localIterator.next();
        if ((l - j <= 10000L) && (paramA == a.A)) {
          e.append(paramA.ordinal()).append(",");
        }
      }
    }
  }
  
  public static void a(FromServiceMsg paramFromServiceMsg)
  {
    if ((b != null) && (!TextUtils.isEmpty(ba)) && (ba.equals(paramFromServiceMsg.getUin())) && (bc > 0L))
    {
      a(b, true, -1L);
      b = null;
    }
  }
  
  public static void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, boolean paramBoolean)
  {
    if (paramToServiceMsg != null) {}
    for (;;)
    {
      boolean bool;
      int i;
      long l;
      String str;
      try
      {
        if ((!TextUtils.isEmpty(paramFromServiceMsg.getUin())) && (!"0".equals(paramFromServiceMsg.getUin())))
        {
          bool = "MessageSvc.PbSendMsg".equals(paramFromServiceMsg.getServiceCmd());
          if (bool) {}
        }
        else
        {
          return;
        }
        if (!paramToServiceMsg.getAttributes().containsKey("msgtype")) {
          break label472;
        }
        i = ((Integer)paramToServiceMsg.getAttributes().get("msgtype")).intValue();
        if (!paramToServiceMsg.getAttributes().containsKey("resend_by_user")) {
          break label466;
        }
        bool = ((Boolean)paramToServiceMsg.getAttributes().get("resend_by_user")).booleanValue();
        if (paramToServiceMsg.getAttributes().containsKey("retryIndex")) {
          ((Integer)paramToServiceMsg.getAttributes().get("retryIndex")).intValue();
        }
        if (!paramToServiceMsg.getAttributes().containsKey("msgSeq")) {
          break label458;
        }
        l = ((Long)paramToServiceMsg.getAttributes().get("msgSeq")).longValue();
        if (!paramToServiceMsg.getAttributes().containsKey("fromUin")) {
          break label452;
        }
        str = (String)paramToServiceMsg.getAttributes().get("fromUin");
        if (!paramToServiceMsg.getAttributes().containsKey("uin")) {
          break label447;
        }
        paramToServiceMsg = (String)paramToServiceMsg.getAttributes().get("uin");
        if ((i != 64536) || (bool) || (TextUtils.isEmpty(str)) || (TextUtils.isEmpty(paramToServiceMsg)) || (!c.containsKey(str + paramToServiceMsg + l))) {
          continue;
        }
        if (!paramFromServiceMsg.isSuccess()) {
          break label370;
        }
        paramToServiceMsg = (a)c.remove(str + paramToServiceMsg + l);
        if ((!paramBoolean) || (e.length() > 0))
        {
          a(paramToServiceMsg, true, paramBoolean);
          continue;
        }
        j = SystemClock.elapsedRealtime();
      }
      finally {}
      d.offer(paramToServiceMsg);
      continue;
      label370:
      paramToServiceMsg = (a)c.get(str + paramToServiceMsg + l);
      if ((paramToServiceMsg != null) && (paramToServiceMsg.i != null) && (paramToServiceMsg.i.length() < 100))
      {
        paramToServiceMsg.i.append(paramFromServiceMsg.getBusinessFailCode()).append(",");
        continue;
        label447:
        paramToServiceMsg = null;
        continue;
        label452:
        str = null;
        continue;
        label458:
        l = -1L;
        continue;
        label466:
        bool = false;
        continue;
        label472:
        i = -1;
      }
    }
  }
  
  public static void a(String paramString, long paramLong)
  {
    if ((b != null) && (!TextUtils.isEmpty(ba)) && (ba.equals(paramString)) && (bc > 0L))
    {
      QLog.d("WeakNetworkStat", 1, "start to report info login uin:" + paramString + ", timeEnd:" + paramLong);
      a(b, true, paramLong);
      b = null;
    }
  }
  
  public static void b(MsfCore paramMsfCore, ToServiceMsg paramToServiceMsg)
  {
    int j = -1;
    if ((TextUtils.isEmpty(paramToServiceMsg.getUin())) || ("0".equals(paramToServiceMsg.getUin())) || (c.containsKey(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()))) || (!"MessageSvc.PbSendMsg".equals(paramToServiceMsg.getServiceCmd()))) {
      return;
    }
    boolean bool = false;
    long l = -1L;
    if (paramToServiceMsg.getAttributes().containsKey("msgtype")) {}
    for (int i = ((Integer)paramToServiceMsg.getAttributes().get("msgtype")).intValue();; i = -1)
    {
      if (paramToServiceMsg.getAttributes().containsKey("resend_by_user")) {
        bool = ((Boolean)paramToServiceMsg.getAttributes().get("resend_by_user")).booleanValue();
      }
      if (paramToServiceMsg.getAttributes().containsKey("retryIndex")) {
        j = ((Integer)paramToServiceMsg.getAttributes().get("retryIndex")).intValue();
      }
      if (paramToServiceMsg.getAttributes().containsKey("msgSeq")) {
        l = ((Long)paramToServiceMsg.getAttributes().get("msgSeq")).longValue();
      }
      if (paramToServiceMsg.getAttributes().containsKey("fromUin")) {}
      for (paramMsfCore = (String)paramToServiceMsg.getAttributes().get("fromUin");; paramMsfCore = null)
      {
        if (paramToServiceMsg.getAttributes().containsKey("uin")) {}
        for (String str = (String)paramToServiceMsg.getAttributes().get("uin"); (i == 64536) && (!bool) && (j <= 0) && (!TextUtils.isEmpty(paramMsfCore)) && (!TextUtils.isEmpty(str)); str = null)
        {
          a localA = new a();
          a = paramToServiceMsg.getUin();
          b = paramToServiceMsg.getRequestSsoSeq();
          c = SystemClock.elapsedRealtime();
          e = new StringBuilder();
          f = l;
          g = paramMsfCore;
          h = str;
          i = new StringBuilder();
          c.put(paramMsfCore + str + l, localA);
          return;
        }
        break;
      }
    }
  }
  
  private static void c()
  {
    if ((b != null) && (SystemClock.elapsedRealtime() - bc >= 3600000L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("WeakNetworkStat", 2, "clean, clean infoLoginItem by interval check.");
      }
      a(b, false, -1L);
      b = null;
    }
    Iterator localIterator;
    Object localObject;
    if ((c != null) && (c.size() > 0))
    {
      localIterator = c.entrySet().iterator();
      while (localIterator.hasNext())
      {
        localObject = (Map.Entry)localIterator.next();
        a localA = (a)((Map.Entry)localObject).getValue();
        if (SystemClock.elapsedRealtime() - c >= 3600000L)
        {
          if (QLog.isColorLevel()) {
            QLog.d("WeakNetworkStat", 2, "clean, clean SendMsgItem by interval check.");
          }
          a(localA, false, false);
          c.remove(((Map.Entry)localObject).getKey());
        }
      }
    }
    if ((d != null) && (d.size() > 0))
    {
      long l = SystemClock.elapsedRealtime();
      localIterator = d.iterator();
      while (localIterator.hasNext())
      {
        localObject = (a)localIterator.next();
        if (l - c >= 3600000L)
        {
          if (QLog.isColorLevel()) {
            QLog.d("WeakNetworkStat", 2, "clean, clean QuickSendedMsg by interval check.");
          }
          a((a)localObject, true, true);
          d.remove(localObject);
        }
      }
    }
  }
  
  public static class a
  {
    public String a;
    public int b;
    public long c;
    public long d;
    public StringBuilder e;
    public long f;
    public String g;
    public String h;
    public StringBuilder i;
    public long j;
    
    public a() {}
  }
}
