package com.tencent.mobileqq.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat.Builder;
import android.widget.RemoteViews;
import com.tencent.biz.bmqq.protocol.BmqqBusinessService;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.NotificationDeleteReceiver;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.compatible.ActionListener;
import com.tencent.mobileqq.compatible.TempServlet;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.managers.LoadingStateManager;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.service.RegisterProxySvcPack.RegisterProxySvcPackService;
import com.tencent.mobileqq.service.cardpay.CardPayService;
import com.tencent.mobileqq.service.config.ConfigService;
import com.tencent.mobileqq.service.discussion.DiscussionService;
import com.tencent.mobileqq.service.friendlist.FriendListService;
import com.tencent.mobileqq.service.lbs.LBSService;
import com.tencent.mobileqq.service.message.MessageService;
import com.tencent.mobileqq.service.profile.ProfileService;
import com.tencent.mobileqq.service.push.PushService;
import com.tencent.mobileqq.service.qcard.QQCardService;
import com.tencent.mobileqq.service.qwallet.QWalletAuthService;
import com.tencent.mobileqq.service.qwallet.QWalletOpenService;
import com.tencent.mobileqq.service.qwallet.UniPayService;
import com.tencent.mobileqq.service.qwallet.VIPRecommendService;
import com.tencent.mobileqq.service.qzone.QZoneService;
import com.tencent.mobileqq.service.report.ReportService;
import com.tencent.mobileqq.util.NotifyLightUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.KapalaiAdapterUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.MobileIssueSettings;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BadgeUtils;
import java.util.Calendar;
import java.util.Random;
import mqq.app.MobileQQ;
import raf;
import rag;

