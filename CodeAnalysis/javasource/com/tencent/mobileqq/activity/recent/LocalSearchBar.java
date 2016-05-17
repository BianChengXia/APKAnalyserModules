package com.tencent.mobileqq.activity.recent;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.EditText;
import com.tencent.biz.pubaccount.util.PADetailReportUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.activity.GroupSearchActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;

public class LocalSearchBar
  implements DialogInterface.OnDismissListener, View.OnClickListener, Animation.AnimationListener
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private View jdField_a_of_type_AndroidViewView;
  private OnRecentUserOpsListener jdField_a_of_type_ComTencentMobileqqActivityRecentOnRecentUserOpsListener;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private View jdField_b_of_type_AndroidViewView;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private View jdField_c_of_type_AndroidViewView;
  
  public LocalSearchBar(ListView paramListView, View paramView1, View paramView2, BaseActivity paramBaseActivity, View paramView3, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_Long = 0L;
    jdField_b_of_type_Long = 0L;
    jdField_c_of_type_Long = 0L;
    jdField_b_of_type_Int = 4;
    jdField_c_of_type_Int = 1;
    View localView = null;
    jdField_c_of_type_Int = paramInt;
    if (paramView3 != null) {
      localView = paramView3;
    }
    paramView3 = localView;
    if (localView == null) {
      paramView3 = paramBaseActivity.getLayoutInflater().inflate(2130904751, paramListView, false);
    }
    paramView3.findViewById(2131300492).setVisibility(8);
    paramListView.a(paramView3);
    IphoneTitleBarActivity.setLayerType(paramView3);
    jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    jdField_c_of_type_AndroidViewView = paramBaseActivity.findViewById(2131298365);
    jdField_a_of_type_AndroidViewView = paramView1;
    jdField_b_of_type_AndroidViewView = paramView2;
    paramListView = (EditText)paramView3.findViewById(2131300511);
    paramListView.setFocusableInTouchMode(false);
    paramListView.setCursorVisible(false);
    paramListView.setOnClickListener(this);
  }
  
  private void e()
  {
    jdField_c_of_type_Long = System.currentTimeMillis();
    GroupSearchActivity.a(jdField_a_of_type_ComTencentMobileqqAppBaseActivity, null, jdField_c_of_type_Int);
  }
  
  public void a()
  {
    PADetailReportUtil.a().a();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(QQAppInterface paramQQAppInterface) {}
  
  public boolean a()
  {
    return false;
  }
  
  public void b() {}
  
  public void c() {}
  
  public void d() {}
  
  public void onAnimationEnd(Animation paramAnimation) {}
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "onClick() time stamp = " + (l - jdField_a_of_type_Long));
    }
    if (l - jdField_a_of_type_Long > 1500L)
    {
      jdField_a_of_type_Long = l;
      FrameHelperActivity.d(false);
      e();
    }
  }
  
  public void onDismiss(DialogInterface paramDialogInterface) {}
}
