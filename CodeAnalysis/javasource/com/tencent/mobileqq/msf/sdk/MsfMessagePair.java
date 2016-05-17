package com.tencent.mobileqq.msf.sdk;

import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class MsfMessagePair
{
  public FromServiceMsg fromServiceMsg;
  public ToServiceMsg toServiceMsg;
  
  public MsfMessagePair(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    toServiceMsg = paramToServiceMsg;
    fromServiceMsg = paramFromServiceMsg;
  }
}
