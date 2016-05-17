package com.tencent.mobileqq.msf.sdk;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.msf.sdk.handler.IErrorHandler;
import com.tencent.mobileqq.msf.sdk.utils.a;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.HashMap;

public class MsfServiceSdk
  extends j
{
  private static MsfServiceSdk sdk = new MsfServiceSdk();
  private static final String tag = "MsfServiceSdk";
  private volatile boolean initFinished = false;
  g proxy;
  
  private MsfServiceSdk() {}
  
  private void beforeSend(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg == null) {
      return;
    }
    paramToServiceMsg.setAppId(appid);
    paramToServiceMsg.setTimeout(30000L);
    MsfSdkUtils.addToMsgProcessName(processName, paramToServiceMsg);
  }
  
  public static MsfServiceSdk get()
  {
    return sdk;
  }
  
  public void bindBaseService()
  {
    proxy.b();
  }
  
  public ToServiceMsg getA1WithA1(String paramString)
  {
    paramString = new ToServiceMsg(getMsfServiceName(), paramString, "login.auth");
    paramString.setMsfCommand(MsfCommand.wt_GetA1WithA1);
    paramString.getAttributes().put("dwSrcAppid", Long.valueOf(16L));
    paramString.getAttributes().put("dwSubSrcAppid", Long.valueOf(16L));
    beforeSend(paramString);
    return paramString;
  }
  
  public ToServiceMsg getChangeTokenAfterLoginMsg(String paramString, int paramInt, HashMap paramHashMap)
  {
    paramString = new ToServiceMsg(getMsfServiceName(), paramString, "login.chgTok");
    paramString.setMsfCommand(MsfCommand.changeToken);
    paramString.getAttributes().put("to_login_token_cmdhead", Integer.valueOf(paramInt));
    paramString.getAttributes().put("to_login_token_map", paramHashMap);
    beforeSend(paramString);
    return paramString;
  }
  
  public ToServiceMsg getChangeUinAndLoginMsg(String paramString, byte[] paramArrayOfByte)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg(getMsfServiceName(), paramString, "login.auth");
    localToServiceMsg.setMsfCommand(MsfCommand.changeUinLogin);
    localToServiceMsg.getAttributes().put("to_login_pwd", paramArrayOfByte);
    localToServiceMsg.getAttributes().put("to_login_changeuin", paramString);
    beforeSend(localToServiceMsg);
    return localToServiceMsg;
  }
  
  public ToServiceMsg getCheckMsfConErroMsg()
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg(getMsfServiceName(), "0", "Check_msf_conErro");
    localToServiceMsg.setMsfCommand(MsfCommand.check_msf_conErro);
    return localToServiceMsg;
  }
  
  public ToServiceMsg getCheckSMSAndGetStMsg(String paramString, byte[] paramArrayOfByte)
  {
    paramString = new ToServiceMsg(msfServiceName, paramString, "cmd_appUseWtLogin");
    paramString.setMsfCommand(MsfCommand.wt_CheckSMSAndGetSt);
    paramString.getAttributes().put("userInput", paramArrayOfByte);
    paramString.setTimeout(30000L);
    return paramString;
  }
  
  public ToServiceMsg getDataFlowMsg(String paramString, a paramA)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg(getMsfServiceName(), "0", "socketnetflow");
    localToServiceMsg.setMsfCommand(MsfCommand.reportSocket);
    extraData.putString("processName", paramString);
    extraData.putString("ip", b);
    extraData.putString("refer", c);
    extraData.putInt("port", d);
    extraData.putInt("flag", e);
    extraData.putLong("buffersize", f);
    extraData.putInt("networktype", g);
    extraData.putString("mType", h);
    extraData.putByte("status", i);
    localToServiceMsg.setNeedCallback(false);
    beforeSend(localToServiceMsg);
    return localToServiceMsg;
  }
  
  public ToServiceMsg getDelLoginedAccount(String paramString1, String paramString2)
  {
    paramString1 = new ToServiceMsg(getMsfServiceName(), paramString1, "cmd_DelLoginedAccount");
    paramString1.setMsfCommand(MsfCommand.delLoginedAccount);
    paramString1.getAttributes().put(paramString1.getServiceCmd(), paramString2);
    beforeSend(paramString1);
    return paramString1;
  }
  
  public ToServiceMsg getKeyMsg(String paramString)
  {
    paramString = new ToServiceMsg(getMsfServiceName(), paramString, "MSF.getKey");
    paramString.setMsfCommand(MsfCommand.getKey);
    beforeSend(paramString);
    return paramString;
  }
  
  public ToServiceMsg getLoginMsg(String paramString, byte[] paramArrayOfByte)
  {
    paramString = new ToServiceMsg(getMsfServiceName(), paramString, "login.auth");
    paramString.setMsfCommand(MsfCommand.loginAuth);
    paramString.getAttributes().put("to_login_pwd", paramArrayOfByte);
    beforeSend(paramString);
    return paramString;
  }
  
  public ToServiceMsg getLoginWithoutPasswdMsg(String paramString)
  {
    paramString = new ToServiceMsg(getMsfServiceName(), paramString, "login.auth");
    paramString.setMsfCommand(MsfCommand.wt_GetStWithoutPasswd);
    paramString.getAttributes().put("dwSrcAppid", Long.valueOf(16L));
    paramString.getAttributes().put("dwDstAppid", Long.valueOf(16L));
    beforeSend(paramString);
    return paramString;
  }
  
  public String getMsfServiceName()
  {
    if (initFinished == true) {
      return proxy.a.msfServiceName;
    }
    proxy = new g("com.tencent.mobileqq.msf.service.MsfService");
    proxy.a(this);
    initFinished = true;
    appid = 88886666;
    return proxy.a.msfServiceName;
  }
  
  public ToServiceMsg getPluginConfigMsg(String paramString)
  {
    paramString = new ToServiceMsg(getMsfServiceName(), paramString, "ConfigService.ClientReq");
    paramString.setMsfCommand(MsfCommand.getPluginConfig);
    beforeSend(paramString);
    return paramString;
  }
  
  public ToServiceMsg getRefreVerifyCodeMsg(VerifyCodeInfo paramVerifyCodeInfo)
  {
    if (paramVerifyCodeInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("MsfServiceSdk", 2, "getRefreVerifyCodeMsg info null!");
      }
      return null;
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg(getMsfServiceName(), uin, "login.auth");
    localToServiceMsg.setMsfCommand(MsfCommand.refreVerifyCode);
    VerifyCodeInfo.putVerifyCodeInfo(localToServiceMsg, paramVerifyCodeInfo);
    localToServiceMsg.setRequestSsoSeq(ssoSeq);
    beforeSend(localToServiceMsg);
    return localToServiceMsg;
  }
  
  public ToServiceMsg getRefreshDevLockSmsMsg(String paramString)
  {
    paramString = new ToServiceMsg(msfServiceName, paramString, "cmd_appUseWtLogin");
    paramString.setMsfCommand(MsfCommand.wt_RefreshSMSData);
    paramString.getAttributes().put("smsAppid", Long.valueOf(9L));
    paramString.setTimeout(30000L);
    return paramString;
  }
  
  public ToServiceMsg getRefreshTicketsMsg(String paramString)
  {
    paramString = new ToServiceMsg(getMsfServiceName(), paramString, "cmd_refreshTickets");
    paramString.setMsfCommand(MsfCommand.refreshTickets);
    beforeSend(paramString);
    return paramString;
  }
  
  public ToServiceMsg getRegQueryAccountMsg(String paramString)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg(getMsfServiceName(), "0", "wtlogin.trans_emp");
    localToServiceMsg.getAttributes().put("to_register_cr_mobile", paramString);
    localToServiceMsg.setMsfCommand(MsfCommand.regUin_queryMobile);
    beforeSend(localToServiceMsg);
    return localToServiceMsg;
  }
  
  public ToServiceMsg getRegisterCmdCallMsg(CommandCallbackerInfo paramCommandCallbackerInfo)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg(getMsfServiceName(), uin, "push.cmdRegister");
    localToServiceMsg.setMsfCommand(MsfCommand.registerCmdCallback);
    m.a(localToServiceMsg, paramCommandCallbackerInfo);
    beforeSend(localToServiceMsg);
    return localToServiceMsg;
  }
  
  public ToServiceMsg getRegisterCommitMobileMsg(String paramString1, byte paramByte1, byte paramByte2, byte paramByte3, String paramString2, String paramString3, String paramString4, Long paramLong)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg(getMsfServiceName(), "0", "wtlogin.trans_emp");
    localToServiceMsg.setMsfCommand(MsfCommand.regUin_commitMobile);
    localToServiceMsg.getAttributes().put("to_register_cr_country", Byte.valueOf(paramByte1));
    localToServiceMsg.getAttributes().put("to_register_cr_language", Byte.valueOf(paramByte2));
    localToServiceMsg.getAttributes().put("to_register_cr_pigType", Byte.valueOf(paramByte3));
    localToServiceMsg.getAttributes().put("to_register_cr_appName", paramString2);
    localToServiceMsg.getAttributes().put("to_register_cr_appVersion", paramString3);
    localToServiceMsg.getAttributes().put("to_register_cr_mobile", paramString4);
    localToServiceMsg.getAttributes().put("appid", paramLong);
    localToServiceMsg.getAttributes().put("To_register_captcha_sig", paramString1);
    beforeSend(localToServiceMsg);
    return localToServiceMsg;
  }
  
  public ToServiceMsg getRegisterCommitPassMsg(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg(getMsfServiceName(), "0", "wtlogin.trans_emp");
    localToServiceMsg.setMsfCommand(MsfCommand.regUin_commitPass);
    localToServiceMsg.getAttributes().put("To_register_smsCode", paramString1);
    localToServiceMsg.getAttributes().put("To_register_pass", paramString2);
    localToServiceMsg.getAttributes().put("To_register_nick", paramString3);
    localToServiceMsg.getAttributes().put("To_register_type", Boolean.valueOf(paramBoolean));
    beforeSend(localToServiceMsg);
    return localToServiceMsg;
  }
  
  public ToServiceMsg getRegisterCommitSmsCodeMsg(String paramString)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg(getMsfServiceName(), "0", "wtlogin.trans_emp");
    localToServiceMsg.setMsfCommand(MsfCommand.regUin_commitSmsCode);
    localToServiceMsg.getAttributes().put("To_register_smsCode", paramString);
    beforeSend(localToServiceMsg);
    return localToServiceMsg;
  }
  
  public ToServiceMsg getRegisterProxyMsg(int paramInt, String paramString1, String paramString2, String paramString3, NotifyRegisterInfo paramNotifyRegisterInfo, CommandCallbackerInfo paramCommandCallbackerInfo)
  {
    paramString1 = new ToServiceMsg(getMsfServiceName(), paramString1, "push.proxyRegister");
    paramString1.setMsfCommand(MsfCommand.proxyRegisterPush);
    l localL = new l();
    a = paramInt;
    b = paramString2;
    c = paramString3;
    d = paramNotifyRegisterInfo;
    e = paramCommandCallbackerInfo;
    m.a(paramString1, localL);
    beforeSend(paramString1);
    return paramString1;
  }
  
  public ToServiceMsg getRegisterPushMsg(PushRegisterInfo paramPushRegisterInfo)
  {
    if (paramPushRegisterInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("MsfServiceSdk", 2, "getRegisterPushMsg pushRegisterInfo null!");
      }
      return null;
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg(getMsfServiceName(), uin, "push.register");
    localToServiceMsg.setMsfCommand(MsfCommand.registerPush);
    m.a(localToServiceMsg, paramPushRegisterInfo);
    beforeSend(localToServiceMsg);
    return localToServiceMsg;
  }
  
  public ToServiceMsg getRegisterQueryUpSmsStatMsg()
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg(getMsfServiceName(), "0", "wtlogin.trans_emp");
    localToServiceMsg.setMsfCommand(MsfCommand.regUin_querySmsStat);
    beforeSend(localToServiceMsg);
    return localToServiceMsg;
  }
  
  public ToServiceMsg getRegisterSendReSendSmsMsg()
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg(getMsfServiceName(), "0", "wtlogin.trans_emp");
    localToServiceMsg.setMsfCommand(MsfCommand.regUin_reSendSms);
    beforeSend(localToServiceMsg);
    return localToServiceMsg;
  }
  
  public ToServiceMsg getReportMsg(byte paramByte, String paramString)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg(getMsfServiceName(), "0", "ConfigService.ClientReq");
    localToServiceMsg.setMsfCommand(MsfCommand.reportMsg);
    localToServiceMsg.getAttributes().put("to_report_type", Byte.valueOf(paramByte));
    localToServiceMsg.getAttributes().put("to_report_content", paramString);
    beforeSend(localToServiceMsg);
    return localToServiceMsg;
  }
  
  public ToServiceMsg getReportTrafficeMsg4Highway(Intent paramIntent)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg(getMsfServiceName(), "0", "socketnetflow");
    localToServiceMsg.setMsfCommand(MsfCommand.reportSocket);
    extraData.putString("ip", paramIntent.getStringExtra("ip"));
    extraData.putString("processName", "com.tencent.mobileqq");
    extraData.putString("refer", null);
    extraData.putInt("port", paramIntent.getIntExtra("port", 0));
    extraData.putString("mType", paramIntent.getStringExtra("mType"));
    extraData.putInt("flag", paramIntent.getIntExtra("flag", 0));
    extraData.putLong("buffersize", paramIntent.getLongExtra("buffersize", -1L));
    extraData.putInt("networktype", paramIntent.getIntExtra("networktype", 1));
    extraData.putByte("status", paramIntent.getByteExtra("status", (byte)0));
    localToServiceMsg.setNeedCallback(false);
    beforeSend(localToServiceMsg);
    return localToServiceMsg;
  }
  
  public ToServiceMsg getResetCmdCallMsg(String paramString, CommandCallbackerInfo paramCommandCallbackerInfo)
  {
    paramString = new ToServiceMsg(getMsfServiceName(), paramString, "push.resetCmds");
    paramString.setMsfCommand(MsfCommand.resetCmdCallback);
    m.a(paramString, paramCommandCallbackerInfo);
    beforeSend(paramString);
    return paramString;
  }
  
  public ToServiceMsg getResumedMsg()
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg(getMsfServiceName(), "0", "Msf.SetResume");
    localToServiceMsg.setMsfCommand(MsfCommand._setMsfResunmed);
    beforeSend(localToServiceMsg);
    return localToServiceMsg;
  }
  
  public ToServiceMsg getSendWtPkgMsg(String paramString1, long paramLong, String paramString2, byte[] paramArrayOfByte, int paramInt)
  {
    paramString1 = new ToServiceMsg(getMsfServiceName(), paramString1, paramString2);
    paramString1.setMsfCommand(MsfCommand.msf_send_wtpkg);
    beforeSend(paramString1);
    paramString1.setTimeout(paramInt);
    paramString1.getAttributes().put("wtsdkseq", Long.valueOf(paramLong));
    paramInt = paramArrayOfByte.length + 4;
    paramString2 = ByteBuffer.allocate(paramInt);
    paramString2.order(ByteOrder.BIG_ENDIAN);
    paramString2.putInt(paramInt);
    paramString2.put(paramArrayOfByte);
    paramString1.putWupBuffer(paramString2.array());
    return paramString1;
  }
  
  public ToServiceMsg getSubmitPuzzleVerifyCodeTicketMsg(String paramString, VerifyCodeInfo paramVerifyCodeInfo)
  {
    if (paramVerifyCodeInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("MsfServiceSdk", 2, "getSubmitPuzzleVerifyCodeSigMsg info null!");
      }
      return null;
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg(getMsfServiceName(), uin, "login.auth");
    localToServiceMsg.setMsfCommand(MsfCommand.submitPuzzleVerifyCodeTicket);
    VerifyCodeInfo.putVerifyCodeInfo(localToServiceMsg, paramVerifyCodeInfo);
    localToServiceMsg.getAttributes().put("to_puzzle_verify_code_sig", paramString);
    localToServiceMsg.setRequestSsoSeq(ssoSeq);
    beforeSend(localToServiceMsg);
    return localToServiceMsg;
  }
  
  public ToServiceMsg getSubmitVerifyCodeMsg(String paramString, VerifyCodeInfo paramVerifyCodeInfo)
  {
    if (paramVerifyCodeInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("MsfServiceSdk", 2, "getSubmitVerifyCodeMsg info null!");
      }
      return null;
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg(getMsfServiceName(), uin, "login.auth");
    localToServiceMsg.setMsfCommand(MsfCommand.submitVerifyCode);
    VerifyCodeInfo.putVerifyCodeInfo(localToServiceMsg, paramVerifyCodeInfo);
    localToServiceMsg.getAttributes().put("to_verify_code", paramString);
    localToServiceMsg.setRequestSsoSeq(ssoSeq);
    beforeSend(localToServiceMsg);
    return localToServiceMsg;
  }
  
  public ToServiceMsg getSuspendMsg()
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg(getMsfServiceName(), "0", "Msf.SetSuspend");
    localToServiceMsg.setMsfCommand(MsfCommand._setMsfSuspend);
    beforeSend(localToServiceMsg);
    return localToServiceMsg;
  }
  
  public ToServiceMsg getUnRegisterProxyMsg(int paramInt, String paramString1, String paramString2)
  {
    paramString1 = new ToServiceMsg(getMsfServiceName(), paramString1, "push.proxyUnRegister");
    paramString1.setMsfCommand(MsfCommand.proxyUnRegisterPush);
    paramString1.getAttributes().put(paramString1.getServiceCmd(), paramString2);
    beforeSend(paramString1);
    return paramString1;
  }
  
  public ToServiceMsg getUnRegisterPushMsg(PushRegisterInfo paramPushRegisterInfo)
  {
    if (paramPushRegisterInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("MsfServiceSdk", 2, "getUnRegisterPushMsg pushRegisterInfo null!");
      }
      return null;
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg(getMsfServiceName(), uin, "push.unRegister");
    localToServiceMsg.setMsfCommand(MsfCommand.unRegisterPush);
    m.a(localToServiceMsg, paramPushRegisterInfo);
    beforeSend(localToServiceMsg);
    return localToServiceMsg;
  }
  
  public void init(Context paramContext, int paramInt, String paramString1, String paramString2, IErrorHandler paramIErrorHandler, String paramString3)
  {
    proxy = new g(paramString2);
    proxy.a(this);
    super.initSub(paramString3, paramInt, paramString1, paramIErrorHandler);
    initFinished = true;
  }
  
  public void initMsfService()
  {
    proxy.a();
    proxy.b();
  }
  
  public void registerMsfService()
  {
    proxy.f();
  }
  
  public int sendMsg(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg == null) {
      return -1;
    }
    if (paramToServiceMsg.getServiceName().equals(getMsfServiceName())) {
      return proxy.b(paramToServiceMsg);
    }
    return d.a(paramToServiceMsg);
  }
  
  public void sendStartUseAccountBroadcast(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      if (QLog.isColorLevel()) {
        QLog.w("MsfServiceSdk", 2, "sendStartUseAccountBroadcast context null!");
      }
    }
    do
    {
      return;
      Intent localIntent = new Intent("com.tencent.mobileqq.usersync");
      localIntent.putExtra("uin", paramString);
      localIntent.putExtra("action", "enter");
      paramContext.sendBroadcast(localIntent);
    } while (!QLog.isColorLevel());
    QLog.d("MsfServiceSdk", 2, "send bootAction user " + paramString + " enter broadcast");
  }
  
  public void sendstopUseAccountBroadcast(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      if (QLog.isColorLevel()) {
        QLog.w("MsfServiceSdk", 2, "sendstopUseAccountBroadcast context null!");
      }
    }
    do
    {
      return;
      Intent localIntent = new Intent("com.tencent.mobileqq.usersync");
      localIntent.putExtra("uin", paramString);
      localIntent.putExtra("action", "exit");
      paramContext.sendBroadcast(localIntent);
    } while (!QLog.isColorLevel());
    QLog.d("MsfServiceSdk", 2, "send bootAction user " + paramString + " exit broadcast");
  }
  
  public void startBaseService()
  {
    proxy.a();
  }
  
  public void stopMsfService()
  {
    proxy.c();
  }
  
  public ArrayList syncGetLoginedAccountList()
  {
    return MsfSdkUtils.getLoginedAccountList();
  }
  
  public int syncGetNetInfo()
  {
    return AppNetConnInfo.getConnInfo();
  }
  
  public String syncGetServerAppConfig()
  {
    return syncGetServerConfig("0", 2);
  }
  
  public String syncGetServerCommonConfig()
  {
    return syncGetServerConfig("0", 0);
  }
  
  public String syncGetServerConfig(String paramString, int paramInt)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg(getMsfServiceName(), paramString, "cmd_getServerConfig");
    localToServiceMsg.setMsfCommand(MsfCommand.getServerConfig);
    localToServiceMsg.getAttributes().put("to_getServerConfig_type", Integer.valueOf(paramInt));
    beforeSend(localToServiceMsg);
    sendMsg(localToServiceMsg);
    return MsfSdkUtils.getServerConfig(processName, paramInt, paramString);
  }
  
  public String syncGetServerUserConfig(String paramString)
  {
    return syncGetServerConfig(paramString, 1);
  }
  
  public void unRegisterMsfService()
  {
    proxy.a(Boolean.valueOf(true));
  }
  
  public void unRegisterMsfService(Boolean paramBoolean)
  {
    proxy.a(paramBoolean);
  }
  
  public void unbindMsfService()
  {
    proxy.e();
    proxy.g();
  }
}