public class MobileQQService
  extends MobileQQServiceBase
{
  public static final int a = 1;
  public static final String a = "MobileQQService";
  public static final int b = 2;
  private NotificationManager jdField_a_of_type_AndroidAppNotificationManager;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ActionListener jdField_a_of_type_ComTencentMobileqqCompatibleActionListener;
  private Random jdField_a_of_type_JavaUtilRandom;
  private boolean jdField_a_of_type_Boolean;
  private volatile boolean b;
  private int d;
  
  public MobileQQService(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaUtilRandom = new Random();
    jdField_a_of_type_Boolean = false;
    d = 0;
    b = false;
    jdField_a_of_type_ComTencentMobileqqCompatibleActionListener = new raf(this);
    jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new rag(this);
    jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    b();
  }
  
  private Notification a(Intent paramIntent, Bitmap paramBitmap, String paramString1, String paramString2)
  {
    PendingIntent localPendingIntent = PendingIntent.getActivity(BaseApplication.getContext(), 0, paramIntent, 134217728);
    Notification localNotification;
    int i;
    if (!MobileIssueSettings.e)
    {
      localNotification = KapalaiAdapterUtil.a().a(BaseApplication.getContext(), 2130838557);
      paramIntent = localNotification;
      if (QLog.isColorLevel())
      {
        QLog.i("MobileQQService", 2, "buildIdleNotification by newNotificationForMeizu. nf=" + localNotification);
        paramIntent = localNotification;
      }
      icon = 2130838557;
      if (!jdField_a_of_type_Boolean) {
        break label189;
      }
      if (paramBitmap != null)
      {
        i = jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a("icon");
        if ((i > 0) && (contentView != null)) {
          contentView.setImageViewBitmap(i, paramBitmap);
        }
      }
      paramIntent.setLatestEventInfo(BaseApplication.getContext(), paramString1, paramString2, localPendingIntent);
    }
    label189:
    do
    {
      do
      {
        return paramIntent;
        localNotification = new Notification(2130838557, null, System.currentTimeMillis());
        paramIntent = localNotification;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("MobileQQService", 2, "buildIdleNotification by default. nf=" + localNotification);
        paramIntent = localNotification;
        break;
        paramIntent.setLatestEventInfo(BaseApplication.getContext(), paramString1, paramString2, localPendingIntent);
      } while (paramBitmap == null);
      i = jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a("icon");
    } while ((i <= 0) || (contentView == null));
    contentView.setImageViewBitmap(i, paramBitmap);
    return paramIntent;
  }
  
  private Notification a(Intent paramIntent, Bitmap paramBitmap, String paramString1, String paramString2, String paramString3)
  {
    boolean bool1 = jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b();
    PendingIntent localPendingIntent = PendingIntent.getActivity(BaseApplication.getContext(), 0, paramIntent, 268435456);
    if (QLog.isColorLevel()) {
      QLog.i("MobileQQService", 2, "buildNotification by getActivity. contentIntent=" + localPendingIntent);
    }
    int j = 2130838558;
    int i = j;
    if (paramIntent.getIntExtra("uintype", -1) == 1008)
    {
      i = j;
      if (!AppConstants.ad.equals(paramIntent.getStringExtra("uin")))
      {
        if (!paramIntent.getBooleanExtra("activepull_push_flag", false)) {
          break label305;
        }
        i = j;
      }
    }
    boolean bool2 = paramIntent.getBooleanExtra("key_notifycation_oneway_message", false);
    j = i;
    if (bool2)
    {
      j = i;
      if (paramIntent.getIntExtra("uintype", -1) == 1010) {
        j = 2130840648;
      }
    }
    i = j;
    if (bool2)
    {
      i = j;
      if (paramIntent.getIntExtra("uintype", -1) == 1001) {
        i = 2130838454;
      }
    }
    if (paramIntent.getBooleanExtra("qav_notify_flag", false)) {
      i = 2130838902;
    }
    paramIntent = new NotificationCompat.Builder(BaseApplication.getContext()).setSmallIcon(i).setAutoCancel(true).setWhen(System.currentTimeMillis()).setTicker(paramString1);
    if (bool1) {
      paramIntent.setOngoing(true);
    }
    if (NotifyLightUtil.a(BaseApplication.getContext(), jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      Calendar.getInstance().get(11);
      paramIntent.setLights(-16711936, 2000, 2000);
    }
    if (jdField_a_of_type_Boolean)
    {
      if (paramBitmap != null) {
        paramIntent.setLargeIcon(paramBitmap);
      }
      paramIntent.setContentTitle(paramString2).setContentText(paramString3).setContentIntent(localPendingIntent);
    }
    for (;;)
    {
      return paramIntent.build();
      label305:
      i = 2130838643;
      break;
      paramIntent.setContentTitle(paramString2).setContentText(paramString3).setContentIntent(localPendingIntent);
      if (paramBitmap != null) {
        paramIntent.setLargeIcon(paramBitmap);
      }
    }
  }
  
  private PendingIntent a()
  {
    Intent localIntent = new Intent(BaseApplication.getContext(), NotificationDeleteReceiver.class);
    return PendingIntent.getBroadcast(BaseApplication.getContext(), 0, localIntent, 268435456);
  }
  
  private void a(boolean paramBoolean) {}
  
  private void b(ToServiceMsg paramToServiceMsg)
  {
    String[] arrayOfString = extraData.getStringArray("cmds");
    if (arrayOfString.length != 3) {
      return;
    }
    Bitmap localBitmap = (Bitmap)extraData.getParcelable("bitmap");
    paramToServiceMsg = a((Intent)extraData.getParcelable("intent"), localBitmap, arrayOfString[1], arrayOfString[2]);
    flags = 34;
    b();
    if (jdField_a_of_type_AndroidAppNotificationManager != null) {
      jdField_a_of_type_AndroidAppNotificationManager.cancel(121);
    }
    a(119, paramToServiceMsg);
  }
  
  private void c(ToServiceMsg paramToServiceMsg)
  {
    String[] arrayOfString = extraData.getStringArray("cmds");
    if (arrayOfString.length != 3) {
      return;
    }
    Intent localIntent = (Intent)extraData.getParcelable("intent");
    Bitmap localBitmap = (Bitmap)extraData.getParcelable("bitmap");
    boolean bool = localIntent.getBooleanExtra("key_notifycation_oneway_message", false);
    if (!MobileIssueSettings.e)
    {
      paramToServiceMsg = KapalaiAdapterUtil.a().a(localIntent, localBitmap, arrayOfString[0], arrayOfString[1], arrayOfString[2], jdField_a_of_type_Boolean, jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      deleteIntent = a();
      b();
      if (!SettingCloneUtil.readValue(BaseApplication.getContext(), jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), BaseApplication.getContext().getString(2131368180), "qqsetting_notify_showcontent_key", true)) {
        break label706;
      }
      if (localIntent.getIntExtra("uintype", -1) != 1008) {
        break label340;
      }
      if (jdField_a_of_type_AndroidAppNotificationManager != null) {
        jdField_a_of_type_AndroidAppNotificationManager.cancel(122);
      }
      a(122, paramToServiceMsg);
    }
    for (;;)
    {
      paramToServiceMsg = new Intent("com.tencent.msg.newmessage");
      paramToServiceMsg.setPackage("com.tencent.mobileqq");
      paramToServiceMsg.putExtra("cmds", arrayOfString);
      paramToServiceMsg.putExtra("intent", localIntent);
      paramToServiceMsg.putExtra("type", 0);
      paramToServiceMsg.putExtra("bitmap", localBitmap);
      jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().sendBroadcast(paramToServiceMsg);
      return;
      if (MobileIssueSettings.m)
      {
        Notification localNotification = a(localIntent, null, arrayOfString[0], arrayOfString[1], arrayOfString[2]);
        int i = jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a("icon");
        paramToServiceMsg = localNotification;
        if (i <= 0) {
          break;
        }
        paramToServiceMsg = localNotification;
        if (contentView == null) {
          break;
        }
        contentView.setImageViewBitmap(i, localBitmap);
        paramToServiceMsg = localNotification;
        break;
      }
      paramToServiceMsg = a(localIntent, localBitmap, arrayOfString[0], arrayOfString[1], arrayOfString[2]);
      break;
      label340:
      if ((bool) && (localIntent.getIntExtra("uintype", -1) == 1010))
      {
        if (jdField_a_of_type_AndroidAppNotificationManager != null) {
          jdField_a_of_type_AndroidAppNotificationManager.cancel(140);
        }
        a(140, paramToServiceMsg);
        if (QLog.isColorLevel()) {
          QLog.d("MobileQQService", 2, "entry show_NOTIFY_ID_DATE_UNREAD notify");
        }
      }
      else if ((bool) && (localIntent.getIntExtra("uintype", -1) == 1001))
      {
        if (jdField_a_of_type_AndroidAppNotificationManager != null) {
          jdField_a_of_type_AndroidAppNotificationManager.cancel(135);
        }
        a(135, paramToServiceMsg);
        if (QLog.isColorLevel()) {
          QLog.d("MobileQQService", 2, "entry show_NOTIFY_ID_LBS_FRIEND_UNREAD notify");
        }
      }
      else if (localIntent.getBooleanExtra("extra_notification_sec_msg", false))
      {
        if (jdField_a_of_type_AndroidAppNotificationManager != null) {
          jdField_a_of_type_AndroidAppNotificationManager.cancel(123);
        }
        a(123, paramToServiceMsg);
      }
      else if (localIntent.getBooleanExtra("qav_notify_flag", false))
      {
        if (jdField_a_of_type_AndroidAppNotificationManager != null) {
          jdField_a_of_type_AndroidAppNotificationManager.cancel(129);
        }
        a(129, paramToServiceMsg);
      }
      else if (localIntent.getIntExtra("uintype", -1) == 3001)
      {
        if (jdField_a_of_type_AndroidAppNotificationManager != null) {
          jdField_a_of_type_AndroidAppNotificationManager.cancel(144);
        }
        a(144, paramToServiceMsg);
      }
      else if (localIntent.getBooleanExtra("_dingdong_notification_schedule_has_flag_", false))
      {
        if (jdField_a_of_type_AndroidAppNotificationManager != null) {
          jdField_a_of_type_AndroidAppNotificationManager.cancel(193);
        }
        flags |= 0x20;
        a(193, paramToServiceMsg);
      }
      else if (localIntent.getBooleanExtra("activepull_push_flag", false))
      {
        if (jdField_a_of_type_AndroidAppNotificationManager != null) {
          jdField_a_of_type_AndroidAppNotificationManager.cancel(194);
        }
        a(194, paramToServiceMsg);
      }
      else
      {
        if (jdField_a_of_type_AndroidAppNotificationManager != null)
        {
          jdField_a_of_type_AndroidAppNotificationManager.cancel(121);
          jdField_a_of_type_AndroidAppNotificationManager.cancel(119);
        }
        a(121, paramToServiceMsg);
        continue;
        label706:
        if (localIntent.getBooleanExtra("qav_notify_flag", false))
        {
          if (jdField_a_of_type_AndroidAppNotificationManager != null) {
            jdField_a_of_type_AndroidAppNotificationManager.cancel(129);
          }
          a(129, paramToServiceMsg);
        }
        else if (localIntent.getBooleanExtra("_dingdong_notification_schedule_has_flag_", false))
        {
          if (jdField_a_of_type_AndroidAppNotificationManager != null) {
            jdField_a_of_type_AndroidAppNotificationManager.cancel(193);
          }
          flags |= 0x20;
          a(193, paramToServiceMsg);
        }
        else
        {
          if (jdField_a_of_type_AndroidAppNotificationManager != null)
          {
            jdField_a_of_type_AndroidAppNotificationManager.cancel(121);
            jdField_a_of_type_AndroidAppNotificationManager.cancel(119);
          }
          a(121, paramToServiceMsg);
        }
      }
    }
  }
  
  public AppInterface a()
  {
    return jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  }
  
  protected void a()
  {
    try
    {
      super.a();
      Object localObject1 = new ProfileService(jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      ((ProfileService)localObject1).a();
      a((BaseProtocolCoder)localObject1);
      localObject1 = new FriendListService(jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      ((FriendListService)localObject1).a();
      a((BaseProtocolCoder)localObject1);
      localObject1 = new MessageService(jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      ((MessageService)localObject1).a();
      a((BaseProtocolCoder)localObject1);
      localObject1 = new LBSService(jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      ((LBSService)localObject1).a();
      a((BaseProtocolCoder)localObject1);
      localObject1 = new QZoneService();
      ((QZoneService)localObject1).a();
      a((BaseProtocolCoder)localObject1);
      localObject1 = new PushService();
      ((PushService)localObject1).a();
      a((BaseProtocolCoder)localObject1);
      ((PushService)localObject1).a(jdField_a_of_type_ComTencentMobileqqCompatibleActionListener);
      localObject1 = new ConfigService();
      ((ConfigService)localObject1).a();
      a((BaseProtocolCoder)localObject1);
      localObject1 = new ReportService();
      ((ReportService)localObject1).a();
      a((BaseProtocolCoder)localObject1);
      localObject1 = new DiscussionService();
      ((DiscussionService)localObject1).a();
      a((BaseProtocolCoder)localObject1);
      localObject1 = new RegisterProxySvcPackService(jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      ((RegisterProxySvcPackService)localObject1).a();
      a((BaseProtocolCoder)localObject1);
      localObject1 = new VIPService();
      ((VIPService)localObject1).a();
      a((BaseProtocolCoder)localObject1);
      localObject1 = new CardPayService();
      ((CardPayService)localObject1).a();
      a((BaseProtocolCoder)localObject1);
      localObject1 = new QWalletOpenService();
      ((QWalletOpenService)localObject1).a();
      a((BaseProtocolCoder)localObject1);
      localObject1 = new QQCardService();
      ((QQCardService)localObject1).a();
      a((BaseProtocolCoder)localObject1);
      localObject1 = new BmqqBusinessService(jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      ((BmqqBusinessService)localObject1).a();
      a((BaseProtocolCoder)localObject1);
      localObject1 = new UniPayService();
      ((UniPayService)localObject1).a();
      a((BaseProtocolCoder)localObject1);
      localObject1 = new VIPRecommendService();
      ((VIPRecommendService)localObject1).a();
      a((BaseProtocolCoder)localObject1);
      b = true;
      localObject1 = new QWalletAuthService();
      ((QWalletAuthService)localObject1).a();
      a((BaseProtocolCoder)localObject1);
      return;
    }
    finally
    {
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  void a(int paramInt)
  {
    jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    if ((jdField_a_of_type_AndroidAppNotificationManager != null) && (jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication() != null)) {}
    try
    {
      jdField_a_of_type_AndroidAppNotificationManager.cancel(paramInt);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  void a(int paramInt, Notification paramNotification)
  {
    int j = 0;
    jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    if (jdField_a_of_type_AndroidAppNotificationManager != null) {}
    for (;;)
    {
      int i;
      try
      {
        QQMessageFacade localQQMessageFacade = jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        QCallFacade localQCallFacade = jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        if (localQCallFacade == null) {
          break label235;
        }
        i = localQCallFacade.a();
        if (localQQMessageFacade == null) {
          break label240;
        }
        j = localQQMessageFacade.e();
      }
      catch (Throwable paramNotification)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("MobileQQService", 2, "startForegroundCompat exception. id=" + paramInt + ", mNM=" + jdField_a_of_type_AndroidAppNotificationManager, paramNotification);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("BadgeUtilImpl", 2, "startForegroundCompat changeMI6Badge count=" + j);
      }
      BadgeUtils.a(jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), j, paramNotification);
      jdField_a_of_type_AndroidAppNotificationManager.notify(paramInt, paramNotification);
      return;
      if (paramInt == 129)
      {
        j = i;
        continue;
        if (QLog.isColorLevel()) {
          QLog.i("MobileQQService", 2, "startForegroundCompat. id=" + paramInt + ", mNM=" + jdField_a_of_type_AndroidAppNotificationManager);
        }
      }
      else
      {
        j = 1;
        continue;
        label235:
        i = 0;
        continue;
        label240:
        if (paramInt != 121) {}
      }
    }
  }
  
  protected void a(FromServiceMsg paramFromServiceMsg)
  {
    LoadingStateManager.a().a(paramFromServiceMsg, jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void a(ToServiceMsg paramToServiceMsg)
  {
    b(paramToServiceMsg, jdField_a_of_type_ComTencentMobileqqCompatibleActionListener, TempServlet.class);
  }
  
  protected void a(ToServiceMsg paramToServiceMsg, ActionListener paramActionListener, Class paramClass)
  {
    if (paramToServiceMsg == null) {}
    do
    {
      return;
      paramClass = paramToServiceMsg.getServiceCmd();
      if (!"CMD_SHOW_NOTIFIYCATION".equals(paramClass)) {
        break;
      }
      if (!((PhoneContactManagerImp)jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).a())
      {
        c(paramToServiceMsg);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("MobileQQService", 2, "pcm blocked msg notification");
    return;
    if ("CMD_IDLE_NOTIFIYCATION".equals(paramClass))
    {
      jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.E();
      b(paramToServiceMsg);
      return;
    }
    if ("CMD_STOP_NOTIFIYCATION".equals(paramClass))
    {
      jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.E();
      a(119);
      return;
    }
    if ("CMD_CANCLE_NOTIFIYCATION".equals(paramClass))
    {
      b(119);
      return;
    }
    super.a(paramToServiceMsg, paramActionListener, TempServlet.class);
  }
  
  public void a(boolean paramBoolean, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Exception paramException)
  {
    if (paramToServiceMsg == null) {
      return;
    }
    if (!paramBoolean)
    {
      if (paramFromServiceMsg.getResultCode() == 2008)
      {
        paramFromServiceMsg = BaseActivity.sTopActivity;
        paramToServiceMsg = paramFromServiceMsg;
        if (paramFromServiceMsg == null) {
          paramToServiceMsg = jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication();
        }
        paramFromServiceMsg = new Intent(paramToServiceMsg, NotificationActivity.class);
        paramFromServiceMsg.setFlags(872415232);
        paramFromServiceMsg.putExtra("type", 2);
        paramToServiceMsg.startActivity(paramFromServiceMsg);
        return;
      }
      if ((paramException == null) && ((paramFromServiceMsg.getResultCode() == 1002) || (paramFromServiceMsg.getResultCode() == 1013)) && ("ProfileService.CheckUpdateReq".equals(paramFromServiceMsg.getServiceCmd()))) {
        jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.a();
      }
    }
    super.a(paramBoolean, paramToServiceMsg, paramFromServiceMsg, paramException);
  }
  
  public void b()
  {
    if ((jdField_a_of_type_AndroidAppNotificationManager == null) && (d < 3)) {}
    try
    {
      jdField_a_of_type_Boolean = DeviceInfoUtil.a();
      a(true);
      jdField_a_of_type_AndroidAppNotificationManager = ((NotificationManager)jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSystemService("notification"));
      c = Math.abs(jdField_a_of_type_JavaUtilRandom.nextInt());
      if (QLog.isColorLevel()) {
        QLog.i("MobileQQService", 2, "MobileQQService has created. mNM=" + jdField_a_of_type_AndroidAppNotificationManager);
      }
      d += 1;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MobileQQService", 2, "e = " + localException.toString());
        }
      }
    }
  }
  
  void b(int paramInt)
  {
    if (jdField_a_of_type_AndroidAppNotificationManager != null) {
      jdField_a_of_type_AndroidAppNotificationManager.cancel(paramInt);
    }
  }
  
  public void c()
  {
    a(false);
    a(119);
    if (QLog.isColorLevel()) {
      QLog.i("MobileQQService", 2, "MobileQQService has destroyed.");
    }
    super.c();
  }
}
