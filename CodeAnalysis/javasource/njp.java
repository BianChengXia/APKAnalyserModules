import com.tencent.mobileqq.app.message.C2CMessageProcessor;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.mobileqq.statistics.StatisticCollector;
import java.util.HashMap;

public class njp
  implements Runnable
{
  public njp(C2CMessageProcessor paramC2CMessageProcessor, String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, String paramString4)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("fromUin", jdField_a_of_type_JavaLangString);
    localHashMap.put("toUin", jdField_b_of_type_JavaLangString);
    localHashMap.put("msgId", c);
    localHashMap.put("createTime", String.valueOf(jdField_a_of_type_Long));
    localHashMap.put("recvTime", String.valueOf(jdField_b_of_type_Long));
    localHashMap.put("sendFlag", d);
    localHashMap.put("nodeNo", String.valueOf(3000));
    long l2 = jdField_b_of_type_Long - jdField_a_of_type_Long;
    long l1;
    if (l2 > 0L)
    {
      l1 = l2;
      if (l2 <= 86400L) {}
    }
    else
    {
      l1 = 0L;
    }
    StatisticCollector.a(BaseApplication.getContext()).a(null, "actPubAccMsgReceipt", true, l1, 0L, localHashMap, null);
  }
}
