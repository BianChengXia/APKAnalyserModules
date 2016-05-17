package com.tencent.mobileqq.activity.contact.addcontact;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.activity.GroupSearchActivity;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class ViewFactory
{
  public static final int a = 5;
  private static ViewFactory jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory;
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static final int[] jdField_a_of_type_ArrayOfInt = { 80000000, 80000001, 80000002, 80000003 };
  public static final int b = 80000000;
  private static final int[] b = { 80000001, 80000000, 80000002, 80000003 };
  public static final int c = 80000001;
  private static final int[] c = { 80000002, 80000000, 80000001, 80000003 };
  public static final int d = 80000002;
  public static final int e = 80000003;
  public static final int f = 80000004;
  public static final int g = 80000005;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap(5);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private ViewFactory() {}
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 2131369375;
    case 80000000: 
      return 2131368326;
    case 80000001: 
      return 2131369376;
    case 80000002: 
      if (GroupSearchActivity.e == 12) {
        return 2131369396;
      }
      return 2131369395;
    }
    return 2131369378;
  }
  
  private View a(Context paramContext)
  {
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
    localLinearLayout.setOrientation(1);
    TextView localTextView = new TextView(paramContext);
    localTextView.setText("没有找到相关结果");
    localTextView.setTextSize(0, paramContext.getResources().getDimension(2131492922));
    localTextView.setPadding(0, paramContext.getResources().getDimensionPixelSize(2131493425), 0, 0);
    localTextView.setTextColor(paramContext.getResources().getColor(2131428213));
    paramContext = new LinearLayout.LayoutParams(-2, -2);
    gravity = 1;
    localLinearLayout.addView(localTextView, paramContext);
    localLinearLayout.setContentDescription("没有找到相关结果");
    return localLinearLayout;
  }
  
  public static ViewFactory a()
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory == null) {
        jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory = new ViewFactory();
      }
      return jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory;
    }
  }
  
  public static int[] a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return jdField_a_of_type_ArrayOfInt;
    case 80000000: 
      return jdField_a_of_type_ArrayOfInt;
    case 80000001: 
      return b;
    case 80000002: 
      return c;
    }
    return jdField_a_of_type_ArrayOfInt;
  }
  
  private View b(Context paramContext)
  {
    return new ViewFactory.GuideView(paramContext);
  }
  
  public View a(int paramInt, Context paramContext, boolean paramBoolean)
  {
    int j = 0;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    int i = j;
    if (paramBoolean)
    {
      localObject1 = localObject2;
      i = j;
      if (jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt)) != null)
      {
        localObject1 = (View)((WeakReference)jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt))).get();
        i = 1;
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      switch (paramInt)
      {
      default: 
        localObject2 = localObject1;
      }
    }
    for (;;)
    {
      if ((paramBoolean) && (i == 0)) {
        jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), new WeakReference(localObject2));
      }
      return localObject2;
      localObject2 = b(paramContext);
      continue;
      localObject2 = a(paramContext);
    }
  }
  
  public void a()
  {
    jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory = null;
    jdField_a_of_type_JavaUtilHashMap.clear();
    jdField_a_of_type_JavaUtilHashMap = null;
  }
}
