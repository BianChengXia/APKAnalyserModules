package com.tencent.msf.service.protocol.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SSOReserveField
{
  private SSOReserveField() {}
  
  public static final class ReserveFields
    extends MessageMicro
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 48, 56 }, new String[] { "type", "extra", "app_recv", "sdk_send", "sdk_recv", "sso_send", "sso_recv" }, new Object[] { Integer.valueOf(0), "", Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L) }, ReserveFields.class);
    public final PBUInt64Field app_recv = PBField.initUInt64(0L);
    public final PBStringField extra = PBField.initString("");
    public final PBUInt64Field sdk_recv = PBField.initUInt64(0L);
    public final PBUInt64Field sdk_send = PBField.initUInt64(0L);
    public final PBUInt64Field sso_recv = PBField.initUInt64(0L);
    public final PBUInt64Field sso_send = PBField.initUInt64(0L);
    public final PBUInt32Field type = PBField.initUInt32(0);
    
    public ReserveFields() {}
  }
}
