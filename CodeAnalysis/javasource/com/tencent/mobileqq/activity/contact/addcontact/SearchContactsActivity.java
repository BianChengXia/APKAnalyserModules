package com.tencent.mobileqq.activity.contact.addcontact;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Looper;
import android.os.MessageQueue;
import android.text.Editable;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebView;
import lqx;
import lqy;

public class SearchContactsActivity
  extends SearchBaseActivity
{
  private static final String e = "//gettbs";
  
  public SearchContactsActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private void a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals("//gettbs")))
    {
      String str4 = WebAccelerateHelper.a().a();
      String str2 = "";
      String str3 = "";
      String str1 = str3;
      paramString = str2;
      if (!TextUtils.isEmpty(str4))
      {
        str1 = str3;
        paramString = str2;
        if (str4.length() > 2)
        {
          paramString = String.valueOf(str4.charAt(0));
          str1 = String.valueOf(str4.charAt(2));
        }
      }
      paramString = String.format("tbs_download:%s\ntbs_enable:%s\ntbsCoreVersion:%d\ntbsSdkVersion:%d", new Object[] { paramString, str1, Integer.valueOf(QbSdk.getTbsVersion(this)), Integer.valueOf(WebView.getTbsSDKVersion(this)) });
      QQToast.a(getActivity().getApplicationContext(), paramString, 0).b(getTitleBarHeight());
    }
  }
  
  protected SearchBaseFragment a()
  {
    return SearchContactsFragment.a(i);
  }
  
  protected void a()
  {
    super.a();
    jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    String str = getIntent().getStringExtra("start_search_key");
    boolean bool = TextUtils.isEmpty(str);
    if (!bool)
    {
      if (i == 12)
      {
        jdField_a_of_type_AndroidWidgetEditText.setHint("搜索" + PublicAccountConfigUtil.a(app, getApplicationContext()) + "/文章");
        jdField_a_of_type_AndroidWidgetEditText.setText(str);
        jdField_a_of_type_AndroidWidgetEditText.setSelection(jdField_a_of_type_AndroidWidgetEditText.getText().length());
        jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
        jdField_a_of_type_AndroidWidgetButton.setText(getResources().getString(2131367944));
      }
    }
    else
    {
      jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new lqx(this, bool));
      if (AppSetting.i)
      {
        if (i != 12) {
          break label193;
        }
        jdField_a_of_type_AndroidWidgetEditText.setContentDescription("搜索栏、订阅号、文章、正在编辑");
      }
    }
    for (;;)
    {
      if (TextUtils.isEmpty(str)) {
        break label205;
      }
      return;
      jdField_a_of_type_AndroidWidgetEditText.setHint("搜索人/群/公众号/文章");
      break;
      label193:
      jdField_a_of_type_AndroidWidgetEditText.setContentDescription("搜索栏、QQ号、手机号、邮箱、群、公共号、正在编辑");
    }
    label205:
    Looper.myQueue().addIdleHandler(new lqy(this));
  }
  
  public void finish()
  {
    super.finish();
    if (!TextUtils.isEmpty(getIntent().getStringExtra("start_search_key"))) {
      return;
    }
    overridePendingTransition(0, 0);
  }
}
