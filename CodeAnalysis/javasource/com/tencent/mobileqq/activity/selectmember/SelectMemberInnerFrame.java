package com.tencent.mobileqq.activity.selectmember;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import com.tencent.common.app.InnerFrame;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;

public abstract class SelectMemberInnerFrame
  extends InnerFrame
{
  public LayoutInflater a;
  public InnerFrameManager a;
  public SelectMemberActivity a;
  public QQAppInterface a;
  
  public SelectMemberInnerFrame(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public SelectMemberInnerFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public SelectMemberInnerFrame(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public abstract ContactSearchFragment a();
  
  public abstract String a();
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity = ((SelectMemberActivity)a());
    jdField_a_of_type_ComTencentCommonAppInnerFrameManager = a();
    jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = a();
    jdField_a_of_type_AndroidViewLayoutInflater = jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getLayoutInflater();
  }
  
  public abstract void f();
}
