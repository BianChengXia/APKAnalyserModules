package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class SharedPreUtils
{
  public static final String a = "SharedPreUtils_preference";
  
  public SharedPreUtils()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static int A(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "pstn_switch_wording_config_version", 0);
  }
  
  public static int a(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("huangye_version_code", 0);
  }
  
  public static int a(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("entry_config_verion_code_" + paramString, 0);
  }
  
  public static int a(Context paramContext, String paramString1, String paramString2)
  {
    return paramContext.getSharedPreferences(paramString1, 0).getInt(paramString2, 0);
  }
  
  public static long a(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getLong("last_time_pull_patch_reconnect", 0L);
  }
  
  public static SharedPreferences a(String paramString)
  {
    return BaseApplicationImpl.getContext().getSharedPreferences("lightalk_tips_sp_" + paramString, 0);
  }
  
  public static String a(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("last_loginuin_for_birthday_uin", "");
  }
  
  public static String a(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString(paramString + "_" + "keyboard_last_phone", "");
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("huangye_version_code", paramInt);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString1, String paramString2, String paramString3)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("dynamic_splash_config_version", paramInt1);
    paramContext.putInt("dynamic_splash_config_play_times", paramInt2);
    paramContext.putInt("dynamic_splash_config_play_internal", paramInt3);
    paramContext.putInt("dynamic_splash_config_show_times", paramInt4);
    paramContext.putString("dynamic_splash_config_md5", paramString1);
    paramContext.putString("dynamic_splash_config_effective_time", paramString2);
    paramContext.putString("dynamic_splash_config_zip_url", paramString3);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("entry_config_verion_code_" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, int paramInt, String paramString1, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("splash_version_code", paramInt);
    paramContext.putString("splash_effectivetime", paramString1);
    paramContext.putString("splash_md5value", paramString2);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, int paramInt, boolean paramBoolean)
  {
    int i = 1;
    int k = 1;
    int j = 0;
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    if (!paramBoolean)
    {
      j = paramContext.getInt("hotchat_scene_config_fcount", 0) + 1;
      if (j <= 5) {
        break label79;
      }
    }
    label79:
    for (i = k;; i = 0)
    {
      paramContext = paramContext.edit();
      if (i != 0) {
        paramContext.putInt("hotchat_scene_config_version", paramInt);
      }
      paramContext.putInt("hotchat_scene_config_fcount", j);
      paramContext.commit();
      return;
    }
  }
  
  public static void a(Context paramContext, long paramLong)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putLong("last_time_pull_patch_reconnect", paramLong);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString("last_loginuin_for_birthday_uin", paramString);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("keyword_and_remark_version_code" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString1, int paramInt, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.length() == 0) || (paramContext == null)) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 11) {}
    for (paramContext = paramContext.getSharedPreferences("SharedPreUtils_preference" + paramString1, 4).edit();; paramContext = paramContext.getSharedPreferences("SharedPreUtils_preference" + paramString1, 0).edit())
    {
      paramContext.putInt(paramString2, paramInt);
      paramContext.commit();
      return;
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (paramContext == null) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    paramContext = paramContext.getSharedPreferences("LabaSetting_" + paramString2, 0).edit();
    paramContext.putInt(paramString1, 1);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString, boolean paramBoolean)
  {
    if ((paramString == null) || (paramString.length() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SharedPreUtils", 2, "CNR setAutoLoginSharePre uin is null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SharedPreUtils", 2, "CNR setAutoLoginSharePre auto =" + paramBoolean);
    }
    String str = paramContext.getPackageName() + "_preferences";
    if (Build.VERSION.SDK_INT > 10) {}
    for (int i = 4;; i = 0)
    {
      paramContext = paramContext.getSharedPreferences(str, i);
      paramContext.edit().putBoolean("login_auto" + paramString, paramBoolean);
      paramBoolean = paramContext.edit().commit();
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("SharedPreUtils", 2, "CNR setAutoLoginSharePre isOK =" + paramBoolean);
      return;
    }
  }
  
  public static void a(Context paramContext, ArrayList paramArrayList, String paramString)
  {
    if ((paramArrayList == null) || (paramContext == null)) {
      return;
    }
    paramContext = paramContext.getSharedPreferences("LabaSetting_" + paramString, 0).edit();
    paramContext.clear();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      paramContext.putInt((String)paramArrayList.next(), 1);
    }
    paramContext.commit();
  }
  
  public static boolean a(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean("readinjoy_folder_setting_btn", false);
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    int i = 0;
    boolean bool2 = false;
    boolean bool1;
    if ((paramString == null) || (paramString.length() == 0))
    {
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("SharedPreUtils", 2, "CNR getAutoLoginSharePre uin is null");
        bool1 = bool2;
      }
    }
    do
    {
      return bool1;
      String str = paramContext.getPackageName() + "_preferences";
      if (Build.VERSION.SDK_INT > 10) {
        i = 4;
      }
      bool2 = paramContext.getSharedPreferences(str, i).getBoolean("login_auto" + paramString, true);
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("SharedPreUtils", 2, "CNR getAutoLoginSharePre auto =" + bool2);
    return bool2;
  }
  
  public static boolean a(Context paramContext, String paramString1, int paramInt, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.length() == 0) || (paramContext == null)) {
      return false;
    }
    if (Build.VERSION.SDK_INT >= 11) {}
    for (paramContext = paramContext.getSharedPreferences("SharedPreUtils_preference" + paramString1, 4); paramInt > paramContext.getInt(paramString2, 0); paramContext = paramContext.getSharedPreferences("SharedPreUtils_preference" + paramString1, 0)) {
      return true;
    }
    return false;
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2)
  {
    boolean bool = true;
    if ((TextUtils.isEmpty(paramString1)) || (paramContext == null)) {
      bool = false;
    }
    while (paramContext.getSharedPreferences("LabaSetting_" + paramString2, 0).getInt(paramString1, 0) == 1) {
      return bool;
    }
    return false;
  }
  
  public static int b(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("officecenter_version_code", 0);
  }
  
  public static int b(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("group_video_version_code_" + paramString, 0);
  }
  
  public static SharedPreferences b(String paramString)
  {
    return BaseApplicationImpl.getContext().getSharedPreferences("lightalk_pstn_number_sp_" + paramString, 0);
  }
  
  public static String b(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("birthday_user", "");
  }
  
  public static void b(Context paramContext, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("officecenter_version_code", paramInt);
    paramContext.commit();
  }
  
  public static void b(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("group_video_version_code_" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static void b(Context paramContext, int paramInt, String paramString1, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString2 + "_" + "birthday_splash_version_code", paramInt);
    paramContext.putString("birthday_splash_md5value", paramString1);
    paramContext.commit();
  }
  
  public static void b(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString("birthday_user", paramString);
    paramContext.commit();
  }
  
  public static void b(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("send_bless_version_code" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static void b(Context paramContext, String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (paramContext == null)) {
      return;
    }
    paramContext.getSharedPreferences("LabaSetting_" + paramString2, 0).edit().remove(paramString1).commit();
  }
  
  public static void b(Context paramContext, String paramString, boolean paramBoolean)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return;
    }
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean("acount_first_login_app" + paramString, paramBoolean);
    paramContext.commit();
  }
  
  public static boolean b(Context paramContext, String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return false;
    }
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean("acount_first_login_app" + paramString, true);
  }
  
  public static int c(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("eqq_config_version_code", 0);
  }
  
  public static int c(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("qvip_res_version_code_" + paramString, 0);
  }
  
  public static SharedPreferences c(String paramString)
  {
    return BaseApplicationImpl.getContext().getSharedPreferences("aio_jump_lightalk_red_dot" + paramString, 0);
  }
  
  public static String c(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("splash_md5value", "");
  }
  
  public static void c(Context paramContext, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("eqq_config_version_code", paramInt);
    paramContext.commit();
  }
  
  public static void c(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("qvip_res_version_code_" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static void c(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString("eqq-config-data", paramString);
    paramContext.commit();
  }
  
  public static void c(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "flower_rank_color_config_version", paramInt);
    paramContext.commit();
  }
  
  public static void c(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString(paramString1 + "_" + "keyboard_last_phone", paramString2);
    paramContext.commit();
  }
  
  public static void c(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean(paramString + "_" + "enter_lightalk_vip", paramBoolean);
    paramContext.commit();
  }
  
  public static boolean c(Context paramContext, String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return false;
    }
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean("translate_bubble_first_time", true);
  }
  
  public static int d(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("splash_version_code", 0);
  }
  
  public static int d(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "hotchat_classify_version_code", 0);
  }
  
  public static SharedPreferences d(String paramString)
  {
    return BaseApplicationImpl.getContext().getSharedPreferences("qav_upgrade_invite" + paramString, 0);
  }
  
  public static String d(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("eqq-config-data", null);
  }
  
  public static void d(Context paramContext, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("nearby_chat_gray_tips_config_version", paramInt);
    paramContext.commit();
  }
  
  public static void d(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "hotchat_classify_version_code", paramInt);
    paramContext.commit();
  }
  
  public static void d(Context paramContext, String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return;
    }
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean("translate_bubble_first_time", false);
    paramContext.commit();
  }
  
  public static void d(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "nearby_flower_gray_tips_config_version", paramInt);
    paramContext.commit();
  }
  
  public static void d(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString("readinjoy_folder_nickname", paramString1);
    paramContext.putString("readinjoy_folder_icon_url", paramString2);
    paramContext.commit();
  }
  
  public static void d(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString("readinjoy_folder_setting_url", paramString);
    paramContext.putBoolean("readinjoy_folder_setting_btn", paramBoolean);
    paramContext.commit();
  }
  
  public static boolean d(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean(paramString + "_" + "enter_lightalk_vip", false);
  }
  
  public static int e(Context paramContext)
  {
    int i = 0;
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
      if (paramContext != null) {
        i = versionCode;
      }
      return i;
    }
    catch (Exception paramContext) {}
    return 0;
  }
  
  public static int e(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "qfind_pidlist_version_code", 0);
  }
  
  public static String e(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("splash_effectivetime", "");
  }
  
  public static void e(Context paramContext, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("public_account_config_version", paramInt);
    paramContext.commit();
  }
  
  public static void e(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "qfind_pidlist_version_code", paramInt);
    paramContext.commit();
  }
  
  public static void e(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString("public_account_config_data", paramString);
    paramContext.commit();
  }
  
  public static void e(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "search_config_version", paramInt);
    paramContext.commit();
  }
  
  public static int f(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("nearby_chat_gray_tips_config_version", 0);
  }
  
  public static int f(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "", 0);
  }
  
  public static String f(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("public_account_config_data", null);
  }
  
  public static void f(Context paramContext, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("patch_config_version", paramInt);
    paramContext.commit();
  }
  
  public static void f(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "", paramInt);
    paramContext.commit();
  }
  
  public static void f(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "search_config_appid", paramInt);
    paramContext.commit();
  }
  
  public static int g(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("public_account_config_version", 0);
  }
  
  public static int g(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "pushbanner_ad_version_code", 0);
  }
  
  public static String g(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("readinjoy_folder_nickname", "");
  }
  
  public static void g(Context paramContext, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("hotchat_activity_config_data", paramInt);
    paramContext.commit();
  }
  
  public static void g(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "pushbanner_ad_version_code", paramInt);
    paramContext.commit();
  }
  
  public static void g(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "pa_subcribe_config_version", paramInt);
    paramContext.commit();
  }
  
  public static int h(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("patch_config_version", 0);
  }
  
  public static int h(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "birthday_splash_version_code", 0);
  }
  
  public static String h(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("readinjoy_folder_icon_url", "");
  }
  
  public static void h(Context paramContext, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("camera_compatible_list_version", paramInt);
    paramContext.commit();
  }
  
  public static void h(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("general_configs_version_code_" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static void h(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "subscript_recommend_config_version", paramInt);
    paramContext.commit();
  }
  
  public static int i(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("hotchat_scene_config_version", 0);
  }
  
  public static int i(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("keyword_and_remark_version_code" + paramString, 0);
  }
  
  public static String i(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("readinjoy_folder_setting_url", "");
  }
  
  public static void i(Context paramContext, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("dynamic_splash_config_version", paramInt);
    paramContext.commit();
  }
  
  public static void i(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("general_android_configs_version_code_" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static void i(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "readinjoy_local_channel_config_version", paramInt);
    paramContext.commit();
  }
  
  public static int j(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("hotchat_activity_config_data", 0);
  }
  
  public static int j(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("send_bless_version_code" + paramString, 0);
  }
  
  public static void j(Context paramContext, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("shortvideo_progressive_blacklist_version", paramInt);
    paramContext.commit();
  }
  
  public static void j(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("general_lbs_configs_version_code_" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static void j(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "qwallet_setting_version", paramInt);
    paramContext.commit();
  }
  
  public static int k(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("camera_compatible_list_version", 0);
  }
  
  public static int k(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("general_configs_version_code_" + paramString, 0);
  }
  
  public static void k(Context paramContext, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("qqhotspot_config_version", paramInt);
    paramContext.commit();
  }
  
  public static void k(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "lightalk_config_version", paramInt);
    paramContext.commit();
  }
  
  public static void k(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "passwd_red_bag_setting_version", paramInt);
    paramContext.commit();
  }
  
  public static int l(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("dynamic_splash_config_version", 0);
  }
  
  public static int l(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("general_android_configs_version_code_" + paramString, 0);
  }
  
  public static void l(Context paramContext, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("readinjoy_folder_config_version", paramInt);
    paramContext.commit();
  }
  
  public static void l(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "jump_lightalk_config_version", paramInt);
    paramContext.commit();
  }
  
  public static void l(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "pstn_switch_wording_config_version", paramInt);
    paramContext.commit();
  }
  
  public static int m(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("shortvideo_progressive_blacklist_version", 0);
  }
  
  public static int m(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("general_lbs_configs_version_code_" + paramString, 0);
  }
  
  public static void m(Context paramContext, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("readinjoy_folder_setting_config_version", paramInt);
    paramContext.commit();
  }
  
  public static void m(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "qav_upgrade_invite_config_version", paramInt);
    paramContext.commit();
  }
  
  public static int n(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("qqhotspot_config_version", 0);
  }
  
  public static int n(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "lightalk_config_version", 0);
  }
  
  public static void n(Context paramContext, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("readinjoy_folder_config_id", paramInt);
    paramContext.commit();
  }
  
  public static void n(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "troop_contacts_mode_config_version", paramInt);
    paramContext.commit();
  }
  
  public static int o(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("readinjoy_folder_config_version", 0);
  }
  
  public static int o(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "jump_lightalk_config_version", 0);
  }
  
  public static int p(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("readinjoy_folder_setting_config_version", 0);
  }
  
  public static int p(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "qav_upgrade_invite_config_version", 0);
  }
  
  public static int q(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("readinjoy_folder_config_id", 0);
  }
  
  public static int q(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "flower_rank_color_config_version", 0);
  }
  
  public static int r(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "nearby_flower_gray_tips_config_version", 0);
  }
  
  public static int s(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "troop_contacts_mode_config_version", 0);
  }
  
  public static int t(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "search_config_version", 0);
  }
  
  public static int u(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "search_config_appid", 0);
  }
  
  public static int v(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "pa_subcribe_config_version", 0);
  }
  
  public static int w(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "subscript_recommend_config_version", 0);
  }
  
  public static int x(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "readinjoy_local_channel_config_version", 0);
  }
  
  public static int y(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "qwallet_setting_version", 0);
  }
  
  public static int z(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "passwd_red_bag_setting_version", 0);
  }
}
