package com.tencent.mobileqq.app.upgrade;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.widget.Toast;
import com.tencent.apkupdate.ApkUpdateParam;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.open.downloadnew.DownloadApi;
import com.tencent.open.downloadnew.DownloadConstants;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.open.downloadnew.DownloadQueryListener;
import com.tencent.open.downloadnew.UpdateManager;
import com.tencent.open.downloadnew.UpdateManager.OnCheckUpdateListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import com.tencent.util.WeakReferenceHandler;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import nmk;
import protocol.KQQConfig.UpgradeInfo;

public final class UpgradeController
  implements Handler.Callback, DownloadListener, DownloadQueryListener, UpdateManager.OnCheckUpdateListener
{
  public static final int a = 0;
  private static UpgradeController jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeController;
  public static final String a = "UpgradeController";
  public static final int b = 1;
  public static final String b = "qqupgrade";
  public static final int c = -1;
  public static final String c = "100686848";
  public static final int d = 0;
  private static final String d = "_100686848";
  public static final int e = 1;
  private static final String e = "ANDROIDQQ.QQUPDATE";
  public static final int f = 2;
  private static final String f = "6633";
  public static final int g = 3;
  public static final int h = 4;
  public static final int i = 100000;
  public static final int j = 100001;
  public static final int k = 100002;
  public static final int l = 100003;
  public static final int m = 100004;
  public static final int n = 100005;
  public static final int o = 100006;
  private static final int p = 1;
  private Application jdField_a_of_type_AndroidAppApplication;
  private UpgradeController.AutoDownloadInWifiController jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeController$AutoDownloadInWifiController;
  private UpgradeDetailWrapper jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper;
  private DownloadInfo jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo;
  private WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private final ArrayList jdField_a_of_type_JavaUtilArrayList;
  private volatile boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  
  private UpgradeController()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
    a(false);
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    if (((paramInt1 == 12) || (paramInt1 == 2)) && (a() == 4)) {
      return 0;
    }
    if ((jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper == null) || (jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo == null)) {
      return 1;
    }
    String str;
    Bundle localBundle;
    if ((jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper != null) && (jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper$NewApkInfo != null) && (jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper$NewApkInfo.jdField_a_of_type_JavaLangString != null))
    {
      str = jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper$NewApkInfo.jdField_a_of_type_JavaLangString;
      localBundle = new Bundle();
      localBundle.putString(DownloadConstants.jdField_a_of_type_JavaLangString, "100686848");
      localBundle.putString(DownloadConstants.i, jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strNewSoftwareURL);
      localBundle.putString(DownloadConstants.e, jdField_a_of_type_AndroidAppApplication.getPackageName());
      localBundle.putInt(DownloadConstants.j, paramInt1);
      if (paramInt1 == 12) {
        localBundle.putBoolean(DownloadConstants.n, true);
      }
      localBundle.putString(DownloadConstants.h, "ANDROIDQQ.QQUPDATE");
      localBundle.putString(DownloadConstants.k, str);
      if (paramInt2 == 0) {
        break label347;
      }
      localBundle.putString(DownloadConstants.l, "_100686848");
      localBundle.putBoolean(DownloadConstants.w, false);
      i1 = paramInt2;
      if (paramInt1 != 5)
      {
        i1 = paramInt2;
        if (jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iIncrementUpgrade != 0) {}
      }
    }
    for (int i1 = 0;; i1 = paramInt2)
    {
      localBundle.putString(DownloadConstants.b, "6633");
      if ((jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper$NewApkInfo != null) && (jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper$NewApkInfo.jdField_a_of_type_Int > 0)) {
        localBundle.putInt(DownloadConstants.d, jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper$NewApkInfo.jdField_a_of_type_Int);
      }
      localBundle.putBoolean(DownloadConstants.f, true);
      localBundle.putBoolean(DownloadConstants.g, true);
      localBundle.putInt(DownloadConstants.m, 1);
      localBundle.putInt(DownloadConstants.z, jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.bGray);
      DownloadApi.a(BaseActivity.sTopActivity, localBundle, 1, jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail, i1);
      return 0;
      str = "新版手Q";
      break;
      label347:
      localBundle.putBoolean(DownloadConstants.w, true);
    }
  }
  
  private static ApplicationInfo a(Context paramContext, String paramString)
  {
    Object localObject = null;
    paramString = paramContext.getPackageManager().getPackageArchiveInfo(paramString, 1);
    paramContext = localObject;
    if (paramString != null) {
      paramContext = applicationInfo;
    }
    return paramContext;
  }
  
  public static UpgradeController a()
  {
    if (jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeController == null) {
      jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeController = new UpgradeController();
    }
    return jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeController;
  }
  
  public static String a()
  {
    String str2 = "";
    Object localObject = a();
    String str1 = str2;
    if (localObject != null)
    {
      localObject = jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper;
      str1 = str2;
      if (localObject != null)
      {
        str1 = str2;
        if (jdField_a_of_type_ProtocolKQQConfigUpgradeInfo != null) {
          str1 = "" + jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeSdkId;
        }
      }
    }
    return str1;
  }
  
  public static String a(String paramString)
  {
    return URLUtil.a(paramString, "nt", UpgradeConstants.a());
  }
  
  private void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "invokeStateChangedToListeners:" + paramInt);
    }
    synchronized (jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
      if (localIterator.hasNext()) {
        ((UpgradeController.OnStateChangedListener)localIterator.next()).a(paramInt, this);
      }
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    Object localObject = a();
    boolean bool1 = bool3;
    if (localObject != null)
    {
      localObject = jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper;
      bool1 = bool3;
      if (localObject != null)
      {
        bool1 = bool3;
        if (jdField_a_of_type_ProtocolKQQConfigUpgradeInfo != null)
        {
          if ((jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeType <= 0) || (jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.bNewSwitch != 1)) {
            break label88;
          }
          bool1 = true;
          if (!bool1) {
            return bool1;
          }
          if (ConfigHandler.a(paramQQAppInterface, jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iNewTimeStamp)) {
            break label93;
          }
        }
      }
    }
    label88:
    label93:
    for (bool1 = bool2;; bool1 = false)
    {
      return bool1;
      bool1 = false;
      break;
    }
    return bool1;
  }
  
  public static String b()
  {
    int i2 = 0;
    Object localObject = a();
    int i1 = i2;
    if (localObject != null)
    {
      localObject = jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper;
      i1 = i2;
      if (localObject != null)
      {
        i1 = i2;
        if (jdField_a_of_type_ProtocolKQQConfigUpgradeInfo != null) {
          i1 = jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iTipsType;
        }
      }
    }
    return String.valueOf(i1);
  }
  
  private void d(boolean paramBoolean)
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.a().a();
    if (localObject == null) {
      return;
    }
    ConfigHandler.a((QQAppInterface)localObject, b());
    String str;
    if ((jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo != null) && (jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeType == 1))
    {
      if (!paramBoolean) {
        break label214;
      }
      str = ConfigHandler.a(jdField_a_of_type_AndroidAppApplication);
    }
    for (;;)
    {
      try
      {
        BaseActivity localBaseActivity = BaseActivity.sTopActivity;
        if ((localBaseActivity != null) && (str != null) && (!str.startsWith("com.tencent.av.")) && (!str.equals("com.tencent.mobileqq.activity.UserguideActivity")) && (!str.equals("com.tencent.mobileqq.activity.UpgradeDetailActivity"))) {
          localBaseActivity.runOnUiThread(new nmk(this, localBaseActivity, (QQAppInterface)localObject));
        }
        localObject = ((QQAppInterface)localObject).a(Conversation.class);
        if (localObject != null) {
          ((MqqHandler)localObject).obtainMessage(1134018).sendToTarget();
        }
      }
      catch (Exception localException)
      {
        int i1;
        label214:
        continue;
      }
      i1 = 0;
      if (NetworkUtil.h(jdField_a_of_type_AndroidAppApplication)) {
        i1 = 1;
      }
      localObject = new HashMap();
      ((HashMap)localObject).put("param_FailCode", Integer.toString(i1));
      ((HashMap)localObject).put("param_ErrMsg", "success");
      StatisticCollector.a(jdField_a_of_type_AndroidAppApplication).a("", "UpgradeErr", true, 0L, 0L, (HashMap)localObject, "", true);
      return;
      localObject = ((QQAppInterface)localObject).a(Conversation.class);
      if (localObject != null) {
        ((MqqHandler)localObject).obtainMessage(1134018).sendToTarget();
      }
    }
  }
  
  private void f()
  {
    if (jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      UpgradeController.OnHandleUpgradeFinishListener localOnHandleUpgradeFinishListener = (UpgradeController.OnHandleUpgradeFinishListener)jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localOnHandleUpgradeFinishListener != null)
      {
        localOnHandleUpgradeFinishListener.a(0, jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper, this);
        jdField_a_of_type_JavaLangRefWeakReference = null;
      }
    }
  }
  
  private void g()
  {
    ArrayList localArrayList = new ArrayList();
    DownloadInfo localDownloadInfo = new DownloadInfo();
    b = "100686848";
    d = jdField_a_of_type_AndroidAppApplication.getPackageName();
    i = "6633";
    if ((jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper$NewApkInfo != null) && (jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper$NewApkInfo.jdField_a_of_type_Int > 0)) {
      g = jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper$NewApkInfo.jdField_a_of_type_Int;
    }
    localArrayList.add(localDownloadInfo);
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "queryDownloadInfo:" + localDownloadInfo);
    }
    DownloadApi.a(localArrayList, this);
  }
  
  private void h()
  {
    try
    {
      if (!b())
      {
        jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeController$AutoDownloadInWifiController = new UpgradeController.AutoDownloadInWifiController(this);
        jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeController$AutoDownloadInWifiController.a();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void i()
  {
    try
    {
      if (b())
      {
        jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeController$AutoDownloadInWifiController.b();
        jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeController$AutoDownloadInWifiController = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void j()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("UpgradeController", 2, "initDownloadEnv: " + c);
      }
      if (!c)
      {
        UpdateManager.a().a(this);
        DownloadApi.a(this);
        c = true;
      }
      return;
    }
    finally {}
  }
  
  private void k()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("UpgradeController", 2, "releaseDownloadEnv: " + c);
      }
      if (c)
      {
        UpdateManager.a().b(this);
        UpdateManager.a().a();
        DownloadApi.b(this);
        c = false;
      }
      return;
    }
    finally {}
  }
  
  public int a()
  {
    int i2 = 0;
    int i1 = i2;
    if (jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo != null)
    {
      i1 = i2;
      switch (jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.a())
      {
      default: 
        i1 = i2;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("UpgradeController", 2, "getDownloadState: " + i1);
      }
      return i1;
      i1 = 4;
      continue;
      i1 = 1;
      continue;
      i1 = 2;
      continue;
      i1 = 3;
    }
  }
  
  public UpgradeDetailWrapper a()
  {
    return jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper;
  }
  
  public void a()
  {
    if ((jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper == null) || (jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail == null) || (jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeType != 1)) {}
    while (((jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo != null) && (jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.h == 1)) || (jdField_a_of_type_Boolean)) {
      return;
    }
    b(true);
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "onException:" + paramInt + ", " + paramString);
    }
    f();
  }
  
  public void a(Context paramContext)
  {
    int i2 = 1;
    if ((jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo == null) || (jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.a() != 4)) {
      return;
    }
    for (int i1 = i2;; i1 = 0)
    {
      try
      {
        if (jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo != null)
        {
          if (jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.h != 1) {
            continue;
          }
          i1 = i2;
        }
        a(5, i1);
        return;
      }
      catch (Exception paramContext) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("UpgradeController", 2, "installApk:", paramContext);
      return;
    }
  }
  
  public void a(UpgradeController.OnStateChangedListener paramOnStateChangedListener)
  {
    if (paramOnStateChangedListener == null) {
      return;
    }
    synchronized (jdField_a_of_type_JavaUtilArrayList)
    {
      if (!jdField_a_of_type_JavaUtilArrayList.contains(paramOnStateChangedListener)) {
        jdField_a_of_type_JavaUtilArrayList.add(paramOnStateChangedListener);
      }
      return;
    }
  }
  
  public void a(DownloadInfo paramDownloadInfo)
  {
    if (!"100686848".equals(b)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "onDownloadPause");
    }
    jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo = paramDownloadInfo;
    a(a());
  }
  
  public void a(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    if (!"100686848".equals(b)) {
      return;
    }
    jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo = paramDownloadInfo;
    jdField_a_of_type_Boolean = false;
    i();
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "onDownloadError: " + paramInt1 + ", " + paramString);
    }
    a(a());
    paramInt2 = paramInt1;
    if (NetworkUtil.h(jdField_a_of_type_AndroidAppApplication)) {
      paramInt2 = paramInt1 | 0x1;
    }
    paramDownloadInfo = new HashMap();
    paramDownloadInfo.put("param_FailCode", Integer.toString(paramInt2));
    paramDownloadInfo.put("param_ErrMsg", paramString);
    StatisticCollector.a(jdField_a_of_type_AndroidAppApplication).a("", "UpgradeErr", false, 0L, 0L, paramDownloadInfo, "", true);
  }
  
  public void a(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("UpgradeController", 4, "onCheckUpdateFailed");
    }
    g();
  }
  
  public void a(String paramString1, String paramString2) {}
  
  public void a(ArrayList paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramArrayList = (ApkUpdateDetail)paramArrayList.get(0);
      jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail = paramArrayList;
      if (QLog.isDevelopLevel()) {
        QLog.d("UpgradeController", 4, "onCheckUpdateSucceed:" + url + " -- " + updatemethod);
      }
    }
    g();
  }
  
  public void a(List paramList)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)paramList.next();
        if ("100686848".equals(b)) {
          jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo = localDownloadInfo;
        }
      }
    }
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 == 0) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("UpgradeController", 2, "onDownloadUpdate Status:" + jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.a());
      }
      a(a());
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper != null) && (jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo != null) && (jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeType == 2)) {
      return;
    }
    c();
    jdField_a_of_type_AndroidAppApplication = BaseApplicationImpl.a();
    jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo = null;
    jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper = new UpgradeDetailWrapper(null, null);
    jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(0);
    b = false;
    k();
  }
  
  boolean a()
  {
    return jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo != null;
  }
  
  public boolean a(UpgradeInfo paramUpgradeInfo, UpgradeController.OnHandleUpgradeFinishListener paramOnHandleUpgradeFinishListener)
  {
    jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ProtocolKQQConfigUpgradeInfo = paramUpgradeInfo;
    jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper$NewApkInfo = ConfigHandler.a(paramUpgradeInfo);
    if ((paramOnHandleUpgradeFinishListener == null) || (paramUpgradeInfo == null)) {}
    while (iUpgradeType == 0) {
      return false;
    }
    j();
    jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramOnHandleUpgradeFinishListener);
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "handleUpgradeInfo packageName = " + jdField_a_of_type_AndroidAppApplication.getPackageName() + ", bGray = " + bGray + ", versioncode = " + jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper$NewApkInfo.jdField_a_of_type_Int);
    }
    paramUpgradeInfo = new ApkUpdateParam(jdField_a_of_type_AndroidAppApplication.getPackageName(), bGray, jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper$NewApkInfo.jdField_a_of_type_Int);
    paramOnHandleUpgradeFinishListener = new ArrayList();
    paramOnHandleUpgradeFinishListener.add(paramUpgradeInfo);
    UpdateManager.a().b(paramOnHandleUpgradeFinishListener);
    return true;
  }
  
  public void b()
  {
    if ((jdField_a_of_type_Boolean) && (b())) {
      c();
    }
  }
  
  public void b(UpgradeController.OnStateChangedListener paramOnStateChangedListener)
  {
    if (paramOnStateChangedListener == null) {
      return;
    }
    synchronized (jdField_a_of_type_JavaUtilArrayList)
    {
      if (jdField_a_of_type_JavaUtilArrayList.contains(paramOnStateChangedListener)) {
        jdField_a_of_type_JavaUtilArrayList.remove(paramOnStateChangedListener);
      }
      return;
    }
  }
  
  public void b(DownloadInfo paramDownloadInfo)
  {
    if (!"100686848".equals(b)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "onDownloadWait");
    }
    jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo = paramDownloadInfo;
    a(a());
  }
  
  public void b(String paramString1, String paramString2) {}
  
  public void b(List paramList)
  {
    if ((paramList != null) && (paramList.size() > 0)) {
      jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo = ((DownloadInfo)paramList.get(0));
    }
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "onResult Status:" + jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo);
    }
    f();
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "startDownload:" + paramBoolean + ", " + jdField_a_of_type_Boolean);
    }
    if (a() == 4) {}
    while (jdField_a_of_type_Boolean) {
      return;
    }
    if (paramBoolean)
    {
      h();
      return;
    }
    c(false);
  }
  
  boolean b()
  {
    return jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeController$AutoDownloadInWifiController != null;
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 262	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +12 -> 17
    //   8: ldc 19
    //   10: iconst_2
    //   11: ldc_w 597
    //   14: invokestatic 267	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   17: aload_0
    //   18: getfield 303	com/tencent/mobileqq/app/upgrade/UpgradeController:jdField_a_of_type_Boolean	Z
    //   21: ifeq +21 -> 42
    //   24: aload_0
    //   25: iconst_0
    //   26: putfield 303	com/tencent/mobileqq/app/upgrade/UpgradeController:jdField_a_of_type_Boolean	Z
    //   29: aload_0
    //   30: invokevirtual 599	com/tencent/mobileqq/app/upgrade/UpgradeController:e	()V
    //   33: aload_0
    //   34: invokespecial 513	com/tencent/mobileqq/app/upgrade/UpgradeController:i	()V
    //   37: ldc 30
    //   39: invokestatic 601	com/tencent/open/downloadnew/DownloadApi:a	(Ljava/lang/String;)V
    //   42: aload_0
    //   43: monitorexit
    //   44: return
    //   45: astore_1
    //   46: goto -13 -> 33
    //   49: astore_1
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_1
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	UpgradeController
    //   45	1	1	localException	Exception
    //   49	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   29	33	45	java/lang/Exception
    //   2	17	49	finally
    //   17	29	49	finally
    //   29	33	49	finally
    //   33	42	49	finally
  }
  
  public void c(DownloadInfo paramDownloadInfo)
  {
    if (!"100686848".equals(b)) {}
    boolean bool;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("UpgradeController", 2, "onDownloadFinish");
      }
      jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo = paramDownloadInfo;
      jdField_a_of_type_Boolean = false;
      Object localObject = k;
      paramDownloadInfo = a(BaseApplicationImpl.a, (String)localObject);
      if (paramDownloadInfo != null) {}
      for (paramDownloadInfo = packageName; BaseApplicationImpl.a.getPackageName().equals(paramDownloadInfo); paramDownloadInfo = null)
      {
        a(a());
        d(true);
        i();
        return;
      }
      bool = jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.jdField_a_of_type_Boolean;
      if (!bool) {
        break;
      }
      DownloadApi.a("_100686848");
      String str = PluginStatic.encodeFile((String)localObject);
      i();
      localObject = new File((String)localObject);
      if (((File)localObject).exists()) {
        ((File)localObject).delete();
      }
      localObject = new HashMap();
      ((HashMap)localObject).put("param_FailCode", Integer.toString(9527));
      ((HashMap)localObject).put("param_ErrMsg", "MD5:" + str + "_PN:" + paramDownloadInfo);
      StatisticCollector.a(jdField_a_of_type_AndroidAppApplication).a("", "UpgradeErr", false, 0L, 0L, (HashMap)localObject, "", true);
    } while (bool);
    jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(0);
    return;
    jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.jdField_a_of_type_Boolean = false;
    if (!b()) {}
    for (int i1 = 1;; i1 = 0)
    {
      a(10, i1);
      break;
    }
  }
  
  public void c(String paramString1, String paramString2) {}
  
  void c(boolean paramBoolean)
  {
    int i2 = 1;
    if (!jdField_a_of_type_Boolean)
    {
      jdField_a_of_type_Boolean = true;
      if ((jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail == null) || (jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail.updatemethod != 4)) {
        break label55;
      }
    }
    label55:
    for (int i1 = 12;; i1 = 2)
    {
      if (paramBoolean) {
        i2 = 0;
      }
      a(i1, i2);
      return;
    }
  }
  
  public void d()
  {
    int i2 = 2;
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "resumeDownload:");
    }
    if (jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo == null) {
      return;
    }
    int i1 = i2;
    if (jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail != null)
    {
      i1 = i2;
      if (jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail.updatemethod == 4) {
        i1 = 12;
      }
    }
    if (!b()) {}
    for (i2 = 1;; i2 = 0)
    {
      a(i1, i2);
      return;
    }
  }
  
  public void d(DownloadInfo paramDownloadInfo)
  {
    if (!"100686848".equals(b)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "onDownloadCancel");
    }
    jdField_a_of_type_Boolean = false;
    i();
    jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo = paramDownloadInfo;
    a(a());
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "pauseDownload:");
    }
    if (!b()) {}
    for (int i1 = 1;; i1 = 0)
    {
      a(3, i1);
      return;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    try
    {
      Toast.makeText(BaseApplicationImpl.a, 2131362927, 0).show();
      return true;
    }
    catch (Throwable paramMessage)
    {
      for (;;) {}
    }
  }
}
