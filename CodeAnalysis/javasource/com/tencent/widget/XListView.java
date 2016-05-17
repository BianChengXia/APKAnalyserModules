package com.tencent.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class XListView
  extends ListView
{
  public static final int aO = 1;
  public static final int aP = 2;
  private int jdField_a_of_type_Int = 0;
  private OnSizeChangeListener jdField_a_of_type_ComTencentWidgetOnSizeChangeListener;
  private XListView.DrawFinishedListener jdField_a_of_type_ComTencentWidgetXListView$DrawFinishedListener;
  private XListView.MotionEventInterceptor jdField_a_of_type_ComTencentWidgetXListView$MotionEventInterceptor;
  private int b = -1;
  
  public XListView(Context paramContext)
  {
    this(paramContext, null);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public XListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842868);
  }
  
  public XListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setEdgeEffectEnabled(false);
    a_ = Integer.MAX_VALUE;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.aH);
    setMaxHeight(paramContext.getDimensionPixelSize(0, -1));
    paramContext.recycle();
  }
  
  private int a()
  {
    if (getContextgetResourcesgetDisplayMetricswidthPixels > getContextgetResourcesgetDisplayMetricsheightPixels) {
      return 1;
    }
    return 2;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, int paramInt5)
  {
    if (jdField_a_of_type_ComTencentWidgetOnSizeChangeListener != null) {
      jdField_a_of_type_ComTencentWidgetOnSizeChangeListener.a(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean, paramInt5);
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool3 = false;
    boolean bool1;
    if (jdField_a_of_type_ComTencentWidgetXListView$MotionEventInterceptor != null)
    {
      MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
      if (localMotionEvent != null)
      {
        bool1 = jdField_a_of_type_ComTencentWidgetXListView$MotionEventInterceptor.a(this, localMotionEvent);
        localMotionEvent.recycle();
      }
    }
    for (;;)
    {
      if (!bool1) {
        try
        {
          bool2 = super.dispatchTouchEvent(paramMotionEvent);
          if (!bool1)
          {
            bool1 = bool3;
            if (!bool2) {}
          }
          else
          {
            bool1 = true;
          }
          return bool1;
        }
        catch (IllegalArgumentException paramMotionEvent)
        {
          for (;;)
          {
            paramMotionEvent.printStackTrace();
            boolean bool2 = false;
          }
        }
      }
      return true;
      bool1 = false;
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if (jdField_a_of_type_ComTencentWidgetXListView$DrawFinishedListener != null) {
      jdField_a_of_type_ComTencentWidgetXListView$DrawFinishedListener.a();
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (b > 0)
    {
      int j = View.MeasureSpec.getMode(paramInt2);
      i = paramInt2;
      if (View.MeasureSpec.getSize(paramInt2) > b)
      {
        i = paramInt2;
        if (j != 0) {
          i = View.MeasureSpec.makeMeasureSpec(b, j);
        }
      }
    }
    super.onMeasure(paramInt1, i);
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    int i = a();
    if (jdField_a_of_type_Int != i) {}
    for (boolean bool = true;; bool = false)
    {
      a(paramInt1, paramInt2, paramInt3, paramInt4, bool, i);
      jdField_a_of_type_Int = i;
      return;
    }
  }
  
  public void setDrawFinishedListener(XListView.DrawFinishedListener paramDrawFinishedListener)
  {
    jdField_a_of_type_ComTencentWidgetXListView$DrawFinishedListener = paramDrawFinishedListener;
  }
  
  public void setMaxHeight(int paramInt)
  {
    b = paramInt;
    if (b < getMeasuredHeight()) {
      requestLayout();
    }
  }
  
  public void setMotionEventInterceptor(XListView.MotionEventInterceptor paramMotionEventInterceptor)
  {
    jdField_a_of_type_ComTencentWidgetXListView$MotionEventInterceptor = paramMotionEventInterceptor;
  }
  
  public void setOnSizeChangeListener(OnSizeChangeListener paramOnSizeChangeListener)
  {
    jdField_a_of_type_ComTencentWidgetOnSizeChangeListener = paramOnSizeChangeListener;
  }
  
  public void setOverScrollDistance(int paramInt)
  {
    a_ = paramInt;
  }
}
