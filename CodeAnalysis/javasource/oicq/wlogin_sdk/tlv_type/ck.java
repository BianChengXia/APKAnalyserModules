package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.cryptor;
import oicq.wlogin_sdk.tools.util;

public class ck
  extends a
{
  int h = 1;
  int i = 0;
  
  public ck()
  {
    g = 1024;
  }
  
  public byte[] a(byte[] paramArrayOfByte1, long paramLong1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, long paramLong2, long paramLong3, byte[] paramArrayOfByte4)
  {
    byte[] arrayOfByte = paramArrayOfByte1;
    if (paramArrayOfByte1 == null) {
      arrayOfByte = new byte[16];
    }
    paramArrayOfByte1 = paramArrayOfByte2;
    if (paramArrayOfByte2 == null) {
      paramArrayOfByte1 = new byte[16];
    }
    paramArrayOfByte2 = paramArrayOfByte3;
    if (paramArrayOfByte3 == null) {
      paramArrayOfByte2 = new byte[16];
    }
    paramArrayOfByte3 = paramArrayOfByte4;
    if (paramArrayOfByte4 == null) {
      paramArrayOfByte3 = new byte[8];
    }
    i = (paramArrayOfByte1.length + 10 + paramArrayOfByte2.length + 4 + 4 + 4 + paramArrayOfByte3.length);
    paramArrayOfByte4 = new byte[i];
    util.int16_to_buf(paramArrayOfByte4, 0, h);
    util.int64_to_buf(paramArrayOfByte4, 2, paramLong1);
    System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte4, 10, paramArrayOfByte1.length);
    int j = paramArrayOfByte1.length + 10;
    System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte4, j, paramArrayOfByte2.length);
    j += paramArrayOfByte2.length;
    util.int32_to_buf(paramArrayOfByte4, j, (int)paramLong2);
    j += 4;
    util.int32_to_buf(paramArrayOfByte4, j, (int)paramLong3);
    j += 4;
    util.int64_to_buf32(paramArrayOfByte4, j, util.get_server_cur_time());
    j += 4;
    System.arraycopy(paramArrayOfByte3, 0, paramArrayOfByte4, j, paramArrayOfByte3.length);
    j = paramArrayOfByte3.length;
    paramArrayOfByte1 = cryptor.encrypt(paramArrayOfByte4, 0, paramArrayOfByte4.length, arrayOfByte);
    i = paramArrayOfByte1.length;
    a(g);
    b(paramArrayOfByte1, paramArrayOfByte1.length);
    d();
    return a();
  }
}
