package oicq.wlogin_sdk.tools;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;

public class b
  implements Handler.Callback
{
  private static b a = null;
  private static final Object c = new Object();
  private static String d = "";
  private static String e = "";
  private volatile boolean b = false;
  private Context f;
  private HandlerThread g;
  private Handler h;
  
  private b(Context paramContext)
  {
    f = paramContext;
    g = new HandlerThread("FileTracer");
    g.start();
    if (g.isAlive()) {
      h = new Handler(g.getLooper(), this);
    }
    h.sendEmptyMessage(1024);
  }
  
  private void a()
  {
    try
    {
      h.sendEmptyMessageDelayed(1024, 2000L);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public static void a(Context arg0, String paramString1, String paramString2)
  {
    if ((??? == null) || (paramString2 == null)) {
      return;
    }
    if (a == null) {
      a = new b(???);
    }
    synchronized (c)
    {
      if (e.length() > 4096) {
        e = "";
      }
    }
    try
    {
      e = e + util.getDate() + util.getThreadId() + util.getLineInfo(3) + util.getSdkVersion() + util.getUser(paramString1) + paramString2 + "\n";
      return;
      paramString1 = finally;
      throw paramString1;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        e = "";
        util.printException(paramString1, "");
      }
    }
  }
  
  private void b()
  {
    if (Thread.currentThread() != g) {}
    while (b) {
      return;
    }
    b = true;
    c();
    b = false;
  }
  
  private void c()
  {
    byte[] arrayOfByte1;
    if ((e != null) && (e.length() > 0))
    {
      d = e;
      e = "";
      arrayOfByte1 = util.compress(d.getBytes());
      if ((arrayOfByte1 != null) && (arrayOfByte1.length != 0)) {}
    }
    else
    {
      return;
    }
    byte[] arrayOfByte2 = new byte[arrayOfByte1.length + 4];
    util.int32_to_buf(arrayOfByte2, 0, arrayOfByte1.length);
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 4, arrayOfByte1.length);
    util.writeFile(util.getLogFileName(f, util.getCurrentDay()), arrayOfByte2);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (what)
    {
    }
    for (;;)
    {
      return true;
      b();
      a();
    }
  }
}
