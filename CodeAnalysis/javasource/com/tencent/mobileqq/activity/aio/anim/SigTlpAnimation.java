package com.tencent.mobileqq.activity.aio.anim;

import android.graphics.Rect;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.item.RichStatItemBuilder.Holder;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.BubbleInfo.CommonAttrs;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richstatus.StatusHistoryActivity.ItemViewHolder;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.SignatureTemplateInfo.DynamicItem;
import com.tencent.mobileqq.widget.MutilayoutSlideDetectListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import com.tencent.widget.MaxHeightRelativelayout;
import java.io.File;
import java.util.ArrayList;
import ksd;
import kse;
import mqq.os.MqqHandler;

public class SigTlpAnimation
  extends XBubbleAnimation
{
  public static final String a;
  public static final int b = 0;
  protected static Rect b;
  protected Rect a;
  public View a;
  private RichStatItemBuilder.Holder jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder$Holder;
  public BubbleInfo.CommonAttrs a;
  private StatusHistoryActivity.ItemViewHolder jdField_a_of_type_ComTencentMobileqqRichstatusStatusHistoryActivity$ItemViewHolder;
  public SignatureTemplateInfo.DynamicItem a;
  protected boolean a;
  public String[] a;
  public String b;
  private String d;
  private int e;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = SigTlpAnimation.class.getSimpleName();
    jdField_b_of_type_AndroidGraphicsRect = new Rect();
  }
  
  public SigTlpAnimation(int paramInt, AIOAnimationConatiner paramAIOAnimationConatiner, ListView paramListView)
  {
    super(paramInt, paramAIOAnimationConatiner, paramListView);
    jdField_a_of_type_Boolean = false;
    jdField_a_of_type_AndroidGraphicsRect = new Rect();
    jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable = new VipPngPlayAnimationDrawable(paramListView.getResources());
    jdField_b_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable = null;
    jdField_a_of_type_AndroidOsHandler = new Handler();
  }
  
  private boolean a(boolean paramBoolean)
  {
    if (jdField_b_of_type_AndroidViewView == null) {
      return false;
    }
    if (b())
    {
      if (paramBoolean) {
        jdField_b_of_type_AndroidViewView.setBackgroundDrawable(jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable);
      }
      ViewGroup.LayoutParams localLayoutParams1 = new ViewGroup.LayoutParams(-2, -2);
      height = (jdField_a_of_type_AndroidGraphicsRect.bottom - jdField_a_of_type_AndroidGraphicsRect.top);
      width = (jdField_a_of_type_AndroidGraphicsRect.right - jdField_a_of_type_AndroidGraphicsRect.left);
      jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.addViewInLayout(jdField_b_of_type_AndroidViewView, -1, localLayoutParams1, false);
      if ((jdField_a_of_type_Boolean) && (jdField_a_of_type_AndroidViewView != null))
      {
        ViewGroup.LayoutParams localLayoutParams2 = new ViewGroup.LayoutParams(-2, -2);
        height = (jdField_a_of_type_AndroidViewView.getBottom() - jdField_a_of_type_AndroidViewView.getTop());
        width = (jdField_a_of_type_AndroidViewView.getRight() - jdField_a_of_type_AndroidViewView.getLeft());
        Object localObject = (View)jdField_a_of_type_AndroidViewView.getParent();
        if (((jdField_a_of_type_AndroidViewView instanceof TextView)) && (localObject != null) && ((localObject instanceof RelativeLayout)))
        {
          localObject = (RelativeLayout)jdField_a_of_type_AndroidViewView.getParent();
          Rect localRect = jdField_b_of_type_AndroidGraphicsRect;
          int i = jdField_a_of_type_AndroidViewView.getLeft();
          int j = ((RelativeLayout)localObject).getLeft();
          left = (((View)((RelativeLayout)localObject).getParent()).getLeft() + (j + i));
          ((RelativeLayout)localObject).removeView(jdField_a_of_type_AndroidViewView);
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "paramButton.width=" + width + ",paramButton.height=" + height);
        }
        jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.addViewInLayout(jdField_a_of_type_AndroidViewView, 1, localLayoutParams2, false);
        jdField_a_of_type_AndroidViewView.layout(0, 0, width, height);
      }
      jdField_b_of_type_AndroidViewView.layout(0, 0, width, height);
      return a();
    }
    return false;
  }
  
  public int a(View paramView, boolean paramBoolean)
  {
    View localView = (View)paramView.getParent();
    int i = paramView.getTop();
    if (localView == null) {
      return i;
    }
    if (paramBoolean)
    {
      do
      {
        if ((localView instanceof ChatXListView)) {
          break;
        }
        j = localView.getTop() + i;
        paramView = (View)localView.getParent();
        localView = paramView;
        i = j;
      } while (paramView != null);
      return j;
    }
    paramView = localView;
    int j = i;
    if (jdField_a_of_type_AndroidViewView == null)
    {
      j = i;
      do
      {
        i = j;
        if ((localView instanceof MutilayoutSlideDetectListView)) {
          break;
        }
        i = j + localView.getTop();
        paramView = (View)localView.getParent();
        localView = paramView;
        j = i;
      } while (paramView != null);
      return i;
    }
    do
    {
      i = j;
      if ((paramView instanceof MaxHeightRelativelayout)) {
        break;
      }
      i = j + paramView.getTop();
      localView = (View)paramView.getParent();
      paramView = localView;
      j = i;
    } while (localView != null);
    return i;
    return i;
  }
  
  public void a()
  {
    jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.a(true);
  }
  
  protected void a(int paramInt)
  {
    jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.offsetChildrenTopAndBottom(paramInt);
  }
  
  public void a(boolean paramBoolean)
  {
    c();
    if (jdField_b_of_type_AndroidViewView != null)
    {
      jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.removeViewInLayout(jdField_b_of_type_AndroidViewView);
      jdField_b_of_type_AndroidViewView = null;
    }
    if ((paramBoolean) && ((jdField_a_of_type_AndroidViewView == null) || (jdField_a_of_type_Boolean)))
    {
      jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.removeAllViews();
      jdField_a_of_type_AndroidViewView = null;
    }
    jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.invalidate();
  }
  
  protected boolean a()
  {
    if (jdField_b_of_type_AndroidViewView != null)
    {
      jdField_b_of_type_AndroidViewView.offsetLeftAndRight(jdField_a_of_type_AndroidGraphicsRect.left);
      jdField_b_of_type_AndroidViewView.offsetTopAndBottom(jdField_a_of_type_AndroidGraphicsRect.top);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "rect.left=" + jdField_a_of_type_AndroidGraphicsRect.left + ",rect.top=" + jdField_a_of_type_AndroidGraphicsRect.top);
      }
      if ((jdField_a_of_type_Boolean) && (jdField_a_of_type_AndroidViewView != null))
      {
        jdField_a_of_type_AndroidViewView.offsetLeftAndRight(jdField_b_of_type_AndroidGraphicsRectleft);
        jdField_a_of_type_AndroidViewView.offsetTopAndBottom(jdField_b_of_type_AndroidGraphicsRecttop);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "rectAio.left=" + jdField_b_of_type_AndroidGraphicsRectleft + ",rectAio.top=" + jdField_b_of_type_AndroidGraphicsRecttop);
        }
      }
    }
    for (;;)
    {
      return true;
      if (jdField_a_of_type_Boolean) {
        jdField_a_of_type_AndroidOsHandler.post(new ksd(this));
      }
    }
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = true;
    Object localObject = new File(paramString);
    boolean bool1;
    if ((localObject == null) || (!((File)localObject).exists()) || (!((File)localObject).isDirectory())) {
      bool1 = false;
    }
    do
    {
      return bool1;
      bool1 = bool2;
    } while (jdField_a_of_type_ArrayOfJavaLangString != null);
    localObject = FileUtils.a(paramString);
    if (((ArrayList)localObject).size() <= 0) {
      return false;
    }
    jdField_a_of_type_ArrayOfJavaLangString = new String[((ArrayList)localObject).size()];
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString).append(File.separator).append("%d.png");
    paramString = ((StringBuilder)localObject).toString();
    int j = jdField_a_of_type_ArrayOfJavaLangString.length;
    int i = 0;
    for (;;)
    {
      bool1 = bool2;
      if (i >= j) {
        break;
      }
      jdField_a_of_type_ArrayOfJavaLangString[i] = String.format(paramString, new Object[] { Integer.valueOf(i + 1) });
      i += 1;
    }
  }
  
  protected boolean a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "layout changed=" + paramBoolean + ",left=" + paramInt1 + ",top=" + paramInt2 + ",right=" + paramInt3 + ",bottom=" + paramInt4);
    }
    if ((jdField_a_of_type_Boolean) && (jdField_b_of_type_AndroidViewView != null))
    {
      jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.removeAllViews();
      a(false);
    }
    return false;
  }
  
  protected boolean a(Object... paramVarArgs)
  {
    if (paramVarArgs.length != 7) {
      return false;
    }
    jdField_a_of_type_AndroidViewView = null;
    String str1 = String.valueOf(paramVarArgs[1]);
    jdField_b_of_type_JavaLangString = String.valueOf(paramVarArgs[2]);
    String str2 = (String)paramVarArgs[3];
    jdField_a_of_type_Boolean = ((Boolean)paramVarArgs[4]).booleanValue();
    if (paramVarArgs[5] != null) {
      jdField_a_of_type_AndroidViewView = ((View)paramVarArgs[5]);
    }
    jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem = ((SignatureTemplateInfo.DynamicItem)paramVarArgs[6]);
    ThreadManager.a().post(new kse(this, str1, str2));
    return true;
  }
  
  protected void b()
  {
    jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.a(false);
  }
  
  public boolean b()
  {
    int j = 0;
    Object localObject;
    int i;
    int k;
    int m;
    if (jdField_a_of_type_Boolean)
    {
      jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder$Holder = null;
      e = AIOUtils.a(Long.valueOf(d).longValue(), jdField_a_of_type_ComTencentWidgetListView.a());
      localObject = AIOUtils.a(AIOUtils.a(jdField_a_of_type_ComTencentWidgetListView, e));
      if ((localObject != null) && ((localObject instanceof RichStatItemBuilder.Holder))) {
        jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder$Holder = ((RichStatItemBuilder.Holder)localObject);
      }
      while (jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder$Holder == null)
      {
        a(true);
        return false;
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "list view item's tag can not cast to Holder, object:" + localObject + ",mPosition:" + e);
        }
      }
      if ((jdField_b_of_type_AndroidViewView == null) || (jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder$Holder.jdField_a_of_type_AndroidWidgetImageView == null) || (jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder$Holder.jdField_a_of_type_AndroidViewViewGroup == null)) {
        break label747;
      }
      int n = jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder$Holder.jdField_a_of_type_AndroidWidgetImageView.getLeft() + jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder$Holder.jdField_a_of_type_AndroidViewViewGroup.getLeft();
      int i1 = a(jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder$Holder.jdField_a_of_type_AndroidWidgetImageView, true) - jdField_a_of_type_ComTencentWidgetListView.getScrollY();
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "getParentTop(mHolder.signCardBg, true):" + a(jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder$Holder.jdField_a_of_type_AndroidWidgetImageView, true) + ",istview.getScrollY():" + jdField_a_of_type_ComTencentWidgetListView.getScrollY());
      }
      int i2 = jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder$Holder.jdField_a_of_type_AndroidWidgetImageView.getRight() - jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder$Holder.jdField_a_of_type_AndroidWidgetImageView.getLeft();
      int i3 = jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder$Holder.jdField_a_of_type_AndroidWidgetImageView.getBottom() - jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder$Holder.jdField_a_of_type_AndroidWidgetImageView.getTop();
      i = i3;
      j = i2;
      k = i1;
      m = n;
      if (jdField_a_of_type_AndroidViewView != null)
      {
        jdField_b_of_type_AndroidGraphicsRecttop = a(jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder$Holder.c, true);
        m = n;
        k = i1;
        j = i2;
        i = i3;
      }
    }
    for (;;)
    {
      label371:
      m += (int)(jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem.a * j);
      k += (int)(jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem.b * i);
      localObject = jdField_a_of_type_AndroidGraphicsRect;
      float f = jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem.c;
      j = (int)(j * f);
      f = jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem.d;
      ((Rect)localObject).set(m, k, j + m, (int)(i * f) + k);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "bindView top=" + k + ",left=" + m);
      }
      return true;
      if (jdField_a_of_type_AndroidViewView == null)
      {
        jdField_a_of_type_ComTencentMobileqqRichstatusStatusHistoryActivity$ItemViewHolder = null;
        e = SignatureManager.a(d, jdField_a_of_type_ComTencentWidgetListView.a());
        localObject = AIOUtils.a(AIOUtils.a(jdField_a_of_type_ComTencentWidgetListView, e));
        if ((localObject != null) && ((localObject instanceof StatusHistoryActivity.ItemViewHolder)))
        {
          jdField_a_of_type_ComTencentMobileqqRichstatusStatusHistoryActivity$ItemViewHolder = ((StatusHistoryActivity.ItemViewHolder)localObject);
          label567:
          if (jdField_a_of_type_ComTencentMobileqqRichstatusStatusHistoryActivity$ItemViewHolder == null) {
            break label669;
          }
          if (jdField_b_of_type_AndroidViewView == null) {
            break label740;
          }
          j = jdField_a_of_type_ComTencentMobileqqRichstatusStatusHistoryActivity$ItemViewHolder.a.getRight() - jdField_a_of_type_ComTencentMobileqqRichstatusStatusHistoryActivity$ItemViewHolder.a.getLeft();
          i = jdField_a_of_type_ComTencentMobileqqRichstatusStatusHistoryActivity$ItemViewHolder.a.getBottom() - jdField_a_of_type_ComTencentMobileqqRichstatusStatusHistoryActivity$ItemViewHolder.a.getTop();
        }
      }
      for (;;)
      {
        m = 0;
        k = 0;
        break label371;
        if (!QLog.isColorLevel()) {
          break label567;
        }
        QLog.e(jdField_a_of_type_JavaLangString, 2, "list view item's tag can not cast to ItemViewHolder, object:" + localObject);
        break label567;
        label669:
        break;
        m = ((View)jdField_a_of_type_AndroidViewView.getParent()).getLeft();
        k = a(jdField_a_of_type_AndroidViewView, false) - jdField_a_of_type_ComTencentWidgetListView.getScrollY();
        j = jdField_a_of_type_AndroidViewView.getRight() - jdField_a_of_type_AndroidViewView.getLeft();
        i = jdField_a_of_type_AndroidViewView.getBottom() - jdField_a_of_type_AndroidViewView.getTop();
        break label371;
        label740:
        i = 0;
        j = 0;
      }
      label747:
      i = 0;
      k = 0;
      m = 0;
    }
  }
  
  protected void c()
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable != null) {
      jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.a();
    }
  }
  
  public void d()
  {
    a(false);
  }
}
