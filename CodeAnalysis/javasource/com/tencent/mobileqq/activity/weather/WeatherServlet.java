package com.tencent.mobileqq.activity.weather;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.jungle.weather.proto.WeatherReportInfo.Area;
import com.tencent.jungle.weather.proto.WeatherReportInfo.GetWeatherByLbsReq;
import com.tencent.jungle.weather.proto.WeatherReportInfo.GetWeatherByLbsRsp;
import com.tencent.jungle.weather.proto.WeatherReportInfo.PbRspMsgHead;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;

public class WeatherServlet
  extends MSFServlet
{
  public static final int a = 6666;
  public static final String a = "string_err_msg";
  public static final int b = 8888;
  public static final String b = "KEY_TEMPER";
  public static final String c = "o_wea_code";
  public static final String d = "area_name";
  public static final String e = "show_flag";
  public static final String f = "uint32_result";
  private static final String g = "latitide";
  private static final String h = "longtitude";
  private static final String i = "req_type";
  private static final String j = "uin";
  private static final String k = "QQWeatherReport.getWeatherByLbs";
  
  public WeatherServlet()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.a(), WeatherServlet.class);
    localNewIntent.putExtra("req_type", 6666);
    localNewIntent.putExtra("uin", Long.parseLong(paramQQAppInterface.a()));
    paramQQAppInterface.startServlet(localNewIntent);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2)
  {
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.a(), WeatherServlet.class);
    localNewIntent.putExtra("req_type", 8888);
    localNewIntent.putExtra("latitide", paramInt1);
    localNewIntent.putExtra("longtitude", paramInt2);
    paramQQAppInterface.startServlet(localNewIntent);
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (!"QQWeatherReport.getWeatherByLbs".equals(paramFromServiceMsg.getServiceCmd())) {
      return;
    }
    boolean bool2 = paramFromServiceMsg.isSuccess();
    int m = paramIntent.getIntExtra("req_type", 0);
    Bundle localBundle = new Bundle();
    localBundle.putAll(paramIntent.getExtras());
    if (QLog.isColorLevel()) {
      QLog.d("weatherManager", 2, "WeatherServlet onReceive isSucess1:" + bool2);
    }
    bool1 = bool2;
    if (bool2) {}
    for (;;)
    {
      try
      {
        localObject = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
        paramFromServiceMsg = new byte[((ByteBuffer)localObject).getInt() - 4];
        ((ByteBuffer)localObject).get(paramFromServiceMsg);
        localObject = new WeatherReportInfo.GetWeatherByLbsRsp();
        ((WeatherReportInfo.GetWeatherByLbsRsp)localObject).mergeFrom(paramFromServiceMsg);
        if (pbRspMsgHead.uint32_result.get() != 0) {
          continue;
        }
        bool1 = true;
        if (QLog.isColorLevel()) {
          QLog.d("weatherManager", 2, "WeatherServlet onReceive isSucess2:" + bool1);
        }
        if (!bool1) {
          continue;
        }
        localBundle.putString("KEY_TEMPER", temper.get());
        localBundle.putString("o_wea_code", o_wea_code.get());
        localBundle.putString("area_name", area.area_name.get());
        localBundle.putInt("show_flag", show_flag.get());
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        Object localObject;
        paramFromServiceMsg.printStackTrace();
        bool1 = false;
        continue;
      }
      notifyObserver(paramIntent, m, bool1, localBundle, WeatherManager.class);
      return;
      bool1 = false;
      continue;
      localBundle.putInt("uint32_result", pbRspMsgHead.uint32_result.get());
      localBundle.putString("string_err_msg", pbRspMsgHead.string_err_msg.get());
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    int m = paramIntent.getIntExtra("req_type", 0);
    Object localObject;
    switch (m)
    {
    default: 
      throw new RuntimeException("Weatherservlet unknow req_type: " + m);
    case 6666: 
      localObject = new WeatherReportInfo.GetWeatherByLbsReq();
      uin.set(paramIntent.getLongExtra("uin", 0L));
    }
    for (paramIntent = ((WeatherReportInfo.GetWeatherByLbsReq)localObject).toByteArray();; paramIntent = ((WeatherReportInfo.GetWeatherByLbsReq)localObject).toByteArray())
    {
      localObject = ByteBuffer.allocate(paramIntent.length + 4);
      ((ByteBuffer)localObject).putInt(paramIntent.length + 4).put(paramIntent);
      paramPacket.setSSOCommand("QQWeatherReport.getWeatherByLbs");
      paramPacket.putSendData(((ByteBuffer)localObject).array());
      return;
      localObject = new WeatherReportInfo.GetWeatherByLbsReq();
      lat.set(paramIntent.getIntExtra("latitide", 0));
      lng.set(paramIntent.getIntExtra("longtitude", 0));
    }
  }
}
